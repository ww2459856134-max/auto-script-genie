package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
enum h3 {
    REMOVED,
    VISIBLE,
    GONE,
    INVISIBLE;

    static h3 b(int i2) {
        if (i2 == 0) {
            return VISIBLE;
        }
        if (i2 == 4) {
            return INVISIBLE;
        }
        if (i2 == 8) {
            return GONE;
        }
        throw new IllegalArgumentException("Unknown visibility " + i2);
    }

    static h3 c(View view) {
        return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
    }

    void a(View view) {
        int i2 = d3.a[ordinal()];
        if (i2 == 1) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (i2 == 3) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (i2 != 4) {
            return;
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }
}
