package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class l5 extends c6 implements j6 {
    public static final j6 a = new l5();
    private static final n.a.a.n.c.r1.x b = new n.a.a.n.c.r1.x(1.0d);
    private static final n.a.a.n.c.r1.x c = new n.a.a.n.c.r1.x(0.0d);

    private static Double l(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 2 ? i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            Double dL = l(w0Var, i2, i3);
            if (dL == null) {
                return n.a.a.n.c.r1.o.e;
            }
            Double dL2 = l(w0Var2, i2, i3);
            return dL2 == null ? n.a.a.n.c.r1.o.e : dL.compareTo(dL2) == 0 ? b : c;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
