package n.a.a.n.c.r1;

import n.a.a.n.c.t1.c6;
import n.a.a.n.c.t1.p6;

/* loaded from: classes.dex */
public final class n extends c6 {
    public static final p6 a = new n();

    private n() {
    }

    private Object l(w0 w0Var) {
        if (w0Var instanceof n0) {
            return ((n0) w0Var).getStringValue();
        }
        if (w0Var == l.a) {
            return "";
        }
        throw new IllegalAccessError("Unexpected value type (" + w0Var.getClass().getName() + ")");
    }

    @Override // n.a.a.n.c.t1.m6
    public w0 i(int i2, int i3, w0 w0Var, w0 w0Var2) {
        try {
            w0 w0VarI = z.i(w0Var, i2, i3);
            w0 w0VarI2 = z.i(w0Var2, i2, i3);
            StringBuilder sb = new StringBuilder();
            sb.append(l(w0VarI));
            sb.append(l(w0VarI2));
            return new m0(sb.toString());
        } catch (p e) {
            return e.a();
        }
    }
}
