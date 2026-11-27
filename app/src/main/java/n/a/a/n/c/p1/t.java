package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class t implements j6 {
    public static final j6 b = new t(c.a);
    private c a;

    private t(c cVar) {
        this.a = cVar;
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length < 2 || w0VarArr.length > 3) {
            return n.a.a.n.c.r1.o.e;
        }
        int iT = t0Var.t();
        int iK = t0Var.k();
        try {
            return new n.a.a.n.c.r1.x(n.a.a.n.d.y.f(s.a.d(this.a.a(w0VarArr[0], iT, iK), (int) Math.floor(this.a.c(w0VarArr[1], iT, iK)), this.a.b(w0VarArr.length == 3 ? w0VarArr[2] : null, iT, iK))));
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
