package n.a.a.n.c.r1;

import java.math.BigDecimal;
import java.math.MathContext;

/* loaded from: classes.dex */
final class p0 extends t0 {
    p0() {
    }

    @Override // n.a.a.n.c.r1.t0
    protected double l(double d, double d2) throws p {
        if (d2 != 0.0d) {
            return new BigDecimal(n.a.a.n.e.c0.h(d)).divide(new BigDecimal(n.a.a.n.e.c0.h(d2)), MathContext.DECIMAL128).doubleValue();
        }
        throw new p(o.d);
    }
}
