package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView;

/* loaded from: classes.dex */
class e extends ActionMenuItemView.b {
    final /* synthetic */ k a;

    e(k kVar) {
        this.a = kVar;
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
    public androidx.appcompat.view.menu.c0 a() {
        d dVar = this.a.V;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }
}
