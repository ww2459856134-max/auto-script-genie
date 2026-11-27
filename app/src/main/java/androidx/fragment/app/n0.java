package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
class n0 extends AnimationSet implements Runnable {
    private final ViewGroup c;
    private final View d;
    private boolean e;
    private boolean f;
    private boolean g;

    n0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.g = true;
        this.c = viewGroup;
        this.d = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j2, Transformation transformation) {
        this.g = true;
        if (this.e) {
            return !this.f;
        }
        if (!super.getTransformation(j2, transformation)) {
            this.e = true;
            h.e.j.d0.a(this.c, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e || !this.g) {
            this.c.endViewTransition(this.d);
            this.f = true;
        } else {
            this.g = false;
            this.c.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j2, Transformation transformation, float f) {
        this.g = true;
        if (this.e) {
            return !this.f;
        }
        if (!super.getTransformation(j2, transformation, f)) {
            this.e = true;
            h.e.j.d0.a(this.c, this);
        }
        return true;
    }
}
