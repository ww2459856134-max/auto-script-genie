package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.Logger;

/* loaded from: classes.dex */
public class ia implements p6 {
    private static final Logger a = n.a.a.i.b.a(ia.class);

    private static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d + 1.0d;
        double dPow = Math.pow(d7, d2);
        double dPow2 = Math.pow(d7, d2 - 1.0d);
        double d8 = d5 + (dPow * d4);
        double d9 = (dPow - 1.0d) * d3;
        double d10 = (d * d6) + 1.0d;
        double d11 = d9 * d10;
        return (d8 + (d11 / d)) / (((d2 * dPow2) * d4) - (d11 / ((Math.pow(d, 2.0d) + ((((d2 * d3) * dPow2) * d10) / d)) + ((d9 * d6) / d))));
    }

    static double b(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d6;
        boolean z = false;
        int i2 = 0;
        while (i2 < 100.0d && !z) {
            double dA = d7 - a(d7, d, d2, d3, d4, d5);
            boolean z2 = Math.abs(dA - d7) < 1.0E-8d;
            i2++;
            d7 = dA;
            z = z2;
        }
        if (z) {
            return d7;
        }
        return Double.NaN;
    }

    static void c(double d) throws n.a.a.n.c.r1.p {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
        }
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 3) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dB = b(n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[0], i2, i3)), n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[1], i2, i3)), n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[2], i2, i3)), w0VarArr.length >= 4 ? n.a.a.n.c.r1.z.e(w0VarArr.length >= 4 ? n.a.a.n.c.r1.z.i(w0VarArr[3], i2, i3) : null) : 0.0d, w0VarArr.length >= 5 ? n.a.a.n.c.r1.z.e(w0VarArr.length >= 5 ? n.a.a.n.c.r1.z.i(w0VarArr[4], i2, i3) : null) : 0.0d, w0VarArr.length >= 6 ? n.a.a.n.c.r1.z.e(w0VarArr.length >= 6 ? n.a.a.n.c.r1.z.i(w0VarArr[5], i2, i3) : null) : 0.1d);
            c(dB);
            return new n.a.a.n.c.r1.x(dB);
        } catch (n.a.a.n.c.r1.p e) {
            a.atError().withThrowable(e).log("Can't evaluate rate function");
            return e.a();
        }
    }
}
