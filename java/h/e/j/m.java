package h.e.j;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class m {
    private final i a;

    public m(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public m(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new l(context, onGestureListener, handler);
        } else {
            this.a = new k(context, onGestureListener, handler);
        }
    }
}
