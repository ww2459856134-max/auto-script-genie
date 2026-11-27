package androidx.appcompat.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
abstract class j0 {
    static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i2 = configuration.colorMode & 3;
        int i3 = configuration2.colorMode;
        if (i2 != (i3 & 3)) {
            configuration3.colorMode |= i3 & 3;
        }
        int i4 = configuration.colorMode & 12;
        int i5 = configuration2.colorMode;
        if (i4 != (i5 & 12)) {
            configuration3.colorMode |= i5 & 12;
        }
    }
}
