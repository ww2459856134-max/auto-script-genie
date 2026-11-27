package k.x.j1;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class z0 extends p0 {
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2151h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2152i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2153j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2154k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2155l;

    /* renamed from: m, reason: collision with root package name */
    private k.c f2156m;

    public z0(k.c cVar) {
        this.f2156m = cVar;
    }

    @Override // k.x.j1.t0
    byte[] a() {
        byte[] bArr = new byte[9];
        bArr[0] = i1.f2132o.a();
        k.x.s0.f(this.f, bArr, 1);
        k.x.s0.f(this.f2151h, bArr, 3);
        k.x.s0.f(this.e, bArr, 5);
        k.x.s0.f(this.g, bArr, 7);
        return bArr;
    }

    @Override // k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.c(this.e, this.f, stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        k.x.m.c(this.g, this.f2151h, stringBuffer);
    }

    public int j(byte[] bArr, int i2) {
        this.f = k.x.s0.e(bArr[i2], bArr[i2 + 1]);
        this.f2151h = k.x.s0.e(bArr[i2 + 2], bArr[i2 + 3]);
        int iC = k.x.s0.c(bArr[i2 + 4], bArr[i2 + 5]);
        this.e = iC & 255;
        boolean z = (iC & 16384) != 0;
        this.f2152i = z;
        this.f2153j = (iC & 32768) != 0;
        if (z) {
            this.e = this.f2156m.b() + this.e;
        }
        if (this.f2153j) {
            this.f = this.f2156m.getRow() + this.f;
        }
        int iC2 = k.x.s0.c(bArr[i2 + 6], bArr[i2 + 7]);
        this.g = iC2 & 255;
        boolean z2 = (iC2 & 16384) != 0;
        this.f2154k = z2;
        this.f2155l = (iC2 & 32768) != 0;
        if (z2) {
            this.g = this.f2156m.b() + this.g;
        }
        if (!this.f2155l) {
            return 8;
        }
        this.f2151h = this.f2156m.getRow() + this.f2151h;
        return 8;
    }
}
