package h.g.b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import h.e.j.s0;
import java.util.Arrays;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class c {
    private static final Interpolator w = new h.g.b.a();
    private int a;
    private int b;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f1325h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f1326i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f1327j;

    /* renamed from: k, reason: collision with root package name */
    private int f1328k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f1329l;

    /* renamed from: m, reason: collision with root package name */
    private float f1330m;

    /* renamed from: n, reason: collision with root package name */
    private float f1331n;

    /* renamed from: o, reason: collision with root package name */
    private int f1332o;
    private int p;
    private OverScroller q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private int c = -1;
    private final Runnable v = new b(this);

    public static abstract class a {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int c(int i2) {
            return i2;
        }

        public abstract int d(View view);

        public int e(View view) {
            return 0;
        }

        public abstract void f(int i2, int i3);

        public abstract boolean g(int i2);

        public abstract void h(int i2, int i3);

        public abstract void i(View view, int i2);

        public abstract void j(int i2);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i2);
    }

    private c(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1332o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.f1330m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1331n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, w);
    }

    private boolean C(int i2) {
        if (B(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void F() {
        this.f1329l.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.f1330m);
        p(g(this.f1329l.getXVelocity(this.c), this.f1331n, this.f1330m), g(this.f1329l.getYVelocity(this.c), this.f1331n, this.f1330m));
    }

    private void G(float f, float f2, int i2) {
        int i3 = c(f, f2, i2, 1) ? 1 : 0;
        if (c(f2, f, i2, 4)) {
            i3 |= 4;
        }
        if (c(f, f2, i2, 2)) {
            i3 |= 2;
        }
        if (c(f2, f, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f1326i;
            iArr[i2] = iArr[i2] | i3;
            this.r.f(i3, i2);
        }
    }

    private void H(float f, float f2, int i2) {
        s(i2);
        float[] fArr = this.d;
        this.f[i2] = f;
        fArr[i2] = f;
        float[] fArr2 = this.e;
        this.g[i2] = f2;
        fArr2[i2] = f2;
        this.f1325h[i2] = x((int) f, (int) f2);
        this.f1328k |= 1 << i2;
    }

    private void I(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (C(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    private boolean c(float f, float f2, int i2, int i3) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f1325h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.f1327j[i2] & i3) == i3 || (this.f1326i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.b;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.g(i3)) {
            return (this.f1326i[i2] & i3) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.f1327j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean f(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.d(view) > 0;
        boolean z2 = this.r.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i2 = this.b;
        return f3 > ((float) (i2 * i2));
    }

    private float g(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    private int h(int i2, int i3, int i4) {
        int iAbs = Math.abs(i2);
        if (iAbs < i3) {
            return 0;
        }
        return iAbs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void i() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.f1325h, 0);
        Arrays.fill(this.f1326i, 0);
        Arrays.fill(this.f1327j, 0);
        this.f1328k = 0;
    }

    private void j(int i2) {
        if (this.d == null || !B(i2)) {
            return;
        }
        this.d[i2] = 0.0f;
        this.e[i2] = 0.0f;
        this.f[i2] = 0.0f;
        this.g[i2] = 0.0f;
        this.f1325h[i2] = 0;
        this.f1326i[i2] = 0;
        this.f1327j[i2] = 0;
        this.f1328k = (~(1 << i2)) & this.f1328k;
    }

    private int k(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float fQ = f + (q(Math.min(1.0f, Math.abs(i2) / width)) * f);
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    private int l(View view, int i2, int i3, int i4, int i5) {
        float f;
        float f2;
        float f3;
        float f4;
        int iH = h(i4, (int) this.f1331n, (int) this.f1330m);
        int iH2 = h(i5, (int) this.f1331n, (int) this.f1330m);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i3);
        int iAbs3 = Math.abs(iH);
        int iAbs4 = Math.abs(iH2);
        int i6 = iAbs3 + iAbs4;
        int i7 = iAbs + iAbs2;
        if (iH != 0) {
            f = iAbs3;
            f2 = i6;
        } else {
            f = iAbs;
            f2 = i7;
        }
        float f5 = f / f2;
        if (iH2 != 0) {
            f3 = iAbs4;
            f4 = i6;
        } else {
            f3 = iAbs2;
            f4 = i7;
        }
        return (int) ((k(i2, iH, this.r.d(view)) * f5) + (k(i3, iH2, this.r.e(view)) * (f3 / f4)));
    }

    public static c n(ViewGroup viewGroup, float f, a aVar) {
        c cVarO = o(viewGroup, aVar);
        cVarO.b = (int) (cVarO.b * (1.0f / f));
        return cVarO;
    }

    public static c o(ViewGroup viewGroup, a aVar) {
        return new c(viewGroup.getContext(), viewGroup, aVar);
    }

    private void p(float f, float f2) {
        this.t = true;
        this.r.l(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            J(0);
        }
    }

    private float q(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void r(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i4 != 0) {
            i2 = this.r.a(this.s, i2, i4);
            s0.O(this.s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.r.b(this.s, i3, i5);
            s0.P(this.s, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.r.k(this.s, i6, i7, i6 - left, i7 - top);
    }

    private void s(int i2) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1325h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1326i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1327j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.f1325h = iArr;
            this.f1326i = iArr2;
            this.f1327j = iArr3;
        }
    }

    private boolean u(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.abortAnimation();
            J(0);
            return false;
        }
        this.q.startScroll(left, top, i6, i7, l(this.s, i6, i7, i4, i5));
        J(2);
        return true;
    }

    private int x(int i2, int i3) {
        int i4 = i2 < this.u.getLeft() + this.f1332o ? 1 : 0;
        if (i3 < this.u.getTop() + this.f1332o) {
            i4 |= 4;
        }
        if (i2 > this.u.getRight() - this.f1332o) {
            i4 |= 2;
        }
        return i3 > this.u.getBottom() - this.f1332o ? i4 | 8 : i4;
    }

    public boolean A(int i2, int i3) {
        return D(this.s, i2, i3);
    }

    public boolean B(int i2) {
        return ((1 << i2) & this.f1328k) != 0;
    }

    public boolean D(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void E(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1329l == null) {
            this.f1329l = VelocityTracker.obtain();
        }
        this.f1329l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewT = t((int) x, (int) y);
            H(x, y, pointerId);
            P(viewT, pointerId);
            int i4 = this.f1325h[pointerId];
            int i5 = this.p;
            if ((i4 & i5) != 0) {
                this.r.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.a == 1) {
                F();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.a == 1) {
                if (C(this.c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.c);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f;
                    int i6 = this.c;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.g[i6]);
                    r(this.s.getLeft() + i7, this.s.getTop() + i8, i7, i8);
                    I(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (C(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f = x3 - this.d[pointerId2];
                    float f2 = y3 - this.e[pointerId2];
                    G(f, f2, pointerId2);
                    if (this.a != 1) {
                        View viewT2 = t((int) x3, (int) y3);
                        if (f(viewT2, f, f2) && P(viewT2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            I(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.a == 1) {
                p(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            H(x4, y4, pointerId3);
            if (this.a != 0) {
                if (A((int) x4, (int) y4)) {
                    P(this.s, pointerId3);
                    return;
                }
                return;
            } else {
                P(t((int) x4, (int) y4), pointerId3);
                int i9 = this.f1325h[pointerId3];
                int i10 = this.p;
                if ((i9 & i10) != 0) {
                    this.r.h(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.a == 1 && pointerId4 == this.c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.c) {
                    View viewT3 = t((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view = this.s;
                    if (viewT3 == view && P(view, pointerId5)) {
                        i2 = this.c;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                F();
            }
        }
        j(pointerId4);
    }

    void J(int i2) {
        this.u.removeCallbacks(this.v);
        if (this.a != i2) {
            this.a = i2;
            this.r.j(i2);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public void K(int i2) {
        this.p = i2;
    }

    public void L(float f) {
        this.f1331n = f;
    }

    public boolean M(int i2, int i3) {
        if (this.t) {
            return u(i2, i3, (int) this.f1329l.getXVelocity(this.c), (int) this.f1329l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean N(MotionEvent motionEvent) {
        boolean z;
        View viewT;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1329l == null) {
            this.f1329l = VelocityTracker.obtain();
        }
        this.f1329l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            z = false;
            int pointerId = motionEvent.getPointerId(0);
            H(x, y, pointerId);
            View viewT2 = t((int) x, (int) y);
            if (viewT2 == this.s && this.a == 2) {
                P(viewT2, pointerId);
            }
            int i2 = this.f1325h[pointerId];
            int i3 = this.p;
            if ((i2 & i3) != 0) {
                this.r.h(i2 & i3, pointerId);
            }
        } else if (actionMasked == 1) {
            a();
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x2 = motionEvent.getX(actionIndex);
                        float y2 = motionEvent.getY(actionIndex);
                        H(x2, y2, pointerId2);
                        int i4 = this.a;
                        if (i4 == 0) {
                            int i5 = this.f1325h[pointerId2];
                            int i6 = this.p;
                            if ((i5 & i6) != 0) {
                                this.r.h(i5 & i6, pointerId2);
                            }
                        } else if (i4 == 2 && (viewT = t((int) x2, (int) y2)) == this.s) {
                            P(viewT, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        j(motionEvent.getPointerId(actionIndex));
                    }
                }
            } else if (this.d != null && this.e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i7 = 0; i7 < pointerCount; i7++) {
                    int pointerId3 = motionEvent.getPointerId(i7);
                    if (C(pointerId3)) {
                        float x3 = motionEvent.getX(i7);
                        float y3 = motionEvent.getY(i7);
                        float f = x3 - this.d[pointerId3];
                        float f2 = y3 - this.e[pointerId3];
                        View viewT3 = t((int) x3, (int) y3);
                        boolean z2 = viewT3 != null && f(viewT3, f, f2);
                        if (z2) {
                            int left = viewT3.getLeft();
                            int i8 = (int) f;
                            int iA = this.r.a(viewT3, left + i8, i8);
                            int top = viewT3.getTop();
                            int i9 = (int) f2;
                            int iB = this.r.b(viewT3, top + i9, i9);
                            int iD = this.r.d(viewT3);
                            int iE = this.r.e(viewT3);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            G(f, f2, pointerId3);
                            if (this.a == 1 || (z2 && P(viewT3, pointerId3))) {
                                break;
                            }
                        }
                    }
                }
                I(motionEvent);
            }
            z = false;
        }
        if (this.a == 1) {
            return true;
        }
        return z;
    }

    public boolean O(View view, int i2, int i3) {
        this.s = view;
        this.c = -1;
        boolean zU = u(i2, i3, 0, 0);
        if (!zU && this.a == 0 && this.s != null) {
            this.s = null;
        }
        return zU;
    }

    boolean P(View view, int i2) {
        if (view == this.s && this.c == i2) {
            return true;
        }
        if (view == null || !this.r.m(view, i2)) {
            return false;
        }
        this.c = i2;
        b(view, i2);
        return true;
    }

    public void a() {
        this.c = -1;
        i();
        VelocityTracker velocityTracker = this.f1329l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1329l = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.c = i2;
            this.r.i(view, i2);
            J(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public boolean d(int i2) {
        int length = this.d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (e(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i2, int i3) {
        if (!B(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f = this.f[i3] - this.d[i3];
        float f2 = this.g[i3] - this.e[i3];
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i4 = this.b;
        return f3 > ((float) (i4 * i4));
    }

    public boolean m(boolean z) {
        if (this.a == 2) {
            boolean zComputeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                s0.O(this.s, left);
            }
            if (top != 0) {
                s0.P(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    J(0);
                }
            }
        }
        return this.a == 2;
    }

    public View t(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            this.r.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.s;
    }

    public int w() {
        return this.f1332o;
    }

    public int y() {
        return this.b;
    }

    public int z() {
        return this.a;
    }
}
