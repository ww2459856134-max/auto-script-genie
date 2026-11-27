package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class z extends RecyclerView.n implements RecyclerView.s {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;
    private final int a;
    private final int b;
    final StateListDrawable c;
    final Drawable d;
    private final int e;
    private final int f;
    private final StateListDrawable g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f378h;

    /* renamed from: i, reason: collision with root package name */
    private final int f379i;

    /* renamed from: j, reason: collision with root package name */
    private final int f380j;

    /* renamed from: k, reason: collision with root package name */
    int f381k;

    /* renamed from: l, reason: collision with root package name */
    int f382l;

    /* renamed from: m, reason: collision with root package name */
    float f383m;

    /* renamed from: n, reason: collision with root package name */
    int f384n;

    /* renamed from: o, reason: collision with root package name */
    int f385o;
    float p;
    private RecyclerView s;
    final ValueAnimator z;
    private int q = 0;
    private int r = 0;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final int[] x = new int[2];
    private final int[] y = new int[2];

    z(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new v(this);
        this.C = new w(this);
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.f378h = drawable2;
        this.e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f379i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f380j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.a = i3;
        this.b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new x(this));
        valueAnimatorOfFloat.addUpdateListener(new y(this));
        i(recyclerView);
    }

    private void B(float f) {
        int[] iArrO = o();
        float fMax = Math.max(iArrO[0], Math.min(iArrO[1], f));
        if (Math.abs(this.f382l - fMax) < 2.0f) {
            return;
        }
        int iW = w(this.f383m, fMax, iArrO, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (iW != 0) {
            this.s.scrollBy(0, iW);
        }
        this.f383m = fMax;
    }

    private void j() {
        this.s.removeCallbacks(this.B);
    }

    private void k() {
        this.s.X0(this);
        this.s.Z0(this);
        this.s.a1(this.C);
        j();
    }

    private void l(Canvas canvas) {
        int i2 = this.r;
        int i3 = this.f379i;
        int i4 = this.f385o;
        int i5 = this.f384n;
        this.g.setBounds(0, 0, i5, i3);
        this.f378h.setBounds(0, 0, this.q, this.f380j);
        canvas.translate(0.0f, i2 - i3);
        this.f378h.draw(canvas);
        canvas.translate(i4 - (i5 / 2), 0.0f);
        this.g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void m(Canvas canvas) {
        int i2 = this.q;
        int i3 = this.e;
        int i4 = i2 - i3;
        int i5 = this.f382l;
        int i6 = this.f381k;
        int i7 = i5 - (i6 / 2);
        this.c.setBounds(0, 0, i3, i6);
        this.d.setBounds(0, 0, this.f, this.r);
        if (!r()) {
            canvas.translate(i4, 0.0f);
            this.d.draw(canvas);
            canvas.translate(0.0f, i7);
            this.c.draw(canvas);
            canvas.translate(-i4, -i7);
            return;
        }
        this.d.draw(canvas);
        canvas.translate(this.e, i7);
        canvas.scale(-1.0f, 1.0f);
        this.c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.e, -i7);
    }

    private int[] n() {
        int[] iArr = this.y;
        int i2 = this.b;
        iArr[0] = i2;
        iArr[1] = this.q - i2;
        return iArr;
    }

    private int[] o() {
        int[] iArr = this.x;
        int i2 = this.b;
        iArr[0] = i2;
        iArr[1] = this.r - i2;
        return iArr;
    }

    private void q(float f) {
        int[] iArrN = n();
        float fMax = Math.max(iArrN[0], Math.min(iArrN[1], f));
        if (Math.abs(this.f385o - fMax) < 2.0f) {
            return;
        }
        int iW = w(this.p, fMax, iArrN, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (iW != 0) {
            this.s.scrollBy(iW, 0);
        }
        this.p = fMax;
    }

    private boolean r() {
        return h.e.j.s0.w(this.s) == 1;
    }

    private void v(int i2) {
        j();
        this.s.postDelayed(this.B, i2);
    }

    private int w(float f, float f2, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f2 - f) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void y() {
        this.s.g(this);
        this.s.j(this);
        this.s.k(this.C);
    }

    void A(int i2, int i3) {
        int iComputeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i4 = this.r;
        this.t = iComputeVerticalScrollRange - i4 > 0 && i4 >= this.a;
        int iComputeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i5 = this.q;
        boolean z = iComputeHorizontalScrollRange - i5 > 0 && i5 >= this.a;
        this.u = z;
        boolean z2 = this.t;
        if (!z2 && !z) {
            if (this.v != 0) {
                x(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i4;
            this.f382l = (int) ((f * (i3 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.f381k = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
        }
        if (this.u) {
            float f2 = i5;
            this.f385o = (int) ((f2 * (i2 + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f384n = Math.min(i5, (i5 * i5) / iComputeHorizontalScrollRange);
        }
        int i6 = this.v;
        if (i6 == 0 || i6 == 1) {
            x(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            x(0);
        } else if (this.A != 0) {
            if (this.t) {
                m(canvas);
            }
            if (this.u) {
                l(canvas);
            }
        }
    }

    public void i(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            k();
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            y();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            boolean zS = s(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zT && !zS) {
                return false;
            }
            if (zS) {
                this.w = 1;
                this.p = (int) motionEvent.getX();
            } else if (zT) {
                this.w = 2;
                this.f383m = (int) motionEvent.getY();
            }
            x(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            boolean zS = s(motionEvent.getX(), motionEvent.getY());
            if (zT || zS) {
                if (zS) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zT) {
                    this.w = 2;
                    this.f383m = (int) motionEvent.getY();
                }
                x(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.f383m = 0.0f;
            this.p = 0.0f;
            x(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            z();
            if (this.w == 1) {
                q(motionEvent.getX());
            }
            if (this.w == 2) {
                B(motionEvent.getY());
            }
        }
    }

    void p(int i2) {
        int i3 = this.A;
        if (i3 == 1) {
            this.z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.z.setDuration(i2);
        this.z.start();
    }

    boolean s(float f, float f2) {
        if (f2 >= this.r - this.f379i) {
            int i2 = this.f385o;
            int i3 = this.f384n;
            if (f >= i2 - (i3 / 2) && f <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean t(float f, float f2) {
        if (!r() ? f >= this.q - this.e : f <= this.e / 2) {
            int i2 = this.f382l;
            int i3 = this.f381k;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    void u() {
        this.s.invalidate();
    }

    void x(int i2) {
        if (i2 == 2 && this.v != 2) {
            this.c.setState(D);
            j();
        }
        if (i2 == 0) {
            u();
        } else {
            z();
        }
        if (this.v == 2 && i2 != 2) {
            this.c.setState(E);
            v(1200);
        } else if (i2 == 1) {
            v(1500);
        }
        this.v = i2;
    }

    public void z() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }
}
