package k.a0.a;

import java.util.Date;

/* loaded from: classes.dex */
public class r2 extends b implements k.g, k.x.o0, k.h {
    private v p;
    private double q;

    public r2(u2 u2Var, k.x.n0 n0Var, boolean z, y2 y2Var, int i2) {
        super(u2Var.x(), n0Var, u2Var.A(), u2Var.C(), y2Var, i2);
        this.p = new v(u2Var, u2Var.z(), n0Var, z, y2Var);
        this.q = u2Var.getValue();
    }

    @Override // k.g
    public Date getDate() {
        return this.p.getDate();
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1990h;
    }

    @Override // k.g
    public boolean i() {
        return this.p.i();
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().y().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        k.x.j1.x xVar = new k.x.j1.x(D(), this, A(), C(), y().x().A());
        xVar.c();
        byte[] bArrA = xVar.a();
        int length = bArrA.length + 22;
        byte[] bArr = new byte[length];
        k.x.s0.f(getRow(), bArr, 0);
        k.x.s0.f(b(), bArr, 2);
        k.x.s0.f(z(), bArr, 4);
        k.x.c0.a(this.q, bArr, 6);
        System.arraycopy(bArrA, 0, bArr, 22, bArrA.length);
        k.x.s0.f(bArrA.length, bArr, 20);
        int i2 = length - 6;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 6, bArr2, 0, i2);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return this.p.p();
    }
}
