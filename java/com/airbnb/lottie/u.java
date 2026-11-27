package com.airbnb.lottie;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class u implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ e0 a;

    u(e0 e0Var) {
        this.a = e0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.J != null) {
            this.a.J.G(this.a.e.h());
        }
    }
}
