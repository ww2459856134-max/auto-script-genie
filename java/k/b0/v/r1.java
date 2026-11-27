package k.b0.v;

/* loaded from: classes.dex */
class r1 extends k.x.c1 {
    private boolean c;
    private byte[] d;

    public r1(boolean z) {
        super(k.x.z0.b0);
        this.c = z;
        byte[] bArr = new byte[2];
        this.d = bArr;
        if (z) {
            k.x.s0.f(1, bArr, 0);
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.d;
    }
}
