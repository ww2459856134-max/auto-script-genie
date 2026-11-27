package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class f extends AnimatorListenerAdapter {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ View b;
    final /* synthetic */ boolean c;
    final /* synthetic */ i3 d;
    final /* synthetic */ o e;

    f(r rVar, ViewGroup viewGroup, View view, boolean z, i3 i3Var, o oVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = i3Var;
        this.e = oVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.b);
        if (this.c) {
            this.d.e().a(this.b);
        }
        this.e.a();
    }
}
