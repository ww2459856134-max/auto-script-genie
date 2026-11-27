package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class b1 extends c1 {
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;

    static {
        k.y.c.b(b1.class);
    }

    public b1(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        int iC = s0.c(bArrC[0], bArrC[1]);
        this.c = iC;
        this.f = (iC | 256) != 0;
        this.d = (iC | 1024) != 0;
        this.e = (iC | 2048) != 0;
    }

    public boolean A() {
        return this.f;
    }

    public void B(boolean z) {
        this.d = true;
    }

    public void C(boolean z) {
        this.f = z;
    }

    public void D(boolean z) {
        this.d = true;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[2];
        if (this.f) {
            this.c |= 256;
        }
        if (this.d) {
            this.c |= 1024;
        }
        if (this.e) {
            this.c |= 2048;
        }
        s0.f(this.c, bArr, 0);
        return bArr;
    }

    public b1() {
        super(z0.R);
        this.c = 1217;
    }
}
