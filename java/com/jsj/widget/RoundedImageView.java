package com.jsj.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.jsj.autojs.h;
import java.util.Objects;

/* loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    private static final ImageView.ScaleType[] t = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private int c;
    private int d;
    private ColorStateList e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private int f793h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f794i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f795j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView.ScaleType f796k;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.c = 0;
        this.d = 0;
        this.e = ColorStateList.valueOf(-16777216);
        this.f = false;
        this.g = false;
    }

    private Drawable a() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.f793h;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f793h, e);
                this.f793h = 0;
            }
        }
        return c.c(drawable);
    }

    private void b(Drawable drawable, boolean z) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof c) {
            c cVar = (c) drawable;
            cVar.h(this.f796k);
            cVar.f((!z || this.g) ? this.c : 0.0f);
            cVar.e((!z || this.g) ? this.d : 0);
            cVar.d(this.e);
            cVar.g(this.f);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            while (i < numberOfLayers) {
                b(layerDrawable.getDrawable(i), z);
                i++;
            }
        }
    }

    private void c() {
        b(this.f795j, true);
    }

    private void d() {
        b(this.f794i, false);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.e.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.e;
    }

    public int getBorderWidth() {
        return this.d;
    }

    public int getCornerRadius() {
        return this.c;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f796k;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f795j = c.c(drawable);
        c();
        super.setBackgroundDrawable(this.f795j);
    }

    public void setBorderColor(int i2) {
        setBorderColors(ColorStateList.valueOf(i2));
    }

    public void setBorderColors(ColorStateList colorStateList) {
        if (this.e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.e = colorStateList;
        d();
        c();
        if (this.d > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        if (this.d == i2) {
            return;
        }
        this.d = i2;
        d();
        c();
        invalidate();
    }

    public void setCornerRadius(int i2) {
        if (this.c == i2) {
            return;
        }
        this.c = i2;
        d();
        c();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f793h = 0;
        this.f794i = c.b(bitmap);
        d();
        super.setImageDrawable(this.f794i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f793h = 0;
        this.f794i = c.c(drawable);
        d();
        super.setImageDrawable(this.f794i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.f793h != i2) {
            this.f793h = i2;
            this.f794i = a();
            d();
            super.setImageDrawable(this.f794i);
        }
    }

    public void setOval(boolean z) {
        this.f = z;
        d();
        c();
        invalidate();
    }

    public void setRoundBackground(boolean z) {
        if (this.g == z) {
            return;
        }
        this.g = z;
        c();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Objects.requireNonNull(scaleType);
        if (this.f796k != scaleType) {
            this.f796k = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            d();
            c();
            invalidate();
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 0;
        this.d = 0;
        this.e = ColorStateList.valueOf(-16777216);
        this.f = false;
        this.g = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.c, i2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setScaleType(t[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.d = dimensionPixelSize;
        if (this.c < 0) {
            this.c = 0;
        }
        if (dimensionPixelSize < 0) {
            this.d = 0;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(1);
        this.e = colorStateList;
        if (colorStateList == null) {
            this.e = ColorStateList.valueOf(-16777216);
        }
        this.g = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.f = typedArrayObtainStyledAttributes.getBoolean(4, false);
        d();
        c();
        typedArrayObtainStyledAttributes.recycle();
    }
}
