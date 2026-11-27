package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class e0 extends h.e.j.b1 {
    final /* synthetic */ f0 a;

    e0(f0 f0Var) {
        this.a = f0Var;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        this.a.b.I.setVisibility(8);
        t0 t0Var = this.a.b;
        PopupWindow popupWindow = t0Var.J;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (t0Var.I.getParent() instanceof View) {
            h.e.j.s0.W((View) this.a.b.I.getParent());
        }
        this.a.b.I.k();
        this.a.b.M.f(null);
        t0 t0Var2 = this.a.b;
        t0Var2.M = null;
        h.e.j.s0.W(t0Var2.Q);
    }
}
