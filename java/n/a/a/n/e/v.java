package n.a.a.n.e;

import java.math.BigInteger;

/* loaded from: classes.dex */
final class v {
    private static final BigInteger c = BigInteger.valueOf(4503599627370495L);
    private static final BigInteger d = BigInteger.valueOf(4503599627370496L);
    private final BigInteger a;
    private final int b;

    public v(long j2) {
        if (Math.toIntExact(j2 >> 52) != 0) {
            this.a = c(j2);
            this.b = (r0 & 2047) - 1023;
        } else {
            BigInteger bigIntegerAnd = BigInteger.valueOf(j2).and(c);
            int iBitLength = 64 - bigIntegerAnd.bitLength();
            this.a = bigIntegerAnd.shiftLeft(iBitLength);
            this.b = (-1023) - iBitLength;
        }
    }

    public static v a(long j2, int i2) {
        return new v(c(j2), i2);
    }

    private static BigInteger c(long j2) {
        return BigInteger.valueOf(j2).and(c).or(d).shiftLeft(11);
    }

    public int b() {
        return this.b;
    }

    public a0 d() {
        return a0.b(this.a, this.b);
    }

    v(BigInteger bigInteger, int i2) {
        if (bigInteger.bitLength() == 64) {
            this.a = bigInteger;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("bad bit length");
    }
}
