package h.e.g;

import android.annotation.SuppressLint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
final class l {
    final Typeface a;
    final int b;

    l(int i2) {
        this.a = null;
        this.b = i2;
    }

    @SuppressLint({"WrongConstant"})
    boolean a() {
        return this.b == 0;
    }

    @SuppressLint({"WrongConstant"})
    l(Typeface typeface) {
        this.a = typeface;
        this.b = 0;
    }
}
