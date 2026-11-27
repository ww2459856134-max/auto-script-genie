package n.a.a.n.c.t1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class q6 implements j6 {
    public static final q6 a = new q6();
    private static final long b = (long) Math.pow(2.0d, 53.0d);

    private boolean a(double d) {
        return d < 0.0d || d > ((double) b);
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, n.a.a.n.c.t0 t0Var) throws i.b.ha.a.e.b.c {
        if (w0VarArr.length < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        if (w0VarArr.length == 1) {
            try {
                return a(n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k()))) ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x((long) r9);
            } catch (n.a.a.n.c.r1.p unused) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
                double dE = n.a.a.n.c.r1.z.e(n.a.a.n.c.r1.z.i(w0Var, t0Var.t(), t0Var.k()));
                if (a(dE)) {
                    return n.a.a.n.c.r1.o.f2385h;
                }
                arrayList.add(Long.valueOf((long) dE));
            }
            long jLongValue = ((Long) arrayList.get(0)).longValue();
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                jLongValue = i.b.ha.a.e.g.a.a(jLongValue, ((Long) arrayList.get(i2)).longValue());
            }
            return new n.a.a.n.c.r1.x(jLongValue);
        } catch (n.a.a.n.c.r1.p unused2) {
            return n.a.a.n.c.r1.o.e;
        }
    }
}
