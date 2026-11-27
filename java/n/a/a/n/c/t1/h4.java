package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class h4 extends i4 {
    private final int b;

    public h4(int i2, g4 g4Var) {
        super(g4Var);
        this.b = i2;
    }

    @Override // n.a.a.n.c.t1.z3
    public boolean a(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            return c(((n.a.a.n.c.r1.o) w0Var).u() - this.b);
        }
        return false;
    }

    @Override // n.a.a.n.c.t1.i4
    protected String f() {
        return n.a.a.n.d.i0.b(this.b).f();
    }

    public int g() {
        return this.b;
    }
}
