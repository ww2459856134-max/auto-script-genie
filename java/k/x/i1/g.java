package k.x.i1;

/* loaded from: classes.dex */
class g extends x {
    private byte[] c;
    private int d;
    private double e;
    private double f;
    private double g;

    /* renamed from: h, reason: collision with root package name */
    private double f2065h;

    static {
        k.y.c.b(g.class);
    }

    public g(a0 a0Var) {
        super(a0Var);
        byte[] bArrA = a();
        this.d = k.x.s0.c(bArrA[0], bArrA[1]);
        this.e = k.x.s0.c(bArrA[2], bArrA[3]) + (k.x.s0.c(bArrA[4], bArrA[5]) / 1024.0d);
        this.f = k.x.s0.c(bArrA[6], bArrA[7]) + (k.x.s0.c(bArrA[8], bArrA[9]) / 256.0d);
        this.g = k.x.s0.c(bArrA[10], bArrA[11]) + (k.x.s0.c(bArrA[12], bArrA[13]) / 1024.0d);
        this.f2065h = k.x.s0.c(bArrA[14], bArrA[15]) + (k.x.s0.c(bArrA[16], bArrA[17]) / 256.0d);
    }

    @Override // k.x.i1.x, k.x.i1.z
    byte[] b() {
        byte[] bArr = new byte[18];
        this.c = bArr;
        k.x.s0.f(this.d, bArr, 0);
        k.x.s0.f((int) this.e, this.c, 2);
        k.x.s0.f((int) ((this.e - ((int) r0)) * 1024.0d), this.c, 4);
        k.x.s0.f((int) this.f, this.c, 6);
        k.x.s0.f((int) ((this.f - ((int) r0)) * 256.0d), this.c, 8);
        k.x.s0.f((int) this.g, this.c, 10);
        k.x.s0.f((int) ((this.g - ((int) r0)) * 1024.0d), this.c, 12);
        k.x.s0.f((int) this.f2065h, this.c, 14);
        k.x.s0.f((int) ((this.f2065h - ((int) r0)) * 256.0d), this.c, 16);
        return j(this.c);
    }

    int m() {
        return this.d;
    }

    double n() {
        return this.e;
    }

    double o() {
        return this.g;
    }

    double p() {
        return this.f;
    }

    double q() {
        return this.f2065h;
    }

    public g(double d, double d2, double d3, double d4, int i2) {
        super(b0.f2046o);
        this.e = d;
        this.f = d2;
        this.g = d3;
        this.f2065h = d4;
        this.d = i2;
    }
}
