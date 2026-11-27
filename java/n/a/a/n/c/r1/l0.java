package n.a.a.n.c.r1;

import java.util.function.BiFunction;
import n.a.a.n.c.t1.c6;
import n.a.a.n.c.t1.p6;
import n.a.a.n.c.t1.x2;

/* loaded from: classes.dex */
public abstract class l0 extends c6 implements x2 {
    public static final p6 a = new f0();
    public static final p6 b = new g0();
    public static final p6 c = new h0();
    public static final p6 d = new i0();
    public static final p6 e = new j0();
    public static final p6 f = new k0();

    private static int l(w0 w0Var) {
        if (w0Var == l.a || (w0Var instanceof u)) {
            return 0;
        }
        if (w0Var instanceof m) {
            return ((m) w0Var).u() ? -1 : 0;
        }
        if (w0Var instanceof x) {
            return n.a.a.n.e.b0.a(0.0d, ((x) w0Var).r());
        }
        if (w0Var instanceof m0) {
            return ((m0) w0Var).getStringValue().length() < 1 ? 0 : -1;
        }
        throw new IllegalArgumentException("bad value class (" + w0Var.getClass().getName() + ")");
    }

    private static int n(w0 w0Var, w0 w0Var2) {
        l lVar = l.a;
        if (w0Var == lVar || (w0Var instanceof u)) {
            return l(w0Var2);
        }
        if (w0Var2 == lVar || (w0Var2 instanceof u)) {
            return -l(w0Var);
        }
        if (w0Var instanceof m) {
            if (!(w0Var2 instanceof m)) {
                return 1;
            }
            m mVar = (m) w0Var;
            if (mVar.u() == ((m) w0Var2).u()) {
                return 0;
            }
            return mVar.u() ? 1 : -1;
        }
        if (w0Var2 instanceof m) {
            return -1;
        }
        if (w0Var instanceof m0) {
            if (w0Var2 instanceof m0) {
                return ((m0) w0Var).getStringValue().compareToIgnoreCase(((m0) w0Var2).getStringValue());
            }
            return 1;
        }
        if (w0Var2 instanceof m0) {
            return -1;
        }
        if ((w0Var instanceof x) && (w0Var2 instanceof x)) {
            return n.a.a.n.e.b0.a(((x) w0Var).r(), ((x) w0Var2).r());
        }
        throw new IllegalArgumentException("Bad operand types (" + w0Var.getClass().getName() + "), (" + w0Var2.getClass().getName() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ w0 p(w0 w0Var, w0 w0Var2) {
        return m.v(m(n(w0Var, w0Var2)));
    }

    @Override // n.a.a.n.c.t1.x2
    public w0 h(w0[] w0VarArr, int i2, int i3) {
        return d(w0VarArr[0], w0VarArr[1], i2, i3, new BiFunction() { // from class: n.a.a.n.c.r1.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.a.p((w0) obj, (w0) obj2);
            }
        });
    }

    @Override // n.a.a.n.c.t1.m6
    public w0 i(int i2, int i3, w0 w0Var, w0 w0Var2) {
        try {
            return m.v(m(n(z.i(w0Var, i2, i3), z.i(w0Var2, i2, i3))));
        } catch (p e2) {
            return e2.a();
        }
    }

    protected abstract boolean m(int i2);
}
