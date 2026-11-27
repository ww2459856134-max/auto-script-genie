package androidx.fragment.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;

/* loaded from: classes.dex */
class g0 extends s0<h0> implements androidx.lifecycle.w, androidx.activity.k, androidx.activity.result.h, v1 {
    final /* synthetic */ h0 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(h0 h0Var) {
        super(h0Var);
        this.g = h0Var;
    }

    @Override // androidx.fragment.app.v1
    public void a(p1 p1Var, Fragment fragment) {
        this.g.B(fragment);
    }

    @Override // androidx.fragment.app.p0
    public View d(int i2) {
        return this.g.findViewById(i2);
    }

    @Override // androidx.activity.result.h
    public ActivityResultRegistry e() {
        return this.g.e();
    }

    @Override // androidx.lifecycle.w
    public androidx.lifecycle.v f() {
        return this.g.f();
    }

    @Override // androidx.fragment.app.p0
    public boolean g() {
        Window window = this.g.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.activity.k
    public OnBackPressedDispatcher k() {
        return this.g.k();
    }

    @Override // androidx.fragment.app.s0
    public LayoutInflater m() {
        return this.g.getLayoutInflater().cloneInContext(this.g);
    }

    @Override // androidx.fragment.app.s0
    public boolean n(Fragment fragment) {
        return !this.g.isFinishing();
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.f o() {
        return this.g.A;
    }

    @Override // androidx.fragment.app.s0
    public void q() {
        this.g.E();
    }

    @Override // androidx.fragment.app.s0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public h0 l() {
        return this.g;
    }
}
