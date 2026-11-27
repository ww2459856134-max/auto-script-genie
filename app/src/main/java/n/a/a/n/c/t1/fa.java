package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public class fa implements j6 {
    public static final fa a = new fa();

    private static void a(double d) throws n.a.a.n.c.r1.p {
        y9.a(d);
        if (d < 0.0d) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.f2385h);
        }
    }

    public static n.a.a.n.c.r1.w0 b(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length != 3) {
            return n.a.a.n.c.r1.o.e;
        }
        n.a.a.n.c.r1.w0 w0Var = w0VarArr[0];
        n.a.a.n.c.r1.w0 w0Var2 = w0VarArr[1];
        n.a.a.n.c.r1.w0 w0Var3 = w0VarArr[2];
        try {
            try {
                double D = y9.D(w0Var, i2, i3);
                double D2 = y9.D(w0Var2, i2, i3);
                if (d(D, D2)) {
                    return new n.a.a.n.c.r1.x(1.0d);
                }
                a(D);
                a(D2);
                boolean zU = ((n.a.a.n.c.r1.m) w0Var3).u();
                i.b.ha.a.e.a.e eVar = new i.b.ha.a.e.a.e(D2);
                double dA = zU ? eVar.a((int) D) : eVar.c((int) D);
                y9.a(dA);
                return new n.a.a.n.c.r1.x(dA);
            } catch (n.a.a.n.c.r1.p unused) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static boolean d(double d, double d2) {
        return d == 0.0d && d2 == 0.0d;
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) {
        return b(w0VarArr, t0Var.t(), t0Var.k());
    }
}
