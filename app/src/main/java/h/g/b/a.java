package h.g.b;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
final class a implements Interpolator {
    a() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
