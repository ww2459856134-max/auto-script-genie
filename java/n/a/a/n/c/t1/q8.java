package n.a.a.n.c.t1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* loaded from: classes.dex */
abstract class q8 {
    public static double A(double d) {
        double dPow = Math.pow(2.718281828459045d, d);
        double dPow2 = Math.pow(2.718281828459045d, -d);
        return (dPow - dPow2) / (dPow + dPow2);
    }

    public static double a(double d) {
        return Math.log(Math.sqrt(Math.pow(d, 2.0d) - 1.0d) + d);
    }

    public static double b(double d) {
        return Math.log(Math.sqrt((d * d) + 1.0d) + d);
    }

    public static double c(double d) {
        return Math.log((d + 1.0d) / (1.0d - d)) / 2.0d;
    }

    public static double d(double[] dArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        return d / dArr.length;
    }

    public static double e(double d, double d2) {
        if (d > 0.0d && d2 < 0.0d) {
            return Double.NaN;
        }
        if (d == 0.0d || d2 == 0.0d) {
            return 0.0d;
        }
        return d2 == 1.0d ? Math.ceil(d) : v(d, d2, RoundingMode.CEILING);
    }

    public static double f(double d) {
        return (Math.pow(2.718281828459045d, d) + Math.pow(2.718281828459045d, -d)) / 2.0d;
    }

    public static double g(double d) {
        return h((int) d);
    }

    public static double h(int i2) {
        if (i2 < 0) {
            return Double.NaN;
        }
        if (i2 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        for (int i3 = 1; i3 <= i2; i3++) {
            d *= i3;
        }
        return d;
    }

    public static double i(double d, double d2) {
        if (d2 == 0.0d && d != 0.0d) {
            return Double.NaN;
        }
        if (d == 0.0d || d2 == 0.0d) {
            return 0.0d;
        }
        if (d2 == 1.0d) {
            return Math.floor(d);
        }
        if (d2 >= 0.0d || d < 0.0d) {
            return v(d, d2, RoundingMode.FLOOR);
        }
        return Double.NaN;
    }

    public static double j(double[] dArr) {
        double dMax = Double.NEGATIVE_INFINITY;
        for (double d : dArr) {
            dMax = Math.max(dMax, d);
        }
        return dMax;
    }

    public static double k(double[] dArr) {
        double dMin = Double.POSITIVE_INFINITY;
        for (double d : dArr) {
            dMin = Math.min(dMin, d);
        }
        return dMin;
    }

    public static double l(double d, double d2) {
        if (d2 == 0.0d) {
            return Double.NaN;
        }
        return w(d) == w(d2) ? d % d2 : ((d % d2) + d2) % d2;
    }

    public static double m(int i2, int i3) {
        if (i3 < 0 || i2 < i3) {
            return Double.NaN;
        }
        int i4 = i2 - i3;
        int iMin = Math.min(i4, i3);
        int iMax = Math.max(i4, i3);
        double d = 1.0d;
        while (iMax < i2) {
            iMax++;
            d *= iMax;
        }
        return d / h(iMin);
    }

    public static double n(double[] dArr) {
        if (dArr == null || dArr.length <= 0) {
            return 0.0d;
        }
        double d = 1.0d;
        for (double d2 : dArr) {
            d *= d2;
        }
        return d;
    }

    public static double o(double d, double d2) {
        return p(d, (int) d2);
    }

    public static double p(double d, int i2) {
        return q(d, i2, RoundingMode.HALF_UP);
    }

    private static double q(double d, int i2, RoundingMode roundingMode) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return Double.NaN;
        }
        return new BigDecimal(n.a.a.n.e.c0.h(d)).setScale(i2, roundingMode).doubleValue();
    }

    public static double r(double d, double d2) {
        return s(d, (int) d2);
    }

    public static double s(double d, int i2) {
        return q(d, i2, RoundingMode.DOWN);
    }

    public static double t(double d, double d2) {
        return u(d, (int) d2);
    }

    public static double u(double d, int i2) {
        return q(d, i2, RoundingMode.UP);
    }

    public static double v(double d, double d2, RoundingMode roundingMode) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d2);
        return BigDecimal.valueOf(d).divide(bigDecimalValueOf, MathContext.DECIMAL128).setScale(0, roundingMode).multiply(bigDecimalValueOf).doubleValue();
    }

    public static short w(double d) {
        return (short) (d == 0.0d ? 0 : d < 0.0d ? -1 : 1);
    }

    public static double x(double d) {
        return (Math.pow(2.718281828459045d, d) - Math.pow(2.718281828459045d, -d)) / 2.0d;
    }

    public static double y(double[] dArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        return d;
    }

    public static double z(double[] dArr) {
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2 * d2;
        }
        return d;
    }
}
