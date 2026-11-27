package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
class r extends q implements ActionProvider.VisibilityListener {
    private h.e.j.d e;

    r(v vVar, Context context, ActionProvider actionProvider) {
        super(vVar, context, actionProvider);
    }

    @Override // h.e.j.e
    public boolean b() {
        return this.c.isVisible();
    }

    @Override // h.e.j.e
    public View d(MenuItem menuItem) {
        return this.c.onCreateActionView(menuItem);
    }

    @Override // h.e.j.e
    public boolean g() {
        return this.c.overridesItemVisibility();
    }

    @Override // h.e.j.e
    public void j(h.e.j.d dVar) {
        this.e = dVar;
        this.c.setVisibilityListener(dVar != null ? this : null);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public void onActionProviderVisibilityChanged(boolean z) {
        h.e.j.d dVar = this.e;
        if (dVar != null) {
            dVar.onActionProviderVisibilityChanged(z);
        }
    }
}
