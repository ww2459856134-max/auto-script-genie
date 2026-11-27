package i.b.ha.a.e.f.a;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.f.b.e.c;

/* loaded from: classes.dex */
public class a {
    public double a(double[] dArr, double[] dArr2, boolean z) throws d {
        c cVar = new c();
        int length = dArr.length;
        int i2 = 0;
        if (length != dArr2.length) {
            throw new d(i.b.ha.a.e.b.p.d.DIMENSIONS_MISMATCH_SIMPLE, Integer.valueOf(length), Integer.valueOf(dArr2.length));
        }
        if (length < 2) {
            throw new d(i.b.ha.a.e.b.p.d.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(length), 2);
        }
        double dF = cVar.f(dArr);
        double dF2 = cVar.f(dArr2);
        double d = 0.0d;
        while (i2 < length) {
            double d2 = ((dArr[i2] - dF) * (dArr2[i2] - dF2)) - d;
            i2++;
            d += d2 / i2;
            dF = dF;
        }
        return z ? d * (length / (length - 1)) : d;
    }
}
