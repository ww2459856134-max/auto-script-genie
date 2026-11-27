package h.a.l.a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

/* loaded from: classes.dex */
class f implements TimeInterpolator {
    private int[] a;
    private int b;
    private int c;

    f(AnimationDrawable animationDrawable, boolean z) {
        b(animationDrawable, z);
    }

    int a() {
        return this.c;
    }

    int b(AnimationDrawable animationDrawable, boolean z) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        this.b = numberOfFrames;
        int[] iArr = this.a;
        if (iArr == null || iArr.length < numberOfFrames) {
            this.a = new int[numberOfFrames];
        }
        int[] iArr2 = this.a;
        int i2 = 0;
        for (int i3 = 0; i3 < numberOfFrames; i3++) {
            int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
            iArr2[i3] = duration;
            i2 += duration;
        }
        this.c = i2;
        return i2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i2 = (int) ((f * this.c) + 0.5f);
        int i3 = this.b;
        int[] iArr = this.a;
        int i4 = 0;
        while (i4 < i3 && i2 >= iArr[i4]) {
            i2 -= iArr[i4];
            i4++;
        }
        return (i4 / i3) + (i4 < i3 ? i2 / this.c : 0.0f);
    }
}
