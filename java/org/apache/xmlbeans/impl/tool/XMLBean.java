package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.taskdefs.Jar;
import org.apache.tools.ant.taskdefs.Javac;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.util.ExceptionUtil;

/* loaded from: classes.dex */
public class XMLBean extends MatchingTask {
    private static final String JAVA = ".java";
    private static final String WSDL = ".wsdl";
    private static final String XSD = ".xsd";
    private static final String XSDCONFIG = ".xsdconfig";
    private String catalog;
    private File classgendir;
    private Path classpath;
    private String compiler;
    private boolean debug;
    private String debugLevel;
    private File destfile;
    private boolean download;
    private String forkedExecutable;
    private Set<String> mdefnamespaces;
    private String memoryInitialSize;
    private String memoryMaximumSize;
    private boolean noSrcRegen;
    private boolean noann;
    private boolean nopvr;
    private boolean noupa;
    private boolean novdoc;
    private boolean optimize;
    private String partialMethods;
    private boolean quiet;
    private String repackage;
    private File schema;
    private File srcgendir;
    private boolean srconly;
    private String typesystemname;
    private boolean verbose;
    private final List<FileSet> schemas = new ArrayList();
    private boolean noext = false;
    private boolean failonerror = true;
    private boolean fork = true;
    private boolean includeAntRuntime = true;
    private boolean includeJavaRuntime = false;
    private boolean nowarn = false;
    private final List<Extension> extensions = new ArrayList();
    private final Map<String, Set<File>> _extRouter = new HashMap(5);
    private String source = null;

    public class ErrorLogger extends AbstractCollection<XmlError> {
        private final URI _baseURI;
        private final boolean _noisy;

