package k.x.j1;

/* loaded from: classes.dex */
abstract class g1 extends p0 {
    private int e;
    private t0[] f;

    protected g1() {
    }

    @Override // k.x.j1.t0
    byte[] a() {
        return null;
    }

    public int j() {
        return this.e;
    }

    protected t0[] k() {
        return this.f;
    }

    public int l(byte[] bArr, int i2) {
        this.e = k.x.s0.c(bArr[i2], bArr[i2 + 1]);
        return 2;
    }

    protected final void m(int i2) {
        this.e = i2;
    }

    public void n(t0[] t0VarArr) {
        this.f = t0VarArr;
    }
}
