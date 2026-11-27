package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

/* loaded from: classes.dex */
class m0 {
    public final Animation a;
    public final Animator b;

    m0(Animation animation) {
        this.a = animation;
        this.b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    m0(Animator animator) {
        this.a = null;
        this.b = animator;
        if (animator == null) {
            throw new IllegalStateException("Animator cannot be null");
        }
    }
}
