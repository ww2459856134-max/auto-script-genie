package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class r2 extends c6 {
    private final boolean a;

    protected r2(boolean z) {
        this.a = z;
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var2, i2, i3));
            if (dE < 1.0d) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            int iCeil = (int) Math.ceil(dE);
            try {
                double[] dArrP = u2.p(w0Var);
                if (iCeil > dArrP.length) {
                    return n.a.a.n.c.r1.o.f2385h;
                }
                double dC = this.a ? ta.c(dArrP, iCeil) : ta.d(dArrP, iCeil);
                y9.a(dC);
                return new n.a.a.n.c.r1.x(dC);
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            }
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
