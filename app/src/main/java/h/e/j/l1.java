package h.e.j;

import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
class l1 extends k1 {
    l1(e1 e1Var, WindowInsets windowInsets) {
        super(e1Var, windowInsets);
    }

    @Override // h.e.j.o1
    e1 a() {
        return e1.r(this.c.consumeDisplayCutout());
    }

    @Override // h.e.j.j1, h.e.j.o1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return Objects.equals(this.c, l1Var.c) && Objects.equals(this.f, l1Var.f);
    }

    @Override // h.e.j.o1
    h f() {
        return h.a(this.c.getDisplayCutout());
    }

    @Override // h.e.j.o1
    public int hashCode() {
        return this.c.hashCode();
    }

    l1(e1 e1Var, l1 l1Var) {
        super(e1Var, l1Var);
    }
}
