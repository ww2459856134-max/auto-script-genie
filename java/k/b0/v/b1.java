package k.b0.v;

/* loaded from: classes.dex */
class b1 extends k.x.c1 {
    private boolean c;
    private byte[] d;

    public b1(boolean z) {
        super(k.x.z0.H0);
        this.c = z;
        byte[] bArr = new byte[2];
        this.d = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.d;
    }
}
