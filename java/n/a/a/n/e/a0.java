package n.a.a.n.e;

import com.auto.exceldeps.log4j.util.Chars;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class a0 {
    private static final BigDecimal d = new BigDecimal(BigInteger.ONE.shiftLeft(24));
    private final int a;
    private final long b;
    private final int c;

    a0(long j2, int i2, int i3) {
        this.b = j2;
        this.c = i2;
        this.a = i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a0 b(BigInteger bigInteger, int i2) {
        int i3 = (i2 > 49 || i2 < 46) ? -(((15204352 - (315653 * i2)) + 524288) >> 20) : 0;
        z zVar = new z(bigInteger, i2);
        if (i3 != 0) {
            zVar.f(-i3);
        }
        switch (zVar.b()) {
            case 44:
            case 45:
                zVar.f(1);
                i3--;
                zVar.g();
                return zVar.a(i3);
            case 46:
                if (!zVar.c()) {
                }
                zVar.g();
                return zVar.a(i3);
            case 47:
            case 48:
                zVar.g();
                return zVar.a(i3);
            case 49:
                if (!zVar.d()) {
                    zVar.f(-1);
                    i3++;
                }
                zVar.g();
                return zVar.a(i3);
            case 50:
                break;
            default:
                throw new IllegalStateException("Bad binary exp " + zVar.b() + ".");
        }
    }

    private String d() {
        return this.c == 0 ? "0" : e().toString().substring(2);
    }

    public int a(a0 a0Var) {
        int i2 = this.a - a0Var.a;
        if (i2 != 0) {
            return i2;
        }
        long j2 = this.b;
        long j3 = a0Var.b;
        if (j2 > j3) {
            return 1;
        }
        if (j2 < j3) {
            return -1;
        }
        return this.c - a0Var.c;
    }

    public int c() {
        return this.a + 14;
    }

    public BigDecimal e() {
        return BigDecimal.valueOf(this.c).divide(d);
    }

    public String f() {
        return Long.toString(this.b);
    }

    public String g() {
        long j2 = this.b + 5;
        StringBuilder sb = new StringBuilder(24);
        sb.append(j2);
        sb.setCharAt(sb.length() - 1, '0');
        return sb.toString();
    }

    public a0 h() {
        long j2 = this.b;
        if (this.c >= 8388608) {
            j2++;
        }
        int i2 = this.a;
        return j2 < 1000000000000000L ? new a0(j2, 0, i2) : new a0(j2 / 10, 0, i2 + 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a0.class.getName());
        sb.append(" [");
        String strValueOf = String.valueOf(this.b);
        sb.append(strValueOf.charAt(0));
        sb.append(NameUtil.PERIOD);
        sb.append(strValueOf.substring(1));
        sb.append(Chars.SPACE);
        sb.append(d());
        sb.append('E');
        sb.append(c());
        sb.append(']');
        return sb.toString();
    }
}
