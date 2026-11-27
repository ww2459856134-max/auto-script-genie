package k.x.i1;

/* loaded from: classes.dex */
final class a0 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private b0 f2037h;

    /* renamed from: i, reason: collision with root package name */
    private c0 f2038i;

    static {
        k.y.c.b(a0.class);
    }

    public a0(c0 c0Var, int i2) {
        this.f2038i = c0Var;
        this.a = i2;
        byte[] data = c0Var.getData();
        this.f = data.length;
        int i3 = this.a;
        int iC = k.x.s0.c(data[i3], data[i3 + 1]);
        this.b = (65520 & iC) >> 4;
        this.c = iC & 15;
        int i4 = this.a;
        this.d = k.x.s0.c(data[i4 + 2], data[i4 + 3]);
        int i5 = this.a;
        this.e = k.x.s0.d(data[i5 + 4], data[i5 + 5], data[i5 + 6], data[i5 + 7]);
        if (this.c == 15) {
            this.g = true;
        } else {
            this.g = false;
        }
    }

    byte[] a() {
        byte[] bArr = new byte[this.e];
        System.arraycopy(this.f2038i.getData(), this.a + 8, bArr, 0, this.e);
        return bArr;
    }

    c0 b() {
        return this.f2038i;
    }

    int c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    int e() {
        return this.a;
    }

    int f() {
        return this.f;
    }

    b0 g() {
        if (this.f2037h == null) {
            this.f2037h = b0.a(this.d);
        }
        return this.f2037h;
    }

    public boolean h() {
        return this.g;
    }

    void i(boolean z) {
        this.g = z;
    }

    byte[] j(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 8];
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        if (this.g) {
            this.c = 15;
        }
        k.x.s0.f((this.b << 4) | this.c, bArr2, 0);
        k.x.s0.f(this.d, bArr2, 2);
        k.x.s0.a(bArr.length, bArr2, 4);
        return bArr2;
    }

    void k(int i2) {
        this.b = i2;
    }

    void l(int i2) {
        this.c = i2;
    }

    public a0(b0 b0Var) {
        this.f2037h = b0Var;
        this.d = b0Var.b();
    }
}
