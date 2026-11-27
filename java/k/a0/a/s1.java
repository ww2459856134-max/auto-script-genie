package k.a0.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
class s1 implements k.p, n {

    /* renamed from: j, reason: collision with root package name */
    private static DecimalFormat f1859j = new DecimalFormat("#.###");
    private int a;
    private int b;
    private double c;
    private k.z.d e;
    private k.d f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private k.x.n0 f1860h;
    private NumberFormat d = f1859j;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1861i = false;

    public s1(int i2, int i3, double d, int i4, k.x.n0 n0Var, y2 y2Var) {
        this.a = i2;
        this.b = i3;
        this.c = d;
        this.g = i4;
        this.f1860h = n0Var;
    }

    final void a(NumberFormat numberFormat) {
        if (numberFormat != null) {
            this.d = numberFormat;
        }
    }

    @Override // k.c
    public final int b() {
        return this.b;
    }

    @Override // k.c, k.a0.a.n
    public k.d c() {
        return this.f;
    }

    @Override // k.c
    public k.z.d e() {
        if (!this.f1861i) {
            this.e = this.f1860h.h(this.g);
            this.f1861i = true;
        }
        return this.e;
    }

    @Override // k.c
    public final int getRow() {
        return this.a;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.d;
    }

    @Override // k.p
    public double getValue() {
        return this.c;
    }

    @Override // k.a0.a.n
    public void h(k.d dVar) {
        this.f = dVar;
    }

    @Override // k.c
    public String p() {
        return this.d.format(this.c);
    }
}
