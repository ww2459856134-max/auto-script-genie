package k.x;

/* loaded from: classes.dex */
class j extends c1 {
    private int c;
    private int d;

    public j(int i2, int i3) {
        super(z0.I0);
        this.c = i2;
        this.d = i3;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[4];
        s0.f(this.c, bArr, 0);
        bArr[1] = (byte) (bArr[1] | 128);
        bArr[2] = (byte) this.d;
        bArr[3] = -1;
        return bArr;
    }
}
