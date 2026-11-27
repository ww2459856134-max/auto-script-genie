package i.b.ha.a.e.a;

import i.b.ha.a.e.b.k;
import i.b.ha.a.e.b.o;
import i.b.ha.a.e.g.j;

/* loaded from: classes.dex */
public class d extends b {
    private static final double f = j.B(2.0d);
    private final double c;
    private final double d;
    private final double e;

    public d(double d, double d2) throws k {
        this(d, d2, 1.0E-9d);
    }

    public double a(double d) {
        double d2 = d - this.c;
        double dA = j.a(d2);
        double d3 = this.d;
        return dA > 40.0d * d3 ? d2 < 0.0d ? 0.0d : 1.0d : i.b.ha.a.e.e.e.b((-d2) / (d3 * f)) * 0.5d;
    }

    public double b(double d) {
        return j.h(d(d));
    }

    public double c(double d) throws o {
        if (d < 0.0d || d > 1.0d) {
            throw new o(Double.valueOf(d), 0, 1);
        }
        return this.c + (this.d * f * i.b.ha.a.e.e.e.a((d * 2.0d) - 1.0d));
    }

    public double d(double d) {
        double d2 = (d - this.c) / this.d;
        return (((-0.5d) * d2) * d2) - this.e;
    }

    public d(double d, double d2, double d3) throws k {
        this(new i.b.ha.a.e.d.d(), d, d2, d3);
    }

    public d(i.b.ha.a.e.d.c cVar, double d, double d2, double d3) throws k {
        super(cVar);
        if (d2 > 0.0d) {
            this.c = d;
            this.d = d2;
            this.e = j.k(d2) + (j.k(6.283185307179586d) * 0.5d);
            return;
        }
        throw new k(i.b.ha.a.e.b.p.d.STANDARD_DEVIATION, Double.valueOf(d2));
    }
}
