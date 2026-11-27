package androidx.fragment.app;

import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
class e3 extends i3 {

    /* renamed from: h, reason: collision with root package name */
    private final b2 f250h;

    e3(h3 h3Var, g3 g3Var, b2 b2Var, h.e.f.c cVar) {
        super(h3Var, g3Var, b2Var.k(), cVar);
        this.f250h = b2Var;
    }

    @Override // androidx.fragment.app.i3
    public void c() {
        super.c();
        this.f250h.m();
    }

    @Override // androidx.fragment.app.i3
    void l() {
        if (g() == g3.ADDING) {
            Fragment fragmentK = this.f250h.k();
            View viewFindFocus = fragmentK.h0.findFocus();
            if (viewFindFocus != null) {
                fragmentK.H1(viewFindFocus);
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK);
                }
            }
            View viewZ1 = f().z1();
            if (viewZ1.getParent() == null) {
                this.f250h.b();
                viewZ1.setAlpha(0.0f);
            }
            if (viewZ1.getAlpha() == 0.0f && viewZ1.getVisibility() == 0) {
                viewZ1.setVisibility(4);
            }
            viewZ1.setAlpha(fragmentK.P());
        }
    }
}
