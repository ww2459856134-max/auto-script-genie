package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class j extends Drawable {
    private static final double q = Math.cos(Math.toRadians(45.0d));
    static i r;
    private final int a;
    private Paint c;
    private Paint d;
    private final RectF e;
    private float f;
    private Path g;

    /* renamed from: h, reason: collision with root package name */
    private float f196h;

    /* renamed from: i, reason: collision with root package name */
    private float f197i;

    /* renamed from: j, reason: collision with root package name */
    private float f198j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f199k;

    /* renamed from: m, reason: collision with root package name */
    private final int f201m;

    /* renamed from: n, reason: collision with root package name */
    private final int f202n;

    /* renamed from: l, reason: collision with root package name */
    private boolean f200l = true;

    /* renamed from: o, reason: collision with root package name */
    private boolean f203o = true;
    private boolean p = false;
    private Paint b = new Paint(5);

    j(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f201m = resources.getColor(h.c.b.d);
        this.f202n = resources.getColor(h.c.b.c);
        this.a = resources.getDimensionPixelSize(h.c.c.a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f = (int) (f + 0.5f);
        this.e = new RectF();
        Paint paint2 = new Paint(this.c);
        this.d = paint2;
        paint2.setAntiAlias(false);
        s(f2, f3);
    }

    private void a(Rect rect) {
        float f = this.f196h;
        float f2 = 1.5f * f;
        this.e.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        b();
    }

    private void b() {
        float f = this.f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f197i;
        rectF2.inset(-f2, -f2);
        Path path = this.g;
        if (path == null) {
            this.g = new Path();
        } else {
            path.reset();
        }
        this.g.setFillType(Path.FillType.EVEN_ODD);
        this.g.moveTo(-this.f, 0.0f);
        this.g.rLineTo(-this.f197i, 0.0f);
        this.g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.g.arcTo(rectF, 270.0f, -90.0f, false);
        this.g.close();
        float f3 = this.f;
        float f4 = f3 / (this.f197i + f3);
        Paint paint = this.c;
        float f5 = this.f + this.f197i;
        int i2 = this.f201m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i2, i2, this.f202n}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.d;
        float f6 = this.f;
        float f7 = this.f197i;
        int i3 = this.f201m;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i3, i3, this.f202n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.d.setAntiAlias(false);
    }

    static float c(float f, float f2, boolean z) {
        return z ? (float) (f + ((1.0d - q) * f2)) : f;
    }

    static float d(float f, float f2, boolean z) {
        return z ? (float) ((f * 1.5f) + ((1.0d - q) * f2)) : f * 1.5f;
    }

    private void e(Canvas canvas) {
        float f = this.f;
        float f2 = (-f) - this.f197i;
        float f3 = f + this.a + (this.f198j / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.e.width() - f4 > 0.0f;
        boolean z2 = this.e.height() - f4 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.e;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.e.width() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.e;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.g, this.c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.e.width() - f4, (-this.f) + this.f197i, this.d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.e;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.e.height() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.e;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.g, this.c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.e.height() - f4, -this.f, this.d);
        }
        canvas.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f199k = colorStateList;
        this.b.setColor(colorStateList.getColorForState(getState(), this.f199k.getDefaultColor()));
    }

    private void s(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fT = t(f);
        float fT2 = t(f2);
        if (fT > fT2) {
            if (!this.p) {
                this.p = true;
            }
            fT = fT2;
        }
        if (this.f198j == fT && this.f196h == fT2) {
            return;
        }
        this.f198j = fT;
        this.f196h = fT2;
        this.f197i = (int) ((fT * 1.5f) + this.a + 0.5f);
        this.f200l = true;
        invalidateSelf();
    }

    private int t(float f) {
        int i2 = (int) (f + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f200l) {
            a(getBounds());
            this.f200l = false;
        }
        canvas.translate(0.0f, this.f198j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f198j) / 2.0f);
        r.a(canvas, this.e, this.f, this.b);
    }

    ColorStateList f() {
        return this.f199k;
    }

    float g() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f196h, this.f, this.f203o));
        int iCeil2 = (int) Math.ceil(c(this.f196h, this.f, this.f203o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f196h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f199k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f = this.f196h;
        return (Math.max(f, this.f + this.a + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f196h * 1.5f) + this.a) * 2.0f);
    }

    float k() {
        float f = this.f196h;
        return (Math.max(f, this.f + this.a + (f / 2.0f)) * 2.0f) + ((this.f196h + this.a) * 2.0f);
    }

    float l() {
        return this.f198j;
    }

    void m(boolean z) {
        this.f203o = z;
        invalidateSelf();
    }

    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f200l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f199k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.b.getColor() == colorForState) {
            return false;
        }
        this.b.setColor(colorForState);
        this.f200l = true;
        invalidateSelf();
        return true;
    }

    void p(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.f == f2) {
            return;
        }
        this.f = f2;
        this.f200l = true;
        invalidateSelf();
    }

    void q(float f) {
        s(this.f198j, f);
    }

    void r(float f) {
        s(f, this.f196h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
        this.c.setAlpha(i2);
        this.d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
