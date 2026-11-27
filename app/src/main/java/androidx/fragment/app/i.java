package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* loaded from: classes.dex */
class i implements Animation.AnimationListener {
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ View d;
    final /* synthetic */ o e;

    i(r rVar, ViewGroup viewGroup, View view, o oVar) {
        this.c = viewGroup;
        this.d = view;
        this.e = oVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.c.post(new h(this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
