package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class p9 extends d6 implements j6 {
    public static final p9 a = new p9();

    private p9() {
    }

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    static double b(double d, double d2, double d3) {
        return new i.b.ha.a.e.a.d(d2, d3).c(d);
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
            if (dA.doubleValue() > 0.0d && dA.doubleValue() < 1.0d) {
                Double dA2 = a(w0Var2, i2, i3);
                if (dA2 == null) {
                    return n.a.a.n.c.r1.o.e;
                }
                Double dA3 = a(w0Var3, i2, i3);
                return dA3 == null ? n.a.a.n.c.r1.o.e : dA3.doubleValue() <= 0.0d ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(b(dA.doubleValue(), dA2.doubleValue(), dA3.doubleValue()));
            }
            return n.a.a.n.c.r1.o.f2385h;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
