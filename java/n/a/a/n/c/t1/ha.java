package n.a.a.n.c.t1;

import java.util.Iterator;

/* loaded from: classes.dex */
public class ha extends dc {
    private static n.a.a.n.c.r1.j l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.j) {
            return (n.a.a.n.c.r1.j) w0Var;
        }
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            return ((n.a.a.n.c.r1.c0) w0Var).c(0, 0, 0, 0);
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    private static n.a.a.n.c.r1.w0 m(double d, n.a.a.n.c.r1.j jVar, boolean z) {
        int iA = jVar.a();
        int width = jVar.getWidth();
        int i2 = 1;
        for (int i3 = 0; i3 < iA; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                Double dO = o(jVar, i3, i4);
                if (dO != null && ((z && dO.doubleValue() > d) || (!z && dO.doubleValue() < d))) {
                    i2++;
                }
            }
        }
        return new n.a.a.n.c.r1.x(i2);
    }

    private static n.a.a.n.c.r1.w0 n(double d, n.a.a.n.c.r1.e0 e0Var, boolean z) {
        Iterator<n.a.a.n.c.r1.w0> it = e0Var.v().iterator();
        int i2 = 1;
        while (it.hasNext()) {
            n.a.a.n.c.r1.w0 next = it.next();
            if (next instanceof n.a.a.n.c.r1.c0) {
                n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) next;
                next = c0Var.o(c0Var.g());
            }
            if (next instanceof n.a.a.n.c.r1.x) {
                double dR = ((n.a.a.n.c.r1.x) next).r();
                if ((z && dR > d) || (!z && dR < d)) {
                    i2++;
                }
            }
        }
        return new n.a.a.n.c.r1.x(i2);
    }

    private static Double o(n.a.a.n.c.r1.j jVar, int i2, int i3) {
        n.a.a.n.c.r1.w0 w0VarK = jVar.k(i2, i3);
        if (w0VarK instanceof n.a.a.n.c.r1.x) {
            return Double.valueOf(((n.a.a.n.c.r1.x) w0VarK).r());
        }
        return null;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) throws n.a.a.n.c.r1.p {
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            if (Double.isNaN(dE) || Double.isInfinite(dE)) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
            }
            int iF = n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var3, i2, i3));
            boolean z = true;
            if (iF != 0) {
                if (iF != 1) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
                }
                z = false;
            }
            return w0Var2 instanceof n.a.a.n.c.r1.e0 ? n(dE, (n.a.a.n.c.r1.e0) w0Var2, z) : m(dE, l(w0Var2), z);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) throws n.a.a.n.c.r1.p {
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            if (Double.isNaN(dE) || Double.isInfinite(dE)) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
            }
            return w0Var2 instanceof n.a.a.n.c.r1.e0 ? n(dE, (n.a.a.n.c.r1.e0) w0Var2, true) : m(dE, l(w0Var2), true);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
