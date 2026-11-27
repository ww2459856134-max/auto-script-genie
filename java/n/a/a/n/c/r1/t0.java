package n.a.a.n.c.r1;

import java.util.function.BiFunction;
import n.a.a.n.c.t1.c6;
import n.a.a.n.c.t1.p6;
import n.a.a.n.c.t1.x2;

/* loaded from: classes.dex */
public abstract class t0 extends c6 implements x2 {
    public static final p6 a = new o0();
    public static final p6 b = new p0();
    public static final p6 c = new q0();
    public static final p6 d = new r0();
    public static final p6 e = new s0();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ w0 n(w0 w0Var, w0 w0Var2) {
        try {
            return new x(l(z.e(w0Var), z.e(w0Var2)));
        } catch (p e2) {
            return e2.a();
        }
    }

    @Override // n.a.a.n.c.t1.x2
    public w0 h(w0[] w0VarArr, int i2, int i3) {
        return w0VarArr.length != 2 ? o.e : d(w0VarArr[0], w0VarArr[1], i2, i3, new BiFunction() { // from class: n.a.a.n.c.r1.e
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.a.n((w0) obj, (w0) obj2);
            }
        });
    }

    @Override // n.a.a.n.c.t1.m6
    public w0 i(int i2, int i3, w0 w0Var, w0 w0Var2) {
        try {
            double dL = l(o(w0Var, i2, i3), o(w0Var2, i2, i3));
            return (dL != 0.0d || (this instanceof s0)) ? (Double.isNaN(dL) || Double.isInfinite(dL)) ? o.f2385h : new x(dL) : x.c;
        } catch (p e2) {
            return e2.a();
        }
    }

    protected abstract double l(double d2, double d3) throws p;

    protected final double o(w0 w0Var, int i2, int i3) throws p {
        return z.e(z.i(w0Var, i2, i3));
    }
}
