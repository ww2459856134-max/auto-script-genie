package k.x.i1;

/* loaded from: classes.dex */
abstract class z {
    private a0 a;

    protected z(a0 a0Var) {
        this.a = a0Var;
    }

    byte[] a() {
        return this.a.a();
    }

    abstract byte[] b();

    protected final c0 c() {
        return this.a.b();
    }

    protected final int d() {
        return this.a.c();
    }

    public int e() {
        return this.a.d() + 8;
    }

    protected final int f() {
        return this.a.e();
    }

    protected int g() {
        return this.a.f();
    }

    public b0 h() {
        return this.a.g();
    }

    protected void i(boolean z) {
        this.a.i(z);
    }

    final byte[] j(byte[] bArr) {
        return this.a.j(bArr);
    }

    protected final void k(int i2) {
        this.a.k(i2);
    }

    protected final void l(int i2) {
        this.a.l(i2);
    }

    protected z(b0 b0Var) {
        this.a = new a0(b0Var);
    }
}
