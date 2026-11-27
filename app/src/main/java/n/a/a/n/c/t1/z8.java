package n.a.a.n.c.t1;

/* loaded from: classes.dex */
class z8 implements f3 {
    Double a = null;

    z8(a9 a9Var) {
    }

    @Override // n.a.a.n.c.t1.f3
    public n.a.a.n.c.r1.w0 a() {
        Double d = this.a;
        return new n.a.a.n.c.r1.x(d == null ? 0.0d : d.doubleValue());
    }

    @Override // n.a.a.n.c.t1.f3
    public void b(n.a.a.n.c.r1.w0 w0Var) {
        double dR = w0Var instanceof n.a.a.n.c.r1.x ? ((n.a.a.n.c.r1.x) w0Var).r() : 0.0d;
        Double d = this.a;
        if (d == null || d.doubleValue() < dR) {
            this.a = Double.valueOf(dR);
        }
    }
}
