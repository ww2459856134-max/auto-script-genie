package i.b.ha.a.e.f.b.e;

import java.io.Serializable;

/* loaded from: classes.dex */
class a extends i.b.ha.a.e.f.b.a implements Serializable {
    protected long c = 0;
    protected double d = Double.NaN;
    protected double e = Double.NaN;
    protected double f = Double.NaN;

    a() {
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public double a() {
        return this.d;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void c(double d) {
        long j2 = this.c;
        if (j2 == 0) {
            this.d = 0.0d;
        }
        long j3 = j2 + 1;
        this.c = j3;
        double d2 = this.d;
        double d3 = d - d2;
        this.e = d3;
        double d4 = d3 / j3;
        this.f = d4;
        this.d = d2 + d4;
    }

    @Override // i.b.ha.a.e.f.b.a, i.b.ha.a.e.f.b.c
    public void clear() {
        this.d = Double.NaN;
        this.c = 0L;
        this.e = Double.NaN;
        this.f = Double.NaN;
    }

    @Override // i.b.ha.a.e.f.b.c
    public long getN() {
        return this.c;
    }
}
