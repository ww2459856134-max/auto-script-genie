package n.a.a.j.o;

import java.util.Locale;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

/* loaded from: classes.dex */
public abstract class c {
    public static long a(STCoordinate sTCoordinate) {
        return b(sTCoordinate, 1.0d);
    }

    private static long b(XmlAnySimpleType xmlAnySimpleType, double d) throws NumberFormatException {
        double d2;
        String lowerCase = xmlAnySimpleType.getStringValue().toLowerCase(Locale.ROOT);
        double d3 = Double.parseDouble(lowerCase.replaceAll("(mm|cm|in|pt|pc|pi)", ""));
        if (!lowerCase.endsWith("mm")) {
            if (!lowerCase.endsWith("cm")) {
                if (!lowerCase.endsWith("in")) {
                    if (lowerCase.endsWith("pc") || lowerCase.endsWith("pi")) {
                        d3 *= 0.16599999368190765d;
                    } else {
                        d2 = lowerCase.endsWith("pt") ? d3 * 12700.0d : d3 * d;
                    }
                }
                return (long) d2;
            }
            d2 = d3 * 914400.0d;
            return (long) d2;
        }
        d3 /= 10.0d;
        d3 /= 2.5399999618530273d;
        d2 = d3 * 914400.0d;
        return (long) d2;
    }

    public static boolean c(STOnOff sTOnOff) {
        if (sTOnOff == null) {
            return false;
        }
        String stringValue = sTOnOff.getStringValue();
        return "true".equalsIgnoreCase(stringValue) || "on".equalsIgnoreCase(stringValue) || "x".equalsIgnoreCase(stringValue) || "1".equals(stringValue);
    }

    public static boolean d(CTOnOff cTOnOff) {
        if (cTOnOff == null) {
            return false;
        }
        if (cTOnOff.isSetVal()) {
            return c(cTOnOff.xgetVal());
        }
        return true;
    }
}
