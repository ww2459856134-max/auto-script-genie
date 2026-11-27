package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
public final class e implements j6 {
    public static final j6 a = new e();

    private e() {
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            return n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k());
        } catch (n.a.a.n.c.r1.p e) {
            n.a.a.n.c.r1.o oVarA = e.a();
            if (oVarA != n.a.a.n.c.r1.o.f2386i) {
                return oVarA;
            }
            try {
                return n.a.a.n.c.r1.z.i(w0VarArr[1], t0Var.t(), t0Var.k());
            } catch (n.a.a.n.c.r1.p e2) {
                return e2.a();
            }
        }
    }
}
