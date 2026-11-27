package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
class q extends h.e.j.e {
    final ActionProvider c;
    final /* synthetic */ v d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(v vVar, Context context, ActionProvider actionProvider) {
        super(context);
        this.d = vVar;
        this.c = actionProvider;
    }

    @Override // h.e.j.e
    public boolean a() {
        return this.c.hasSubMenu();
    }

    @Override // h.e.j.e
    public View c() {
        return this.c.onCreateActionView();
    }

    @Override // h.e.j.e
    public boolean e() {
        return this.c.onPerformDefaultAction();
    }

    @Override // h.e.j.e
    public void f(SubMenu subMenu) {
        ActionProvider actionProvider = this.c;
        this.d.d(subMenu);
        actionProvider.onPrepareSubMenu(subMenu);
    }
}
