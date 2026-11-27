package n.a.a.n.e;

import java.math.BigInteger;

/* loaded from: classes.dex */
abstract class x {
    private static final BigInteger[] a;

    static {
        BigInteger[] bigIntegerArr = new BigInteger[33];
        long j2 = 1;
        for (int i2 = 1; i2 < 33; i2++) {
            bigIntegerArr[i2] = BigInteger.valueOf(j2);
            j2 <<= 1;
        }
        a = bigIntegerArr;
    }

    public static BigInteger a(BigInteger bigInteger, int i2) {
        return i2 < 1 ? bigInteger : bigInteger.add(a[i2]);
    }
}
