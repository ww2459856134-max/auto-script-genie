package i.b.ha.a.e.a;

import i.b.ha.a.e.b.k;
import i.b.ha.a.e.g.j;

/* loaded from: classes.dex */
public class g extends b {
    private final double c;
    private final double d;

    public g(i.b.ha.a.e.d.c cVar, double d) throws k {
        this(cVar, d, 1.0E-9d);
    }

    public double a(double d) {
        if (d == 0.0d) {
            return 0.5d;
        }
        double d2 = this.c;
        double dE = i.b.ha.a.e.e.d.e(d2 / ((d * d) + d2), d2 * 0.5d, 0.5d);
        return d < 0.0d ? 0.5d * dE : 1.0d - (dE * 0.5d);
    }

    public double b(double d) {
        return j.h(c(d));
    }

    public double c(double d) {
        double d2 = this.c;
        return this.d - (((d2 + 1.0d) / 2.0d) * j.k(((d * d) / d2) + 1.0d));
    }

    public g(i.b.ha.a.e.d.c cVar, double d, double d2) throws k {
        super(cVar);
        if (d <= 0.0d) {
            throw new k(i.b.ha.a.e.b.p.d.DEGREES_OF_FREEDOM, Double.valueOf(d));
        }
        this.c = d;
        this.d = (i.b.ha.a.e.e.g.d((1.0d + d) / 2.0d) - ((j.k(3.141592653589793d) + j.k(d)) * 0.5d)) - i.b.ha.a.e.e.g.d(d / 2.0d);
    }
}
