package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: classes.dex */
class k0 implements Animation.AnimationListener {
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ Fragment d;
    final /* synthetic */ m2 e;
    final /* synthetic */ h.e.f.c f;

    k0(ViewGroup viewGroup, Fragment fragment, m2 m2Var, h.e.f.c cVar) {
        this.c = viewGroup;
        this.d = fragment;
        this.e = m2Var;
        this.f = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.c.post(new j0(this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
