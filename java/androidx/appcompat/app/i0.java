package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
abstract class i0 {
    static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }
}