        public ErrorLogger(boolean z) {
            this._noisy = z;
            this._baseURI = XMLBean.uriFromFile(XMLBean.this.getProject().getBaseDir());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<XmlError> iterator() {
            return Collections.emptyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(XmlError xmlError) {
            if (xmlError.getSeverity() == 0) {
                XMLBean.this.log(xmlError.toString(this._baseURI), 0);
            } else if (xmlError.getSeverity() == 1) {
                XMLBean.this.log(xmlError.toString(this._baseURI), 1);
            } else if (this._noisy) {
                XMLBean.this.log(xmlError.toString(this._baseURI), 2);
            }
            return false;
        }
    }

    private void processPaths(String[] strArr, File file) {
        for (String str : strArr) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf > -1) {
                Set<File> set = this._extRouter.get(str.substring(iLastIndexOf).toLowerCase(Locale.ROOT));
                if (set != null) {
                    set.add(new File(file, str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URI uriFromFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalFile().toURI();
        } catch (IOException unused) {
            return file.getAbsoluteFile().toURI();
        }
    }

    public void addFileset(FileSet fileSet) {
        this.schemas.add(fileSet);
    }

    public Path createClasspath() {
        if (this.classpath == null) {
            this.classpath = new Path(getProject());
        }
        return this.classpath.createPath();
    }

    public Extension createExtension() {
        Extension extension = new Extension();
        this.extensions.add(extension);
        return extension;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.tools.ant.BuildException */
    public void execute() throws BuildException {
        boolean zCompile;
        if (this.schemas.isEmpty() && this.schema == null && this.fileset.getDir(getProject()) == null) {
            if (this.failonerror) {
                throw new BuildException("The 'schema' or 'dir' attribute or a nested fileset is required.");
            }
            log("The 'schema' or 'dir' attribute or a nested fileset is required.", 0);
            return;
        }
        this._extRouter.put(XSD, new HashSet());
        this._extRouter.put(WSDL, new HashSet());
        this._extRouter.put(JAVA, new HashSet());
        this._extRouter.put(XSDCONFIG, new HashSet());
        File parentFile = this.schema;
        if (parentFile != null) {
            if (parentFile.isDirectory()) {
                DirectoryScanner directoryScanner = getDirectoryScanner(this.schema);
                processPaths(directoryScanner.getIncludedFiles(), directoryScanner.getBasedir());
            } else {
                parentFile = this.schema.getParentFile();
                processPaths(new String[]{this.schema.getName()}, parentFile);
            }
        }
        if (this.fileset.getDir(getProject()) != null) {
            this.schemas.add(this.fileset);
        }
        Iterator<FileSet> it = this.schemas.iterator();
        while (it.hasNext()) {
            DirectoryScanner directoryScanner2 = it.next().getDirectoryScanner(getProject());
            processPaths(directoryScanner2.getIncludedFiles(), directoryScanner2.getBasedir());
        }
        Set<File> set = this._extRouter.get(XSD);
        Set<File> set2 = this._extRouter.get(WSDL);
        if (set.isEmpty() && set2.isEmpty()) {
            log("Could not find any xsd or wsdl files to process.", 1);
            return;
        }
        Set<File> set3 = this._extRouter.get(JAVA);
        Set<File> set4 = this._extRouter.get(XSDCONFIG);
        if (this.srcgendir == null && this.srconly) {
            this.srcgendir = this.classgendir;
        }
        if (this.destfile == null && this.classgendir == null && !this.srconly) {
            this.destfile = new File("xmltypes.jar");
        }
        if (this.verbose) {
            this.quiet = false;
        }
        File[] fileArr = (File[]) set.toArray(new File[0]);
        File[] fileArr2 = (File[]) set2.toArray(new File[0]);
        File[] fileArr3 = (File[]) set3.toArray(new File[0]);
        File[] fileArr4 = (File[]) set4.toArray(new File[0]);
        ErrorLogger errorLogger = new ErrorLogger(this.verbose);
        try {
            try {
                File fileCreateTempDir = (this.srcgendir == null || this.classgendir == null) ? SchemaCodeGenerator.createTempDir() : null;
                if (this.srcgendir == null) {
                    this.srcgendir = IOUtil.createDir(fileCreateTempDir, "src");
                }
                if (this.classgendir == null) {
                    this.classgendir = IOUtil.createDir(fileCreateTempDir, "classes");
                }
                if (this.classpath == null) {
                    Path path = new Path(getProject());
                    this.classpath = path;
                    path.concatSystemClasspath();
                }
                this.classpath.createPathElement().setLocation(this.classgendir);
                String[] list = this.classpath.list();
                File[] fileArr5 = new File[list.length];
                for (int i2 = 0; i2 < list.length; i2++) {
                    fileArr5[i2] = new File(list[i2]);
                }
                Parameters parameters = new Parameters();
                parameters.setBaseDir(parentFile);
                parameters.setXsdFiles(fileArr);
                parameters.setWsdlFiles(fileArr2);
                parameters.setJavaFiles(fileArr3);
                parameters.setConfigFiles(fileArr4);
                parameters.setClasspath(fileArr5);
                parameters.setName(this.typesystemname);
                parameters.setSrcDir(this.srcgendir);
                parameters.setClassesDir(this.classgendir);
                parameters.setNojavac(true);
                parameters.setDebug(this.debug);
                parameters.setVerbose(this.verbose);
                parameters.setQuiet(this.quiet);
                parameters.setDownload(this.download);
                parameters.setExtensions(this.extensions);
                parameters.setErrorListener(errorLogger);
                parameters.setCatalogFile(this.catalog);
                parameters.setIncrementalSrcGen(this.noSrcRegen);
                parameters.setMdefNamespaces(this.mdefnamespaces);
                parameters.setNoUpa(this.noupa);
                parameters.setNoPvr(this.nopvr);
                parameters.setNoAnn(this.noann);
                parameters.setNoVDoc(this.novdoc);
                parameters.setNoExt(this.noext);
                parameters.setRepackage(this.repackage);
                parameters.setPartialMethods(SchemaCompiler.parsePartialMethods(this.partialMethods));
                zCompile = SchemaCompiler.compile(parameters);
                if (zCompile) {
                    try {
                        if (!this.srconly) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Javac javac = new Javac();
                            javac.setProject(getProject());
                            javac.setTaskName(getTaskName());
                            javac.setClasspath(this.classpath);
                            String str = this.compiler;
                            if (str != null) {
                                javac.setCompiler(str);
                            }
                            javac.setDebug(this.debug);
                            String str2 = this.debugLevel;
                            if (str2 != null) {
                                javac.setDebugLevel(str2);
                            }
                            javac.setDestdir(this.classgendir);
                            javac.setExecutable(this.forkedExecutable);
                            javac.setFailonerror(this.failonerror);
                            javac.setFork(this.fork);
                            javac.setSource("1.8");
                            javac.setTarget("1.8");
                            javac.setIncludeantruntime(this.includeAntRuntime);
                            javac.setIncludejavaruntime(this.includeJavaRuntime);
                            javac.setNowarn(this.nowarn);
                            javac.setSrcdir(new Path(getProject(), this.srcgendir.getAbsolutePath()));
                            String str3 = this.memoryInitialSize;
                            if (str3 != null) {
                                javac.setMemoryInitialSize(str3);
                            }
                            String str4 = this.memoryMaximumSize;
                            if (str4 != null) {
                                javac.setMemoryMaximumSize(str4);
                            }
                            javac.setOptimize(this.optimize);
                            javac.setVerbose(this.verbose);
                            javac.execute();
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            if (!this.quiet) {
                                log("Time to compile code: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0d) + " seconds");
                            }
                            if (this.destfile != null) {
                                Jar jar = new Jar();
                                jar.setProject(getProject());
                                jar.setTaskName(getTaskName());
                                jar.setBasedir(this.classgendir);
                                jar.setDestFile(this.destfile);
                                jar.execute();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if ((th instanceof InterruptedException) || this.failonerror) {
                            throw new BuildException(th);
                        }
                        if (ExceptionUtil.isFatal(th)) {
                            ExceptionUtil.rethrow(th);
                        }
                        log("Exception while building schemas: " + th.getMessage(), 0);
                        StringWriter stringWriter = new StringWriter();
                        th.printStackTrace(new PrintWriter(stringWriter));
                        log(stringWriter.toString(), 3);
                        if (!zCompile) {
                            return;
                        }
                    }
                }
                if (fileCreateTempDir != null) {
                    SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
                }
            } catch (BuildException e) {
                throw e;
            }
        } catch (Throwable th2) {
            th = th2;
            zCompile = false;
        }
        if (!zCompile && this.failonerror) {
            throw new BuildException();
        }
    }

    public String getCatalog() {
        return this.catalog;
    }

    public File getClassgendir() {
        return this.classgendir;
    }

    public Path getClasspath() {
        return this.classpath;
    }

    public String getDebugLevel() {
        return this.debugLevel;
    }

    public File getDestfile() {
        return this.destfile;
    }

    public String getExecutable() {
        return this.forkedExecutable;
    }

    public String getIgnoreDuplicatesInNamespaces() {
        Set<String> set = this.mdefnamespaces;
        if (set == null) {
            return null;
        }
        return defpackage.g.a(",", set);
    }

    public String getMemoryInitialSize() {
        return this.memoryInitialSize;
    }

    public String getMemoryMaximumSize() {
        return this.memoryMaximumSize;
    }

    public boolean getOptimize() {
        return this.optimize;
    }

    public String getPartialMethods() {
        return this.partialMethods;
    }

    public String getRepackage() {
        return this.repackage;
    }

    public File getSchema() {
        return this.schema;
    }

    public File getSrcgendir() {
        return this.srcgendir;
    }

    public String getTypesystemname() {
        return this.typesystemname;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isDownload() {
        return this.download;
    }

    public boolean isFailonerror() {
        return this.failonerror;
    }

    public boolean isIncludeAntRuntime() {
        return this.includeAntRuntime;
    }

    public boolean isIncludeJavaRuntime() {
        return this.includeJavaRuntime;
    }

    public boolean isNoAnnotations() {
        return this.noann;
    }

    public boolean isNoExt() {
        return this.noext;
    }

    public boolean isNoPvr() {
        return this.nopvr;
    }

    public boolean isNoSrcRegen() {
        return this.noSrcRegen;
    }

    public boolean isNoUpa() {
        return this.noupa;
    }

    public boolean isNoValidateDoc() {
        return this.novdoc;
    }

    public boolean isNowarn() {
        return this.nowarn;
    }

    public boolean isQuiet() {
        return this.quiet;
    }

    public boolean isSrconly() {
        return this.srconly;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public void setCatalog(String str) {
        this.catalog = str;
    }

    public void setClassgendir(File file) {
        this.classgendir = file;
    }

    public void setClasspath(Path path) {
        Path path2 = this.classpath;
        if (path2 != null) {
            path2.append(path);
        } else {
            this.classpath = path;
        }
    }

    public void setClasspathRef(Reference reference) {
        if (this.classpath == null) {
            this.classpath = new Path(getProject());
        }
        this.classpath.createPath().setRefid(reference);
    }

    public void setCompiler(String str) {
        this.compiler = str;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setDebugLevel(String str) {
        this.debugLevel = str;
    }

    public void setDestfile(File file) {
        this.destfile = file;
    }

    public void setDownload(boolean z) {
        this.download = z;
    }

    public void setExecutable(String str) {
        this.forkedExecutable = str;
    }

    public void setFailonerror(boolean z) {
        this.failonerror = z;
    }

    public void setFork(boolean z) {
        this.fork = z;
    }

    public void setIgnoreDuplicatesInNamespaces(String str) {
        this.mdefnamespaces = new HashSet();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.mdefnamespaces.add(stringTokenizer.nextToken().trim());
        }
    }

    public void setIncludeAntRuntime(boolean z) {
        this.includeAntRuntime = z;
    }

    public void setIncludeJavaRuntime(boolean z) {
        this.includeJavaRuntime = z;
    }

    public void setMemoryInitialSize(String str) {
        this.memoryInitialSize = str;
    }

    public void setMemoryMaximumSize(String str) {
        this.memoryMaximumSize = str;
    }

    public void setNoAnnotations(boolean z) {
        this.noann = z;
    }

    public void setNoExt(boolean z) {
        this.noext = z;
    }

    public void setNoPvr(boolean z) {
        this.nopvr = z;
    }

    public void setNoSrcRegen(boolean z) {
        this.noSrcRegen = z;
    }

    public void setNoUpa(boolean z) {
        this.noupa = z;
    }

    public void setNoValidateDoc(boolean z) {
        this.novdoc = z;
    }

    public void setNowarn(boolean z) {
        this.nowarn = z;
    }

    public void setOptimize(boolean z) {
        this.optimize = z;
    }

    public void setPartialMethods(String str) {
        this.partialMethods = str;
    }

    public void setQuiet(boolean z) {
        this.quiet = z;
    }

    public void setRepackage(String str) {
        this.repackage = str;
    }

    public void setSchema(File file) {
        this.schema = file;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSrcgendir(File file) {
        this.srcgendir = file;
    }

    public void setSrconly(boolean z) {
        this.srconly = z;
    }

    public void setTypesystemname(String str) {
        this.typesystemname = str;
    }

    public void setVerbose(boolean z) {
        this.verbose = z;
    }
}
