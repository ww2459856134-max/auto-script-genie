package n.a.a.n.c.t1;

/* loaded from: classes.dex */
class a3 implements f3 {
    Double a = Double.valueOf(0.0d);
    Integer b = 0;

    a3(b3 b3Var) {
    }

    @Override // n.a.a.n.c.t1.f3
    public n.a.a.n.c.r1.w0 a() {
        return this.b.intValue() == 0 ? n.a.a.n.c.r1.o.d : new n.a.a.n.c.r1.x(this.a.doubleValue() / this.b.intValue());
    }

    @Override // n.a.a.n.c.t1.f3
    public void b(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.x) {
            this.a = Double.valueOf(this.a.doubleValue() + ((n.a.a.n.c.r1.x) w0Var).r());
            this.b = Integer.valueOf(this.b.intValue() + 1);
        }
    }
}
