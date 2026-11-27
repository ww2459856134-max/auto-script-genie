package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class t0 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private final float c;
    private final int d;
    private final int e;
    final View f;
    private Runnable g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f174h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f175i;

    /* renamed from: j, reason: collision with root package name */
    private int f176j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f177k = new int[2];

    public t0(View view) {
        this.f = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.d = tapTimeout;
        this.e = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f174h;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.g;
        if (runnable2 != null) {
            this.f.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        p0 p0Var;
        View view = this.f;
        androidx.appcompat.view.menu.c0 c0VarB = b();
        if (c0VarB == null || !c0VarB.a() || (p0Var = (p0) c0VarB.i()) == null || !p0Var.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(p0Var, motionEventObtainNoHistory);
        boolean zE = p0Var.e(motionEventObtainNoHistory, this.f176j);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f176j = motionEvent.getPointerId(0);
            if (this.g == null) {
                this.g = new r0(this);
            }
            view.postDelayed(this.g, this.d);
            if (this.f174h == null) {
                this.f174h = new s0(this);
            }
            view.postDelayed(this.f174h, this.e);
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f176j);
            if (iFindPointerIndex >= 0 && !h(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.c)) {
                a();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
        }
        return false;
    }

    private static boolean h(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f177k);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f177k);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract androidx.appcompat.view.menu.c0 b();

    protected abstract boolean c();

    protected boolean d() {
        androidx.appcompat.view.menu.c0 c0VarB = b();
        if (c0VarB == null || !c0VarB.a()) {
            return true;
        }
        c0VarB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f175i = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f175i;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f175i = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f175i = false;
        this.f176j = -1;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
    }
}
