package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;

/* loaded from: classes.dex */
class d implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ i c;

    d(i iVar) {
        this.c = iVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.c.a() || this.c.f72k.size() <= 0 || this.c.f72k.get(0).a.w()) {
            return;
        }
        View view = this.c.I;
        if (view == null || !view.isShown()) {
            this.c.dismiss();
            return;
        }
        Iterator<h> it = this.c.f72k.iterator();
        while (it.hasNext()) {
            it.next().a.g();
        }
    }
}
