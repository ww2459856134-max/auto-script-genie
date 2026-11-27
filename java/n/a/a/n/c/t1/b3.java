package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class b3 extends g3 {
    public static final j6 a = new b3();

    @Override // n.a.a.n.c.t1.g3, n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) throws n.a.a.n.c.r1.p {
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            n.a.a.n.c.r1.j jVarB = g3.b(w0VarArr[0]);
            if (w0VarArr.length == 3) {
                jVarB = g3.b(w0VarArr[2]);
            }
            n.a.a.n.c.r1.j jVarB2 = g3.b(w0VarArr[0]);
            z3 z3VarM = l4.m(w0VarArr[1], t0Var.t(), t0Var.k());
            if (z3VarM instanceof h4) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.w(((h4) z3VarM).g()));
            }
            return h(d(), jVarB, jVarB2, z3VarM);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.g3
    protected f3 d() {
        return new a3(this);
    }

    @Override // n.a.a.n.c.t1.g3
    protected boolean e() {
        return false;
    }

    protected n.a.a.n.c.r1.w0 h(f3 f3Var, n.a.a.n.c.r1.j jVar, n.a.a.n.c.r1.j jVar2, z3 z3Var) throws n.a.a.n.c.r1.p {
        int iA = jVar2.a();
        int width = jVar2.getWidth();
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                n.a.a.n.c.r1.w0 w0VarK = jVar2.k(i2, i3);
                n.a.a.n.c.r1.w0 w0VarK2 = jVar.k(i2, i3);
                if (z3Var != null && z3Var.a(w0VarK)) {
                    if (w0VarK instanceof n.a.a.n.c.r1.o) {
                        throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0VarK);
                    }
                    f3Var.b(w0VarK2);
                }
            }
        }
        return f3Var.a();
    }
}
