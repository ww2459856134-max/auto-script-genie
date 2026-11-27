package k.b0.v;

/* loaded from: classes.dex */
class m2 extends k.x.c1 {
    private int c;

    public m2(int i2) {
        super(k.x.z0.Y0);
        this.c = i2;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[4];
        k.x.s0.f(this.c, bArr, 0);
        k.x.s0.f(100, bArr, 2);
        return bArr;
    }
}
