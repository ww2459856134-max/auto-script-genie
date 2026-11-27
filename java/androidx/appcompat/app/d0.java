package androidx.appcompat.app;

import android.view.Window;
import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
final class d0 implements z.a {
    final /* synthetic */ t0 c;

    d0(t0 t0Var) {
        this.c = t0Var;
    }

    @Override // androidx.appcompat.view.menu.z.a
    public void b(androidx.appcompat.view.menu.m mVar, boolean z) {
        this.c.L(mVar);
    }

    @Override // androidx.appcompat.view.menu.z.a
    public boolean c(androidx.appcompat.view.menu.m mVar) {
        Window.Callback callbackF0 = this.c.f0();
        if (callbackF0 == null) {
            return true;
        }
        callbackF0.onMenuOpened(108, mVar);
        return true;
    }
}
