package com.bumptech.glide.load.z.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.bumptech.glide.load.v;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class f extends Drawable implements k, Animatable {
    private List<h.p.a.a.b> A;
    private final e c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private int f655h;

    /* renamed from: i, reason: collision with root package name */
    private int f656i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f657j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f658k;
    private Rect t;

    public f(Context context, com.bumptech.glide.v.b bVar, v<Bitmap> vVar, int i2, int i3, Bitmap bitmap) {
        this(new e(new n(com.bumptech.glide.c.c(context), bVar, i2, i3, vVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.t == null) {
            this.t = new Rect();
        }
        return this.t;
    }

    private Paint h() {
        if (this.f658k == null) {
            this.f658k = new Paint(2);
        }
        return this.f658k;
    }

    private void j() {
        List<h.p.a.a.b> list = this.A;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A.get(i2).a(this);
            }
        }
    }

    private void l() {
        this.f655h = 0;
    }

    private void n() {
        com.bumptech.glide.b0.n.a(!this.f, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.c.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.d) {
                return;
            }
            this.d = true;
            this.c.a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.d = false;
        this.c.a.s(this);
    }

    @Override // com.bumptech.glide.load.z.j.k
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f655h++;
        }
        int i2 = this.f656i;
        if (i2 == -1 || this.f655h < i2) {
            return;
        }
        j();
        stop();
    }

    public ByteBuffer c() {
        return this.c.a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f) {
            return;
        }
        if (this.f657j) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f657j = false;
        }
        canvas.drawBitmap(this.c.a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.c.a.e();
    }

    public int f() {
        return this.c.a.f();
    }

    public int g() {
        return this.c.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.c.a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d;
    }

    public void k() {
        this.f = true;
        this.c.a.a();
    }

    public void m(v<Bitmap> vVar, Bitmap bitmap) {
        this.c.a.o(vVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f657j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        h().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.bumptech.glide.b0.n.a(!this.f, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.g = z;
        if (!z) {
            o();
        } else if (this.e) {
            n();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.e = true;
        l();
        if (this.g) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.e = false;
        o();
    }

    f(e eVar) {
        this.g = true;
        this.f656i = -1;
        com.bumptech.glide.b0.n.d(eVar);
        this.c = eVar;
    }
}
