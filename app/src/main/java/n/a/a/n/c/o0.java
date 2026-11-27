package n.a.a.n.c;

/* loaded from: classes.dex */
public final class o0 extends n.a.a.n.c.r1.d0 {
    private final f1 e;

    public o0(int i2, int i3, f1 f1Var) {
        super(f1Var, i2, i3);
        this.e = f1Var;
    }

    @Override // n.a.a.n.c.r1.c0
    public n.a.a.n.c.r1.j c(int i2, int i3, int i4, int i5) {
        return new n0(new n.a.a.n.c.u1.c1(getRow(), b(), i2, i3, i4, i5), this.e);
    }

    @Override // n.a.a.n.c.r1.c0
    public n.a.a.n.c.r1.w0 o(int i2) {
        return this.e.f(i2, getRow(), b());
    }

    public String toString() {
        return o0.class.getName() + "[" + this.e.p() + '!' + new n.a.a.n.e.s(getRow(), b()).g() + "]";
    }

    public n.a.a.n.c.r1.w0 u() {
        f1 f1Var = this.e;
        return f1Var.f(f1Var.g(), getRow(), b());
    }

    public boolean v() {
        f1 f1Var = this.e;
        return f1Var.h(f1Var.g()).f(getRow());
    }

    public boolean w() {
        return this.e.h(g()).g(getRow(), b());
    }
}
