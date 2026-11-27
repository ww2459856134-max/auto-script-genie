package androidx.appcompat.app;

import android.view.View;

/* loaded from: classes.dex */
class c0 extends h.e.j.b1 {
    final /* synthetic */ t0 a;

    c0(t0 t0Var) {
        this.a = t0Var;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        this.a.I.setAlpha(1.0f);
        this.a.M.f(null);
        this.a.M = null;
    }

    @Override // h.e.j.b1, h.e.j.a1
    public void c(View view) {
        this.a.I.setVisibility(0);
        this.a.I.sendAccessibilityEvent(32);
        if (this.a.I.getParent() instanceof View) {
            h.e.j.s0.W((View) this.a.I.getParent());
        }
    }
}
