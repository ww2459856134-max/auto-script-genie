package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.n;
import h.e.j.s0;
import h.g.b.c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] l0 = {R.attr.colorPrimaryDark};
    static final int[] m0 = {R.attr.layout_gravity};
    static final boolean n0;
    private static final boolean o0;
    private int A;
    private boolean C;
    private boolean D;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private d M;
    private List<d> O;
    private float P;
    private float Q;
    private Drawable U;
    private Drawable V;
    private Drawable W;
    private CharSequence a0;
    private CharSequence b0;
    private final c c;
    private Object c0;
    private float d;
    private boolean d0;
    private int e;
    private Drawable e0;
    private int f;
    private Drawable f0;
    private float g;
    private Drawable g0;

    /* renamed from: h, reason: collision with root package name */
    private Paint f224h;
    private Drawable h0;

    /* renamed from: i, reason: collision with root package name */
    private final h.g.b.c f225i;
    private final ArrayList<View> i0;

    /* renamed from: j, reason: collision with root package name */
    private final h.g.b.c f226j;
    private Rect j0;

    /* renamed from: k, reason: collision with root package name */
    private final g f227k;
    private Matrix k0;
    private final g t;

    class a implements View.OnApplyWindowInsetsListener {
        a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class b extends h.e.j.b {
        private final Rect d = new Rect();

        b() {
        }

        private void n(h.e.j.q1.e eVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.y(childAt)) {
                    eVar.c(childAt);
                }
            }
        }

        private void o(h.e.j.q1.e eVar, h.e.j.q1.e eVar2) {
            Rect rect = this.d;
            eVar2.k(rect);
            eVar.R(rect);
            eVar2.l(rect);
            eVar.S(rect);
            eVar.m0(eVar2.J());
            eVar.e0(eVar2.s());
            eVar.U(eVar2.m());
            eVar.Y(eVar2.p());
            eVar.Z(eVar2.C());
            eVar.V(eVar2.B());
            eVar.a0(eVar2.D());
            eVar.b0(eVar2.E());
            eVar.P(eVar2.y());
            eVar.j0(eVar2.I());
            eVar.d0(eVar2.F());
            eVar.a(eVar2.j());
        }

        @Override // h.e.j.b
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewN = DrawerLayout.this.n();
            if (viewN == null) {
                return true;
            }
            CharSequence charSequenceQ = DrawerLayout.this.q(DrawerLayout.this.r(viewN));
            if (charSequenceQ == null) {
                return true;
            }
            text.add(charSequenceQ);
            return true;
        }

        @Override // h.e.j.b
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // h.e.j.b
        public void g(View view, h.e.j.q1.e eVar) {
            if (DrawerLayout.n0) {
                super.g(view, eVar);
            } else {
                h.e.j.q1.e eVarK = h.e.j.q1.e.K(eVar);
                super.g(view, eVarK);
                eVar.k0(view);
                Object objB = s0.B(view);
                if (objB instanceof View) {
                    eVar.g0((View) objB);
                }
                o(eVar, eVarK);
                eVarK.M();
                n(eVar, (ViewGroup) view);
            }
            eVar.U(DrawerLayout.class.getName());
            eVar.a0(false);
            eVar.b0(false);
            eVar.N(h.e.j.q1.c.d);
            eVar.N(h.e.j.q1.c.e);
        }

        @Override // h.e.j.b
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.n0 || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class c extends h.e.j.b {
        c() {
        }

        @Override // h.e.j.b
        public void g(View view, h.e.j.q1.e eVar) {
            super.g(view, eVar);
            if (DrawerLayout.y(view)) {
                return;
            }
            eVar.g0(null);
        }
    }

    public interface d {
        void a(View view);

        void b(View view);

        void c(int i2);

        void d(View view, float f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g extends c.a {
        private final int a;
        private h.g.b.c b;
        private final Runnable c = new androidx.drawerlayout.widget.b(this);

        g(int i2) {
            this.a = i2;
        }

        private void n() {
            View viewL = DrawerLayout.this.l(this.a == 3 ? 5 : 3);
            if (viewL != null) {
                DrawerLayout.this.d(viewL);
            }
        }

        @Override // h.g.b.c.a
        public int a(View view, int i2, int i3) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // h.g.b.c.a
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // h.g.b.c.a
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // h.g.b.c.a
        public void f(int i2, int i3) {
            View viewL = (i2 & 1) == 1 ? DrawerLayout.this.l(3) : DrawerLayout.this.l(5);
            if (viewL == null || DrawerLayout.this.p(viewL) != 0) {
                return;
            }
            this.b.b(viewL, i3);
        }

        @Override // h.g.b.c.a
        public boolean g(int i2) {
            return false;
        }

        @Override // h.g.b.c.a
        public void h(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.c, 160L);
        }

        @Override // h.g.b.c.a
        public void i(View view, int i2) {
            ((e) view.getLayoutParams()).c = false;
            n();
        }

        @Override // h.g.b.c.a
        public void j(int i2) {
            DrawerLayout.this.O(this.a, i2, this.b.v());
        }

        @Override // h.g.b.c.a
        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = (DrawerLayout.this.c(view, 3) ? i2 + r3 : DrawerLayout.this.getWidth() - i2) / view.getWidth();
            DrawerLayout.this.M(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // h.g.b.c.a
        public void l(View view, float f, float f2) {
            int i2;
            float fS = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i2 = (f > 0.0f || (f == 0.0f && fS > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && fS > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.b.M(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // h.g.b.c.a
        public boolean m(View view, int i2) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.a) && DrawerLayout.this.p(view) == 0;
        }

        void o() {
            View viewL;
            int width;
            int iW = this.b.w();
            boolean z = this.a == 3;
            if (z) {
                viewL = DrawerLayout.this.l(3);
                width = (viewL != null ? -viewL.getWidth() : 0) + iW;
            } else {
                viewL = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - iW;
            }
            if (viewL != null) {
                if (((!z || viewL.getLeft() >= width) && (z || viewL.getLeft() <= width)) || DrawerLayout.this.p(viewL) != 0) {
                    return;
                }
                e eVar = (e) viewL.getLayoutParams();
                this.b.O(viewL, width, viewL.getTop());
                eVar.c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.c);
        }

        public void q(h.g.b.c cVar) {
            this.b = cVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        n0 = i2 >= 19;
        o0 = i2 >= 21;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private boolean D(float f2, float f3, View view) {
        if (this.j0 == null) {
            this.j0 = new Rect();
        }
        view.getHitRect(this.j0);
        return this.j0.contains((int) f2, (int) f3);
    }

    private boolean E(Drawable drawable, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (drawable == null || !androidx.core.graphics.drawable.a.g(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.l(drawable, i2);
        return true;
    }

    private Drawable J() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iW = s0.w(this);
        if (iW == 0) {
            Drawable drawable = this.e0;
            if (drawable != null) {
                E(drawable, iW);
                return this.e0;
            }
        } else {
            Drawable drawable2 = this.f0;
            if (drawable2 != null) {
                E(drawable2, iW);
                return this.f0;
            }
        }
        return this.g0;
    }

    private Drawable K() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iW = s0.w(this);
        if (iW == 0) {
            Drawable drawable = this.f0;
            if (drawable != null) {
                E(drawable, iW);
                return this.f0;
            }
        } else {
            Drawable drawable2 = this.e0;
            if (drawable2 != null) {
                E(drawable2, iW);
                return this.e0;
            }
        }
        return this.h0;
    }

    private void L() {
        if (o0) {
            return;
        }
        this.V = J();
        this.W = K();
    }

    private void N(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || B(childAt)) && !(z && childAt == view)) {
                s0.e0(childAt, 4);
            } else {
                s0.e0(childAt, 1);
            }
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventT = t(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventT);
            motionEventT.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.k0 == null) {
                this.k0 = new Matrix();
            }
            matrix.invert(this.k0);
            motionEventObtain.transform(this.k0);
        }
        return motionEventObtain;
    }

    static String u(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((e) getChildAt(i2).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return n() != null;
    }

    static boolean y(View view) {
        return (s0.u(view) == 4 || s0.u(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((e) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean B(View view) {
        int iA = n.a(((e) view.getLayoutParams()).a, s0.w(view));
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((e) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void F(View view, float f2) {
        float fS = s(view);
        float width = view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (fS * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        M(view, f2);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.D) {
            eVar.b = 1.0f;
            eVar.d = 1;
            N(view, true);
        } else if (z) {
            eVar.d |= 2;
            if (c(view, 3)) {
                this.f225i.O(view, 0, view.getTop());
            } else {
                this.f226j.O(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            F(view, 1.0f);
            O(eVar.a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void I(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.O) == null) {
            return;
        }
        list.remove(dVar);
    }

    void M(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.b) {
            return;
        }
        eVar.b = f2;
        j(view, f2);
    }

    void O(int i2, int i3, View view) {
        int iZ = this.f225i.z();
        int iZ2 = this.f226j.z();
        int i4 = 2;
        if (iZ == 1 || iZ2 == 1) {
            i4 = 1;
        } else if (iZ != 2 && iZ2 != 2) {
            i4 = 0;
        }
        if (view != null && i3 == 0) {
            float f2 = ((e) view.getLayoutParams()).b;
            if (f2 == 0.0f) {
                h(view);
            } else if (f2 == 1.0f) {
                i(view);
            }
        }
        if (i4 != this.A) {
            this.A = i4;
            List<d> list = this.O;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.O.get(size).c(i4);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (!B(childAt)) {
                this.i0.add(childAt);
            } else if (A(childAt)) {
                childAt.addFocusables(arrayList, i2, i3);
                z = true;
            }
        }
        if (!z) {
            int size = this.i0.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.i0.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        this.i0.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (m() != null || B(view)) {
            s0.e0(view, 4);
        } else {
            s0.e0(view, 1);
        }
        if (n0) {
            return;
        }
        s0.Z(view, this.c);
    }

    void b() {
        if (this.K) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.K = true;
    }

    boolean c(View view, int i2) {
        return (r(view) & i2) == i2;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            fMax = Math.max(fMax, ((e) getChildAt(i2).getLayoutParams()).b);
        }
        this.g = fMax;
        boolean zM = this.f225i.m(true);
        boolean zM2 = this.f226j.m(true);
        if (zM || zM2) {
            s0.T(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.g <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (D(x, y, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        int height = getHeight();
        boolean z = z(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (z) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(iSave);
        float f2 = this.g;
        if (f2 > 0.0f && z) {
            this.f224h.setColor((this.f & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i2, 0.0f, width, getHeight(), this.f224h);
        } else if (this.V != null && c(view, 3)) {
            int intrinsicWidth = this.V.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f225i.w(), 1.0f));
            this.V.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.V.setAlpha((int) (fMax * 255.0f));
            this.V.draw(canvas);
        } else if (this.W != null && c(view, 5)) {
            int intrinsicWidth2 = this.W.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f226j.w(), 1.0f));
            this.W.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.W.setAlpha((int) (fMax2 * 255.0f));
            this.W.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.D) {
            eVar.b = 0.0f;
            eVar.d = 0;
        } else if (z) {
            eVar.d |= 4;
            if (c(view, 3)) {
                this.f225i.O(view, -view.getWidth(), view.getTop());
            } else {
                this.f226j.O(view, getWidth(), view.getTop());
            }
        } else {
            F(view, 0.0f);
            O(eVar.a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f() {
        g(false);
    }

    void g(boolean z) {
        int childCount = getChildCount();
        boolean zO = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (B(childAt) && (!z || eVar.c)) {
                zO |= c(childAt, 3) ? this.f225i.O(childAt, -childAt.getWidth(), childAt.getTop()) : this.f226j.O(childAt, getWidth(), childAt.getTop());
                eVar.c = false;
            }
        }
        this.f227k.p();
        this.t.p();
        if (zO) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (o0) {
            return this.d;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.U;
    }

    void h(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.d & 1) == 1) {
            eVar.d = 0;
            List<d> list = this.O;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.O.get(size).b(view);
                }
            }
            N(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void i(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.d & 1) == 0) {
            eVar.d = 1;
            List<d> list = this.O;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.O.get(size).a(view);
                }
            }
            N(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view, float f2) {
        List<d> list = this.O;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.O.get(size).d(view, f2);
            }
        }
    }

    View l(int i2) {
        int iA = n.a(i2, s0.w(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((r(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    View m() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((e) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i2) {
        int iW = s0.w(this);
        if (i2 == 3) {
            int i3 = this.G;
            if (i3 != 3) {
                return i3;
            }
            int i4 = iW == 0 ? this.I : this.J;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i2 == 5) {
            int i5 = this.H;
            if (i5 != 3) {
                return i5;
            }
            int i6 = iW == 0 ? this.J : this.I;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i2 == 8388611) {
            int i7 = this.I;
            if (i7 != 3) {
                return i7;
            }
            int i8 = iW == 0 ? this.G : this.H;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i2 != 8388613) {
            return 0;
        }
        int i9 = this.J;
        if (i9 != 3) {
            return i9;
        }
        int i10 = iW == 0 ? this.H : this.G;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.d0 || this.U == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.c0) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.U.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.U.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewT;
        int actionMasked = motionEvent.getActionMasked();
        boolean zN = this.f225i.N(motionEvent) | this.f226j.N(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.P = x;
            this.Q = y;
            z = this.g > 0.0f && (viewT = this.f225i.t((int) x, (int) y)) != null && z(viewT);
            this.K = false;
        } else if (actionMasked == 1) {
            g(true);
            this.K = false;
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            } else if (this.f225i.d(3)) {
                this.f227k.p();
                this.t.p();
            }
            z = false;
        }
        return zN || z || w() || this.K;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !x()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View viewN = n();
        if (viewN != null && p(viewN) == 0) {
            f();
        }
        return viewN != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        boolean z2 = true;
        this.C = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (eVar.b * f3));
                        f2 = (measuredWidth + i6) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i7 - r11) / f4;
                        i6 = i7 - ((int) (eVar.b * f4));
                    }
                    boolean z3 = f2 != eVar.b ? z2 : false;
                    int i10 = eVar.a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i5 - i3;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                    }
                    if (z3) {
                        M(childAt, f2);
                    }
                    int i18 = eVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i8++;
            z2 = true;
        }
        this.C = false;
        this.D = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z = this.c0 != null && s0.t(this);
        int iW = s0.w(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z) {
                    int iA = n.a(eVar.a, iW);
                    if (s0.t(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.c0;
                            if (iA == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i4, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iA == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i4, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.c0;
                        if (iA == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i4, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iA == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i4, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, WXVideoFileObject.FILE_SIZE_LIMIT));
                } else {
                    if (!B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (o0) {
                        float fQ = s0.q(childAt);
                        float f2 = this.d;
                        if (fQ != f2) {
                            s0.d0(childAt, f2);
                        }
                    }
                    int iR = r(childAt) & 7;
                    int i6 = iR == 3 ? 1 : i4;
                    if ((i6 != 0 && z2) || (i6 == 0 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(iR) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (i6 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.e + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                }
            }
            i5++;
            i4 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewL;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.a());
        int i2 = fVar.e;
        if (i2 != 0 && (viewL = l(i2)) != null) {
            G(viewL);
        }
        int i3 = fVar.f;
        if (i3 != 3) {
            setDrawerLockMode(i3, 3);
        }
        int i4 = fVar.g;
        if (i4 != 3) {
            setDrawerLockMode(i4, 5);
        }
        int i5 = fVar.f228h;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388611);
        }
        int i6 = fVar.f229i;
        if (i6 != 3) {
            setDrawerLockMode(i6, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        L();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e eVar = (e) getChildAt(i2).getLayoutParams();
            int i3 = eVar.d;
            boolean z = i3 == 1;
            boolean z2 = i3 == 2;
            if (z || z2) {
                fVar.e = eVar.a;
                break;
            }
        }
        fVar.f = this.G;
        fVar.g = this.H;
        fVar.f228h = this.I;
        fVar.f229i = this.J;
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View viewM;
        this.f225i.E(motionEvent);
        this.f226j.E(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z = false;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.P = x;
            this.Q = y;
            this.K = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View viewT = this.f225i.t((int) x2, (int) y2);
            if (viewT == null || !z(viewT)) {
                z = true;
                g(z);
            } else {
                float f2 = x2 - this.P;
                float f3 = y2 - this.Q;
                int iY = this.f225i.y();
                if ((f2 * f2) + (f3 * f3) >= iY * iY || (viewM = m()) == null || p(viewM) == 2) {
                }
                g(z);
            }
        } else if (action == 3) {
            g(true);
            this.K = false;
        }
        return true;
    }

    public int p(View view) {
        if (B(view)) {
            return o(((e) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i2) {
        int iA = n.a(i2, s0.w(this));
        if (iA == 3) {
            return this.a0;
        }
        if (iA == 5) {
            return this.b0;
        }
        return null;
    }

    int r(View view) {
        return n.a(((e) view.getLayoutParams()).a, s0.w(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.C) {
            return;
        }
        super.requestLayout();
    }

    float s(View view) {
        return ((e) view.getLayoutParams()).b;
    }

    public void setChildInsets(Object obj, boolean z) {
        this.c0 = obj;
        this.d0 = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.d = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (B(childAt)) {
                s0.d0(childAt, this.d);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.M;
        if (dVar2 != null) {
            I(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.M = dVar;
    }

    public void setDrawerLockMode(int i2) {
        setDrawerLockMode(i2, 3);
        setDrawerLockMode(i2, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i2) {
        if (o0) {
            return;
        }
        if ((i2 & 8388611) == 8388611) {
            this.e0 = drawable;
        } else if ((i2 & 8388613) == 8388613) {
            this.f0 = drawable;
        } else if ((i2 & 3) == 3) {
            this.g0 = drawable;
        } else if ((i2 & 5) != 5) {
            return;
        } else {
            this.h0 = drawable;
        }
        L();
        invalidate();
    }

    public void setDrawerTitle(int i2, CharSequence charSequence) {
        int iA = n.a(i2, s0.w(this));
        if (iA == 3) {
            this.a0 = charSequence;
        } else if (iA == 5) {
            this.b0 = charSequence;
        }
    }

    public void setScrimColor(int i2) {
        this.f = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.U = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.U = new ColorDrawable(i2);
        invalidate();
    }

    boolean z(View view) {
        return ((e) view.getLayoutParams()).a == 0;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new c();
        this.f = -1728053248;
        this.f224h = new Paint();
        this.D = true;
        this.G = 3;
        this.H = 3;
        this.I = 3;
        this.J = 3;
        this.e0 = null;
        this.f0 = null;
        this.g0 = null;
        this.h0 = null;
        setDescendantFocusability(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
        float f2 = getResources().getDisplayMetrics().density;
        this.e = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        g gVar = new g(3);
        this.f227k = gVar;
        g gVar2 = new g(5);
        this.t = gVar2;
        h.g.b.c cVarN = h.g.b.c.n(this, 1.0f, gVar);
        this.f225i = cVarN;
        cVarN.K(1);
        cVarN.L(f3);
        gVar.q(cVarN);
        h.g.b.c cVarN2 = h.g.b.c.n(this, 1.0f, gVar2);
        this.f226j = cVarN2;
        cVarN2.K(2);
        cVarN2.L(f3);
        gVar2.q(cVarN2);
        setFocusableInTouchMode(true);
        s0.e0(this, 1);
        s0.Z(this, new b());
        setMotionEventSplittingEnabled(false);
        if (s0.t(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(l0);
                try {
                    this.U = typedArrayObtainStyledAttributes.getDrawable(0);
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } else {
                this.U = null;
            }
        }
        this.d = f2 * 10.0f;
        this.i0 = new ArrayList<>();
    }

    public void setDrawerLockMode(int i2, int i3) {
        View viewL;
        int iA = n.a(i3, s0.w(this));
        if (i3 == 3) {
            this.G = i2;
        } else if (i3 == 5) {
            this.H = i2;
        } else if (i3 == 8388611) {
            this.I = i2;
        } else if (i3 == 8388613) {
            this.J = i2;
        }
        if (i2 != 0) {
            (iA == 3 ? this.f225i : this.f226j).a();
        }
        if (i2 != 1) {
            if (i2 == 2 && (viewL = l(iA)) != null) {
                G(viewL);
                return;
            }
            return;
        }
        View viewL2 = l(iA);
        if (viewL2 != null) {
            d(viewL2);
        }
    }

    public void setStatusBarBackground(int i2) {
        this.U = i2 != 0 ? androidx.core.content.a.e(getContext(), i2) : null;
        invalidate();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public int a;
        float b;
        boolean c;
        int d;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.m0);
            this.a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.a = 0;
            this.a = eVar.a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    protected static class f extends h.g.a.c {
        public static final Parcelable.Creator<f> CREATOR = new androidx.drawerlayout.widget.a();
        int e;
        int f;
        int g;

        /* renamed from: h, reason: collision with root package name */
        int f228h;

        /* renamed from: i, reason: collision with root package name */
        int f229i;

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.e = 0;
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.f228h = parcel.readInt();
            this.f229i = parcel.readInt();
        }

        @Override // h.g.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.f228h);
            parcel.writeInt(this.f229i);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.e = 0;
        }
    }

    public void setDrawerShadow(int i2, int i3) {
        setDrawerShadow(androidx.core.content.a.e(getContext(), i2), i3);
    }

    public void setDrawerLockMode(int i2, View view) {
        if (B(view)) {
            setDrawerLockMode(i2, ((e) view.getLayoutParams()).a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }
}
