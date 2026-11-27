package n.a.a.n.d;

import com.auto.exceldeps.log4j.Logger;
import java.math.BigDecimal;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class k0 extends Format {
    private static final Logger f = n.a.a.i.b.a(k0.class);
    private static final Pattern g = Pattern.compile("(#+)|(\\d+)");
    private final int c;
    private final int d;
    private final String e;

    public k0(String str, String str2) throws NumberFormatException {
        int iPow;
        this.e = str;
        Matcher matcher = g.matcher(str2);
        int i2 = -1;
        if (!matcher.find()) {
            iPow = -1;
        } else if (matcher.group(2) != null) {
            try {
                int i3 = Integer.parseInt(matcher.group(2));
                i2 = i3 == 0 ? -1 : i3;
                iPow = -1;
            } catch (NumberFormatException e) {
                throw new IllegalStateException(e);
            }
        } else if (matcher.group(1) != null) {
            iPow = (int) Math.pow(10.0d, Math.min(matcher.group(1).length(), 4));
        } else {
            iPow = -1;
            i2 = 100;
        }
        this.c = (i2 > 0 || iPow > 0) ? i2 : 100;
        this.d = iPow;
    }

    private String b(BigDecimal bigDecimal) {
        boolean z = bigDecimal.compareTo(BigDecimal.ZERO) < 0;
        BigDecimal bigDecimalAbs = bigDecimal.abs();
        BigDecimal bigDecimal2 = new BigDecimal(bigDecimalAbs.toBigInteger());
        BigDecimal bigDecimalRemainder = bigDecimalAbs.remainder(BigDecimal.ONE);
        if (bigDecimal2.add(bigDecimalRemainder).compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        if (bigDecimalRemainder.compareTo(BigDecimal.ZERO) == 0) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append(NameUtil.HYPHEN);
            }
            sb.append(bigDecimal2);
            return sb.toString();
        }
        try {
            n.a.a.n.b.k0 k0VarA = this.c > 0 ? n.a.a.n.b.k0.a(bigDecimalRemainder.doubleValue(), this.c) : n.a.a.n.b.k0.c(bigDecimalRemainder.doubleValue(), this.d);
            StringBuilder sb2 = new StringBuilder();
            if (z) {
                sb2.append(NameUtil.HYPHEN);
            }
            String str = this.e;
            if (str == null || str.isEmpty()) {
                int iD = k0VarA.d();
                sb2.append(bigDecimal2.multiply(BigDecimal.valueOf(iD)).add(BigDecimal.valueOf(k0VarA.e())).toBigInteger());
                sb2.append("/");
                sb2.append(iD);
                return sb2.toString();
            }
            if (k0VarA.e() == 0) {
                sb2.append(bigDecimal2);
                return sb2.toString();
            }
            if (k0VarA.e() == k0VarA.d()) {
                sb2.append(bigDecimal2.add(BigDecimal.ONE));
                return sb2.toString();
            }
            if (bigDecimal2.compareTo(BigDecimal.ZERO) > 0) {
                sb2.append(bigDecimal2);
                sb2.append(" ");
            }
            sb2.append(k0VarA.e());
            sb2.append("/");
            sb2.append(k0VarA.d());
            return sb2.toString();
        } catch (RuntimeException e) {
            f.atWarn().withThrowable(e).log("Can't format fraction");
            return Double.toString(bigDecimal.doubleValue());
        }
    }

    public String a(Number number) {
        return b(new BigDecimal(number.doubleValue()));
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Number) {
            stringBuffer.append(a((Number) obj));
            return stringBuffer;
        }
        throw new IllegalArgumentException("Cannot format object of " + obj.getClass() + " to number: " + obj);
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new n.a.a.n.c.r1.v("Reverse parsing not supported");
    }
}
