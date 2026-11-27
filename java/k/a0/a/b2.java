package k.a0.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
class b2 extends o implements k.p {

    /* renamed from: n, reason: collision with root package name */
    private static DecimalFormat f1787n;

    /* renamed from: l, reason: collision with root package name */
    private double f1788l;

    /* renamed from: m, reason: collision with root package name */
    private NumberFormat f1789m;

    static {
        k.y.c.b(b2.class);
        f1787n = new DecimalFormat("#.###");
    }

    public b2(f2 f2Var, k.x.n0 n0Var, y2 y2Var) {
        super(f2Var, n0Var, y2Var);
        byte[] bArrC = x().c();
        this.f1788l = a2.a(k.x.s0.d(bArrC[6], bArrC[7], bArrC[8], bArrC[9]));
        NumberFormat numberFormatF = n0Var.f(z());
        this.f1789m = numberFormatF;
        if (numberFormatF == null) {
            this.f1789m = f1787n;
        }
    }

    @Override // k.c
    public k.f getType() {
        return k.f.d;
    }

    @Override // k.p
    public double getValue() {
        return this.f1788l;
    }

    @Override // k.c
    public String p() {
        return this.f1789m.format(this.f1788l);
    }
}
