package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class c5 implements u6 {
    private double a = 0.0d;

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        return new n.a.a.n.c.r1.x(this.a);
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return true;
        }
        this.a += ((n.a.a.n.c.r1.y) w0Var).r();
        return true;
    }
}
