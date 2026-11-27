package i.b.ha.a.e.f.a;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.f.c.c;

/* loaded from: classes.dex */
public class b {
    public double a(double[] dArr, double[] dArr2) {
        c cVar = new c();
        if (dArr.length != dArr2.length) {
            throw new i.b.ha.a.e.b.b(dArr.length, dArr2.length);
        }
        if (dArr.length < 2) {
            throw new d(i.b.ha.a.e.b.p.d.INSUFFICIENT_DIMENSION, Integer.valueOf(dArr.length), 2);
        }
        for (int i2 = 0; i2 < dArr.length; i2++) {
            cVar.a(dArr[i2], dArr2[i2]);
        }
        return cVar.b();
    }
}
