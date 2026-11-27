package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class g3 implements j6 {
    g3() {
    }

    private static n.a.a.n.c.r1.w0 a(f3 f3Var, n.a.a.n.c.r1.j jVar, n.a.a.n.c.r1.j[] jVarArr, z3[] z3VarArr) throws n.a.a.n.c.r1.p {
        boolean z;
        int iA = jVarArr[0].a();
        int width = jVarArr[0].getWidth();
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < jVarArr.length; i4++) {
                    n.a.a.n.c.r1.j jVar2 = jVarArr[i4];
                    z3 z3Var = z3VarArr[i4];
                    if (z3Var == null || !z3Var.a(jVar2.k(i2, i3))) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    if (jVar != null) {
                        n.a.a.n.c.r1.w0 w0VarK = jVar.k(i2, i3);
                        if (w0VarK instanceof n.a.a.n.c.r1.o) {
                            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0VarK);
                        }
                        f3Var.b(w0VarK);
                    } else {
                        f3Var.b(null);
                    }
                }
            }
        }
        return f3Var.a();
    }

    protected static n.a.a.n.c.r1.j b(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            return (n.a.a.n.c.r1.j) w0Var;
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, 0, 0, 0);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static void f(z3[] z3VarArr) throws n.a.a.n.c.r1.p {
        for (z3 z3Var : z3VarArr) {
            if (z3Var instanceof h4) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.w(((h4) z3Var).g()));
            }
        }
    }

    private static void g(n.a.a.n.c.r1.j jVar, n.a.a.n.c.r1.j[] jVarArr) throws n.a.a.n.c.r1.p {
        int iA = jVarArr[0].a();
        int width = jVarArr[0].getWidth();
        if (jVar != null && (jVar.a() != iA || jVar.getWidth() != width)) {
            throw n.a.a.n.c.r1.p.c();
        }
        for (n.a.a.n.c.r1.j jVar2 : jVarArr) {
            if (jVar2.a() != iA || jVar2.getWidth() != width) {
                throw n.a.a.n.c.r1.p.c();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        ?? E = e();
        if (w0VarArr.length < E + 2 || w0VarArr.length % 2 != E) {
            return n.a.a.n.c.r1.o.e;
        }
        n.a.a.n.c.r1.j jVarB = null;
        int i2 = 0;
        if (E != 0) {
            try {
                jVarB = b(w0VarArr[0]);
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            }
        }
        int length = (w0VarArr.length - E) / 2;
        n.a.a.n.c.r1.j[] jVarArr = new n.a.a.n.c.r1.j[length];
        z3[] z3VarArr = new z3[length];
        for (int i3 = E; i3 < w0VarArr.length - 1; i3 += 2) {
            jVarArr[i2] = b(w0VarArr[i3]);
            z3VarArr[i2] = l4.m(w0VarArr[i3 + 1], t0Var.t(), t0Var.k());
            i2++;
        }
        g(jVarB, jVarArr);
        f(z3VarArr);
        return a(d(), jVarB, jVarArr, z3VarArr);
    }

    protected abstract f3 d();

    protected abstract boolean e();
}
