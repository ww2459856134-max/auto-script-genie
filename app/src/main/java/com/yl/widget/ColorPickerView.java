package com.yl.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.frame.k0;
import com.yl.ui.e0;

/* loaded from: classes.dex */
public class ColorPickerView extends View {
    private final Rect A;
    private int C;
    private b D;
    private Bitmap G;
    private Bitmap H;
    private boolean I;
    private boolean J;
    private int K;
    private int M;
    private int[] O;
    private int P;
    private int Q;
    private int U;
    private a V;
    private int c;
    private boolean d;
    private final Paint e;
    private final Paint f;
    private LinearGradient g;

    /* renamed from: h, reason: collision with root package name */
    private int f1166h;

    /* renamed from: i, reason: collision with root package name */
    private int f1167i;

    /* renamed from: j, reason: collision with root package name */
    private int f1168j;

    /* renamed from: k, reason: collision with root package name */
    private int f1169k;
    private final Rect t;

    public interface a {
        void a(ColorPickerView colorPickerView, int i2, int i3);

        void b(ColorPickerView colorPickerView);

        void c(ColorPickerView colorPickerView);
    }

    public enum b {
        HORIZONTAL,
        VERTICAL
    }

    private class c extends View.BaseSavedState {
        int c;
        int d;
        int[] e;
        Bitmap f;
        Bitmap g;

        c(ColorPickerView colorPickerView, Parcelable parcelable) {
            super(parcelable);
            this.g = null;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                parcel.writeParcelable(this.f, i2);
                parcel.writeIntArray(this.e);
            }
            Bitmap bitmap2 = this.g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            parcel.writeParcelable(this.g, i2);
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        this.t = new Rect();
        this.A = new Rect();
        this.I = true;
        this.J = true;
        this.O = null;
        this.U = 100;
        this.G = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        this.H = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setAntiAlias(true);
        this.M = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
    }

    private int a() {
        int width;
        int i2;
        int height;
        try {
            if (this.D == b.HORIZONTAL) {
                Rect rect = this.t;
                int i3 = rect.right;
                int i4 = rect.left;
                i2 = i3 - i4;
                height = (rect.bottom - rect.top) / 2;
                int i5 = this.K;
                if (i5 >= i4) {
                    width = i5 > i3 ? this.G.getWidth() - 1 : i5 - i4;
                }
            } else {
                Rect rect2 = this.t;
                int i6 = rect2.bottom;
                int i7 = rect2.top;
                i2 = i6 - i7;
                int i8 = (rect2.right - rect2.left) / 2;
                int i9 = this.M;
                height = i9 >= i7 ? i9 > i6 ? this.G.getHeight() - 1 : i9 - i7 : 1;
                width = i8;
            }
            this.P = j(this.G.getPixel(width, height));
        } catch (Exception e) {
            k0.r(e);
        }
        if (i2 == 0) {
            return 0;
        }
        this.Q = (width * this.U) / i2;
        return this.P;
    }

    private void b() {
        int height;
        int width;
        int i2;
        int height2;
        int i3 = this.f1169k - this.f1166h;
        int i4 = this.f1168j - this.f1167i;
        int iMin = Math.min(i4, i3);
        b bVar = this.D;
        b bVar2 = b.HORIZONTAL;
        if (bVar == bVar2) {
            if (i4 <= i3) {
                iMin = i4 / 6;
            }
        } else if (i4 >= i3) {
            iMin = i3 / 6;
        }
        int i5 = iMin / 9;
        int i6 = (i5 * 7) / 2;
        this.C = i6;
        int i7 = (i5 * 3) / 2;
        if (bVar == bVar2) {
            i2 = this.f1167i + i6;
            width = this.f1168j - i6;
            height2 = (getHeight() / 2) - i7;
            height = (getHeight() / 2) + i7;
        } else {
            int i8 = this.f1166h + i6;
            height = this.f1169k - i6;
            int width2 = (getWidth() / 2) - i7;
            width = (getWidth() / 2) + i7;
            i2 = width2;
            height2 = i8;
        }
        this.t.set(i2, height2, width, height);
    }

