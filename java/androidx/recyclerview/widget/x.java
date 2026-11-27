package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
class x extends AnimatorListenerAdapter {
    private boolean a = false;
    final /* synthetic */ z b;

    x(z zVar) {
        this.b = zVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.a) {
            this.a = false;
            return;
        }
        if (((Float) this.b.z.getAnimatedValue()).floatValue() == 0.0f) {
            z zVar = this.b;
            zVar.A = 0;
            zVar.x(0);
        } else {
            z zVar2 = this.b;
            zVar2.A = 2;
            zVar2.u();
        }
    }
}
