package i.b.ha.a.e.f.b.f;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.g.j;
import java.io.Serializable;

/* loaded from: classes.dex */
public class b extends i.b.ha.a.e.f.b.a implements Serializable {
    private double d = 0.0d;
    private int c = 0;

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public double a() {
        return this.d;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.d
    public double b(double[] dArr, int i2, int i3) throws d {
        if (!e(dArr, i2, i3, true)) {
            return Double.NaN;
        }
        double dK = 0.0d;
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            dK += j.k(dArr[i4]);
        }
        return dK;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void c(double d) {
        this.d += j.k(d);
        this.c++;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void clear() {
        this.d = 0.0d;
        this.c = 0;
    }

    @Override // i.b.ha.a.e.f.b.c
    public long getN() {
        return this.c;
    }
}
