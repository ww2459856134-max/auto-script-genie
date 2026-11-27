package n.a.a.n.d;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
class s extends Format {
    private static final Pattern e = Pattern.compile("(,+)$");
    private static final BigDecimal f = BigDecimal.valueOf(1000L);
    private final BigDecimal c;
    private final DecimalFormat d;

    public s(String str, DecimalFormatSymbols decimalFormatSymbols) {
        DecimalFormat decimalFormat = new DecimalFormat(c(str), decimalFormatSymbols);
        this.d = decimalFormat;
        w.x(decimalFormat);
        Matcher matcher = e.matcher(str);
        if (!matcher.find()) {
            this.c = null;
            return;
        }
        String strGroup = matcher.group(1);
        BigDecimal bigDecimalMultiply = BigDecimal.ONE;
        for (int i2 = 0; i2 < strGroup.length(); i2++) {
            bigDecimalMultiply = bigDecimalMultiply.multiply(f);
        }
        this.c = bigDecimalMultiply;
    }

    private Object b(Object obj) {
        BigDecimal bigDecimal = this.c;
        if (bigDecimal == null) {
            return obj;
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).divide(bigDecimal, RoundingMode.HALF_UP);
        }
        if (obj instanceof Double) {
            return Double.valueOf(((Double) obj).doubleValue() / this.c.doubleValue());
        }
        throw new UnsupportedOperationException("cannot scaleInput of type " + obj.getClass());
    }

    private static String c(String str) {
        return str.replaceAll(",+$", "");
    }

    boolean a() {
        return this.c != null;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.d.format(b(obj), stringBuffer, fieldPosition);
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }
}
