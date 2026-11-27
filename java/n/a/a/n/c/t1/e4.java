package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class e4 extends b6 {
    private static final z3 a = new z3() { // from class: n.a.a.n.c.t1.l
        @Override // n.a.a.n.c.t1.z3
        public final boolean a(n.a.a.n.c.r1.w0 w0Var) {
            return e4.l(w0Var);
        }
    };

    static /* synthetic */ boolean l(n.a.a.n.c.r1.w0 w0Var) {
        return w0Var == n.a.a.n.c.r1.l.a || ((w0Var instanceof n.a.a.n.c.r1.m0) && ((n.a.a.n.c.r1.m0) w0Var).getStringValue().isEmpty());
    }

    @Override // n.a.a.n.c.t1.l6
    public n.a.a.n.c.r1.w0 g(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        int iB;
        if (w0Var instanceof n.a.a.n.c.r1.c0) {
            iB = a4.c((n.a.a.n.c.r1.c0) w0Var, a);
        } else {
            if (!(w0Var instanceof n.a.a.n.c.i1)) {
                throw new IllegalArgumentException("Bad range arg type (" + w0Var.getClass().getName() + ")");
            }
            iB = a4.b((n.a.a.n.c.i1) w0Var, a);
        }
        return new n.a.a.n.c.r1.x(iB);
    }
}
