package i.b;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
class w8 implements View.OnTouchListener {
    final /* synthetic */ Runnable c;
    final /* synthetic */ y8 d;

    w8(y8 y8Var, Runnable runnable) {
        this.d = y8Var;
        this.c = runnable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.getLocationInWindow(new int[2]);
        motionEvent.offsetLocation(r1[0], r1[1]);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.d.b = true;
        } else if (action == 1) {
            y8 y8Var = this.d;
            y8Var.b = false;
            y8Var.c(rawX, rawY);
            com.frame.l1.c(30939485, this.c, 200L);
        } else if (action == 2) {
            y8 y8Var2 = this.d;
            y8Var2.b = true;
            y8Var2.c(rawX, rawY);
        }
        return true;
    }
}
