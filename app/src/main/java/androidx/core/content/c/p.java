package androidx.core.content.c;

import android.content.res.Resources;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class p {
    public static void a(Resources.Theme theme) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            o.a(theme);
        } else if (i2 >= 23) {
            n.a(theme);
        }
    }
}
