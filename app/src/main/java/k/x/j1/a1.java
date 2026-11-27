package k.x.j1;

/* loaded from: classes.dex */
class a1 extends p0 {
    private boolean e;
    private boolean f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2104h;

    /* renamed from: i, reason: collision with root package name */
    private k.c f2105i;

    static {
        k.y.c.b(a1.class);
    }

    public a1(k.c cVar) {
        this.f2105i = cVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[5];
        bArr[0] = i1.c.a();
        k.x.s0.f(this.f2104h, bArr, 1);
        int i2 = this.g;
        if (this.e) {
            i2 |= 16384;
        }
        if (this.f) {
            i2 |= 32768;
        }
        k.x.s0.f(i2, bArr, 3);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.c(this.g, this.f2104h, stringBuffer);
    }

    public int j(byte[] bArr, int i2) {
        k.c cVar;
        k.c cVar2;
        this.f2104h = k.x.s0.e(bArr[i2], bArr[i2 + 1]);
        int iC = k.x.s0.c(bArr[i2 + 2], bArr[i2 + 3]);
        this.g = (byte) (iC & 255);
        boolean z = (iC & 16384) != 0;
        this.e = z;
        this.f = (iC & 32768) != 0;
        if (z && (cVar2 = this.f2105i) != null) {
            this.g = cVar2.b() + this.g;
        }
        if (!this.f || (cVar = this.f2105i) == null) {
            return 4;
        }
        this.f2104h = cVar.getRow() + this.f2104h;
        return 4;
    }
}
