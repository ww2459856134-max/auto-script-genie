package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* loaded from: classes.dex */
public class FactorImports {
    private static URI commonAncestor(URI uri, URI uri2) {
        String string = uri.toString();
        String string2 = uri2.toString();
        int length = string.length();
        if (string2.length() < length) {
            length = string2.length();
        }
        int i2 = 0;
        while (i2 < length && string.charAt(i2) == string2.charAt(i2)) {
            i2++;
        }
        int iLastIndexOf = i2 - 1;
        if (iLastIndexOf >= 0) {
            iLastIndexOf = string.lastIndexOf(47, iLastIndexOf);
        }
        if (iLastIndexOf < 0) {
            return null;
        }
        try {
            return new URI(string.substring(0, iLastIndexOf));
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private static File commonFileFor(String str, String str2, int i2, File file) {
        if (i2 > 0) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf < 0) {
                iLastIndexOf = str.length();
            }
            str = str.substring(0, iLastIndexOf) + i2 + str.substring(iLastIndexOf);
        }
        return new File(file, str);
    }

    private static boolean isDuplicate(String str, String str2, Set<QName> set) {
        if (str == null) {
            return false;
        }
        return set.contains(new QName(str2, str));
    }

    private static boolean isFirstDuplicate(String str, String str2, Set<QName> set, Set<QName> set2) {
        if (str == null) {
            return false;
        }
        QName qName = new QName(str2, str);
        if (!set2.contains(qName) || !set.contains(qName)) {
            return false;
        }
        set.remove(qName);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static void main(String[] strArr) throws Exception {
        File file;
        File file2;
        ?? r1;
        HashSet hashSet;
        ?? r2;
        HashSet hashSet2;
        HashSet hashSet3;
        File file3;
        String str;
        int i2;
        File[] fileArr;
        HashMap map;
        String str2;
        HashSet hashSet4;
        String str3 = "warning: ";
        HashSet hashSet5 = new HashSet();
        hashSet5.add("h");
        hashSet5.add("help");
        hashSet5.add("usage");
        hashSet5.add("license");
        hashSet5.add("version");
        String str4 = "out";
        CommandLine commandLine = new CommandLine(strArr, hashSet5, Arrays.asList("import", "out"));
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str5 : badOpts) {
                System.out.println("Unrecognized option: " + str5);
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
        String[] strArrArgs = commandLine.args();
        if (strArrArgs.length != 1) {
            System.exit(0);
            return;
        }
        String opt = commandLine.getOpt("import");
        if (opt == null) {
            opt = "common.xsd";
        }
        String opt2 = commandLine.getOpt("out");
        if (opt2 == null) {
            System.out.println("Using output directory 'out'");
        } else {
            str4 = opt2;
        }
        File file4 = new File(str4);
        File file5 = new File(strArrArgs[0]);
        File[] files = commandLine.getFiles();
        HashMap map2 = new HashMap();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = new HashSet();
        HashSet hashSet13 = new HashSet();
        HashSet hashSet14 = new HashSet();
        File file6 = file5;
        HashSet hashSet15 = new HashSet();
        String str6 = opt;
        HashSet hashSet16 = new HashSet();
        int length = files.length;
        HashSet hashSet17 = hashSet15;
        int i3 = 0;
        while (i3 < length) {
            int i4 = length;
            File file7 = files[i3];
            try {
                try {
                    SchemaDocument schemaDocument = SchemaDocument.Factory.parse(file7);
                    map2.put(schemaDocument, file7);
                    if (schemaDocument.getSchema().sizeOfImportArray() > 0 || schemaDocument.getSchema().sizeOfIncludeArray() > 0) {
                        fileArr = files;
                        try {
                            PrintStream printStream = System.out;
                            map = map2;
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str3);
                                sb.append(file7);
                                i2 = i3;
                                sb.append(" contains imports or includes that are being ignored.");
                                printStream.println(sb.toString());
                            } catch (XmlException e) {
                                e = e;
                                str = str3;
                                i2 = i3;
                                hashSet4 = hashSet17;
                                PrintStream printStream2 = System.out;
                                StringBuilder sb2 = new StringBuilder();
                                str2 = str;
                                sb2.append(str2);
                                sb2.append(file7);
                                sb2.append(" is not a schema file - ");
                                sb2.append(e.getError().toString());
                                printStream2.println(sb2.toString());
                                i3 = i2 + 1;
                                hashSet17 = hashSet4;
                                str3 = str2;
                                length = i4;
                                files = fileArr;
                                map2 = map;
                            }
                        } catch (XmlException e2) {
                            e = e2;
                            str = str3;
                            i2 = i3;
                            map = map2;
                            hashSet4 = hashSet17;
                            PrintStream printStream22 = System.out;
                            StringBuilder sb22 = new StringBuilder();
                            str2 = str;
                            sb22.append(str2);
                            sb22.append(file7);
                            sb22.append(" is not a schema file - ");
                            sb22.append(e.getError().toString());
                            printStream22.println(sb22.toString());
                            i3 = i2 + 1;
                            hashSet17 = hashSet4;
                            str3 = str2;
                            length = i4;
                            files = fileArr;
                            map2 = map;
                        }
                    } else {
                        i2 = i3;
                        fileArr = files;
                        map = map2;
                    }
                    String targetNamespace = schemaDocument.getSchema().getTargetNamespace();
                    if (targetNamespace == null) {
                        targetNamespace = "";
                    }
                    try {
                        TopLevelComplexType[] complexTypeArray = schemaDocument.getSchema().getComplexTypeArray();
                        int length2 = complexTypeArray.length;
                        str = str3;
                        int i5 = 0;
                        while (i5 < length2) {
                            try {
                                noteName(complexTypeArray[i5].getName(), targetNamespace, hashSet8, hashSet13, hashSet16);
                                i5++;
                                complexTypeArray = complexTypeArray;
                            } catch (XmlException e3) {
                                e = e3;
                                hashSet4 = hashSet17;
                                PrintStream printStream222 = System.out;
                                StringBuilder sb222 = new StringBuilder();
                                str2 = str;
                                sb222.append(str2);
                                sb222.append(file7);
                                sb222.append(" is not a schema file - ");
                                sb222.append(e.getError().toString());
                                printStream222.println(sb222.toString());
                                i3 = i2 + 1;
                                hashSet17 = hashSet4;
                                str3 = str2;
                                length = i4;
                                files = fileArr;
                                map2 = map;
                            }
                        }
                        TopLevelSimpleType[] simpleTypeArray = schemaDocument.getSchema().getSimpleTypeArray();
                        int length3 = simpleTypeArray.length;
                        int i6 = 0;
                        while (i6 < length3) {
                            noteName(simpleTypeArray[i6].getName(), targetNamespace, hashSet8, hashSet13, hashSet16);
                            i6++;
                            simpleTypeArray = simpleTypeArray;
                        }
                        TopLevelElement[] elementArray = schemaDocument.getSchema().getElementArray();
                        int length4 = elementArray.length;
                        int i7 = 0;
                        while (i7 < length4) {
                            noteName(elementArray[i7].getName(), targetNamespace, hashSet6, hashSet11, hashSet16);
                            i7++;
                            elementArray = elementArray;
                        }
                        TopLevelAttribute[] attributeArray = schemaDocument.getSchema().getAttributeArray();
                        int length5 = attributeArray.length;
                        int i8 = 0;
                        while (i8 < length5) {
                            noteName(attributeArray[i8].getName(), targetNamespace, hashSet7, hashSet12, hashSet16);
                            i8++;
                            attributeArray = attributeArray;
                        }
                        NamedGroup[] groupArray = schemaDocument.getSchema().getGroupArray();
                        int length6 = groupArray.length;
                        int i9 = 0;
                        while (i9 < length6) {
                            noteName(groupArray[i9].getName(), targetNamespace, hashSet9, hashSet14, hashSet16);
                            i9++;
                            groupArray = groupArray;
                        }
                        NamedAttributeGroup[] attributeGroupArray = schemaDocument.getSchema().getAttributeGroupArray();
                        int length7 = attributeGroupArray.length;
                        int i10 = 0;
                        while (i10 < length7) {
                            int i11 = length7;
                            hashSet4 = hashSet17;
                            try {
                                noteName(attributeGroupArray[i10].getName(), targetNamespace, hashSet10, hashSet4, hashSet16);
                                i10++;
                                hashSet17 = hashSet4;
                                length7 = i11;
                            } catch (XmlException e4) {
                                e = e4;
                                PrintStream printStream2222 = System.out;
                                StringBuilder sb2222 = new StringBuilder();
                                str2 = str;
                                sb2222.append(str2);
                                sb2222.append(file7);
                                sb2222.append(" is not a schema file - ");
                                sb2222.append(e.getError().toString());
                                printStream2222.println(sb2222.toString());
                                i3 = i2 + 1;
                                hashSet17 = hashSet4;
                                str3 = str2;
                                length = i4;
                                files = fileArr;
                                map2 = map;
                            }
                        }
                        hashSet4 = hashSet17;
                        str2 = str;
                    } catch (XmlException e5) {
                        e = e5;
                        str = str3;
                    }
                } catch (XmlException e6) {
                    e = e6;
                    str = str3;
                    i2 = i3;
                    fileArr = files;
                }
                i3 = i2 + 1;
                hashSet17 = hashSet4;
                str3 = str2;
                length = i4;
                files = fileArr;
                map2 = map;
            } catch (IOException e7) {
                System.err.println("Unable to load " + file7 + " - " + e7.getMessage());
                System.exit(1);
                return;
            }
        }
        HashMap map3 = map2;
        HashSet hashSet18 = hashSet17;
        if (map3.isEmpty()) {
            System.out.println("No schema files found.");
            System.exit(0);
            return;
        }
        if (hashSet13.isEmpty() && hashSet11.isEmpty() && hashSet12.isEmpty() && hashSet14.isEmpty() && hashSet18.isEmpty()) {
            System.out.println("No duplicate names found.");
            System.exit(0);
            return;
        }
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        int i12 = hashSet16.size() == 1 ? 0 : 1;
        Iterator it = hashSet16.iterator();
        while (it.hasNext()) {
            String str7 = (String) it.next();
            Iterator it2 = it;
            SchemaDocument schemaDocument2 = SchemaDocument.Factory.parse("<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema'/>");
            if (!str7.isEmpty()) {
                schemaDocument2.getSchema().setTargetNamespace(str7);
            }
            schemaDocument2.getSchema().setElementFormDefault(FormChoice.QUALIFIED);
            map4.put(str7, schemaDocument2);
            String str8 = str6;
            map5.put(schemaDocument2, commonFileFor(str8, str7, i12, file4));
            i12++;
            it = it2;
            hashSet10 = hashSet10;
            str6 = str8;
        }
        HashSet hashSet19 = hashSet10;
        File file8 = file4;
        Iterator it3 = map3.keySet().iterator();
        while (it3.hasNext()) {
            SchemaDocument schemaDocument3 = (SchemaDocument) it3.next();
            String targetNamespace2 = schemaDocument3.getSchema().getTargetNamespace();
            if (targetNamespace2 == null) {
                targetNamespace2 = "";
            }
            SchemaDocument schemaDocument4 = (SchemaDocument) map4.get(targetNamespace2);
            HashMap map6 = map4;
            TopLevelComplexType[] complexTypeArray2 = schemaDocument3.getSchema().getComplexTypeArray();
            Iterator it4 = it3;
            int length8 = complexTypeArray2.length - 1;
            boolean z = false;
            while (length8 >= 0) {
                HashMap map7 = map5;
                if (isDuplicate(complexTypeArray2[length8].getName(), targetNamespace2, hashSet13)) {
                    if (isFirstDuplicate(complexTypeArray2[length8].getName(), targetNamespace2, hashSet8, hashSet13)) {
                        file3 = file8;
                        schemaDocument4.getSchema().addNewComplexType().set(complexTypeArray2[length8]);
                    } else {
                        file3 = file8;
                    }
                    schemaDocument3.getSchema().removeComplexType(length8);
                    z = true;
                } else {
                    file3 = file8;
                }
                length8--;
                file8 = file3;
                map5 = map7;
            }
            HashMap map8 = map5;
            File file9 = file8;
            TopLevelSimpleType[] simpleTypeArray2 = schemaDocument3.getSchema().getSimpleTypeArray();
            for (int i13 = 0; i13 < simpleTypeArray2.length; i13++) {
                if (isDuplicate(simpleTypeArray2[i13].getName(), targetNamespace2, hashSet13)) {
                    if (isFirstDuplicate(simpleTypeArray2[i13].getName(), targetNamespace2, hashSet8, hashSet13)) {
                        schemaDocument4.getSchema().addNewSimpleType().set(simpleTypeArray2[i13]);
                    }
                    schemaDocument3.getSchema().removeSimpleType(i13);
                    z = true;
                }
            }
            TopLevelElement[] elementArray2 = schemaDocument3.getSchema().getElementArray();
            for (int i14 = 0; i14 < elementArray2.length; i14++) {
                if (isDuplicate(elementArray2[i14].getName(), targetNamespace2, hashSet11)) {
                    if (isFirstDuplicate(elementArray2[i14].getName(), targetNamespace2, hashSet6, hashSet11)) {
                        schemaDocument4.getSchema().addNewElement().set(elementArray2[i14]);
                    }
                    schemaDocument3.getSchema().removeElement(i14);
                    z = true;
                }
            }
            TopLevelAttribute[] attributeArray2 = schemaDocument3.getSchema().getAttributeArray();
            for (int i15 = 0; i15 < attributeArray2.length; i15++) {
                if (isDuplicate(attributeArray2[i15].getName(), targetNamespace2, hashSet12)) {
                    if (isFirstDuplicate(attributeArray2[i15].getName(), targetNamespace2, hashSet7, hashSet12)) {
                        schemaDocument4.getSchema().addNewElement().set(attributeArray2[i15]);
                    }
                    schemaDocument3.getSchema().removeElement(i15);
                    z = true;
                }
            }
            NamedGroup[] groupArray2 = schemaDocument3.getSchema().getGroupArray();
            for (int i16 = 0; i16 < groupArray2.length; i16++) {
                if (isDuplicate(groupArray2[i16].getName(), targetNamespace2, hashSet14)) {
                    if (isFirstDuplicate(groupArray2[i16].getName(), targetNamespace2, hashSet9, hashSet14)) {
                        schemaDocument4.getSchema().addNewElement().set(groupArray2[i16]);
                    }
                    schemaDocument3.getSchema().removeElement(i16);
                    z = true;
                }
            }
            NamedAttributeGroup[] attributeGroupArray2 = schemaDocument3.getSchema().getAttributeGroupArray();
            int i17 = 0;
            while (i17 < attributeGroupArray2.length) {
                if (isDuplicate(attributeGroupArray2[i17].getName(), targetNamespace2, hashSet18)) {
                    hashSet2 = hashSet19;
                    if (isFirstDuplicate(attributeGroupArray2[i17].getName(), targetNamespace2, hashSet2, hashSet18)) {
                        hashSet3 = hashSet18;
                        schemaDocument4.getSchema().addNewElement().set(attributeGroupArray2[i17]);
                    } else {
                        hashSet3 = hashSet18;
                    }
                    schemaDocument3.getSchema().removeElement(i17);
                    z = true;
                } else {
                    hashSet2 = hashSet19;
                    hashSet3 = hashSet18;
                }
                i17++;
                hashSet18 = hashSet3;
                hashSet19 = hashSet2;
            }
            HashSet hashSet20 = hashSet19;
            HashSet hashSet21 = hashSet18;
            if (z) {
                IncludeDocument.Include includeAddNewInclude = schemaDocument3.getSchema().addNewInclude();
                r1 = map3;
                File file10 = (File) r1.get(schemaDocument3);
                file = file6;
                file2 = file9;
                File fileOutputFileFor = outputFileFor(file10, file, file2);
                hashSet = hashSet14;
                r2 = map8;
                File file11 = (File) r2.get(schemaDocument4);
                if (targetNamespace2 != null) {
                    includeAddNewInclude.setSchemaLocation(relativeURIFor(fileOutputFileFor, file11));
                }
            } else {
                file = file6;
                file2 = file9;
                r1 = map3;
                hashSet = hashSet14;
                r2 = map8;
            }
            map3 = r1;
            it3 = it4;
            map4 = map6;
            hashSet18 = hashSet21;
            hashSet19 = hashSet20;
            file8 = file2;
            map5 = r2;
            hashSet14 = hashSet;
            file6 = file;
        }
        Map map9 = map5;
        File file12 = file8;
        File file13 = file6;
        Map map10 = map3;
        if (!file12.isDirectory() && !file12.mkdirs()) {
            System.err.println("Unable to makedir " + file12);
            System.exit(1);
            return;
        }
        for (SchemaDocument schemaDocument5 : map10.keySet()) {
            File file14 = (File) map10.get(schemaDocument5);
            File fileOutputFileFor2 = outputFileFor(file14, file13, file12);
            if (fileOutputFileFor2 == null) {
                System.out.println("Cannot copy " + file14);
            } else {
                schemaDocument5.save(fileOutputFileFor2, new XmlOptions().setSavePrettyPrint().setSaveAggressiveNamespaces());
            }
        }
        for (SchemaDocument schemaDocument6 : map9.keySet()) {
            schemaDocument6.save((File) map9.get(schemaDocument6), new XmlOptions().setSavePrettyPrint().setSaveAggressiveNamespaces());
        }
    }

    private static void noteName(String str, String str2, Set<QName> set, Set<QName> set2, Set<String> set3) {
        if (str == null) {
            return;
        }
        QName qName = new QName(str2, str);
        if (!set.contains(qName)) {
            set.add(qName);
        } else {
            set2.add(qName);
            set3.add(str2);
        }
    }

    private static File outputFileFor(File file, File file2, File file3) {
        URI uriRelativize = file2.getAbsoluteFile().toURI().relativize(file.getAbsoluteFile().toURI());
        if (!uriRelativize.isAbsolute()) {
            return new File(CodeGenUtil.resolve(file3.toURI(), uriRelativize));
        }
        System.out.println("Cannot relativize " + file);
        return null;
    }

    public static void printUsage() {
        System.out.println("Refactors a directory of XSD files to remove name conflicts.");
        System.out.println("Usage: sfactor [-import common.xsd] [-out outputdir] inputdir");
        System.out.println("    -import common.xsd - The XSD file to contain redundant ");
        System.out.println("                         definitions for importing.");
        System.out.println("    -out outputdir - The directory into which to place XSD ");
        System.out.println("                     files resulting from refactoring, ");
        System.out.println("                     plus a commonly imported common.xsd.");
        System.out.println("    inputdir - The directory containing the XSD files with");
        System.out.println("               redundant definitions.");
        System.out.println("    -license - Print license information.");
        System.out.println();
    }

    private static String relativeURIFor(File file, File file2) {
        int iIndexOf;
        URI uri = file.getAbsoluteFile().toURI();
        URI uri2 = file2.getAbsoluteFile().toURI();
        URI uriCommonAncestor = commonAncestor(uri, uri2);
        if (uriCommonAncestor == null) {
            return uri2.toString();
        }
        URI uriRelativize = uriCommonAncestor.relativize(uri);
        URI uriRelativize2 = uriCommonAncestor.relativize(uri2);
        if (uriRelativize.isAbsolute() || uriRelativize2.isAbsolute()) {
            return uri2.toString();
        }
        String string = uriRelativize.toString();
        int i2 = 0;
        String str = "";
        while (i2 < string.length() && (iIndexOf = string.indexOf(47, i2)) >= 0) {
            str = str + "../";
            i2 = iIndexOf + 1;
        }
        return str + uriRelativize2.toString();
    }
}
