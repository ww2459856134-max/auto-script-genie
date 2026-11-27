package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.s0;
import h.e.j.u;
import h.e.j.v;
import h.e.j.y;
import h.e.j.z;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements y, u {
    private static final String p0 = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] q0 = {R.attr.enabled};
    private boolean A;
    private int C;
    int D;
    private float G;
    private float H;
    private boolean I;
    private int J;
    boolean K;
    private boolean M;
    private final DecelerateInterpolator O;
    androidx.swiperefreshlayout.widget.b P;
    private int Q;
    protected int U;
    float V;
    protected int W;
    int a0;
    int b0;
    private View c;
    androidx.swiperefreshlayout.widget.f c0;
    j d;
    private Animation d0;
    boolean e;
    private Animation e0;
    private int f;
    private Animation f0;
    private float g;
    private Animation g0;

    /* renamed from: h, reason: collision with root package name */
    private float f386h;
    private Animation h0;

    /* renamed from: i, reason: collision with root package name */
    private final z f387i;
    boolean i0;

    /* renamed from: j, reason: collision with root package name */
    private final v f388j;
    private int j0;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f389k;
    boolean k0;
    private i l0;
    private Animation.AnimationListener m0;
    private final Animation n0;
    private final Animation o0;
    private final int[] t;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.e) {
                swipeRefreshLayout.q();
                return;
            }
            swipeRefreshLayout.c0.setAlpha(255);
            SwipeRefreshLayout.this.c0.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.i0 && (jVar = swipeRefreshLayout2.d) != null) {
                jVar.h();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.D = swipeRefreshLayout3.P.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
        }
    }

    class d extends Animation {
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        d(int i2, int i3) {
            this.c = i2;
            this.d = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.c0.setAlpha((int) (this.c + ((this.d - r0) * f)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.K) {
                return;
            }
            swipeRefreshLayout.w(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.k0 ? swipeRefreshLayout.a0 - Math.abs(swipeRefreshLayout.W) : swipeRefreshLayout.a0;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.U + ((int) ((iAbs - r1) * f))) - swipeRefreshLayout2.P.getTop());
            SwipeRefreshLayout.this.c0.e(1.0f - f);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.o(f);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f2 = swipeRefreshLayout.V;
            swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
            SwipeRefreshLayout.this.o(f);
        }
    }

    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface j {
        void h();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.U = i2;
        this.n0.reset();
        this.n0.setDuration(200L);
        this.n0.setInterpolator(this.O);
        if (animationListener != null) {
            this.P.b(animationListener);
        }
        this.P.clearAnimation();
        this.P.startAnimation(this.n0);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.K) {
            x(i2, animationListener);
            return;
        }
        this.U = i2;
        this.o0.reset();
        this.o0.setDuration(200L);
        this.o0.setInterpolator(this.O);
        if (animationListener != null) {
            this.P.b(animationListener);
        }
        this.P.clearAnimation();
        this.P.startAnimation(this.o0);
    }

    private void d() {
        this.P = new androidx.swiperefreshlayout.widget.b(getContext(), -328966);
        androidx.swiperefreshlayout.widget.f fVar = new androidx.swiperefreshlayout.widget.f(getContext());
        this.c0 = fVar;
        fVar.l(1);
        this.P.setImageDrawable(this.c0);
        this.P.setVisibility(8);
        addView(this.P);
    }

    private void e() {
        if (this.c == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.P)) {
                    this.c = childAt;
                    return;
                }
            }
        }
    }

    private void i(float f2) {
        if (f2 > this.g) {
            r(true, true);
            return;
        }
        this.e = false;
        this.c0.j(0.0f, 0.0f);
        b(this.D, this.K ? null : new e());
        this.c0.d(false);
    }

    private boolean k(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void n(float f2) {
        this.c0.d(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.g));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.g;
        int i2 = this.b0;
        if (i2 <= 0) {
            i2 = this.k0 ? this.a0 - this.W : this.a0;
        }
        float f3 = i2;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i3 = this.W + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.P.getVisibility() != 0) {
            this.P.setVisibility(0);
        }
        if (!this.K) {
            this.P.setScaleX(1.0f);
            this.P.setScaleY(1.0f);
        }
        if (this.K) {
            setAnimationProgress(Math.min(1.0f, f2 / this.g));
        }
        if (f2 < this.g) {
            if (this.c0.getAlpha() > 76 && !k(this.f0)) {
                v();
            }
        } else if (this.c0.getAlpha() < 255 && !k(this.g0)) {
            u();
        }
        this.c0.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.c0.e(Math.min(1.0f, fMax));
        this.c0.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.D);
    }

    private void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.J) {
            this.J = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void r(boolean z, boolean z2) {
        if (this.e != z) {
            this.i0 = z2;
            e();
            this.e = z;
            if (z) {
                a(this.D, this.m0);
            } else {
                w(this.m0);
            }
        }
    }

    private Animation s(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.P.b(null);
        this.P.clearAnimation();
        this.P.startAnimation(dVar);
        return dVar;
    }

    private void setColorViewAlpha(int i2) {
        this.P.getBackground().setAlpha(i2);
        this.c0.setAlpha(i2);
    }

    private void t(float f2) {
        float f3 = this.H;
        float f4 = f2 - f3;
        int i2 = this.f;
        if (f4 <= i2 || this.I) {
            return;
        }
        this.G = f3 + i2;
        this.I = true;
        this.c0.setAlpha(76);
    }

    private void u() {
        this.g0 = s(this.c0.getAlpha(), 255);
    }

    private void v() {
        this.f0 = s(this.c0.getAlpha(), 76);
    }

    private void x(int i2, Animation.AnimationListener animationListener) {
        this.U = i2;
        this.V = this.P.getScaleX();
        h hVar = new h();
        this.h0 = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.P.b(animationListener);
        }
        this.P.clearAnimation();
        this.P.startAnimation(this.h0);
    }

    private void y(Animation.AnimationListener animationListener) {
        this.P.setVisibility(0);
        this.c0.setAlpha(255);
        b bVar = new b();
        this.d0 = bVar;
        bVar.setDuration(this.C);
        if (animationListener != null) {
            this.P.b(animationListener);
        }
        this.P.clearAnimation();
        this.P.startAnimation(this.d0);
    }

    public boolean c() {
        i iVar = this.l0;
        if (iVar != null) {
            return iVar.a(this, this.c);
        }
        View view = this.c;
        return view instanceof ListView ? androidx.core.widget.i.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f388j.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f388j.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f388j.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f388j.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.Q;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f387i.a();
    }

    public int getProgressCircleDiameter() {
        return this.j0;
    }

    public int getProgressViewEndOffset() {
        return this.a0;
    }

    public int getProgressViewStartOffset() {
        return this.W;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f388j.j();
    }

    @Override // android.view.View, h.e.j.u
    public boolean isNestedScrollingEnabled() {
        return this.f388j.l();
    }

    void o(float f2) {
        setTargetOffsetTopAndBottom((this.U + ((int) ((this.W - r0) * f2))) - this.P.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.M && actionMasked == 0) {
            this.M = false;
        }
        if (!isEnabled() || this.M || c() || this.e || this.A) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.W - this.P.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.J = pointerId;
            this.I = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.H = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.I = false;
            this.J = -1;
        } else if (actionMasked == 2) {
            int i2 = this.J;
            if (i2 == -1) {
                Log.e(p0, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i2);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            t(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                p(motionEvent);
            }
        }
        return this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.c == null) {
            e();
        }
        View view = this.c;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.P.getMeasuredWidth();
        int measuredHeight2 = this.P.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.D;
        this.P.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.c == null) {
            e();
        }
        View view = this.c;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), WXVideoFileObject.FILE_SIZE_LIMIT));
        this.P.measure(View.MeasureSpec.makeMeasureSpec(this.j0, WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(this.j0, WXVideoFileObject.FILE_SIZE_LIMIT));
        this.Q = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.P) {
                this.Q = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f386h;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f386h = 0.0f;
                } else {
                    this.f386h = f2 - f3;
                    iArr[1] = i3;
                }
                n(this.f386h);
            }
        }
        if (this.k0 && i3 > 0 && this.f386h == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.P.setVisibility(8);
        }
        int[] iArr2 = this.f389k;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.t);
        if (i5 + this.t[1] >= 0 || c()) {
            return;
        }
        float fAbs = this.f386h + Math.abs(r11);
        this.f386h = fAbs;
        n(fAbs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f387i.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f386h = 0.0f;
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.M || this.e || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, h.e.j.y
    public void onStopNestedScroll(View view) {
        this.f387i.d(view);
        this.A = false;
        float f2 = this.f386h;
        if (f2 > 0.0f) {
            i(f2);
            this.f386h = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.M && actionMasked == 0) {
            this.M = false;
        }
        if (!isEnabled() || this.M || c() || this.e || this.A) {
            return false;
        }
        if (actionMasked == 0) {
            this.J = motionEvent.getPointerId(0);
            this.I = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.J);
                if (iFindPointerIndex < 0) {
                    Log.e(p0, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.I) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.G) * 0.5f;
                    this.I = false;
                    i(y);
                }
                this.J = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.J);
                if (iFindPointerIndex2 < 0) {
                    Log.e(p0, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                t(y2);
                if (this.I) {
                    float f2 = (y2 - this.G) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    n(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(p0, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.J = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    p(motionEvent);
                }
            }
        }
        return true;
    }

    void q() {
        this.P.clearAnimation();
        this.c0.stop();
        this.P.setVisibility(8);
        setColorViewAlpha(255);
        if (this.K) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.W - this.D);
        }
        this.D = this.P.getTop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.c instanceof AbsListView)) {
            View view = this.c;
            if (view == null || s0.L(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void setAnimationProgress(float f2) {
        this.P.setScaleX(f2);
        this.P.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.c0.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.a.c(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.g = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        q();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f388j.m(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.l0 = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.d = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.P.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.c(getContext(), i2));
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        this.a0 = i2;
        this.K = z;
        this.P.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        this.K = z;
        this.W = i2;
        this.a0 = i3;
        this.k0 = true;
        q();
        this.e = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.e == z) {
            r(z, false);
            return;
        }
        this.e = z;
        setTargetOffsetTopAndBottom((!this.k0 ? this.a0 + this.W : this.a0) - this.D);
        this.i0 = false;
        y(this.m0);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.j0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.j0 = (int) (displayMetrics.density * 40.0f);
            }
            this.P.setImageDrawable(null);
            this.c0.l(i2);
            this.P.setImageDrawable(this.c0);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.b0 = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.P.bringToFront();
        s0.P(this.P, i2);
        this.D = this.P.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.f388j.o(i2);
    }

    @Override // android.view.View, h.e.j.u
    public void stopNestedScroll() {
        this.f388j.q();
    }

    void w(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.e0 = cVar;
        cVar.setDuration(150L);
        this.P.b(animationListener);
        this.P.clearAnimation();
        this.P.startAnimation(this.e0);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.g = -1.0f;
        this.f389k = new int[2];
        this.t = new int[2];
        this.J = -1;
        this.Q = -1;
        this.m0 = new a();
        this.n0 = new f();
        this.o0 = new g();
        this.f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.C = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.O = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.j0 = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.a0 = i2;
        this.g = i2;
        this.f387i = new z(this);
        this.f388j = new v(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.j0;
        this.D = i3;
        this.W = i3;
        o(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q0);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }
}
