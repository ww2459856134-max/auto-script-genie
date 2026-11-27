package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class u4 implements u6 {
    private n.a.a.n.c.r1.w0 a;

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        n.a.a.n.c.r1.w0 w0Var = this.a;
        return w0Var == null ? n.a.a.n.c.r1.x.c : w0Var;
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.y)) {
            return true;
        }
        if (this.a == null) {
            this.a = w0Var;
            return true;
        }
        if (((n.a.a.n.c.r1.y) w0Var).r() >= ((n.a.a.n.c.r1.y) this.a).r()) {
            return true;
        }
        this.a = w0Var;
        return true;
    }
}
