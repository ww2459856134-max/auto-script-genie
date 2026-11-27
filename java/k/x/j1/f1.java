package k.x.j1;

/* loaded from: classes.dex */
class f1 extends p0 {
    private String e;
    private k.w f;

    static {
        k.y.c.b(f1.class);
    }

    public f1(k.w wVar) {
        this.f = wVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[(this.e.length() * 2) + 3];
        bArr[0] = i1.f.a();
        bArr[1] = (byte) this.e.length();
        bArr[2] = 1;
        k.x.y0.e(this.e, bArr, 3);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append("\"");
        stringBuffer.append(this.e);
        stringBuffer.append("\"");
    }

    public int j(byte[] bArr, int i2) {
        int i3 = bArr[i2] & 255;
        if ((bArr[i2 + 1] & 1) == 0) {
            this.e = k.x.y0.d(bArr, i3, i2 + 2, this.f);
        } else {
            this.e = k.x.y0.g(bArr, i3, i2 + 2);
            i3 *= 2;
        }
        return i3 + 2;
    }

    public f1(String str) {
        this.e = str;
    }
}
