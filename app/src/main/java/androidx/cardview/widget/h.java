package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class h extends Drawable {
    private float a;
    private final RectF c;
    private final Rect d;
    private float e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f192h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f193i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f194j;
    private boolean f = false;
    private boolean g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f195k = PorterDuff.Mode.SRC_IN;
    private final Paint b = new Paint(5);

    h(ColorStateList colorStateList, float f) {
        this.a = f;
        e(colorStateList);
        this.c = new RectF();
        this.d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f192h = colorStateList;
        this.b.setColor(colorStateList.getColorForState(getState(), this.f192h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.d.set(rect);
        if (this.f) {
            this.d.inset((int) Math.ceil(j.c(this.e, this.a, this.g)), (int) Math.ceil(j.d(this.e, this.a, this.g)));
            this.c.set(this.d);
        }
    }

    public ColorStateList b() {
        return this.f192h;
    }

    float c() {
        return this.e;
    }

    public float d() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.b;
        if (this.f193i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f193i);
            z = true;
        }
        RectF rectF = this.c;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f, boolean z, boolean z2) {
        if (f == this.e && this.f == z && this.g == z2) {
            return;
        }
        this.e = f;
        this.f = z;
        this.g = z2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    void h(float f) {
        if (f == this.a) {
            return;
        }
        this.a = f;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f194j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f192h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f192h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.b.getColor();
        if (z) {
            this.b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f194j;
        if (colorStateList2 == null || (mode = this.f195k) == null) {
            return z;
        }
        this.f193i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f194j = colorStateList;
        this.f193i = a(colorStateList, this.f195k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f195k = mode;
        this.f193i = a(this.f194j, mode);
        invalidateSelf();
    }
}
