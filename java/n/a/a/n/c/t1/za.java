package n.a.a.n.c.t1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class za implements p6 {
    private static boolean a(n.a.a.n.c.j1[] j1VarArr, int i2, int i3) {
        for (n.a.a.n.c.j1 j1Var : j1VarArr) {
            if (j1Var.a() != i2 || j1Var.getWidth() != i3) {
                return false;
            }
        }
        return true;
    }

    private static n.a.a.n.c.r1.w0 b(n.a.a.n.c.r1.w0[] w0VarArr) throws n.a.a.n.c.r1.p {
        int length = w0VarArr.length;
        try {
            n.a.a.n.c.j1[] j1VarArr = (n.a.a.n.c.j1[]) Arrays.copyOf(w0VarArr, length, n.a.a.n.c.j1[].class);
            n.a.a.n.c.j1 j1Var = j1VarArr[0];
            int iA = j1Var.a();
            int width = j1Var.getWidth();
            if (!a(j1VarArr, iA, width)) {
                for (int i2 = 1; i2 < j1VarArr.length; i2++) {
                    h(j1VarArr[i2]);
                }
                return n.a.a.n.c.r1.o.e;
            }
            double d = 0.0d;
            for (int i3 = 0; i3 < iA; i3++) {
                for (int i4 = 0; i4 < width; i4++) {
                    double d2 = 1.0d;
                    for (int i5 = 0; i5 < length; i5++) {
                        d2 *= d(j1VarArr[i5].p(i3, i4), false);
                    }
                    d += d2;
                }
            }
            return new n.a.a.n.c.r1.x(d);
        } catch (ArrayStoreException unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }

    private static n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr) throws n.a.a.n.c.r1.p {
        int length = w0VarArr.length;
        double dF = 1.0d;
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            dF *= f(w0Var);
        }
        return new n.a.a.n.c.r1.x(dF);
    }

    private static double d(n.a.a.n.c.r1.w0 w0Var, boolean z) throws n.a.a.n.c.r1.p {
        if ((w0Var instanceof n.a.a.n.c.r1.l) || w0Var == null) {
            if (z) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            return 0.0d;
        }
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        if (w0Var instanceof n.a.a.n.c.r1.m0) {
            if (z) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            return 0.0d;
        }
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            return ((n.a.a.n.c.r1.y) w0Var).r();
        }
        throw new IllegalStateException("Unexpected value eval class (" + w0Var.getClass().getName() + ")");
    }

    private static double f(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            if (c0Var.t() > 1) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            w0Var = c0Var.o(c0Var.g());
        }
        if (w0Var == null) {
            throw new IllegalStateException("parameter may not be null");
        }
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
            if (!jVar.s() || !jVar.q()) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            w0Var = jVar.k(0, 0);
        }
        return d(w0Var, true);
    }

    private static void h(n.a.a.n.c.j1 j1Var) throws n.a.a.n.c.r1.p {
        int iA = j1Var.a();
        int width = j1Var.getWidth();
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                n.a.a.n.c.r1.w0 w0VarP = j1Var.p(i2, i3);
                if (w0VarP instanceof n.a.a.n.c.r1.o) {
                    throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0VarP);
                }
            }
        }
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        n.a.a.n.c.r1.w0 w0Var = w0VarArr[0];
        try {
            if (w0Var instanceof n.a.a.n.c.r1.y) {
                return c(w0VarArr);
            }
            if (w0Var instanceof n.a.a.n.c.r1.c0) {
                return c(w0VarArr);
            }
            if (w0Var instanceof n.a.a.n.c.j1) {
                n.a.a.n.c.j1 j1Var = (n.a.a.n.c.j1) w0Var;
                return (j1Var.q() && j1Var.s()) ? c(w0VarArr) : b(w0VarArr);
            }
            throw new IllegalStateException("Invalid arg type for SUMPRODUCT: (" + w0Var.getClass().getName() + ")");
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
