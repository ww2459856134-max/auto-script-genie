package org.apache.xmlbeans.impl.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlErrorCodes;

/* loaded from: classes.dex */
public class NameUtil {
    public static final char AYAH = 1757;
    public static final char COLON = ':';
    private static final int DIGIT = 2;
    public static final char DOT = 183;
    public static final char ELHIZB = 1758;
    public static final char HYPHEN = '-';
    private static final String JAVA_NS_PREFIX = "java:";
    private static final int LOWER = 5;
    private static final int MARK = 3;
    private static final int NOCASE = 6;
    public static final char PERIOD = '.';
    private static final int PUNCT = 1;
    private static final int START = 0;
    public static final char TELEIA = 903;
    private static final int UPPER = 4;
    public static final char USCORE = '_';
    private static final Set<String> javaWords = new HashSet(Arrays.asList("assert", "abstract", XmlErrorCodes.BOOLEAN, "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", XmlErrorCodes.DOUBLE, "else", "enum", "extends", "false", "final", "finally", XmlErrorCodes.FLOAT, "for", "goto", "if", "implements", "import", "instanceof", XmlErrorCodes.INT, "interface", XmlErrorCodes.LONG, "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "threadsafe", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));
    private static final Set<String> extraWords = new HashSet(Arrays.asList("i", "target", "org", "com"));
    private static final Set<String> javaNames = new HashSet(Arrays.asList("CharSequence", "Cloneable", "Comparable", "Runnable", "Boolean", "Byte", "Character", "Class", "ClassLoader", "Compiler", "Double", "Float", "InheritableThreadLocal", "Integer", "Long", "Math", "Number", "Object", "Package", "Process", "Runtime", "RuntimePermission", "SecurityManager", "Short", "StackTraceElement", "StrictMath", "String", "StringBuffer", "System", "Thread", "ThreadGroup", "ThreadLocal", "Throwable", "Void", "ArithmeticException", "ArrayIndexOutOfBoundsException", "ArrayStoreException", "ClassCastException", "ClassNotFoundException", "CloneNotSupportedException", "Exception", "IllegalAccessException", "IllegalArgumentException", "IllegalMonitorStateException", "IllegalStateException", "IllegalThreadStateException", "IndexOutOfBoundsException", "InstantiationException", "InterruptedException", "NegativeArraySizeException", "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException", "RuntimeException", "SecurityException", "StringIndexOutOfBoundsException", "UnsupportedOperationException", "AbstractMethodError", "AssertionError", "ClassCircularityError", "ClassFormatError", "Error", "ExceptionInInitializerError", "IllegalAccessError", "IncompatibleClassChangeError", "InstantiationError", "InternalError", "LinkageError", "NoClassDefFoundError", "NoSuchFieldError", "NoSuchMethodError", "OutOfMemoryError", "StackOverflowError", "ThreadDeath", "UnknownError", "UnsatisfiedLinkError", "UnsupportedClassVersionError", "VerifyError", "VirtualMachineError", "BigInteger", "BigDecimal", "Enum", "Date", "GDate", "GDuration", XmlErrorCodes.QNAME, "List", "XmlObject", "XmlCursor", "XmlBeans", "SchemaType"));

    private static void addCapped(List<String> list, String str) {
        if (str.isEmpty()) {
            return;
        }
        list.add(upperCaseFirstLetter(str));
    }

    private static int findSchemeColon(String str) {
        int length = str.length();
        if (length == 0 || !isUriAlphaChar(str.charAt(0))) {
            return -1;
        }
        int i2 = 1;
        while (i2 < length && isUriSchemeChar(str.charAt(i2))) {
            i2++;
        }
        if (i2 == length || str.charAt(i2) != ':') {
            return -1;
        }
        while (i2 < length && str.charAt(i2) == ':') {
            i2++;
        }
        return i2 - 1;
    }

    public static int getCharClass(char c, boolean z) {
        if (isPunctuation(c, z)) {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        if (Character.isUpperCase(c)) {
            return 4;
        }
        if (Character.isLowerCase(c)) {
            return 5;
        }
        if (Character.isLetter(c)) {
            return 6;
        }
        return Character.isJavaIdentifierPart(c) ? 3 : 1;
    }

    public static String getClassNameFromQName(QName qName) {
        return getClassNameFromQName(qName, false);
    }

    public static String getNamespaceFromPackage(Class<?> cls) {
        for (Class<?> componentType = cls; componentType.isArray(); componentType = componentType.getComponentType()) {
        }
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return JAVA_NS_PREFIX + (iLastIndexOf < 0 ? "" : name.substring(0, iLastIndexOf));
    }

    public static String getPackageFromNamespace(String str) {
        return getPackageFromNamespace(str, false);
    }

    private static boolean isExtraReservedWord(String str) {
        return extraWords.contains(str.toLowerCase(Locale.ROOT));
    }

    public static boolean isJavaCommonClassName(String str) {
        return javaNames.contains(str);
    }

    private static boolean isJavaReservedWord(String str) {
        return javaWords.contains(str.toLowerCase(Locale.ROOT));
    }

    private static boolean isLetter(int i2) {
        return i2 == 4 || i2 == 5 || i2 == 6;
    }

    public static boolean isPunctuation(char c, boolean z) {
        return c == '-' || c == '.' || c == ':' || c == 183 || (c == '_' && !z) || c == 903 || c == 1757 || c == 1758;
    }

    private static boolean isUriAlphaChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isUriSchemeChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '-' || c == '.' || c == '+');
    }

    public static boolean isValidJavaIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        int length = str.length();
        if (length == 0 || javaWords.contains(str) || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i2 = 1; i2 < length; i2++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private static String jls77String(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!Character.isJavaIdentifierPart(sb.charAt(i2)) || '$' == sb.charAt(i2)) {
                sb.setCharAt(i2, USCORE);
            }
        }
        if (sb.length() == 0 || !Character.isJavaIdentifierStart(sb.charAt(0))) {
            sb.insert(0, USCORE);
        }
        if (isJavaReservedWord(str)) {
            sb.append(USCORE);
        }
        return sb.toString();
    }

