package k.b0.v;

/* loaded from: classes.dex */
class x2 extends k.x.c1 {
    private String c;

    public x2(String str) {
        super(k.x.z0.D);
        this.c = str;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.c.length() * 2) + 3];
        k.x.s0.f(this.c.length(), bArr, 0);
        bArr[2] = 1;
        k.x.y0.e(this.c, bArr, 3);
        return bArr;
    }
}
