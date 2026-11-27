package i.b.ha.a.e.g;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class c {
    public static StringBuffer a(double d, NumberFormat numberFormat, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            stringBuffer.append('(');
            stringBuffer.append(d);
            stringBuffer.append(')');
        } else {
            numberFormat.format(d, stringBuffer, fieldPosition);
        }
        return stringBuffer;
    }

    public static NumberFormat b() {
        return c(Locale.getDefault());
    }

    public static NumberFormat c(Locale locale) {
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        numberFormat.setMaximumFractionDigits(10);
        return numberFormat;
    }
}
