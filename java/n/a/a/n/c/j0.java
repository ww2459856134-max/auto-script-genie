package n.a.a.n.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class j0 {
    private final Map<i0, h0> a = new HashMap();

    private h0 b(t tVar, int i2, int i3) {
        i0 i0Var = new i0(i2, i3);
        h0 h0Var = this.a.get(i0Var);
        if (h0Var != null) {
            return h0Var;
        }
        h0 h0Var2 = new h0(tVar.l(i3).d());
        this.a.put(i0Var, h0Var2);
        return h0Var2;
    }

    public void a(t tVar, int i2, int i3, int i4, int i5) {
        b(tVar, i2, i3).a(i4, i5);
    }

    public boolean c() {
        return this.a.isEmpty();
    }
}
