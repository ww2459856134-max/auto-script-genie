package h.e.j;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class t {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
