package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class y implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ z a;

    y(z zVar) {
        this.a = zVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.a.c.setAlpha(iFloatValue);
        this.a.d.setAlpha(iFloatValue);
        this.a.u();
    }
}
