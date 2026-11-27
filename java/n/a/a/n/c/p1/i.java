package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class i implements j6 {
    public static final j6 b = new i(0);
    public static final j6 c = new i(1);
    private final int a;

    private i(int i2) {
        this.a = i2;
    }

    private static int a(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, i2, (short) i3));
        if (dE < 0.0d) {
            dE = -dE;
        }
        return Math.toIntExact(((long) Math.floor(dE)) & 1);
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length != 1) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            return n.a.a.n.c.r1.m.v(a(w0VarArr[0], t0Var.t(), t0Var.k()) == this.a);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
