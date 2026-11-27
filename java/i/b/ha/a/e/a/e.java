package i.b.ha.a.e.a;

import i.b.ha.a.e.b.k;
import i.b.ha.a.e.g.j;

/* loaded from: classes.dex */
public class e extends a {
    private final double c;
    private final int d;
    private final double e;

    public e(double d) throws k {
        this(d, 1.0E-12d, 10000000);
    }

    public double a(int i2) {
        if (i2 < 0) {
            return 0.0d;
        }
        if (i2 == Integer.MAX_VALUE) {
            return 1.0d;
        }
        return i.b.ha.a.e.e.g.g(i2 + 1.0d, this.c, this.e, this.d);
    }

    public double b(int i2) {
        if (i2 < 0 || i2 == Integer.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        if (i2 == 0) {
            return -this.c;
        }
        double d = i2;
        return (((-f.b(d)) - f.a(d, this.c)) - (j.k(6.283185307179586d) * 0.5d)) - (j.k(d) * 0.5d);
    }

    public double c(int i2) {
        double dB = b(i2);
        if (dB == Double.NEGATIVE_INFINITY) {
            return 0.0d;
        }
        return j.h(dB);
    }

    public e(double d, double d2, int i2) throws k {
        this(new i.b.ha.a.e.d.d(), d, d2, i2);
    }

    public e(i.b.ha.a.e.d.c cVar, double d, double d2, int i2) throws k {
        super(cVar);
        if (d > 0.0d) {
            this.c = d;
            this.e = d2;
            this.d = i2;
            new d(cVar, d, j.B(d), 1.0E-9d);
            new c(cVar, 1.0d, 1.0E-9d);
            return;
        }
        throw new k(i.b.ha.a.e.b.p.d.MEAN, Double.valueOf(d));
    }
}
