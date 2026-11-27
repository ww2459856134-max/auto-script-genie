package h.e.j;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
class k implements i {
    private static final int v = ViewConfiguration.getLongPressTimeout();
    private static final int w = ViewConfiguration.getTapTimeout();
    private static final int x = ViewConfiguration.getDoubleTapTimeout();
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler e;
    final GestureDetector.OnGestureListener f;
    GestureDetector.OnDoubleTapListener g;

    /* renamed from: h, reason: collision with root package name */
    boolean f1306h;

    /* renamed from: i, reason: collision with root package name */
    boolean f1307i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1308j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1309k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1310l;

    /* renamed from: m, reason: collision with root package name */
    MotionEvent f1311m;

    /* renamed from: n, reason: collision with root package name */
    private MotionEvent f1312n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1313o;
    private float p;
    private float q;
    private float r;
    private float s;
    private boolean t;
    private VelocityTracker u;

    k(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.e = new j(this, handler);
        } else {
            this.e = new j(this);
        }
        this.f = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            g((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        e(context);
    }

    private void b() {
        this.e.removeMessages(1);
        this.e.removeMessages(2);
        this.e.removeMessages(3);
        this.u.recycle();
        this.u = null;
        this.f1313o = false;
        this.f1306h = false;
        this.f1309k = false;
        this.f1310l = false;
        this.f1307i = false;
        if (this.f1308j) {
            this.f1308j = false;
        }
    }

    private void c() {
        this.e.removeMessages(1);
        this.e.removeMessages(2);
        this.e.removeMessages(3);
        this.f1313o = false;
        this.f1309k = false;
        this.f1310l = false;
        this.f1307i = false;
        if (this.f1308j) {
            this.f1308j = false;
        }
    }

    private void e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.f == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        }
        this.t = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = viewConfiguration.getScaledMaximumFlingVelocity();
        this.a = scaledTouchSlop * scaledTouchSlop;
        this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f1310l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > x) {
            return false;
        }
        int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x2 * x2) + (y * y) < this.b;
    }

    @Override // h.e.j.i
    public boolean a(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int action = motionEvent.getAction();
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        int i2 = action & 255;
        boolean z = i2 == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x2 = 0.0f;
        float y = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                x2 += motionEvent.getX(i3);
                y += motionEvent.getY(i3);
            }
        }
        float f = z ? pointerCount - 1 : pointerCount;
        float f2 = x2 / f;
        float f3 = y / f;
        if (i2 == 0) {
            if (this.g == null) {
                zOnDoubleTap = false;
            } else {
                boolean zHasMessages = this.e.hasMessages(3);
                if (zHasMessages) {
                    this.e.removeMessages(3);
                }
                MotionEvent motionEvent3 = this.f1311m;
                if (motionEvent3 == null || (motionEvent2 = this.f1312n) == null || !zHasMessages || !f(motionEvent3, motionEvent2, motionEvent)) {
                    this.e.sendEmptyMessageDelayed(3, x);
                    zOnDoubleTap = false;
                } else {
                    this.f1313o = true;
                    zOnDoubleTap = this.g.onDoubleTap(this.f1311m) | false | this.g.onDoubleTapEvent(motionEvent);
                }
            }
            this.p = f2;
            this.r = f2;
            this.q = f3;
            this.s = f3;
            MotionEvent motionEvent4 = this.f1311m;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.f1311m = MotionEvent.obtain(motionEvent);
            this.f1309k = true;
            this.f1310l = true;
            this.f1306h = true;
            this.f1308j = false;
            this.f1307i = false;
            if (this.t) {
                this.e.removeMessages(2);
                this.e.sendEmptyMessageAtTime(2, this.f1311m.getDownTime() + w + v);
            }
            this.e.sendEmptyMessageAtTime(1, this.f1311m.getDownTime() + w);
            return zOnDoubleTap | this.f.onDown(motionEvent);
        }
        if (i2 == 1) {
            this.f1306h = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.f1313o) {
                zOnFling = this.g.onDoubleTapEvent(motionEvent) | false;
            } else {
                if (this.f1308j) {
                    this.e.removeMessages(3);
                    this.f1308j = false;
                } else if (this.f1309k) {
                    boolean zOnSingleTapUp = this.f.onSingleTapUp(motionEvent);
                    if (this.f1307i && (onDoubleTapListener = this.g) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    zOnFling = zOnSingleTapUp;
                } else {
                    VelocityTracker velocityTracker = this.u;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.d);
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > this.c || Math.abs(xVelocity) > this.c) {
                        zOnFling = this.f.onFling(this.f1311m, motionEvent, xVelocity, yVelocity);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent5 = this.f1312n;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.f1312n = motionEventObtain;
            VelocityTracker velocityTracker2 = this.u;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.u = null;
            }
            this.f1313o = false;
            this.f1307i = false;
            this.e.removeMessages(1);
            this.e.removeMessages(2);
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    b();
                    return false;
                }
                if (i2 == 5) {
                    this.p = f2;
                    this.r = f2;
                    this.q = f3;
                    this.s = f3;
                    c();
                    return false;
                }
                if (i2 != 6) {
                    return false;
                }
                this.p = f2;
                this.r = f2;
                this.q = f3;
                this.s = f3;
                this.u.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.d);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.u.getXVelocity(pointerId2);
                float yVelocity2 = this.u.getYVelocity(pointerId2);
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    if (i4 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i4);
                        if ((this.u.getXVelocity(pointerId3) * xVelocity2) + (this.u.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.u.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
            if (this.f1308j) {
                return false;
            }
            float f4 = this.p - f2;
            float f5 = this.q - f3;
            if (this.f1313o) {
                return false | this.g.onDoubleTapEvent(motionEvent);
            }
            if (!this.f1309k) {
                if (Math.abs(f4) < 1.0f && Math.abs(f5) < 1.0f) {
                    return false;
                }
                boolean zOnScroll = this.f.onScroll(this.f1311m, motionEvent, f4, f5);
                this.p = f2;
                this.q = f3;
                return zOnScroll;
            }
            int i5 = (int) (f2 - this.r);
            int i6 = (int) (f3 - this.s);
            int i7 = (i5 * i5) + (i6 * i6);
            if (i7 > this.a) {
                zOnFling = this.f.onScroll(this.f1311m, motionEvent, f4, f5);
                this.p = f2;
                this.q = f3;
                this.f1309k = false;
                this.e.removeMessages(3);
                this.e.removeMessages(1);
                this.e.removeMessages(2);
            } else {
                zOnFling = false;
            }
            if (i7 > this.a) {
                this.f1310l = false;
            }
        }
        return zOnFling;
    }

    void d() {
        this.e.removeMessages(3);
        this.f1307i = false;
        this.f1308j = true;
        this.f.onLongPress(this.f1311m);
    }

    public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.g = onDoubleTapListener;
    }
}
