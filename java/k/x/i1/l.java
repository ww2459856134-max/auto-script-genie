package k.x.i1;

/* loaded from: classes.dex */
class l extends x {
    private byte[] c;
    private int d;
    private int e;
    private int f;

    public l(a0 a0Var) {
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

    public l(int i2) {
        super(b0.f2042k);
        this.d = 1;
        int i3 = i2 + 1;
        this.e = i3;
        this.f = i3 + 1024 + 1;
        k(1);
    }
}
