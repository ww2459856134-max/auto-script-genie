package i.b.ha.a.e.f.b.e;

import i.b.ha.a.e.b.d;
import java.io.Serializable;

/* loaded from: classes.dex */
public class c extends i.b.ha.a.e.f.b.a implements Serializable {
    protected boolean d = true;
    protected a c = new a();

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public double a() {
        return this.c.d;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.d
    public double b(double[] dArr, int i2, int i3) throws d {
        if (!d(dArr, i2, i3)) {
            return Double.NaN;
        }
        double d = i3;
        double dB = new i.b.ha.a.e.f.b.f.a().b(dArr, i2, i3) / d;
        double d2 = 0.0d;
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            d2 += dArr[i4] - dB;
        }
        return dB + (d2 / d);
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void c(double d) {
        if (this.d) {
            this.c.c(d);
        }
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void clear() {
        if (this.d) {
            this.c.clear();
        }
    }

    @Override // i.b.ha.a.e.f.b.c
    public long getN() {
        return this.c.getN();
    }
}
