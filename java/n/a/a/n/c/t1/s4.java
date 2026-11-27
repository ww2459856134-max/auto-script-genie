package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class s4 implements u6 {
    private n.a.a.n.c.r1.w0 a;

    @Override // n.a.a.n.c.t1.u6
    public n.a.a.n.c.r1.w0 a() {
        n.a.a.n.c.r1.w0 w0Var = this.a;
        if (w0Var == null) {
            return n.a.a.n.c.r1.o.e;
        }
        if (w0Var instanceof n.a.a.n.c.r1.l) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            return n.a.a.n.c.r1.z.g(n.a.a.n.c.r1.z.i(w0Var, 0, 0)).isEmpty() ? n.a.a.n.c.r1.o.e : this.a;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.u6
    public boolean b(n.a.a.n.c.r1.w0 w0Var) {
        n.a.a.n.c.r1.w0 w0Var2 = this.a;
        if (w0Var2 == null) {
            this.a = w0Var;
            return true;
        }
        if (w0Var2 instanceof n.a.a.n.c.r1.l) {
            this.a = w0Var;
            return true;
        }
        if (w0Var instanceof n.a.a.n.c.r1.l) {
            return true;
        }
        this.a = n.a.a.n.c.r1.o.f2385h;
        return false;
    }
}
