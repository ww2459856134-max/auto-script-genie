package n.a.a.n.c.t1;

import java.math.RoundingMode;

/* loaded from: classes.dex */
public final class n3 implements j6 {
    public static final n3 a = new n3();

    private n3() {
    }

    private static Double a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.k(n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, i2, i3)));
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        Double dA;
        Double dA2;
        if (w0VarArr.length == 0) {
            return n.a.a.n.c.r1.o.e;
        }
        boolean z = false;
        try {
            Double dA3 = a(w0VarArr[0], t0Var.t(), t0Var.k());
            if (dA3 == null) {
                return n.a.a.n.c.r1.o.e;
            }
            double dDoubleValue = (w0VarArr.length <= 1 || (dA2 = a(w0VarArr[1], t0Var.t(), t0Var.k())) == null) ? 1.0d : dA2.doubleValue();
            if (w0VarArr.length > 2 && (dA = a(w0VarArr[2], t0Var.t(), t0Var.k())) != null && dA.doubleValue() < 0.0d) {
                z = true;
            }
            if (!z || dA3.doubleValue() >= 0.0d) {
                if (dDoubleValue != 1.0d) {
                    return new n.a.a.n.c.r1.x(q8.v(dA3.doubleValue(), dDoubleValue, dDoubleValue < 0.0d ? RoundingMode.FLOOR : RoundingMode.CEILING));
                }
                return new n.a.a.n.c.r1.x(Math.ceil(dA3.doubleValue()));
            }
            if (dDoubleValue != 1.0d) {
                return new n.a.a.n.c.r1.x(q8.v(dA3.doubleValue(), dDoubleValue, dDoubleValue < 0.0d ? RoundingMode.CEILING : RoundingMode.FLOOR));
            }
            return new n.a.a.n.c.r1.x(Math.floor(dA3.doubleValue()));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
