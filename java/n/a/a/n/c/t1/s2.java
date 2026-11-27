package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class s2 extends c6 {
    protected s2() {
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        double d;
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var2, i2, i3));
            if (dE < 0.0d || dE > 1.0d) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            try {
                double[] dArrP = u2.p(w0Var);
                int length = dArrP.length;
                if (length != 0 && length <= 8191) {
                    double d2 = ((length - 1) * dE) + 1.0d;
                    if (d2 == 1.0d) {
                        d = ta.d(dArrP, 1);
                    } else if (Double.compare(d2, length) == 0) {
                        d = ta.c(dArrP, 1);
                    } else {
                        int i4 = (int) d2;
                        d = ta.d(dArrP, i4) + ((d2 - i4) * (ta.d(dArrP, i4 + 1) - ta.d(dArrP, i4)));
                    }
                    y9.a(d);
                    return new n.a.a.n.c.r1.x(d);
                }
                return n.a.a.n.c.r1.o.f2385h;
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            }
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
