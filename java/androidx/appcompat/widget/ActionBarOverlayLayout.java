package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.z;
import h.e.j.e1;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements k0, h.e.j.y, h.e.j.w, h.e.j.x {
    static final int[] g0 = {h.a.a.b, R.attr.windowContentOverlay};
    boolean A;
    private int C;
    private int D;
    private final Rect G;
    private final Rect H;
    private final Rect I;
    private final Rect J;
    private final Rect K;
    private final Rect M;
    private final Rect O;
    private h.e.j.e1 P;
    private h.e.j.e1 Q;
    private h.e.j.e1 U;
    private h.e.j.e1 V;
    private d W;
    private OverScroller a0;
    ViewPropertyAnimator b0;
    private int c;
    final AnimatorListenerAdapter c0;
    private int d;
    private final Runnable d0;
    private ContentFrameLayout e;
    private final Runnable e0;
    ActionBarContainer f;
    private final h.e.j.z f0;
    private l0 g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f104h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f105i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f106j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f107k;
    private boolean t;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b0 = null;
            actionBarOverlayLayout.A = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b0 = null;
            actionBarOverlayLayout.A = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b0 = actionBarOverlayLayout.f.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.c0);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.b0 = actionBarOverlayLayout.f.animate().translationY(-ActionBarOverlayLayout.this.f.getHeight()).setListener(ActionBarOverlayLayout.this.c0);
        }
    }

    public interface d {
        void a();

        void b();

        void c();

        void d();

        void e(int i2);

        void f(boolean z);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void n() {
        s();
        this.e0.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean o(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        e eVar = (e) view.getLayoutParams();
        if (z) {
            int i2 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i3 = rect.left;
            if (i2 != i3) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i3;
                z5 = true;
            } else {
                z5 = false;
            }
        }
        if (z2) {
            int i4 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
            int i5 = rect.top;
            if (i4 != i5) {
                ((ViewGroup.MarginLayoutParams) eVar).topMargin = i5;
                z5 = true;
            }
        }
        if (z4) {
            int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
            int i7 = rect.right;
            if (i6 != i7) {
                ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i7;
                z5 = true;
            }
        }
        if (z3) {
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i9 = rect.bottom;
            if (i8 != i9) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i9;
                return true;
            }
        }
        return z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l0 r(View view) {
        if (view instanceof l0) {
            return (l0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void t(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(g0);
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f104h = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f105i = context.getApplicationInfo().targetSdkVersion < 19;
        this.a0 = new OverScroller(context);
    }

    private void v() {
        s();
        postDelayed(this.e0, 600L);
    }

    private void w() {
        s();
        postDelayed(this.d0, 600L);
    }

    private void y() {
        s();
        this.d0.run();
    }

    private boolean z(float f) {
        this.a0.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.a0.getFinalY() > this.f.getHeight();
    }

    @Override // androidx.appcompat.widget.k0
    public boolean a() {
        x();
        return this.g.a();
    }

    @Override // androidx.appcompat.widget.k0
    public boolean b() {
        x();
        return this.g.b();
    }

    @Override // androidx.appcompat.widget.k0
    public boolean c() {
        x();
        return this.g.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.k0
    public boolean d() {
        x();
        return this.g.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f104h == null || this.f105i) {
            return;
        }
        int bottom = this.f.getVisibility() == 0 ? (int) (this.f.getBottom() + this.f.getTranslationY() + 0.5f) : 0;
        this.f104h.setBounds(0, bottom, getWidth(), this.f104h.getIntrinsicHeight() + bottom);
        this.f104h.draw(canvas);
    }

    @Override // androidx.appcompat.widget.k0
    public boolean e() {
        x();
        return this.g.e();
    }

    @Override // h.e.j.w
    public void f(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        x();
        boolean zO = o(this.f, rect, true, true, false, true);
        this.J.set(rect);
        e2.a(this, this.J, this.G);
        if (!this.K.equals(this.J)) {
            this.K.set(this.J);
            zO = true;
        }
        if (!this.H.equals(this.G)) {
            this.H.set(this.G);
            zO = true;
        }
        if (zO) {
            requestLayout();
        }
        return true;
    }

    @Override // h.e.j.w
    public void g(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f0.a();
    }

    public CharSequence getTitle() {
        x();
        return this.g.getTitle();
    }

    @Override // h.e.j.w
    public void h(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void i(int i2) {
        x();
        if (i2 == 2) {
            this.g.i();
        } else if (i2 == 5) {
            this.g.n();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // h.e.j.w
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void k() {
        x();
        this.g.k();
    }

    @Override // h.e.j.x
    public void l(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        h(view, i2, i3, i4, i5, i6);
    }

    @Override // h.e.j.w
    public boolean m(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        x();
        h.e.j.e1 e1VarS = h.e.j.e1.s(windowInsets, this);
        boolean zO = o(this.f, new Rect(e1VarS.f(), e1VarS.h(), e1VarS.g(), e1VarS.e()), true, true, false, true);
        h.e.j.s0.e(this, e1VarS, this.G);
        Rect rect = this.G;
        h.e.j.e1 e1VarI = e1VarS.i(rect.left, rect.top, rect.right, rect.bottom);
        this.P = e1VarI;
        boolean z = true;
        if (!this.Q.equals(e1VarI)) {
            this.Q = this.P;
            zO = true;
        }
        if (this.H.equals(this.G)) {
            z = zO;
        } else {
            this.H.set(this.G);
        }
        if (z) {
            requestLayout();
        }
        return e1VarS.a().c().b().q();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t(getContext());
        h.e.j.s0.W(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        x();
        measureChildWithMargins(this.f, i2, 0, i3, 0);
        e eVar = (e) this.f.getLayoutParams();
        int iMax = Math.max(0, this.f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f.getMeasuredState());
        boolean z = (h.e.j.s0.F(this) & 256) != 0;
        if (z) {
            measuredHeight = this.c;
            if (this.f107k && this.f.getTabContainer() != null) {
                measuredHeight += this.c;
            }
        } else {
            measuredHeight = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        this.I.set(this.G);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            this.U = this.P;
        } else {
            this.M.set(this.J);
        }
        if (!this.f106j && !z) {
            Rect rect = this.I;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i4 >= 21) {
                this.U = this.U.i(0, measuredHeight, 0, 0);
            }
        } else if (i4 >= 21) {
            h.e.d.b bVarB = h.e.d.b.b(this.U.f(), this.U.h() + measuredHeight, this.U.g(), this.U.e() + 0);
            e1.a aVar = new e1.a(this.U);
            aVar.c(bVarB);
            this.U = aVar.a();
        } else {
            Rect rect2 = this.M;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        o(this.e, this.I, true, true, true, true);
        if (i4 >= 21 && !this.V.equals(this.U)) {
            h.e.j.e1 e1Var = this.U;
            this.V = e1Var;
            h.e.j.s0.f(this.e, e1Var);
        } else if (i4 < 21 && !this.O.equals(this.M)) {
            this.O.set(this.M);
            this.e.a(this.M);
        }
        measureChildWithMargins(this.e, i2, 0, i3, 0);
        e eVar2 = (e) this.e.getLayoutParams();
        int iMax3 = Math.max(iMax, this.e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.t || !z) {
            return false;
        }
        if (z(f2)) {
            n();
        } else {
            y();
        }
        this.A = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.C + i3;
        this.C = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f0.b(view, view2, i2);
        this.C = getActionBarHideOffset();
        s();
        d dVar = this.W;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onStopNestedScroll(View view) {
        if (this.t && !this.A) {
            if (this.C <= this.f.getHeight()) {
                w();
            } else {
                v();
            }
        }
        d dVar = this.W;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        x();
        int i3 = this.D ^ i2;
        this.D = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & 256) != 0;
        d dVar = this.W;
        if (dVar != null) {
            dVar.f(!z2);
            if (z || !z2) {
                this.W.a();
            } else {
                this.W.c();
            }
        }
        if ((i3 & 256) == 0 || this.W == null) {
            return;
        }
        h.e.j.s0.W(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.d = i2;
        d dVar = this.W;
        if (dVar != null) {
            dVar.e(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    void s() {
        removeCallbacks(this.d0);
        removeCallbacks(this.e0);
        ViewPropertyAnimator viewPropertyAnimator = this.b0;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void setActionBarHideOffset(int i2) {
        s();
        this.f.setTranslationY(-Math.max(0, Math.min(i2, this.f.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.W = dVar;
        if (getWindowToken() != null) {
            this.W.e(this.d);
            int i2 = this.D;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                h.e.j.s0.W(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f107k = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.t) {
            this.t = z;
            if (z) {
                return;
            }
            s();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        x();
        this.g.setIcon(i2);
    }

    public void setLogo(int i2) {
        x();
        this.g.t(i2);
    }

    @Override // androidx.appcompat.widget.k0
    public void setMenu(Menu menu, z.a aVar) {
        x();
        this.g.setMenu(menu, aVar);
    }

    @Override // androidx.appcompat.widget.k0
    public void setMenuPrepared() {
        x();
        this.g.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.f106j = z;
        this.f105i = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.k0
    public void setWindowCallback(Window.Callback callback) {
        x();
        this.g.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.k0
    public void setWindowTitle(CharSequence charSequence) {
        x();
        this.g.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean u() {
        return this.f106j;
    }

    void x() {
        if (this.e == null) {
            this.e = (ContentFrameLayout) findViewById(h.a.f.b);
            this.f = (ActionBarContainer) findViewById(h.a.f.c);
            this.g = r(findViewById(h.a.f.a));
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Rect();
        this.M = new Rect();
        this.O = new Rect();
        h.e.j.e1 e1Var = h.e.j.e1.b;
        this.P = e1Var;
        this.Q = e1Var;
        this.U = e1Var;
        this.V = e1Var;
        this.c0 = new a();
        this.d0 = new b();
        this.e0 = new c();
        t(context);
        this.f0 = new h.e.j.z(this);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        x();
        this.g.setIcon(drawable);
    }
}
