package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class e0 implements View.OnAttachStateChangeListener {
    final /* synthetic */ f0 c;

    e0(f0 f0Var) {
        this.c = f0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.c.I;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.c.I = view.getViewTreeObserver();
            }
            f0 f0Var = this.c;
            f0Var.I.removeGlobalOnLayoutListener(f0Var.t);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
