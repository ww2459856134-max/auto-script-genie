package k.b0.v;

/* loaded from: classes.dex */
class w1 extends k.x.c1 {
    private byte[] c;
    private boolean d;

    public w1(boolean z) {
        super(k.x.z0.j0);
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
