package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public abstract class c1 extends w0 implements l {
    static {
        k.y.c.b(c1.class);
    }

    protected c1(z0 z0Var) {
        super(z0Var);
    }

    private byte[] z(byte[] bArr) {
        int length = ((bArr.length - 8224) / 8224) + 1;
        byte[] bArr2 = new byte[bArr.length + (length * 4)];
        System.arraycopy(bArr, 0, bArr2, 0, 8224);
        int i2 = 8224;
        int i3 = 8224;
        for (int i4 = 0; i4 < length; i4++) {
            int iMin = Math.min(bArr.length - i2, 8224);
            s0.f(z0.v.a, bArr2, i3);
            s0.f(iMin, bArr2, i3 + 2);
            System.arraycopy(bArr, i2, bArr2, i3 + 4, iMin);
            i2 += iMin;
            i3 += iMin + 4;
        }
        return bArr2;
    }

    @Override // k.x.l
    public final byte[] a() {
        byte[] bArrY = y();
        int length = bArrY.length;
        if (bArrY.length > 8224) {
            bArrY = z(bArrY);
            length = 8224;
        }
        byte[] bArr = new byte[bArrY.length + 4];
        System.arraycopy(bArrY, 0, bArr, 4, bArrY.length);
        s0.f(w(), bArr, 0);
        s0.f(length, bArr, 2);
        return bArr;
    }

    protected abstract byte[] y();

    protected c1(f2 f2Var) {
        super(f2Var);
    }
}
