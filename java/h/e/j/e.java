package h.e.j;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class e {
    private c a;
    private d b;

    public e(Context context) {
    }

    public abstract boolean a();

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public abstract boolean e();

    public abstract void f(SubMenu subMenu);

    public boolean g() {
        return false;
    }

    public void h() {
        this.b = null;
        this.a = null;
    }

    public void i(c cVar) {
        this.a = cVar;
    }

    public void j(d dVar) {
        if (this.b != null && dVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.b = dVar;
    }

    public void k(boolean z) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(z);
        }
    }
}
