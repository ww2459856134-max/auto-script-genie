package androidx.recyclerview.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class e0 implements RecyclerView.s {
    final /* synthetic */ k0 a;

    e0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int iFindPointerIndex;
        n0 n0VarP;
        this.a.z.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.a.f358l = motionEvent.getPointerId(0);
            this.a.d = motionEvent.getX();
            this.a.e = motionEvent.getY();
            this.a.x();
            k0 k0Var = this.a;
            if (k0Var.c == null && (n0VarP = k0Var.p(motionEvent)) != null) {
                k0 k0Var2 = this.a;
                k0Var2.d -= n0VarP.f363i;
                k0Var2.e -= n0VarP.f364j;
                k0Var2.o(n0VarP.e, true);
                if (this.a.a.remove(n0VarP.e.itemView)) {
                    k0 k0Var3 = this.a;
                    k0Var3.f359m.clearView(k0Var3.r, n0VarP.e);
                }
                this.a.C(n0VarP.e, n0VarP.f);
                k0 k0Var4 = this.a;
                k0Var4.I(motionEvent, k0Var4.f361o, 0);
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            k0 k0Var5 = this.a;
            k0Var5.f358l = -1;
            k0Var5.C(null, 0);
        } else {
            int i2 = this.a.f358l;
            if (i2 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                this.a.l(actionMasked, motionEvent, iFindPointerIndex);
            }
        }
        VelocityTracker velocityTracker = this.a.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return this.a.c != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            this.a.C(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.z.a(motionEvent);
        VelocityTracker velocityTracker = this.a.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (this.a.f358l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(this.a.f358l);
        if (iFindPointerIndex >= 0) {
            this.a.l(actionMasked, motionEvent, iFindPointerIndex);
        }
        k0 k0Var = this.a;
        RecyclerView.d0 d0Var = k0Var.c;
        if (d0Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    k0Var.I(motionEvent, k0Var.f361o, iFindPointerIndex);
                    this.a.w(d0Var);
                    k0 k0Var2 = this.a;
                    k0Var2.r.removeCallbacks(k0Var2.s);
                    this.a.s.run();
                    this.a.r.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                k0 k0Var3 = this.a;
                if (pointerId == k0Var3.f358l) {
                    k0Var3.f358l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    k0 k0Var4 = this.a;
                    k0Var4.I(motionEvent, k0Var4.f361o, actionIndex);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = k0Var.t;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        this.a.C(null, 0);
        this.a.f358l = -1;
    }
}
