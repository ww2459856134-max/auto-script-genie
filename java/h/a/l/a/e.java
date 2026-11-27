package h.a.l.a;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;

/* loaded from: classes.dex */
class e extends g {
    private final ObjectAnimator a;
    private final boolean b;

    e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        super();
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i2 = z ? numberOfFrames - 1 : 0;
        int i3 = z ? 0 : numberOfFrames - 1;
        f fVar = new f(animationDrawable, z);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
        if (Build.VERSION.SDK_INT >= 18) {
            objectAnimatorOfInt.setAutoCancel(true);
        }
        objectAnimatorOfInt.setDuration(fVar.a());
        objectAnimatorOfInt.setInterpolator(fVar);
        this.b = z2;
        this.a = objectAnimatorOfInt;
    }

    @Override // h.a.l.a.g
    public boolean a() {
        return this.b;
    }

    @Override // h.a.l.a.g
    public void b() {
        this.a.reverse();
    }

    @Override // h.a.l.a.g
    public void c() {
        this.a.start();
    }

    @Override // h.a.l.a.g
    public void d() {
        this.a.cancel();
    }
}
