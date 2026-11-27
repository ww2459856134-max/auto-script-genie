package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.d8;
import n.a.a.n.c.t1.g8;
import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.n8;

/* loaded from: classes.dex */
final class x implements j6 {
    public static final j6 a = new x(c.a);

    private x(c cVar) {
    }

    private w0 a(w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        d8 d8VarN = d8.ExactMatch;
        if (w0VarArr.length > 2) {
            try {
                d8VarN = n8.n(n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[2], i2, i3)));
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            } catch (Exception unused) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        d8 d8Var = d8VarN;
        g8 g8VarS = g8.IterateForward;
        if (w0VarArr.length > 3) {
            try {
                g8VarS = n8.s(n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[3], i2, i3)));
            } catch (n.a.a.n.c.r1.p e2) {
                return e2.a();
            } catch (Exception unused2) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        return b(i2, i3, w0VarArr[0], w0VarArr[1], d8Var, g8VarS);
    }

    private w0 b(int i2, int i3, w0 w0Var, w0 w0Var2, d8 d8Var, g8 g8Var) {
        try {
            w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            return new n.a.a.n.c.r1.x(n8.t(w0VarI, n8.r(w0Var2).s() ? n8.b(r2, 0) : n8.d(r2, 0), d8Var, g8Var) + 1.0d);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        return a(w0VarArr, t0Var.t(), t0Var.k());
    }
}
