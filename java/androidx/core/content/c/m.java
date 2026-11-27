package androidx.core.content.c;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class m {
    public static Handler c(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void a(int i2, Handler handler) {
        c(handler).post(new l(this, i2));
    }

    public final void b(Typeface typeface, Handler handler) {
        c(handler).post(new k(this, typeface));
    }

    public abstract void d(int i2);

    public abstract void e(Typeface typeface);
}
