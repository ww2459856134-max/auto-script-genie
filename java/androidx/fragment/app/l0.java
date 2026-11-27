package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class l0 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ View b;
    final /* synthetic */ Fragment c;
    final /* synthetic */ m2 d;
    final /* synthetic */ h.e.f.c e;

    l0(ViewGroup viewGroup, View view, Fragment fragment, m2 m2Var, h.e.f.c cVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = fragment;
        this.d = m2Var;
        this.e = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        Animator animatorU = this.c.u();
        this.c.F1(null);
        if (animatorU == null || this.a.indexOfChild(this.b) >= 0) {
            return;
        }
        this.d.a(this.c, this.e);
    }
}
