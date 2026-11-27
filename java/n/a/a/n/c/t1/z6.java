package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class z6 implements m6, n6, o6, z2 {
    private static n.a.a.n.c.j1 a(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, 0, 0, 0);
        }
        if (w0Var instanceof n.a.a.n.c.j1) {
            return (n.a.a.n.c.j1) w0Var;
        }
        throw new IllegalStateException("Incomplete code - cannot handle first arg of type (" + w0Var.getClass().getName() + ")");
    }

    private static n.a.a.n.c.r1.w0 b(n.a.a.n.c.j1 j1Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.j1 j1VarF;
        if (i2 == 0) {
            j1VarF = j1Var;
        } else {
            if (i2 > j1Var.a()) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
            }
            j1VarF = j1Var.f(i2 - 1);
        }
        if (i3 == 0) {
            return j1VarF;
        }
        if (i3 <= j1Var.getWidth()) {
            return j1VarF.h(i3 - 1);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f);
    }

    private static int c(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        if (w0VarI == n.a.a.n.c.r1.u.a || w0VarI == n.a.a.n.c.r1.l.a) {
            return 0;
        }
        int iF = n.a.a.n.c.r1.z.f(w0VarI);
        if (iF >= 0) {
            return iF;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            return b(a(w0Var), c(w0Var2, i2, i3), c(w0Var3, i2, i3));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        n.a.a.n.c.j1 j1VarA = a(w0Var);
        try {
            int iC = c(w0Var2, i2, i3);
            int i4 = 0;
            if (!j1VarA.s()) {
                if (!j1VarA.q()) {
                    return n.a.a.n.c.r1.o.f;
                }
                i4 = iC;
                iC = 0;
            }
            return b(j1VarA, iC, i4);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.o6
    public n.a.a.n.c.r1.w0 j(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4) {
        throw new IllegalStateException("Incomplete code - don't know how to support the 'area_num' parameter yet)");
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int length = w0VarArr.length;
        if (length == 2) {
            return i(i2, i3, w0VarArr[0], w0VarArr[1]);
        }
        if (length == 3) {
            return e(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2]);
        }
        if (length != 4) {
            return n.a.a.n.c.r1.o.e;
        }
        j(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2], w0VarArr[3]);
        throw null;
    }
}
