package k.b0.v;

/* loaded from: classes.dex */
class g3 extends k.x.c1 {
    private byte[] c;
    private boolean d;

    public g3(boolean z) {
        super(k.x.z0.g0);
        this.d = z;
        byte[] bArr = new byte[2];
        this.c = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.c;
    }
}
