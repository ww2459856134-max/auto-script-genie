package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    private boolean c;
    private View d;
    private View e;
    private View f;
    Drawable g;

    /* renamed from: h, reason: collision with root package name */
    Drawable f99h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f100i;

    /* renamed from: j, reason: collision with root package name */
    boolean f101j;

    /* renamed from: k, reason: collision with root package name */
    boolean f102k;
    private int t;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.g;
        if (drawable != null && drawable.isStateful()) {
            this.g.setState(getDrawableState());
        }
        Drawable drawable2 = this.f99h;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f99h.setState(getDrawableState());
        }
        Drawable drawable3 = this.f100i;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f100i.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f99h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f100i;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.e = findViewById(h.a.f.a);
        this.f = findViewById(h.a.f.f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.c || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.d;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f101j) {
            Drawable drawable2 = this.f100i;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = z3;
            }
        } else {
            if (this.g != null) {
                if (this.e.getVisibility() == 0) {
                    this.g.setBounds(this.e.getLeft(), this.e.getTop(), this.e.getRight(), this.e.getBottom());
                } else {
                    View view2 = this.f;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.g.setBounds(0, 0, 0, 0);
                    } else {
                        this.g.setBounds(this.f.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
                    }
                }
                z3 = true;
            }
            this.f102k = z4;
            if (z4 && (drawable = this.f99h) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.e == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.t) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.e == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.d;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.e) ? a(this.e) : !b(this.f) ? a(this.f) : 0) + a(this.d), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.g);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.e;
            if (view != null) {
                this.g.setBounds(view.getLeft(), this.e.getTop(), this.e.getRight(), this.e.getBottom());
            }
        }
        boolean z = true;
        if (!this.f101j ? this.g != null || this.f99h != null : this.f100i != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f100i;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f100i);
        }
        this.f100i = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f101j && (drawable2 = this.f100i) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f101j ? !(this.g != null || this.f99h != null) : this.f100i == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f99h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f99h);
        }
        this.f99h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f102k && (drawable2 = this.f99h) != null) {
                drawable2.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
            }
        }
        boolean z = true;
        if (!this.f101j ? this.g != null || this.f99h != null : this.f100i != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.d;
        if (view != null) {
            removeView(view);
        }
        this.d = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.c = z;
        setDescendantFocusability(z ? 393216 : WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f99h;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f100i;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.g && !this.f101j) || (drawable == this.f99h && this.f102k) || ((drawable == this.f100i && this.f101j) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e.j.s0.a0(this, new c(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.a.j.a);
        this.g = typedArrayObtainStyledAttributes.getDrawable(h.a.j.b);
        this.f99h = typedArrayObtainStyledAttributes.getDrawable(h.a.j.d);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(h.a.j.f1227j, -1);
        boolean z = true;
        if (getId() == h.a.f.N) {
            this.f101j = true;
            this.f100i = typedArrayObtainStyledAttributes.getDrawable(h.a.j.c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f101j ? this.g != null || this.f99h != null : this.f100i != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
