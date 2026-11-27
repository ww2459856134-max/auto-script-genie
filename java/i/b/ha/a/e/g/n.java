package i.b.ha.a.e.g;

/* loaded from: classes.dex */
public abstract class n {
    private static final long a = Double.doubleToRawLongBits(0.0d);
    private static final long b = Double.doubleToRawLongBits(-0.0d);
    private static final int c = Float.floatToRawIntBits(0.0f);
    private static final int d = Float.floatToRawIntBits(-0.0f);

    static {
        Double.longBitsToDouble(4368491638549381120L);
        Double.longBitsToDouble(4503599627370496L);
    }

    public static boolean a(double d2, double d3, double d4) {
        return b(d2, d3, 1) || j.a(d3 - d2) <= d4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(double d2, double d3, int i2) {
        long j2;
        long j3;
        boolean z;
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d3);
        if (((jDoubleToRawLongBits ^ jDoubleToRawLongBits2) & Long.MIN_VALUE) == 0) {
            z = j.c(jDoubleToRawLongBits - jDoubleToRawLongBits2) <= ((long) i2);
        } else {
            if (jDoubleToRawLongBits < jDoubleToRawLongBits2) {
                j3 = jDoubleToRawLongBits2 - a;
                j2 = jDoubleToRawLongBits - b;
            } else {
                long j4 = jDoubleToRawLongBits - a;
                j2 = jDoubleToRawLongBits2 - b;
                j3 = j4;
            }
            long j5 = i2;
            if (j3 <= j5 && j2 <= j5 - j3) {
            }
        }
        return (!z || Double.isNaN(d2) || Double.isNaN(d3)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(float f, float f2, int i2) {
        int i3;
        int i4;
        boolean z;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int iFloatToRawIntBits2 = Float.floatToRawIntBits(f2);
        if (((iFloatToRawIntBits ^ iFloatToRawIntBits2) & Integer.MIN_VALUE) == 0) {
            z = j.b(iFloatToRawIntBits - iFloatToRawIntBits2) <= i2;
        } else {
            if (iFloatToRawIntBits < iFloatToRawIntBits2) {
                i3 = iFloatToRawIntBits2 - c;
                i4 = iFloatToRawIntBits - d;
            } else {
                int i5 = iFloatToRawIntBits - c;
                int i6 = iFloatToRawIntBits2 - d;
                i3 = i5;
                i4 = i6;
            }
            if (i3 <= i2 && i4 <= i2 - i3) {
            }
        }
        return (!z || Float.isNaN(f) || Float.isNaN(f2)) ? false : true;
    }

    public static boolean d(double d2, double d3) {
        if (d2 == d2 && d3 == d3) {
            return b(d2, d3, 1);
        }
        return !(((d2 > d2 ? 1 : (d2 == d2 ? 0 : -1)) != 0) ^ ((d3 > d3 ? 1 : (d3 == d3 ? 0 : -1)) != 0));
    }

    public static boolean e(float f, float f2) {
        if (f == f && f2 == f2) {
            return c(f, f2, 1);
        }
        return !(((f > f ? 1 : (f == f ? 0 : -1)) != 0) ^ ((f2 > f2 ? 1 : (f2 == f2 ? 0 : -1)) != 0));
    }
}
