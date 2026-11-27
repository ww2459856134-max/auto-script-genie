package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes.dex */
public class InstanceValidator {
    public static int extraMain(String[] strArr) {
        int i2;
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("strict");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        int i3 = 0;
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            return 0;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            return 0;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            return 0;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            return 0;
        }
        if (commandLine.args().length == 0) {
            return 0;
        }
        boolean z = commandLine.getOpt("dl") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        boolean z4 = commandLine.getOpt("strict") != null;
        boolean z5 = commandLine.getOpt("partial") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".xml");
        File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        int length = fileArrFilesEndingWith.length;
        int i4 = 0;
        while (i4 < length) {
            File file = fileArrFilesEndingWith[i4];
            try {
                arrayList.add(XmlObject.Factory.parse(file, new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(file + " not loadable: " + e);
            }
            i4++;
            i3 = 0;
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[i3]);
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
        if (z5) {
            xmlOptions.setCompilePartialTypesystem();
        }
        SchemaTypeLoader schemaTypeLoaderTypeLoaderForResource = (fileArrFilesEndingWith3 == null || fileArrFilesEndingWith3.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith3));
        if (xmlObjectArr != null) {
            try {
                if (xmlObjectArr.length > 0) {
                    schemaTypeLoaderTypeLoaderForResource = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoaderTypeLoaderForResource, xmlOptions);
                }
            } catch (Exception e2) {
                if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                    e2.printStackTrace(System.err);
                }
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("Schema invalid:");
                sb.append(z5 ? " couldn't recover from errors" : "");
                printStream.println(sb.toString());
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println((XmlError) it.next());
                }
                return 10;
            }
        }
        if (!z5 || arrayList2.isEmpty()) {
            i2 = 0;
        } else {
            System.out.println("Schema invalid: partial schema type system recovered");
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println((XmlError) it2.next());
            }
            i2 = 11;
        }
        if (schemaTypeLoaderTypeLoaderForResource == null) {
            schemaTypeLoaderTypeLoaderForResource = XmlBeans.getContextTypeLoader();
        }
        for (File file2 : fileArrFilesEndingWith2) {
            try {
                XmlOptions xmlOptions2 = new XmlOptions();
                xmlOptions2.setLoadLineNumbersEndElement();
                XmlObject xmlObject = schemaTypeLoaderTypeLoaderForResource.parse(file2, (SchemaType) null, xmlOptions2);
                ArrayList arrayList3 = new ArrayList();
                if (xmlObject.schemaType() == XmlObject.type) {
                    System.out.println(file2 + " NOT valid.  ");
                    System.out.println("  Document type not found.");
                } else if (xmlObject.validate(z4 ? new XmlOptions().setErrorListener(arrayList3).setValidateStrict() : new XmlOptions().setErrorListener(arrayList3))) {
                    System.out.println(file2 + " valid.");
                } else {
                    System.out.println(file2 + " NOT valid.");
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        System.out.println((XmlError) it3.next());
                    }
                    i2 = 1;
                }
            } catch (Exception e3) {
                System.err.println(file2 + " not loadable: " + e3);
                e3.printStackTrace(System.err);
            }
        }
        return i2;
    }

    public static void main(String[] strArr) {
        System.exit(extraMain(strArr));
    }

    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("Contrast with the svalidate tool, which validates using a stream.");
        System.out.println("Usage: validate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -strict - performs strict(er) validation");
        System.out.println("    -partial - allow partial schema type system");
        System.out.println("    -license - prints license information");
    }
}
