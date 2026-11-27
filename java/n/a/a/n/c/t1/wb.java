package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class wb extends d6 {
    private static int a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        if (w0Var == n.a.a.n.c.r1.u.a) {
            return 0;
        }
        return n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
    }

    private static double b(int i2, int i3, int i4) throws n.a.a.n.c.r1.p {
        if (i2 > 32767 || i3 > 32767 || i4 > 32767) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        if ((i2 * 3600) + (i3 * 60) + i4 >= 0) {
            return (r2 % 86400) / 86400.0d;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            return new n.a.a.n.c.r1.x(b(a(w0Var, i2, i3), a(w0Var2, i2, i3), a(w0Var3, i2, i3)));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
