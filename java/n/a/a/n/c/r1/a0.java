package n.a.a.n.c.r1;

import n.a.a.n.c.t1.b6;
import n.a.a.n.c.t1.p6;

/* loaded from: classes.dex */
public final class a0 extends b6 {
    public static final p6 a = new a0();

    private a0() {
    }

    @Override // n.a.a.n.c.t1.l6
    public w0 g(int i2, int i3, w0 w0Var) {
        try {
            double dE = z.e(z.i(w0Var, i2, i3));
            return dE == 0.0d ? x.c : new x(dE / 100.0d);
        } catch (p e) {
            return e.a();
        }
    }
}
