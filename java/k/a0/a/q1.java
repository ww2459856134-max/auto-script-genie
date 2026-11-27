package k.a0.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
class q1 extends o implements k.p, k.x.o0, k.q {

    /* renamed from: o, reason: collision with root package name */
    private static final DecimalFormat f1841o;

    /* renamed from: l, reason: collision with root package name */
    private double f1842l;

    /* renamed from: m, reason: collision with root package name */
    private NumberFormat f1843m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f1844n;

    static {
        k.y.c.b(q1.class);
        f1841o = new DecimalFormat("#.###");
    }

    public q1(f2 f2Var, k.x.n0 n0Var, k.x.j1.t tVar, k.x.a1 a1Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        this.f1844n = x().c();
        NumberFormat numberFormatF = n0Var.f(z());
        this.f1843m = numberFormatF;
        if (numberFormatF == null) {
            this.f1843m = f1841o;
        }
        this.f1842l = k.x.c0.b(this.f1844n, 6);
    }

    @Override // k.c
    public k.f getType() {
        return k.f.g;
    }

    @Override // k.p
    public double getValue() {
        return this.f1842l;
    }

    @Override // k.x.o0
    public byte[] j() throws k.x.j1.w {
        if (!y().y().A()) {
            throw new k.x.j1.w(k.x.j1.w.e);
        }
        byte[] bArr = this.f1844n;
        byte[] bArr2 = new byte[bArr.length - 6];
        System.arraycopy(bArr, 6, bArr2, 0, bArr.length - 6);
        return bArr2;
    }

    @Override // k.c
    public String p() {
        return !Double.isNaN(this.f1842l) ? this.f1843m.format(this.f1842l) : "";
    }
}
