package androidx.fragment.app;

import android.animation.Animator;

/* loaded from: classes.dex */
class g implements h.e.f.b {
    final /* synthetic */ Animator a;

    g(r rVar, Animator animator) {
        this.a = animator;
    }

    @Override // h.e.f.b
    public void onCancel() {
        this.a.end();
    }
}
