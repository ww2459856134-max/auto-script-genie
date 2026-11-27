package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class fb extends d6 implements j6 {
    public static final fb a = new fb();

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    static double b(double d, int i2) {
        return 1.0d - new i.b.ha.a.e.a.g(null, i2).a(d);
    }

    static double d(double d, int i2) {
        return b(d, i2) * 2.0d;
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 3 ? e(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1], w0VarArr[2]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            Double dA = a(w0Var, i2, i3);
            if (dA == null) {
                return n.a.a.n.c.r1.o.e;
            }
            if (dA.doubleValue() < 0.0d) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            Double dA2 = a(w0Var2, i2, i3);
            if (dA2 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            int iIntValue = dA2.intValue();
            if (iIntValue < 1) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            Double dA3 = a(w0Var3, i2, i3);
            if (dA3 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            int iIntValue2 = dA3.intValue();
            return (iIntValue2 == 1 || iIntValue2 == 2) ? iIntValue2 == 2 ? new n.a.a.n.c.r1.x(d(dA.doubleValue(), iIntValue)) : new n.a.a.n.c.r1.x(b(dA.doubleValue(), iIntValue)) : n.a.a.n.c.r1.o.f2385h;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
