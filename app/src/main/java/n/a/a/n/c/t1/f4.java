package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class f4 extends i4 {
    private final int b;

    public f4(boolean z, g4 g4Var) {
        super(g4Var);
        g(z);
        this.b = z ? 1 : 0;
    }

    private static int g(boolean z) {
        return z ? 1 : 0;
    }

    @Override // n.a.a.n.c.t1.z3
    public boolean a(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.m0) {
            return false;
        }
        if (!(w0Var instanceof n.a.a.n.c.r1.m)) {
            return w0Var instanceof n.a.a.n.c.r1.l ? e() == 2 : (w0Var instanceof n.a.a.n.c.r1.x) && e() == 2;
        }
        boolean zU = ((n.a.a.n.c.r1.m) w0Var).u();
        g(zU);
        return c((zU ? 1 : 0) - this.b);
    }

    @Override // n.a.a.n.c.t1.i4
    protected String f() {
        return this.b == 1 ? "TRUE" : "FALSE";
    }
}
