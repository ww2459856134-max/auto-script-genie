package k.x.i1;

import k.a0.a.f2;
import k.x.c1;
import k.x.z0;

/* loaded from: classes.dex */
public class f0 extends c1 {
    private byte[] c;
    private int d;
    private int e;
    private int f;

    static {
        k.y.c.b(f0.class);
    }

    public f0(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = bArrC;
        this.d = k.x.s0.c(bArrC[0], bArrC[1]);
        byte[] bArr = this.c;
        this.e = k.x.s0.c(bArr[2], bArr[3]);
        byte[] bArr2 = this.c;
        this.f = k.x.s0.c(bArr2[6], bArr2[7]);
    }

    public int A() {
        return this.f;
    }

    int b() {
        return this.e;
    }

    int getRow() {
        return this.d;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[12];
        this.c = bArr2;
        k.x.s0.f(this.d, bArr2, 0);
        k.x.s0.f(this.e, this.c, 2);
        k.x.s0.f(this.f, this.c, 6);
        k.x.s0.f(0, this.c, 8);
        return this.c;
    }

    public f0(int i2, int i3, int i4) {
        super(z0.f2176l);
        this.d = i3;
        this.e = i2;
        this.f = i4;
    }
}
