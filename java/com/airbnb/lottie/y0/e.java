package com.airbnb.lottie.y0;

import android.view.Choreographer;

/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {
    private com.airbnb.lottie.e t;
    private float e = 1.0f;
    private boolean f = false;
    private long g = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f561h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private int f562i = 0;

    /* renamed from: j, reason: collision with root package name */
    private float f563j = -2.1474836E9f;

    /* renamed from: k, reason: collision with root package name */
    private float f564k = 2.1474836E9f;
    protected boolean A = false;

    private void B() {
        if (this.t == null) {
            return;
        }
        float f = this.f561h;
        if (f < this.f563j || f > this.f564k) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f563j), Float.valueOf(this.f564k), Float.valueOf(this.f561h)));
        }
    }

    private float j() {
        com.airbnb.lottie.e eVar = this.t;
        if (eVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / eVar.h()) / Math.abs(this.e);
    }

    private boolean n() {
        return m() < 0.0f;
    }

    public void A(float f) {
        this.e = f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        r();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        q();
        if (this.t == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.c.a("LottieValueAnimator#doFrame");
        float fJ = (this.g != 0 ? j2 - r1 : 0L) / j();
        float f = this.f561h;
        if (n()) {
            fJ = -fJ;
        }
        float f2 = f + fJ;
        this.f561h = f2;
        boolean z = !g.d(f2, l(), k());
        this.f561h = g.b(this.f561h, l(), k());
        this.g = j2;
        e();
        if (z) {
            if (getRepeatCount() == -1 || this.f562i < getRepeatCount()) {
                c();
                this.f562i++;
                if (getRepeatMode() == 2) {
                    this.f = !this.f;
                    u();
                } else {
                    this.f561h = n() ? k() : l();
                }
                this.g = j2;
            } else {
                this.f561h = this.e < 0.0f ? l() : k();
                r();
                b(n());
            }
        }
        B();
        com.airbnb.lottie.c.b("LottieValueAnimator#doFrame");
    }

    public void f() {
        this.t = null;
        this.f563j = -2.1474836E9f;
        this.f564k = 2.1474836E9f;
    }

    public void g() {
        r();
        b(n());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fL;
        float fK;
        float fL2;
        if (this.t == null) {
            return 0.0f;
        }
        if (n()) {
            fL = k() - this.f561h;
            fK = k();
            fL2 = l();
        } else {
            fL = this.f561h - l();
            fK = k();
            fL2 = l();
        }
        return fL / (fK - fL2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.e eVar = this.t;
        if (eVar == null) {
            return 0L;
        }
        return (long) eVar.d();
    }

    public float h() {
        com.airbnb.lottie.e eVar = this.t;
        if (eVar == null) {
            return 0.0f;
        }
        return (this.f561h - eVar.o()) / (this.t.f() - this.t.o());
    }

    public float i() {
        return this.f561h;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.A;
    }

    public float k() {
        com.airbnb.lottie.e eVar = this.t;
        if (eVar == null) {
            return 0.0f;
        }
        float f = this.f564k;
        return f == 2.1474836E9f ? eVar.f() : f;
    }

    public float l() {
        com.airbnb.lottie.e eVar = this.t;
        if (eVar == null) {
            return 0.0f;
        }
        float f = this.f563j;
        return f == -2.1474836E9f ? eVar.o() : f;
    }

    public float m() {
        return this.e;
    }

    public void o() {
        r();
    }

    public void p() {
        this.A = true;
        d(n());
        w((int) (n() ? k() : l()));
        this.g = 0L;
        this.f562i = 0;
        q();
    }

    protected void q() {
        if (isRunning()) {
            s(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void r() {
        s(true);
    }

    protected void s(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.A = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f) {
            return;
        }
        this.f = false;
        u();
    }

    public void t() {
        this.A = true;
        q();
        this.g = 0L;
        if (n() && i() == l()) {
            this.f561h = k();
        } else {
            if (n() || i() != k()) {
                return;
            }
            this.f561h = l();
        }
    }

    public void u() {
        A(-m());
    }

    public void v(com.airbnb.lottie.e eVar) {
        boolean z = this.t == null;
        this.t = eVar;
        if (z) {
            y((int) Math.max(this.f563j, eVar.o()), (int) Math.min(this.f564k, eVar.f()));
        } else {
            y((int) eVar.o(), (int) eVar.f());
        }
        float f = this.f561h;
        this.f561h = 0.0f;
        w((int) f);
        e();
    }

    public void w(float f) {
        if (this.f561h == f) {
            return;
        }
        this.f561h = g.b(f, l(), k());
        this.g = 0L;
        e();
    }

    public void x(float f) {
        y(this.f563j, f);
    }

    public void y(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.airbnb.lottie.e eVar = this.t;
        float fO = eVar == null ? -3.4028235E38f : eVar.o();
        com.airbnb.lottie.e eVar2 = this.t;
        float f3 = eVar2 == null ? Float.MAX_VALUE : eVar2.f();
        this.f563j = g.b(f, fO, f3);
        this.f564k = g.b(f2, fO, f3);
        w((int) g.b(this.f561h, f, f2));
    }

    public void z(int i2) {
        y(i2, (int) this.f564k);
    }
}
