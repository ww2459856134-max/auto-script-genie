package com.makeramen.roundedimageview;

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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* loaded from: classes.dex */
public class c extends Drawable {
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c;
    private final Bitmap d;
    private final Paint e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f822h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f823i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f824j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f825k;

    /* renamed from: l, reason: collision with root package name */
    private Shader.TileMode f826l;

    /* renamed from: m, reason: collision with root package name */
    private Shader.TileMode f827m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f828n;

    /* renamed from: o, reason: collision with root package name */
    private float f829o;
    private final boolean[] p;
    private boolean q;
    private float r;
    private ColorStateList s;
    private ImageView.ScaleType t;

    public c(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.c = rectF;
        this.f822h = new RectF();
        this.f824j = new Matrix();
        this.f825k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f826l = tileMode;
        this.f827m = tileMode;
        this.f828n = true;
        this.f829o = 0.0f;
        this.p = new boolean[]{true, true, true, true};
        this.q = false;
        this.r = 0.0f;
        this.s = ColorStateList.valueOf(-16777216);
        this.t = ImageView.ScaleType.FIT_CENTER;
        this.d = bitmap;
        int width = bitmap.getWidth();
        this.f = width;
        int height = bitmap.getHeight();
        this.g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f823i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static c d(Bitmap bitmap) {
        if (bitmap != null) {
            return new c(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof c)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapC = c(drawable);
            return bitmapC != null ? new c(bitmapC) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), e(layerDrawable.getDrawable(i2)));
        }
        return layerDrawable;
    }

    private void f(Canvas canvas) {
        if (a(this.p) || this.f829o == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f = rectF.left;
        float f2 = rectF.top;
        float fWidth = rectF.width() + f;
        float fHeight = this.b.height() + f2;
        float f3 = this.f829o;
        if (!this.p[0]) {
            this.f825k.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.f825k, this.e);
        }
        if (!this.p[1]) {
            this.f825k.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.f825k, this.e);
        }
        if (!this.p[2]) {
            this.f825k.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.f825k, this.e);
        }
        if (this.p[3]) {
            return;
        }
        this.f825k.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.f825k, this.e);
    }

    private void g(Canvas canvas) {
        float f;
        if (a(this.p) || this.f829o == 0.0f) {
            return;
        }
        RectF rectF = this.b;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float fWidth = rectF.width() + f2;
        float fHeight = f3 + this.b.height();
        float f4 = this.f829o;
        float f5 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.f823i);
            canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.f823i);
        }
        if (!this.p[1]) {
            canvas.drawLine((fWidth - f4) - f5, f3, fWidth, f3, this.f823i);
            canvas.drawLine(fWidth, f3 - f5, fWidth, f3 + f4, this.f823i);
        }
        if (this.p[2]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine((fWidth - f4) - f5, fHeight, fWidth + f5, fHeight, this.f823i);
            canvas.drawLine(fWidth, fHeight - f, fWidth, fHeight, this.f823i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f2 - f5, fHeight, f2 + f, fHeight, this.f823i);
        canvas.drawLine(f2, fHeight - f, f2, fHeight, this.f823i);
    }

    private void o() {
        float fWidth;
        float fHeight;
        int i2 = b.a[this.t.ordinal()];
        if (i2 == 1) {
            this.f822h.set(this.a);
            RectF rectF = this.f822h;
            float f = this.r;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.f824j.reset();
            this.f824j.setTranslate((int) (((this.f822h.width() - this.f) * 0.5f) + 0.5f), (int) (((this.f822h.height() - this.g) * 0.5f) + 0.5f));
        } else if (i2 == 2) {
            this.f822h.set(this.a);
            RectF rectF2 = this.f822h;
            float f2 = this.r;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.f824j.reset();
            float fWidth2 = 0.0f;
            if (this.f * this.f822h.height() > this.f822h.width() * this.g) {
                fWidth = this.f822h.height() / this.g;
                fHeight = 0.0f;
                fWidth2 = (this.f822h.width() - (this.f * fWidth)) * 0.5f;
            } else {
                fWidth = this.f822h.width() / this.f;
                fHeight = (this.f822h.height() - (this.g * fWidth)) * 0.5f;
            }
            this.f824j.setScale(fWidth, fWidth);
            Matrix matrix = this.f824j;
            float f3 = this.r;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i2 == 3) {
            this.f824j.reset();
            float fMin = (((float) this.f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f, this.a.height() / this.g) : 1.0f;
            float fWidth3 = (int) (((this.a.width() - (this.f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.a.height() - (this.g * fMin)) * 0.5f) + 0.5f);
            this.f824j.setScale(fMin, fMin);
            this.f824j.postTranslate(fWidth3, fHeight2);
            this.f822h.set(this.c);
            this.f824j.mapRect(this.f822h);
            RectF rectF3 = this.f822h;
            float f4 = this.r;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.f824j.setRectToRect(this.c, this.f822h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 5) {
            this.f822h.set(this.c);
            this.f824j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.f824j.mapRect(this.f822h);
            RectF rectF4 = this.f822h;
            float f5 = this.r;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.f824j.setRectToRect(this.c, this.f822h, Matrix.ScaleToFit.FILL);
        } else if (i2 == 6) {
            this.f822h.set(this.c);
            this.f824j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.f824j.mapRect(this.f822h);
            RectF rectF5 = this.f822h;
            float f6 = this.r;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.f824j.setRectToRect(this.c, this.f822h, Matrix.ScaleToFit.FILL);
        } else if (i2 != 7) {
            this.f822h.set(this.c);
            this.f824j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
            this.f824j.mapRect(this.f822h);
            RectF rectF6 = this.f822h;
            float f7 = this.r;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.f824j.setRectToRect(this.c, this.f822h, Matrix.ScaleToFit.FILL);
        } else {
            this.f822h.set(this.a);
            RectF rectF7 = this.f822h;
            float f8 = this.r;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.f824j.reset();
            this.f824j.setRectToRect(this.c, this.f822h, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.f822h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f828n) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.f826l, this.f827m);
            Shader.TileMode tileMode = this.f826l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f827m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f824j);
            }
            this.e.setShader(bitmapShader);
            this.f828n = false;
        }
        if (this.q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.b, this.e);
                return;
            } else {
                canvas.drawOval(this.b, this.e);
                canvas.drawOval(this.f822h, this.f823i);
                return;
            }
        }
        if (!b(this.p)) {
            canvas.drawRect(this.b, this.e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.f822h, this.f823i);
                return;
            }
            return;
        }
        float f = this.f829o;
        if (this.r <= 0.0f) {
            canvas.drawRoundRect(this.b, f, f, this.e);
            f(canvas);
        } else {
            canvas.drawRoundRect(this.b, f, f, this.e);
            canvas.drawRoundRect(this.f822h, f, f, this.f823i);
            f(canvas);
            g(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
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

    public c h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.f823i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public c i(float f) {
        this.r = f;
        this.f823i.setStrokeWidth(f);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    public c j(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.f829o = 0.0f;
        } else {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + fFloatValue);
            }
            this.f829o = fFloatValue;
        }
        boolean[] zArr = this.p;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public c k(boolean z) {
        this.q = z;
        return this;
    }

    public c l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType) {
            this.t = scaleType;
            o();
        }
        return this;
    }

    public c m(Shader.TileMode tileMode) {
        if (this.f826l != tileMode) {
            this.f826l = tileMode;
            this.f828n = true;
            invalidateSelf();
        }
        return this;
    }

    public c n(Shader.TileMode tileMode) {
        if (this.f827m != tileMode) {
            this.f827m = tileMode;
            this.f828n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.f823i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f823i.setColor(colorForState);
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
