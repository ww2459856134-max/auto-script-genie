package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class p8 extends dc {
    private static b8 l(n.a.a.n.c.r1.w0 w0Var, boolean z) {
        return n8.c(w0Var, z, true);
    }

    private static n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, double d) {
        try {
            return new n.a.a.n.c.r1.x(p(n.a.a.n.c.r1.z.i(w0Var, i2, i3), n(w0Var2), d == 0.0d, d > 0.0d) + 1.0d);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static m8 n(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            return c0Var.t() == 1 ? new o8(c0Var.o(c0Var.g())) : n8.g(c0Var);
        }
        if (w0Var instanceof n.a.a.n.c.j1) {
            m8 m8VarF = n8.f((n.a.a.n.c.j1) w0Var);
            if (m8VarF != null) {
                return m8VarF;
            }
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        if (w0Var instanceof n.a.a.n.c.r1.m0) {
            if (n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.m0) w0Var).getStringValue()) == null) {
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
            }
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        throw new IllegalStateException("Unexpected eval type (" + w0Var + ")");
    }

    private static double o(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        if (w0VarI instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0VarI);
        }
        if (w0VarI instanceof n.a.a.n.c.r1.y) {
            return ((n.a.a.n.c.r1.y) w0VarI).r();
        }
        if (w0VarI instanceof n.a.a.n.c.r1.m0) {
            Double dK = n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.m0) w0VarI).getStringValue());
            if (dK != null) {
                return dK.doubleValue();
            }
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        if ((w0VarI instanceof n.a.a.n.c.r1.u) || (w0VarI instanceof n.a.a.n.c.r1.l)) {
            return 1.0d;
        }
        throw new IllegalStateException("Unexpected match_type type (" + w0VarI.getClass().getName() + ")");
    }

    private static int p(n.a.a.n.c.r1.w0 w0Var, m8 m8Var, boolean z, boolean z2) throws n.a.a.n.c.r1.p {
        b8 b8VarL = l(w0Var, z);
        int size = m8Var.getSize();
        int i2 = 0;
        if (z) {
            while (i2 < size) {
                if (b8VarL.a(m8Var.getItem(i2)).b()) {
                    return i2;
                }
                i2++;
            }
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        if (z2) {
            for (int i3 = size - 1; i3 >= 0; i3--) {
                a8 a8VarA = b8VarL.a(m8Var.getItem(i3));
                if (!a8VarA.e() && !a8VarA.d()) {
                    return i3;
                }
            }
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
        }
        while (i2 < size) {
            a8 a8VarA2 = b8VarL.a(m8Var.getItem(i2));
            if (a8VarA2.b()) {
                return i2;
            }
            if (a8VarA2.c()) {
                if (i2 >= 1) {
                    return i2 - 1;
                }
                throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2386i);
            }
            i2++;
        }
        return size - 1;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            return m(i2, i3, w0Var, w0Var2, o(w0Var3, i2, i3));
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.f;
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        return m(i2, i3, w0Var, w0Var2, 1.0d);
    }
}
