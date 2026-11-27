package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* loaded from: classes.dex */
class d1 extends h.e.j.b1 {
    final /* synthetic */ h1 a;

    d1(h1 h1Var) {
        this.a = h1Var;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        View view2;
        h1 h1Var = this.a;
        if (h1Var.q && (view2 = h1Var.g) != null) {
            view2.setTranslationY(0.0f);
            this.a.d.setTranslationY(0.0f);
        }
        this.a.d.setVisibility(8);
        this.a.d.setTransitioning(false);
        h1 h1Var2 = this.a;
        h1Var2.v = null;
        h1Var2.x();
        ActionBarOverlayLayout actionBarOverlayLayout = this.a.c;
        if (actionBarOverlayLayout != null) {
            h.e.j.s0.W(actionBarOverlayLayout);
        }
    }
}
