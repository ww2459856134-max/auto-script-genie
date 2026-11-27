package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class c implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ e a;
    final /* synthetic */ f b;

    c(f fVar, e eVar) {
        this.b = fVar;
        this.a = eVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.b.n(fFloatValue, this.a);
        this.b.b(fFloatValue, this.a, false);
        this.b.invalidateSelf();
    }
}
