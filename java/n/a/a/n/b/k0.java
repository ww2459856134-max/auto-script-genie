package n.a.a.n.b;

/* loaded from: classes.dex */
public class k0 {
    private final int a;
    private final int b;

    public k0(int i2, int i3) {
        this.b = i2;
        this.a = i3;
    }

    public static k0 a(double d, int i2) {
        return new k0((int) Math.round(d * i2), i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0123, code lost:
    
        throw new java.lang.IllegalStateException("Overflow trying to convert " + r37 + " to fraction (" + r4 + r36 + r13 + r35);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static k0 b(double d, double d2, int i2, int i3) {
        String str;
        String str2;
        long j2;
        long jFloor = (long) Math.floor(d);
        String str3 = ")";
        String str4 = "/";
        if (jFloor > 2147483647L) {
            throw new IllegalArgumentException("Overflow trying to convert " + d + " to fraction (" + jFloor + "/1)");
        }
        int i4 = 1;
        if (Math.abs(jFloor - d) < d2) {
            return new k0((int) jFloor, 1);
        }
        int i5 = 0;
        double d3 = d;
        long j3 = jFloor;
        boolean z = false;
        long j4 = 0;
        long j5 = 1;
        long j6 = 1;
        while (true) {
            i5 += i4;
            long j7 = j3;
            double d4 = 1.0d / (d3 - jFloor);
            long jFloor2 = (long) Math.floor(d4);
            long j8 = jFloor;
            long j9 = (jFloor2 * j7) + j6;
            long j10 = (jFloor2 * j5) + j4;
            if (d2 != 0.0d || i2 <= 0) {
                str = str3;
                str2 = str4;
            } else {
                str = str3;
                str2 = str4;
                long j11 = i2;
                if (Math.abs(j10) > j11 && Math.abs(j5) < j11) {
                    return new k0((int) j7, (int) j5);
                }
            }
            if (j9 > 2147483647L || j10 > 2147483647L) {
                break;
            }
            long j12 = j5;
            double d5 = j9 / j10;
            if (i5 >= i3 || Math.abs(d5 - d) <= d2 || j10 >= i2) {
                j5 = j12;
                j2 = j7;
                z = true;
            } else {
                j2 = j9;
                j5 = j10;
                d3 = d4;
                j4 = j12;
                j6 = j7;
                j8 = jFloor2;
            }
            if (z) {
                if (i5 < i3) {
                    return j10 < ((long) i2) ? new k0((int) j9, (int) j10) : new k0((int) j2, (int) j5);
                }
                throw new IllegalStateException("Unable to convert " + d + " to fraction after " + i3 + " iterations");
            }
            j3 = j2;
            jFloor = j8;
            str3 = str;
            str4 = str2;
            i4 = 1;
        }
    }

    public static k0 c(double d, int i2) {
        return b(d, 0.0d, i2, 100);
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }
}
