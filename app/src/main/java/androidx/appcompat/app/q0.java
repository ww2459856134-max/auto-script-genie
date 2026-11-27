package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: classes.dex */
class q0 extends ContentFrameLayout {

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ t0 f32k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(t0 t0Var, Context context) {
        super(context);
        this.f32k = t0Var;
    }

    private boolean b(int i2, int i3) {
        return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f32k.T(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f32k.N(0);
        return true;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(h.a.k.a.b.d(getContext(), i2));
    }
}
