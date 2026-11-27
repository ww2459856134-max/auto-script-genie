package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class gb extends d6 implements j6 {
    public static final gb a = new gb();

    private static Boolean a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.d(n.a.a.n.c.r1.z.i(w0Var, i2, i3), false);
    }

    private static Double b(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    private static double d(double d, int i2) {
        return new i.b.ha.a.e.a.g(null, i2).a(d);
    }

    private static double f(double d, int i2) {
        return new i.b.ha.a.e.a.g(null, i2).b(d);
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 3 ? e(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1], w0VarArr[2]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            Double dB = b(w0Var, i2, i3);
            if (dB == null) {
                return n.a.a.n.c.r1.o.e;
            }
            Double dB2 = b(w0Var2, i2, i3);
            if (dB2 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            int iIntValue = dB2.intValue();
            if (iIntValue < 1) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            Boolean boolA = a(w0Var3, i2, i3);
            return boolA == null ? n.a.a.n.c.r1.o.e : boolA.booleanValue() ? new n.a.a.n.c.r1.x(d(dB.doubleValue(), iIntValue)) : new n.a.a.n.c.r1.x(f(dB.doubleValue(), iIntValue));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
