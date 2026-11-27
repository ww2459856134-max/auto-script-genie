package n.a.a.n.c.p1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.y9;

/* loaded from: classes.dex */
final class g implements j6 {
    public static final j6 a = new g();

    private g() {
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) throws n.a.a.n.c.r1.p {
        if (w0VarArr.length != 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k()));
            double dE2 = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[1], t0Var.t(), t0Var.k()));
            double dDoubleValue = 0.0d;
            if (dE2 != 0.0d) {
                if (dE * dE2 < 0.0d) {
                    throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
                }
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(dE2);
                dDoubleValue = bigDecimalValueOf.multiply(BigDecimal.valueOf(dE).divide(bigDecimalValueOf, 0, RoundingMode.HALF_UP)).doubleValue();
            }
            y9.a(dDoubleValue);
            return new n.a.a.n.c.r1.x(dDoubleValue);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
