package i.b.ha.a.e.f.c;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.c.p;
import i.b.ha.a.e.c.u;

/* loaded from: classes.dex */
public class b extends a {
    private p d;
    private final double e;

    public b() {
        this(0.0d);
    }

    @Override // i.b.ha.a.e.f.c.a
    protected u a() {
        return this.d.b().a(d());
    }

    @Override // i.b.ha.a.e.f.c.a
    protected void e(double[][] dArr) {
        super.e(dArr);
        this.d = new p(c(), this.e);
    }

    public void i(double[] dArr, double[][] dArr2) throws d {
        h(dArr2, dArr);
        f(dArr);
        e(dArr2);
    }

    public b(double d) {
        this.d = null;
        this.e = d;
    }
}
