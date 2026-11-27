package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class j4 extends i4 {
    private final double b;

    public j4(double d, g4 g4Var) {
        super(g4Var);
        this.b = d;
    }

    @Override // n.a.a.n.c.t1.z3
    public boolean a(n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.m0)) {
            return w0Var instanceof n.a.a.n.c.r1.x ? c(Double.compare(((n.a.a.n.c.r1.x) w0Var).r(), this.b)) : (w0Var instanceof n.a.a.n.c.r1.l) && e() == 2;
        }
        int iE = e();
        if (iE != 0 && iE != 1) {
            return iE == 2;
        }
        Double dK = n.a.a.n.c.r1.z.k(((n.a.a.n.c.r1.m0) w0Var).getStringValue());
        return dK != null && this.b == dK.doubleValue();
    }

    @Override // n.a.a.n.c.t1.i4
    protected String f() {
        return String.valueOf(this.b);
    }
}
