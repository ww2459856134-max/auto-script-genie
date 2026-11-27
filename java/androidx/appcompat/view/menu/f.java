package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ h c;
    final /* synthetic */ MenuItem d;
    final /* synthetic */ m e;
    final /* synthetic */ g f;

    f(g gVar, h hVar, MenuItem menuItem, m mVar) {
        this.f = gVar;
        this.c = hVar;
        this.d = menuItem;
        this.e = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.c;
        if (hVar != null) {
            this.f.c.a0 = true;
            hVar.b.e(false);
            this.f.c.a0 = false;
        }
        if (this.d.isEnabled() && this.d.hasSubMenu()) {
            this.e.L(this.d, 4);
        }
    }
}
