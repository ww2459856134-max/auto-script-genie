package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    private ArrayList<View> c;
    private ArrayList<View> d;
    private View.OnApplyWindowInsetsListener e;
    private boolean f;

    public FragmentContainerView(Context context) {
        super(context);
        this.f = true;
    }

    private void a(View view) {
        ArrayList<View> arrayList = this.d;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (p1.z0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (p1.z0(view) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        h.e.j.e1 e1VarR = h.e.j.e1.r(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.e;
        h.e.j.e1 e1VarR2 = onApplyWindowInsetsListener != null ? h.e.j.e1.r(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : h.e.j.s0.Q(this, e1VarR);
        if (!e1VarR2.k()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                h.e.j.s0.f(getChildAt(i2), e1VarR2);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f && this.c != null) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                super.drawChild(canvas, this.c.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f || (arrayList = this.c) == null || arrayList.size() <= 0 || !this.c.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.d;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.c;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    void setDrawDisappearingViewsLast(boolean z) {
        this.f = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) {
            throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        }
        super.setLayoutTransition(layoutTransition);
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.e = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i2) {
        String str;
        super(context, attributeSet, i2);
        this.f = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.j.c.e);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(h.j.c.f);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, p1 p1Var) {
        String str;
        super(context, attributeSet);
        this.f = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.j.c.e);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(h.j.c.f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(h.j.c.g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentH0 = p1Var.h0(id);
        if (classAttribute != null && fragmentH0 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = p1Var.q0().a(context.getClassLoader(), classAttribute);
            fragmentA.H0(context, attributeSet, null);
            f2 f2VarL = p1Var.l();
            f2VarL.q(true);
            f2VarL.c(this, fragmentA, string);
            f2VarL.j();
        }
        p1Var.S0(this);
    }
}
