package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
abstract class c {
    final Context a;
    private h.d.i<h.e.e.a.b, MenuItem> b;
    private h.d.i<Object, SubMenu> c;

    c(Context context) {
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof h.e.e.a.b)) {
            return menuItem;
        }
        h.e.e.a.b bVar = (h.e.e.a.b) menuItem;
        if (this.b == null) {
            this.b = new h.d.i<>();
        }
        MenuItem menuItem2 = this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        v vVar = new v(this.a, bVar);
        this.b.put(bVar, vVar);
        return vVar;
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    final void e() {
        h.d.i<h.e.e.a.b, MenuItem> iVar = this.b;
        if (iVar != null) {
            iVar.clear();
        }
        h.d.i<Object, SubMenu> iVar2 = this.c;
        if (iVar2 != null) {
            iVar2.clear();
        }
    }

    final void f(int i2) {
        if (this.b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.b.size()) {
            if (this.b.i(i3).getGroupId() == i2) {
                this.b.k(i3);
                i3--;
            }
            i3++;
        }
    }

    final void g(int i2) {
        if (this.b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            if (this.b.i(i3).getItemId() == i2) {
                this.b.k(i3);
                return;
            }
        }
    }
}
