package i.b.ha.a.e.e;

import i.b.ha.a.e.b.m;
import i.b.ha.a.e.b.n;
import i.b.ha.a.e.g.j;

/* loaded from: classes.dex */
public abstract class g {
    private static final double[] a = {0.9999999999999971d, 57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
    private static final double b = j.k(6.283185307179586d) * 0.5d;

    public static double a(double d) {
        if (d == j.x(d) && d <= 0.0d) {
            return Double.NaN;
        }
        double dA = j.a(d);
        if (dA > 20.0d) {
            double d2 = 4.7421875d + dA + 0.5d;
            double dC = c(dA) * (2.5066282746310007d / dA) * j.t(d2, 0.5d + dA) * j.h(-d2);
            return d > 0.0d ? dC : (-3.141592653589793d) / ((d * j.z(3.141592653589793d * d)) * dC);
        }
        if (d >= 1.0d) {
            double d3 = 1.0d;
            while (d > 2.5d) {
                d -= 1.0d;
                d3 *= d;
            }
            return d3 / (b(d - 1.0d) + 1.0d);
        }
        double d4 = d;
        while (d < -0.5d) {
            d += 1.0d;
            d4 *= d;
        }
        return 1.0d / (d4 * (b(d) + 1.0d));
    }

    public static double b(double d) {
        double d2;
        if (d < -0.5d) {
            throw new n(Double.valueOf(d), Double.valueOf(-0.5d), true);
        }
        if (d > 1.5d) {
            throw new m(Double.valueOf(d), Double.valueOf(1.5d), true);
        }
        double d3 = d <= 0.5d ? d : (d - 0.5d) - 0.5d;
        if (d3 < 0.0d) {
            double d4 = ((((((((((((((((((((((((((((((6.247308301164655E-9d * d3) + 6.116095104481416E-9d) / ((((((((((((((((1.9575583661463974E-10d * d3) - 6.077618957228252E-8d) * d3) + 9.926418406727737E-7d) * d3) - 6.4304548177935305E-6d) * d3) - 8.514194324403149E-6d) * d3) + 4.939449793824468E-4d) * d3) + 0.026620534842894922d) * d3) + 0.203610414066807d) * d3) + 1.0d)) * d3) - 2.056338416977607E-7d) * d3) + 1.133027231981696E-6d) * d3) - 1.2504934821426706E-6d) * d3) - 2.013485478078824E-5d) * d3) + 1.280502823881162E-4d) * d3) - 2.1524167411495098E-4d) * d3) - 0.0011651675918590652d) * d3) + 0.0072189432466631d) * d3) - 0.009621971527876973d) * d3) - 0.04219773455554433d) * d3) + 0.16653861138229148d) * d3) - 0.04200263503409524d) * d3) - 0.6558780715202539d) * d3) - 0.42278433509846713d;
            if (d > 0.5d) {
                return (d3 * d4) / d;
            }
            d2 = d4 + 0.5d + 0.5d;
        } else {
            d2 = ((((((((((((((((((((((((((((((((((((((((4.343529937408594E-15d * d3) - 1.2494415722763663E-13d) * d3) + 1.5728330277104463E-12d) * d3) + 4.686843322948848E-11d) * d3) + 6.820161668496171E-10d) * d3) + 6.8716741130671986E-9d) * d3) + 6.116095104481416E-9d) / ((((((((2.6923694661863613E-4d * d3) + 0.004956830093825887d) * d3) + 0.054642130860422966d) * d3) + 0.3056961078365221d) * d3) + 1.0d)) * d3) - 2.056338416977607E-7d) * d3) + 1.133027231981696E-6d) * d3) - 1.2504934821426706E-6d) * d3) - 2.013485478078824E-5d) * d3) + 1.280502823881162E-4d) * d3) - 2.1524167411495098E-4d) * d3) - 0.0011651675918590652d) * d3) + 0.0072189432466631d) * d3) - 0.009621971527876973d) * d3) - 0.04219773455554433d) * d3) + 0.16653861138229148d) * d3) - 0.04200263503409524d) * d3) - 0.6558780715202539d) * d3) + 0.5772156649015329d;
            if (d > 0.5d) {
                return (d3 / d) * ((d2 - 0.5d) - 0.5d);
            }
        }
        return d * d2;
    }

    public static double c(double d) {
        double d2 = 0.0d;
        for (int length = a.length - 1; length > 0; length--) {
            d2 += a[length] / (length + d);
        }
        return d2 + a[0];
    }

    public static double d(double d) {
        if (Double.isNaN(d) || d <= 0.0d) {
            return Double.NaN;
        }
        if (d < 0.5d) {
            return e(d) - j.k(d);
        }
        if (d <= 2.5d) {
            return e((d - 0.5d) - 0.5d);
        }
        if (d > 8.0d) {
            double d2 = 4.7421875d + d + 0.5d;
            return (((0.5d + d) * j.k(d2)) - d2) + b + j.k(c(d) / d);
        }
        double d3 = 1.0d;
        for (int i2 = 1; i2 <= ((int) j.j(d - 1.5d)); i2++) {
            d3 *= d - i2;
        }
        return e(d - (r0 + 1)) + j.k(d3);
    }

    public static double e(double d) throws m, n {
        if (d < -0.5d) {
            throw new n(Double.valueOf(d), Double.valueOf(-0.5d), true);
        }
        if (d <= 1.5d) {
            return -j.m(b(d));
        }
        throw new m(Double.valueOf(d), Double.valueOf(1.5d), true);
    }

    public static double f(double d, double d2, double d3, int i2) {
        double d4 = 0.0d;
        if (Double.isNaN(d) || Double.isNaN(d2) || d <= 0.0d || d2 < 0.0d) {
            return Double.NaN;
        }
        if (d2 == 0.0d) {
            return 0.0d;
        }
        if (d2 >= d + 1.0d) {
            return 1.0d - g(d, d2, d3, i2);
        }
        double d5 = 1.0d / d;
        double d6 = d5;
        while (j.a(d5 / d6) > d3 && d4 < i2 && d6 < Double.POSITIVE_INFINITY) {
            d4 += 1.0d;
            d5 *= d2 / (d + d4);
            d6 += d5;
        }
        if (d4 >= i2) {
            throw new i.b.ha.a.e.b.g(Integer.valueOf(i2));
        }
        if (Double.isInfinite(d6)) {
            return 1.0d;
        }
        return j.h(((-d2) + (j.k(d2) * d)) - d(d)) * d6;
    }

    public static double g(double d, double d2, double d3, int i2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || d <= 0.0d || d2 < 0.0d) {
            return Double.NaN;
        }
        if (d2 == 0.0d) {
            return 1.0d;
        }
        return d2 < d + 1.0d ? 1.0d - f(d, d2, d3, i2) : (1.0d / new f(d).a(d2, d3, i2)) * j.h(((-d2) + (j.k(d2) * d)) - d(d));
    }
}
