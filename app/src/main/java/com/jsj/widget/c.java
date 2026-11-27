package com.jsj.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class c extends Drawable {
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c;
    private final BitmapShader d;
    private final Paint e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f803h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f804i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f805j;

    /* renamed from: k, reason: collision with root package name */
    private float f806k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f807l;

    /* renamed from: m, reason: collision with root package name */
    private float f808m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f809n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView.ScaleType f810o;

    public c(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.f803h = new RectF();
        Matrix matrix = new Matrix();
        this.f805j = matrix;
        this.f806k = 0.0f;
        this.f807l = false;
        this.f808m = 0.0f;
        this.f809n = ColorStateList.valueOf(-16777216);
        this.f810o = ImageView.ScaleType.FIT_CENTER;
        int width = bitmap.getWidth();
        this.f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.d = bitmapShader;
        bitmapShader.setLocalMatrix(matrix);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Paint paint2 = new Paint();
        this.f804i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f809n.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f808m);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Drawable b(Bitmap bitmap) {
        if (bitmap != null) {
            return new c(bitmap);
        }
        return null;
    }

    public static Drawable c(Drawable drawable) {
        if (drawable == null || (drawable instanceof c) || (drawable instanceof ColorDrawable)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapA = a(drawable);
            if (bitmapA != null) {
                return new c(bitmapA);
            }
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), c(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    private void i() {
        float fWidth;
        float fHeight;
        this.f803h.set(this.a);
        RectF rectF = this.b;
        float f = this.f808m;
        rectF.set(f, f, this.f803h.width() - this.f808m, this.f803h.height() - this.f808m);
        float fWidth2 = 0.0f;
        switch (b.a[this.f810o.ordinal()]) {
            case 1:
                this.f803h.set(this.a);
                RectF rectF2 = this.b;
                float f2 = this.f808m;
                rectF2.set(f2, f2, this.f803h.width() - this.f808m, this.f803h.height() - this.f808m);
                this.f805j.set(null);
                this.f805j.setTranslate((int) (((this.b.width() - this.f) * 0.5f) + 0.5f), (int) (((this.b.height() - this.g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f803h.set(this.a);
                RectF rectF3 = this.b;
                float f3 = this.f808m;
                rectF3.set(f3, f3, this.f803h.width() - this.f808m, this.f803h.height() - this.f808m);
                this.f805j.set(null);
                if (this.f * this.b.height() > this.b.width() * this.g) {
                    fWidth = this.b.height() / this.g;
                    fHeight = 0.0f;
                    fWidth2 = (this.b.width() - (this.f * fWidth)) * 0.5f;
                } else {
                    fWidth = this.b.width() / this.f;
                    fHeight = (this.b.height() - (this.g * fWidth)) * 0.5f;
                }
                this.f805j.setScale(fWidth, fWidth);
                Matrix matrix = this.f805j;
                float f4 = this.f808m;
                matrix.postTranslate(((int) (fWidth2 + 0.5f)) + f4, ((int) (fHeight + 0.5f)) + f4);
                break;
            case 3:
                this.f805j.set(null);
                float fMin = (((float) this.f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f, this.a.height() / this.g) : 1.0f;
                float fWidth3 = (int) (((this.a.width() - (this.f * fMin)) * 0.5f) + 0.5f);
                float fHeight2 = (int) (((this.a.height() - (this.g * fMin)) * 0.5f) + 0.5f);
                this.f805j.setScale(fMin, fMin);
                this.f805j.postTranslate(fWidth3, fHeight2);
                this.f803h.set(this.c);
                this.f805j.mapRect(this.f803h);
                RectF rectF4 = this.b;
                RectF rectF5 = this.f803h;
                float f5 = rectF5.left;
                float f6 = this.f808m;
                rectF4.set(f5 + f6, rectF5.top + f6, rectF5.right - f6, rectF5.bottom - f6);
                this.f805j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f803h.set(this.c);
                this.f805j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.f805j.mapRect(this.f803h);
                RectF rectF6 = this.b;
                RectF rectF7 = this.f803h;
                float f7 = rectF7.left;
                float f8 = this.f808m;
                rectF6.set(f7 + f8, rectF7.top + f8, rectF7.right - f8, rectF7.bottom - f8);
                this.f805j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f803h.set(this.c);
                this.f805j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
                this.f805j.mapRect(this.f803h);
                RectF rectF8 = this.b;
                RectF rectF9 = this.f803h;
                float f9 = rectF9.left;
                float f10 = this.f808m;
                rectF8.set(f9 + f10, rectF9.top + f10, rectF9.right - f10, rectF9.bottom - f10);
                this.f805j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f803h.set(this.c);
                this.f805j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
                this.f805j.mapRect(this.f803h);
                RectF rectF10 = this.b;
                RectF rectF11 = this.f803h;
                float f11 = rectF11.left;
                float f12 = this.f808m;
                rectF10.set(f11 + f12, rectF11.top + f12, rectF11.right - f12, rectF11.bottom - f12);
                this.f805j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f803h.set(this.a);
                RectF rectF12 = this.b;
                float f13 = this.f808m;
                rectF12.set(f13 + 0.0f, f13 + 0.0f, this.f803h.width() - this.f808m, this.f803h.height() - this.f808m);
                this.f805j.set(null);
                this.f805j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                break;
        }
        RectF rectF13 = this.f803h;
        float f14 = this.f808m;
        rectF13.inset(f14 / 2.0f, f14 / 2.0f);
        this.d.setLocalMatrix(this.f805j);
    }

    public c d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f809n = colorStateList;
        this.f804i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f807l) {
            if (this.f808m <= 0.0f) {
                canvas.drawOval(this.b, this.e);
                return;
            } else {
                canvas.drawOval(this.f803h, this.f804i);
                canvas.drawOval(this.b, this.e);
                return;
            }
        }
        if (this.f808m <= 0.0f) {
            RectF rectF = this.b;
            float f = this.f806k;
            canvas.drawRoundRect(rectF, f, f, this.e);
        } else {
            RectF rectF2 = this.f803h;
            float f2 = this.f806k;
            canvas.drawRoundRect(rectF2, f2, f2, this.f804i);
            canvas.drawRoundRect(this.b, Math.max(this.f806k - this.f808m, 0.0f), Math.max(this.f806k - this.f808m, 0.0f), this.e);
        }
    }

    public c e(int i2) {
        float f = i2;
        this.f808m = f;
        this.f804i.setStrokeWidth(f);
        return this;
    }

    public c f(float f) {
        this.f806k = f;
        return this;
    }

    public c g(boolean z) {
        this.f807l = z;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public c h(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f810o != scaleType) {
            this.f810o = scaleType;
            i();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f809n.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        i();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f809n.getColorForState(iArr, 0);
        if (this.f804i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f804i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.e.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }
}
