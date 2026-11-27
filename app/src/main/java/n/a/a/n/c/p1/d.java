package n.a.a.n.c.p1;

import n.a.a.n.c.n1;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class d implements j6 {
    public static final j6 a = new d();

    private d() {
    }

    private static w0 a(w0 w0Var, w0 w0Var2, int i2, int i3) throws n.a.a.n.c.r1.p {
        w0 w0VarD = n1.d(w0Var, i2, i3);
        return w0VarD instanceof n.a.a.n.c.r1.o ? w0Var2 : w0VarD;
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            return a(w0VarArr[0], w0VarArr[1], t0Var.t(), t0Var.k());
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
