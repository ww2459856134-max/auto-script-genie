package k.b0.v;

/* loaded from: classes.dex */
class t2 extends k.x.c1 {
    private byte[] c;
    private double d;
    private double e;
    private k.z.i f;
    private k.z.h g;

    /* renamed from: h, reason: collision with root package name */
    private int f1954h;

    /* renamed from: i, reason: collision with root package name */
    private int f1955i;

    /* renamed from: j, reason: collision with root package name */
    private int f1956j;

    /* renamed from: k, reason: collision with root package name */
    private int f1957k;

    /* renamed from: l, reason: collision with root package name */
    private int f1958l;

    /* renamed from: m, reason: collision with root package name */
    private int f1959m;

    /* renamed from: n, reason: collision with root package name */
    private int f1960n;

    /* renamed from: o, reason: collision with root package name */
    private int f1961o;
    private boolean p;

    public t2(k.t tVar) {
        super(k.x.z0.i0);
        k.y.c.b(t2.class);
        this.f = tVar.t();
        this.g = tVar.w();
        this.d = tVar.o();
        this.e = tVar.m();
        this.f1954h = tVar.y().b();
        this.f1959m = tVar.q();
        this.f1960n = tVar.M();
        this.f1957k = tVar.k();
        this.f1958l = tVar.i();
        this.f1956j = tVar.x();
        this.f1955i = tVar.I();
        this.f1961o = tVar.c();
        this.p = true;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[34];
        this.c = bArr;
        k.x.s0.f(this.f1954h, bArr, 0);
        k.x.s0.f(this.f1955i, this.c, 2);
        k.x.s0.f(this.f1956j, this.c, 4);
        k.x.s0.f(this.f1957k, this.c, 6);
        k.x.s0.f(this.f1958l, this.c, 8);
        int i2 = this.g == k.z.h.b ? 1 : 0;
        if (this.f == k.z.i.a) {
            i2 |= 2;
        }
        if (this.f1956j != 0) {
            i2 |= 128;
        }
        if (!this.p) {
            i2 |= 4;
        }
        k.x.s0.f(i2, this.c, 10);
        k.x.s0.f(this.f1959m, this.c, 12);
        k.x.s0.f(this.f1960n, this.c, 14);
        k.x.c0.a(this.d, this.c, 16);
        k.x.c0.a(this.e, this.c, 24);
        k.x.s0.f(this.f1961o, this.c, 32);
        return this.c;
    }
}
