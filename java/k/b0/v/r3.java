package k.b0.v;

/* loaded from: classes.dex */
class r3 extends k.x.c1 {
    private byte[] c;

    public r3(String str) {
        super(k.x.z0.Q);
        this.c = new byte[112];
        if (str == null) {
            str = "Java Excel API v" + k.v.k();
        }
        k.x.y0.a(str, this.c, 0);
        int length = str.length();
        while (true) {
            byte[] bArr = this.c;
            if (length >= bArr.length) {
                return;
            }
            bArr[length] = 32;
            length++;
        }
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.c;
    }
}
