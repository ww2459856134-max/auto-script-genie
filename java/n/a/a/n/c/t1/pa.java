package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class pa implements j6 {
    public static final j6 a = new pa();

    private pa() {
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        int iK = t0Var.k();
        int iT = t0Var.t();
        n.a.a.n.c.r1.w0 w0VarM = null;
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            if (w0Var instanceof n.a.a.n.c.r1.k) {
                n.a.a.n.c.r1.k kVar = (n.a.a.n.c.r1.k) w0Var;
                if (kVar.u(iT, iK)) {
                    if (w0VarM != null) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    w0VarM = kVar.m(iT, iK);
                } else if (kVar.l(iT)) {
                    if (w0VarM != null) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    w0VarM = kVar.m(iT, kVar.getFirstColumn());
                } else if (!kVar.i(iK)) {
                    continue;
                } else {
                    if (w0VarM != null) {
                        return n.a.a.n.c.r1.o.e;
                    }
                    w0VarM = kVar.m(kVar.getFirstRow(), iK);
                }
            }
        }
        return w0VarM != null ? w0VarM : n.a.a.n.c.r1.o.e;
    }
}
