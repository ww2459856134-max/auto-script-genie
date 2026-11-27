package androidx.appcompat.app;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import java.util.List;

/* loaded from: classes.dex */
class k0 extends h.a.o.n {
    final /* synthetic */ t0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k0(t0 t0Var, Window.Callback callback) {
        super(callback);
        this.d = t0Var;
    }

    final ActionMode b(ActionMode.Callback callback) {
        h.a.o.g gVar = new h.a.o.g(this.d.g, callback);
        h.a.o.c cVarF0 = this.d.F0(gVar);
        if (cVarF0 != null) {
            return gVar.e(cVarF0);
        }
        return null;
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.d.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.d.r0(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.m)) {
            return super.onCreatePanelMenu(i2, menu);
        }
        return false;
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        super.onMenuOpened(i2, menu);
        this.d.u0(i2);
        return true;
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
        this.d.v0(i2);
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        androidx.appcompat.view.menu.m mVar = menu instanceof androidx.appcompat.view.menu.m ? (androidx.appcompat.view.menu.m) menu : null;
        if (i2 == 0 && mVar == null) {
            return false;
        }
        if (mVar != null) {
            mVar.a0(true);
        }
        boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
        if (mVar != null) {
            mVar.a0(false);
        }
        return zOnPreparePanel;
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        androidx.appcompat.view.menu.m mVar;
        r0 r0VarD0 = this.d.d0(0, true);
        if (r0VarD0 == null || (mVar = r0VarD0.f35j) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i2);
        } else {
            super.onProvideKeyboardShortcuts(list, mVar, i2);
        }
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        return this.d.m0() ? b(callback) : super.onWindowStartingActionMode(callback);
    }

    @Override // h.a.o.n, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        if (this.d.m0() && i2 == 0) {
            return b(callback);
        }
        return super.onWindowStartingActionMode(callback, i2);
    }
}
