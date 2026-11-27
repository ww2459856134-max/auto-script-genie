package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.a0;
import h.e.j.e1;
import h.e.j.s0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    static final int[] D0 = {R.attr.layout_gravity};
    private static final Comparator<f> E0 = new a();
    private static final Interpolator F0 = new b();
    private static final n G0 = new n();
    private boolean A;
    private ArrayList<View> A0;
    private final Runnable B0;
    private l C;
    private int C0;
    private int D;
    private Drawable G;
    private int H;
    private int I;
    private float J;
    private float K;
    private int M;
    private boolean O;
    private boolean P;
    private boolean Q;
    private int U;
    private boolean V;
    private boolean W;
    private int a0;
    private int b0;
    private int c;
    private int c0;
    private final ArrayList<f> d;
    private float d0;
    private final f e;
    private float e0;
    private final Rect f;
    private float f0;
    androidx.viewpager.widget.a g;
    private float g0;

    /* renamed from: h, reason: collision with root package name */
    int f410h;
    private int h0;

    /* renamed from: i, reason: collision with root package name */
    private int f411i;
    private VelocityTracker i0;

    /* renamed from: j, reason: collision with root package name */
    private Parcelable f412j;
    private int j0;

    /* renamed from: k, reason: collision with root package name */
    private ClassLoader f413k;
    private int k0;
    private int l0;
    private int m0;
    private boolean n0;
    private EdgeEffect o0;
    private EdgeEffect p0;
    private boolean q0;
    private boolean r0;
    private int s0;
    private Scroller t;
    private List<j> t0;
    private j u0;
    private j v0;
    private List<i> w0;
    private k x0;
    private int y0;
    private int z0;

    static class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b - fVar2.b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.D();
        }
    }

    class d implements a0 {
        private final Rect a = new Rect();

        d() {
        }

        @Override // h.e.j.a0
        public e1 a(View view, e1 e1Var) {
            e1 e1VarQ = s0.Q(view, e1Var);
            if (e1VarQ.k()) {
                return e1VarQ;
            }
            Rect rect = this.a;
            rect.left = e1VarQ.f();
            rect.top = e1VarQ.h();
            rect.right = e1VarQ.g();
            rect.bottom = e1VarQ.e();
            int childCount = ViewPager.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                e1 e1VarF = s0.f(ViewPager.this.getChildAt(i2), e1VarQ);
                rect.left = Math.min(e1VarF.f(), rect.left);
                rect.top = Math.min(e1VarF.h(), rect.top);
                rect.right = Math.min(e1VarF.g(), rect.right);
                rect.bottom = Math.min(e1VarF.e(), rect.bottom);
            }
            return e1VarQ.l(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        f() {
        }
    }

    class h extends h.e.j.b {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.g;
            return aVar != null && aVar.d() > 1;
        }

        @Override // h.e.j.b
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.g) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.d());
            accessibilityEvent.setFromIndex(ViewPager.this.f410h);
            accessibilityEvent.setToIndex(ViewPager.this.f410h);
        }

        @Override // h.e.j.b
        public void g(View view, h.e.j.q1.e eVar) {
            super.g(view, eVar);
            eVar.U(ViewPager.class.getName());
            eVar.i0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                eVar.a(XMLEvent.CHANGE_PREFIX_MAPPING);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                eVar.a(XMLEvent.ENTITY_REFERENCE);
            }
        }

        @Override // h.e.j.b
        public boolean j(View view, int i2, Bundle bundle) throws Resources.NotFoundException {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (i2 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f410h + 1);
                return true;
            }
            if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f410h - 1);
            return true;
        }
    }

    public interface i {
        void c(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface j {
        void a(int i2, float f, int i3);

        void b(int i2);

        void d(int i2);
    }

    public interface k {
        void a(View view, float f);
    }

    private class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.g();
        }
    }

    public static class m extends h.g.a.c {
        public static final Parcelable.Creator<m> CREATOR = new androidx.viewpager.widget.b();
        int e;
        Parcelable f;
        ClassLoader g;

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.e + "}";
        }

        @Override // h.g.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.e);
            parcel.writeParcelable(this.f, i2);
        }

        m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.e = parcel.readInt();
            this.f = parcel.readParcelable(classLoader);
            this.g = classLoader;
        }
    }

    static class n implements Comparator<View> {
        n() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.a;
            return z != gVar2.a ? z ? 1 : -1 : gVar.e - gVar2.e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = new f();
        this.f = new Rect();
        this.f411i = -1;
        this.f412j = null;
        this.f413k = null;
        this.J = -3.4028235E38f;
        this.K = Float.MAX_VALUE;
        this.U = 1;
        this.h0 = -1;
        this.q0 = true;
        this.B0 = new c();
        this.C0 = 0;
        u();
    }

    private boolean B(int i2) {
        if (this.d.size() == 0) {
            if (this.q0) {
                return false;
            }
            this.r0 = false;
            x(0, 0.0f, 0);
            if (this.r0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarS = s();
        int clientWidth = getClientWidth();
        int i3 = this.D;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarS.b;
        float f3 = ((i2 / f2) - fVarS.e) / (fVarS.d + (i3 / f2));
        this.r0 = false;
        x(i5, f3, (int) (i4 * f3));
        if (this.r0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean C(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.d0 - f2;
        this.d0 = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.J * clientWidth;
        float f5 = this.K * clientWidth;
        boolean z3 = false;
        f fVar = this.d.get(0);
        ArrayList<f> arrayList = this.d;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.g.d() - 1) {
            f5 = fVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.o0.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.p0.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.d0 += scrollX - i2;
        scrollTo(i2, getScrollY());
        B(i2);
        return z3;
    }

    private void F(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.d.isEmpty()) {
            if (!this.t.isFinished()) {
                this.t.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f fVarT = t(this.f410h);
        int iMin = (int) ((fVarT != null ? Math.min(fVarT.e, this.K) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            f(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void G() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void I(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean J() {
        this.h0 = -1;
        n();
        this.o0.onRelease();
        this.p0.onRelease();
        return this.o0.isFinished() || this.p0.isFinished();
    }

    private void K(int i2, boolean z, int i3, boolean z2) throws Resources.NotFoundException {
        f fVarT = t(i2);
        int clientWidth = fVarT != null ? (int) (getClientWidth() * Math.max(this.J, Math.min(fVarT.e, this.K))) : 0;
        if (z) {
            O(clientWidth, 0, i3);
            if (z2) {
                j(i2);
                return;
            }
            return;
        }
        if (z2) {
            j(i2);
        }
        f(false);
        scrollTo(clientWidth, 0);
        B(clientWidth);
    }

    private void P() {
        if (this.z0 != 0) {
            ArrayList<View> arrayList = this.A0;
            if (arrayList == null) {
                this.A0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.A0.add(getChildAt(i2));
            }
            Collections.sort(this.A0, G0);
        }
    }

    private void d(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iD = this.g.d();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.D / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.b;
            int i6 = fVar.b;
            if (i5 < i6) {
                int i7 = 0;
                float fG = fVar2.e + fVar2.d + f2;
                while (true) {
                    i5++;
                    if (i5 > fVar.b || i7 >= this.d.size()) {
                        break;
                    }
                    f fVar5 = this.d.get(i7);
                    while (true) {
                        fVar4 = fVar5;
                        if (i5 <= fVar4.b || i7 >= this.d.size() - 1) {
                            break;
                        }
                        i7++;
                        fVar5 = this.d.get(i7);
                    }
                    while (i5 < fVar4.b) {
                        fG += this.g.g(i5) + f2;
                        i5++;
                    }
                    fVar4.e = fG;
                    fG += fVar4.d + f2;
                }
            } else if (i5 > i6) {
                int size = this.d.size() - 1;
                float fG2 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.b || size < 0) {
                        break;
                    }
                    f fVar6 = this.d.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i5 >= fVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.d.get(size);
                    }
                    while (i5 > fVar3.b) {
                        fG2 -= this.g.g(i5) + f2;
                        i5--;
                    }
                    fG2 -= fVar3.d + f2;
                    fVar3.e = fG2;
                }
            }
        }
        int size2 = this.d.size();
        float fG3 = fVar.e;
        int i8 = fVar.b;
        int i9 = i8 - 1;
        this.J = i8 == 0 ? fG3 : -3.4028235E38f;
        int i10 = iD - 1;
        this.K = i8 == i10 ? (fVar.d + fG3) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            f fVar7 = this.d.get(i11);
            while (true) {
                i4 = fVar7.b;
                if (i9 <= i4) {
                    break;
                }
                fG3 -= this.g.g(i9) + f2;
                i9--;
            }
            fG3 -= fVar7.d + f2;
            fVar7.e = fG3;
            if (i4 == 0) {
                this.J = fG3;
            }
            i11--;
            i9--;
        }
        float fG4 = fVar.e + fVar.d + f2;
        int i12 = fVar.b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            f fVar8 = this.d.get(i13);
            while (true) {
                i3 = fVar8.b;
                if (i12 >= i3) {
                    break;
                }
                fG4 += this.g.g(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.K = (fVar8.d + fG4) - 1.0f;
            }
            fVar8.e = fG4;
            fG4 += fVar8.d + f2;
            i13++;
            i12++;
        }
    }

    private void f(boolean z) {
        boolean z2 = this.C0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.t.isFinished()) {
                this.t.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.t.getCurrX();
                int currY = this.t.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        B(currX);
                    }
                }
            }
        }
        this.Q = false;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            f fVar = this.d.get(i2);
            if (fVar.c) {
                fVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                s0.U(this, this.B0);
            } else {
                this.B0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.l0 || Math.abs(i3) <= this.j0) {
            i2 += (int) (f2 + (i2 >= this.f410h ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.d.size() <= 0) {
            return i2;
        }
        return Math.max(this.d.get(0).b, Math.min(i2, this.d.get(r4.size() - 1).b));
    }

    private void i(int i2, float f2, int i3) {
        j jVar = this.u0;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List<j> list = this.t0;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = this.t0.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.v0;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    private void j(int i2) {
        j jVar = this.u0;
        if (jVar != null) {
            jVar.d(i2);
        }
        List<j> list = this.t0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.t0.get(i3);
                if (jVar2 != null) {
                    jVar2.d(i2);
                }
            }
        }
        j jVar3 = this.v0;
        if (jVar3 != null) {
            jVar3.d(i2);
        }
    }

    private void k(int i2) {
        j jVar = this.u0;
        if (jVar != null) {
            jVar.b(i2);
        }
        List<j> list = this.t0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.t0.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.v0;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    private void m(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.y0 : 0, null);
        }
    }

    private void n() {
        this.V = false;
        this.W = false;
        VelocityTracker velocityTracker = this.i0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.i0 = null;
        }
    }

    private Rect p(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f s() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.D / clientWidth : 0.0f;
        f fVar = null;
        int i3 = 0;
        int i4 = -1;
        boolean z = true;
        float f4 = 0.0f;
        while (i3 < this.d.size()) {
            f fVar2 = this.d.get(i3);
            if (!z && fVar2.b != (i2 = i4 + 1)) {
                fVar2 = this.e;
                fVar2.e = f2 + f4 + f3;
                fVar2.b = i2;
                fVar2.d = this.g.g(i2);
                i3--;
            }
            f2 = fVar2.e;
            float f5 = fVar2.d + f2 + f3;
            if (!z && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.d.size() - 1) {
                return fVar2;
            }
            i4 = fVar2.b;
            f4 = fVar2.d;
            i3++;
            z = false;
            fVar = fVar2;
        }
        return fVar;
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.P != z) {
            this.P = z;
        }
    }

    private static boolean v(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean w(float f2, float f3) {
        return (f2 < ((float) this.b0) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.b0)) && f3 < 0.0f);
    }

    private void y(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.h0) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.d0 = motionEvent.getX(i2);
            this.h0 = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.i0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    boolean A() throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.g;
        if (aVar == null || this.f410h >= aVar.d() - 1) {
            return false;
        }
        setCurrentItem(this.f410h + 1, true);
        return true;
    }

    void D() throws Resources.NotFoundException {
        E(this.f410h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7 A[PHI: r7 r10 r15
      0x00f7: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00f7: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00f7: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void E(int i2) throws Resources.NotFoundException {
        f fVarT;
        String hexString;
        f fVarA;
        f fVarR;
        f fVar;
        int i3 = this.f410h;
        if (i3 != i2) {
            fVarT = t(i3);
            this.f410h = i2;
        } else {
            fVarT = null;
        }
        if (this.g == null) {
            P();
            return;
        }
        if (this.Q) {
            P();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.g.r(this);
        int i4 = this.U;
        int iMax = Math.max(0, this.f410h - i4);
        int iD = this.g.d();
        int iMin = Math.min(iD - 1, this.f410h + i4);
        if (iD != this.c) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.c + ", found: " + iD + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.g.getClass());
        }
        int i5 = 0;
        while (true) {
            if (i5 >= this.d.size()) {
                break;
            }
            fVarA = this.d.get(i5);
            int i6 = fVarA.b;
            int i7 = this.f410h;
            if (i6 >= i7) {
                if (i6 != i7) {
                    break;
                }
            } else {
                i5++;
            }
        }
        if (fVarA == null && iD > 0) {
            fVarA = a(this.f410h, i5);
        }
        if (fVarA != null) {
            int i8 = i5 - 1;
            f fVar2 = i8 >= 0 ? this.d.get(i8) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - fVarA.d) + (getPaddingLeft() / clientWidth);
            float f2 = 0.0f;
            for (int i9 = this.f410h - 1; i9 >= 0; i9--) {
                if (f2 >= paddingLeft && i9 < iMax) {
                    if (fVar2 == null) {
                        break;
                    }
                    if (i9 == fVar2.b && !fVar2.c) {
                        this.d.remove(i8);
                        this.g.a(this, i9, fVar2.a);
                        i8--;
                        i5--;
                        if (i8 >= 0) {
                            fVar = this.d.get(i8);
                        }
                        fVar2 = fVar;
                    }
                } else if (fVar2 == null || i9 != fVar2.b) {
                    f2 += a(i9, i8 + 1).d;
                    i5++;
                    fVar = i8 >= 0 ? this.d.get(i8) : null;
                    fVar2 = fVar;
                } else {
                    f2 += fVar2.d;
                    i8--;
                    if (i8 >= 0) {
                        fVar = this.d.get(i8);
                    }
                    fVar2 = fVar;
                }
            }
            float f3 = fVarA.d;
            int i10 = i5 + 1;
            if (f3 < 2.0f) {
                f fVar3 = i10 < this.d.size() ? this.d.get(i10) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i11 = this.f410h;
                while (true) {
                    i11++;
                    if (i11 >= iD) {
                        break;
                    }
                    if (f3 >= paddingRight && i11 > iMin) {
                        if (fVar3 == null) {
                            break;
                        }
                        if (i11 == fVar3.b && !fVar3.c) {
                            this.d.remove(i10);
                            this.g.a(this, i11, fVar3.a);
                            if (i10 < this.d.size()) {
                                fVar3 = this.d.get(i10);
                            }
                        }
                    } else if (fVar3 == null || i11 != fVar3.b) {
                        f fVarA2 = a(i11, i10);
                        i10++;
                        f3 += fVarA2.d;
                        fVar3 = i10 < this.d.size() ? this.d.get(i10) : null;
                    } else {
                        f3 += fVar3.d;
                        i10++;
                        if (i10 < this.d.size()) {
                            fVar3 = this.d.get(i10);
                        }
                    }
                }
            }
            d(fVarA, i5, fVarT);
            this.g.o(this, this.f410h, fVarA.a);
        }
        this.g.c(this);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            g gVar = (g) childAt.getLayoutParams();
            gVar.f = i12;
            if (!gVar.a && gVar.c == 0.0f && (fVarR = r(childAt)) != null) {
                gVar.c = fVarR.d;
                gVar.e = fVarR.b;
            }
        }
        P();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            f fVarQ = viewFindFocus != null ? q(viewFindFocus) : null;
            if (fVarQ == null || fVarQ.b != this.f410h) {
                for (int i13 = 0; i13 < getChildCount(); i13++) {
                    View childAt2 = getChildAt(i13);
                    f fVarR2 = r(childAt2);
                    if (fVarR2 != null && fVarR2.b == this.f410h && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    public void H(i iVar) {
        List<i> list = this.w0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    void L(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        M(i2, z, z2, 0);
    }

    void M(int i2, boolean z, boolean z2, int i3) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.g;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f410h == i2 && this.d.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.g.d()) {
            i2 = this.g.d() - 1;
        }
        int i4 = this.U;
        int i5 = this.f410h;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.d.size(); i6++) {
                this.d.get(i6).c = true;
            }
        }
        boolean z3 = this.f410h != i2;
        if (!this.q0) {
            E(i2);
            K(i2, z, i3, z3);
        } else {
            this.f410h = i2;
            if (z3) {
                j(i2);
            }
            requestLayout();
        }
    }

    j N(j jVar) {
        j jVar2 = this.v0;
        this.v0 = jVar;
        return jVar2;
    }

    void O(int i2, int i3, int i4) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.t;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.A ? this.t.getCurrX() : this.t.getStartX();
            this.t.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            f(false);
            D();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fL = f3 + (l(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fL / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.g.g(this.f410h)) + this.D)) + 1.0f) * 100.0f), 600);
        this.A = false;
        this.t.startScroll(i5, scrollY, i6, i7, iMin);
        s0.T(this);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.b = i2;
        fVar.a = this.g.h(this, i2);
        fVar.d = this.g.g(i2);
        if (i3 < 0 || i3 >= this.d.size()) {
            this.d.add(fVar);
        } else {
            this.d.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f fVarR;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.f410h) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f fVarR;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.f410h) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zV = gVar.a | v(view);
        gVar.a = zV;
        if (!this.O) {
            super.addView(view, i2, layoutParams);
        } else {
            if (gVar != null && zV) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.w0 == null) {
            this.w0 = new ArrayList();
        }
        this.w0.add(iVar);
    }

    public boolean c(int i2) throws Resources.NotFoundException {
        boolean z;
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        boolean z2 = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i2 == 17) {
                zRequestFocus = (viewFindFocus == null || p(this.f, viewFindNextFocus).left < p(this.f, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : z();
            } else if (i2 == 66) {
                zRequestFocus = (viewFindFocus == null || p(this.f, viewFindNextFocus).left > p(this.f, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : A();
            }
            z2 = zRequestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z2 = z();
        } else if (i2 == 66 || i2 == 2) {
            z2 = A();
        }
        if (z2) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z2;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.g == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.J)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.K));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.A = true;
        if (this.t.isFinished() || !this.t.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.t.getCurrX();
        int currY = this.t.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!B(currX)) {
                this.t.abortAnimation();
                scrollTo(0, currY);
            }
        }
        s0.T(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || o(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarR;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.f410h && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.g) != null && aVar.d() > 1)) {
            if (!this.o0.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.J * width);
                this.o0.setSize(height, width);
                zDraw = false | this.o0.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.p0.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.K + 1.0f)) * width2);
                this.p0.setSize(height2, width2);
                zDraw |= this.p0.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.o0.finish();
            this.p0.finish();
        }
        if (zDraw) {
            s0.T(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.G;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean e(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && e(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    void g() throws Resources.NotFoundException {
        int iD = this.g.d();
        this.c = iD;
        boolean z = this.d.size() < (this.U * 2) + 1 && this.d.size() < iD;
        int iMax = this.f410h;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.d.size()) {
            f fVar = this.d.get(i2);
            int iE = this.g.e(fVar.a);
            if (iE != -1) {
                if (iE == -2) {
                    this.d.remove(i2);
                    i2--;
                    if (!z2) {
                        this.g.r(this);
                        z2 = true;
                    }
                    this.g.a(this, fVar.b, fVar.a);
                    int i3 = this.f410h;
                    if (i3 == fVar.b) {
                        iMax = Math.max(0, Math.min(i3, iD - 1));
                    }
                } else {
                    int i4 = fVar.b;
                    if (i4 != iE) {
                        if (i4 == this.f410h) {
                            iMax = iE;
                        }
                        fVar.b = iE;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.g.c(this);
        }
        Collections.sort(this.d, E0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.a) {
                    gVar.c = 0.0f;
                }
            }
            L(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.g;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.z0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) this.A0.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.f410h;
    }

    public int getOffscreenPageLimit() {
        return this.U;
    }

    public int getPageMargin() {
        return this.D;
    }

    float l(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? z() : c(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? A() : c(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return c(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return c(1);
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.B0);
        Scroller scroller = this.t;
        if (scroller != null && !scroller.isFinished()) {
            this.t.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.D <= 0 || this.G == null || this.d.size() <= 0 || this.g == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.D / width;
        int i3 = 0;
        f fVar = this.d.get(0);
        float f5 = fVar.e;
        int size = this.d.size();
        int i4 = fVar.b;
        int i5 = this.d.get(size - 1).b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = this.d.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.e;
                float f7 = fVar.d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float fG = this.g.g(i4);
                f2 = (f5 + fG) * width;
                f5 += fG + f4;
            }
            if (this.D + f2 > scrollX) {
                f3 = f4;
                this.G.setBounds(Math.round(f2), this.H, Math.round(this.D + f2), this.I);
                this.G.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i4++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            J();
            return false;
        }
        if (action != 0) {
            if (this.V) {
                return true;
            }
            if (this.W) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.f0 = x;
            this.d0 = x;
            float y = motionEvent.getY();
            this.g0 = y;
            this.e0 = y;
            this.h0 = motionEvent.getPointerId(0);
            this.W = false;
            this.A = true;
            this.t.computeScrollOffset();
            if (this.C0 != 2 || Math.abs(this.t.getFinalX() - this.t.getCurrX()) <= this.m0) {
                f(false);
                this.V = false;
            } else {
                this.t.abortAnimation();
                this.Q = false;
                D();
                this.V = true;
                I(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.h0;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.d0;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.g0);
                if (f2 != 0.0f && !w(this.d0, f2) && e(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.d0 = x2;
                    this.e0 = y2;
                    this.W = true;
                    return false;
                }
                int i3 = this.c0;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.V = true;
                    I(true);
                    setScrollState(1);
                    float f3 = this.f0;
                    float f4 = this.c0;
                    this.d0 = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.e0 = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.W = true;
                }
                if (this.V && C(x2)) {
                    s0.T(this);
                }
            }
        } else if (action == 6) {
            y(motionEvent);
        }
        if (this.i0 == null) {
            this.i0 = VelocityTracker.obtain();
        }
        this.i0.addMovement(motionEvent);
        return this.V;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) throws Resources.NotFoundException {
        boolean z2;
        f fVarR;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a) {
                    int i10 = gVar.b;
                    int i11 = i10 & 7;
                    int i12 = i10 & 112;
                    if (i11 != 1) {
                        if (i11 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i11 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i12 == 16) {
                            if (i12 == 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i12 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i13 = paddingLeft + scrollX;
                            childAt.layout(i13, paddingTop, childAt.getMeasuredWidth() + i13, paddingTop + childAt.getMeasuredHeight());
                            i8++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i14 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i14;
                        int i132 = paddingLeft + scrollX;
                        childAt.layout(i132, paddingTop, childAt.getMeasuredWidth() + i132, paddingTop + childAt.getMeasuredHeight());
                        i8++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i15;
                    if (i12 == 16) {
                    }
                    int i142 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i142;
                    int i1322 = paddingLeft + scrollX;
                    childAt.layout(i1322, paddingTop, childAt.getMeasuredWidth() + i1322, paddingTop + childAt.getMeasuredHeight());
                    i8++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i16 = (i6 - paddingLeft) - paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.a && (fVarR = r(childAt2)) != null) {
                    float f2 = i16;
                    int i18 = ((int) (fVarR.e * f2)) + paddingLeft;
                    if (gVar2.d) {
                        gVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * gVar2.c), WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, WXVideoFileObject.FILE_SIZE_LIMIT));
                    }
                    childAt2.layout(i18, paddingTop, childAt2.getMeasuredWidth() + i18, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.H = paddingTop;
        this.I = i7 - paddingBottom;
        this.s0 = i8;
        if (this.q0) {
            z2 = false;
            K(this.f410h, false, 0, false);
        } else {
            z2 = false;
        }
        this.q0 = z2;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        g gVar;
        g gVar2;
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.b0 = Math.min(measuredWidth / 10, this.a0);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = WXVideoFileObject.FILE_SIZE_LIMIT;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.a) {
                int i7 = gVar2.b;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, WXVideoFileObject.FILE_SIZE_LIMIT);
        this.M = View.MeasureSpec.makeMeasureSpec(measuredHeight, WXVideoFileObject.FILE_SIZE_LIMIT);
        this.O = true;
        D();
        this.O = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.c), WXVideoFileObject.FILE_SIZE_LIMIT), this.M);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        f fVarR;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarR = r(childAt)) != null && fVarR.b == this.f410h && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.a());
        androidx.viewpager.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.l(mVar.f, mVar.g);
            L(mVar.e, false, true);
        } else {
            this.f411i = mVar.e;
            this.f412j = mVar.f;
            this.f413k = mVar.g;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.e = this.f410h;
        androidx.viewpager.widget.a aVar = this.g;
        if (aVar != null) {
            mVar.f = aVar.m();
        }
        return mVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.D;
            F(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar;
        if (this.n0) {
            return true;
        }
        boolean zJ = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.g) == null || aVar.d() == 0) {
            return false;
        }
        if (this.i0 == null) {
            this.i0 = VelocityTracker.obtain();
        }
        this.i0.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.t.abortAnimation();
            this.Q = false;
            D();
            float x = motionEvent.getX();
            this.f0 = x;
            this.d0 = x;
            float y = motionEvent.getY();
            this.g0 = y;
            this.e0 = y;
            this.h0 = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.d0 = motionEvent.getX(actionIndex);
                        this.h0 = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        y(motionEvent);
                        this.d0 = motionEvent.getX(motionEvent.findPointerIndex(this.h0));
                    }
                } else if (this.V) {
                    K(this.f410h, true, 0, false);
                    zJ = J();
                }
            } else if (!this.V) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.h0);
                if (iFindPointerIndex == -1) {
                    zJ = J();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x2 - this.d0);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y2 - this.e0);
                    if (fAbs > this.c0 && fAbs > fAbs2) {
                        this.V = true;
                        I(true);
                        float f2 = this.f0;
                        this.d0 = x2 - f2 > 0.0f ? f2 + this.c0 : f2 - this.c0;
                        this.e0 = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.V) {
                    }
                }
            } else if (this.V) {
                zJ = false | C(motionEvent.getX(motionEvent.findPointerIndex(this.h0)));
            }
        } else if (this.V) {
            VelocityTracker velocityTracker = this.i0;
            velocityTracker.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.k0);
            int xVelocity = (int) velocityTracker.getXVelocity(this.h0);
            this.Q = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarS = s();
            float f3 = clientWidth;
            M(h(fVarS.b, ((scrollX / f3) - fVarS.e) / (fVarS.d + (this.D / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.h0)) - this.f0)), true, true, xVelocity);
            zJ = J();
        }
        if (zJ) {
            s0.T(this);
        }
        return true;
    }

    f q(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return r(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f r(View view) {
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            f fVar = this.d.get(i2);
            if (this.g.i(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.O) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.p(null);
            this.g.r(this);
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                f fVar = this.d.get(i2);
                this.g.a(this, fVar.b, fVar.a);
            }
            this.g.c(this);
            this.d.clear();
            G();
            this.f410h = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.g;
        this.g = aVar;
        this.c = 0;
        if (aVar != null) {
            if (this.C == null) {
                this.C = new l();
            }
            this.g.p(this.C);
            this.Q = false;
            boolean z = this.q0;
            this.q0 = true;
            this.c = this.g.d();
            if (this.f411i >= 0) {
                this.g.l(this.f412j, this.f413k);
                L(this.f411i, false, true);
                this.f411i = -1;
                this.f412j = null;
                this.f413k = null;
            } else if (z) {
                requestLayout();
            } else {
                D();
            }
        }
        List<i> list = this.w0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.w0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.w0.get(i3).c(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.Q = false;
        L(i2, !this.q0, false);
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.U) {
            this.U = i2;
            D();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.u0 = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.D;
        this.D = i2;
        int width = getWidth();
        F(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.G = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, k kVar) throws Resources.NotFoundException {
        setPageTransformer(z, kVar, 2);
    }

    void setScrollState(int i2) {
        if (this.C0 == i2) {
            return;
        }
        this.C0 = i2;
        if (this.x0 != null) {
            m(i2 != 0);
        }
        k(i2);
    }

    f t(int i2) {
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            f fVar = this.d.get(i3);
            if (fVar.b == i2) {
                return fVar;
            }
        }
        return null;
    }

    void u() {
        setWillNotDraw(false);
        setDescendantFocusability(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
        setFocusable(true);
        Context context = getContext();
        this.t = new Scroller(context, F0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.c0 = viewConfiguration.getScaledPagingTouchSlop();
        this.j0 = (int) (400.0f * f2);
        this.k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.o0 = new EdgeEffect(context);
        this.p0 = new EdgeEffect(context);
        this.l0 = (int) (25.0f * f2);
        this.m0 = (int) (2.0f * f2);
        this.a0 = (int) (f2 * 16.0f);
        s0.Z(this, new h());
        if (s0.u(this) == 0) {
            s0.e0(this, 1);
        }
        s0.g0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.G;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void x(int i2, float f2, int i3) {
        int iMax;
        int width;
        int left;
        if (this.s0 > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a) {
                    int i5 = gVar.b & 7;
                    if (i5 != 1) {
                        if (i5 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i5 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i6 = iMax;
                    width = paddingLeft;
                    paddingLeft = i6;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = width;
                }
            }
        }
        i(i2, f2, i3);
        if (this.x0 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                if (!((g) childAt2.getLayoutParams()).a) {
                    this.x0.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.r0 = true;
    }

    boolean z() throws Resources.NotFoundException {
        int i2 = this.f410h;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    public static class g extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public g() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.D0);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, k kVar, int i2) throws Resources.NotFoundException {
        boolean z2 = kVar != null;
        boolean z3 = z2 != (this.x0 != null);
        this.x0 = kVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.z0 = z ? 2 : 1;
            this.y0 = i2;
        } else {
            this.z0 = 0;
        }
        if (z3) {
            D();
        }
    }

    public void setCurrentItem(int i2, boolean z) throws Resources.NotFoundException {
        this.Q = false;
        L(i2, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.a.e(getContext(), i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = new f();
        this.f = new Rect();
        this.f411i = -1;
        this.f412j = null;
        this.f413k = null;
        this.J = -3.4028235E38f;
        this.K = Float.MAX_VALUE;
        this.U = 1;
        this.h0 = -1;
        this.q0 = true;
        this.B0 = new c();
        this.C0 = 0;
        u();
    }
}
