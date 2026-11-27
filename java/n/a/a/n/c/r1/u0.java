package n.a.a.n.c.r1;

import java.util.function.Function;
import n.a.a.n.c.t1.b6;
import n.a.a.n.c.t1.p6;
import n.a.a.n.c.t1.x2;

/* loaded from: classes.dex */
public final class u0 extends b6 implements x2 {
    public static final p6 a = new u0();

    private u0() {
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public w0 m(int i2, int i3, w0 w0Var) {
        try {
            double dE = z.e(z.i(w0Var, i2, i3));
            return dE == 0.0d ? x.c : new x(-dE);
        } catch (p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.x2
    public w0 h(w0[] w0VarArr, final int i2, final int i3) {
        return w0VarArr.length != 1 ? o.e : a(w0VarArr[0], i2, i3, new Function() { // from class: n.a.a.n.c.r1.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.m(i2, i3, (w0) obj);
            }
        });
    }
}
