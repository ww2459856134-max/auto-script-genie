package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class q0 {
    private final s0<?> a;

    private q0(s0<?> s0Var) {
        this.a = s0Var;
    }

    public static q0 b(s0<?> s0Var) {
        h.e.i.h.e(s0Var, "callbacks == null");
        return new q0(s0Var);
    }

    public void a(Fragment fragment) {
        s0<?> s0Var = this.a;
        s0Var.f.j(s0Var, s0Var, fragment);
    }

    public void c() {
        this.a.f.y();
    }

    public void d(Configuration configuration) {
        this.a.f.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.f.B(menuItem);
    }

    public void f() {
        this.a.f.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.f.D(menu, menuInflater);
    }

    public void h() {
        this.a.f.E();
    }

    public void i() {
        this.a.f.G();
    }

    public void j(boolean z) {
        this.a.f.H(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.f.J(menuItem);
    }

    public void l(Menu menu) {
        this.a.f.K(menu);
    }

    public void m() {
        this.a.f.M();
    }

    public void n(boolean z) {
        this.a.f.N(z);
    }

    public boolean o(Menu menu) {
        return this.a.f.O(menu);
    }

    public void p() {
        this.a.f.Q();
    }

    public void q() {
        this.a.f.R();
    }

    public void r() {
        this.a.f.T();
    }

    public boolean s() {
        return this.a.f.a0(true);
    }

    public p1 t() {
        return this.a.f;
    }

    public void u() {
        this.a.f.R0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.f.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        s0<?> s0Var = this.a;
        if (!(s0Var instanceof androidx.lifecycle.w)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        s0Var.f.d1(parcelable);
    }

    public Parcelable x() {
        return this.a.f.f1();
    }
}
