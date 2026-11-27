package i.b.ha.a.e.g;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class b {
    static final long[] a = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    static {
        new AtomicReference(null);
    }

    public static long a(int i2) throws i.b.ha.a.e.b.j, i.b.ha.a.e.b.c {
        if (i2 < 0) {
            throw new i.b.ha.a.e.b.j(i.b.ha.a.e.b.p.d.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(i2));
        }
        if (i2 <= 20) {
            return a[i2];
        }
        throw new i.b.ha.a.e.b.c();
    }
}
