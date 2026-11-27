package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
class i0 implements h.e.f.b {
    final /* synthetic */ Fragment a;

    i0(Fragment fragment) {
        this.a = fragment;
    }

    @Override // h.e.f.b
    public void onCancel() {
        if (this.a.t() != null) {
            View viewT = this.a.t();
            this.a.D1(null);
            viewT.clearAnimation();
        }
        this.a.F1(null);
    }
}
