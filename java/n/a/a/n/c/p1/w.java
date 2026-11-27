package n.a.a.n.c.p1;

import n.a.a.n.c.j1;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.d8;
import n.a.a.n.c.t1.g8;
import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.n8;
import n.a.a.n.c.t1.x2;

/* loaded from: classes.dex */
final class w implements j6, x2 {
    public static final j6 a = new w(c.a);

    private w(c cVar) {
    }

    private w0 e(w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 3) {
            return n.a.a.n.c.r1.o.e;
        }
        w0 w0Var = n.a.a.n.c.r1.l.a;
        if (w0VarArr.length > 3) {
            try {
                w0 w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[3], i2, i3);
                if (w0VarI != null) {
                    w0Var = w0VarI;
                }
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            }
        }
        w0 w0Var2 = w0Var;
        d8 d8VarN = d8.ExactMatch;
        if (w0VarArr.length > 4) {
            try {
                d8VarN = n8.n(n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[4], i2, i3)));
            } catch (n.a.a.n.c.r1.p e2) {
                return e2.a();
            } catch (Exception unused) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        d8 d8Var = d8VarN;
        g8 g8VarS = g8.IterateForward;
        if (w0VarArr.length > 5) {
            try {
                g8VarS = n8.s(n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0VarArr[5], i2, i3)));
            } catch (n.a.a.n.c.r1.p e3) {
                return e3.a();
            } catch (Exception unused2) {
                return n.a.a.n.c.r1.o.e;
            }
        }
        return g(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2], w0Var2, d8Var, g8VarS);
    }

    private w0 g(int i2, int i3, w0 w0Var, w0 w0Var2, w0 w0Var3, w0 w0Var4, d8 d8Var, g8 g8Var) {
        int width;
        try {
            w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            j1 j1VarR = n8.r(w0Var2);
            try {
                int iT = n8.t(w0VarI, j1VarR.s() ? n8.b(j1VarR, 0) : n8.d(j1VarR, 0), d8Var, g8Var);
                if (!(w0Var3 instanceof n.a.a.n.c.r1.j)) {
                    return w0Var3;
                }
                n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var3;
                return j1VarR.s() ? jVar.c(iT, iT, 0, jVar.getWidth() - 1) : jVar.c(0, jVar.a() - 1, iT, iT);
            } catch (n.a.a.n.c.r1.p e) {
                return n.a.a.n.c.r1.o.f2386i.equals(e.a()) ? w0Var4 != n.a.a.n.c.r1.l.a ? (!(w0Var3 instanceof n.a.a.n.c.r1.j) || (width = ((n.a.a.n.c.r1.j) w0Var3).getWidth()) <= 1) ? w0Var4 : i(w0Var4, width) : n.a.a.n.c.r1.o.f2386i : e.a();
            }
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    private n.a.a.n.c.r1.j i(w0 w0Var, int i2) {
        return new v(this, i2, w0Var);
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        return e(w0VarArr, t0Var.t(), t0Var.k());
    }

    @Override // n.a.a.n.c.t1.x2
    public w0 h(w0[] w0VarArr, int i2, int i3) {
        return e(w0VarArr, i2, i3);
    }
}
