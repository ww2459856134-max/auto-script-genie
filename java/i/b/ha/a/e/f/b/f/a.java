package i.b.ha.a.e.f.b.f;

import i.b.ha.a.e.b.d;
import java.io.Serializable;

/* loaded from: classes.dex */
public class a extends i.b.ha.a.e.f.b.a implements Serializable {
    private long c = 0;
    private double d = 0.0d;

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public double a() {
        return this.d;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.d
    public double b(double[] dArr, int i2, int i3) throws d {
        if (!e(dArr, i2, i3, true)) {
            return Double.NaN;
        }
        double d = 0.0d;
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            d += dArr[i4];
        }
        return d;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void c(double d) {
        this.d += d;
        this.c++;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void clear() {
        this.d = 0.0d;
        this.c = 0L;
    }

    @Override // i.b.ha.a.e.f.b.c
    public long getN() {
        return this.c;
    }
}
