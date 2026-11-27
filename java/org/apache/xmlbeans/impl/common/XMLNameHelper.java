package org.apache.xmlbeans.impl.common;

import java.io.UnsupportedEncodingException;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.xml.stream.XMLName;

/* loaded from: classes.dex */
public class XMLNameHelper {
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static XMLName forLN(String str) {
        return new XmlNameImpl("", str);
    }

    public static XMLName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new XmlNameImpl(str2, str);
    }

    public static XMLName forPretty(String str, int i2) {
        int iIndexOf = str.indexOf(64, i2);
        return iIndexOf < 0 ? new XmlNameImpl("", str.substring(i2)) : new XmlNameImpl(str.substring(iIndexOf + 1), str.substring(i2, iIndexOf));
    }

    public static QName getQName(XMLName xMLName) {
        if (xMLName == null) {
            return null;
        }
        return QNameHelper.forLNS(xMLName.getLocalName(), xMLName.getNamespaceUri());
    }

    public static String hexsafe(String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (isSafe(cCharAt)) {
                sb.append(cCharAt);
            } else {
                try {
                    byte[] bytes = str.substring(i2, i2 + 1).getBytes("UTF-8");
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        sb.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        sb.append(cArr[(bytes[i3] >> 4) & 15]);
                        sb.append(cArr[bytes[i3] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    sb.append("_BAD_UTF8_CHAR");
                }
            }
        }
        return sb.toString();
    }

    public static String hexsafedir(XMLName xMLName) {
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().isEmpty()) {
            return "_nons/" + hexsafe(xMLName.getLocalName());
        }
        return hexsafe(xMLName.getNamespaceUri()) + "/" + hexsafe(xMLName.getLocalName());
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

    public static String pretty(XMLName xMLName) {
        if (xMLName == null) {
            return "null";
        }
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().isEmpty()) {
            return xMLName.getLocalName();
        }
        return xMLName.getLocalName() + "@" + xMLName.getNamespaceUri();
    }
}
