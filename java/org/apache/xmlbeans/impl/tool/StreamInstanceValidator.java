package org.apache.xmlbeans.impl.tool;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLInputFactory;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.StaxHelper;
import org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader;

/* loaded from: classes.dex */
public class StreamInstanceValidator {
    public static void main(String[] strArr) throws IOException {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupr");
        hashSet.add("noupa");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") == null && commandLine.getOpt("help") == null && commandLine.getOpt("usage") == null) {
            if (strArr.length >= 1) {
                String[] badOpts = commandLine.getBadOpts();
                if (badOpts.length > 0) {
                    for (String str : badOpts) {
                        System.out.println("Unrecognized option: " + str);
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
                if (commandLine.args().length == 0) {
                    printUsage();
                    return;
                }
                boolean z = commandLine.getOpt("dl") != null;
                boolean z2 = commandLine.getOpt("nopvr") != null;
                boolean z3 = commandLine.getOpt("noupa") != null;
                File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".xml");
                File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".jar");
                ArrayList arrayList = new ArrayList();
                XmlOptions loadLineNumbers = new XmlOptions().setLoadLineNumbers();
                for (int i2 = 0; i2 < fileArrFilesEndingWith.length; i2++) {
                    try {
                        arrayList.add(XmlObject.Factory.parse(fileArrFilesEndingWith[i2], loadLineNumbers.setLoadMessageDigest()));
                    } catch (Exception e) {
                        System.err.println(fileArrFilesEndingWith[i2] + " not loadable: " + e);
                    }
                }
                XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
                SchemaTypeLoader schemaTypeLoaderCompileXsd = null;
                ArrayList arrayList2 = new ArrayList();
                XmlOptions xmlOptions = new XmlOptions();
                xmlOptions.setErrorListener(arrayList2);
                if (z) {
                    xmlOptions.setCompileDownloadUrls();
                }
                if (z2) {
                    xmlOptions.setCompileNoPvrRule();
                }
                if (z3) {
                    xmlOptions.setCompileNoUpaRule();
                }
                if (fileArrFilesEndingWith3 != null && fileArrFilesEndingWith3.length > 0) {
                    schemaTypeLoaderCompileXsd = XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith3));
                }
                if (xmlObjectArr != null) {
                    try {
                        if (xmlObjectArr.length > 0) {
                            schemaTypeLoaderCompileXsd = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoaderCompileXsd, xmlOptions);
                        }
                    } catch (Exception e2) {
                        if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                            e2.printStackTrace(System.err);
                        }
                        System.out.println("Schema invalid");
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                        return;
                    }
                }
                validateFiles(fileArrFilesEndingWith2, schemaTypeLoaderCompileXsd, loadLineNumbers);
                return;
            }
        }
        printUsage();
        System.exit(0);
    }

    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("A streaming validation useful for validating very large instance ");
        System.out.println("documents with less memory. Contrast with the validate tool.");
        System.out.println("Usage: svalidate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -license - prints license information");
    }

    private static String stringFromError(XmlError xmlError, String str) {
        return XmlError.severityAsString(xmlError.getSeverity()) + ": " + str + ParameterizedMessage.ERROR_MSG_SEPARATOR + xmlError.getLine() + ParameterizedMessage.ERROR_MSG_SEPARATOR + xmlError.getColumn() + " " + xmlError.getMessage() + " ";
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void validateFiles(File[] fileArr, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) throws IOException {
        InputStream inputStream;
        Throwable th;
        ValidatingXMLStreamReader validatingXMLStreamReader = new ValidatingXMLStreamReader();
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            String path = file.getPath();
            long jCurrentTimeMillis = 0;
            arrayList.clear();
            try {
                try {
                    XMLInputFactory xMLInputFactoryNewXMLInputFactory = StaxHelper.newXMLInputFactory(new XmlOptions(xmlOptions));
                    InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
                    try {
                        XMLStreamReader xMLStreamReaderCreateXMLStreamReader = xMLInputFactoryNewXMLInputFactory.createXMLStreamReader(path, inputStreamNewInputStream);
                        while (!xMLStreamReaderCreateXMLStreamReader.isStartElement()) {
                            try {
                                xMLStreamReaderCreateXMLStreamReader.next();
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStreamNewInputStream;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th4) {
                                            th.addSuppressed(th4);
                                        }
                                    }
                                    throw th3;
                                }
                            }
                        }
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        inputStream = inputStreamNewInputStream;
                        try {
                            validatingXMLStreamReader.init(xMLStreamReaderCreateXMLStreamReader, true, null, schemaTypeLoader, xmlOptions, arrayList);
                            while (validatingXMLStreamReader.hasNext()) {
                                validatingXMLStreamReader.next();
                            }
                            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                        } catch (Throwable th5) {
                            th = th5;
                            jCurrentTimeMillis = jCurrentTimeMillis2;
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStreamNewInputStream;
                    }
                    try {
                        validatingXMLStreamReader.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th = th;
                        throw th;
                    }
                } catch (XMLStreamException e) {
                    e = e;
                    Location location = e.getLocation();
                    arrayList.add(XmlError.forLocation(e.getMessage(), path, location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset()));
                    if (arrayList.isEmpty()) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    System.err.println("error for file: " + file + ": " + e);
                    e.printStackTrace(System.err);
                }
            } catch (XMLStreamException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            if (arrayList.isEmpty()) {
                System.out.println(file + " NOT valid (" + jCurrentTimeMillis + " ms):");
                Iterator<XmlError> it = arrayList.iterator();
                while (it.hasNext()) {
                    System.out.println(stringFromError(it.next(), path));
                }
            } else {
                System.out.println(file + " valid. (" + jCurrentTimeMillis + " ms)");
            }
        }
    }
}
