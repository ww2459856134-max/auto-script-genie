package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;

/* loaded from: classes.dex */
abstract class g0 {
    static Context a(Context context, Configuration configuration) {
        return context.createConfigurationContext(configuration);
    }

    static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i2 = configuration.densityDpi;
        int i3 = configuration2.densityDpi;
        if (i2 != i3) {
            configuration3.densityDpi = i3;
        }
    }
}
