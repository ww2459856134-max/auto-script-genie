package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
final class i0 implements Interpolator {
    i0() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return f * f * f * f * f;
    }
}
