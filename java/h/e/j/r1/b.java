package h.e.j.r1;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class b {
    public static Interpolator a(float f, float f2, float f3, float f4) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f, f2, f3, f4) : new a(f, f2, f3, f4);
    }
}
