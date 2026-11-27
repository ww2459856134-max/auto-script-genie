package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class v4 implements u6 {
    private double a;
    private boolean b = false;

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        return new n.a.a.n.c.r1.x(this.a);
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        if (w0Var instanceof n.a.a.n.c.r1.y) {
            if (this.b) {
                this.a *= ((n.a.a.n.c.r1.y) w0Var).r();
            } else {
                this.a = ((n.a.a.n.c.r1.y) w0Var).r();
                this.b = true;
            }
        }
        return true;
    }
}
