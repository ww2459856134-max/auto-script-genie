package org.apache.poi.xssf.usermodel.u2;

import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import n.a.a.l.b.d;
import n.a.a.l.b.e;
import n.a.a.o.c1;
import n.a.a.o.j1;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes.dex */
public abstract class c {
    private static QName a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return new QName(str2);
        }
        return new QName(str + j1.l(str2.charAt(0)) + str2.substring(1));
    }

    public static void b(XmlObject xmlObject, String str, e eVar, String str2) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            if (str == null) {
                xmlCursorNewCursor.removeAttribute(a(str2, "password"));
                xmlCursorNewCursor.removeAttribute(a(str2, "algorithmName"));
                xmlCursorNewCursor.removeAttribute(a(str2, "hashValue"));
                xmlCursorNewCursor.removeAttribute(a(str2, "saltValue"));
                xmlCursorNewCursor.removeAttribute(a(str2, "spinCount"));
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                    return;
                }
                return;
            }
            xmlCursorNewCursor.toFirstContentToken();
            if (eVar == null) {
                int iA = d.a(str);
                QName qNameA = a(str2, "password");
                Locale locale = Locale.ROOT;
                xmlCursorNewCursor.insertAttributeWithValue(qNameA, String.format(locale, "%04X", Integer.valueOf(iA)).toUpperCase(locale));
            } else {
                byte[] bArrGenerateSeed = c1.a().generateSeed(16);
                byte[] bArrD = d.d(str, eVar, bArrGenerateSeed, 100000, false);
                Base64.Encoder encoder = Base64.getEncoder();
                xmlCursorNewCursor.insertAttributeWithValue(a(str2, "algorithmName"), eVar.c);
                xmlCursorNewCursor.insertAttributeWithValue(a(str2, "hashValue"), encoder.encodeToString(bArrD));
                xmlCursorNewCursor.insertAttributeWithValue(a(str2, "saltValue"), encoder.encodeToString(bArrGenerateSeed));
                xmlCursorNewCursor.insertAttributeWithValue(a(str2, "spinCount"), "100000");
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static boolean c(XmlObject xmlObject, String str, String str2) {
        if (str == null) {
            return false;
        }
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            String attributeText = xmlCursorNewCursor.getAttributeText(a(str2, "password"));
            String attributeText2 = xmlCursorNewCursor.getAttributeText(a(str2, "algorithmName"));
            String attributeText3 = xmlCursorNewCursor.getAttributeText(a(str2, "hashValue"));
            String attributeText4 = xmlCursorNewCursor.getAttributeText(a(str2, "saltValue"));
            String attributeText5 = xmlCursorNewCursor.getAttributeText(a(str2, "spinCount"));
            if (attributeText != null) {
                boolean z = Integer.parseInt(attributeText, 16) == d.a(str);
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return z;
            }
            if (attributeText3 == null || attributeText2 == null || attributeText4 == null || attributeText5 == null) {
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return false;
            }
            Base64.Decoder decoder = Base64.getDecoder();
            boolean zEquals = Arrays.equals(decoder.decode(attributeText3), d.d(str, e.a(attributeText2), decoder.decode(attributeText4), Integer.parseInt(attributeText5), false));
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return zEquals;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
