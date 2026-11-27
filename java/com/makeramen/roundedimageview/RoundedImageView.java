package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    public static final Shader.TileMode H = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] I = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private int A;
    private ImageView.ScaleType C;
    private Shader.TileMode D;
    private Shader.TileMode G;
    private final float[] c;
    private Drawable d;
    private ColorStateList e;
    private float f;
    private ColorFilter g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f811h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f812i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f813j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f814k;
    private boolean t;

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
        this.c = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.e = ColorStateList.valueOf(-16777216);
        this.f = 0.0f;
        this.g = null;
        this.f811h = false;
        this.f813j = false;
        this.f814k = false;
        this.t = false;
        this.C = ImageView.ScaleType.FIT_CENTER;
        Shader.TileMode tileMode = H;
        this.D = tileMode;
        this.G = tileMode;
    }

    private void a() {
        Drawable drawable = this.f812i;
        if (drawable == null || !this.f811h) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f812i = drawableMutate;
        if (this.f813j) {
            drawableMutate.setColorFilter(this.g);
        }
    }

    private static Shader.TileMode b(int i2) {
        if (i2 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    private Drawable c() throws Resources.NotFoundException {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.A;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.A, e);
                this.A = 0;
            }
        }
        return c.e(drawable);
    }

    private void d(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (!(drawable instanceof c)) {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    d(layerDrawable.getDrawable(i2));
                }
                return;
            }
            return;
        }
        c cVar = (c) drawable;
        cVar.l(this.C);
        cVar.i(this.f);
        cVar.h(this.e);
        cVar.k(this.f814k);
        cVar.m(this.D);
        cVar.n(this.G);
        float[] fArr = this.c;
        if (fArr != null) {
            cVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
        }
        a();
    }

    private void e(boolean z) {
        if (this.t) {
            if (z) {
                this.d = c.e(this.d);
            }
            d(this.d);
        }
    }

    private void f() {
        d(this.f812i);
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

    public float getBorderWidth() {
        return this.f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.c) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.C;
    }

    public Shader.TileMode getTileModeX() {
        return this.D;
    }

    public Shader.TileMode getTileModeY() {
        return this.G;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.d = drawable;
        e(true);
        super.setBackgroundDrawable(this.d);
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.g != colorFilter) {
            this.g = colorFilter;
            this.f813j = true;
            this.f811h = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        setCornerRadius(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i2) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(i2);
        setCornerRadius(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.A = 0;
        this.f812i = c.d(bitmap);
        f();
        super.setImageDrawable(this.f812i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.A = 0;
        this.f812i = c.e(drawable);
        f();
        super.setImageDrawable(this.f812i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.A != i2) {
            this.A = i2;
            this.f812i = c();
            f();
            super.setImageDrawable(this.f812i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.f814k = z;
        f();
        e(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.C != scaleType) {
            this.C = scaleType;
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
            f();
            e(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.D == tileMode) {
            return;
        }
        this.D = tileMode;
        f();
        e(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.G == tileMode) {
            return;
        }
        this.G = tileMode;
        f();
        e(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.e.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.e = colorStateList;
        f();
        e(false);
        if (this.f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.f == f) {
            return;
        }
        this.f = f;
        f();
        e(false);
        invalidate();
    }

    public void setCornerRadius(int i2, float f) {
        float[] fArr = this.c;
        if (fArr[i2] == f) {
            return;
        }
        fArr[i2] = f;
        f();
        e(false);
        invalidate();
    }

    public void setCornerRadiusDimen(int i2, int i3) {
        setCornerRadius(i2, getResources().getDimensionPixelSize(i3));
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        float[] fArr = this.c;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        f();
        e(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.c = fArr;
        this.e = ColorStateList.valueOf(-16777216);
        this.f = 0.0f;
        this.g = null;
        this.f811h = false;
        this.f813j = false;
        this.f814k = false;
        this.t = false;
        this.C = ImageView.ScaleType.FIT_CENTER;
        Shader.TileMode tileMode = H;
        this.D = tileMode;
        this.G = tileMode;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.makeramen.roundedimageview.a.a, i2, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.b, -1);
        if (i3 >= 0) {
            setScaleType(I[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.e, -1);
        fArr[0] = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f815h, -1);
        fArr[1] = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f816i, -1);
        fArr[2] = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.g, -1);
        fArr[3] = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.f, -1);
        int length = fArr.length;
        boolean z = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr2 = this.c;
            if (fArr2[i4] < 0.0f) {
                fArr2[i4] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.c.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.c[i5] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.makeramen.roundedimageview.a.d, -1);
        this.f = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f = 0.0f;
        }
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(com.makeramen.roundedimageview.a.c);
        this.e = colorStateList;
        if (colorStateList == null) {
            this.e = ColorStateList.valueOf(-16777216);
        }
        this.t = typedArrayObtainStyledAttributes.getBoolean(com.makeramen.roundedimageview.a.f817j, false);
        this.f814k = typedArrayObtainStyledAttributes.getBoolean(com.makeramen.roundedimageview.a.f818k, false);
        int i6 = typedArrayObtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.f819l, -2);
        if (i6 != -2) {
            setTileModeX(b(i6));
            setTileModeY(b(i6));
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.f820m, -2);
        if (i7 != -2) {
            setTileModeX(b(i7));
        }
        int i8 = typedArrayObtainStyledAttributes.getInt(com.makeramen.roundedimageview.a.f821n, -2);
        if (i8 != -2) {
            setTileModeY(b(i8));
        }
        f();
        e(true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