    private void c() {
        int iHeight = this.t.height();
        int iWidth = this.t.width();
        int i2 = this.C * 2;
        Bitmap bitmap = this.G;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.G.recycle();
            this.G = null;
        }
        Bitmap bitmap2 = this.H;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.H.recycle();
            this.H = null;
        }
        this.G = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        this.H = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
    }

    private void d() {
        Canvas canvas = new Canvas(this.G);
        RectF rectF = new RectF(0.0f, 0.0f, this.G.getWidth(), this.G.getHeight());
        int height = this.D == b.HORIZONTAL ? this.G.getHeight() / 2 : this.G.getWidth() / 2;
        this.e.setColor(-16777216);
        float f = height;
        canvas.drawRoundRect(rectF, f, f, this.e);
        this.e.setShader(this.g);
        canvas.drawRoundRect(rectF, f, f, this.e);
        this.e.setShader(null);
        this.I = false;
    }

    private void f() {
        this.f.setColor(this.c);
        this.f.setShadowLayer(3, 0.0f, 0.0f, -7829368);
        Canvas canvas = new Canvas(this.H);
        int i2 = this.C;
        canvas.drawCircle(i2, i2, i2 - 3, this.f);
        this.J = false;
    }

    private boolean g(int i2, int i3) {
        if (this.D == b.HORIZONTAL) {
            int i4 = this.f1167i;
            int i5 = this.C;
            return i2 > i4 + i5 && i2 < this.f1168j - i5;
        }
        int i6 = this.f1166h;
        int i7 = this.C;
        return i3 > i6 + i7 && i3 < this.f1169k - i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2) {
        if (this.D == b.HORIZONTAL) {
            this.K = (int) ((this.f1168j - this.f1167i) * i2 * 0.01f);
        } else {
            this.M = (int) ((this.f1169k - this.f1166h) * i2 * 0.01f);
        }
        if (this.d) {
            this.J = true;
        }
        try {
            a();
        } catch (Exception e) {
            k0.r(e);
        }
        invalidate();
    }

    private int j(int i2) {
        return Color.argb(Color.alpha(i2), Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public int[] e() {
        return new int[]{Color.rgb(255, 0, 0), Color.rgb(255, 255, 0), Color.rgb(0, 255, 0), Color.rgb(0, 255, 255), Color.rgb(0, 0, 255), Color.rgb(255, 0, 255), Color.rgb(255, 0, 0)};
    }

    public int getColor() {
        return a();
    }

    public int getIndicatorColor() {
        return this.c;
    }

    public int getMax() {
        return this.U;
    }

    public int getProgress() {
        return this.Q;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.I) {
            d();
        }
        if (!this.G.isRecycled()) {
            canvas.drawBitmap(this.G, (Rect) null, this.t, this.e);
        }
        if (this.d) {
            if (this.J) {
                f();
            }
            Rect rect = this.A;
            int i2 = this.K;
            int i3 = this.C;
            int i4 = this.M;
            rect.set(i2 - i3, i4 - i3, i2 + i3, i4 + i3);
            if (this.H.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.H, (Rect) null, this.A, this.e);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f1166h = getPaddingTop();
        this.f1167i = getPaddingLeft();
        this.f1169k = getMeasuredHeight() - getPaddingBottom();
        this.f1168j = getMeasuredWidth() - getPaddingRight();
        int i6 = this.K;
        int i7 = this.M;
        if (i6 == i7 || i7 == Integer.MAX_VALUE) {
            this.K = getWidth() / 2;
            this.M = getHeight() / 2;
        }
        b();
        int[] iArr = this.O;
        if (iArr == null) {
            setColors(e());
        } else {
            setColors(iArr);
        }
        c();
        if (this.d) {
            this.J = true;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            size = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight();
        }
        if (mode2 != 1073741824) {
            size2 = getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom();
        }
        b bVar = this.D;
        b bVar2 = b.HORIZONTAL;
        setMeasuredDimension(Math.max(size, bVar == bVar2 ? 420 : 70), Math.max(size2, this.D == bVar2 ? 70 : 420));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.K = cVar.c;
        this.M = cVar.d;
        this.O = cVar.e;
        this.G = cVar.f;
        if (this.d) {
            this.H = cVar.g;
            this.J = true;
        }
        this.I = true;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(this, super.onSaveInstanceState());
        cVar.c = this.K;
        cVar.d = this.M;
        cVar.f = this.G;
        if (this.d) {
            cVar.g = this.H;
        }
        return cVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!g(x, y)) {
            return true;
        }
        if (this.D == b.HORIZONTAL) {
            this.K = x;
            this.M = getHeight() / 2;
        } else {
            this.K = getWidth() / 2;
            this.M = y;
        }
        if (motionEvent.getActionMasked() == 0) {
            a aVar = this.V;
            if (aVar != null) {
                aVar.c(this);
                a();
                this.V.a(this, this.P, this.Q);
            }
        } else if (motionEvent.getActionMasked() == 1) {
            a aVar2 = this.V;
            if (aVar2 != null) {
                aVar2.b(this);
                a();
                this.V.a(this, this.P, this.Q);
            }
        } else if (this.V != null) {
            a();
            this.V.a(this, this.P, this.Q);
        }
        invalidate();
        return true;
    }

    public void setColors(int... iArr) {
        this.g = null;
        this.O = iArr;
        if (this.D == b.HORIZONTAL) {
            Rect rect = this.t;
            float f = rect.left;
            int i2 = rect.top;
            this.g = new LinearGradient(f, i2, rect.right, i2, iArr, (float[]) null, Shader.TileMode.CLAMP);
        } else {
            int i3 = this.t.left;
            this.g = new LinearGradient(i3, r1.top, i3, r1.bottom, iArr, (float[]) null, Shader.TileMode.CLAMP);
        }
        this.I = true;
        invalidate();
    }

    public void setIndicatorColor(int i2) {
        this.c = i2;
        this.J = true;
        invalidate();
    }

    public void setMax(int i2) {
        this.U = i2;
    }

    public void setOnColorPickerChangeListener(a aVar) {
        this.V = aVar;
    }

    public void setOrientation(b bVar) {
        this.D = bVar;
        this.J = true;
        this.I = true;
        requestLayout();
    }

    public void setPosition(int i2, int i3) {
        if (g(i2, i3)) {
            this.K = i2;
            this.M = i3;
            if (this.d) {
                this.J = true;
            }
            invalidate();
        }
    }

    public void setProgress(final int i2) {
        post(new Runnable() { // from class: com.yl.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i(i2);
            }
        });
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = new Rect();
        this.A = new Rect();
        this.I = true;
        this.J = true;
        this.O = null;
        this.U = 100;
        this.G = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        this.H = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f = paint2;
        paint2.setAntiAlias(true);
        this.M = Integer.MAX_VALUE;
        this.K = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e0.a, i2, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(e0.b, -1);
        this.D = typedArrayObtainStyledAttributes.getInteger(e0.d, 0) == 0 ? b.HORIZONTAL : b.VERTICAL;
        this.d = typedArrayObtainStyledAttributes.getBoolean(e0.c, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
