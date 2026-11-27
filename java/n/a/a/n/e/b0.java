package n.a.a.n.e;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class b0 {
    public static int a(double d, double d2) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d2);
        int iA = w.a(jDoubleToLongBits);
        int iA2 = w.a(jDoubleToLongBits2);
        if (iA == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + d(d));
        }
        if (iA2 == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + d(d));
        }
        boolean z = jDoubleToLongBits < 0;
        if (z != (jDoubleToLongBits2 < 0)) {
            return z ? -1 : 1;
        }
        int i2 = iA - iA2;
        int iAbs = Math.abs(i2);
        if (iAbs > 1) {
            return z ? -i2 : i2;
        }
        if (iAbs != 1 && jDoubleToLongBits == jDoubleToLongBits2) {
            return 0;
        }
        if (iA == 0) {
            return iA2 == 0 ? c(jDoubleToLongBits & 4503599627370495L, 4503599627370495L & jDoubleToLongBits2, z) : -b(jDoubleToLongBits2, jDoubleToLongBits, z);
        }
        if (iA2 == 0) {
            return b(jDoubleToLongBits, jDoubleToLongBits2, z);
        }
        int iA3 = v.a(jDoubleToLongBits, iA - 1023).d().h().a(v.a(jDoubleToLongBits2, iA2 - 1023).d().h());
        return z ? -iA3 : iA3;
    }

    private static int b(long j2, long j3, boolean z) {
        long j4 = j3 & 4503599627370495L;
        if (j4 == 0) {
            return z ? -1 : 1;
        }
        long j5 = j2 & 4503599627370495L;
        if (j5 > 7 || j4 < 4503599627370490L) {
            return z ? -1 : 1;
        }
        if (j5 == 7 && j4 == 4503599627370490L) {
            return 0;
        }
        return z ? 1 : -1;
    }

    private static int c(long j2, long j3, boolean z) {
        return z ? Long.compare(j3, j2) : Long.compare(j2, j3);
    }

    private static String d(double d) {
        return "0x" + Long.toHexString(Double.doubleToLongBits(d)).toUpperCase(Locale.ROOT);
    }
}
