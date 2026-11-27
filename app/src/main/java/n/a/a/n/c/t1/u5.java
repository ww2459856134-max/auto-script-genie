package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class u5 {
    public static double a(double d, int i2, double d2, double d3, int i3) {
        double d4 = d + 1.0d;
        double d5 = i2;
        return -((d3 * Math.pow(d4, d5)) + (((d2 * ((i3 * d) + 1.0d)) * (Math.pow(d4, d5) - 1.0d)) / d));
    }

    public static double b(double d, int i2, int i3, double d2) {
        return c(d, i2, i3, d2, 0.0d);
    }

    public static double c(double d, int i2, int i3, double d2, double d3) {
        return d(d, i2, i3, d2, d3, 0);
    }

    public static double d(double d, int i2, int i3, double d2, double d3, int i4) {
        double dA = a(d, i2 - 1, g(d, i3, d2, d3, i4), d2, i4) * d;
        return i4 == 1 ? dA / (1.0d + d) : dA;
    }

    public static double e(double d, int i2, double d2) {
        return f(d, i2, d2, 0.0d);
    }

    public static double f(double d, int i2, double d2, double d3) {
        return g(d, i2, d2, d3, 0);
    }

    public static double g(double d, int i2, double d2, double d3, int i3) {
        double d4 = d + 1.0d;
        double d5 = i2;
        return ((-d) * ((Math.pow(d4, d5) * d2) + d3)) / (((d * i3) + 1.0d) * (Math.pow(d4, d5) - 1.0d));
    }

    public static double h(double d, int i2, int i3, double d2) {
        return e(d, i3, d2) - b(d, i2, i3, d2);
    }
}
