package n.a.a.n.c.t1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class u9 implements p6 {
    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            double dC = a6.c(y9.D(w0VarArr[0], i2, i3), u2.p((n.a.a.n.c.r1.w0[]) Arrays.copyOfRange(w0VarArr, 1, w0VarArr.length, n.a.a.n.c.r1.w0[].class)));
            y9.a(dC);
            return new n.a.a.n.c.r1.x(dC);
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
