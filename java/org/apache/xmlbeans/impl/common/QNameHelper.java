package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.soap.SOAPConstants;
import org.apache.xmlbeans.xml.stream.XMLName;

/* loaded from: classes.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_NAME_LENGTH = 64;
    public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
    private static final Map<String, String> WELL_KNOWN_PREFIXES = buildWKP();
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static Map<String, String> buildWKP() {
        HashMap map = new HashMap();
        map.put(XMLConstants.XML_NS_URI, "xml");
        map.put("http://www.w3.org/2001/XMLSchema", "xs");
        map.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        map.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        map.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        map.put(SOAPConstants.URI_NS_SOAP_ENVELOPE, "soapenv");
        return Collections.unmodifiableMap(map);
    }

    public static QName forLN(String str) {
        return new QName("", str);
    }

    public static QName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new QName(str2, str);
    }

    public static QName forPretty(String str, int i2) {
        int iIndexOf = str.indexOf(64, i2);
        return iIndexOf < 0 ? new QName("", str.substring(i2)) : new QName(str.substring(iIndexOf + 1), str.substring(i2, iIndexOf));
    }

    public static String getLocalPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public static String getPrefixPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : "";
    }

    public static XMLName getXMLName(QName qName) {
        if (qName == null) {
            return null;
        }
        return XMLNameHelper.forLNS(qName.getLocalPart(), qName.getNamespaceURI());
    }

    public static String hexsafe(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytes;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (isSafe(cCharAt)) {
                sb.append(cCharAt);
            } else {
                try {
                    byte[] bytes2 = str.substring(i2, i2 + 1).getBytes("UTF-8");
                    for (int i3 = 0; i3 < bytes2.length; i3++) {
                        sb.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        sb.append(cArr[(bytes2[i3] >> 4) & 15]);
                        sb.append(cArr[bytes2[i3] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    sb.append("_BAD_UTF8_CHAR");
                }
            }
        }
        if (sb.length() <= 64) {
            return sb.toString();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                bytes = new byte[0];
            }
            byte[] bArrDigest = messageDigest.digest(bytes);
            StringBuilder sb2 = new StringBuilder(URI_SHA1_PREFIX);
            for (int i4 = 0; i4 < bArrDigest.length; i4++) {
                char[] cArr2 = hexdigits;
                sb2.append(cArr2[(bArrDigest[i4] >> 4) & 15]);
                sb2.append(cArr2[bArrDigest[i4] & 15]);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused3) {
            throw new IllegalStateException("Using in a JDK without an SHA implementation");
        }
    }

    public static String hexsafedir(QName qName) {
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().isEmpty()) {
            return "_nons/" + hexsafe(qName.getLocalPart());
        }
        return hexsafe(qName.getNamespaceURI()) + "/" + hexsafe(qName.getLocalPart());
    }

    private static boolean isSafe(int i2) {
        if (i2 >= 97 && i2 <= 122) {
            return true;
        }
        if (i2 < 65 || i2 > 90) {
            return i2 >= 48 && i2 <= 57;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String namespace(SchemaType schemaType) {
        while (schemaType != null) {
            if (schemaType.getName() != null) {
                return schemaType.getName().getNamespaceURI();
            }
            if (schemaType.getContainerField() != null && !schemaType.getContainerField().getName().getNamespaceURI().isEmpty()) {
                return schemaType.getContainerField().getName().getNamespaceURI();
            }
            schemaType = schemaType.getOuterType();
        }
        return "";
    }

    public static String pretty(QName qName) {
        if (qName == null) {
            return "null";
        }
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().isEmpty()) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    public static String readable(SchemaType schemaType) {
        return readable(schemaType, WELL_KNOWN_PREFIXES);
    }

    private static boolean startsWithXml(String str, int i2) {
        if (str.length() < i2 + 3) {
            return false;
        }
        if (str.charAt(i2) != 'X' && str.charAt(i2) != 'x') {
            return false;
        }
        int i3 = i2 + 1;
        if (str.charAt(i3) != 'M' && str.charAt(i3) != 'm') {
            return false;
        }
        int i4 = i2 + 2;
        return str.charAt(i4) == 'L' || str.charAt(i4) == 'l';
    }

    public static String suggestPrefix(String str) {
        String str2 = WELL_KNOWN_PREFIXES.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf > 0 && iLastIndexOf == str.length() - 1) {
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
            length = iLastIndexOf;
        }
        int i2 = iLastIndexOf + 1;
        if (str.startsWith("www.", i2)) {
            i2 += 4;
        }
        while (i2 < length && !XMLChar.isNCNameStart(str.charAt(i2))) {
            i2++;
        }
        for (int i3 = i2 + 1; i3 < length; i3++) {
            if (!XMLChar.isNCName(str.charAt(i3)) || !Character.isLetterOrDigit(str.charAt(i3))) {
                length = i3;
                break;
            }
        }
        int i4 = i2 + 3;
        if (str.length() < i4 || !startsWithXml(str, i2)) {
            if (length - i2 > 4) {
                length = (!isVowel(str.charAt(i2 + 2)) || isVowel(str.charAt(i4))) ? i4 : i2 + 4;
            }
            return length - i2 == 0 ? "ns" : str.substring(i2, length).toLowerCase(Locale.ROOT);
        }
        if (str.length() < i2 + 4) {
            return "ns";
        }
        return "x" + Character.toLowerCase(str.charAt(i4));
    }

    public static String readable(SchemaType schemaType, Map<String, String> map) {
        if (schemaType.getName() != null) {
            return readable(schemaType.getName(), map);
        }
        if (schemaType.isAttributeType()) {
            return "attribute type " + readable(schemaType.getAttributeTypeAttributeName(), map);
        }
        if (schemaType.isDocumentType()) {
            return "document type " + readable(schemaType.getDocumentElementName(), map);
        }
        if (schemaType.isNoType() || schemaType.getOuterType() == null) {
            return "invalid type";
        }
        SchemaType outerType = schemaType.getOuterType();
        SchemaField containerField = schemaType.getContainerField();
        if (outerType.isAttributeType()) {
            return "type of attribute " + readable(containerField.getName(), map);
        }
        if (outerType.isDocumentType()) {
            return "type of element " + readable(containerField.getName(), map);
        }
        if (containerField != null) {
            if (containerField.isAttribute()) {
                return "type of " + containerField.getName().getLocalPart() + " attribute in " + readable(outerType, map);
            }
            return "type of " + containerField.getName().getLocalPart() + " element in " + readable(outerType, map);
        }
        if (outerType.getBaseType() == schemaType) {
            return "base type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() == 3) {
            return "item type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() != 2) {
            return "inner type in " + readable(outerType, map);
        }
        return "member type " + schemaType.getAnonymousUnionMemberOrdinal() + " of " + readable(outerType, map);
    }

    public static String readable(QName qName) {
        return readable(qName, WELL_KNOWN_PREFIXES);
    }

    public static String readable(QName qName, Map<String, String> map) {
        if (qName.getNamespaceURI().isEmpty()) {
            return qName.getLocalPart();
        }
        String str = map.get(qName.getNamespaceURI());
        if (str != null) {
            return str + ParameterizedMessage.ERROR_MSG_SEPARATOR + qName.getLocalPart();
        }
        return qName.getLocalPart() + " in namespace " + qName.getNamespaceURI();
    }
}
