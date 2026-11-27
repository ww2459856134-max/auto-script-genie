package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: classes.dex */
public class ActionBarContextView extends b {
    private View A;
    private View C;
    private View D;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private int J;
    private int K;
    private boolean M;
    private int O;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f103k;
    private CharSequence t;

    class a implements View.OnClickListener {
        final /* synthetic */ h.a.o.c c;

        a(ActionBarContextView actionBarContextView, h.a.o.c cVar) {
            this.c = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.c.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.G == null) {
            LayoutInflater.from(getContext()).inflate(h.a.g.a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.G = linearLayout;
            this.H = (TextView) linearLayout.findViewById(h.a.f.e);
            this.I = (TextView) this.G.findViewById(h.a.f.d);
            if (this.J != 0) {
                this.H.setTextAppearance(getContext(), this.J);
            }
            if (this.K != 0) {
                this.I.setTextAppearance(getContext(), this.K);
            }
        }
        this.H.setText(this.f103k);
        this.I.setText(this.t);
        boolean z = !TextUtils.isEmpty(this.f103k);
        boolean z2 = !TextUtils.isEmpty(this.t);
        int i2 = 0;
        this.I.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.G;
        if (!z && !z2) {
            i2 = 8;
        }
        linearLayout2.setVisibility(i2);
        if (this.G.getParent() == null) {
            addView(this.G);
        }
    }

    public void g() {
        if (this.A == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.b
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.b
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.t;
    }

    public CharSequence getTitle() {
        return this.f103k;
    }

    public void h(h.a.o.c cVar) {
        View view = this.A;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.O, (ViewGroup) this, false);
            this.A = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.A);
        }
        View viewFindViewById = this.A.findViewById(h.a.f.f1202i);
        this.C = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(this, cVar));
        androidx.appcompat.view.menu.m mVar = (androidx.appcompat.view.menu.m) cVar.e();
        k kVar = this.f;
        if (kVar != null) {
            kVar.z();
        }
        k kVar2 = new k(getContext());
        this.f = kVar2;
        kVar2.K(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        mVar.c(this.f, this.d);
        ActionMenuView actionMenuView = (ActionMenuView) this.f.p(this);
        this.e = actionMenuView;
        h.e.j.s0.a0(actionMenuView, null);
        addView(this.e, layoutParams);
    }

    public boolean j() {
        return this.M;
    }

    public void k() {
        removeAllViews();
        this.D = null;
        this.e = null;
        this.f = null;
        View view = this.C;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        k kVar = this.f;
        if (kVar != null) {
            return kVar.L();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f;
        if (kVar != null) {
            kVar.C();
            this.f.D();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f103k);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean zB = e2.b(this);
        int paddingRight = zB ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.A;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            int i6 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = b.d(paddingRight, i6, zB);
            paddingRight = b.d(iD + e(this.A, iD, paddingTop, paddingTop2, zB), i7, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.G;
        if (linearLayout != null && this.D == null && linearLayout.getVisibility() != 8) {
            iE += e(this.G, iE, paddingTop, paddingTop2, zB);
        }
        int i8 = iE;
        View view2 = this.D;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.e;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int i4 = WXVideoFileObject.FILE_SIZE_LIMIT;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.g;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.A;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.e;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.e, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.G;
        if (linearLayout != null && this.D == null) {
            if (this.M) {
                this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.G.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.G.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.D;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            if (i7 == -2) {
                i4 = Integer.MIN_VALUE;
            }
            if (i7 >= 0) {
                iMin = Math.min(i7, iMin);
            }
            this.D.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.g > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.b
    public void setContentHeight(int i2) {
        this.g = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.D;
        if (view2 != null) {
            removeView(view2);
        }
        this.D = view;
        if (view != null && (linearLayout = this.G) != null) {
            removeView(linearLayout);
            this.G = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.t = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f103k = charSequence;
        i();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.M) {
            requestLayout();
        }
        this.M = z;
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.f1179k);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        t1 t1VarU = t1.u(context, attributeSet, h.a.j.x, i2, 0);
        h.e.j.s0.a0(this, t1VarU.f(h.a.j.y));
        this.J = t1VarU.m(h.a.j.C, 0);
        this.K = t1VarU.m(h.a.j.B, 0);
        this.g = t1VarU.l(h.a.j.A, 0);
        this.O = t1VarU.m(h.a.j.z, h.a.g.d);
        t1VarU.v();
    }
}
