package h.e.j;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
class l implements i {
    private final GestureDetector a;

    l(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.a = new GestureDetector(context, onGestureListener, handler);
    }

    @Override // h.e.j.i
    public boolean a(MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
