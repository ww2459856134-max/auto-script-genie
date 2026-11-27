package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
class g extends t0 {
    final /* synthetic */ h t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(h hVar, View view, k kVar) {
        super(view);
        this.t = hVar;
    }

    @Override // androidx.appcompat.widget.t0
    public androidx.appcompat.view.menu.c0 b() {
        i iVar = this.t.e.U;
        if (iVar == null) {
            return null;
        }
        return iVar.c();
    }

    @Override // androidx.appcompat.widget.t0
    public boolean c() {
        this.t.e.L();
        return true;
    }

    @Override // androidx.appcompat.widget.t0
    public boolean d() {
        k kVar = this.t.e;
        if (kVar.W != null) {
            return false;
        }
        kVar.C();
        return true;
    }
}
