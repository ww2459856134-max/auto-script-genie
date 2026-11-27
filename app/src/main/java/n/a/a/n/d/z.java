package n.a.a.n.d;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Locale;

/* loaded from: classes.dex */
public class z extends Format {
    private static final MathContext g = new MathContext(10, RoundingMode.HALF_UP);
    private final DecimalFormatSymbols c;
    private final DecimalFormat d;
    private final DecimalFormat e;
    private final DecimalFormat f;

    public z(Locale locale) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        this.c = decimalFormatSymbols;
        DecimalFormat decimalFormat = new DecimalFormat("0.#####E0", decimalFormatSymbols);
        this.f = decimalFormat;
        w.x(decimalFormat);
        DecimalFormat decimalFormat2 = new DecimalFormat("#", decimalFormatSymbols);
        this.d = decimalFormat2;
        w.x(decimalFormat2);
        DecimalFormat decimalFormat3 = new DecimalFormat("#.##########", decimalFormatSymbols);
        this.e = decimalFormat3;
        w.x(decimalFormat3);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!(obj instanceof Number)) {
            return this.d.format(obj, stringBuffer, fieldPosition);
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (Double.isInfinite(dDoubleValue) || Double.isNaN(dDoubleValue)) {
            return this.d.format(obj, stringBuffer, fieldPosition);
        }
        double dAbs = Math.abs(dDoubleValue);
        if (dAbs >= 1.0E11d || (dAbs <= 1.0E-10d && dAbs > 0.0d)) {
            return this.f.format(obj, stringBuffer, fieldPosition);
        }
        if (Math.floor(dDoubleValue) == dDoubleValue || dAbs >= 1.0E10d) {
            return this.d.format(obj, stringBuffer, fieldPosition);
        }
        return this.e.format(BigDecimal.valueOf(dDoubleValue).round(g).doubleValue(), stringBuffer, fieldPosition);
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }
}
