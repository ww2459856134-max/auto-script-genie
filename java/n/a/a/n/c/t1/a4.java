package n.a.a.n.c.t1;

/* loaded from: classes.dex */
abstract class a4 {
    public static int a(n.a.a.n.c.r1.w0 w0Var, z3 z3Var) {
        if (w0Var == null) {
            throw new IllegalArgumentException("eval must not be null");
        }
        if (w0Var instanceof n.a.a.n.c.i1) {
            return b((n.a.a.n.c.i1) w0Var, z3Var);
        }
        if (w0Var instanceof n.a.a.n.c.j1) {
            throw new IllegalArgumentException("Count requires 3D Evals, 2D ones aren't supported");
        }
        return w0Var instanceof n.a.a.n.c.r1.c0 ? c((n.a.a.n.c.r1.c0) w0Var, z3Var) : z3Var.a(w0Var) ? 1 : 0;
    }

    public static int b(n.a.a.n.c.i1 i1Var, z3 z3Var) {
        int iD = i1Var.d();
        int i2 = 0;
        for (int iG = i1Var.g(); iG <= iD; iG++) {
            int iA = i1Var.a();
            int width = i1Var.getWidth();
            for (int i3 = 0; i3 < iA; i3++) {
                for (int i4 = 0; i4 < width; i4++) {
                    n.a.a.n.c.r1.w0 w0VarJ = i1Var.j(iG, i3, i4);
                    if ((!(z3Var instanceof y3) || ((y3) z3Var).b(i1Var, i3, i4)) && z3Var.a(w0VarJ)) {
                        i2++;
                    }
                }
            }
        }
        return i2;
    }

    public static int c(n.a.a.n.c.r1.c0 c0Var, z3 z3Var) {
        int iD = c0Var.d();
        int i2 = 0;
        for (int iG = c0Var.g(); iG <= iD; iG++) {
            if (z3Var.a(c0Var.o(iG))) {
                i2++;
            }
        }
        return i2;
    }
}
