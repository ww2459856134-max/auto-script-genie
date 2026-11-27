package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class q9 extends b6 implements j6 {
    public static final q9 a = new q9();

    private q9() {
    }

    private static Double l(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length == 1 ? m(t0Var.t(), t0Var.k(), w0VarArr[0]) : n.a.a.n.c.r1.o.e;
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            Double dL = l(w0Var, i2, i3);
            return dL == null ? n.a.a.n.c.r1.o.e : dL.doubleValue() < 0.0d ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(o9.b(dL.doubleValue(), 0.0d, 1.0d, true));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
