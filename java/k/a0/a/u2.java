package k.a0.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
public class u2 extends b implements k.p, k.x.o0, k.q {
    private static DecimalFormat r;
    private double p;
    private NumberFormat q;

    static {
        k.y.c.b(u2.class);
        r = new DecimalFormat("#.###");
    }

    public u2(f2 f2Var, j0 j0Var, double d, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, tVar, a1Var, y2Var, j0Var.c());
        this.p = d;
        this.q = r;
    }

    public NumberFormat F() {
        return this.q;
    }

    final void G(NumberFormat numberFormat) {
        if (numberFormat != null) {
            this.q = numberFormat;
        }
    }

    @Override // k.c
    public k.f getType() {
        return k.f.g;
    }

    @Override // k.p
    public double getValue() {
        return this.p;
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
        k.x.c0.a(this.p, bArr, 6);
        System.arraycopy(bArrA, 0, bArr, 22, bArrA.length);
        k.x.s0.f(bArrA.length, bArr, 20);
        int i2 = length - 6;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 6, bArr2, 0, i2);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return !Double.isNaN(this.p) ? this.q.format(this.p) : "";
    }
}
