package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e0 extends Drawable implements Drawable.Callback, Animatable {
    private String A;
    private b C;
    private com.airbnb.lottie.u0.a D;
    a G;
    s0 H;
    private boolean I;
    private com.airbnb.lottie.v0.m.e J;
    private int K;
    private boolean M;
    private boolean O;
    private boolean P;
    private boolean Q;
    private final Matrix c = new Matrix();
    private e d;
    private final com.airbnb.lottie.y0.e e;
    private float f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f434h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<d0> f435i;

    /* renamed from: j, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f436j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView.ScaleType f437k;
    private com.airbnb.lottie.u0.b t;

    public e0() {
        com.airbnb.lottie.y0.e eVar = new com.airbnb.lottie.y0.e();
        this.e = eVar;
        this.f = 1.0f;
        this.g = true;
        this.f434h = false;
        new HashSet();
        this.f435i = new ArrayList<>();
        u uVar = new u(this);
        this.f436j = uVar;
        this.K = 255;
        this.P = true;
        this.Q = false;
        eVar.addUpdateListener(uVar);
    }

    private void d() {
        this.J = new com.airbnb.lottie.v0.m.e(this, com.airbnb.lottie.x0.t.a(this.d), this.d.j(), this.d);
    }

    private void g(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f437k) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    private void h(Canvas canvas) {
        float f;
        if (this.J == null) {
            return;
        }
        int iSave = -1;
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.d.b().width();
        float fHeight = bounds.height() / this.d.b().height();
        if (this.P) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f = 1.0f / fMin;
                fWidth /= f;
                fHeight /= f;
            } else {
                f = 1.0f;
            }
            if (f > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f2 = fWidth2 * fMin;
                float f3 = fMin * fHeight2;
                canvas.translate(fWidth2 - f2, fHeight2 - f3);
                canvas.scale(f, f, f2, f3);
            }
        }
        this.c.reset();
        this.c.preScale(fWidth, fHeight);
        this.J.c(canvas, this.c, this.K);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void i(Canvas canvas) {
        float f;
        if (this.J == null) {
            return;
        }
        float f2 = this.f;
        float fU = u(canvas);
        if (f2 > fU) {
            f = this.f / fU;
        } else {
            fU = f2;
            f = 1.0f;
        }
        int iSave = -1;
        if (f > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.d.b().width() / 2.0f;
            float fHeight = this.d.b().height() / 2.0f;
            float f3 = fWidth * fU;
            float f4 = fHeight * fU;
            canvas.translate((A() * fWidth) - f3, (A() * fHeight) - f4);
            canvas.scale(f, f, f3, f4);
        }
        this.c.reset();
        this.c.preScale(fU, fU);
        this.J.c(canvas, this.c, this.K);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void k0() {
        if (this.d == null) {
            return;
        }
        float fA = A();
        setBounds(0, 0, (int) (this.d.b().width() * fA), (int) (this.d.b().height() * fA));
    }

    private Context n() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.u0.a o() {
        if (getCallback() == null) {
            return null;
        }
        if (this.D == null) {
            this.D = new com.airbnb.lottie.u0.a(getCallback(), this.G);
        }
        return this.D;
    }

    private com.airbnb.lottie.u0.b r() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.u0.b bVar = this.t;
        if (bVar != null && !bVar.b(n())) {
            this.t = null;
        }
        if (this.t == null) {
            this.t = new com.airbnb.lottie.u0.b(getCallback(), this.A, this.C, this.d.i());
        }
        return this.t;
    }

    private float u(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.d.b().width(), canvas.getHeight() / this.d.b().height());
    }

    public float A() {
        return this.f;
    }

    public float B() {
        return this.e.m();
    }

    public s0 C() {
        return this.H;
    }

    public Typeface D(String str, String str2) {
        com.airbnb.lottie.u0.a aVarO = o();
        if (aVarO != null) {
            return aVarO.b(str, str2);
        }
        return null;
    }

    public boolean E() {
        com.airbnb.lottie.y0.e eVar = this.e;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean F() {
        return this.O;
    }

    public void G() {
        this.f435i.clear();
        this.e.o();
    }

    public void H() {
        if (this.J == null) {
            this.f435i.add(new v(this));
            return;
        }
        if (this.g || y() == 0) {
            this.e.p();
        }
        if (this.g) {
            return;
        }
        N((int) (B() < 0.0f ? v() : t()));
        this.e.g();
    }

    public List<com.airbnb.lottie.v0.f> I(com.airbnb.lottie.v0.f fVar) {
        if (this.J == null) {
            com.airbnb.lottie.y0.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.J.g(fVar, 0, arrayList, new com.airbnb.lottie.v0.f(new String[0]));
        return arrayList;
    }

    public void J() {
        if (this.J == null) {
            this.f435i.add(new w(this));
            return;
        }
        if (this.g || y() == 0) {
            this.e.t();
        }
        if (this.g) {
            return;
        }
        N((int) (B() < 0.0f ? v() : t()));
        this.e.g();
    }

    public void K(boolean z) {
        this.O = z;
    }

    public boolean L(e eVar) {
        if (this.d == eVar) {
            return false;
        }
        this.Q = false;
        f();
        this.d = eVar;
        d();
        this.e.v(eVar);
        b0(this.e.getAnimatedFraction());
        f0(this.f);
        k0();
        Iterator it = new ArrayList(this.f435i).iterator();
        while (it.hasNext()) {
            ((d0) it.next()).a(eVar);
            it.remove();
        }
        this.f435i.clear();
        eVar.u(this.M);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void M(a aVar) {
        com.airbnb.lottie.u0.a aVar2 = this.D;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void N(int i2) {
        if (this.d == null) {
            this.f435i.add(new r(this, i2));
        } else {
            this.e.w(i2);
        }
    }

    public void O(b bVar) {
        this.C = bVar;
        com.airbnb.lottie.u0.b bVar2 = this.t;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public void P(String str) {
        this.A = str;
    }

    public void Q(int i2) {
        if (this.d == null) {
            this.f435i.add(new z(this, i2));
        } else {
            this.e.x(i2 + 0.99f);
        }
    }

    public void R(String str) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new c0(this, str));
            return;
        }
        com.airbnb.lottie.v0.i iVarK = eVar.k(str);
        if (iVarK != null) {
            Q((int) (iVarK.b + iVarK.c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void S(float f) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new a0(this, f));
        } else {
            Q((int) com.airbnb.lottie.y0.g.j(eVar.o(), this.d.f(), f));
        }
    }

    public void T(int i2, int i3) {
        if (this.d == null) {
            this.f435i.add(new p(this, i2, i3));
        } else {
            this.e.y(i2, i3 + 0.99f);
        }
    }

    public void U(String str) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new n(this, str));
            return;
        }
        com.airbnb.lottie.v0.i iVarK = eVar.k(str);
        if (iVarK != null) {
            int i2 = (int) iVarK.b;
            T(i2, ((int) iVarK.c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void V(String str, String str2, boolean z) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new o(this, str, str2, z));
            return;
        }
        com.airbnb.lottie.v0.i iVarK = eVar.k(str);
        if (iVarK == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i2 = (int) iVarK.b;
        com.airbnb.lottie.v0.i iVarK2 = this.d.k(str2);
        if (str2 != null) {
            T(i2, (int) (iVarK2.b + (z ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public void W(float f, float f2) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new q(this, f, f2));
        } else {
            T((int) com.airbnb.lottie.y0.g.j(eVar.o(), this.d.f(), f), (int) com.airbnb.lottie.y0.g.j(this.d.o(), this.d.f(), f2));
        }
    }

    public void X(int i2) {
        if (this.d == null) {
            this.f435i.add(new x(this, i2));
        } else {
            this.e.z(i2);
        }
    }

    public void Y(String str) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new b0(this, str));
            return;
        }
        com.airbnb.lottie.v0.i iVarK = eVar.k(str);
        if (iVarK != null) {
            X((int) iVarK.b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void Z(float f) {
        e eVar = this.d;
        if (eVar == null) {
            this.f435i.add(new y(this, f));
        } else {
            X((int) com.airbnb.lottie.y0.g.j(eVar.o(), this.d.f(), f));
        }
    }

    public void a0(boolean z) {
        this.M = z;
        e eVar = this.d;
        if (eVar != null) {
            eVar.u(z);
        }
    }

    public void b0(float f) {
        if (this.d == null) {
            this.f435i.add(new s(this, f));
            return;
        }
        c.a("Drawable#setProgress");
        this.e.w(com.airbnb.lottie.y0.g.j(this.d.o(), this.d.f(), f));
        c.b("Drawable#setProgress");
    }

    public <T> void c(com.airbnb.lottie.v0.f fVar, T t, com.airbnb.lottie.z0.c<T> cVar) {
        if (this.J == null) {
            this.f435i.add(new t(this, fVar, t, cVar));
            return;
        }
        boolean zIsEmpty = true;
        if (fVar.d() != null) {
            fVar.d().f(t, cVar);
        } else {
            List<com.airbnb.lottie.v0.f> listI = I(fVar);
            for (int i2 = 0; i2 < listI.size(); i2++) {
                listI.get(i2).d().f(t, cVar);
            }
            zIsEmpty = true ^ listI.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == j0.A) {
                b0(x());
            }
        }
    }

    public void c0(int i2) {
        this.e.setRepeatCount(i2);
    }

    public void d0(int i2) {
        this.e.setRepeatMode(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.Q = false;
        c.a("Drawable#draw");
        if (this.f434h) {
            try {
                g(canvas);
            } catch (Throwable th) {
                com.airbnb.lottie.y0.d.b("Lottie crashed in draw!", th);
            }
        } else {
            g(canvas);
        }
        c.b("Drawable#draw");
    }

    public void e() {
        this.f435i.clear();
        this.e.cancel();
    }

    public void e0(boolean z) {
        this.f434h = z;
    }

    public void f() {
        if (this.e.isRunning()) {
            this.e.cancel();
        }
        this.d = null;
        this.J = null;
        this.t = null;
        this.e.f();
        invalidateSelf();
    }

    public void f0(float f) {
        this.f = f;
        k0();
    }

    void g0(ImageView.ScaleType scaleType) {
        this.f437k = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.K;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.d == null) {
            return -1;
        }
        return (int) (r0.b().height() * A());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.d == null) {
            return -1;
        }
        return (int) (r0.b().width() * A());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h0(float f) {
        this.e.A(f);
    }

    void i0(Boolean bool) {
        this.g = bool.booleanValue();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.Q) {
            return;
        }
        this.Q = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return E();
    }

    public void j(boolean z) {
        if (this.I == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.airbnb.lottie.y0.d.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.I = z;
        if (this.d != null) {
            d();
        }
    }

    public void j0(s0 s0Var) {
    }

    public boolean k() {
        return this.I;
    }

    public void l() {
        this.f435i.clear();
        this.e.g();
    }

    public boolean l0() {
        return this.H == null && this.d.c().i() > 0;
    }

    public e m() {
        return this.d;
    }

    public int p() {
        return (int) this.e.i();
    }

    public Bitmap q(String str) {
        com.airbnb.lottie.u0.b bVarR = r();
        if (bVarR != null) {
            return bVarR.a(str);
        }
        return null;
    }

    public String s() {
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.K = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.airbnb.lottie.y0.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        H();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        l();
    }

    public float t() {
        return this.e.k();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public float v() {
        return this.e.l();
    }

    public o0 w() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.m();
        }
        return null;
    }

    public float x() {
        return this.e.h();
    }

    public int y() {
        return this.e.getRepeatCount();
    }

    public int z() {
        return this.e.getRepeatMode();
    }
}
