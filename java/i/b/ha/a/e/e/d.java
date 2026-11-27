package i.b.ha.a.e.e;

import i.b.ha.a.e.b.m;
import i.b.ha.a.e.b.n;
import i.b.ha.a.e.b.o;
import i.b.ha.a.e.g.j;

/* loaded from: classes.dex */
public abstract class d {
    private static final double[] a = {0.08333333333333333d, -2.777777777777778E-5d, 7.936507936507937E-8d, -5.952380952380953E-10d, 8.417508417508329E-12d, -1.917526917518546E-13d, 6.410256405103255E-15d, -2.955065141253382E-16d, 1.7964371635940225E-17d, -1.3922896466162779E-18d, 1.338028550140209E-19d, -1.542460098679661E-20d, 1.9770199298095743E-21d, -2.3406566479399704E-22d, 1.713480149663986E-23d};

    private static double a(double d, double d2) throws o, n {
        if (d < 0.0d || d > d2) {
            throw new o(Double.valueOf(d), 0, Double.valueOf(d2));
        }
        if (d2 < 10.0d) {
            throw new n(Double.valueOf(d2), 10, true);
        }
        double d3 = d / d2;
        double d4 = d3 + 1.0d;
        double d5 = d3 / d4;
        double d6 = 1.0d / d4;
        double d7 = d6 * d6;
        int length = a.length;
        double[] dArr = new double[length];
        dArr[0] = 1.0d;
        for (int i2 = 1; i2 < length; i2++) {
            dArr[i2] = (dArr[i2 - 1] * d7) + d6 + 1.0d;
        }
        double d8 = 10.0d / d2;
        double d9 = d8 * d8;
        double[] dArr2 = a;
        double d10 = dArr2[dArr2.length - 1] * dArr[length - 1];
        for (int length2 = dArr2.length - 2; length2 >= 0; length2--) {
            d10 = (d10 * d9) + (a[length2] * dArr[length2]);
        }
        return (d10 * d5) / d2;
    }

    public static double b(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || d <= 0.0d || d2 <= 0.0d) {
            return Double.NaN;
        }
        double dP = j.p(d, d2);
        double dN = j.n(d, d2);
        if (dP >= 10.0d) {
            double dG = g(dP, dN);
            double d3 = dP / dN;
            double dK = (-(dP - 0.5d)) * j.k(d3 / (1.0d + d3));
            double dM = j.m(d3) * dN;
            return dK <= dM ? ((((j.k(dN) * (-0.5d)) + 0.9189385332046727d) + dG) - dK) - dM : ((((j.k(dN) * (-0.5d)) + 0.9189385332046727d) + dG) - dM) - dK;
        }
        if (dP <= 2.0d) {
            if (dP < 1.0d) {
                return dN >= 10.0d ? g.d(dP) + c(dP, dN) : j.k((g.a(dP) * g.a(dN)) / g.a(dP + dN));
            }
            if (dN <= 2.0d) {
                return (g.d(dP) + g.d(dN)) - d(dP, dN);
            }
            if (dN >= 10.0d) {
                return g.d(dP) + c(dP, dN);
            }
            double d4 = 1.0d;
            while (dN > 2.0d) {
                dN -= 1.0d;
                d4 *= dN / (dP + dN);
            }
            return j.k(d4) + g.d(dP) + (g.d(dN) - d(dP, dN));
        }
        if (dN > 1000.0d) {
            int iJ = (int) j.j(dP - 1.0d);
            double d5 = 1.0d;
            for (int i2 = 0; i2 < iJ; i2++) {
                dP -= 1.0d;
                d5 *= dP / ((dP / dN) + 1.0d);
            }
            return (j.k(d5) - (iJ * j.k(dN))) + g.d(dP) + c(dP, dN);
        }
        double d6 = 1.0d;
        while (dP > 2.0d) {
            dP -= 1.0d;
            double d7 = dP / dN;
            d6 *= d7 / (d7 + 1.0d);
        }
        if (dN >= 10.0d) {
            return j.k(d6) + g.d(dP) + c(dP, dN);
        }
        double d8 = 1.0d;
        while (dN > 2.0d) {
            dN -= 1.0d;
            d8 *= dN / (dP + dN);
        }
        return j.k(d6) + j.k(d8) + g.d(dP) + (g.d(dN) - d(dP, dN));
    }

    private static double c(double d, double d2) throws o, n {
        double d3;
        double dA;
        if (d < 0.0d) {
            throw new n(Double.valueOf(d), Double.valueOf(0.0d), true);
        }
        if (d2 < 10.0d) {
            throw new n(Double.valueOf(d2), Double.valueOf(10.0d), true);
        }
        if (d <= d2) {
            d3 = (d - 0.5d) + d2;
            dA = a(d, d2);
        } else {
            d3 = (d2 - 0.5d) + d;
            dA = a(d2, d);
        }
        double dM = d3 * j.m(d / d2);
        double dK = d * (j.k(d2) - 1.0d);
        return dM <= dK ? (dA - dM) - dK : (dA - dK) - dM;
    }

    private static double d(double d, double d2) throws m, o, n {
        double dE;
        double dK;
        Double dValueOf = Double.valueOf(1.0d);
        Double dValueOf2 = Double.valueOf(2.0d);
        if (d < 1.0d || d > 2.0d) {
            throw new o(Double.valueOf(d), dValueOf, dValueOf2);
        }
        if (d2 < 1.0d || d2 > 2.0d) {
            throw new o(Double.valueOf(d2), dValueOf, dValueOf2);
        }
        double d3 = (d - 1.0d) + (d2 - 1.0d);
        if (d3 <= 0.5d) {
            return g.e(d3 + 1.0d);
        }
        if (d3 <= 1.5d) {
            dE = g.e(d3);
            dK = j.m(d3);
        } else {
            dE = g.e(d3 - 1.0d);
            dK = j.k(d3 * (1.0d + d3));
        }
        return dE + dK;
    }

    public static double e(double d, double d2, double d3) {
        return f(d, d2, d3, 1.0E-14d, Integer.MAX_VALUE);
    }

    public static double f(double d, double d2, double d3, double d4, int i2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || Double.isNaN(d3) || d < 0.0d || d > 1.0d || d2 <= 0.0d || d3 <= 0.0d) {
            return Double.NaN;
        }
        double d5 = 2.0d + d3 + d2;
        if (d > (d2 + 1.0d) / d5) {
            double d6 = 1.0d - d;
            if (d6 <= (d3 + 1.0d) / d5) {
                return 1.0d - f(d6, d3, d2, d4, i2);
            }
        }
        return (j.h((((j.k(d) * d2) + (j.m(-d) * d3)) - j.k(d2)) - b(d2, d3)) * 1.0d) / new c(d3, d2).a(d, d4, i2);
    }

    private static double g(double d, double d2) {
        Double dValueOf = Double.valueOf(10.0d);
        if (d < 10.0d) {
            throw new n(Double.valueOf(d), dValueOf, true);
        }
        if (d2 < 10.0d) {
            throw new n(Double.valueOf(d2), dValueOf, true);
        }
        double dP = j.p(d, d2);
        double dN = j.n(d, d2);
        double d3 = 10.0d / dP;
        double d4 = d3 * d3;
        double[] dArr = a;
        double d5 = dArr[dArr.length - 1];
        for (int length = dArr.length - 2; length >= 0; length--) {
            d5 = (d5 * d4) + a[length];
        }
        return (d5 / dP) + a(dP, dN);
    }
}
