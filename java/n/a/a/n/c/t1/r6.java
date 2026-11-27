package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class r6 extends b6 implements j6 {
    public static final j6 a = new r6();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : m(t0Var.t(), t0Var.k(), w0VarArr[0]);
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 m(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        String strG;
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            n.a.a.n.c.r1.c0 c0Var = (n.a.a.n.c.r1.c0) w0Var;
            strG = n.a.a.n.c.r1.z.g(c0Var.o(c0Var.g()));
        } else {
            strG = n.a.a.n.c.r1.z.g(w0Var);
        }
        try {
            return new n.a.a.n.c.r1.x(e3.a(strG, 16, 10));
        } catch (IllegalArgumentException unused) {
            return n.a.a.n.c.r1.o.f2385h;
        }
    }
}
