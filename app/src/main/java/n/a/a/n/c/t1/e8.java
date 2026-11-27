package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class e8 extends c8 {
    private final double b;

    protected e8(n.a.a.n.c.r1.x xVar) {
        super(xVar);
        this.b = xVar.r();
    }

    @Override // n.a.a.n.c.t1.c8
    protected a8 b(n.a.a.n.c.r1.w0 w0Var) {
        return a8.f(Double.compare(this.b, ((n.a.a.n.c.r1.x) w0Var).r()));
    }

    @Override // n.a.a.n.c.t1.c8
    protected String c() {
        return String.valueOf(this.b);
    }
}
