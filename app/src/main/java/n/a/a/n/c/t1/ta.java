package n.a.a.n.c.t1;

import java.util.Arrays;

/* loaded from: classes.dex */
abstract class ta {
    public static double a(double[] dArr) {
        double dAbs = 0.0d;
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        double length = d / dArr.length;
        for (double d3 : dArr) {
            dAbs += Math.abs(d3 - length);
        }
        return dAbs / dArr.length;
    }

    public static double b(double[] dArr) {
        if (dArr == null || dArr.length < 1) {
            return Double.NaN;
        }
        int length = dArr.length;
        double d = 0.0d;
        for (double d2 : dArr) {
            d += d2;
        }
        double d3 = d / length;
        double d4 = 0.0d;
        for (double d5 : dArr) {
            double d6 = d5 - d3;
            d4 += d6 * d6;
        }
        if (length == 1) {
            return 0.0d;
        }
        return d4;
    }

    public static double c(double[] dArr, int i2) {
        int i3 = i2 - 1;
        if (dArr == null || dArr.length <= i3 || i3 < 0) {
            return Double.NaN;
        }
        Arrays.sort(dArr);
        return dArr[(dArr.length - i3) - 1];
    }

    public static double d(double[] dArr, int i2) {
        int i3 = i2 - 1;
        if (dArr == null || dArr.length <= i3 || i3 < 0) {
            return Double.NaN;
        }
        Arrays.sort(dArr);
        return dArr[i3];
    }

    public static double e(double[] dArr) {
        if (dArr == null || dArr.length < 1) {
            return Double.NaN;
        }
        int length = dArr.length;
        Arrays.sort(dArr);
        int i2 = length % 2;
        int i3 = length / 2;
        return i2 == 0 ? (dArr[i3] + dArr[i3 - 1]) / 2.0d : dArr[i3];
    }

    public static double f(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return Math.sqrt(b(dArr) / (dArr.length - 1));
    }

    public static double g(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return Math.sqrt(b(dArr) / dArr.length);
    }

    public static double h(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return b(dArr) / (dArr.length - 1);
    }

    public static double i(double[] dArr) {
        if (dArr == null || dArr.length <= 1) {
            return Double.NaN;
        }
        return b(dArr) / dArr.length;
    }
}
