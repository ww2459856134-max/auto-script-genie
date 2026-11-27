package androidx.appcompat.app;

import android.view.Window;
import androidx.appcompat.view.menu.z;

/* loaded from: classes.dex */
final class s0 implements z.a {
    final /* synthetic */ t0 c;

    s0(t0 t0Var) {
        this.c = t0Var;
    }

    @Override // androidx.appcompat.view.menu.z.a
    public void b(androidx.appcompat.view.menu.m mVar, boolean z) {
        androidx.appcompat.view.menu.m mVarD = mVar.D();
        boolean z2 = mVarD != mVar;
        t0 t0Var = this.c;
        if (z2) {
            mVar = mVarD;
        }
        r0 r0VarY = t0Var.Y(mVar);
        if (r0VarY != null) {
            if (!z2) {
                this.c.O(r0VarY, z);
            } else {
                this.c.K(r0VarY.a, r0VarY, mVarD);
                this.c.O(r0VarY, true);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.z.a
    public boolean c(androidx.appcompat.view.menu.m mVar) {
        Window.Callback callbackF0;
        if (mVar != mVar.D()) {
            return true;
        }
        t0 t0Var = this.c;
        if (!t0Var.a0 || (callbackF0 = t0Var.f0()) == null || this.c.m0) {
            return true;
        }
        callbackF0.onMenuOpened(108, mVar);
        return true;
    }
}
