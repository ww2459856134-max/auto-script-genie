package k.x.i1;

import k.a0.a.f2;
import k.x.c1;
import k.x.z0;

/* loaded from: classes.dex */
public class s0 extends c1 {
    private byte[] c;
    private int d;

    static {
        k.y.c.b(s0.class);
    }

    s0(String str) {
        super(z0.f2177m);
        this.d = str.length();
    }

    public int A() {
        return this.d;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[18];
        this.c = bArr2;
        k.x.s0.f(530, bArr2, 0);
        k.x.s0.f(this.d, this.c, 10);
        k.x.s0.f(16, this.c, 12);
        return this.c;
    }

    public s0(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = bArrC;
        this.d = k.x.s0.c(bArrC[10], bArrC[11]);
    }
}
