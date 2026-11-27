package androidx.appcompat.widget;

import android.view.ViewParent;

/* loaded from: classes.dex */
class r0 implements Runnable {
    final /* synthetic */ t0 c;

    r0(t0 t0Var) {
        this.c = t0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewParent parent = this.c.f.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
