package h.a.l.a;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class j {
    public static boolean a(Drawable.ConstantState constantState) {
        return constantState.canApplyTheme();
    }

    public static void b(Drawable drawable, Outline outline) {
        drawable.getOutline(outline);
    }

    public static Resources c(Resources.Theme theme) {
        return theme.getResources();
    }
}
