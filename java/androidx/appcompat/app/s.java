package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.d2;

/* loaded from: classes.dex */
public abstract class s extends androidx.fragment.app.h0 implements t, androidx.core.app.r {
    private u H;
    private Resources I;

    public s() {
        H();
    }

    private void H() {
        b().d("androidx:appcompat", new q(this));
        r(new r(this));
    }

    private void I() {
        androidx.lifecycle.x.a(getWindow().getDecorView(), this);
        androidx.lifecycle.y.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    private boolean O(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.fragment.app.h0
    public void E() {
        F().o();
    }

    public u F() {
        if (this.H == null) {
            this.H = u.g(this, this);
        }
        return this.H;
    }

    public a G() {
        return F().m();
    }

    public void J(androidx.core.app.s sVar) {
        sVar.b(this);
    }

    protected void K(int i2) {
    }

    public void L(androidx.core.app.s sVar) {
    }

    @Deprecated
    public void M() {
    }

    public boolean N() {
        Intent intentA = a();
        if (intentA == null) {
            return false;
        }
        if (!Q(intentA)) {
            P(intentA);
            return true;
        }
        androidx.core.app.s sVarG = androidx.core.app.s.g(this);
        J(sVarG);
        L(sVarG);
        sVarG.h();
        try {
            androidx.core.app.f.j(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void P(Intent intent) {
        androidx.core.app.o.e(this, intent);
    }

    public boolean Q(Intent intent) {
        return androidx.core.app.o.f(this, intent);
    }

    @Override // androidx.core.app.r
    public Intent a() {
        return androidx.core.app.o.a(this);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        I();
        F().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(F().f(context));
    }

    @Override // androidx.appcompat.app.t
    public void c(h.a.o.c cVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a aVarG = G();
        if (getWindow().hasFeature(0)) {
            if (aVarG == null || !aVarG.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.t
    public h.a.o.c d(h.a.o.b bVar) {
        return null;
    }

    @Override // androidx.core.app.n, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a aVarG = G();
        if (keyCode == 82 && aVarG != null && aVarG.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) F().i(i2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return F().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.I == null && d2.b()) {
            this.I = new d2(this, super.getResources());
        }
        Resources resources = this.I;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        F().o();
    }

    @Override // androidx.appcompat.app.t
    public void n(h.a.o.c cVar) {
    }

    @Override // androidx.fragment.app.h0, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.I != null) {
            this.I.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        F().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        M();
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        F().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (O(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.h0, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a aVarG = G();
        if (menuItem.getItemId() != 16908332 || aVarG == null || (aVarG.j() & 4) == 0) {
            return false;
        }
        return N();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.fragment.app.h0, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        F().s(bundle);
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        F().t();
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onStart() {
        super.onStart();
        F().v();
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        super.onStop();
        F().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        F().E(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a aVarG = G();
        if (getWindow().hasFeature(0)) {
            if (aVarG == null || !aVarG.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        I();
        F().A(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        F().D(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        I();
        F().B(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        I();
        F().C(view, layoutParams);
    }
}
