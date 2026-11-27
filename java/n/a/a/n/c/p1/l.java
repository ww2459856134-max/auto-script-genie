package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class l implements j6 {
    public static final j6 a = new l();

    private l() {
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k()));
            double dE2 = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[1], t0Var.t(), t0Var.k()));
            if (dE > dE2) {
                return n.a.a.n.c.r1.o.f2385h;
            }
            double dCeil = Math.ceil(dE);
            double dFloor = Math.floor(dE2);
            if (dCeil > dFloor) {
                dFloor = dCeil;
            }
            return new n.a.a.n.c.r1.x(dCeil + ((long) (Math.random() * ((dFloor - dCeil) + 1.0d))));
        } catch (n.a.a.n.c.r1.p unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
