package k.x.j1;

/* loaded from: classes.dex */
class i extends p0 {
    private boolean e;
    private boolean f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2122h;

    /* renamed from: i, reason: collision with root package name */
    private int f2123i;

    /* renamed from: j, reason: collision with root package name */
    private t f2124j;

    static {
        k.y.c.b(i.class);
    }

    public i(k.c cVar, t tVar) {
        this.f2124j = tVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[7];
        bArr[0] = i1.d.a();
        k.x.s0.f(this.f2123i, bArr, 1);
        k.x.s0.f(this.f2122h, bArr, 3);
        int i2 = this.g;
        if (this.f) {
            i2 |= 32768;
        }
        if (this.e) {
            i2 |= 16384;
        }
        k.x.s0.f(i2, bArr, 5);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.d(this.f2123i, this.g, !this.e, this.f2122h, !this.f, this.f2124j, stringBuffer);
    }

    public int j(byte[] bArr, int i2) {
        this.f2123i = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        this.f2122h = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        int iC = k.x.s0.c(bArr[i2 + 4], bArr[i2 + 5]);
        this.g = iC & 255;
        this.e = (iC & 16384) != 0;
        this.f = (iC & 32768) != 0;
        return 6;
    }

    public i(String str, t tVar) throws w {
        this.f2124j = tVar;
        this.e = true;
        this.f = true;
        int iIndexOf = str.indexOf(33);
        String strSubstring = str.substring(iIndexOf + 1);
        this.g = k.x.m.f(strSubstring);
        this.f2122h = k.x.m.i(strSubstring);
        String strSubstring2 = str.substring(0, iIndexOf);
        if (strSubstring2.charAt(0) == '\'' && strSubstring2.charAt(strSubstring2.length() - 1) == '\'') {
            strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
        }
        int iC = tVar.c(strSubstring2);
        this.f2123i = iC;
        if (iC < 0) {
            throw new w(w.f2147h, strSubstring2);
        }
    }
}
