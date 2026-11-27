package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
class y0 implements View.OnTouchListener {
    final /* synthetic */ a1 c;

    y0(a1 a1Var) {
        this.c = a1Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && (popupWindow = this.c.e0) != null && popupWindow.isShowing() && x >= 0 && x < this.c.e0.getWidth() && y >= 0 && y < this.c.e0.getHeight()) {
            a1 a1Var = this.c;
            a1Var.a0.postDelayed(a1Var.U, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        a1 a1Var2 = this.c;
        a1Var2.a0.removeCallbacks(a1Var2.U);
        return false;
    }
}
