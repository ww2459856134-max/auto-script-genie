package k.b0.v;

/* loaded from: classes.dex */
class q0 extends k.x.c1 {
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;

    public q0() {
        super(k.x.z0.l0);
    }

    public void A(int i2) {
        this.g = i2;
        this.e = (i2 * 14) + 1;
    }

    public void B(int i2) {
        this.f = i2;
        this.d = (i2 * 14) + 1;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[8];
        this.c = bArr;
        k.x.s0.f(this.d, bArr, 0);
        k.x.s0.f(this.e, this.c, 2);
        k.x.s0.f(this.f, this.c, 4);
        k.x.s0.f(this.g, this.c, 6);
        return this.c;
    }
}
