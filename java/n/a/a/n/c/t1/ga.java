package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class ga extends c6 implements j6 {
    public static final j6 a = new ga();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 2 ? n.a.a.n.c.r1.o.e : i(t0Var.t(), t0Var.k(), w0VarArr[0], w0VarArr[1]);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
            try {
                return n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var2, i2, i3)) == 0.0d ? n.a.a.n.c.r1.o.d : new n.a.a.n.c.r1.x((int) (dE / r3));
            } catch (n.a.a.n.c.r1.p unused) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p unused2) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
