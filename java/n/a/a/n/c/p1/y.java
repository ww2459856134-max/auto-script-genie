package n.a.a.n.c.p1;

import n.a.a.n.c.r1.m0;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class y implements j6 {
    public static final j6 a = new y();

    private y() {
    }

    private static double a(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, (short) i3);
        if (!(w0VarI instanceof m0)) {
            return n.a.a.n.c.r1.z.e(w0VarI);
        }
        String stringValue = ((m0) w0VarI).getStringValue();
        Double dK = n.a.a.n.c.r1.z.k(stringValue);
        return dK != null ? dK.doubleValue() : n.a.a.n.d.y.e(n.a.a.n.e.u.a(stringValue), false);
    }

    private static int b(w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, (short) i3));
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        int iB;
        int iT = t0Var.t();
        int iK = t0Var.k();
        try {
            int length = w0VarArr.length;
            if (length == 2) {
                iB = 0;
            } else {
                if (length != 3) {
                    return n.a.a.n.c.r1.o.e;
                }
                iB = b(w0VarArr[2], iT, iK);
            }
            return new n.a.a.n.c.r1.x(a0.g(a(w0VarArr[0], iT, iK), a(w0VarArr[1], iT, iK), iB));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
