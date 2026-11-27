package org.apache.xmlbeans.impl.tool;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.JarHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.XmlErrorPrinter;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.config.BindingConfigImpl;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.schema.PathResourceLoader;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.tool.Extension;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* loaded from: classes.dex */
public class SchemaCompiler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMPATIBILITY_CONFIG_URI = "http://www.bea.com/2002/09/xbean/config";
    private static final String CONFIG_URI = "http://xml.apache.org/xmlbeans/2004/02/xbean/config";
    private static final Map<String, String> MAP_COMPATIBILITY_CONFIG_URIS = Collections.singletonMap(COMPATIBILITY_CONFIG_URI, CONFIG_URI);

    private static void addSchema(String str, SchemaDocument schemaDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List<SchemaDocument.Schema> list) {
        StscState.addInfo(xmlErrorWatcher, "Loading schema file " + str);
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        if (schemaDocument.validate(errorListener)) {
            list.add(schemaDocument.getSchema());
        }
    }

    private static void addWsdlSchemas(String str, DefinitionsDocument definitionsDocument, XmlErrorWatcher xmlErrorWatcher, boolean z, List<SchemaDocument.Schema> list) {
        if (wsdlContainsEncoded(definitionsDocument)) {
            StscState.addWarning(xmlErrorWatcher, "The WSDL " + str + " uses SOAP encoding. SOAP encoding is not compatible with literal XML Schema.", 60, definitionsDocument);
        }
        StscState.addInfo(xmlErrorWatcher, "Loading wsdl file " + str);
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        int i2 = 0;
        for (XmlObject xmlObject : definitionsDocument.getDefinitions().getTypesArray()) {
            XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace xs=\"http://www.w3.org/2001/XMLSchema\" xs:schema");
            if (xmlObjectArrSelectPath.length == 0) {
                StscState.addWarning(xmlErrorWatcher, "The WSDL " + str + " did not have any schema documents in namespace 'http://www.w3.org/2001/XMLSchema'", 60, definitionsDocument);
            } else {
                for (XmlObject xmlObject2 : xmlObjectArrSelectPath) {
                    if (xmlObject2.validate(errorListener)) {
                        i2++;
                        list.add((SchemaDocument.Schema) xmlObject2);
                    }
                }
            }
        }
        StscState.addInfo(xmlErrorWatcher, "Processing " + i2 + " schema(s) in " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x02bf A[PHI: r0
      0x02bf: PHI (r0v5 boolean) = (r0v4 boolean), (r0v4 boolean), (r0v13 boolean), (r0v13 boolean) binds: [B:23:0x0198, B:24:0x019a, B:53:0x0273, B:55:0x0277] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean compile(Parameters parameters) throws IOException {
        boolean z;
        boolean z2;
        String str;
        File file;
        File baseDir = parameters.getBaseDir();
        File[] xsdFiles = parameters.getXsdFiles();
        File[] wsdlFiles = parameters.getWsdlFiles();
        URL[] urlFiles = parameters.getUrlFiles();
        File[] javaFiles = parameters.getJavaFiles();
        File[] configFiles = parameters.getConfigFiles();
        File[] classpath = parameters.getClasspath();
        File outputJar = parameters.getOutputJar();
        String name = parameters.getName();
        File srcDir = parameters.getSrcDir();
        File classesDir = parameters.getClassesDir();
        String compiler = parameters.getCompiler();
        String memoryInitialSize = parameters.getMemoryInitialSize();
        String memoryMaximumSize = parameters.getMemoryMaximumSize();
        boolean zIsNojavac = parameters.isNojavac();
        boolean zIsDebug = parameters.isDebug();
        boolean zIsVerbose = parameters.isVerbose();
        boolean zIsQuiet = parameters.isQuiet();
        boolean zIsDownload = parameters.isDownload();
        boolean zIsNoUpa = parameters.isNoUpa();
        boolean zIsNoPvr = parameters.isNoPvr();
        boolean zIsNoAnn = parameters.isNoAnn();
        boolean zIsNoVDoc = parameters.isNoVDoc();
        boolean zIsNoExt = parameters.isNoExt();
        boolean zIsIncrementalSrcGen = parameters.isIncrementalSrcGen();
        boolean zIsCopyAnn = parameters.isCopyAnn();
        String sourceCodeEncoding = parameters.getSourceCodeEncoding();
        Collection<XmlError> errorListener = parameters.getErrorListener();
        Set<XmlOptions.BeanMethod> partialMethods = parameters.getPartialMethods();
        String repackage = parameters.getRepackage();
        if (repackage != null) {
            SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
            z = zIsCopyAnn;
            z2 = zIsNoAnn;
            str = repackage;
            SchemaTypeSystemImpl.METADATA_PACKAGE_GEN = new Repackager(repackage).repackage(new StringBuffer(SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD)).toString();
            System.out.println("SchemaCompiler  Metadata LOAD:" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + " GEN:" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN);
        } else {
            z = zIsCopyAnn;
            z2 = zIsNoAnn;
            str = repackage;
        }
        SchemaCodePrinter schemaCodePrinter = parameters.getSchemaCodePrinter();
        List<Extension> extensions = parameters.getExtensions();
        Set<String> mdefNamespaces = parameters.getMdefNamespaces();
        EntityResolver entityResolverResolverForCatalog = parameters.getEntityResolver() == null ? ResolverUtil.resolverForCatalog(parameters.getCatalogFile()) : parameters.getEntityResolver();
        if (srcDir == null || classesDir == null) {
            throw new IllegalArgumentException("src and class gen directories may not be null.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (baseDir == null) {
            baseDir = new File(SystemProperties.getProperty("user.dir"));
        }
        HashMap map = new HashMap();
        PathResourceLoader pathResourceLoader = classpath != null ? new PathResourceLoader(classpath) : null;
        File fileCreateDir = IOUtil.createDir(classesDir, SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/src");
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(errorListener);
        boolean z3 = z;
        boolean z4 = z2;
        String str2 = str;
        SchemaTypeSystem schemaTypeSystemLoadTypeSystem = loadTypeSystem(name, xsdFiles, wsdlFiles, urlFiles, configFiles, javaFiles, pathResourceLoader, zIsDownload, zIsNoUpa, zIsNoPvr, z4, zIsNoVDoc, zIsNoExt, sourceCodeEncoding, mdefNamespaces, baseDir, map, xmlErrorWatcher, fileCreateDir, entityResolverResolverForCatalog, classpath);
        boolean z5 = !xmlErrorWatcher.hasError();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!zIsQuiet) {
            System.out.println("Time to build schema type system: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0d) + " seconds");
        }
        if (!z5 || schemaTypeSystemLoadTypeSystem == null) {
            file = classesDir;
        } else {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            FilerImpl filerImpl = new FilerImpl(classesDir, srcDir, str2 == null ? null : new Repackager(str2), zIsVerbose, zIsIncrementalSrcGen);
            XmlOptions xmlOptions = new XmlOptions();
            if (schemaCodePrinter != null) {
                xmlOptions.setSchemaCodePrinter(schemaCodePrinter);
            }
            xmlOptions.setCompilePartialMethod(partialMethods);
            xmlOptions.setCompileNoAnnotations(z4);
            xmlOptions.setCompileAnnotationAsJavadoc(z3);
            xmlOptions.setCharacterEncoding(sourceCodeEncoding);
            schemaTypeSystemLoadTypeSystem.save(filerImpl);
            boolean zGenerateTypes = SchemaTypeSystemCompiler.generateTypes(schemaTypeSystemLoadTypeSystem, filerImpl, xmlOptions);
            if (zIsIncrementalSrcGen) {
                SchemaCodeGenerator.deleteObsoleteFiles(srcDir, srcDir, new HashSet(filerImpl.getSourceFiles()));
            }
            if (zGenerateTypes) {
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                if (!zIsQuiet) {
                    System.out.println("Time to generate code: " + ((jCurrentTimeMillis4 - jCurrentTimeMillis3) / 1000.0d) + " seconds");
                }
            }
            if (!zGenerateTypes || zIsNojavac) {
                file = classesDir;
                z5 = zGenerateTypes;
            } else {
                long jCurrentTimeMillis5 = System.currentTimeMillis();
                List<File> sourceFiles = filerImpl.getSourceFiles();
                if (javaFiles != null) {
                    sourceFiles.addAll(Arrays.asList(javaFiles));
                }
                z5 = !CodeGenUtil.externalCompile(sourceFiles, classesDir, classpath, zIsDebug, compiler, null, memoryInitialSize, memoryMaximumSize, zIsQuiet, zIsVerbose, sourceCodeEncoding) ? false : zGenerateTypes;
                long jCurrentTimeMillis6 = System.currentTimeMillis();
                if (z5 && !parameters.isQuiet()) {
                    System.out.println("Time to compile code: " + ((jCurrentTimeMillis6 - jCurrentTimeMillis5) / 1000.0d) + " seconds");
                }
                if (z5 && outputJar != null) {
                    try {
                        file = classesDir;
                    } catch (IOException e) {
                        e = e;
                        file = classesDir;
                    }
                    try {
                        new JarHelper().jarDir(file, outputJar);
                    } catch (IOException e2) {
                        e = e2;
                        System.err.println("IO Error " + e);
                        z5 = false;
                        if (z5) {
                            System.out.println("Compiled types to: " + outputJar);
                        }
                        if (z5) {
                            runExtensions(extensions, schemaTypeSystemLoadTypeSystem, file);
                        }
                        if (pathResourceLoader != null) {
                        }
                        return z5;
                    }
                    if (z5 && !parameters.isQuiet()) {
                        System.out.println("Compiled types to: " + outputJar);
                    }
                }
            }
        }
        if (!z5 || zIsQuiet) {
            runExtensions(extensions, schemaTypeSystemLoadTypeSystem, file);
        } else {
            System.out.println("BUILD FAILED");
        }
        if (pathResourceLoader != null) {
            pathResourceLoader.close();
        }
        return z5;
    }

    private static SchemaTypeSystem loadTypeSystem(String str, File[] fileArr, File[] fileArr2, URL[] urlArr, File[] fileArr3, File[] fileArr4, ResourceLoader resourceLoader, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str2, Set<String> set, File file, Map<String, String> map, Collection<XmlError> collection, File file2, EntityResolver entityResolver, File[] fileArr5) {
        String str3;
        File[] fileArr6 = fileArr;
        File[] fileArr7 = fileArr2;
        String str4 = "xsd config";
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
        try {
            StscState.start().setErrorListener(xmlErrorWatcher);
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            if (fileArr6 != null) {
                int length = fileArr6.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = length;
                    File file3 = fileArr6[i2];
                    try {
                        XmlOptions xmlOptions = new XmlOptions();
                        xmlOptions.setLoadLineNumbers();
                        xmlOptions.setLoadMessageDigest();
                        xmlOptions.setEntityResolver(entityResolver);
                        XmlObject xmlObject = schemaTypeLoaderTypeLoaderForClassLoader.parse(file3, (SchemaType) null, xmlOptions);
                        if (xmlObject instanceof SchemaDocument) {
                            str3 = str4;
                            addSchema(file3.toString(), (SchemaDocument) xmlObject, xmlErrorWatcher, z5, arrayList);
                        } else {
                            str3 = str4;
                            try {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{file3, "schema"}, xmlObject);
                            } catch (XmlException e) {
                                e = e;
                                xmlErrorWatcher.add(e.getError());
                                i2++;
                                fileArr6 = fileArr;
                                length = i3;
                                str4 = str3;
                            } catch (Exception e2) {
                                e = e2;
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"xsd", file3, e.getMessage()}, file3);
                                i2++;
                                fileArr6 = fileArr;
                                length = i3;
                                str4 = str3;
                            }
                        }
                    } catch (XmlException e3) {
                        e = e3;
                        str3 = str4;
                    } catch (Exception e4) {
                        e = e4;
                        str3 = str4;
                    }
                    i2++;
                    fileArr6 = fileArr;
                    length = i3;
                    str4 = str3;
                }
            }
            String str5 = str4;
            if (fileArr7 != null) {
                int length2 = fileArr7.length;
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = length2;
                    File file4 = fileArr7[i4];
                    try {
                        try {
                            XmlOptions xmlOptions2 = new XmlOptions();
                            xmlOptions2.setLoadLineNumbers();
                            xmlOptions2.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                            xmlOptions2.setEntityResolver(entityResolver);
                            XmlObject xmlObject2 = schemaTypeLoaderTypeLoaderForClassLoader.parse(file4, (SchemaType) null, xmlOptions2);
                            if (xmlObject2 instanceof DefinitionsDocument) {
                                addWsdlSchemas(file4.toString(), (DefinitionsDocument) xmlObject2, xmlErrorWatcher, z5, arrayList);
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{file4, "wsdl"}, xmlObject2);
                            }
                        } catch (Exception e5) {
                            StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"wsdl", file4, e5.getMessage()}, file4);
                        }
                    } catch (XmlException e6) {
                        xmlErrorWatcher.add(e6.getError());
                    }
                    i4++;
                    fileArr7 = fileArr2;
                    length2 = i5;
                }
            }
            if (urlArr != null) {
                for (URL url : urlArr) {
                    try {
                        try {
                            XmlOptions xmlOptions3 = new XmlOptions();
                            xmlOptions3.setLoadLineNumbers();
                            xmlOptions3.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                            xmlOptions3.setEntityResolver(entityResolver);
                            XmlObject xmlObject3 = schemaTypeLoaderTypeLoaderForClassLoader.parse(url, (SchemaType) null, xmlOptions3);
                            if (xmlObject3 instanceof DefinitionsDocument) {
                                addWsdlSchemas(url.toString(), (DefinitionsDocument) xmlObject3, xmlErrorWatcher, z5, arrayList);
                            } else if (xmlObject3 instanceof SchemaDocument) {
                                addSchema(url.toString(), (SchemaDocument) xmlObject3, xmlErrorWatcher, z5, arrayList);
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{url, "wsdl or schema"}, xmlObject3);
                            }
                        } catch (Exception e7) {
                            StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{SocialConstants.PARAM_URL, url, e7.getMessage()}, url);
                        }
                    } catch (XmlException e8) {
                        xmlErrorWatcher.add(e8.getError());
                    }
                }
            }
            SchemaDocument.Schema[] schemaArr = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[0]);
            ArrayList arrayList2 = new ArrayList();
            if (fileArr3 != null) {
                if (z6) {
                    System.out.println("Pre/Post and Interface extensions will be ignored.");
                }
                for (File file5 : fileArr3) {
                    try {
                        try {
                            XmlOptions xmlOptions4 = new XmlOptions();
                            xmlOptions4.setLoadLineNumbers();
                            xmlOptions4.setEntityResolver(entityResolver);
                            xmlOptions4.setLoadSubstituteNamespaces(MAP_COMPATIBILITY_CONFIG_URIS);
                            XmlObject xmlObject4 = schemaTypeLoaderTypeLoaderForClassLoader.parse(file5, (SchemaType) null, xmlOptions4);
                            if (xmlObject4 instanceof ConfigDocument) {
                                StscState.addInfo(xmlErrorWatcher, "Loading config file " + file5);
                                if (xmlObject4.validate(new XmlOptions().setErrorListener(xmlErrorWatcher))) {
                                    ConfigDocument.Config config = ((ConfigDocument) xmlObject4).getConfig();
                                    arrayList2.add(config);
                                    if (z6) {
                                        config.setExtensionArray(new Extensionconfig[0]);
                                    }
                                }
                            } else {
                                try {
                                    Object[] objArr = new Object[2];
                                    objArr[0] = file5;
                                    objArr[1] = str5;
                                    StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, objArr, xmlObject4);
                                } catch (XmlException e9) {
                                    e = e9;
                                    xmlErrorWatcher.add(e.getError());
                                }
                            }
                        } catch (XmlException e10) {
                            e = e10;
                        }
                    } catch (Exception e11) {
                        StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{str5, file5, e11.getMessage()}, file5);
                    }
                }
            }
            ConfigDocument.Config[] configArr = (ConfigDocument.Config[]) arrayList2.toArray(new ConfigDocument.Config[0]);
            SchemaTypeLoader schemaTypeLoaderBuild = SchemaTypeLoaderImpl.build(null, resourceLoader, null);
            URI uri = file != null ? file.toURI() : null;
            XmlOptions xmlOptions5 = new XmlOptions();
            if (z) {
                xmlOptions5.setCompileDownloadUrls();
            }
            if (z2) {
                xmlOptions5.setCompileNoUpaRule();
            }
            if (z3) {
                xmlOptions5.setCompileNoPvrRule();
            }
            if (z4) {
                xmlOptions5.setCompileNoAnnotations();
            }
            if (str2 != null) {
                xmlOptions5.setCharacterEncoding(str2);
            }
            if (set != null) {
                xmlOptions5.setCompileMdefNamespaces(set);
            }
            xmlOptions5.setCompileNoValidation();
            xmlOptions5.setEntityResolver(entityResolver);
            SchemaTypeSystemCompiler.Parameters parameters = new SchemaTypeSystemCompiler.Parameters();
            parameters.setName(str);
            parameters.setSchemas(schemaArr);
            parameters.setConfig(BindingConfigImpl.forConfigDocuments(configArr, fileArr4, fileArr5));
            parameters.setLinkTo(schemaTypeLoaderBuild);
            parameters.setOptions(xmlOptions5);
            parameters.setErrorListener(xmlErrorWatcher);
            parameters.setJavaize(true);
            parameters.setBaseURI(uri);
            parameters.setSourcesToCopyMap(map);
            parameters.setSchemasDir(file2);
            return SchemaTypeSystemCompiler.compile(parameters);
        } finally {
            StscState.end();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0302 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0309 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0311 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v65, types: [java.util.Set] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void main(String[] strArr) throws IOException {
        SchemaCodePrinter schemaCodePrinter;
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        String str4;
        boolean z4;
        SchemaCodePrinter schemaCodePrinter2;
        HashSet hashSet;
        String str5;
        String str6;
        boolean z5;
        boolean z6;
        String opt;
        String str7;
        File fileCreateDir;
        File file;
        ArrayList arrayList;
        boolean z7;
        File fileCreateTempDir;
        String opt2;
        File[] fileArrSystemClasspath;
        File file2;
        File[] fileArrFilesEndingWith;
        File[] fileArrFilesEndingWith2;
        URL[] uRLs;
        File baseDir;
        URI uri;
        String str8;
        boolean zCompile;
        StringTokenizer stringTokenizer;
        StringTokenizer stringTokenizer2;
        Extension extension;
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
            return;
        }
        HashSet hashSet2 = new HashSet();
        hashSet2.add("h");
        hashSet2.add("help");
        hashSet2.add("usage");
        hashSet2.add("license");
        hashSet2.add("quiet");
        hashSet2.add("verbose");
        hashSet2.add("version");
        hashSet2.add("dl");
        hashSet2.add("noupa");
        hashSet2.add("nopvr");
        hashSet2.add("noann");
        hashSet2.add("novdoc");
        hashSet2.add("noext");
        hashSet2.add("srconly");
        hashSet2.add("debug");
        HashSet hashSet3 = new HashSet();
        hashSet3.add("out");
        hashSet3.add("name");
        hashSet3.add("src");
        hashSet3.add("d");
        hashSet3.add("cp");
        hashSet3.add("compiler");
        hashSet3.add("jar");
        hashSet3.add("ms");
        hashSet3.add("mx");
        hashSet3.add("repackage");
        hashSet3.add("schemaCodePrinter");
        hashSet3.add("extension");
        hashSet3.add("extensionParms");
        hashSet3.add("allowmdef");
        hashSet3.add("catalog");
        hashSet3.add("partialMethods");
        hashSet3.add("copyann");
        hashSet3.add("sourcecodeencoding");
        CommandLine commandLine = new CommandLine(strArr, hashSet2, hashSet3);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str9 : badOpts) {
                System.out.println("Unrecognized option: " + str9);
            }
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        boolean z8 = commandLine.getOpt("verbose") != null;
        boolean z9 = z8 ? false : commandLine.getOpt("quiet") != null;
        if (z8) {
            CommandLine.printVersion();
        }
        String opt3 = commandLine.getOpt("out");
        String opt4 = commandLine.getOpt("repackage");
        String opt5 = commandLine.getOpt("schemaCodePrinter");
        if (opt5 != null) {
            try {
                schemaCodePrinter = (SchemaCodePrinter) Class.forName(opt5).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
                System.err.println("Failed to load SchemaCodePrinter class " + opt5 + "; proceeding with default printer");
            }
        } else {
            schemaCodePrinter = null;
        }
        String opt6 = commandLine.getOpt("name");
        boolean z10 = commandLine.getOpt("dl") != null;
        boolean z11 = commandLine.getOpt("noupa") != null;
        boolean z12 = commandLine.getOpt("nopvr") != null;
        if (commandLine.getOpt("noann") != null) {
            str = "novdoc";
            z = true;
        } else {
            str = "novdoc";
            z = false;
        }
        if (commandLine.getOpt(str) != null) {
            str2 = "noext";
            z2 = true;
        } else {
            str2 = "noext";
            z2 = false;
        }
        if (commandLine.getOpt(str2) != null) {
            str3 = "srconly";
            z3 = true;
        } else {
            str3 = "srconly";
            z3 = false;
        }
        if (commandLine.getOpt(str3) != null) {
            str4 = "debug";
            z4 = true;
        } else {
            str4 = "debug";
            z4 = false;
        }
        boolean z13 = commandLine.getOpt(str4) != null;
        boolean z14 = commandLine.getOpt("copyann") != null;
        String opt7 = commandLine.getOpt("sourcecodeencoding");
        String opt8 = commandLine.getOpt("allowmdef");
        if (opt8 == null) {
            hashSet = Collections.emptySet();
            schemaCodePrinter2 = schemaCodePrinter;
        } else {
            schemaCodePrinter2 = schemaCodePrinter;
            hashSet = new HashSet(Arrays.asList(XmlListImpl.split_list(opt8)));
        }
        ArrayList arrayList2 = new ArrayList();
        if (commandLine.getOpt("extension") != null) {
            str6 = opt4;
            try {
                extension = new Extension();
                str5 = opt7;
                try {
                    z6 = z3;
                    try {
                        z5 = z2;
                    } catch (ClassNotFoundException unused2) {
                        z5 = z2;
                    }
                } catch (ClassNotFoundException unused3) {
                    z5 = z2;
                    z6 = z3;
                    System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                    System.exit(1);
                    if (!arrayList2.isEmpty()) {
                        Extension extension2 = (Extension) arrayList2.get(0);
                        stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
                        while (stringTokenizer.hasMoreTokens()) {
                        }
                    }
                    opt = commandLine.getOpt("d");
                    if (opt != null) {
                    }
                    String opt9 = commandLine.getOpt(str7);
                    if (opt9 != null) {
                    }
                    if (z4) {
                        file = fileCreateDir;
                    }
                    if (file == null) {
                        try {
                            fileCreateTempDir = SchemaCodeGenerator.createTempDir();
                            arrayList = arrayList2;
                            z7 = z;
                        } catch (IOException e) {
                            PrintStream printStream = System.err;
                            arrayList = arrayList2;
                            StringBuilder sb = new StringBuilder();
                            z7 = z;
                            sb.append("Error creating temp dir ");
                            sb.append(e);
                            printStream.println(sb.toString());
                            System.exit(1);
                        }
                    }
                    if (opt3 == null) {
                    }
                    if (opt3 == null) {
                    }
                    if (file == null) {
                    }
                    if (fileCreateDir == null) {
                    }
                    opt2 = commandLine.getOpt("cp");
                    if (opt2 == null) {
                    }
                    String opt10 = commandLine.getOpt("compiler");
                    String opt11 = commandLine.getOpt("jar");
                    if (z8) {
                    }
                    String opt12 = commandLine.getOpt("ms");
                    String opt13 = commandLine.getOpt("mx");
                    file2 = fileCreateTempDir;
                    fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                    boolean z15 = z12;
                    fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
                    boolean z16 = z11;
                    File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".java");
                    boolean z17 = z10;
                    File[] fileArrFilesEndingWith4 = commandLine.filesEndingWith(".xsdconfig");
                    boolean z18 = z9;
                    uRLs = commandLine.getURLs();
                    boolean z19 = z4;
                    if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                    }
                    baseDir = commandLine.getBaseDir();
                    if (baseDir != null) {
                    }
                    XmlErrorPrinter xmlErrorPrinter = new XmlErrorPrinter(z8, uri);
                    String opt14 = commandLine.getOpt("catalog");
                    String opt15 = commandLine.getOpt("partialMethods");
                    Parameters parameters = new Parameters();
                    parameters.setBaseDir(baseDir);
                    parameters.setXsdFiles(fileArrFilesEndingWith);
                    parameters.setWsdlFiles(fileArrFilesEndingWith2);
                    parameters.setJavaFiles(fileArrFilesEndingWith3);
                    parameters.setConfigFiles(fileArrFilesEndingWith4);
                    parameters.setUrlFiles(uRLs);
                    parameters.setClasspath(fileArrSystemClasspath);
                    parameters.setOutputJar(file);
                    parameters.setName(opt6);
                    parameters.setSrcDir(file);
                    parameters.setClassesDir(fileCreateDir);
                    parameters.setCompiler(opt10);
                    parameters.setMemoryInitialSize(str8);
                    parameters.setMemoryMaximumSize(opt13);
                    parameters.setNojavac(z19);
                    parameters.setQuiet(z18);
                    parameters.setVerbose(z8);
                    parameters.setDownload(z17);
                    parameters.setNoUpa(z16);
                    parameters.setNoPvr(z15);
                    parameters.setNoAnn(z7);
                    parameters.setNoVDoc(z5);
                    parameters.setNoExt(z6);
                    parameters.setDebug(z13);
                    parameters.setSourceCodeEncoding(str5);
                    parameters.setErrorListener(xmlErrorPrinter);
                    parameters.setRepackage(str6);
                    parameters.setExtensions(arrayList);
                    parameters.setMdefNamespaces(hashSet);
                    parameters.setCatalogFile(opt14);
                    parameters.setSchemaCodePrinter(schemaCodePrinter2);
                    parameters.setPartialMethods(parsePartialMethods(opt15));
                    parameters.setCopyAnn(z14);
                    zCompile = compile(parameters);
                    if (file2 != null) {
                    }
                    if (!zCompile) {
                    }
                    System.exit(0);
                }
            } catch (ClassNotFoundException unused4) {
                str5 = opt7;
            }
            try {
                extension.setClassName(Class.forName(commandLine.getOpt("extension"), false, Thread.currentThread().getContextClassLoader()));
                arrayList2.add(extension);
            } catch (ClassNotFoundException unused5) {
                System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                System.exit(1);
                if (!arrayList2.isEmpty()) {
                }
                opt = commandLine.getOpt("d");
                if (opt != null) {
                }
                String opt92 = commandLine.getOpt(str7);
                if (opt92 != null) {
                }
                if (z4) {
                }
                if (file == null) {
                }
                if (opt3 == null) {
                }
                if (opt3 == null) {
                }
                if (file == null) {
                }
                if (fileCreateDir == null) {
                }
                opt2 = commandLine.getOpt("cp");
                if (opt2 == null) {
                }
                String opt102 = commandLine.getOpt("compiler");
                String opt112 = commandLine.getOpt("jar");
                if (z8) {
                }
                String opt122 = commandLine.getOpt("ms");
                String opt132 = commandLine.getOpt("mx");
                file2 = fileCreateTempDir;
                fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                boolean z152 = z12;
                fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
                boolean z162 = z11;
                File[] fileArrFilesEndingWith32 = commandLine.filesEndingWith(".java");
                boolean z172 = z10;
                File[] fileArrFilesEndingWith42 = commandLine.filesEndingWith(".xsdconfig");
                boolean z182 = z9;
                uRLs = commandLine.getURLs();
                boolean z192 = z4;
                if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                }
                baseDir = commandLine.getBaseDir();
                if (baseDir != null) {
                }
                XmlErrorPrinter xmlErrorPrinter2 = new XmlErrorPrinter(z8, uri);
                String opt142 = commandLine.getOpt("catalog");
                String opt152 = commandLine.getOpt("partialMethods");
                Parameters parameters2 = new Parameters();
                parameters2.setBaseDir(baseDir);
                parameters2.setXsdFiles(fileArrFilesEndingWith);
                parameters2.setWsdlFiles(fileArrFilesEndingWith2);
                parameters2.setJavaFiles(fileArrFilesEndingWith32);
                parameters2.setConfigFiles(fileArrFilesEndingWith42);
                parameters2.setUrlFiles(uRLs);
                parameters2.setClasspath(fileArrSystemClasspath);
                parameters2.setOutputJar(file);
                parameters2.setName(opt6);
                parameters2.setSrcDir(file);
                parameters2.setClassesDir(fileCreateDir);
                parameters2.setCompiler(opt102);
                parameters2.setMemoryInitialSize(str8);
                parameters2.setMemoryMaximumSize(opt132);
                parameters2.setNojavac(z192);
                parameters2.setQuiet(z182);
                parameters2.setVerbose(z8);
                parameters2.setDownload(z172);
                parameters2.setNoUpa(z162);
                parameters2.setNoPvr(z152);
                parameters2.setNoAnn(z7);
                parameters2.setNoVDoc(z5);
                parameters2.setNoExt(z6);
                parameters2.setDebug(z13);
                parameters2.setSourceCodeEncoding(str5);
                parameters2.setErrorListener(xmlErrorPrinter2);
                parameters2.setRepackage(str6);
                parameters2.setExtensions(arrayList);
                parameters2.setMdefNamespaces(hashSet);
                parameters2.setCatalogFile(opt142);
                parameters2.setSchemaCodePrinter(schemaCodePrinter2);
                parameters2.setPartialMethods(parsePartialMethods(opt152));
                parameters2.setCopyAnn(z14);
                zCompile = compile(parameters2);
                if (file2 != null) {
                }
                if (!zCompile) {
                }
                System.exit(0);
            }
        } else {
            str5 = opt7;
            str6 = opt4;
            z5 = z2;
            z6 = z3;
        }
        if (!arrayList2.isEmpty() && commandLine.getOpt("extensionParms") != null) {
            Extension extension22 = (Extension) arrayList2.get(0);
            stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf < 0) {
                    stringTokenizer2 = stringTokenizer;
                    System.err.println("extensionParms should be name=value;name=value");
                    System.exit(1);
                } else {
                    stringTokenizer2 = stringTokenizer;
                }
                String strSubstring = strNextToken.substring(0, iIndexOf);
                String strSubstring2 = strNextToken.substring(iIndexOf + 1);
                Extension.Param paramCreateParam = extension22.createParam();
                paramCreateParam.setName(strSubstring);
                paramCreateParam.setValue(strSubstring2);
                stringTokenizer = stringTokenizer2;
            }
        }
        opt = commandLine.getOpt("d");
        if (opt != null) {
            fileCreateDir = new File(opt);
            str7 = "src";
        } else {
            str7 = "src";
            fileCreateDir = null;
        }
        String opt922 = commandLine.getOpt(str7);
        file = opt922 != null ? new File(opt922) : null;
        if (z4 && opt922 == null && fileCreateDir != null) {
            file = fileCreateDir;
        }
        if (file == null || fileCreateDir == null) {
            fileCreateTempDir = SchemaCodeGenerator.createTempDir();
            arrayList = arrayList2;
            z7 = z;
            if (opt3 == null && fileCreateDir == null && !z4) {
                opt3 = "xmltypes.jar";
            }
            File file3 = opt3 == null ? new File(opt3) : null;
            if (file == null) {
                file = IOUtil.createDir(fileCreateTempDir, str7);
            }
            if (fileCreateDir == null) {
                fileCreateDir = IOUtil.createDir(fileCreateTempDir, "classes");
            }
            opt2 = commandLine.getOpt("cp");
            if (opt2 == null) {
                String[] strArrSplit = opt2.split(File.pathSeparator);
                ArrayList arrayList3 = new ArrayList();
                int length = strArrSplit.length;
                int i2 = 0;
                while (i2 < length) {
                    arrayList3.add(new File(strArrSplit[i2]));
                    i2++;
                    length = length;
                    strArrSplit = strArrSplit;
                }
                fileArrSystemClasspath = (File[]) arrayList3.toArray(new File[0]);
            } else {
                fileArrSystemClasspath = CodeGenUtil.systemClasspath();
            }
            String opt1022 = commandLine.getOpt("compiler");
            String opt1122 = commandLine.getOpt("jar");
            if (z8 && opt1122 != null) {
                System.out.println("The 'jar' option is no longer supported.");
            }
            String opt1222 = commandLine.getOpt("ms");
            String opt1322 = commandLine.getOpt("mx");
            file2 = fileCreateTempDir;
            fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
            boolean z1522 = z12;
            fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
            boolean z1622 = z11;
            File[] fileArrFilesEndingWith322 = commandLine.filesEndingWith(".java");
            boolean z1722 = z10;
            File[] fileArrFilesEndingWith422 = commandLine.filesEndingWith(".xsdconfig");
            boolean z1822 = z9;
            uRLs = commandLine.getURLs();
            boolean z1922 = z4;
            if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                System.out.println("Could not find any xsd or wsdl files to process.");
                System.exit(0);
            }
            baseDir = commandLine.getBaseDir();
            if (baseDir != null) {
                str8 = opt1222;
                uri = null;
            } else {
                uri = baseDir.toURI();
                str8 = opt1222;
            }
            XmlErrorPrinter xmlErrorPrinter22 = new XmlErrorPrinter(z8, uri);
            String opt1422 = commandLine.getOpt("catalog");
            String opt1522 = commandLine.getOpt("partialMethods");
            Parameters parameters22 = new Parameters();
            parameters22.setBaseDir(baseDir);
            parameters22.setXsdFiles(fileArrFilesEndingWith);
            parameters22.setWsdlFiles(fileArrFilesEndingWith2);
            parameters22.setJavaFiles(fileArrFilesEndingWith322);
            parameters22.setConfigFiles(fileArrFilesEndingWith422);
            parameters22.setUrlFiles(uRLs);
            parameters22.setClasspath(fileArrSystemClasspath);
            parameters22.setOutputJar(file3);
            parameters22.setName(opt6);
            parameters22.setSrcDir(file);
            parameters22.setClassesDir(fileCreateDir);
            parameters22.setCompiler(opt1022);
            parameters22.setMemoryInitialSize(str8);
            parameters22.setMemoryMaximumSize(opt1322);
            parameters22.setNojavac(z1922);
            parameters22.setQuiet(z1822);
            parameters22.setVerbose(z8);
            parameters22.setDownload(z1722);
            parameters22.setNoUpa(z1622);
            parameters22.setNoPvr(z1522);
            parameters22.setNoAnn(z7);
            parameters22.setNoVDoc(z5);
            parameters22.setNoExt(z6);
            parameters22.setDebug(z13);
            parameters22.setSourceCodeEncoding(str5);
            parameters22.setErrorListener(xmlErrorPrinter22);
            parameters22.setRepackage(str6);
            parameters22.setExtensions(arrayList);
            parameters22.setMdefNamespaces(hashSet);
            parameters22.setCatalogFile(opt1422);
            parameters22.setSchemaCodePrinter(schemaCodePrinter2);
            parameters22.setPartialMethods(parsePartialMethods(opt1522));
            parameters22.setCopyAnn(z14);
            zCompile = compile(parameters22);
            if (file2 != null) {
                SchemaCodeGenerator.tryHardToDelete(file2);
            }
            if (!zCompile) {
                System.exit(1);
            }
            System.exit(0);
        }
        arrayList = arrayList2;
        z7 = z;
        fileCreateTempDir = null;
        if (opt3 == null) {
            opt3 = "xmltypes.jar";
        }
        if (opt3 == null) {
        }
        if (file == null) {
        }
        if (fileCreateDir == null) {
        }
        opt2 = commandLine.getOpt("cp");
        if (opt2 == null) {
        }
        String opt10222 = commandLine.getOpt("compiler");
        String opt11222 = commandLine.getOpt("jar");
        if (z8) {
            System.out.println("The 'jar' option is no longer supported.");
        }
        String opt12222 = commandLine.getOpt("ms");
        String opt13222 = commandLine.getOpt("mx");
        file2 = fileCreateTempDir;
        fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        boolean z15222 = z12;
        fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
        boolean z16222 = z11;
        File[] fileArrFilesEndingWith3222 = commandLine.filesEndingWith(".java");
        boolean z17222 = z10;
        File[] fileArrFilesEndingWith4222 = commandLine.filesEndingWith(".xsdconfig");
        boolean z18222 = z9;
        uRLs = commandLine.getURLs();
        boolean z19222 = z4;
        if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
        }
        baseDir = commandLine.getBaseDir();
        if (baseDir != null) {
        }
        XmlErrorPrinter xmlErrorPrinter222 = new XmlErrorPrinter(z8, uri);
        String opt14222 = commandLine.getOpt("catalog");
        String opt15222 = commandLine.getOpt("partialMethods");
        Parameters parameters222 = new Parameters();
        parameters222.setBaseDir(baseDir);
        parameters222.setXsdFiles(fileArrFilesEndingWith);
        parameters222.setWsdlFiles(fileArrFilesEndingWith2);
        parameters222.setJavaFiles(fileArrFilesEndingWith3222);
        parameters222.setConfigFiles(fileArrFilesEndingWith4222);
        parameters222.setUrlFiles(uRLs);
        parameters222.setClasspath(fileArrSystemClasspath);
        parameters222.setOutputJar(file3);
        parameters222.setName(opt6);
        parameters222.setSrcDir(file);
        parameters222.setClassesDir(fileCreateDir);
        parameters222.setCompiler(opt10222);
        parameters222.setMemoryInitialSize(str8);
        parameters222.setMemoryMaximumSize(opt13222);
        parameters222.setNojavac(z19222);
        parameters222.setQuiet(z18222);
        parameters222.setVerbose(z8);
        parameters222.setDownload(z17222);
        parameters222.setNoUpa(z16222);
        parameters222.setNoPvr(z15222);
        parameters222.setNoAnn(z7);
        parameters222.setNoVDoc(z5);
        parameters222.setNoExt(z6);
        parameters222.setDebug(z13);
        parameters222.setSourceCodeEncoding(str5);
        parameters222.setErrorListener(xmlErrorPrinter222);
        parameters222.setRepackage(str6);
        parameters222.setExtensions(arrayList);
        parameters222.setMdefNamespaces(hashSet);
        parameters222.setCatalogFile(opt14222);
        parameters222.setSchemaCodePrinter(schemaCodePrinter2);
        parameters222.setPartialMethods(parsePartialMethods(opt15222));
        parameters222.setCopyAnn(z14);
        zCompile = compile(parameters222);
        if (file2 != null) {
        }
        if (!zCompile) {
        }
        System.exit(0);
    }

    static Set<XmlOptions.BeanMethod> parsePartialMethods(String str) {
        HashSet hashSet = new HashSet();
        if (str != null) {
            for (String str2 : str.split(",")) {
                if ("ALL".equals(str2)) {
                    hashSet.addAll(Arrays.asList(XmlOptions.BeanMethod.values()));
                } else {
                    boolean zStartsWith = str2.startsWith(ProcessIdUtil.DEFAULT_PROCESSID);
                    XmlOptions.BeanMethod beanMethodValueOf = XmlOptions.BeanMethod.valueOf(str2.substring(zStartsWith ? 1 : 0));
                    if (zStartsWith) {
                        hashSet.remove(beanMethodValueOf);
                    } else {
                        hashSet.add(beanMethodValueOf);
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        return hashSet;
    }

    public static void printUsage() {
        System.out.println("Compiles a schema into XML Bean classes and metadata.");
        System.out.println("Usage: scomp [opts] [dirs]* [schema.xsd]* [service.wsdl]* [config.xsdconfig]*");
        System.out.println("Options include:");
        System.out.println("    -cp [a;b;c] - classpath");
        System.out.println("    -d [dir] - target binary directory for .class and .xsb files");
        System.out.println("    -src [dir] - target directory for generated .java files");
        System.out.println("    -srconly - do not compile .java files or jar the output.");
        System.out.println("    -out [xmltypes.jar] - the name of the output jar");
        System.out.println("    -name - the name of the schema type - defaults to autogenerated name");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -noann - ignore annotations");
        System.out.println("    -novdoc - do not validate contents of <documentation>");
        System.out.println("    -noext - ignore all extension (Pre/Post and Interface) found in .xsdconfig files");
        System.out.println("    -compiler - path to external java compiler");
        System.out.println("    -ms - initial memory for external java compiler (default '8m')");
        System.out.println("    -mx - maximum memory for external java compiler (default '256m')");
        System.out.println("    -debug - compile with debug symbols");
        System.out.println("    -quiet - print fewer informational messages");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -version - prints version information");
        System.out.println("    -license - prints license information");
        System.out.println("    -allowmdef \"[ns] [ns] [ns]\" - ignores multiple defs in given namespaces (use ##local for no-namespace)");
        System.out.println("    -catalog [file] -  catalog file for org.apache.xml.resolver.tools.CatalogResolver. (Note: needs resolver.jar from http://xml.apache.org/commons/components/resolver/index.html)");
        System.out.println("    -partialMethods [list] -  comma separated list of bean methods to be generated. Use \"-\" to negate and \"ALL\" for all.");
        System.out.println("                              processed left-to-right, e.g. \"ALL,-GET_LIST\" exclude java.util.List getters - see XmlOptions.BeanMethod");
        System.out.println("    -repackage - repackage specification, e.g. \"org.apache.xmlbeans.metadata:mypackage.metadata\" to change the metadata directory");
        System.out.println("    -copyann - copy schema annotations to javadoc (default false) - don't activate on untrusted schema sources!");
        System.out.println("    -sourcecodeencoding [encodingName] - Generate Java source code with the specified encoding (ISO-8859-1 is the legacy default)");
        System.out.println();
    }

    private static void runExtensions(List<Extension> list, SchemaTypeSystem schemaTypeSystem, File file) throws IOException {
        String absolutePath;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            absolutePath = file.getCanonicalPath();
        } catch (IOException unused) {
            System.out.println("WARNING: Unable to get the path for schema jar file");
            absolutePath = file.getAbsolutePath();
        }
        for (Extension extension : list) {
            try {
                SchemaCompilerExtension schemaCompilerExtension = (SchemaCompilerExtension) extension.getClassName().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                System.out.println("Running Extension: " + schemaCompilerExtension.getExtensionName());
                HashMap map = new HashMap();
                for (Extension.Param param : extension.getParams()) {
                    map.put(param.getName(), param.getValue());
                }
                map.put("classesDir", absolutePath);
                schemaCompilerExtension.schemaCompilerExtension(schemaTypeSystem, map);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                System.out.println("ILLEGAL ACCESS Exception when attempting to instantiate schema compiler extension: " + extension.getClassName().getName());
                System.out.println("EXTENSION Class was not run");
                return;
            } catch (InstantiationException | NoSuchMethodException unused3) {
                System.out.println("UNABLE to instantiate schema compiler extension:" + extension.getClassName().getName());
                System.out.println("EXTENSION Class was not run");
                return;
            }
        }
    }

    private static boolean wsdlContainsEncoded(XmlObject xmlObject) {
        for (XmlObject xmlObject2 : xmlObject.selectPath("declare namespace soap='http://schemas.xmlsoap.org/wsdl/soap/' .//soap:body/@use|.//soap:header/@use|.//soap:fault/@use")) {
            if ("encoded".equals(((SimpleValue) xmlObject2).getStringValue())) {
                return true;
            }
        }
        return false;
    }
}
