package n.a.a.n.d;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class u extends Format {
    public static final Format c = new u();
    private static final DecimalFormat d = w.j("000000000");

    private u() {
    }

    public static String a(Number number) {
        String str = d.format(number);
        return str.substring(0, 3) + NameUtil.HYPHEN + str.substring(3, 5) + NameUtil.HYPHEN + str.substring(5, 9);
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
