package org.apache.xmlbeans.impl.tool;

import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.xmlbeans.XmlError;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Mojo(defaultPhase = LifecyclePhase.GENERATE_SOURCES, name = "compile")
/* loaded from: classes.dex */
public class MavenPlugin extends AbstractMojo {

    @Parameter(defaultValue = "schemaorg_apache_xmlbeans/src")
    private String baseSchemaLocation;

    @Parameter
    private File basedir;

    @Parameter(defaultValue = "true")
    private boolean buildSchemas;

    @Parameter
    private String catalogLocation;

    @Parameter
    private String classPath;

    @Parameter(defaultValue = "${project.basedir}/target/generated-resources")
    private String classTargetDir;

    @Parameter
    private String compiler;

    @Parameter(defaultValue = "false")
    private boolean copyAnn;

    @Parameter(defaultValue = "false")
    private boolean debug;

    @Parameter(defaultValue = "false")
    private boolean download;

    @Parameter
    private List<Extension> extensions;

    @Parameter(defaultValue = "${project.basedir}/target/generated-sources")
    private String javaTargetDir;

    @Parameter
    private List<String> mdefNamespaces;

    @Parameter(defaultValue = CodeGenUtil.DEFAULT_MEM_START)
    private String memoryInitialSize;

    @Parameter(defaultValue = CodeGenUtil.DEFAULT_MEM_MAX)
    private String memoryMaximumSize;

    @Parameter(defaultValue = "${project.artifactId}")
    private String name;

    @Parameter(defaultValue = "false")
    private boolean noAnn;

    @Parameter(defaultValue = "false")
    private boolean noPvr;

    @Parameter(defaultValue = "false")
    private boolean noUpa;

    @Parameter(defaultValue = "false")
    private boolean noVDoc;

    @Parameter(defaultValue = "${project.basedir}/target/${project.artifactId}-${project.version}-xmltypes.jar")
    private File outputJar;

    @Parameter
    private String partialMethods;

    @Parameter(defaultValue = "${project}", readonly = Constants.FLAG_DEBUG)
    private MavenProject project;

    @Parameter(defaultValue = "true")
    private boolean quiet;

    @Parameter(defaultValue = "true")
    private boolean quite;

    @Parameter(defaultValue = "false")
    private boolean recurseSourceSubdirs;

    @Parameter(defaultValue = "${project.groupId}.${project.artifactId}.metadata")
    private String repackage;

    @Parameter
    private List<Resource> resources;

    @Parameter
    private String sourceCodeEncoding;

    @Parameter(defaultValue = "${project.basedir}/src/main/schema")
    private String sourceDir;

    @Parameter(defaultValue = "true")
    private boolean sourceOnly;

    @Parameter(defaultValue = "*.xsd,*.wsdl,*.java")
    private String sourceSchemas;

    @Parameter(defaultValue = "false")
    private boolean verbose;

    @Parameter(defaultValue = "${project.basedir}/src/schema/xmlconfig.xml")
    private String xmlConfigs;

    private static class PassThroughResolver implements EntityResolver {
        private final String baseSchemaLocation;
        private final ClassLoader cl;
        private final EntityResolver delegate;
        private final URI sourceDir;

        public PassThroughResolver(ClassLoader classLoader, EntityResolver entityResolver, URI uri, String str) {
            this.cl = classLoader;
            this.delegate = entityResolver;
            this.sourceDir = uri;
            this.baseSchemaLocation = str + "/";
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
            InputSource inputSourceResolveEntity;
            EntityResolver entityResolver = this.delegate;
            if (entityResolver != null && (inputSourceResolveEntity = entityResolver.resolveEntity(str, str2)) != null) {
                return inputSourceResolveEntity;
            }
            System.out.println("Could not resolve publicId: " + str + ", systemId: " + str2 + " from catalog");
            try {
                String string = this.sourceDir.relativize(new URI(str2)).toString();
                InputStream resourceAsStream = this.cl.getResourceAsStream(string);
                if (resourceAsStream != null) {
                    System.out.println("found in classpath at: " + string);
                    return new InputSource(resourceAsStream);
                }
                InputStream resourceAsStream2 = this.cl.getResourceAsStream(this.baseSchemaLocation + string);
                if (resourceAsStream2 != null) {
                    System.out.println("found in classpath at: META-INF/" + string);
                    return new InputSource(resourceAsStream2);
                }
                System.out.println("Not found in classpath, looking in current directory: " + str2);
                return new InputSource(str2);
            } catch (URISyntaxException e) {
                throw new IOException("Could not relativeize systemId", e);
            }
        }
    }

