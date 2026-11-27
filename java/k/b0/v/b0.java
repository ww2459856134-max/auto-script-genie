package k.b0.v;

/* loaded from: classes.dex */
class b0 extends k.x.c1 {
    private byte[] c;
    private int d;
    private boolean e;

    public b0(int i2, boolean z) {
        super(k.x.z0.P);
        this.c = new byte[4];
        this.d = i2;
        this.e = z;
    }

    @Override // k.x.c1
    public byte[] y() {
        if (this.e) {
            byte[] bArr = this.c;
            bArr[0] = (byte) (bArr[0] | 1);
        }
        k.x.s0.f(this.d, this.c, 2);
        return this.c;
    }
}
