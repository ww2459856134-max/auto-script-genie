package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class e implements View.OnAttachStateChangeListener {
    final /* synthetic */ i c;

    e(i iVar) {
        this.c = iVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.c.W;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.c.W = view.getViewTreeObserver();
            }
            i iVar = this.c;
            iVar.W.removeGlobalOnLayoutListener(iVar.t);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
