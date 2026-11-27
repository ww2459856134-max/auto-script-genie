package k.x.i1;

/* loaded from: classes.dex */
class n0 extends x {
    private byte[] c;
    private int d;
    private int e;
    private int f;

    static {
        k.y.c.b(n0.class);
    }

    public n0(a0 a0Var) {
        super(a0Var);
        this.d = d();
        byte[] bArrA = a();
        this.e = k.x.s0.d(bArrA[0], bArrA[1], bArrA[2], bArrA[3]);
        this.f = k.x.s0.d(bArrA[4], bArrA[5], bArrA[6], bArrA[7]);
    }

    @Override // k.x.i1.x, k.x.i1.z
    byte[] b() {
        byte[] bArr = new byte[8];
        this.c = bArr;
        k.x.s0.a(this.e, bArr, 0);
        k.x.s0.a(this.f, this.c, 4);
        return j(this.c);
    }

    int m() {
        return this.e;
    }

    int n() {
        return this.d;
    }

    public n0(l0 l0Var, int i2, int i3) {
        super(b0.f2044m);
        l(2);
        int iB = l0Var.b();
        this.d = iB;
        this.e = i2;
        this.f = i3;
        k(iB);
    }
}
