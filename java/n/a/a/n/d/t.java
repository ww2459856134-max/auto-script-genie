package n.a.a.n.d;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import n.a.a.o.j1;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class t extends Format {
    public static final Format c = new t();
    private static final DecimalFormat d = w.j("##########");

    private t() {
    }

    public static String a(Number number) {
        String str = d.format(number);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (length <= 4) {
            return str;
        }
        int i2 = length - 4;
        String strSubstring = str.substring(i2, length);
        int i3 = length - 7;
        String strSubstring2 = str.substring(Math.max(0, i3), i2);
        String strSubstring3 = str.substring(Math.max(0, length - 10), Math.max(0, i3));
        if (j1.g(strSubstring3)) {
            sb.append('(');
            sb.append(strSubstring3);
            sb.append(") ");
        }
        if (j1.g(strSubstring2)) {
            sb.append(strSubstring2);
            sb.append(NameUtil.HYPHEN);
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(a((Number) obj));
        return stringBuffer;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return d.parseObject(str, parsePosition);
    }
}
