package i.b.ha.a.e.f.b.e;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.g.j;
import java.io.Serializable;

/* loaded from: classes.dex */
public class b extends i.b.ha.a.e.f.b.a implements Serializable {
    private i.b.ha.a.e.f.b.c c = new i.b.ha.a.e.f.b.f.b();

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public double a() {
        if (this.c.getN() > 0) {
            return j.h(this.c.a() / this.c.getN());
        }
        return Double.NaN;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.d
    public double b(double[] dArr, int i2, int i3) throws d {
        return j.h(this.c.b(dArr, i2, i3) / i3);
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void c(double d) {
        this.c.c(d);
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void clear() {
        this.c.clear();
    }

    @Override // i.b.ha.a.e.f.b.c
    public long getN() {
        return this.c.getN();
    }
}
