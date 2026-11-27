package k.a0.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
class r1 extends o implements k.p {

    /* renamed from: n, reason: collision with root package name */
    private static DecimalFormat f1848n;

    /* renamed from: l, reason: collision with root package name */
    private double f1849l;

    /* renamed from: m, reason: collision with root package name */
    private NumberFormat f1850m;

    static {
        k.y.c.b(r1.class);
        f1848n = new DecimalFormat("#.###");
    }

    public r1(f2 f2Var, k.x.n0 n0Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        this.f1849l = k.x.c0.b(x().c(), 6);
        NumberFormat numberFormatF = n0Var.f(z());
        this.f1850m = numberFormatF;
        if (numberFormatF == null) {
            this.f1850m = f1848n;
        }
    }

    @Override // k.c
    public k.f getType() {
        return k.f.d;
    }

    @Override // k.p
    public double getValue() {
        return this.f1849l;
    }

    @Override // k.c
    public String p() {
        return this.f1850m.format(this.f1849l);
    }
}
