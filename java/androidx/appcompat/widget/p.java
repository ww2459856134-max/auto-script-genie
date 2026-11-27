package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class p {
    private static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    private static p c;
    private j1 a;

    public static synchronized p b() {
        if (c == null) {
            h();
        }
        return c;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        return j1.l(i2, mode);
    }

    public static synchronized void h() {
        if (c == null) {
            p pVar = new p();
            c = pVar;
            pVar.a = j1.h();
            c.a.u(new o());
        }
    }

    static void i(Drawable drawable, r1 r1Var, int[] iArr) {
        j1.w(drawable, r1Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.a.j(context, i2);
    }

    synchronized Drawable d(Context context, int i2, boolean z) {
        return this.a.k(context, i2, z);
    }

    synchronized ColorStateList f(Context context, int i2) {
        return this.a.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.a.s(context);
    }
}