    private static File[] files(List<File> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (File[]) list.toArray(new File[0]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoFailureException */
    public void execute() throws MojoExecutionException, MojoFailureException {
        String str = this.sourceDir;
        if (str == null || str.isEmpty() || !new File(this.sourceDir).isDirectory()) {
            throw new MojoFailureException("Set configuration <sourceDir> (='" + this.sourceDir + "') to a valid directory containing *.xsd,*.wsdl files.");
        }
        String str2 = this.baseSchemaLocation;
        if (str2 == null || str2.isEmpty()) {
            throw new MojoFailureException("baseSchemaLocation is empty");
        }
        if (this.sourceSchemas == null) {
            getLog().debug("sourceSchemas is null");
        }
        if (this.classPath == null) {
            getLog().debug("classPath is null");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        final File file = new File(this.sourceDir);
        Resource resource = new Resource();
        resource.setDirectory(this.sourceDir);
        resource.setTargetPath(this.baseSchemaLocation);
        String str3 = this.sourceSchemas != null ? "(" + this.sourceSchemas.replace(",", "|").replace(".", "\\.").replace("*", ".*") + ")" : ".*";
        for (File file2 : FileUtil.find(file, Pattern.compile(str3), this.recurseSourceSubdirs)) {
            String name = file2.getName();
            String strReplaceAll = name.replaceAll(".*\\.", "");
            strReplaceAll.hashCode();
            if (strReplaceAll.equals("java")) {
                arrayList3.add(file2);
            } else if (strReplaceAll.equals("wsdl")) {
                arrayList2.add(file2);
            } else {
                arrayList.add(file2);
            }
            resource.addInclude(name);
        }
        this.resources = Collections.singletonList(resource);
        if (this.buildSchemas) {
            String str4 = this.xmlConfigs;
            List listEmptyList = (str4 == null || str4.isEmpty()) ? Collections.emptyList() : (List) Stream.of((Object[]) this.xmlConfigs.split(",")).flatMap(new Function() { // from class: org.apache.xmlbeans.impl.tool.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    String str5 = (String) obj;
                    return Stream.of((Object[]) new File[]{new File(str5), new File(file, str5)}).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.tool.a
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj2) {
                            return ((File) obj2).exists();
                        }
                    });
                }
            }).collect(Collectors.toList());
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            String str5 = this.classPath;
            boolean z = false;
            if (str5 != null) {
                for (String str6 : str5.split(",")) {
                    File file3 = new File(str6);
                    arrayList4.add(file3);
                    try {
                        arrayList5.add(file3.toURI().toURL());
                    } catch (MalformedURLException e) {
                        throw new MojoFailureException("invalid classpath: " + file3, e);
                    }
                }
            }
            PassThroughResolver passThroughResolver = new PassThroughResolver(new URLClassLoader((URL[]) arrayList5.toArray(new URL[0])), MavenPluginResolver.getResolver(this.catalogLocation), new File(this.sourceDir).toURI(), this.baseSchemaLocation);
            Parameters parameters = new Parameters();
            parameters.setXsdFiles(files(arrayList));
            parameters.setWsdlFiles(files(arrayList2));
            parameters.setJavaFiles(files(arrayList3));
            parameters.setConfigFiles(files(listEmptyList));
            parameters.setClasspath(files(arrayList4));
            parameters.setName(this.name);
            parameters.setSrcDir(new File(this.javaTargetDir));
            parameters.setClassesDir(new File(this.classTargetDir));
            parameters.setNojavac(this.sourceOnly);
            parameters.setVerbose(this.verbose);
            parameters.setEntityResolver(passThroughResolver);
            if (this.quiet && this.quite) {
                z = true;
            }
            parameters.setQuiet(z);
            parameters.setNoUpa(this.noUpa);
            parameters.setNoPvr(this.noPvr);
            parameters.setNoAnn(this.noAnn);
            parameters.setCopyAnn(this.copyAnn);
            parameters.setNoVDoc(this.noVDoc);
            String str7 = this.repackage;
            if (str7 != null && !str7.isEmpty()) {
                parameters.setRepackage("org.apache.xmlbeans.metadata:" + this.repackage);
            }
            List<String> list = this.mdefNamespaces;
            if (list != null && !list.isEmpty()) {
                parameters.setMdefNamespaces(new HashSet(this.mdefNamespaces));
            }
            ArrayList arrayList6 = new ArrayList();
            parameters.setErrorListener(arrayList6);
            String str8 = this.partialMethods;
            if (str8 != null && !str8.isEmpty()) {
                parameters.setPartialMethods(SchemaCompiler.parsePartialMethods(this.partialMethods));
            }
            parameters.setDownload(this.download);
            parameters.setBaseDir(this.basedir);
            parameters.setCompiler(this.compiler);
            parameters.setMemoryInitialSize(this.memoryInitialSize);
            parameters.setMemoryMaximumSize(this.memoryMaximumSize);
            parameters.setOutputJar(this.outputJar);
            parameters.setDebug(this.debug);
            parameters.setExtensions(this.extensions);
            String str9 = this.sourceCodeEncoding;
            if (str9 != null && !str9.isEmpty()) {
                parameters.setSourceCodeEncoding(this.sourceCodeEncoding);
            }
            if (!SchemaCompiler.compile(parameters)) {
                throw new MojoFailureException("Schema compilation failed!\n" + ((String) arrayList6.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.tool.b
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((XmlError) obj).toString();
                    }
                }).collect(Collectors.joining("\n"))));
            }
            Resource resource2 = new Resource();
            resource2.setDirectory(this.classTargetDir);
            this.project.addResource(resource2);
            this.project.addCompileSourceRoot(this.javaTargetDir);
        }
    }
}
