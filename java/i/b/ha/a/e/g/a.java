package i.b.ha.a.e.g;

/* loaded from: classes.dex */
public abstract class a {
    public static long a(long j2, long j3) throws i.b.ha.a.e.b.c {
        long j4;
        if (j2 == 0 || j3 == 0) {
            if (j2 == Long.MIN_VALUE || j3 == Long.MIN_VALUE) {
                throw new i.b.ha.a.e.b.c(i.b.ha.a.e.b.p.d.GCD_OVERFLOW_64_BITS, Long.valueOf(j2), Long.valueOf(j3));
            }
            return j.c(j2) + j.c(j3);
        }
        long j5 = j2 > 0 ? -j2 : j2;
        long j6 = j3 > 0 ? -j3 : j3;
        int i2 = 0;
        while (true) {
            j4 = j5 & 1;
            if (j4 != 0 || (j6 & 1) != 0 || i2 >= 63) {
                break;
            }
            j5 /= 2;
            j6 /= 2;
            i2++;
        }
        if (i2 == 63) {
            throw new i.b.ha.a.e.b.c(i.b.ha.a.e.b.p.d.GCD_OVERFLOW_64_BITS, Long.valueOf(j2), Long.valueOf(j3));
        }
        long j7 = j4 == 1 ? j6 : -(j5 / 2);
        while (true) {
            if ((j7 & 1) == 0) {
                j7 /= 2;
            } else {
                if (j7 > 0) {
                    j5 = -j7;
                } else {
                    j6 = j7;
                }
                j7 = (j6 - j5) / 2;
                if (j7 == 0) {
                    return (-j5) * (1 << i2);
                }
            }
        }
    }

    public static long b(long j2, long j3) throws i.b.ha.a.e.b.c {
        if (j2 == 0 || j3 == 0) {
            return 0L;
        }
        long jC = j.c(c(j2 / a(j2, j3), j3));
        if (jC != Long.MIN_VALUE) {
            return jC;
        }
        throw new i.b.ha.a.e.b.c(i.b.ha.a.e.b.p.d.LCM_OVERFLOW_64_BITS, Long.valueOf(j2), Long.valueOf(j3));
    }

    public static long c(long j2, long j3) throws i.b.ha.a.e.b.c {
        if (j2 > j3) {
            return c(j3, j2);
        }
        if (j2 < 0) {
            if (j3 < 0) {
                if (j2 < Long.MAX_VALUE / j3) {
                    throw new i.b.ha.a.e.b.c();
                }
            } else {
                if (j3 <= 0) {
                    return 0L;
                }
                if (Long.MIN_VALUE / j3 > j2) {
                    throw new i.b.ha.a.e.b.c();
                }
            }
        } else {
            if (j2 <= 0) {
                return 0L;
            }
            if (j2 > Long.MAX_VALUE / j3) {
                throw new i.b.ha.a.e.b.c();
            }
        }
        return j2 * j3;
    }
}
