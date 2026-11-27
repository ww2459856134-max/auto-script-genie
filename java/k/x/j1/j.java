package k.x.j1;

/* loaded from: classes.dex */
class j extends p0 {
    private boolean e;
    private boolean f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2133h;

    static {
        k.y.c.b(j.class);
    }

    public j(k.c cVar) {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[5];
        bArr[0] = !i() ? i1.c.a() : i1.c.b();
        k.x.s0.f(this.f2133h, bArr, 1);
        int i2 = this.g;
        if (this.f) {
            i2 |= 32768;
        }
        if (this.e) {
            i2 |= 16384;
        }
        k.x.s0.f(i2, bArr, 3);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.e(this.g, !this.e, this.f2133h, !this.f, stringBuffer);
    }

    public int j(byte[] bArr, int i2) {
        this.f2133h = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        int iC = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        this.g = iC & 255;
        this.e = (iC & 16384) != 0;
        this.f = (iC & 32768) != 0;
        return 4;
    }

    public j(String str) {
        this.g = k.x.m.f(str);
        this.f2133h = k.x.m.i(str);
        this.e = k.x.m.j(str);
        this.f = k.x.m.k(str);
    }
}
