package i.b.ha.a.e.g;

/* loaded from: classes.dex */
public abstract class d {
    protected d() {
    }

    public double a(double d, double d2, int i2) throws i.b.ha.a.e.b.g, i.b.ha.a.e.b.a {
        double dB = b(0, d);
        if (n.a(dB, 0.0d, 1.0E-50d)) {
            dB = 1.0E-50d;
        }
        double d3 = 0.0d;
        int i3 = 1;
        double d4 = dB;
        while (i3 < i2) {
            double dB2 = b(i3, d);
            double dC = c(i3, d);
            double d5 = (d3 * dC) + dB2;
            if (n.a(d5, 0.0d, 1.0E-50d)) {
                d5 = 1.0E-50d;
            }
            double d6 = dB2 + (dC / dB);
            dB = n.a(d6, 0.0d, 1.0E-50d) ? 1.0E-50d : d6;
            d3 = 1.0d / d5;
            double d7 = dB * d3;
            d4 *= d7;
            if (Double.isInfinite(d4)) {
                throw new i.b.ha.a.e.b.a(i.b.ha.a.e.b.p.d.CONTINUED_FRACTION_INFINITY_DIVERGENCE, Double.valueOf(d));
            }
            if (Double.isNaN(d4)) {
                throw new i.b.ha.a.e.b.a(i.b.ha.a.e.b.p.d.CONTINUED_FRACTION_NAN_DIVERGENCE, Double.valueOf(d));
            }
            if (j.a(d7 - 1.0d) < d2) {
                break;
            }
            i3++;
        }
        if (i3 < i2) {
            return d4;
        }
        throw new i.b.ha.a.e.b.g(i.b.ha.a.e.b.p.d.NON_CONVERGENT_CONTINUED_FRACTION, Integer.valueOf(i2), Double.valueOf(d));
    }

    protected abstract double b(int i2, double d);

    protected abstract double c(int i2, double d);
}
