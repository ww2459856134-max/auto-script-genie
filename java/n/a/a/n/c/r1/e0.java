package n.a.a.n.c.r1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e0 implements w0 {
    private final List<w0> a = new ArrayList();

    public e0(w0 w0Var, w0 w0Var2) {
        u(w0Var);
        u(w0Var2);
    }

    private void u(w0 w0Var) {
        if (w0Var instanceof e0) {
            this.a.addAll(((e0) w0Var).a);
        } else {
            this.a.add(w0Var);
        }
    }

    public List<w0> v() {
        return this.a;
    }
}
