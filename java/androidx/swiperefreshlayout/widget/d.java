package androidx.swiperefreshlayout.widget;

import android.animation.Animator;

/* loaded from: classes.dex */
class d implements Animator.AnimatorListener {
    final /* synthetic */ e a;
    final /* synthetic */ f b;

    d(f fVar, e eVar) {
        this.b = fVar;
        this.a = eVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.b.b(1.0f, this.a, true);
        this.a.A();
        this.a.l();
        f fVar = this.b;
        if (!fVar.f401h) {
            fVar.g += 1.0f;
            return;
        }
        fVar.f401h = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        this.a.x(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.b.g = 0.0f;
    }
}
