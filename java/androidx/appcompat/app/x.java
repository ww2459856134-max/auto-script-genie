package androidx.appcompat.app;

import android.view.View;

/* loaded from: classes.dex */
class x implements h.e.j.a0 {
    final /* synthetic */ t0 a;

    x(t0 t0Var) {
        this.a = t0Var;
    }

    @Override // h.e.j.a0
    public h.e.j.e1 a(View view, h.e.j.e1 e1Var) {
        int iH = e1Var.h();
        int iL0 = this.a.L0(e1Var, null);
        if (iH != iL0) {
            e1Var = e1Var.l(e1Var.f(), iL0, e1Var.g(), e1Var.e());
        }
        return h.e.j.s0.Q(view, e1Var);
    }
}
