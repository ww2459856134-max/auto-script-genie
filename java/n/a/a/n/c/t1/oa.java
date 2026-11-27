package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class oa implements j6 {
    public static final oa a = new oa();

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        try {
            if (w0VarArr.length == 0) {
                return new n.a.a.n.c.r1.x(t0Var.u() + 1.0d);
            }
            n.a.a.n.c.r1.w0 w0Var = w0VarArr[0];
            if (w0Var instanceof n.a.a.n.c.r1.c0) {
                return new n.a.a.n.c.r1.x(((n.a.a.n.c.r1.c0) w0Var).g() + 1.0d);
            }
            if (w0Var instanceof n.a.a.n.c.r1.j) {
                return new n.a.a.n.c.r1.x(((n.a.a.n.c.r1.j) w0Var).g() + 1.0d);
            }
            if (!(w0Var instanceof n.a.a.n.c.r1.m0)) {
                return n.a.a.n.c.r1.o.f2386i;
            }
            int iG = t0Var.v().g(((n.a.a.n.c.r1.m0) w0Var).getStringValue());
            return iG >= 0 ? new n.a.a.n.c.r1.x(iG + 1.0d) : n.a.a.n.c.r1.o.f2386i;
        } catch (Exception unused) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
