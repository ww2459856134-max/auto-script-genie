package k.b0.v;

/* loaded from: classes.dex */
class a0 extends k.x.c1 {
    private int c;
    private byte[] d;

    public a0(int i2) {
        super(k.x.z0.O);
        this.c = i2;
        byte[] bArr = new byte[2];
        this.d = bArr;
        k.x.s0.f(i2, bArr, 0);
    }

    @Override // k.x.c1
    protected byte[] y() {
        return this.d;
    }
}
