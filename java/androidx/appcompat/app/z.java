package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: classes.dex */
class z implements ContentFrameLayout.a {
    final /* synthetic */ t0 a;

    z(t0 t0Var) {
        this.a = t0Var;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void a() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void onDetachedFromWindow() {
        this.a.S();
    }
}
