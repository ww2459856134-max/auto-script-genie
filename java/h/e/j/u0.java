package h.e.j;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class u0 {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(h.e.b.f1282k);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && s0.E(viewGroup) == null) ? false : true;
    }
}
