package k.x;

import k.a0.a.f2;

/* loaded from: classes.dex */
public class i0 extends c1 implements k.z.f {

    /* renamed from: o, reason: collision with root package name */
    public static final h0 f2029o;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private byte f2030h;

    /* renamed from: i, reason: collision with root package name */
    private byte f2031i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2032j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2033k;

    /* renamed from: l, reason: collision with root package name */
    private String f2034l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2035m;

    /* renamed from: n, reason: collision with root package name */
    private int f2036n;

    static {
        k.y.c.b(i0.class);
        f2029o = new h0();
    }

    protected i0(String str, int i2, int i3, boolean z, int i4, int i5, int i6) {
        super(z0.y0);
        this.e = i3;
        this.g = i4;
        this.f2034l = str;
        this.c = i2;
        this.f2032j = z;
        this.f = i6;
        this.d = i5;
        this.f2035m = false;
        this.f2033k = false;
    }

    public final int A() {
        return this.f2036n;
    }

    public final void B() {
        this.f2035m = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.c == i0Var.c && this.d == i0Var.d && this.e == i0Var.e && this.f == i0Var.f && this.g == i0Var.g && this.f2032j == i0Var.f2032j && this.f2033k == i0Var.f2033k && this.f2030h == i0Var.f2030h && this.f2031i == i0Var.f2031i && this.f2034l.equals(i0Var.f2034l);
    }

    public final void f(int i2) {
        this.f2036n = i2;
        this.f2035m = true;
    }

    public boolean g() {
        return this.f2033k;
    }

    @Override // k.z.f
    public String getName() {
        return this.f2034l;
    }

    public int hashCode() {
        return this.f2034l.hashCode();
    }

    public final boolean isInitialized() {
        return this.f2035m;
    }

    @Override // k.z.f
    public int k() {
        return this.c;
    }

    @Override // k.z.f
    public k.z.n l() {
        return k.z.n.a(this.g);
    }

    @Override // k.z.f
    public k.z.e n() {
        return k.z.e.a(this.d);
    }

    @Override // k.z.f
    public int s() {
        return this.e;
    }

    @Override // k.z.f
    public boolean t() {
        return this.f2032j;
    }

    @Override // k.z.f
    public k.z.m v() {
        return k.z.m.a(this.f);
    }

    @Override // k.x.c1
    public byte[] y() {
        byte[] bArr = new byte[(this.f2034l.length() * 2) + 16];
        s0.f(this.c * 20, bArr, 0);
        if (this.f2032j) {
            bArr[2] = (byte) (bArr[2] | 2);
        }
        if (this.f2033k) {
            bArr[2] = (byte) (bArr[2] | 8);
        }
        s0.f(this.d, bArr, 4);
        s0.f(this.e, bArr, 6);
        s0.f(this.f, bArr, 8);
        bArr[10] = (byte) this.g;
        bArr[11] = this.f2030h;
        bArr[12] = this.f2031i;
        bArr[13] = 0;
        bArr[14] = (byte) this.f2034l.length();
        bArr[15] = 1;
        y0.e(this.f2034l, bArr, 16);
        return bArr;
    }

    public i0(f2 f2Var, k.w wVar) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = s0.c(bArrC[0], bArrC[1]) / 20;
        this.d = s0.c(bArrC[4], bArrC[5]);
        this.e = s0.c(bArrC[6], bArrC[7]);
        this.f = s0.c(bArrC[8], bArrC[9]);
        this.g = bArrC[10];
        this.f2030h = bArrC[11];
        this.f2031i = bArrC[12];
        this.f2035m = false;
        if ((bArrC[2] & 2) != 0) {
            this.f2032j = true;
        }
        if ((bArrC[2] & 8) != 0) {
            this.f2033k = true;
        }
        byte b = bArrC[14];
        if (bArrC[15] == 0) {
            this.f2034l = y0.d(bArrC, b, 16, wVar);
        } else if (bArrC[15] == 1) {
            this.f2034l = y0.g(bArrC, b, 16);
        } else {
            this.f2034l = y0.d(bArrC, b, 15, wVar);
        }
    }

    public i0(f2 f2Var, k.w wVar, h0 h0Var) {
        super(f2Var);
        byte[] bArrC = x().c();
        this.c = s0.c(bArrC[0], bArrC[1]) / 20;
        this.d = s0.c(bArrC[4], bArrC[5]);
        this.e = s0.c(bArrC[6], bArrC[7]);
        this.f = s0.c(bArrC[8], bArrC[9]);
        this.g = bArrC[10];
        this.f2030h = bArrC[11];
        this.f2035m = false;
        if ((bArrC[2] & 2) != 0) {
            this.f2032j = true;
        }
        if ((bArrC[2] & 8) != 0) {
            this.f2033k = true;
        }
        this.f2034l = y0.d(bArrC, bArrC[14], 15, wVar);
    }

    protected i0(k.z.f fVar) {
        super(z0.y0);
        k.y.a.a(fVar != null);
        this.c = fVar.k();
        this.d = fVar.n().b();
        this.e = fVar.s();
        this.f = fVar.v().b();
        this.g = fVar.l().b();
        this.f2032j = fVar.t();
        this.f2034l = fVar.getName();
        this.f2033k = fVar.g();
        this.f2035m = false;
    }
}
