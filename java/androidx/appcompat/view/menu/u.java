package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* loaded from: classes.dex */
class u implements MenuItem.OnMenuItemClickListener {
    private final MenuItem.OnMenuItemClickListener a;
    final /* synthetic */ v b;

    u(v vVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.b = vVar;
        this.a = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.onMenuItemClick(this.b.c(menuItem));
    }
}
