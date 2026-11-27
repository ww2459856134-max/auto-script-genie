package k.b0.v;

/* loaded from: classes.dex */
class i0 extends k.x.c1 {
    private String c;

    public i0(String str) {
        super(k.x.z0.V0);
        k.y.c.b(i0.class);
        this.c = str;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.c.length() * 2) + 12];
        bArr[6] = (byte) this.c.length();
        bArr[7] = 1;
        k.x.y0.e(this.c, bArr, 8);
        int length = (this.c.length() * 2) + 8;
        bArr[length] = 2;
        bArr[length + 1] = 0;
        bArr[length + 2] = 28;
        bArr[length + 3] = 23;
        return bArr;
    }
}
