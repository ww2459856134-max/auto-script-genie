package n.a.a.n.d;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/* loaded from: classes.dex */
final class r extends Format {
    private static final DecimalFormat d = w.j("##########");
    private final String c;

    public r(String str) {
        this.c = str;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(this.c);
        return stringBuffer;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return d.parseObject(str, parsePosition);
    }
}
