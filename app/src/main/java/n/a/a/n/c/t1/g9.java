package n.a.a.n.c.t1;

import java.util.Arrays;

/* loaded from: classes.dex */
public class g9 extends m9 {
    public g9() {
        super(false, false);
    }

    private static double p(double[] dArr, double d, double d2) {
        int i2;
        double d3 = 1.0d;
        double length = dArr.length - 1.0d;
        int length2 = dArr.length;
        int i3 = 0;
        double d4 = 0.0d;
        int i4 = 0;
        double dPow = 0.0d;
        double dPow2 = 0.0d;
        while (i3 < length2) {
            double d5 = dArr[i3];
            if (d5 > d4) {
                i2 = i4 + 1;
                dPow += d5 * Math.pow(d2 + d3, length - i4);
            } else if (d5 < d4) {
                i2 = i4 + 1;
                dPow2 += d5 / Math.pow(d + 1.0d, i4);
            } else {
                i3++;
                d3 = 1.0d;
                d4 = 0.0d;
            }
            i4 = i2;
            i3++;
            d3 = 1.0d;
            d4 = 0.0d;
        }
        double d6 = d4;
        return (dPow == d6 || dPow2 == d6) ? d6 : Math.pow((-dPow) / dPow2, 1.0d / length) - 1.0d;
    }

    @Override // n.a.a.n.c.t1.m9
    protected double c(double[] dArr) throws n.a.a.n.c.r1.p {
        double d = dArr[dArr.length - 2];
        double d2 = dArr[dArr.length - 1];
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length - 2);
        int length = dArrCopyOf.length;
        boolean z = true;
        boolean z2 = true;
        for (int i2 = 0; i2 < length; i2++) {
            double d3 = dArrCopyOf[i2];
            z &= d3 < 0.0d;
            z2 &= d3 > 0.0d;
        }
        if (z) {
            return -1.0d;
        }
        if (z2) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.d);
        }
        return p(dArrCopyOf, d, d2);
    }

    @Override // n.a.a.n.c.t1.m9
    protected int d() {
        return 3;
    }
}
