package k.b0.v;

/* loaded from: classes.dex */
class j extends k.x.c1 {
    private boolean c;
    private boolean d;
    private String e;
    private byte[] f;

    public j(String str) {
        super(k.x.z0.e);
        this.e = str;
        this.c = false;
        this.d = false;
    }

    void A() {
        this.d = true;
    }

    void B() {
        this.c = true;
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.e.length() * 2) + 8];
        this.f = bArr;
        if (this.d) {
            bArr[5] = 2;
        } else {
            bArr[5] = 0;
        }
        if (this.c) {
            bArr[4] = 1;
            bArr[5] = 0;
        }
        bArr[6] = (byte) this.e.length();
        byte[] bArr2 = this.f;
        bArr2[7] = 1;
        k.x.y0.e(this.e, bArr2, 8);
        return this.f;
    }
}
