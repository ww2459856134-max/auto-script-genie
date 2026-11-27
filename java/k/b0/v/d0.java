package k.b0.v;

/* loaded from: classes.dex */
class d0 extends k.x.c1 {
    private int c;
    private int d;
    private byte[] e;

    public d0(int i2, int i3) {
        super(k.x.z0.f2172h);
        this.c = i2;
        this.d = i3;
        byte[] bArr = new byte[14];
        this.e = bArr;
        k.x.s0.a(i2, bArr, 4);
        k.x.s0.f(this.d, this.e, 10);
    }

    @Override // k.x.c1
    protected byte[] y() {
        return this.e;
    }
}
