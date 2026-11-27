package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
class w extends p0 {
    final /* synthetic */ Fragment a;

    w(Fragment fragment) {
        this.a = fragment;
    }

    @Override // androidx.fragment.app.p0
    public View d(int i2) {
        View view = this.a.h0;
        if (view != null) {
            return view.findViewById(i2);
        }
        throw new IllegalStateException("Fragment " + this.a + " does not have a view");
    }

    @Override // androidx.fragment.app.p0
    public boolean g() {
        return this.a.h0 != null;
    }
}
