package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
class z1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ View c;

    z1(b2 b2Var, View view) {
        this.c = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.c.removeOnAttachStateChangeListener(this);
        h.e.j.s0.W(this.c);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
