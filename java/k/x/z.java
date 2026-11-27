package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class z extends c1 {
    private int c;
    private int d;
    private x e;
    private byte[] f;

    static {
        k.y.c.b(z.class);
    }

    public z(f2 f2Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.f = bArrC;
        this.d = s0.d(bArrC[10], bArrC[11], bArrC[12], bArrC[13]);
        byte[] bArr = this.f;
        this.c = s0.d(bArr[14], bArr[15], bArr[16], bArr[17]);
    }

    void A() {
        if (this.e == null) {
            this.e = new x(this.f);
        }
        this.e.a();
    }

    void B() {
        if (this.e == null) {
            this.e = new x(this.f);
        }
        this.e.b();
    }

    int C() {
        return this.c;
    }

    public int D() {
        x xVar = this.e;
        return xVar == null ? this.d : xVar.e();
    }

    public boolean E() {
        x xVar = this.e;
        return xVar == null || xVar.d() > 0;
    }

    @Override // k.x.c1
    public byte[] y() {
        x xVar = this.e;
        return xVar == null ? this.f : xVar.c();
    }

    public z(x xVar) {
        super(z0.e1);
        this.e = xVar;
    }

    z(z zVar) {
        super(z0.e1);
        this.f = zVar.y();
    }
}
