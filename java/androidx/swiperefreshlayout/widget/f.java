package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import h.e.i.h;

/* loaded from: classes.dex */
public class f extends Drawable implements Animatable {

    /* renamed from: i, reason: collision with root package name */
    private static final Interpolator f398i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    private static final Interpolator f399j = new h.k.a.a.b();

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f400k = {-16777216};
    private final e c;
    private float d;
    private Resources e;
    private Animator f;
    float g;

    /* renamed from: h, reason: collision with root package name */
    boolean f401h;

    public f(Context context) {
        h.d(context);
        this.e = context.getResources();
        e eVar = new e();
        this.c = eVar;
        eVar.u(f400k);
        k(2.5f);
        m();
    }

    private void a(float f, e eVar) {
        n(f, eVar);
        float fFloor = (float) (Math.floor(eVar.j() / 0.8f) + 1.0d);
        eVar.y(eVar.k() + (((eVar.i() - 0.01f) - eVar.k()) * f));
        eVar.v(eVar.i());
        eVar.w(eVar.j() + ((fFloor - eVar.j()) * f));
    }

    private int c(float f, int i2, int i3) {
        return ((((i2 >> 24) & 255) + ((int) ((((i3 >> 24) & 255) - r0) * f))) << 24) | ((((i2 >> 16) & 255) + ((int) ((((i3 >> 16) & 255) - r1) * f))) << 16) | ((((i2 >> 8) & 255) + ((int) ((((i3 >> 8) & 255) - r2) * f))) << 8) | ((i2 & 255) + ((int) (f * ((i3 & 255) - r8))));
    }

    private void h(float f) {
        this.d = f;
    }

    private void i(float f, float f2, float f3, float f4) {
        e eVar = this.c;
        float f5 = this.e.getDisplayMetrics().density;
        eVar.z(f2 * f5);
        eVar.q(f * f5);
        eVar.t(0);
        eVar.o(f3 * f5, f4 * f5);
    }

    private void m() {
        e eVar = this.c;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new c(this, eVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f398i);
        valueAnimatorOfFloat.addListener(new d(this, eVar));
        this.f = valueAnimatorOfFloat;
    }

    void b(float f, e eVar, boolean z) {
        float interpolation;
        float interpolation2;
        if (this.f401h) {
            a(f, eVar);
            return;
        }
        if (f != 1.0f || z) {
            float fJ = eVar.j();
            if (f < 0.5f) {
                interpolation = eVar.k();
                interpolation2 = (f399j.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = eVar.k() + 0.79f;
                interpolation = fK - (((1.0f - f399j.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f2 = fJ + (0.20999998f * f);
            float f3 = (f + this.g) * 216.0f;
            eVar.y(interpolation);
            eVar.v(interpolation2);
            eVar.w(f2);
            h(f3);
        }
    }

    public void d(boolean z) {
        this.c.x(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.d, bounds.exactCenterX(), bounds.exactCenterY());
        this.c.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f) {
        this.c.p(f);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.c.u(iArr);
        this.c.t(0);
        invalidateSelf();
    }

    public void g(float f) {
        this.c.w(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.c.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f.isRunning();
    }

    public void j(float f, float f2) {
        this.c.y(f);
        this.c.v(f2);
        invalidateSelf();
    }

    public void k(float f) {
        this.c.z(f);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f, e eVar) {
        if (f > 0.75f) {
            eVar.r(c((f - 0.75f) / 0.25f, eVar.h(), eVar.e()));
        } else {
            eVar.r(eVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.c.n(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f.cancel();
        this.c.A();
        if (this.c.d() != this.c.g()) {
            this.f401h = true;
            this.f.setDuration(666L);
            this.f.start();
        } else {
            this.c.t(0);
            this.c.m();
            this.f.setDuration(1332L);
            this.f.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f.cancel();
        h(0.0f);
        this.c.x(false);
        this.c.t(0);
        this.c.m();
        invalidateSelf();
    }
}
