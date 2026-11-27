package n.a.a.n.c.t1;

import java.math.BigDecimal;
import java.math.MathContext;

/* loaded from: classes.dex */
public final class p4 implements u6 {
    private long a;
    private double b;

    private static double d(double d, long j2) {
        return BigDecimal.valueOf(d).divide(BigDecimal.valueOf(j2), MathContext.DECIMAL128).doubleValue();
    }

    private double e() {
        return d(this.b, this.a);
    }

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        return this.a == 0 ? n.a.a.n.c.r1.x.c : new n.a.a.n.c.r1.x(e());
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return true;
        }
        this.a++;
        this.b += ((n.a.a.n.c.r1.y) w0Var).r();
        return true;
    }
}
