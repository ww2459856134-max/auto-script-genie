package h.e.j;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes.dex */
class x0 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ c1 a;
    final /* synthetic */ View b;

    x0(z0 z0Var, c1 c1Var, View view) {
        this.a = c1Var;
        this.b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(this.b);
    }
}
