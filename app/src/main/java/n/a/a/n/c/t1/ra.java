package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class ra implements j6 {
    public static final ra a = new ra();

    private n.a.a.n.c.r1.w0 a(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            return b(dE) ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(Double.parseDouble(n.a.a.n.e.c0.h(Math.sqrt(dE * 3.141592653589793d))));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private boolean b(double d) {
        return d < 0.0d;
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : a(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }
}
