package h.p.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class t extends Drawable.ConstantState {
    int a;
    s b;
    ColorStateList c;
    PorterDuff.Mode d;
    boolean e;
    Bitmap f;
    ColorStateList g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f1375h;

    /* renamed from: i, reason: collision with root package name */
    int f1376i;

    /* renamed from: j, reason: collision with root package name */
    boolean f1377j;

    /* renamed from: k, reason: collision with root package name */
    boolean f1378k;

    /* renamed from: l, reason: collision with root package name */
    Paint f1379l;

    public t(t tVar) {
        this.c = null;
        this.d = v.t;
        if (tVar != null) {
            this.a = tVar.a;
            s sVar = new s(tVar.b);
            this.b = sVar;
            if (tVar.b.e != null) {
                sVar.e = new Paint(tVar.b.e);
            }
            if (tVar.b.d != null) {
                this.b.d = new Paint(tVar.b.d);
            }
            this.c = tVar.c;
            this.d = tVar.d;
            this.e = tVar.e;
        }
    }

    public boolean a(int i2, int i3) {
        return i2 == this.f.getWidth() && i3 == this.f.getHeight();
    }

    public boolean b() {
        return !this.f1378k && this.g == this.c && this.f1375h == this.d && this.f1377j == this.e && this.f1376i == this.b.getRootAlpha();
    }

    public void c(int i2, int i3) {
        if (this.f == null || !a(i2, i3)) {
            this.f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f1378k = true;
        }
    }

    public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
    }

    public Paint e(ColorFilter colorFilter) {
        if (!f() && colorFilter == null) {
            return null;
        }
        if (this.f1379l == null) {
            Paint paint = new Paint();
            this.f1379l = paint;
            paint.setFilterBitmap(true);
        }
        this.f1379l.setAlpha(this.b.getRootAlpha());
        this.f1379l.setColorFilter(colorFilter);
        return this.f1379l;
    }

    public boolean f() {
        return this.b.getRootAlpha() < 255;
    }

    public boolean g() {
        return this.b.f();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a;
    }

    public boolean h(int[] iArr) {
        boolean zG = this.b.g(iArr);
        this.f1378k |= zG;
        return zG;
    }

    public void i() {
        this.g = this.c;
        this.f1375h = this.d;
        this.f1376i = this.b.getRootAlpha();
        this.f1377j = this.e;
        this.f1378k = false;
    }

    public void j(int i2, int i3) {
        this.f.eraseColor(0);
        this.b.b(new Canvas(this.f), i2, i3, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new v(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new v(this);
    }

    public t() {
        this.c = null;
        this.d = v.t;
        this.b = new s();
    }
}
