package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f188j = {R.attr.colorBackground};

    /* renamed from: k, reason: collision with root package name */
    private static final g f189k;
    private boolean c;
    private boolean d;
    int e;
    int f;
    final Rect g;

    /* renamed from: h, reason: collision with root package name */
    final Rect f190h;

    /* renamed from: i, reason: collision with root package name */
    private final f f191i;

    class a implements f {
        private Drawable a;

        a() {
        }

        @Override // androidx.cardview.widget.f
        public boolean a() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.f
        public void b(int i2, int i3, int i4, int i5) {
            CardView.this.f190h.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.g;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.f
        public void c(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.e) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.f
        public void d(Drawable drawable) {
            this.a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.f
        public Drawable e() {
            return this.a;
        }

        @Override // androidx.cardview.widget.f
        public boolean f() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.f
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f189k = new c();
        } else if (i2 >= 17) {
            f189k = new b();
        } else {
            f189k = new e();
        }
        f189k.n();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f189k.j(this.f191i);
    }

    public float getCardElevation() {
        return f189k.d(this.f191i);
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public float getMaxCardElevation() {
        return f189k.b(this.f191i);
    }

    public boolean getPreventCornerOverlap() {
        return this.d;
    }

    public float getRadius() {
        return f189k.a(this.f191i);
    }

    public boolean getUseCompatPadding() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (f189k instanceof c) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.f(this.f191i)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(this.f191i)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f189k.o(this.f191i, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f) {
        f189k.i(this.f191i, f);
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.g.set(i2, i3, i4, i5);
        f189k.e(this.f191i);
    }

    public void setMaxCardElevation(float f) {
        f189k.g(this.f191i, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.e = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.d) {
            this.d = z;
            f189k.k(this.f191i);
        }
    }

    public void setRadius(float f) {
        f189k.h(this.f191i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.c != z) {
            this.c = z;
            f189k.m(this.f191i);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.c.a.a);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f189k.o(this.f191i, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.g = rect;
        this.f190h = new Rect();
        a aVar = new a();
        this.f191i = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.c.e.a, i2, h.c.d.a);
        int i3 = h.c.e.d;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f188j);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(h.c.b.b);
            } else {
                color = getResources().getColor(h.c.b.a);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(h.c.e.e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(h.c.e.f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(h.c.e.g, 0.0f);
        this.c = typedArrayObtainStyledAttributes.getBoolean(h.c.e.f1265i, false);
        this.d = typedArrayObtainStyledAttributes.getBoolean(h.c.e.f1264h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.f1266j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.f1268l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.f1270n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.f1269m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.f1267k, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.b, 0);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.c.e.c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f189k.l(aVar, context, colorStateList, dimension, dimension2, f);
    }
}
