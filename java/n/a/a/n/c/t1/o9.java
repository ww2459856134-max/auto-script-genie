package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class o9 extends e6 implements j6 {
    public static final o9 a = new o9();

    private o9() {
    }

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    static double b(double d, double d2, double d3, boolean z) {
        i.b.ha.a.e.a.d dVar = new i.b.ha.a.e.a.d(d2, d3);
        return z ? dVar.a(d) : dVar.b(d);
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 4 ? j(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1], w0VarArr[2], w0VarArr[3]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.o6
    public n.a.a.n.c.r1.w0 j(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4) {
        try {
            Double dA = a(w0Var, i2, i3);
            if (dA == null) {
                return n.a.a.n.c.r1.o.e;
            }
            Double dA2 = a(w0Var2, i2, i3);
            if (dA2 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            Double dA3 = a(w0Var3, i2, i3);
            if (dA3 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            if (dA3.doubleValue() <= 0.0d) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            Boolean boolD = n.a.a.n.c.r1.z.d(w0Var4, false);
            return boolD == null ? n.a.a.n.c.r1.o.e : new n.a.a.n.c.r1.x(b(dA.doubleValue(), dA2.doubleValue(), dA3.doubleValue(), boolD.booleanValue()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
