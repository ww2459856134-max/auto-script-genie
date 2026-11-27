package n.a.a.n.c.p1;

import n.a.a.n.c.r1.l0;
import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
public final class o implements j6 {
    public static final j6 a = new o();

    private o() {
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length < 3) {
            return n.a.a.n.c.r1.o.f2386i;
        }
        try {
            w0 w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[0], t0Var.t(), t0Var.k());
            int i2 = 1;
            while (i2 < w0VarArr.length - 1) {
                try {
                    w0 w0VarI2 = n.a.a.n.c.r1.z.i(w0VarArr[i2], t0Var.t(), t0Var.k());
                    w0 w0Var = w0VarArr[i2 + 1];
                    w0 w0VarK = l0.a.k(new w0[]{w0VarI, w0VarI2}, t0Var.t(), t0Var.k());
                    if ((w0VarK instanceof n.a.a.n.c.r1.m) && ((n.a.a.n.c.r1.m) w0VarK).u()) {
                        return w0Var;
                    }
                    i2 += 2;
                    if (i2 == w0VarArr.length - 1) {
                        return w0VarArr[w0VarArr.length - 1];
                    }
                } catch (n.a.a.n.c.r1.p unused) {
                    return n.a.a.n.c.r1.o.f2386i;
                }
            }
            return n.a.a.n.c.r1.o.f2386i;
        } catch (Exception unused2) {
            return n.a.a.n.c.r1.o.f2386i;
        }
    }
}
