package k.b0.v;

/* loaded from: classes.dex */
class l extends k.x.c1 {
    private int c;

    public l(int i2) {
        super(k.x.z0.B0);
        this.c = i2;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[2];
        k.x.s0.f(this.c, bArr, 0);
        return bArr;
    }
}
