package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
class f implements Runnable {
    private i c;
    final /* synthetic */ k d;

    public f(k kVar, i iVar) {
        this.d = kVar;
        this.c = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (((androidx.appcompat.view.menu.b) this.d).e != null) {
            ((androidx.appcompat.view.menu.b) this.d).e.d();
        }
        View view = (View) ((androidx.appcompat.view.menu.b) this.d).f64j;
        if (view != null && view.getWindowToken() != null && this.c.m()) {
            this.d.U = this.c;
        }
        this.d.W = null;
    }
}
