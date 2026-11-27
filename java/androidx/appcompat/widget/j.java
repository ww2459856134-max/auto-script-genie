package androidx.appcompat.widget;

import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
class j implements z.a {
    final /* synthetic */ k c;

    j(k kVar) {
        this.c = kVar;
    }

    @Override // androidx.appcompat.view.menu.z.a
    public void b(androidx.appcompat.view.menu.m mVar, boolean z) {
        if (mVar instanceof androidx.appcompat.view.menu.g0) {
            mVar.D().e(false);
        }
        z.a aVarN = this.c.n();
        if (aVarN != null) {
            aVarN.b(mVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.z.a
    public boolean c(androidx.appcompat.view.menu.m mVar) {
        if (mVar == ((androidx.appcompat.view.menu.b) this.c).e) {
            return false;
        }
        this.c.b0 = ((androidx.appcompat.view.menu.g0) mVar).getItem().getItemId();
        z.a aVarN = this.c.n();
        if (aVarN != null) {
            return aVarN.c(mVar);
        }
        return false;
    }
}
