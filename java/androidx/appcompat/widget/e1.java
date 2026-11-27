package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* loaded from: classes.dex */
class e1 extends h.d.g<Integer, PorterDuffColorFilter> {
    public e1(int i2) {
        super(i2);
    }

    private static int i(int i2, PorterDuff.Mode mode) {
        return ((i2 + 31) * 31) + mode.hashCode();
    }

    PorterDuffColorFilter j(int i2, PorterDuff.Mode mode) {
        return c(Integer.valueOf(i(i2, mode)));
    }

    PorterDuffColorFilter k(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return d(Integer.valueOf(i(i2, mode)), porterDuffColorFilter);
    }
}
