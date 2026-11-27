package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private Drawable A;
    private int C;
    private int D;
    private int G;
    private int H;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f120h;

    /* renamed from: i, reason: collision with root package name */
    private float f121i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f122j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f123k;
    private int[] t;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void i(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), WXVideoFileObject.FILE_SIZE_LIMIT);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewQ = q(i4);
            if (viewQ.getVisibility() != 8) {
                a aVar = (a) viewQ.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewQ.getMeasuredWidth();
                    measureChildWithMargins(viewQ, i3, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void j(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewQ = q(i4);
            if (viewQ.getVisibility() != 8) {
                a aVar = (a) viewQ.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewQ.getMeasuredHeight();
                    measureChildWithMargins(viewQ, iMakeMeasureSpec, 0, i3, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i5;
                }
            }
        }
    }

    private void y(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void e(Canvas canvas) {
        int right;
        int left;
        int i2;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = e2.b(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewQ = q(i3);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i3)) {
                a aVar = (a) viewQ.getLayoutParams();
                h(canvas, zB ? viewQ.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewQ.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.C);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            if (viewQ2 != null) {
                a aVar2 = (a) viewQ2.getLayoutParams();
                if (zB) {
                    left = viewQ2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i2 = this.C;
                    right = left - i2;
                } else {
                    right = viewQ2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.C;
                right = left - i2;
            }
            h(canvas, right);
        }
    }

    void f(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewQ = q(i2);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i2)) {
                g(canvas, (viewQ.getTop() - ((LinearLayout.LayoutParams) ((a) viewQ.getLayoutParams())).topMargin) - this.D);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            g(canvas, viewQ2 == null ? (getHeight() - getPaddingBottom()) - this.D : viewQ2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewQ2.getLayoutParams())).bottomMargin);
        }
    }

    void g(Canvas canvas, int i2) {
        this.A.setBounds(getPaddingLeft() + this.H, i2, (getWidth() - getPaddingRight()) - this.H, this.D + i2);
        this.A.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.d < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.d;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.d == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.e;
        if (this.f == 1 && (i2 = this.g & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f120h) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f120h;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.d;
    }

    public Drawable getDividerDrawable() {
        return this.A;
    }

    public int getDividerPadding() {
        return this.H;
    }

    public int getDividerWidth() {
        return this.C;
    }

    public int getGravity() {
        return this.g;
    }

    public int getOrientation() {
        return this.f;
    }

    public int getShowDividers() {
        return this.G;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f121i;
    }

    void h(Canvas canvas, int i2) {
        this.A.setBounds(i2, getPaddingTop() + this.H, this.C + i2, (getHeight() - getPaddingBottom()) - this.H);
        this.A.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    int n(View view, int i2) {
        return 0;
    }

    int o(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.A == null) {
            return;
        }
        if (this.f == 1) {
            f(canvas);
        } else {
            e(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f == 1) {
            t(i2, i3, i4, i5);
        } else {
            s(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f == 1) {
            x(i2, i3);
        } else {
            v(i2, i3);
        }
    }

    int p(View view) {
        return 0;
    }

    View q(int i2) {
        return getChildAt(i2);
    }

    protected boolean r(int i2) {
        if (i2 == 0) {
            return (this.G & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.G & 4) != 0;
        }
        if ((this.G & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void s(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        int measuredHeight;
        boolean zB = e2.b(this);
        int paddingTop = getPaddingTop();
        int i13 = i5 - i3;
        int paddingBottom = i13 - getPaddingBottom();
        int paddingBottom2 = (i13 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i14 = this.g;
        int i15 = i14 & 112;
        boolean z2 = this.c;
        int[] iArr = this.f123k;
        int[] iArr2 = this.t;
        int iA = h.e.j.n.a(8388615 & i14, h.e.j.s0.w(this));
        boolean z3 = true;
        int paddingLeft = iA != 1 ? iA != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f120h : getPaddingLeft() + (((i4 - i2) - this.f120h) / 2);
        if (zB) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int iN = 0;
        while (iN < virtualChildCount) {
            int i16 = i6 + (i7 * iN);
            View viewQ = q(i16);
            if (viewQ == null) {
                paddingLeft += w(i16);
                z = z3;
                i8 = paddingTop;
                i9 = virtualChildCount;
                i10 = i15;
            } else if (viewQ.getVisibility() != 8) {
                int measuredWidth = viewQ.getMeasuredWidth();
                int measuredHeight2 = viewQ.getMeasuredHeight();
                a aVar = (a) viewQ.getLayoutParams();
                int i17 = iN;
                if (z2) {
                    i9 = virtualChildCount;
                    int baseline = ((LinearLayout.LayoutParams) aVar).height != -1 ? viewQ.getBaseline() : -1;
                    i11 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i11 < 0) {
                        i11 = i15;
                    }
                    i12 = i11 & 112;
                    i10 = i15;
                    if (i12 == 16) {
                        if (i12 == 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                z = true;
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i12 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewQ.getMeasuredHeight() - baseline);
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    }
                    if (r(i16)) {
                        paddingLeft += this.C;
                    }
                    int i18 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    i8 = paddingTop;
                    y(viewQ, i18 + o(viewQ), measuredHeight, measuredWidth, measuredHeight2);
                    int iP = i18 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + p(viewQ);
                    iN = i17 + n(viewQ, i16);
                    paddingLeft = iP;
                    iN++;
                    virtualChildCount = i9;
                    i15 = i10;
                    z3 = z;
                    paddingTop = i8;
                } else {
                    i9 = virtualChildCount;
                }
                i11 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i11 < 0) {
                }
                i12 = i11 & 112;
                i10 = i15;
                if (i12 == 16) {
                }
                if (r(i16)) {
                }
                int i182 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                i8 = paddingTop;
                y(viewQ, i182 + o(viewQ), measuredHeight, measuredWidth, measuredHeight2);
                int iP2 = i182 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + p(viewQ);
                iN = i17 + n(viewQ, i16);
                paddingLeft = iP2;
                iN++;
                virtualChildCount = i9;
                i15 = i10;
                z3 = z;
                paddingTop = i8;
            } else {
                i8 = paddingTop;
                i9 = virtualChildCount;
                i10 = i15;
                z = true;
            }
            iN++;
            virtualChildCount = i9;
            i15 = i10;
            z3 = z;
            paddingTop = i8;
        }
    }

    public void setBaselineAligned(boolean z) {
        this.c = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.A) {
            return;
        }
        this.A = drawable;
        if (drawable != null) {
            this.C = drawable.getIntrinsicWidth();
            this.D = drawable.getIntrinsicHeight();
        } else {
            this.C = 0;
            this.D = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.H = i2;
    }

    public void setGravity(int i2) {
        if (this.g != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.g = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.g;
        if ((8388615 & i4) != i3) {
            this.g = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f122j = z;
    }

    public void setOrientation(int i2) {
        if (this.f != i2) {
            this.f = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.G) {
            requestLayout();
        }
        this.G = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.g;
        if ((i4 & 112) != i3) {
            this.g = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f121i = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void t(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int paddingLeft = getPaddingLeft();
        int i10 = i4 - i2;
        int paddingRight = i10 - getPaddingRight();
        int paddingRight2 = (i10 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i11 = this.g;
        int i12 = i11 & 112;
        int i13 = i11 & 8388615;
        int paddingTop = i12 != 16 ? i12 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f120h : getPaddingTop() + (((i5 - i3) - this.f120h) / 2);
        int iN = 0;
        while (iN < virtualChildCount) {
            View viewQ = q(iN);
            if (viewQ == null) {
                paddingTop += w(iN);
            } else {
                if (viewQ.getVisibility() != 8) {
                    int measuredWidth = viewQ.getMeasuredWidth();
                    int measuredHeight = viewQ.getMeasuredHeight();
                    a aVar = (a) viewQ.getLayoutParams();
                    int i14 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i14 < 0) {
                        i14 = i13;
                    }
                    int iA = h.e.j.n.a(i14, h.e.j.s0.w(this)) & 7;
                    if (iA == 1) {
                        i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                        i7 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else if (iA != 5) {
                        i8 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        int i15 = i8;
                        if (r(iN)) {
                            paddingTop += this.D;
                        }
                        int i16 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        y(viewQ, i15, i16 + o(viewQ), measuredWidth, measuredHeight);
                        int iP = i16 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + p(viewQ);
                        iN += n(viewQ, iN);
                        paddingTop = iP;
                        i9 = 1;
                    } else {
                        i6 = paddingRight - measuredWidth;
                        i7 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    i8 = i6 - i7;
                    int i152 = i8;
                    if (r(iN)) {
                    }
                    int i162 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    y(viewQ, i152, i162 + o(viewQ), measuredWidth, measuredHeight);
                    int iP2 = i162 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + p(viewQ);
                    iN += n(viewQ, iN);
                    paddingTop = iP2;
                    i9 = 1;
                }
                iN += i9;
            }
            i9 = 1;
            iN += i9;
        }
    }

    void u(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void v(int i2, int i3) {
        int[] iArr;
        int i4;
        int iMax;
        int i5;
        int i6;
        int iMax2;
        int iMax3;
        int i7;
        int i8;
        float f;
        int i9;
        int baseline;
        int i10;
        int i11;
        int i12;
        char c;
        int i13;
        int i14;
        boolean z;
        boolean z2;
        View view;
        int i15;
        boolean z3;
        int measuredHeight;
        int iN;
        int baseline2;
        int i16;
        this.f120h = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.f123k == null || this.t == null) {
            this.f123k = new int[4];
            this.t = new int[4];
        }
        int[] iArr2 = this.f123k;
        int[] iArr3 = this.t;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.c;
        boolean z5 = this.f122j;
        int i17 = WXVideoFileObject.FILE_SIZE_LIMIT;
        boolean z6 = mode == 1073741824;
        int iN2 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        int iMax7 = 0;
        boolean z7 = false;
        int iCombineMeasuredStates = 0;
        boolean z8 = false;
        boolean z9 = true;
        float f2 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iN2 >= virtualChildCount) {
                break;
            }
            View viewQ = q(iN2);
            if (viewQ == null) {
                this.f120h += w(iN2);
            } else if (viewQ.getVisibility() == 8) {
                iN2 += n(viewQ, iN2);
            } else {
                if (r(iN2)) {
                    this.f120h += this.C;
                }
                a aVar = (a) viewQ.getLayoutParams();
                float f3 = ((LinearLayout.LayoutParams) aVar).weight;
                float f4 = f2 + f3;
                if (mode == i17 && ((LinearLayout.LayoutParams) aVar).width == 0 && f3 > 0.0f) {
                    if (z6) {
                        this.f120h += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else {
                        int i18 = this.f120h;
                        this.f120h = Math.max(i18, ((LinearLayout.LayoutParams) aVar).leftMargin + i18 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                    }
                    if (z4) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        viewQ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i14 = iN2;
                        z = z5;
                        z2 = z4;
                        view = viewQ;
                    } else {
                        i14 = iN2;
                        z = z5;
                        z2 = z4;
                        view = viewQ;
                        z7 = true;
                        i15 = WXVideoFileObject.FILE_SIZE_LIMIT;
                        if (mode2 == i15 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z3 = true;
                            z8 = true;
                        } else {
                            z3 = false;
                        }
                        int i19 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i19;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            i16 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i16 < 0) {
                                i16 = this.g;
                            }
                            int i20 = (((i16 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i20] = Math.max(iArr2[i20], baseline2);
                            iArr[i20] = Math.max(iArr[i20], measuredHeight - baseline2);
                        }
                        iMax5 = Math.max(iMax5, measuredHeight);
                        z9 = !z9 && ((LinearLayout.LayoutParams) aVar).height == -1;
                        if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                            if (!z3) {
                                i19 = measuredHeight;
                            }
                            iMax7 = Math.max(iMax7, i19);
                        } else {
                            int i21 = iMax7;
                            if (!z3) {
                                i19 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i19);
                            iMax7 = i21;
                        }
                        int i22 = i14;
                        iN = n(view, i22) + i22;
                        f2 = f4;
                        int i23 = iN + 1;
                        iArr3 = iArr;
                        z5 = z;
                        z4 = z2;
                        i17 = i15;
                        iN2 = i23;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) aVar).width != 0 || f3 <= 0.0f) {
                        c = 65534;
                        i13 = Integer.MIN_VALUE;
                    } else {
                        c = 65534;
                        ((LinearLayout.LayoutParams) aVar).width = -2;
                        i13 = 0;
                    }
                    i14 = iN2;
                    int i24 = i13;
                    z = z5;
                    z2 = z4;
                    u(viewQ, i14, i2, f4 == 0.0f ? this.f120h : 0, i3, 0);
                    if (i24 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) aVar).width = i24;
                    }
                    int measuredWidth = viewQ.getMeasuredWidth();
                    if (z6) {
                        view = viewQ;
                        this.f120h += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + p(view);
                    } else {
                        view = viewQ;
                        int i25 = this.f120h;
                        this.f120h = Math.max(i25, i25 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + p(view));
                    }
                    if (z) {
                        iMax4 = Math.max(measuredWidth, iMax4);
                    }
                }
                i15 = WXVideoFileObject.FILE_SIZE_LIMIT;
                if (mode2 == i15) {
                    z3 = false;
                    int i192 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i192;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z2) {
                        i16 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i16 < 0) {
                        }
                        int i202 = (((i16 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i202] = Math.max(iArr2[i202], baseline2);
                        iArr[i202] = Math.max(iArr[i202], measuredHeight - baseline2);
                    }
                    iMax5 = Math.max(iMax5, measuredHeight);
                    if (z9) {
                        if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                        }
                        int i222 = i14;
                        iN = n(view, i222) + i222;
                        f2 = f4;
                    }
                }
                int i232 = iN + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i17 = i15;
                iN2 = i232;
            }
            z = z5;
            z2 = z4;
            int i26 = i17;
            iN = iN2;
            i15 = i26;
            int i2322 = iN + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i17 = i15;
            iN2 = i2322;
        }
        boolean z10 = z5;
        boolean z11 = z4;
        int i27 = iMax5;
        int i28 = iMax6;
        int i29 = iMax7;
        int i30 = iCombineMeasuredStates;
        if (this.f120h > 0 && r(virtualChildCount)) {
            this.f120h += this.C;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            iMax = i27;
            i4 = i30;
        } else {
            i4 = i30;
            iMax = Math.max(i27, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f120h = 0;
            int iN3 = 0;
            while (iN3 < virtualChildCount) {
                View viewQ2 = q(iN3);
                if (viewQ2 == null) {
                    this.f120h += w(iN3);
                } else if (viewQ2.getVisibility() == 8) {
                    iN3 += n(viewQ2, iN3);
                } else {
                    a aVar2 = (a) viewQ2.getLayoutParams();
                    if (z6) {
                        this.f120h += ((LinearLayout.LayoutParams) aVar2).leftMargin + iMax4 + ((LinearLayout.LayoutParams) aVar2).rightMargin + p(viewQ2);
                    } else {
                        int i31 = this.f120h;
                        i12 = iMax;
                        this.f120h = Math.max(i31, i31 + iMax4 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + p(viewQ2));
                        iN3++;
                        iMax = i12;
                    }
                }
                i12 = iMax;
                iN3++;
                iMax = i12;
            }
        }
        int i32 = iMax;
        int paddingLeft = this.f120h + getPaddingLeft() + getPaddingRight();
        this.f120h = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, 0);
        int i33 = (16777215 & iResolveSizeAndState) - this.f120h;
        if (z7 || (i33 != 0 && f2 > 0.0f)) {
            float f5 = this.f121i;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f120h = 0;
            int i34 = i28;
            int iMax8 = -1;
            int iCombineMeasuredStates2 = i4;
            int i35 = 0;
            while (i35 < virtualChildCount) {
                View viewQ3 = q(i35);
                if (viewQ3 == null || viewQ3.getVisibility() == 8) {
                    i7 = i33;
                    i8 = virtualChildCount;
                } else {
                    a aVar3 = (a) viewQ3.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f6 > 0.0f) {
                        int i36 = (int) ((i33 * f6) / f2);
                        float f7 = f2 - f6;
                        int i37 = i33 - i36;
                        i8 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i11 = WXVideoFileObject.FILE_SIZE_LIMIT;
                            if (mode == 1073741824) {
                                if (i36 <= 0) {
                                    i36 = 0;
                                }
                                viewQ3.measure(View.MeasureSpec.makeMeasureSpec(i36, WXVideoFileObject.FILE_SIZE_LIMIT), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewQ3.getMeasuredState() & (-16777216));
                            f2 = f7;
                            i7 = i37;
                        } else {
                            i11 = WXVideoFileObject.FILE_SIZE_LIMIT;
                        }
                        int measuredWidth2 = viewQ3.getMeasuredWidth() + i36;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewQ3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i11), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewQ3.getMeasuredState() & (-16777216));
                        f2 = f7;
                        i7 = i37;
                    } else {
                        i7 = i33;
                        i8 = virtualChildCount;
                    }
                    if (z6) {
                        this.f120h += viewQ3.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + p(viewQ3);
                        f = f2;
                    } else {
                        int i38 = this.f120h;
                        f = f2;
                        this.f120h = Math.max(i38, viewQ3.getMeasuredWidth() + i38 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + p(viewQ3));
                    }
                    boolean z12 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i39 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewQ3.getMeasuredHeight() + i39;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z12) {
                        i39 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i34, i39);
                    if (z9) {
                        i9 = -1;
                        boolean z13 = ((LinearLayout.LayoutParams) aVar3).height == -1;
                        if (z11 && (baseline = viewQ3.getBaseline()) != i9) {
                            i10 = ((LinearLayout.LayoutParams) aVar3).gravity;
                            if (i10 < 0) {
                                i10 = this.g;
                            }
                            int i40 = (((i10 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i40] = Math.max(iArr2[i40], baseline);
                            iArr[i40] = Math.max(iArr[i40], measuredHeight2 - baseline);
                        }
                        z9 = z13;
                        i34 = iMax9;
                        f2 = f;
                    } else {
                        i9 = -1;
                    }
                    if (z11) {
                        i10 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i10 < 0) {
                        }
                        int i402 = (((i10 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i402] = Math.max(iArr2[i402], baseline);
                        iArr[i402] = Math.max(iArr[i402], measuredHeight2 - baseline);
                    }
                    z9 = z13;
                    i34 = iMax9;
                    f2 = f;
                }
                i35++;
                i33 = i7;
                virtualChildCount = i8;
            }
            i5 = i3;
            i6 = virtualChildCount;
            this.f120h += getPaddingLeft() + getPaddingRight();
            iMax2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax3 = i34;
            i4 = iCombineMeasuredStates2;
        } else {
            iMax3 = Math.max(i28, i29);
            if (z10 && mode != 1073741824) {
                for (int i41 = 0; i41 < virtualChildCount; i41++) {
                    View viewQ4 = q(i41);
                    if (viewQ4 != null && viewQ4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewQ4.getLayoutParams())).weight > 0.0f) {
                        viewQ4.measure(View.MeasureSpec.makeMeasureSpec(iMax4, WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(viewQ4.getMeasuredHeight(), WXVideoFileObject.FILE_SIZE_LIMIT));
                    }
                }
            }
            i5 = i3;
            i6 = virtualChildCount;
            iMax2 = i32;
        }
        if (z9 || mode2 == 1073741824) {
            iMax3 = iMax2;
        }
        setMeasuredDimension(iResolveSizeAndState | (i4 & (-16777216)), View.resolveSizeAndState(Math.max(iMax3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i4 << 16));
        if (z8) {
            i(i6, i2);
        }
    }

    int w(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0333  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x(int i2, int i3) {
        int i4;
        int iCombineMeasuredStates;
        int i5;
        int iMax;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        View view;
        int iMax2;
        boolean z2;
        int iMax3;
        this.f120h = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i18 = this.d;
        boolean z3 = this.f122j;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int iMax4 = 0;
        int i22 = 0;
        int iN = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f = 0.0f;
        boolean z6 = true;
        while (true) {
            int i23 = 8;
            int i24 = iMax4;
            if (iN >= virtualChildCount) {
                int i25 = i19;
                int i26 = i21;
                int i27 = i22;
                int i28 = virtualChildCount;
                int i29 = mode2;
                int iMax5 = i20;
                if (this.f120h > 0) {
                    i4 = i28;
                    if (r(i4)) {
                        this.f120h += this.D;
                    }
                } else {
                    i4 = i28;
                }
                if (z3 && (i29 == Integer.MIN_VALUE || i29 == 0)) {
                    this.f120h = 0;
                    int iN2 = 0;
                    while (iN2 < i4) {
                        View viewQ = q(iN2);
                        if (viewQ == null) {
                            this.f120h += w(iN2);
                        } else if (viewQ.getVisibility() == i23) {
                            iN2 += n(viewQ, iN2);
                        } else {
                            a aVar = (a) viewQ.getLayoutParams();
                            int i30 = this.f120h;
                            this.f120h = Math.max(i30, i30 + i26 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + p(viewQ));
                        }
                        iN2++;
                        i23 = 8;
                    }
                }
                int paddingTop = this.f120h + getPaddingTop() + getPaddingBottom();
                this.f120h = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, 0);
                int i31 = (16777215 & iResolveSizeAndState) - this.f120h;
                if (z4 || (i31 != 0 && f > 0.0f)) {
                    float f2 = this.f121i;
                    if (f2 > 0.0f) {
                        f = f2;
                    }
                    this.f120h = 0;
                    int i32 = i31;
                    int i33 = i27;
                    iCombineMeasuredStates = i25;
                    int i34 = 0;
                    while (i34 < i4) {
                        View viewQ2 = q(i34);
                        if (viewQ2.getVisibility() == 8) {
                            i6 = i32;
                        } else {
                            a aVar2 = (a) viewQ2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) aVar2).weight;
                            if (f3 > 0.0f) {
                                int i35 = (int) ((i32 * f3) / f);
                                float f4 = f - f3;
                                i6 = i32 - i35;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin, ((LinearLayout.LayoutParams) aVar2).width);
                                if (((LinearLayout.LayoutParams) aVar2).height == 0) {
                                    i9 = WXVideoFileObject.FILE_SIZE_LIMIT;
                                    if (i29 == 1073741824) {
                                        if (i35 <= 0) {
                                            i35 = 0;
                                        }
                                        viewQ2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i35, WXVideoFileObject.FILE_SIZE_LIMIT));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewQ2.getMeasuredState() & (-256));
                                    f = f4;
                                } else {
                                    i9 = WXVideoFileObject.FILE_SIZE_LIMIT;
                                }
                                int measuredHeight = viewQ2.getMeasuredHeight() + i35;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewQ2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i9));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewQ2.getMeasuredState() & (-256));
                                f = f4;
                            } else {
                                i6 = i32;
                            }
                            int i36 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewQ2.getMeasuredWidth() + i36;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f5 = f;
                            if (mode != 1073741824) {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                                z = ((LinearLayout.LayoutParams) aVar2).width == -1;
                                if (!z) {
                                    i36 = measuredWidth;
                                }
                                int iMax6 = Math.max(i33, i36);
                                boolean z7 = !z6 && ((LinearLayout.LayoutParams) aVar2).width == i8;
                                int i37 = this.f120h;
                                this.f120h = Math.max(i37, viewQ2.getMeasuredHeight() + i37 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + p(viewQ2));
                                z6 = z7;
                                iCombineMeasuredStates = i7;
                                i33 = iMax6;
                                f = f5;
                            } else {
                                i7 = iCombineMeasuredStates;
                                i8 = -1;
                            }
                            if (!z) {
                            }
                            int iMax62 = Math.max(i33, i36);
                            if (z6) {
                                int i372 = this.f120h;
                                this.f120h = Math.max(i372, viewQ2.getMeasuredHeight() + i372 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + p(viewQ2));
                                z6 = z7;
                                iCombineMeasuredStates = i7;
                                i33 = iMax62;
                                f = f5;
                            }
                        }
                        i34++;
                        i32 = i6;
                    }
                    i5 = i2;
                    this.f120h += getPaddingTop() + getPaddingBottom();
                    iMax = i33;
                } else {
                    iMax = Math.max(i27, i24);
                    if (z3 && i29 != 1073741824) {
                        for (int i38 = 0; i38 < i4; i38++) {
                            View viewQ3 = q(i38);
                            if (viewQ3 != null && viewQ3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewQ3.getLayoutParams())).weight > 0.0f) {
                                viewQ3.measure(View.MeasureSpec.makeMeasureSpec(viewQ3.getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(i26, WXVideoFileObject.FILE_SIZE_LIMIT));
                            }
                        }
                    }
                    i5 = i2;
                    iCombineMeasuredStates = i25;
                }
                if (z6 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, iCombineMeasuredStates), iResolveSizeAndState);
                if (z5) {
                    j(i4, i3);
                    return;
                }
                return;
            }
            View viewQ4 = q(iN);
            if (viewQ4 == null) {
                this.f120h += w(iN);
                i13 = virtualChildCount;
                i14 = mode2;
                iMax4 = i24;
            } else {
                int i39 = i19;
                if (viewQ4.getVisibility() == 8) {
                    iN += n(viewQ4, iN);
                    i13 = virtualChildCount;
                    iMax4 = i24;
                    i19 = i39;
                    i14 = mode2;
                } else {
                    if (r(iN)) {
                        this.f120h += this.D;
                    }
                    a aVar3 = (a) viewQ4.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) aVar3).weight;
                    float f7 = f + f6;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f6 > 0.0f) {
                        int i40 = this.f120h;
                        this.f120h = Math.max(i40, ((LinearLayout.LayoutParams) aVar3).topMargin + i40 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        iMax2 = i21;
                        view = viewQ4;
                        i16 = i22;
                        z4 = true;
                        i11 = i39;
                        i12 = i20;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        i15 = i24;
                        i17 = iN;
                    } else {
                        int i41 = i20;
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f6 <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = -2;
                            i10 = 0;
                        }
                        i11 = i39;
                        int i42 = i10;
                        i12 = i41;
                        int i43 = i21;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        i15 = i24;
                        i16 = i22;
                        i17 = iN;
                        u(viewQ4, iN, i2, 0, i3, f7 == 0.0f ? this.f120h : 0);
                        if (i42 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar3).height = i42;
                        }
                        int measuredHeight2 = viewQ4.getMeasuredHeight();
                        int i44 = this.f120h;
                        view = viewQ4;
                        this.f120h = Math.max(i44, i44 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + p(view));
                        iMax2 = z3 ? Math.max(measuredHeight2, i43) : i43;
                    }
                    if (i18 >= 0 && i18 == i17 + 1) {
                        this.e = this.f120h;
                    }
                    if (i17 < i18 && ((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar3).width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z5 = true;
                    }
                    int i45 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i45;
                    int iMax7 = Math.max(i12, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    z6 = z6 && ((LinearLayout.LayoutParams) aVar3).width == -1;
                    if (((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        if (!z2) {
                            i45 = measuredWidth2;
                        }
                        iMax4 = Math.max(i15, i45);
                        iMax3 = i16;
                    } else {
                        if (!z2) {
                            i45 = measuredWidth2;
                        }
                        iMax3 = Math.max(i16, i45);
                        iMax4 = i15;
                    }
                    int iN3 = n(view, i17) + i17;
                    i21 = iMax2;
                    f = f7;
                    i22 = iMax3;
                    i19 = iCombineMeasuredStates2;
                    iN = iN3;
                    i20 = iMax7;
                }
            }
            iN++;
            mode2 = i14;
            virtualChildCount = i13;
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = true;
        this.d = -1;
        this.e = 0;
        this.g = 8388659;
        int[] iArr = h.a.j.T0;
        t1 t1VarU = t1.u(context, attributeSet, iArr, i2, 0);
        h.e.j.s0.X(this, context, iArr, attributeSet, t1VarU.q(), i2, 0);
        int iJ = t1VarU.j(h.a.j.V0, -1);
        if (iJ >= 0) {
            setOrientation(iJ);
        }
        int iJ2 = t1VarU.j(h.a.j.U0, -1);
        if (iJ2 >= 0) {
            setGravity(iJ2);
        }
        boolean zA = t1VarU.a(h.a.j.W0, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f121i = t1VarU.h(h.a.j.Y0, -1.0f);
        this.d = t1VarU.j(h.a.j.X0, -1);
        this.f122j = t1VarU.a(h.a.j.b1, false);
        setDividerDrawable(t1VarU.f(h.a.j.Z0));
        this.G = t1VarU.j(h.a.j.c1, 0);
        this.H = t1VarU.e(h.a.j.a1, 0);
        t1VarU.v();
    }
}