    public static String lowerCamelCase(String str) {
        return lowerCamelCase(str, false, true);
    }

    public static void main(String[] strArr) {
        for (String str : strArr) {
            System.out.println(upperCaseUnderbar(str));
        }
    }

    public static String nonExtraKeyword(String str) {
        if (!isExtraReservedWord(str)) {
            return str;
        }
        return str + "Value";
    }

    public static String nonJavaCommonClassName(String str) {
        if (!isJavaCommonClassName(str)) {
            return str;
        }
        return "X" + str;
    }

    public static String nonJavaKeyword(String str) {
        if (!isJavaReservedWord(str)) {
            return str;
        }
        return 'x' + str;
    }

    private static String processFilename(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            return str;
        }
        int i2 = iLastIndexOf + 1;
        return (i2 + 2 == str.length() || i2 + 3 == str.length() || "html".equals(str.substring(i2).toLowerCase(Locale.ROOT))) ? str.substring(0, iLastIndexOf) : str;
    }

    private static List<String> splitDNS(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        for (int iLastIndexOf = str.lastIndexOf(46); iLastIndexOf != -1; iLastIndexOf--) {
            if (str.charAt(iLastIndexOf) == '.') {
                arrayList.add(jls77String(str.substring(iLastIndexOf + 1, length)));
                length = iLastIndexOf;
            }
        }
        arrayList.add(jls77String(str.substring(0, length)));
        if (arrayList.size() >= 3 && ((String) arrayList.get(arrayList.size() - 1)).toLowerCase(Locale.ROOT).equals("www")) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public static List<String> splitWords(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int charClass = getCharClass(str.charAt(i2), z);
            if (i4 != 1 && charClass == 1) {
                addCapped(arrayList, str.substring(i3, i2));
                do {
                    int charClass2 = getCharClass(str.charAt(i2), z);
                    if (charClass2 == 1) {
                        i2++;
                    } else {
                        i4 = charClass2;
                        i3 = i2;
                    }
                } while (i2 < length);
                return arrayList;
            }
            if ((i4 == 2) != (charClass == 2) || ((i4 == 5 && charClass != 5) || isLetter(i4) != isLetter(charClass))) {
                addCapped(arrayList, str.substring(i3, i2));
                i3 = i2;
            } else if (i4 == 4 && charClass == 5 && i2 > i3 + 1) {
                int i5 = i2 - 1;
                addCapped(arrayList, str.substring(i3, i5));
                i3 = i5;
            }
            i4 = charClass;
            i2++;
        }
        addCapped(arrayList, str.substring(i3));
        return arrayList;
    }

    public static String upperCamelCase(String str) {
        return upperCamelCase(str, false);
    }

    public static String upperCaseFirstLetter(String str) {
        if (str.isEmpty() || Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }

    public static String upperCaseUnderbar(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, false);
        int size = listSplitWords.size() - 1;
        if (size >= 0 && !Character.isJavaIdentifierStart(listSplitWords.get(0).charAt(0))) {
            sb.append("X_");
        }
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(listSplitWords.get(i2));
            sb.append(USCORE);
        }
        if (size >= 0) {
            sb.append(listSplitWords.get(size));
        }
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    public static String getClassNameFromQName(QName qName, boolean z) {
        String strUpperCamelCase = upperCamelCase(qName.getLocalPart(), z);
        String packageFromNamespace = getPackageFromNamespace(qName.getNamespaceURI(), z);
        if (packageFromNamespace == null) {
            return strUpperCamelCase;
        }
        return packageFromNamespace + "." + strUpperCamelCase;
    }

    public static String getPackageFromNamespace(String str, boolean z) {
        List listAsList;
        if (str == null || str.isEmpty()) {
            return "noNamespace";
        }
        int length = str.length();
        int iFindSchemeColon = findSchemeColon(str);
        if (iFindSchemeColon == length - 1) {
            listAsList = new ArrayList();
            listAsList.add(str.substring(0, iFindSchemeColon));
        } else if (iFindSchemeColon < 0 || !str.substring(0, iFindSchemeColon).equals("java")) {
            ArrayList arrayList = new ArrayList();
            int i2 = iFindSchemeColon + 1;
            loop1: while (i2 < length) {
                while (str.charAt(i2) == '/') {
                    i2++;
                    if (i2 >= length) {
                        break loop1;
                    }
                }
                int i3 = i2;
                while (str.charAt(i3) != '/' && (i3 = i3 + 1) < length) {
                }
                arrayList.add(str.substring(i2, i3));
                i2 = i3;
            }
            if (arrayList.size() > 1) {
                arrayList.set(arrayList.size() - 1, processFilename((String) arrayList.get(arrayList.size() - 1)));
            }
            if (!arrayList.isEmpty()) {
                List<String> listSplitDNS = splitDNS((String) arrayList.get(0));
                arrayList.remove(0);
                arrayList.addAll(0, listSplitDNS);
            }
            listAsList = arrayList;
        } else {
            listAsList = Arrays.asList(str.substring(iFindSchemeColon + 1).split("\\."));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            String strNonJavaKeyword = nonJavaKeyword(lowerCamelCase((String) it.next(), z, true));
            if (!strNonJavaKeyword.isEmpty()) {
                sb.append(strNonJavaKeyword);
                sb.append(PERIOD);
            }
        }
        return sb.length() == 0 ? "noNamespace" : z ? sb.substring(0, sb.length() - 1).toLowerCase(Locale.ROOT) : sb.substring(0, sb.length() - 1);
    }

    public static String lowerCamelCase(String str, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, z);
        if (!listSplitWords.isEmpty()) {
            String lowerCase = listSplitWords.get(0).toLowerCase(Locale.ROOT);
            if (!Character.isJavaIdentifierStart(lowerCase.charAt(0)) && z2) {
                sb.append("x");
            }
            sb.append(lowerCase);
            Iterator<String> it = listSplitWords.iterator();
            it.next();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    public static String upperCamelCase(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, z);
        if (!listSplitWords.isEmpty()) {
            if (!Character.isJavaIdentifierStart(listSplitWords.get(0).charAt(0))) {
                sb.append("X");
            }
            Iterator<String> it = listSplitWords.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }
}
