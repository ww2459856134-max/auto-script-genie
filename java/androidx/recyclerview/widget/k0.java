package androidx.recyclerview.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public class k0 extends RecyclerView.n implements RecyclerView.q {
    private l0 A;
    private Rect C;
    private long D;
    float d;
    float e;
    private float f;
    private float g;

    /* renamed from: h, reason: collision with root package name */
    float f354h;

    /* renamed from: i, reason: collision with root package name */
    float f355i;

    /* renamed from: j, reason: collision with root package name */
    private float f356j;

    /* renamed from: k, reason: collision with root package name */
    private float f357k;

    /* renamed from: m, reason: collision with root package name */
    a f359m;

    /* renamed from: o, reason: collision with root package name */
    int f361o;
    private int q;
    RecyclerView r;
    VelocityTracker t;
    private List<RecyclerView.d0> u;
    private List<Integer> v;
    h.e.j.m z;
    final List<View> a = new ArrayList();
    private final float[] b = new float[2];
    RecyclerView.d0 c = null;

    /* renamed from: l, reason: collision with root package name */
    int f358l = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f360n = 0;
    List<n0> p = new ArrayList();
    final Runnable s = new d0(this);
    private RecyclerView.j w = null;
    View x = null;
    int y = -1;
    private final RecyclerView.s B = new e0(this);

    public static abstract class a {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new i0();
        private static final Interpolator sDragViewScrollCapInterpolator = new j0();
        private int mCachedMaxScrollSpeed = -1;

        public static int a(int i2, int i3) {
            int i4;
            int i5 = i2 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= (-789517) & i7;
                i4 = (i7 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i6 | i4;
        }

        private int b(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(h.n.b.d);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int c(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int d(int i2, int i3) {
            return c(2, i2) | c(1, i3) | c(0, i3 | i2);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return true;
        }

        public RecyclerView.d0 chooseDropTarget(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i2, int i3) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = i2 + d0Var.itemView.getWidth();
            int height = i3 + d0Var.itemView.getHeight();
            int left2 = i2 - d0Var.itemView.getLeft();
            int top2 = i3 - d0Var.itemView.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.d0 d0Var3 = list.get(i5);
                if (left2 > 0 && (right = d0Var3.itemView.getRight() - width) < 0 && d0Var3.itemView.getRight() > d0Var.itemView.getRight() && (iAbs4 = Math.abs(right)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = iAbs4;
                }
                if (left2 < 0 && (left = d0Var3.itemView.getLeft() - i2) > 0 && d0Var3.itemView.getLeft() < d0Var.itemView.getLeft() && (iAbs3 = Math.abs(left)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = iAbs3;
                }
                if (top2 < 0 && (top = d0Var3.itemView.getTop() - i3) > 0 && d0Var3.itemView.getTop() < d0Var.itemView.getTop() && (iAbs2 = Math.abs(top)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = iAbs2;
                }
                if (top2 > 0 && (bottom = d0Var3.itemView.getBottom() - height) < 0 && d0Var3.itemView.getBottom() > d0Var.itemView.getBottom() && (iAbs = Math.abs(bottom)) > i4) {
                    d0Var2 = d0Var3;
                    i4 = iAbs;
                }
            }
            return d0Var2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            p0.a.c(d0Var.itemView);
        }

        public int convertToAbsoluteDirection(int i2, int i3) {
            int i4;
            int i5 = i2 & RELATIVE_DIR_FLAGS;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= (-3158065) & i7;
                i4 = (i7 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i6 | i4;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, d0Var), h.e.j.s0.w(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i2, float f, float f2) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200L : 250L : i2 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public abstract float getMoveThreshold(RecyclerView.d0 d0Var);

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public abstract float getSwipeThreshold(RecyclerView.d0 d0Var);

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (getAbsoluteMovementFlags(recyclerView, d0Var) & 16711680) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (getAbsoluteMovementFlags(recyclerView, d0Var) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            int iSignum = (int) (((int) (((int) Math.signum(i3)) * b(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i3) * 1.0f) / i2)))) * sDragScrollInterpolator.getInterpolation(j2 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j2 / 2000.0f : 1.0f));
            return iSignum == 0 ? i3 > 0 ? 1 : -1 : iSignum;
        }

        public abstract boolean isItemViewSwipeEnabled();

        public abstract boolean isLongPressDragEnabled();

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i2, boolean z) {
            p0.a.b(canvas, recyclerView, d0Var.itemView, f, f2, i2, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f, float f2, int i2, boolean z) {
            p0.a.d(canvas, recyclerView, d0Var.itemView, f, f2, i2, z);
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<n0> list, int i2, float f, float f2) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                n0 n0Var = list.get(i3);
                n0Var.e();
                int iSave = canvas.save();
                onChildDraw(canvas, recyclerView, n0Var.e, n0Var.f363i, n0Var.f364j, n0Var.f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, d0Var, f, f2, i2, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<n0> list, int i2, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                n0 n0Var = list.get(i3);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, n0Var.e, n0Var.f363i, n0Var.f364j, n0Var.f, false);
                canvas.restoreToCount(iSave);
            }
            if (d0Var != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, d0Var, f, f2, i2, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                n0 n0Var2 = list.get(i4);
                boolean z2 = n0Var2.f366l;
                if (z2 && !n0Var2.f362h) {
                    list.remove(i4);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3, int i4, int i5) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof b) {
                ((b) layoutManager).a(d0Var.itemView, d0Var2.itemView, i4, i5);
                return;
            }
            if (layoutManager.k()) {
                if (layoutManager.Q(d0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.j1(i3);
                }
                if (layoutManager.T(d0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.j1(i3);
                }
            }
            if (layoutManager.l()) {
                if (layoutManager.U(d0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.j1(i3);
                }
                if (layoutManager.O(d0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.j1(i3);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.d0 d0Var, int i2) {
            if (d0Var != null) {
                p0.a.a(d0Var.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.d0 d0Var, int i2);
    }

    public interface b {
        void a(View view, View view2, int i2, int i3);
    }

    public k0(a aVar) {
        this.f359m = aVar;
    }

    private void D() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.g(this);
        this.r.j(this.B);
        this.r.i(this);
        F();
    }

    private void F() {
        this.A = new l0(this);
        this.z = new h.e.j.m(this.r.getContext(), this.A);
    }

    private void G() {
        l0 l0Var = this.A;
        if (l0Var != null) {
            l0Var.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    private int H(RecyclerView.d0 d0Var) {
        if (this.f360n == 2) {
            return 0;
        }
        int movementFlags = this.f359m.getMovementFlags(this.r, d0Var);
        int iConvertToAbsoluteDirection = (this.f359m.convertToAbsoluteDirection(movementFlags, h.e.j.s0.w(this.r)) & 65280) >> 8;
        if (iConvertToAbsoluteDirection == 0) {
            return 0;
        }
        int i2 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f354h) > Math.abs(this.f355i)) {
            int iK = k(d0Var, iConvertToAbsoluteDirection);
            if (iK > 0) {
                return (i2 & iK) == 0 ? a.a(iK, h.e.j.s0.w(this.r)) : iK;
            }
            int iM = m(d0Var, iConvertToAbsoluteDirection);
            if (iM > 0) {
                return iM;
            }
        } else {
            int iM2 = m(d0Var, iConvertToAbsoluteDirection);
            if (iM2 > 0) {
                return iM2;
            }
            int iK2 = k(d0Var, iConvertToAbsoluteDirection);
            if (iK2 > 0) {
                return (i2 & iK2) == 0 ? a.a(iK2, h.e.j.s0.w(this.r)) : iK2;
            }
        }
        return 0;
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.w == null) {
            this.w = new h0(this);
        }
        this.r.setChildDrawingOrderCallback(this.w);
    }

    private int k(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = this.f354h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f358l > -1) {
            velocityTracker.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.f359m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.f358l);
            float yVelocity = this.t.getYVelocity(this.f358l);
            int i4 = xVelocity <= 0.0f ? 4 : 8;
            float fAbs = Math.abs(xVelocity);
            if ((i4 & i2) != 0 && i3 == i4 && fAbs >= this.f359m.getSwipeEscapeVelocity(this.f) && fAbs > Math.abs(yVelocity)) {
                return i4;
            }
        }
        float width = this.r.getWidth() * this.f359m.getSwipeThreshold(d0Var);
        if ((i2 & i3) == 0 || Math.abs(this.f354h) <= width) {
            return 0;
        }
        return i3;
    }

    private int m(RecyclerView.d0 d0Var, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = this.f355i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.f358l > -1) {
            velocityTracker.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.f359m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.f358l);
            float yVelocity = this.t.getYVelocity(this.f358l);
            int i4 = yVelocity <= 0.0f ? 1 : 2;
            float fAbs = Math.abs(yVelocity);
            if ((i4 & i2) != 0 && i4 == i3 && fAbs >= this.f359m.getSwipeEscapeVelocity(this.f) && fAbs > Math.abs(xVelocity)) {
                return i4;
            }
        }
        float height = this.r.getHeight() * this.f359m.getSwipeThreshold(d0Var);
        if ((i2 & i3) == 0 || Math.abs(this.f355i) <= height) {
            return 0;
        }
        return i3;
    }

    private void n() {
        this.r.X0(this);
        this.r.Z0(this.B);
        this.r.Y0(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.f359m.clearView(this.r, this.p.get(0).e);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        z();
        G();
    }

    private List<RecyclerView.d0> r(RecyclerView.d0 d0Var) {
        RecyclerView.d0 d0Var2 = d0Var;
        List<RecyclerView.d0> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int boundingBoxMargin = this.f359m.getBoundingBoxMargin();
        int iRound = Math.round(this.f356j + this.f354h) - boundingBoxMargin;
        int iRound2 = Math.round(this.f357k + this.f355i) - boundingBoxMargin;
        int i2 = boundingBoxMargin * 2;
        int width = d0Var2.itemView.getWidth() + iRound + i2;
        int height = d0Var2.itemView.getHeight() + iRound2 + i2;
        int i3 = (iRound + width) / 2;
        int i4 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int iJ = layoutManager.J();
        int i5 = 0;
        while (i5 < iJ) {
            View viewI = layoutManager.I(i5);
            if (viewI != d0Var2.itemView && viewI.getBottom() >= iRound2 && viewI.getTop() <= height && viewI.getRight() >= iRound && viewI.getLeft() <= width) {
                RecyclerView.d0 d0VarG0 = this.r.g0(viewI);
                if (this.f359m.canDropOver(this.r, this.c, d0VarG0)) {
                    int iAbs = Math.abs(i3 - ((viewI.getLeft() + viewI.getRight()) / 2));
                    int iAbs2 = Math.abs(i4 - ((viewI.getTop() + viewI.getBottom()) / 2));
                    int i6 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.u.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > this.v.get(i8).intValue(); i8++) {
                        i7++;
                    }
                    this.u.add(i7, d0VarG0);
                    this.v.add(i7, Integer.valueOf(i6));
                }
            }
            i5++;
            d0Var2 = d0Var;
        }
        return this.u;
    }

    private RecyclerView.d0 s(MotionEvent motionEvent) {
        View viewQ;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int i2 = this.f358l;
        if (i2 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        float x = motionEvent.getX(iFindPointerIndex) - this.d;
        float y = motionEvent.getY(iFindPointerIndex) - this.e;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        int i3 = this.q;
        if (fAbs < i3 && fAbs2 < i3) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.k()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.l()) && (viewQ = q(motionEvent)) != null) {
            return this.r.g0(viewQ);
        }
        return null;
    }

    private void t(float[] fArr) {
        if ((this.f361o & 12) != 0) {
            fArr[0] = (this.f356j + this.f354h) - this.c.itemView.getLeft();
        } else {
            fArr[0] = this.c.itemView.getTranslationX();
        }
        if ((this.f361o & 3) != 0) {
            fArr[1] = (this.f357k + this.f355i) - this.c.itemView.getTop();
        } else {
            fArr[1] = this.c.itemView.getTranslationY();
        }
    }

    private static boolean v(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private void z() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    void A(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean B() {
        int iInterpolateOutOfBoundsScroll;
        int iInterpolateOutOfBoundsScroll2;
        int i2;
        int width;
        if (this.c == null) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.D;
        long j3 = j2 == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        if (this.C == null) {
            this.C = new Rect();
        }
        layoutManager.j(this.c.itemView, this.C);
        if (layoutManager.k()) {
            int i3 = (int) (this.f356j + this.f354h);
            int paddingLeft = (i3 - this.C.left) - this.r.getPaddingLeft();
            float f = this.f354h;
            iInterpolateOutOfBoundsScroll = (f >= 0.0f || paddingLeft >= 0) ? (f <= 0.0f || (width = ((i3 + this.c.itemView.getWidth()) + this.C.right) - (this.r.getWidth() - this.r.getPaddingRight())) <= 0) ? 0 : width : paddingLeft;
        }
        if (layoutManager.l()) {
            int i4 = (int) (this.f357k + this.f355i);
            int paddingTop = (i4 - this.C.top) - this.r.getPaddingTop();
            float f2 = this.f355i;
            if (f2 < 0.0f && paddingTop < 0) {
                iInterpolateOutOfBoundsScroll2 = paddingTop;
            } else if (f2 <= 0.0f || (iInterpolateOutOfBoundsScroll2 = ((i4 + this.c.itemView.getHeight()) + this.C.bottom) - (this.r.getHeight() - this.r.getPaddingBottom())) <= 0) {
                iInterpolateOutOfBoundsScroll2 = 0;
            }
        }
        if (iInterpolateOutOfBoundsScroll != 0) {
            iInterpolateOutOfBoundsScroll = this.f359m.interpolateOutOfBoundsScroll(this.r, this.c.itemView.getWidth(), iInterpolateOutOfBoundsScroll, this.r.getWidth(), j3);
        }
        int i5 = iInterpolateOutOfBoundsScroll;
        if (iInterpolateOutOfBoundsScroll2 != 0) {
            i2 = i5;
            iInterpolateOutOfBoundsScroll2 = this.f359m.interpolateOutOfBoundsScroll(this.r, this.c.itemView.getHeight(), iInterpolateOutOfBoundsScroll2, this.r.getHeight(), j3);
        } else {
            i2 = i5;
        }
        if (i2 == 0 && iInterpolateOutOfBoundsScroll2 == 0) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        if (this.D == Long.MIN_VALUE) {
            this.D = jCurrentTimeMillis;
        }
        this.r.scrollBy(i2, iInterpolateOutOfBoundsScroll2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void C(RecyclerView.d0 d0Var, int i2) {
        boolean z;
        boolean z2;
        float fSignum;
        float fSignum2;
        if (d0Var == this.c && i2 == this.f360n) {
            return;
        }
        this.D = Long.MIN_VALUE;
        int i3 = this.f360n;
        o(d0Var, true);
        this.f360n = i2;
        if (i2 == 2) {
            if (d0Var == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.x = d0Var.itemView;
            i();
        }
        int i4 = (1 << ((i2 * 8) + 8)) - 1;
        RecyclerView.d0 d0Var2 = this.c;
        if (d0Var2 != null) {
            if (d0Var2.itemView.getParent() != null) {
                int iH = i3 == 2 ? 0 : H(d0Var2);
                z();
                if (iH == 1 || iH == 2) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.f355i) * this.r.getHeight();
                } else if (iH == 4 || iH == 8 || iH == 16 || iH == 32) {
                    fSignum2 = 0.0f;
                    fSignum = Math.signum(this.f354h) * this.r.getWidth();
                } else {
                    fSignum = 0.0f;
                    fSignum2 = 0.0f;
                }
                int i5 = i3 == 2 ? 8 : iH > 0 ? 2 : 4;
                t(this.b);
                float[] fArr = this.b;
                float f = fArr[0];
                float f2 = fArr[1];
                f0 f0Var = new f0(this, d0Var2, i5, i3, f, f2, fSignum, fSignum2, iH, d0Var2);
                f0Var.b(this.f359m.getAnimationDuration(this.r, i5, fSignum - f, fSignum2 - f2));
                this.p.add(f0Var);
                f0Var.d();
                z = true;
            } else {
                A(d0Var2.itemView);
                this.f359m.clearView(this.r, d0Var2);
                z = false;
            }
            this.c = null;
        } else {
            z = false;
        }
        if (d0Var != null) {
            this.f361o = (this.f359m.getAbsoluteMovementFlags(this.r, d0Var) & i4) >> (this.f360n * 8);
            this.f356j = d0Var.itemView.getLeft();
            this.f357k = d0Var.itemView.getTop();
            this.c = d0Var;
            if (i2 == 2) {
                z2 = false;
                d0Var.itemView.performHapticFeedback(0);
            } else {
                z2 = false;
            }
        }
        ViewParent parent = this.r.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.c != null ? true : z2);
        }
        if (!z) {
            this.r.getLayoutManager().s1();
        }
        this.f359m.onSelectedChanged(this.c, this.f360n);
        this.r.invalidate();
    }

    public void E(RecyclerView.d0 d0Var) {
        if (!this.f359m.hasDragFlag(this.r, d0Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (d0Var.itemView.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        x();
        this.f355i = 0.0f;
        this.f354h = 0.0f;
        C(d0Var, 2);
    }

    void I(MotionEvent motionEvent, int i2, int i3) {
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        float f = x - this.d;
        this.f354h = f;
        this.f355i = y - this.e;
        if ((i2 & 4) == 0) {
            this.f354h = Math.max(0.0f, f);
        }
        if ((i2 & 8) == 0) {
            this.f354h = Math.min(0.0f, this.f354h);
        }
        if ((i2 & 1) == 0) {
            this.f355i = Math.max(0.0f, this.f355i);
        }
        if ((i2 & 2) == 0) {
            this.f355i = Math.min(0.0f, this.f355i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(View view) {
        A(view);
        RecyclerView.d0 d0VarG0 = this.r.g0(view);
        if (d0VarG0 == null) {
            return;
        }
        RecyclerView.d0 d0Var = this.c;
        if (d0Var != null && d0VarG0 == d0Var) {
            C(null, 0);
            return;
        }
        o(d0VarG0, false);
        if (this.a.remove(d0VarG0.itemView)) {
            this.f359m.clearView(this.r, d0VarG0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        this.y = -1;
        if (this.c != null) {
            t(this.b);
            float[] fArr = this.b;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f359m.onDraw(canvas, recyclerView, this.c, this.p, this.f360n, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        float f;
        float f2;
        if (this.c != null) {
            t(this.b);
            float[] fArr = this.b;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.f359m.onDrawOver(canvas, recyclerView, this.c, this.p, this.f360n, f, f2);
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f = resources.getDimension(h.n.b.f);
            this.g = resources.getDimension(h.n.b.e);
            D();
        }
    }

    void l(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.d0 d0VarS;
        int absoluteMovementFlags;
        if (this.c != null || i2 != 2 || this.f360n == 2 || !this.f359m.isItemViewSwipeEnabled() || this.r.getScrollState() == 1 || (d0VarS = s(motionEvent)) == null || (absoluteMovementFlags = (this.f359m.getAbsoluteMovementFlags(this.r, d0VarS) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        float f = x - this.d;
        float f2 = y - this.e;
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        int i4 = this.q;
        if (fAbs >= i4 || fAbs2 >= i4) {
            if (fAbs > fAbs2) {
                if (f < 0.0f && (absoluteMovementFlags & 4) == 0) {
                    return;
                }
                if (f > 0.0f && (absoluteMovementFlags & 8) == 0) {
                    return;
                }
            } else {
                if (f2 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                }
                if (f2 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                    return;
                }
            }
            this.f355i = 0.0f;
            this.f354h = 0.0f;
            this.f358l = motionEvent.getPointerId(0);
            C(d0VarS, 1);
        }
    }

    void o(RecyclerView.d0 d0Var, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            n0 n0Var = this.p.get(size);
            if (n0Var.e == d0Var) {
                n0Var.f365k |= z;
                if (!n0Var.f366l) {
                    n0Var.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    n0 p(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View viewQ = q(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            n0 n0Var = this.p.get(size);
            if (n0Var.e.itemView == viewQ) {
                return n0Var;
            }
        }
        return null;
    }

    View q(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.d0 d0Var = this.c;
        if (d0Var != null) {
            View view = d0Var.itemView;
            if (v(view, x, y, this.f356j + this.f354h, this.f357k + this.f355i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            n0 n0Var = this.p.get(size);
            View view2 = n0Var.e.itemView;
            if (v(view2, x, y, n0Var.f363i, n0Var.f364j)) {
                return view2;
            }
        }
        return this.r.R(x, y);
    }

    boolean u() {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.p.get(i2).f366l) {
                return true;
            }
        }
        return false;
    }

    void w(RecyclerView.d0 d0Var) {
        if (!this.r.isLayoutRequested() && this.f360n == 2) {
            float moveThreshold = this.f359m.getMoveThreshold(d0Var);
            int i2 = (int) (this.f356j + this.f354h);
            int i3 = (int) (this.f357k + this.f355i);
            if (Math.abs(i3 - d0Var.itemView.getTop()) >= d0Var.itemView.getHeight() * moveThreshold || Math.abs(i2 - d0Var.itemView.getLeft()) >= d0Var.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.d0> listR = r(d0Var);
                if (listR.size() == 0) {
                    return;
                }
                RecyclerView.d0 d0VarChooseDropTarget = this.f359m.chooseDropTarget(d0Var, listR, i2, i3);
                if (d0VarChooseDropTarget == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int adapterPosition = d0VarChooseDropTarget.getAdapterPosition();
                int adapterPosition2 = d0Var.getAdapterPosition();
                if (this.f359m.onMove(this.r, d0Var, d0VarChooseDropTarget)) {
                    this.f359m.onMoved(this.r, d0Var, adapterPosition2, d0VarChooseDropTarget, adapterPosition, i2, i3);
                }
            }
        }
    }

    void x() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    void y(n0 n0Var, int i2) {
        this.r.post(new g0(this, n0Var, i2));
    }
}
