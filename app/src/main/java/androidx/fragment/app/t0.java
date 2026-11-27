package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class t0 implements View.OnAttachStateChangeListener {
    final /* synthetic */ b2 c;
    final /* synthetic */ u0 d;

    t0(u0 u0Var, b2 b2Var) {
        this.d = u0Var;
        this.c = b2Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Fragment fragmentK = this.c.k();
        this.c.m();
        j3.n((ViewGroup) fragmentK.h0.getParent(), this.d.c).j();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
