package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class j extends AnimatorListenerAdapter {
    final /* synthetic */ RecyclerView.d0 a;
    final /* synthetic */ View b;
    final /* synthetic */ ViewPropertyAnimator c;
    final /* synthetic */ p d;

    j(p pVar, RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = pVar;
        this.a = d0Var;
        this.b = view;
        this.c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.c.setListener(null);
        this.d.B(this.a);
        this.d.f375o.remove(this.a);
        this.d.X();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.C(this.a);
    }
}
