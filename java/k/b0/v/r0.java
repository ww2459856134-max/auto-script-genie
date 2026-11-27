package k.b0.v;

/* loaded from: classes.dex */
class r0 extends k.x.c1 {
    private byte[] c;
    private String d;

    public r0(String str) {
        super(k.x.z0.d0);
        this.d = str;
    }

    @Override // k.x.c1
    public byte[] y() {
        String str = this.d;
        if (str == null || str.length() == 0) {
            byte[] bArr = new byte[0];
            this.c = bArr;
            return bArr;
        }
        this.c = new byte[(this.d.length() * 2) + 3];
        k.x.s0.f(this.d.length(), this.c, 0);
        byte[] bArr2 = this.c;
        bArr2[2] = 1;
        k.x.y0.e(this.d, bArr2, 3);
        return this.c;
    }
}
