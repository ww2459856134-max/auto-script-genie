package n.a.a.n.e;

import java.math.BigInteger;

/* loaded from: classes.dex */
final class z {
    private static final BigInteger c = new BigInteger("0B5E620F47FFFE666", 16);
    private static final BigInteger d = new BigInteger("0E35FA9319FFFE000", 16);
    private BigInteger a;
    private int b;

    public z(BigInteger bigInteger, int i2) {
        this.a = bigInteger;
        this.b = i2;
    }

    private void e(BigInteger bigInteger, int i2) {
        this.a = this.a.multiply(bigInteger);
        this.b += i2;
        int iBitLength = (r2.bitLength() - 72) & (-32);
        if (iBitLength > 0) {
            this.a = this.a.shiftRight(iBitLength);
            this.b += iBitLength;
        }
    }

    public a0 a(int i2) {
        return new a0(this.a.shiftRight((64 - this.b) - 1).longValue(), (this.a.intValue() << (this.b - 39)) & 16777088, i2);
    }

    public int b() {
        return (this.b + this.a.bitLength()) - 64;
    }

    public boolean c() {
        return this.a.compareTo(c.shiftLeft(this.a.bitLength() + (-64))) > 0;
    }

    public boolean d() {
        return this.a.compareTo(d.shiftLeft(this.a.bitLength() + (-64))) < 0;
    }

    public void f(int i2) {
        y yVarA = y.a(Math.abs(i2));
        if (i2 < 0) {
            e(yVarA.b, yVarA.c);
        } else {
            e(yVarA.a, yVarA.d);
        }
    }

    public void g() {
        int iBitLength = this.a.bitLength();
        int i2 = iBitLength - 64;
        if (i2 == 0) {
            return;
        }
        if (i2 < 0) {
            throw new IllegalStateException("Not enough precision");
        }
        this.b += i2;
        if (i2 > 32) {
            int i3 = (i2 - 1) & 16777184;
            this.a = this.a.shiftRight(i3);
            i2 -= i3;
            iBitLength -= i3;
        }
        if (i2 < 1) {
            throw new IllegalStateException();
        }
        BigInteger bigIntegerA = x.a(this.a, i2);
        this.a = bigIntegerA;
        if (bigIntegerA.bitLength() > iBitLength) {
            i2++;
            this.b++;
        }
        this.a = this.a.shiftRight(i2);
    }
}
