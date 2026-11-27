package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import h.e.j.s0;

/* loaded from: classes.dex */
public abstract class c implements View.OnTouchListener {
    private static final int K = ViewConfiguration.getTapTimeout();
    private boolean C;
    boolean D;
    boolean G;
    boolean H;
    private boolean I;
    private boolean J;
    final View e;
    private Runnable f;

    /* renamed from: i, reason: collision with root package name */
    private int f221i;

    /* renamed from: j, reason: collision with root package name */
    private int f222j;
    final a c = new a();
    private final Interpolator d = new AccelerateInterpolator();
    private float[] g = {0.0f, 0.0f};

    /* renamed from: h, reason: collision with root package name */
    private float[] f220h = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: k, reason: collision with root package name */
    private float[] f223k = {0.0f, 0.0f};
    private float[] t = {0.0f, 0.0f};
    private float[] A = {Float.MAX_VALUE, Float.MAX_VALUE};

    public c(View view) {
        this.e = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        o(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        p(f3, f3);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(K);
        r(500);
        q(500);
    }

    private float d(int i2, float f, float f2, float f3) {
        float fH = h(this.g[i2], f2, this.f220h[i2], f);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f223k[i2];
        float f5 = this.t[i2];
        float f6 = this.A[i2];
        float f7 = f4 * f3;
        return fH > 0.0f ? e(fH * f7, f5, f6) : -e((-fH) * f7, f5, f6);
    }

    static float e(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f221i;
        if (i2 == 0 || i2 == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.H && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    private float h(float f, float f2, float f3, float f4) {
        float interpolation;
        float fE = e(f * f2, 0.0f, f3);
        float fG = g(f2 - f4, fE) - g(f4, fE);
        if (fG < 0.0f) {
            interpolation = -this.d.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.d.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.D) {
            this.H = false;
        } else {
            this.c.i();
        }
    }

    private void v() {
        int i2;
        if (this.f == null) {
            this.f = new b(this);
        }
        this.H = true;
        this.D = true;
        if (this.C || (i2 = this.f222j) <= 0) {
            this.f.run();
        } else {
            s0.V(this.e, this.f, i2);
        }
        this.C = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.e.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public c k(int i2) {
        this.f222j = i2;
        return this;
    }

    public c l(int i2) {
        this.f221i = i2;
        return this;
    }

    public c m(boolean z) {
        if (this.I && !z) {
            i();
        }
        this.I = z;
        return this;
    }

    public c n(float f, float f2) {
        float[] fArr = this.f220h;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public c o(float f, float f2) {
        float[] fArr = this.A;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.I) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            }
            return this.J && this.H;
        }
        this.G = true;
        this.C = false;
        this.c.l(d(0, motionEvent.getX(), view.getWidth(), this.e.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.e.getHeight()));
        if (!this.H && u()) {
            v();
        }
        if (this.J) {
            return false;
        }
    }

    public c p(float f, float f2) {
        float[] fArr = this.t;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public c q(int i2) {
        this.c.j(i2);
        return this;
    }

    public c r(int i2) {
        this.c.k(i2);
        return this;
    }

    public c s(float f, float f2) {
        float[] fArr = this.g;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public c t(float f, float f2) {
        float[] fArr = this.f223k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    boolean u() {
        a aVar = this.c;
        int iF = aVar.f();
        int iD = aVar.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
