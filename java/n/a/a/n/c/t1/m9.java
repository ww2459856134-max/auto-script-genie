package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class m9 implements p6 {
    private static final int e = n.a.a.n.a.EXCEL2007.e();
    private k9<n.a.a.n.c.r1.m, o5> a;
    private k9<n.a.a.n.c.r1.m, o5> b;
    private k9<n.a.a.n.c.r1.l, o5> c;
    private k9<n.a.a.n.c.r1.u, o5> d;

    protected m9(boolean z, boolean z2) {
        l9 l9Var = l9.SKIP;
        this.d = j9.d(l9Var);
        this.a = j9.c(z ? l9.COERCE : l9Var);
        l9 l9Var2 = l9.COERCE;
        this.b = j9.c(l9Var2);
        this.c = j9.b(z2 ? l9Var2 : l9Var);
    }

    private void a(n.a.a.n.c.r1.w0 w0Var, boolean z, o5 o5Var) throws n.a.a.n.c.r1.p {
        if (w0Var == null) {
            throw new IllegalArgumentException("ve must not be null");
        }
        if (w0Var instanceof n.a.a.n.c.r1.m) {
            n.a.a.n.c.r1.m mVar = (n.a.a.n.c.r1.m) w0Var;
            if (z) {
                this.a.accept(mVar, o5Var);
                return;
            } else {
                this.b.accept(mVar, o5Var);
                return;
            }
        }
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            o5Var.a(((n.a.a.n.c.r1.y) w0Var).r());
            return;
        }
        if (w0Var instanceof n.a.a.n.c.r1.n0) {
            if (z) {
                return;
            }
            if (o()) {
                o5Var.a(0.0d);
                return;
            }
            Double dK = n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.n0) w0Var).getStringValue().trim());
            if (dK == null) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            o5Var.a(dK.doubleValue());
            return;
        }
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        if (w0Var == n.a.a.n.c.r1.l.a) {
            this.c.accept((n.a.a.n.c.r1.l) w0Var, o5Var);
        } else {
            if (w0Var == n.a.a.n.c.r1.u.a) {
                this.d.accept((n.a.a.n.c.r1.u) w0Var, o5Var);
                return;
            }
            throw new IllegalStateException("Invalid ValueEval type passed for conversion: " + w0Var);
        }
    }

    private void b(n.a.a.n.c.r1.w0 w0Var, o5 o5Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.i1) {
            n.a.a.n.c.i1 i1Var = (n.a.a.n.c.i1) w0Var;
            for (int iG = i1Var.g(); iG <= i1Var.d(); iG++) {
                int width = i1Var.getWidth();
                int iA = i1Var.a();
                for (int i2 = 0; i2 < iA; i2++) {
                    for (int i3 = 0; i3 < width; i3++) {
                        n.a.a.n.c.r1.w0 w0VarJ = i1Var.j(iG, i2, i3);
                        if ((l() || !i1Var.n(i2, i3)) && (h() || !i1Var.e(i2))) {
                            a(w0VarJ, !o(), o5Var);
                        }
                    }
                }
            }
            return;
        }
        if (!(w0Var instanceof n.a.a.n.c.j1)) {
            if (!(w0Var instanceof n.a.a.n.c.r1.c0)) {
                a(w0Var, false, o5Var);
                return;
            }
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            for (int iG2 = c0Var.g(); iG2 <= c0Var.d(); iG2++) {
                a(c0Var.o(iG2), !o(), o5Var);
            }
            return;
        }
        n.a.a.n.c.j1 j1Var = (n.a.a.n.c.j1) w0Var;
        int width2 = j1Var.getWidth();
        int iA2 = j1Var.a();
        for (int i4 = 0; i4 < iA2; i4++) {
            for (int i5 = 0; i5 < width2; i5++) {
                n.a.a.n.c.r1.w0 w0VarP = j1Var.p(i4, i5);
                if (l() || !j1Var.n(i4, i5)) {
                    a(w0VarP, !o(), o5Var);
                }
            }
        }
    }

    protected abstract double c(double[] dArr) throws n.a.a.n.c.r1.p;

    protected int d() {
        return e;
    }

    protected final double[] f(n.a.a.n.c.r1.w0[] w0VarArr) throws n.a.a.n.c.r1.p {
        if (w0VarArr.length > d()) {
            throw n.a.a.n.c.r1.p.c();
        }
        o5 o5Var = new o5();
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            b(w0Var, o5Var);
        }
        return o5Var.c();
    }

    public boolean h() {
        return true;
    }

    @Override // n.a.a.n.c.t1.p6
    public final n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        try {
            double dC = c(f(w0VarArr));
            if (!Double.isNaN(dC) && !Double.isInfinite(dC)) {
                return new n.a.a.n.c.r1.x(dC);
            }
            return n.a.a.n.c.r1.o.f2385h;
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    public boolean l() {
        return true;
    }

    public void m(l9 l9Var) {
        this.c = j9.b(l9Var);
    }

    public void n(l9 l9Var) {
        this.d = j9.d(l9Var);
    }

    protected boolean o() {
        return false;
    }
}
