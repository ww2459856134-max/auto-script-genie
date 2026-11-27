package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class h0 extends ComponentActivity implements androidx.core.app.c, androidx.core.app.e {
    boolean C;
    boolean D;
    final q0 t = q0.b(new g0(this));
    final androidx.lifecycle.k A = new androidx.lifecycle.k(this);
    boolean G = true;

    public h0() {
        y();
    }

    private static boolean A(p1 p1Var, f.b bVar) {
        boolean zA = false;
        for (Fragment fragment : p1Var.s0()) {
            if (fragment != null) {
                if (fragment.G() != null) {
                    zA |= A(fragment.w(), bVar);
                }
                z2 z2Var = fragment.s0;
                if (z2Var != null && z2Var.o().b().a(f.b.STARTED)) {
                    fragment.s0.h(bVar);
                    zA = true;
                }
                if (fragment.r0.b().a(f.b.STARTED)) {
                    fragment.r0.o(bVar);
                    zA = true;
                }
            }
        }
        return zA;
    }

    private void y() {
        b().d("android:support:fragments", new e0(this));
        r(new f0(this));
    }

    @Deprecated
    public void B(Fragment fragment) {
    }

    @Deprecated
    protected boolean C(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void D() {
        this.A.h(f.a.ON_RESUME);
        this.t.p();
    }

    @Deprecated
    public abstract void E();

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.C);
        printWriter.print(" mResumed=");
        printWriter.print(this.D);
        printWriter.print(" mStopped=");
        printWriter.print(this.G);
        if (getApplication() != null) {
            h.l.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.t.t().W(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.core.app.e
    @Deprecated
    public final void j(int i2) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.t.u();
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.t.u();
        super.onConfigurationChanged(configuration);
        this.t.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A.h(f.a.ON_CREATE);
        this.t.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return i2 == 0 ? super.onCreatePanelMenu(i2, menu) | this.t.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i2, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewW = w(view, str, context, attributeSet);
        return viewW == null ? super.onCreateView(view, str, context, attributeSet) : viewW;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.t.h();
        this.A.h(f.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.t.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.t.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.t.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.t.j(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.t.u();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.t.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.D = false;
        this.t.m();
        this.A.h(f.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.t.n(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        D();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return i2 == 0 ? C(view, menu) | this.t.o(menu) : super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.t.u();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.t.u();
        super.onResume();
        this.D = true;
        this.t.s();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.t.u();
        super.onStart();
        this.G = false;
        if (!this.C) {
            this.C = true;
            this.t.c();
        }
        this.t.s();
        this.A.h(f.a.ON_START);
        this.t.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.t.u();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.G = true;
        z();
        this.t.r();
        this.A.h(f.a.ON_STOP);
    }

    final View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.t.v(view, str, context, attributeSet);
    }

    public p1 x() {
        return this.t.t();
    }

    void z() {
        while (A(x(), f.b.CREATED)) {
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewW = w(null, str, context, attributeSet);
        return viewW == null ? super.onCreateView(str, context, attributeSet) : viewW;
    }
}
