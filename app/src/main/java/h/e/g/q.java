package h.e.g;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;

/* loaded from: classes.dex */
public abstract class q {
    public static Typeface a(Context context, g gVar, int i2, boolean z, int i3, Handler handler, p pVar) {
        c cVar = new c(pVar, handler);
        return z ? m.e(context, gVar, cVar, i2, i3) : m.d(context, gVar, i2, null, cVar);
    }
}
