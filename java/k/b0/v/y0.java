package k.b0.v;

/* loaded from: classes.dex */
class y0 extends k.x.c1 {
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;

    public y0(int i2, int i3, int i4) {
        super(k.x.z0.q);
        this.e = i2;
        this.d = i3;
        this.f = i4;
        this.c = new byte[(i4 * 4) + 16];
        this.g = 16;
    }

    void A(int i2) {
        k.x.s0.a(i2 - this.e, this.c, this.g);
        this.g += 4;
    }

    void B(int i2) {
        k.x.s0.a(i2 - this.e, this.c, 12);
    }

    @Override // k.x.c1
    protected byte[] y() {
        k.x.s0.a(this.d, this.c, 8);
        return this.c;
    }
}
