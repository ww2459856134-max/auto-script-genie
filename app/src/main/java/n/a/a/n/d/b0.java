package n.a.a.n.d;

import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class b0 extends SimpleDateFormat {
    private static final DecimalFormat d;
    private static final DecimalFormat e;
    private static final DecimalFormat f;
    private static final DecimalFormat g;
    private double c;

    static {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ROOT);
        DecimalFormat decimalFormat = new DecimalFormat("0", decimalFormatSymbols);
        d = decimalFormat;
        DecimalFormat decimalFormat2 = new DecimalFormat("00", decimalFormatSymbols);
        e = decimalFormat2;
        DecimalFormat decimalFormat3 = new DecimalFormat("0", decimalFormatSymbols);
        f = decimalFormat3;
        DecimalFormat decimalFormat4 = new DecimalFormat("00", decimalFormatSymbols);
        g = decimalFormat4;
        w.y(decimalFormat, RoundingMode.DOWN);
        w.y(decimalFormat2, RoundingMode.DOWN);
        w.x(decimalFormat3);
        w.x(decimalFormat4);
    }

    public b0(String str, DateFormatSymbols dateFormatSymbols) {
        super(a(str), dateFormatSymbols);
        setTimeZone(n.a.a.o.a1.f());
    }

    private static String a(String str) {
        return str.replace("MMMMM", "\ue001MMM\ue002").replace("[H]", String.valueOf((char) 57360)).replace("[HH]", String.valueOf((char) 57361)).replace("[m]", String.valueOf((char) 57362)).replace("[mm]", String.valueOf((char) 57363)).replace("[s]", String.valueOf((char) 57364)).replace("[ss]", String.valueOf((char) 57365)).replace("T", "'T'").replace("''T''", "'T'").replaceAll("s.000", "s.SSS").replaceAll("s.00", "s.\ue017").replaceAll("s.0", "s.\ue016");
    }

    public void b(double d2) {
        this.c = d2;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public boolean equals(Object obj) {
        return (obj instanceof b0) && this.c == ((b0) obj).c;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String string = super.format(date, stringBuffer, fieldPosition).toString();
        if (string.indexOf(57345) != -1) {
            string = string.replaceAll("\ue001(\\p{L}|\\p{P})[\\p{L}\\p{P}]+\ue002", "$1");
        }
        if (string.indexOf(57360) != -1 || string.indexOf(57361) != -1) {
            double d2 = ((float) this.c) * 24.0f;
            string = string.replaceAll(String.valueOf((char) 57360), d.format(d2)).replaceAll(String.valueOf((char) 57361), e.format(d2));
        }
        if (string.indexOf(57362) != -1 || string.indexOf(57363) != -1) {
            double d3 = ((float) this.c) * 24.0f * 60.0f;
            string = string.replaceAll(String.valueOf((char) 57362), d.format(d3)).replaceAll(String.valueOf((char) 57363), e.format(d3));
        }
        if (string.indexOf(57364) != -1 || string.indexOf(57365) != -1) {
            double d4 = (float) (this.c * 24.0d * 60.0d * 60.0d);
            string = string.replaceAll(String.valueOf((char) 57364), d.format(d4)).replaceAll(String.valueOf((char) 57365), e.format(d4));
        }
        if (string.indexOf(57366) != -1 || string.indexOf(57367) != -1) {
            double d5 = this.c;
            double dFloor = ((float) ((((d5 - Math.floor(d5)) * 24.0d) * 60.0d) * 60.0d)) - ((int) r13);
            string = string.replaceAll(String.valueOf((char) 57366), f.format(10.0d * dFloor)).replaceAll(String.valueOf((char) 57367), g.format(dFloor * 100.0d));
        }
        return new StringBuffer(string);
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public int hashCode() {
        return Double.valueOf(this.c).hashCode();
    }
}
