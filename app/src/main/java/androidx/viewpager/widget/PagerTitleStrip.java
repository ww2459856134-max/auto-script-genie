package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.m;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.e
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {
    private static final int[] H = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    private static final int[] I = {R.attr.textAllCaps};
    private final a A;
    private WeakReference<androidx.viewpager.widget.a> C;
    private int D;
    int G;
    ViewPager c;
    TextView d;
    TextView e;
    TextView f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    float f406h;

    /* renamed from: i, reason: collision with root package name */
    private int f407i;

    /* renamed from: j, reason: collision with root package name */
    private int f408j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f409k;
    private boolean t;

    private class a extends DataSetObserver implements ViewPager.j, ViewPager.i {
        private int c;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i2, float f, int i3) {
            if (f > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.c(i2, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i2) {
            this.c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void d(int i2) {
            if (this.c == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.c.getCurrentItem(), PagerTitleStrip.this.c.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f = pagerTitleStrip2.f406h;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.c.getCurrentItem(), f, true);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.c.getCurrentItem(), PagerTitleStrip.this.c.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f = pagerTitleStrip2.f406h;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.c.getCurrentItem(), f, true);
        }
    }

    private static class b extends SingleLineTransformationMethod {
        private Locale c;

        b(Context context) {
            this.c = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.c);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    void a(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.s(this.A);
            this.C = null;
        }
        if (aVar2 != null) {
            aVar2.k(this.A);
            this.C = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            this.g = -1;
            this.f406h = -1.0f;
            b(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    void b(int i2, androidx.viewpager.widget.a aVar) {
        int iD = aVar != null ? aVar.d() : 0;
        this.f409k = true;
        CharSequence charSequenceF = null;
        this.d.setText((i2 < 1 || aVar == null) ? null : aVar.f(i2 - 1));
        this.e.setText((aVar == null || i2 >= iD) ? null : aVar.f(i2));
        int i3 = i2 + 1;
        if (i3 < iD && aVar != null) {
            charSequenceF = aVar.f(i3);
        }
        this.f.setText(charSequenceF);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.e.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.g = i2;
        if (!this.t) {
            c(i2, this.f406h, false);
        }
        this.f409k = false;
    }

    void c(int i2, float f, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.g) {
            b(i2, this.c.getAdapter());
        } else if (!z && f == this.f406h) {
            return;
        }
        this.t = true;
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredWidth3 = this.f.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (i9 * f2))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.d.getBaseline();
        int baseline2 = this.e.getBaseline();
        int baseline3 = this.f.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = iMax - baseline;
        int i13 = iMax - baseline2;
        int i14 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.d.getMeasuredHeight() + i12, this.e.getMeasuredHeight() + i13), this.f.getMeasuredHeight() + i14);
        int i15 = this.f408j & 112;
        if (i15 == 16) {
            i3 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = i13 + paddingTop;
                i6 = paddingTop + i14;
                TextView textView = this.e;
                textView.layout(i10, i5, i11, textView.getMeasuredHeight() + i5);
                int iMin = Math.min(paddingLeft, (i10 - this.f407i) - measuredWidth);
                TextView textView2 = this.d;
                textView2.layout(iMin, i4, measuredWidth + iMin, textView2.getMeasuredHeight() + i4);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f407i);
                TextView textView3 = this.f;
                textView3.layout(iMax3, i6, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.f406h = f;
                this.t = false;
            }
            i3 = (height - paddingBottom) - iMax2;
        }
        i4 = i12 + i3;
        i5 = i13 + i3;
        i6 = i3 + i14;
        TextView textView4 = this.e;
        textView4.layout(i10, i5, i11, textView4.getMeasuredHeight() + i5);
        int iMin2 = Math.min(paddingLeft, (i10 - this.f407i) - measuredWidth);
        TextView textView22 = this.d;
        textView22.layout(iMin2, i4, measuredWidth + iMin2, textView22.getMeasuredHeight() + i4);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.f407i);
        TextView textView32 = this.f;
        textView32.layout(iMax32, i6, iMax32 + measuredWidth3, textView32.getMeasuredHeight() + i6);
        this.f406h = f;
        this.t = false;
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f407i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        viewPager.N(this.A);
        viewPager.b(this.A);
        this.c = viewPager;
        WeakReference<androidx.viewpager.widget.a> weakReference = this.C;
        a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.c.N(null);
            this.c.H(this.A);
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.c != null) {
            float f = this.f406h;
            if (f < 0.0f) {
                f = 0.0f;
            }
            c(this.g, f, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMax;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
        this.d.measure(childMeasureSpec2, childMeasureSpec);
        this.e.measure(childMeasureSpec2, childMeasureSpec);
        this.f.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i3);
        } else {
            iMax = Math.max(getMinHeight(), this.e.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i3, this.e.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f409k) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.f408j = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int i2 = ((int) (f * 255.0f)) & 255;
        this.D = i2;
        int i3 = (i2 << 24) | (this.G & 16777215);
        this.d.setTextColor(i3);
        this.f.setTextColor(i3);
    }

    public void setTextColor(int i2) {
        this.G = i2;
        this.e.setTextColor(i2);
        int i3 = (this.D << 24) | (this.G & 16777215);
        this.d.setTextColor(i3);
        this.f.setTextColor(i3);
    }

    public void setTextSize(int i2, float f) {
        this.d.setTextSize(i2, f);
        this.e.setTextSize(i2, f);
        this.f.setTextSize(i2, f);
    }

    public void setTextSpacing(int i2) {
        this.f407i = i2;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.g = -1;
        this.f406h = -1.0f;
        this.A = new a();
        TextView textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H);
        boolean z = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            m.l(this.d, resourceId);
            m.l(this.e, resourceId);
            m.l(this.f, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.d.setTextColor(color);
            this.e.setTextColor(color);
            this.f.setTextColor(color);
        }
        this.f408j = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.G = this.e.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, I);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.d);
            setSingleLineAllCaps(this.e);
            setSingleLineAllCaps(this.f);
        } else {
            this.d.setSingleLine();
            this.e.setSingleLine();
            this.f.setSingleLine();
        }
        this.f407i = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
