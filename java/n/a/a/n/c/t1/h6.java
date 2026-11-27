package n.a.a.n.c.t1;

import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class h6 implements j6 {
    public static final h6 a = new h6();

    private h6() {
    }

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        Double dA;
        if (w0VarArr.length == 0) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            Double dA2 = a(w0VarArr[0], t0Var.t(), t0Var.k());
            if (dA2 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            double dAbs = (w0VarArr.length <= 1 || (dA = a(w0VarArr[1], t0Var.t(), t0Var.k())) == null) ? 1.0d : Math.abs(dA.doubleValue());
            return dAbs != 1.0d ? new n.a.a.n.c.r1.x(q8.v(dA2.doubleValue(), dAbs, RoundingMode.FLOOR)) : new n.a.a.n.c.r1.x(Math.floor(dA2.doubleValue()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
