package n.a.a.n.c.t1;

import com.auto.exceldeps.log4j.Logger;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public final class c7 implements p6 {
    private static final Logger a = n.a.a.i.b.a(c7.class);

    public static double a(double[] dArr, double d) {
        char c = 0;
        double d2 = d;
        int i2 = 0;
        while (i2 < 1000) {
            double d3 = 1.0d + d2;
            if (d3 == 0.0d) {
                a.atWarn().log("Returning NaN because IRR has found an denominator of 0");
                return Double.NaN;
            }
            double d4 = dArr[c];
            double d5 = d3;
            double d6 = 0.0d;
            for (int i3 = 1; i3 < dArr.length; i3++) {
                double d7 = dArr[i3];
                d4 += d7 / d5;
                d5 *= d3;
                d6 -= (i3 * d7) / d5;
            }
            if (d6 == 0.0d) {
                a.atWarn().log("Returning NaN because IRR has found an fDerivative of 0");
                return Double.NaN;
            }
            double d8 = d2 - (d4 / d6);
            if (Math.abs(d8 - d2) <= 1.0E-7d) {
                return d8;
            }
            i2++;
            d2 = d8;
            c = 0;
        }
        a.atWarn().log("Returning NaN because IRR has reached max number of iterations allowed: {}", Integer.valueOf(XmlValidationError.INCORRECT_ATTRIBUTE));
        return Double.NaN;
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length == 0 || w0VarArr.length > 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dA = a(u2.p(w0VarArr[0]), w0VarArr.length == 2 ? y9.D(w0VarArr[1], i2, i3) : 0.1d);
            y9.a(dA);
            return new n.a.a.n.c.r1.x(dA);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
