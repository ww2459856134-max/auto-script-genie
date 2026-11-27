package n.a.a.n.c.p1;

import n.a.a.n.c.r1.w0;
import n.a.a.n.c.t0;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
final class f implements j6 {
    public static final j6 a = new f();

    private f() {
    }

    @Override // n.a.a.n.c.t1.j6
    public w0 c(w0[] w0VarArr, t0 t0Var) {
        if (w0VarArr.length % 2 != 0) {
            return n.a.a.n.c.r1.o.e;
        }
        for (int i2 = 0; i2 < w0VarArr.length; i2 += 2) {
            if (((n.a.a.n.c.r1.m) w0VarArr[i2]).u()) {
                return w0VarArr[i2 + 1];
            }
        }
        return n.a.a.n.c.r1.o.f2386i;
    }
}
