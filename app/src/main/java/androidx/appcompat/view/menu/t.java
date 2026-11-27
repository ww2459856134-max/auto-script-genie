package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* loaded from: classes.dex */
class t implements MenuItem.OnActionExpandListener {
    private final MenuItem.OnActionExpandListener a;
    final /* synthetic */ v b;

    t(v vVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.b = vVar;
        this.a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.a.onMenuItemActionCollapse(this.b.c(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.a.onMenuItemActionExpand(this.b.c(menuItem));
    }
}
