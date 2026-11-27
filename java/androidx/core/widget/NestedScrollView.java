package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.recyclerview.widget.k0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.s0;
import h.e.j.u;
import h.e.j.v;
import h.e.j.x;
import h.e.j.z;
import java.util.ArrayList;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements x, u {
    private static final a b0 = new a();
    private static final int[] c0 = {R.attr.fillViewport};
    private VelocityTracker A;
    private boolean C;
    private boolean D;
    private int G;
    private int H;
    private int I;
    private int J;
    private final int[] K;
    private final int[] M;
    private int O;
    private int P;
    private c Q;
    private final z U;
    private final v V;
    private float W;
    private b a0;
    private long c;
    private final Rect d;
    private OverScroller e;
    private EdgeEffect f;
    private EdgeEffect g;

    /* renamed from: h, reason: collision with root package name */
    private int f212h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f213i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f214j;

    /* renamed from: k, reason: collision with root package name */
    private View f215k;
    private boolean t;

    static class a extends h.e.j.b {
        a() {
        }

        @Override // h.e.j.b
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            h.e.j.q1.g.a(accessibilityEvent, nestedScrollView.getScrollX());
            h.e.j.q1.g.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // h.e.j.b
        public void g(View view, h.e.j.q1.e eVar) {
            int scrollRange;
            super.g(view, eVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            eVar.U(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            eVar.i0(true);
            if (nestedScrollView.getScrollY() > 0) {
                eVar.b(h.e.j.q1.c.g);
                eVar.b(h.e.j.q1.c.f1316h);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                eVar.b(h.e.j.q1.c.f);
                eVar.b(h.e.j.q1.c.f1317i);
            }
        }

        @Override // h.e.j.b
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.O(0, iMax, true);
                    return true;
                }
                if (i2 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.O(0, iMin, true);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new j();
        public int c;

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.c + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
        }

        c(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt();
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i2, int i3) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        return this.d.bottom + i2 >= getScrollY() && this.d.top - i2 <= getScrollY() + i3;
    }

    private void C(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.V.e(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.J) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f212h = (int) motionEvent.getY(i2);
            this.J = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.A;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.A;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.A = null;
        }
    }

    private void H(boolean z) {
        if (z) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.P = getScrollY();
        s0.T(this);
    }

    private boolean I(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z = false;
        boolean z2 = i2 == 33;
        View viewR = r(z2, i3, i4);
        if (viewR == null) {
            viewR = this;
        }
        if (i3 < scrollY || i4 > i5) {
            n(z2 ? i3 - scrollY : i4 - i5);
            z = true;
        }
        if (viewR != findFocus()) {
            viewR.requestFocus(i2);
        }
        return z;
    }

    private void J(View view) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        int iE = e(this.d);
        if (iE != 0) {
            scrollBy(0, iE);
        }
    }

    private boolean K(Rect rect, boolean z) {
        int iE = e(rect);
        boolean z2 = iE != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iE);
            } else {
                L(0, iE);
            }
        }
        return z2;
    }

    private void M(int i2, int i3, int i4, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.c > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.e.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY, i4);
            H(z);
        } else {
            if (!this.e.isFinished()) {
                a();
            }
            scrollBy(i2, i3);
        }
        this.c = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.e.abortAnimation();
        Q(1);
    }

    private boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int d(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.W == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.W = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.W;
    }

    private void n(int i2) {
        if (i2 != 0) {
            if (this.D) {
                L(0, i2);
            } else {
                scrollBy(0, i2);
            }
        }
    }

    private void o() {
        this.t = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.f;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.g.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.f = null;
            this.g = null;
        } else if (this.f == null) {
            Context context = getContext();
            this.f = new EdgeEffect(context);
            this.g = new EdgeEffect(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View r(boolean z, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z3 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                    }
                }
            }
        }
        return view;
    }

    private boolean v(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.A;
        if (velocityTracker == null) {
            this.A = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.G = viewConfiguration.getScaledTouchSlop();
        this.H = viewConfiguration.getScaledMinimumFlingVelocity();
        this.I = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.A == null) {
            this.A = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    boolean E(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i10 = i4 + i2;
        int i11 = !z6 ? 0 : i8;
        int i12 = i5 + i3;
        int i13 = !z7 ? 0 : i9;
        int i14 = -i11;
        int i15 = i11 + i6;
        int i16 = -i13;
        int i17 = i13 + i7;
        if (i10 > i15) {
            i10 = i15;
            z2 = true;
        } else if (i10 < i14) {
            z2 = true;
            i10 = i14;
        } else {
            z2 = false;
        }
        if (i12 > i17) {
            i12 = i17;
            z3 = true;
        } else if (i12 < i16) {
            z3 = true;
            i12 = i16;
        } else {
            z3 = false;
        }
        if (z3 && !u(1)) {
            this.e.springBack(i10, i12, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i10, i12, z2, z3);
        return z2 || z3;
    }

    public boolean F(int i2) {
        boolean z = i2 == 130;
        int height = getHeight();
        if (z) {
            this.d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.d;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.d.top = getScrollY() - height;
            Rect rect2 = this.d;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.d;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return I(i2, i3, i4);
    }

    public final void L(int i2, int i3) {
        M(i2, i3, k0.a.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    void N(int i2, int i3, int i4, boolean z) {
        M(i2 - getScrollX(), i3 - getScrollY(), i4, z);
    }

    void O(int i2, int i3, boolean z) {
        N(i2, i3, k0.a.DEFAULT_SWIPE_ANIMATION_DURATION, z);
    }

    public boolean P(int i2, int i3) {
        return this.V.p(i2, i3);
    }

    public void Q(int i2) {
        this.V.r(i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean b(int i2) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !B(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            n(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.d);
            n(e(this.d));
            viewFindNextFocus.requestFocus(i2);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !z(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.e.isFinished()) {
            return;
        }
        this.e.computeScrollOffset();
        int currY = this.e.getCurrY();
        int i2 = currY - this.P;
        this.P = currY;
        int[] iArr = this.M;
        boolean z = false;
        iArr[1] = 0;
        i(0, i2, iArr, null, 1);
        int i3 = i2 - this.M[1];
        int scrollRange = getScrollRange();
        if (i3 != 0) {
            int scrollY = getScrollY();
            E(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i4 = i3 - scrollY2;
            int[] iArr2 = this.M;
            iArr2[1] = 0;
            k(0, scrollY2, 0, i4, this.K, 1, iArr2);
            i3 = i4 - this.M[1];
        }
        if (i3 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                p();
                if (i3 < 0) {
                    if (this.f.isFinished()) {
                        this.f.onAbsorb((int) this.e.getCurrVelocity());
                    }
                } else if (this.g.isFinished()) {
                    this.g.onAbsorb((int) this.e.getCurrVelocity());
                }
            }
            a();
        }
        if (this.e.isFinished()) {
            Q(1);
        } else {
            s0.T(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.V.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.V.b(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return i(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.V.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (i2 >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f.setSize(width, height);
                if (this.f.draw(canvas)) {
                    s0.T(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.g.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (i3 >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.g.setSize(width2, height2);
            if (this.g.draw(canvas)) {
                s0.T(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    protected int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i3) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        }
        if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // h.e.j.w
    public void f(View view, View view2, int i2, int i3) {
        this.U.c(view, view2, i2, i3);
        P(2, i3);
    }

    @Override // h.e.j.w
    public void g(View view, int i2) {
        this.U.e(view, i2);
        Q(i2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.U.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // h.e.j.w
    public void h(View view, int i2, int i3, int i4, int i5, int i6) {
        C(i5, i6, null);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    public boolean i(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.V.d(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View, h.e.j.u
    public boolean isNestedScrollingEnabled() {
        return this.V.l();
    }

    @Override // h.e.j.w
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        i(i2, i3, iArr, null, i4);
    }

    public void k(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.V.e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // h.e.j.x
    public void l(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        C(i5, i6, iArr);
    }

    @Override // h.e.j.w
    public boolean m(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i2, int i3) {
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f214j = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.t) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i2 = scrollY - verticalScrollFactorCompat;
                if (i2 < 0) {
                    scrollRange = 0;
                } else if (i2 <= scrollRange) {
                    scrollRange = i2;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.t) {
            return true;
        }
        int i2 = action & 255;
        if (i2 == 0) {
            int y = (int) motionEvent.getY();
            if (v((int) motionEvent.getX(), y)) {
                this.f212h = y;
                this.J = motionEvent.getPointerId(0);
                w();
                this.A.addMovement(motionEvent);
                this.e.computeScrollOffset();
                this.t = !this.e.isFinished();
                P(2, 0);
            } else {
                this.t = false;
                G();
            }
        } else if (i2 == 1) {
            this.t = false;
            this.J = -1;
            G();
            if (this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                s0.T(this);
            }
            Q(0);
        } else if (i2 == 2) {
            int i3 = this.J;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.f212h) > this.G && (2 & getNestedScrollAxes()) == 0) {
                        this.t = true;
                        this.f212h = y2;
                        y();
                        this.A.addMovement(motionEvent);
                        this.O = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i2 != 3) {
            if (i2 == 6) {
                D(motionEvent);
            }
        }
        return this.t;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int measuredHeight = 0;
        this.f213i = false;
        View view = this.f215k;
        if (view != null && A(view, this)) {
            J(this.f215k);
        }
        this.f215k = null;
        if (!this.f214j) {
            if (this.Q != null) {
                scrollTo(getScrollX(), this.Q.c);
                this.Q = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iD = d(scrollY, paddingTop, measuredHeight);
            if (iD != scrollY) {
                scrollTo(getScrollX(), iD);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f214j = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.C && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, WXVideoFileObject.FILE_SIZE_LIMIT));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        s((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        C(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        f(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.scrollTo(i2, i3);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        if (viewFindNextFocus == null || z(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.Q = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.c = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.a0;
        if (bVar != null) {
            bVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !B(viewFindFocus, 0, i5)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(viewFindFocus, this.d);
        n(e(this.d));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return m(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onStopNestedScroll(View view) {
        g(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        y();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.O = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.O);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.A;
                velocityTracker.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.I);
                int yVelocity = (int) velocityTracker.getYVelocity(this.J);
                if (Math.abs(yVelocity) >= this.H) {
                    int i2 = -yVelocity;
                    float f = i2;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        s(i2);
                    }
                } else if (this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    s0.T(this);
                }
                this.J = -1;
                o();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.J);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.J + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i3 = this.f212h - y;
                    if (!this.t && Math.abs(i3) > this.G) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.t = true;
                        i3 = i3 > 0 ? i3 - this.G : i3 + this.G;
                    }
                    int i4 = i3;
                    if (this.t) {
                        if (i(0, i4, this.M, this.K, 0)) {
                            i4 -= this.M[1];
                            this.O += this.K[1];
                        }
                        int i5 = i4;
                        this.f212h = y - this.K[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (E(0, i5, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !u(0)) {
                            this.A.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.M;
                        iArr[1] = 0;
                        k(0, scrollY2, 0, i5 - scrollY2, this.K, 0, iArr);
                        int i6 = this.f212h;
                        int[] iArr2 = this.K;
                        this.f212h = i6 - iArr2[1];
                        this.O += iArr2[1];
                        if (z) {
                            int i7 = i5 - this.M[1];
                            p();
                            int i8 = scrollY + i7;
                            if (i8 < 0) {
                                f.a(this.f, i7 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.g.isFinished()) {
                                    this.g.onRelease();
                                }
                            } else if (i8 > scrollRange) {
                                f.a(this.g, i7 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f.isFinished()) {
                                    this.f.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.g.isFinished())) {
                                s0.T(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.t && getChildCount() > 0 && this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    s0.T(this);
                }
                this.J = -1;
                o();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f212h = (int) motionEvent.getY(actionIndex);
                this.J = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                D(motionEvent);
                this.f212h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.J));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.e.isFinished();
            this.t = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.e.isFinished()) {
                a();
            }
            this.f212h = (int) motionEvent.getY();
            this.J = motionEvent.getPointerId(0);
            P(2, 0);
        }
        VelocityTracker velocityTracker2 = this.A;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public boolean q(KeyEvent keyEvent) {
        this.d.setEmpty();
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? b(33) : t(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : t(130);
        }
        if (keyCode != 62) {
            return false;
        }
        F(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f213i) {
            this.f215k = view2;
        } else {
            J(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f213i = true;
        super.requestLayout();
    }

    public void s(int i2) {
        if (getChildCount() > 0) {
            this.e.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iD = d(i2, width, width2);
            int iD2 = d(i3, height, height2);
            if (iD == getScrollX() && iD2 == getScrollY()) {
                return;
            }
            super.scrollTo(iD, iD2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.C) {
            this.C = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.V.m(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.a0 = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.D = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return P(i2, 0);
    }

    @Override // android.view.View, h.e.j.u
    public void stopNestedScroll() {
        Q(0);
    }

    public boolean t(int i2) {
        int childCount;
        boolean z = i2 == 130;
        int height = getHeight();
        Rect rect = this.d;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.d.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.d;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.d;
        return I(i2, rect3.top, rect3.bottom);
    }

    public boolean u(int i2) {
        return this.V.k(i2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = new Rect();
        this.f213i = true;
        this.f214j = false;
        this.f215k = null;
        this.t = false;
        this.D = true;
        this.J = -1;
        this.K = new int[2];
        this.M = new int[2];
        x();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0, i2, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.U = new z(this);
        this.V = new v(this);
        setNestedScrollingEnabled(true);
        s0.Z(this, b0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
