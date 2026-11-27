package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
class d0 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ f0 c;

    d0(f0 f0Var) {
        this.c = f0Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.c.a() || this.c.f68k.w()) {
            return;
        }
        View view = this.c.G;
        if (view == null || !view.isShown()) {
            this.c.dismiss();
        } else {
            this.c.f68k.g();
        }
    }
}
