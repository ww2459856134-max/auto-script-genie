package androidx.recyclerview.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class l0 extends GestureDetector.SimpleOnGestureListener {
    private boolean a = true;
    final /* synthetic */ k0 b;

    l0(k0 k0Var) {
        this.b = k0Var;
    }

    void a() {
        this.a = false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View viewQ;
        RecyclerView.d0 d0VarG0;
        if (!this.a || (viewQ = this.b.q(motionEvent)) == null || (d0VarG0 = this.b.r.g0(viewQ)) == null) {
            return;
        }
        k0 k0Var = this.b;
        if (k0Var.f359m.hasDragFlag(k0Var.r, d0VarG0)) {
            int pointerId = motionEvent.getPointerId(0);
            int i2 = this.b.f358l;
            if (pointerId == i2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                k0 k0Var2 = this.b;
                k0Var2.d = x;
                k0Var2.e = y;
                k0Var2.f355i = 0.0f;
                k0Var2.f354h = 0.0f;
                if (k0Var2.f359m.isLongPressDragEnabled()) {
                    this.b.C(d0VarG0, 2);
                }
            }
        }
    }
}
