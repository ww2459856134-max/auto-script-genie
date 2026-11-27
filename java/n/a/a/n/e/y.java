package n.a.a.n.e;

import java.math.BigInteger;

/* loaded from: classes.dex */
final class y {
    private static final BigInteger e = BigInteger.valueOf(5);
    private static final y[] f = new y[350];
    public final BigInteger a;
    public final BigInteger b;
    public final int c;
    public final int d;

    private y(int i2) {
        BigInteger bigIntegerPow = e.pow(i2);
        int iBitLength = bigIntegerPow.bitLength();
        BigInteger bigIntegerDivide = BigInteger.ONE.shiftLeft(iBitLength + 80).divide(bigIntegerPow);
        int iBitLength2 = bigIntegerDivide.bitLength() - 80;
        this.b = bigIntegerDivide.shiftRight(iBitLength2);
        this.c = -((iBitLength - iBitLength2) + i2 + 80);
        int iBitLength3 = bigIntegerPow.bitLength() - 68;
        if (iBitLength3 > 0) {
            this.d = i2 + iBitLength3;
            this.a = bigIntegerPow.shiftRight(iBitLength3);
        } else {
            this.d = i2;
            this.a = bigIntegerPow;
        }
    }

    static y a(int i2) {
        y[] yVarArr = f;
        y yVar = yVarArr[i2];
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(i2);
        yVarArr[i2] = yVar2;
        return yVar2;
    }
}
