package h.e.g;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
abstract class d {
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
