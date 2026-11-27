package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class m0 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ n0 a;

    m0(n0 n0Var) {
        this.a = n0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.c(valueAnimator.getAnimatedFraction());
    }
}
