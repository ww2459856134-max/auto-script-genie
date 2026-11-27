package k.a0.a;

/* loaded from: classes.dex */
public class p2 extends k.x.w0 {
    private byte[] c;
    private boolean d;
    private boolean e;
    private double f;
    private double g;

    /* renamed from: h, reason: collision with root package name */
    private int f1833h;

    /* renamed from: i, reason: collision with root package name */
    private int f1834i;

    /* renamed from: j, reason: collision with root package name */
    private int f1835j;

    /* renamed from: k, reason: collision with root package name */
    private int f1836k;

    /* renamed from: l, reason: collision with root package name */
    private int f1837l;

    /* renamed from: m, reason: collision with root package name */
    private int f1838m;

    /* renamed from: n, reason: collision with root package name */
    private int f1839n;

    /* renamed from: o, reason: collision with root package name */
    private int f1840o;
    private boolean p;

    static {
        k.y.c.b(p2.class);
    }

    p2(f2 f2Var) {
        super(k.x.z0.i0);
        byte[] bArrC = f2Var.c();
        this.c = bArrC;
        this.f1833h = k.x.s0.c(bArrC[0], bArrC[1]);
        byte[] bArr = this.c;
        this.f1834i = k.x.s0.c(bArr[2], bArr[3]);
        byte[] bArr2 = this.c;
        this.f1835j = k.x.s0.c(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.c;
        this.f1836k = k.x.s0.c(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.c;
        this.f1837l = k.x.s0.c(bArr4[8], bArr4[9]);
        byte[] bArr5 = this.c;
        this.f1838m = k.x.s0.c(bArr5[12], bArr5[13]);
        byte[] bArr6 = this.c;
        this.f1839n = k.x.s0.c(bArr6[14], bArr6[15]);
        byte[] bArr7 = this.c;
        this.f1840o = k.x.s0.c(bArr7[32], bArr7[33]);
        this.f = k.x.c0.b(this.c, 16);
        this.g = k.x.c0.b(this.c, 24);
        byte[] bArr8 = this.c;
        int iC = k.x.s0.c(bArr8[10], bArr8[11]);
        this.e = (iC & 1) != 0;
        this.d = (iC & 2) != 0;
        this.p = (iC & 4) == 0;
    }

    public int A() {
        return this.f1836k;
    }

    public double B() {
        return this.g;
    }

    public double C() {
        return this.f;
    }

    public int D() {
        return this.f1838m;
    }

    public boolean E() {
        return this.p;
    }

    public int F() {
        return this.f1835j;
    }

    public int G() {
        return this.f1833h;
    }

    public int H() {
        return this.f1834i;
    }

    public int I() {
        return this.f1839n;
    }

    public boolean J() {
        return this.d;
    }

    public boolean K() {
        return this.e;
    }

    public int y() {
        return this.f1840o;
    }

    public int z() {
        return this.f1837l;
    }
}
