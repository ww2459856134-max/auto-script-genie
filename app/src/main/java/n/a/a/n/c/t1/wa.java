package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class wa extends dc {
    private static double l(n.a.a.n.c.r1.j jVar, z3 z3Var, n.a.a.n.c.r1.j jVar2, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (!z3Var.a(jVar.k(i2, i3))) {
            return 0.0d;
        }
        n.a.a.n.c.r1.w0 w0VarK = jVar2.k(i2, i3);
        if (w0VarK instanceof n.a.a.n.c.r1.x) {
            return ((n.a.a.n.c.r1.x) w0VarK).r();
        }
        if (w0VarK instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0VarK);
        }
        return 0.0d;
    }

    private static n.a.a.n.c.r1.j m(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            return (n.a.a.n.c.r1.j) w0Var;
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, 0, 0, 0);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static n.a.a.n.c.r1.j n(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.j jVar) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            return ((n.a.a.n.c.r1.j) w0Var).c(0, jVar.a() - 1, 0, jVar.getWidth() - 1);
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, jVar.a() - 1, 0, jVar.getWidth() - 1);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static n.a.a.n.c.r1.w0 o(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.j jVar, n.a.a.n.c.r1.j jVar2) {
        z3 z3VarM = l4.m(w0Var, i2, i3);
        if (z3VarM == null) {
            return n.a.a.n.c.r1.x.c;
        }
        try {
            return new n.a.a.n.c.r1.x(p(jVar, z3VarM, jVar2));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static double p(n.a.a.n.c.r1.j jVar, z3 z3Var, n.a.a.n.c.r1.j jVar2) throws n.a.a.n.c.r1.p {
        int iA = jVar.a();
        int width = jVar.getWidth();
        double dL = 0.0d;
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                dL += l(jVar, z3Var, jVar2, i2, i3);
            }
        }
        return dL;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            n.a.a.n.c.r1.j jVarM = m(w0Var);
            return o(i2, i3, w0Var2, jVarM, n(w0Var3, jVarM));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            n.a.a.n.c.r1.j jVarM = m(w0Var);
            return o(i2, i3, w0Var2, jVarM, jVarM);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
