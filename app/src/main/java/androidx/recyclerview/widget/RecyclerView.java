package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b0;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.n1;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.q1.e;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements h.e.j.u {
    private static final int[] W0 = {R.attr.nestedScrollingEnabled};
    static final boolean X0;
    static final boolean Y0;
    static final boolean Z0;
    static final boolean a1;
    private static final boolean b1;
    private static final boolean c1;
    private static final Class<?>[] d1;
    static final Interpolator e1;
    final RectF A;
    private float A0;
    private boolean B0;
    g C;
    final c0 C0;
    o D;
    androidx.recyclerview.widget.b0 D0;
    b0.a E0;
    final a0 F0;
    w G;
    private t G0;
    final ArrayList<n> H;
    private List<t> H0;
    private final ArrayList<s> I;
    boolean I0;
    private s J;
    boolean J0;
    boolean K;
    private l.a K0;
    boolean L0;
    boolean M;
    e1 M0;
    private j N0;
    boolean O;
    private final int[] O0;
    boolean P;
    private h.e.j.v P0;
    private int Q;
    private final int[] Q0;
    private final int[] R0;
    final int[] S0;
    final List<d0> T0;
    boolean U;
    private Runnable U0;
    boolean V;
    private final n1.a V0;
    private boolean W;
    private int a0;
    boolean b0;
    private final x c;
    private final AccessibilityManager c0;
    final v d;
    private List<q> d0;
    private y e;
    boolean e0;
    androidx.recyclerview.widget.a f;
    boolean f0;
    androidx.recyclerview.widget.e g;
    private int g0;

    /* renamed from: h, reason: collision with root package name */
    final n1 f322h;
    private int h0;

    /* renamed from: i, reason: collision with root package name */
    boolean f323i;
    private k i0;

    /* renamed from: j, reason: collision with root package name */
    final Runnable f324j;
    private EdgeEffect j0;

    /* renamed from: k, reason: collision with root package name */
    final Rect f325k;
    private EdgeEffect k0;
    private EdgeEffect l0;
    private EdgeEffect m0;
    l n0;
    private int o0;
    private int p0;
    private VelocityTracker q0;
    private int r0;
    private int s0;
    private final Rect t;
    private int t0;
    private int u0;
    private int v0;
    private r w0;
    private final int x0;
    private final int y0;
    private float z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.P || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.K) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.V) {
                recyclerView2.U = true;
            } else {
                recyclerView2.u();
            }
        }
    }

    public static class a0 {
        private SparseArray<Object> b;

        /* renamed from: m, reason: collision with root package name */
        int f331m;

        /* renamed from: n, reason: collision with root package name */
        long f332n;

        /* renamed from: o, reason: collision with root package name */
        int f333o;
        int p;
        int q;
        int a = -1;
        int c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f326h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f327i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f328j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f329k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f330l = false;

        void a(int i2) {
            if ((this.e & i2) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.e));
        }

        public int b() {
            return this.f326h ? this.c - this.d : this.f;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public boolean e() {
            return this.f326h;
        }

        void f(g gVar) {
            this.e = 1;
            this.f = gVar.getItemCount();
            this.f326h = false;
            this.f327i = false;
            this.f328j = false;
        }

        public boolean g() {
            return this.f330l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.f328j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.f326h + ", mRunSimpleAnimations=" + this.f329k + ", mRunPredictiveAnimations=" + this.f330l + '}';
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.n0;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.L0 = false;
        }
    }

    public static abstract class b0 {
        public abstract View a(v vVar, int i2, int i3);
    }

    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class c0 implements Runnable {
        private int c;
        private int d;
        OverScroller e;
        Interpolator f;
        private boolean g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f334h;

        c0() {
            Interpolator interpolator = RecyclerView.e1;
            this.f = interpolator;
            this.g = false;
            this.f334h = false;
            this.e = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3, int i4, int i5) {
            int iRound;
            int iAbs = Math.abs(i2);
            int iAbs2 = Math.abs(i3);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            int iSqrt2 = (int) Math.sqrt((i2 * i2) + (i3 * i3));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float fB = f2 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, XmlValidationError.LIST_INVALID);
        }

        private float b(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            h.e.j.s0.U(RecyclerView.this, this);
        }

        public void c(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.d = 0;
            this.c = 0;
            Interpolator interpolator = this.f;
            Interpolator interpolator2 = RecyclerView.e1;
            if (interpolator != interpolator2) {
                this.f = interpolator2;
                this.e = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.e.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.g) {
                this.f334h = true;
            } else {
                d();
            }
        }

        public void f(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3, 0, 0);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.e1;
            }
            if (this.f != interpolator) {
                this.f = interpolator;
                this.e = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.d = 0;
            this.c = 0;
            RecyclerView.this.setScrollState(2);
            this.e.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.e.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.e.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.D == null) {
                g();
                return;
            }
            this.f334h = false;
            this.g = true;
            recyclerView.u();
            OverScroller overScroller = this.e;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.c;
                int i6 = currY - this.d;
                this.c = currX;
                this.d = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.S0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.F(i5, i6, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.S0;
                    i5 -= iArr2[0];
                    i6 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.t(i5, i6);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.C != null) {
                    int[] iArr3 = recyclerView3.S0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.i1(i5, i6, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.S0;
                    int i7 = iArr4[0];
                    int i8 = iArr4[1];
                    int i9 = i5 - i7;
                    i6 -= i8;
                    z zVar = recyclerView4.D.g;
                    if (zVar != null && !zVar.b() && zVar.c()) {
                        int iB = RecyclerView.this.F0.b();
                        if (iB == 0) {
                            zVar.g();
                            throw null;
                        }
                        if (zVar.a() >= iB) {
                            zVar.f(iB - 1);
                            zVar.d(i7, i8);
                        } else {
                            zVar.d(i7, i8);
                        }
                    }
                    i4 = i9;
                    i2 = i8;
                    i3 = i7;
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = i5;
                }
                int i10 = i6;
                if (!RecyclerView.this.H.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.S0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.G(i3, i2, i4, i10, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.S0;
                int i11 = i4 - iArr6[0];
                int i12 = i10 - iArr6[1];
                if (i3 != 0 || i2 != 0) {
                    recyclerView6.I(i3, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
                z zVar2 = RecyclerView.this.D.g;
                if ((zVar2 != null && zVar2.b()) || !z) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.b0 b0Var = recyclerView7.D0;
                    if (b0Var != null) {
                        b0Var.f(recyclerView7, i3, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i13, currVelocity);
                    }
                    if (RecyclerView.a1) {
                        RecyclerView.this.E0.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.D.g;
            if (zVar3 != null && zVar3.b()) {
                zVar3.d(0, 0);
            }
            this.g = false;
            if (this.f334h) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.u1(1);
            }
        }
    }

    class d implements n1.a {
        d() {
        }

        @Override // androidx.recyclerview.widget.n1.a
        public void a(d0 d0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.l(d0Var, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.n1.a
        public void b(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.D.k1(d0Var.itemView, recyclerView.d);
        }

        @Override // androidx.recyclerview.widget.n1.a
        public void c(d0 d0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.d.J(d0Var);
            RecyclerView.this.n(d0Var, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.n1.a
        public void d(d0 d0Var, l.b bVar, l.b bVar2) {
            d0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.e0) {
                if (recyclerView.n0.b(d0Var, d0Var, bVar, bVar2)) {
                    RecyclerView.this.N0();
                }
            } else if (recyclerView.n0.d(d0Var, bVar, bVar2)) {
                RecyclerView.this.N0();
            }
        }
    }

    public static abstract class d0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        d0 mShadowedHolder = null;
        d0 mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        v mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void a() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                a();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && h.e.j.s0.H(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i2, int i3, boolean z) {
            addFlags(8);
            offsetPosition(i3, z);
            this.mPosition = i2;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d0(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !h.e.j.s0.H(this.itemView);
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i2, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((p) this.itemView.getLayoutParams()).c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i2;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = h.e.j.s0.u(this.itemView);
            }
            recyclerView.l1(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.l1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.r(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
        }

        public final void setIsRecyclable(boolean z) {
            int i2 = this.mIsRecyclableCount;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.mIsRecyclableCount = i3;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                this.mFlags |= 16;
            } else if (z && i3 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(v vVar, boolean z) {
            this.mScrapContainer = vVar;
            this.mInChangeScrap = z;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void unScrap() {
            this.mScrapContainer.J(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    class e implements e.a {
        e() {
        }

        @Override // androidx.recyclerview.widget.e.a
        public View a(int i2) {
            return RecyclerView.this.getChildAt(i2);
        }

        @Override // androidx.recyclerview.widget.e.a
        public void b(View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0 != null) {
                d0VarH0.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.a
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.e.a
        public d0 d(View view) {
            return RecyclerView.h0(view);
        }

        @Override // androidx.recyclerview.widget.e.a
        public void e(View view, int i2) {
            RecyclerView.this.addView(view, i2);
            RecyclerView.this.y(view);
        }

        @Override // androidx.recyclerview.widget.e.a
        public void f() {
            int iC = c();
            for (int i2 = 0; i2 < iC; i2++) {
                View viewA = a(i2);
                RecyclerView.this.z(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.e.a
        public void g(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0 != null) {
                if (!d0VarH0.isTmpDetached() && !d0VarH0.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + d0VarH0 + RecyclerView.this.P());
                }
                d0VarH0.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
        }

        @Override // androidx.recyclerview.widget.e.a
        public void h(int i2) {
            d0 d0VarH0;
            View viewA = a(i2);
            if (viewA != null && (d0VarH0 = RecyclerView.h0(viewA)) != null) {
                if (d0VarH0.isTmpDetached() && !d0VarH0.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + d0VarH0 + RecyclerView.this.P());
                }
                d0VarH0.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i2);
        }

        @Override // androidx.recyclerview.widget.e.a
        public int i(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.e.a
        public void j(View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0 != null) {
                d0VarH0.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.e.a
        public void k(int i2) {
            View childAt = RecyclerView.this.getChildAt(i2);
            if (childAt != null) {
                RecyclerView.this.z(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i2);
        }
    }

    class f implements a.InterfaceC0002a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void a(int i2, int i3) {
            RecyclerView.this.D0(i2, i3);
            RecyclerView.this.I0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void c(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public d0 d(int i2) {
            d0 d0VarB0 = RecyclerView.this.b0(i2, true);
            if (d0VarB0 == null || RecyclerView.this.g.n(d0VarB0.itemView)) {
                return null;
            }
            return d0VarB0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void e(int i2, int i3) {
            RecyclerView.this.C0(i2, i3);
            RecyclerView.this.I0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void f(int i2, int i3) {
            RecyclerView.this.E0(i2, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.I0 = true;
            recyclerView.F0.d += i3;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void g(int i2, int i3) {
            RecyclerView.this.E0(i2, i3, false);
            RecyclerView.this.I0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0002a
        public void h(int i2, int i3, Object obj) {
            RecyclerView.this.x1(i2, i3, obj);
            RecyclerView.this.J0 = true;
        }

        void i(a.b bVar) {
            int i2 = bVar.a;
            if (i2 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.D.Q0(recyclerView, bVar.b, bVar.d);
                return;
            }
            if (i2 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.D.T0(recyclerView2, bVar.b, bVar.d);
            } else if (i2 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.D.V0(recyclerView3, bVar.b, bVar.d, bVar.c);
            } else {
                if (i2 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.D.S0(recyclerView4, bVar.b, bVar.d, 1);
            }
        }
    }

    public static abstract class g<VH extends d0> {
        private final h mObservable = new h();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh, int i2) {
            vh.mPosition = i2;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i2);
            }
            vh.setFlags(1, 519);
            h.e.f.d.a("RV OnBindView");
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).c = true;
            }
            h.e.f.d.b();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                h.e.f.d.a("RV CreateView");
                VH vh = (VH) onCreateViewHolder(viewGroup, i2);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i2;
                return vh;
            } finally {
                h.e.f.d.b();
            }
        }

        public abstract int getItemCount();

        public abstract long getItemId(int i2);

        public int getItemViewType(int i2) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.d(i2, 1);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.f(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.f(i2, i3);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.g(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.g(i2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.e(i2, 1, obj);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.e(i2, i3, obj);
        }
    }

    static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i2, i3, 1);
            }
        }

        public void d(int i2, int i3) {
            e(i2, i3, null);
        }

        public void e(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i2, i3, obj);
            }
        }

        public void f(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i2, i3);
            }
        }

        public void g(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i2, i3);
            }
        }
    }

    public static abstract class i {
        public abstract void a();

        public abstract void b(int i2, int i3, Object obj);

        public abstract void c(int i2, int i3);

        public abstract void d(int i2, int i3, int i4);

        public abstract void e(int i2, int i3);
    }

    public interface j {
        int a(int i2, int i3);
    }

    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {
        private a a = null;
        private ArrayList<y0> b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        interface a {
            void a(d0 d0Var);
        }

        public static class b {
            public int a;
            public int b;

            public b a(d0 d0Var) {
                b(d0Var, 0);
                return this;
            }

            public b b(d0 d0Var, int i2) {
                View view = d0Var.itemView;
                this.a = view.getLeft();
                this.b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i2 = d0Var.mFlags & 14;
            if (d0Var.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int oldPosition = d0Var.getOldPosition();
            int adapterPosition = d0Var.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i2 : i2 | 2048;
        }

        public abstract boolean a(d0 d0Var, b bVar, b bVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, b bVar, b bVar2);

        public abstract boolean c(d0 d0Var, b bVar, b bVar2);

        public abstract boolean d(d0 d0Var, b bVar, b bVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            s(d0Var);
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.b.get(i2).a();
            }
            this.b.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.c;
        }

        public long m() {
            return this.f;
        }

        public long n() {
            return this.e;
        }

        public long o() {
            return this.d;
        }

        public abstract boolean p();

        public final boolean q(y0 y0Var) {
            boolean zP = p();
            if (y0Var != null) {
                if (zP) {
                    this.b.add(y0Var);
                } else {
                    y0Var.a();
                }
            }
            return zP;
        }

        public b r() {
            return new b();
        }

        public void s(d0 d0Var) {
        }

        public b t(a0 a0Var, d0 d0Var) {
            b bVarR = r();
            bVarR.a(d0Var);
            return bVarR;
        }

        public b u(a0 a0Var, d0 d0Var, int i2, List<Object> list) {
            b bVarR = r();
            bVarR.a(d0Var);
            return bVarR;
        }

        public abstract void v();

        void w(a aVar) {
            this.a = aVar;
        }
    }

    private class m implements l.a {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(d0 d0Var) {
            d0Var.setIsRecyclable(true);
            if (d0Var.mShadowedHolder != null && d0Var.mShadowingHolder == null) {
                d0Var.mShadowedHolder = null;
            }
            d0Var.mShadowingHolder = null;
            if (d0Var.shouldBeKeptAsChild() || RecyclerView.this.W0(d0Var.itemView) || !d0Var.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.itemView, false);
        }
    }

    public static abstract class n {
        @Deprecated
        public void c(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void d(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            c(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void e(Canvas canvas, RecyclerView recyclerView) {
        }

        public void f(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            e(canvas, recyclerView);
        }

        @Deprecated
        public void g(Canvas canvas, RecyclerView recyclerView) {
        }

        public void h(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            g(canvas, recyclerView);
        }
    }

    public static abstract class o {
        androidx.recyclerview.widget.e a;
        RecyclerView b;
        private final k1 c;
        private final k1 d;
        l1 e;
        l1 f;
        z g;

        /* renamed from: h, reason: collision with root package name */
        boolean f336h;

        /* renamed from: i, reason: collision with root package name */
        boolean f337i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f338j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f339k;

        /* renamed from: l, reason: collision with root package name */
        int f340l;

        /* renamed from: m, reason: collision with root package name */
        boolean f341m;

        /* renamed from: n, reason: collision with root package name */
        private int f342n;

        /* renamed from: o, reason: collision with root package name */
        private int f343o;
        private int p;
        private int q;

        public interface a {
            void a(int i2, int i3);
        }

        public static class b {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public o() {
            z0 z0Var = new z0(this);
            this.c = z0Var;
            a1 a1Var = new a1(this);
            this.d = a1Var;
            this.e = new l1(z0Var);
            this.f = new l1(a1Var);
            this.f336h = false;
            this.f337i = false;
            this.f338j = true;
            this.f339k = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int K(int i2, int i3, int i4, int i5, boolean z) {
            int iMax = Math.max(0, i2 - i4);
            if (z) {
                if (i5 < 0) {
                    if (i5 != -1 || (i3 != Integer.MIN_VALUE && (i3 == 0 || i3 != 1073741824))) {
                        i3 = 0;
                        i5 = 0;
                    } else {
                        i5 = iMax;
                    }
                }
                i3 = 1073741824;
            } else if (i5 >= 0) {
                i3 = 1073741824;
            } else if (i5 != -1) {
                if (i5 == -2) {
                    if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                        i5 = iMax;
                        i3 = Integer.MIN_VALUE;
                    } else {
                        i5 = iMax;
                        i3 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i5, i3);
        }

        private int[] L(View view, Rect rect) {
            int[] iArr = new int[2];
            int iD0 = d0();
            int iF0 = f0();
            int iN0 = n0() - e0();
            int iW = W() - c0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i2 = left - iD0;
            int iMin = Math.min(0, i2);
            int i3 = top - iF0;
            int iMin2 = Math.min(0, i3);
            int i4 = iWidth - iN0;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, iHeight - iW);
            if (Y() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i2, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i4);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i3, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        private void f(View view, int i2, boolean z) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (z || d0VarH0.isRemoved()) {
                this.b.f322h.b(d0VarH0);
            } else {
                this.b.f322h.p(d0VarH0);
            }
            p pVar = (p) view.getLayoutParams();
            if (d0VarH0.wasReturnedFromScrap() || d0VarH0.isScrap()) {
                if (d0VarH0.isScrap()) {
                    d0VarH0.unScrap();
                } else {
                    d0VarH0.clearReturnedFromScrapFlag();
                }
                this.a.c(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int iM = this.a.m(view);
                if (i2 == -1) {
                    i2 = this.a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.P());
                }
                if (iM != i2) {
                    this.b.D.A0(iM, i2);
                }
            } else {
                this.a.a(view, i2, false);
                pVar.c = true;
                z zVar = this.g;
                if (zVar != null && zVar.c()) {
                    this.g.e(view);
                }
            }
            if (pVar.d) {
                d0VarH0.itemView.invalidate();
                pVar.d = false;
            }
        }

        public static b h0(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.n.d.a, i2, i3);
            bVar.a = typedArrayObtainStyledAttributes.getInt(h.n.d.b, 1);
            bVar.b = typedArrayObtainStyledAttributes.getInt(h.n.d.f1346l, 1);
            bVar.c = typedArrayObtainStyledAttributes.getBoolean(h.n.d.f1345k, false);
            bVar.d = typedArrayObtainStyledAttributes.getBoolean(h.n.d.f1347m, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        public static int n(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        private boolean s0(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iD0 = d0();
            int iF0 = f0();
            int iN0 = n0() - e0();
            int iW = W() - c0();
            Rect rect = this.b.f325k;
            P(focusedChild, rect);
            return rect.left - i2 < iN0 && rect.right - i2 > iD0 && rect.top - i3 < iW && rect.bottom - i3 > iF0;
        }

        private void t1(v vVar, int i2, View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0.shouldIgnore()) {
                return;
            }
            if (d0VarH0.isInvalid() && !d0VarH0.isRemoved() && !this.b.C.hasStableIds()) {
                o1(i2);
                vVar.C(d0VarH0);
            } else {
                x(i2);
                vVar.D(view);
                this.b.f322h.k(d0VarH0);
            }
        }

        private static boolean v0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private void y(int i2, View view) {
            this.a.d(i2);
        }

        void A(RecyclerView recyclerView, v vVar) {
            this.f337i = false;
            H0(recyclerView, vVar);
        }

        public void A0(int i2, int i3) {
            View viewI = I(i2);
            if (viewI != null) {
                x(i2);
                h(viewI, i3);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.b.toString());
            }
        }

        public void A1(Rect rect, int i2, int i3) {
            z1(n(i2, rect.width() + d0() + e0(), b0()), n(i3, rect.height() + f0() + c0(), a0()));
        }

        public View B(View view) {
            View viewS;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (viewS = recyclerView.S(view)) == null || this.a.n(viewS)) {
                return null;
            }
            return viewS;
        }

        public void B0(int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.A0(i2);
            }
        }

        void B1(int i2, int i3) {
            int iJ = J();
            if (iJ == 0) {
                this.b.w(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < iJ; i8++) {
                View viewI = I(i8);
                Rect rect = this.b.f325k;
                P(viewI, rect);
                int i9 = rect.left;
                if (i9 < i5) {
                    i5 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i6) {
                    i6 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.b.f325k.set(i5, i6, i4, i7);
            A1(this.b.f325k, i2, i3);
        }

        public View C(int i2) {
            int iJ = J();
            for (int i3 = 0; i3 < iJ; i3++) {
                View viewI = I(i3);
                d0 d0VarH0 = RecyclerView.h0(viewI);
                if (d0VarH0 != null && d0VarH0.getLayoutPosition() == i2 && !d0VarH0.shouldIgnore() && (this.b.F0.e() || !d0VarH0.isRemoved())) {
                    return viewI;
                }
            }
            return null;
        }

        public void C0(int i2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.B0(i2);
            }
        }

        void C1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                this.p = 0;
                this.q = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.g;
                this.p = recyclerView.getWidth();
                this.q = recyclerView.getHeight();
            }
            this.f342n = WXVideoFileObject.FILE_SIZE_LIMIT;
            this.f343o = WXVideoFileObject.FILE_SIZE_LIMIT;
        }

        public abstract p D();

        public void D0(g gVar, g gVar2) {
        }

        boolean D1(View view, int i2, int i3, p pVar) {
            return (!view.isLayoutRequested() && this.f338j && v0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && v0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public boolean E0(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        boolean E1() {
            return false;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void F0(RecyclerView recyclerView) {
        }

        boolean F1(View view, int i2, int i3, p pVar) {
            return (this.f338j && v0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && v0(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        @Deprecated
        public void G0(RecyclerView recyclerView) {
        }

        void G1() {
            z zVar = this.g;
            if (zVar != null) {
                zVar.g();
            }
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).b.bottom;
        }

        public void H0(RecyclerView recyclerView, v vVar) {
            G0(recyclerView);
        }

        public abstract boolean H1();

        public View I(int i2) {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.f(i2);
            }
            return null;
        }

        public abstract View I0(View view, int i2, v vVar, a0 a0Var);

        public int J() {
            androidx.recyclerview.widget.e eVar = this.a;
            if (eVar != null) {
                return eVar.g();
            }
            return 0;
        }

        public void J0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            K0(recyclerView.d, recyclerView.F0, accessibilityEvent);
        }

        public void K0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.b.C;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.getItemCount());
            }
        }

        void L0(h.e.j.q1.e eVar) {
            RecyclerView recyclerView = this.b;
            M0(recyclerView.d, recyclerView.F0, eVar);
        }

        public boolean M() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.f323i;
        }

        public void M0(v vVar, a0 a0Var, h.e.j.q1.e eVar) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                eVar.a(XMLEvent.ENTITY_REFERENCE);
                eVar.i0(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                eVar.a(XMLEvent.CHANGE_PREFIX_MAPPING);
                eVar.i0(true);
            }
            eVar.W(h.e.j.q1.d.a(j0(vVar, a0Var), N(vVar, a0Var), u0(vVar, a0Var), k0(vVar, a0Var)));
        }

        public int N(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.C == null || !k()) {
                return 1;
            }
            return this.b.C.getItemCount();
        }

        void N0(View view, h.e.j.q1.e eVar) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0 == null || d0VarH0.isRemoved() || this.a.n(d0VarH0.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.b;
            O0(recyclerView.d, recyclerView.F0, view, eVar);
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        public void O0(v vVar, a0 a0Var, View view, h.e.j.q1.e eVar) {
            eVar.X(e.a.f(l() ? g0(view) : 0, 1, k() ? g0(view) : 0, 1, false, false));
        }

        public void P(View view, Rect rect) {
            RecyclerView.i0(view, rect);
        }

        public View P0(View view, int i2) {
            return null;
        }

        public int Q(View view) {
            return view.getLeft() - Z(view);
        }

        public void Q0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int T(View view) {
            return view.getRight() + i0(view);
        }

        public void T0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int U(View view) {
            return view.getTop() - l0(view);
        }

        public void U0(RecyclerView recyclerView, int i2, int i3) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            U0(recyclerView, i2, i3);
        }

        public int W() {
            return this.q;
        }

        public abstract void W0(v vVar, a0 a0Var);

        public int X() {
            return this.f343o;
        }

        public void X0(a0 a0Var) {
        }

        public int Y() {
            return h.e.j.s0.w(this.b);
        }

        public void Y0(v vVar, a0 a0Var, int i2, int i3) {
            this.b.w(i2, i3);
        }

        public int Z(View view) {
            return ((p) view.getLayoutParams()).b.left;
        }

        @Deprecated
        public boolean Z0(RecyclerView recyclerView, View view, View view2) {
            return w0() || recyclerView.w0();
        }

        public int a0() {
            return h.e.j.s0.x(this.b);
        }

        public boolean a1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return Z0(recyclerView, view, view2);
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return h.e.j.s0.y(this.b);
        }

        public abstract void b1(Parcelable parcelable);

        public void c(View view, int i2) {
            f(view, i2, true);
        }

        public int c0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract Parcelable c1();

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void d1(int i2) {
        }

        public void e(View view, int i2) {
            f(view, i2, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        boolean e1(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return f1(recyclerView.d, recyclerView.F0, i2, bundle);
        }

        public int f0() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean f1(v vVar, a0 a0Var, int i2, Bundle bundle) {
            int iW;
            int iN0;
            int i3;
            int i4;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 == 4096) {
                iW = recyclerView.canScrollVertically(1) ? (W() - f0()) - c0() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    iN0 = (n0() - d0()) - e0();
                    i3 = iW;
                    i4 = iN0;
                }
                i3 = iW;
                i4 = 0;
            } else if (i2 != 8192) {
                i4 = 0;
                i3 = 0;
            } else {
                iW = recyclerView.canScrollVertically(-1) ? -((W() - f0()) - c0()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    iN0 = -((n0() - d0()) - e0());
                    i3 = iW;
                    i4 = iN0;
                }
                i3 = iW;
                i4 = 0;
            }
            if (i3 == 0 && i4 == 0) {
                return false;
            }
            this.b.q1(i4, i3, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void g(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.o(str);
            }
        }

        public int g0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        boolean g1(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return h1(recyclerView.d, recyclerView.F0, view, i2, bundle);
        }

        public void h(View view, int i2) {
            i(view, i2, (p) view.getLayoutParams());
        }

        public boolean h1(v vVar, a0 a0Var, View view, int i2, Bundle bundle) {
            return false;
        }

        public void i(View view, int i2, p pVar) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0.isRemoved()) {
                this.b.f322h.b(d0VarH0);
            } else {
                this.b.f322h.p(d0VarH0);
            }
            this.a.c(view, i2, pVar, d0VarH0.isRemoved());
        }

        public int i0(View view) {
            return ((p) view.getLayoutParams()).b.right;
        }

        public void i1(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                if (!RecyclerView.h0(I(iJ)).shouldIgnore()) {
                    l1(iJ, vVar);
                }
            }
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.l0(view));
            }
        }

        public int j0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.C == null || !l()) {
                return 1;
            }
            return this.b.C.getItemCount();
        }

        void j1(v vVar) {
            int iJ = vVar.j();
            for (int i2 = iJ - 1; i2 >= 0; i2--) {
                View viewN = vVar.n(i2);
                d0 d0VarH0 = RecyclerView.h0(viewN);
                if (!d0VarH0.shouldIgnore()) {
                    d0VarH0.setIsRecyclable(false);
                    if (d0VarH0.isTmpDetached()) {
                        this.b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.b.n0;
                    if (lVar != null) {
                        lVar.j(d0VarH0);
                    }
                    d0VarH0.setIsRecyclable(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.b.invalidate();
            }
        }

        public abstract boolean k();

        public int k0(v vVar, a0 a0Var) {
            return 0;
        }

        public void k1(View view, v vVar) {
            n1(view);
            vVar.B(view);
        }

        public abstract boolean l();

        public int l0(View view) {
            return ((p) view.getLayoutParams()).b.top;
        }

        public void l1(int i2, v vVar) {
            View viewI = I(i2);
            o1(i2);
            vVar.B(viewI);
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public void m0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.A;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean m1(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int n0() {
            return this.p;
        }

        public void n1(View view) {
            this.a.p(view);
        }

        public abstract void o(int i2, int i3, a0 a0Var, a aVar);

        public int o0() {
            return this.f342n;
        }

        public void o1(int i2) {
            if (I(i2) != null) {
                this.a.q(i2);
            }
        }

        public void p(int i2, a aVar) {
        }

        boolean p0() {
            int iJ = J();
            for (int i2 = 0; i2 < iJ; i2++) {
                ViewGroup.LayoutParams layoutParams = I(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean p1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return q1(recyclerView, view, rect, z, false);
        }

        public abstract int q(a0 a0Var);

        public boolean q0() {
            return this.f337i;
        }

        public boolean q1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrL = L(view, rect);
            int i2 = iArrL[0];
            int i3 = iArrL[1];
            if ((z2 && !s0(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.n1(i2, i3);
            }
            return true;
        }

        public abstract int r(a0 a0Var);

        public abstract boolean r0();

        public void r1() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int s(a0 a0Var);

        public void s1() {
            this.f336h = true;
        }

        public abstract int t(a0 a0Var);

        public final boolean t0() {
            return this.f339k;
        }

        public abstract int u(a0 a0Var);

        public boolean u0(v vVar, a0 a0Var) {
            return false;
        }

        public abstract int u1(int i2, v vVar, a0 a0Var);

        public abstract int v(a0 a0Var);

        public abstract void v1(int i2);

        public void w(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                t1(vVar, iJ, I(iJ));
            }
        }

        public boolean w0() {
            z zVar = this.g;
            return zVar != null && zVar.c();
        }

        public abstract int w1(int i2, v vVar, a0 a0Var);

        public void x(int i2) {
            y(i2, I(i2));
        }

        public boolean x0(View view, boolean z, boolean z2) {
            boolean z3 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z3 : !z3;
        }

        void x1(RecyclerView recyclerView) {
            y1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), WXVideoFileObject.FILE_SIZE_LIMIT));
        }

        public void y0(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void y1(int i2, int i3) {
            this.p = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.f342n = mode;
            if (mode == 0 && !RecyclerView.Y0) {
                this.p = 0;
            }
            this.q = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f343o = mode2;
            if (mode2 != 0 || RecyclerView.Y0) {
                return;
            }
            this.q = 0;
        }

        void z(RecyclerView recyclerView) {
            this.f337i = true;
            F0(recyclerView);
        }

        public void z0(View view, int i2, int i3) {
            p pVar = (p) view.getLayoutParams();
            Rect rectL0 = this.b.l0(view);
            int i4 = i2 + rectL0.left + rectL0.right;
            int i5 = i3 + rectL0.top + rectL0.bottom;
            int iK = K(n0(), o0(), d0() + e0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int iK2 = K(W(), X(), f0() + c0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (D1(view, iK, iK2, pVar)) {
                view.measure(iK, iK2);
            }
        }

        public void z1(int i2, int i3) {
            this.b.setMeasuredDimension(i2, i3);
        }
    }

    public interface q {
        void a(View view);

        void b(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i2, int i3);
    }

    public interface s {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public abstract void b(RecyclerView recyclerView, int i2, int i3);
    }

    public static class u {
        SparseArray<b1> a = new SparseArray<>();
        private int b = 0;

        private b1 g(int i2) {
            b1 b1Var = this.a.get(i2);
            if (b1Var != null) {
                return b1Var;
            }
            b1 b1Var2 = new b1();
            this.a.put(i2, b1Var2);
            return b1Var2;
        }

        void a() {
            this.b++;
        }

        public void b() {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                this.a.valueAt(i2).a.clear();
            }
        }

        void c() {
            this.b--;
        }

        void d(int i2, long j2) {
            b1 b1VarG = g(i2);
            b1VarG.d = j(b1VarG.d, j2);
        }

        void e(int i2, long j2) {
            b1 b1VarG = g(i2);
            b1VarG.c = j(b1VarG.c, j2);
        }

        public d0 f(int i2) {
            b1 b1Var = this.a.get(i2);
            if (b1Var == null || b1Var.a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = b1Var.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int itemViewType = d0Var.getItemViewType();
            ArrayList<d0> arrayList = g(itemViewType).a;
            if (this.a.get(itemViewType).b <= arrayList.size()) {
                return;
            }
            d0Var.resetInternal();
            arrayList.add(d0Var);
        }

        long j(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        boolean k(int i2, long j2, long j3) {
            long j4 = g(i2).d;
            return j4 == 0 || j2 + j4 < j3;
        }

        boolean l(int i2, long j2, long j3) {
            long j4 = g(i2).c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    public final class v {
        final ArrayList<d0> a;
        ArrayList<d0> b;
        final ArrayList<d0> c;
        private final List<d0> d;
        private int e;
        int f;
        u g;

        /* renamed from: h, reason: collision with root package name */
        private b0 f344h;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.b = null;
            this.c = new ArrayList<>();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        private boolean H(d0 d0Var, int i2, int i3, long j2) {
            d0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = d0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.g.k(itemViewType, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.C.bindViewHolder(d0Var, i2);
            this.g.d(d0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.F0.e()) {
                return true;
            }
            d0Var.mPreLayoutPosition = i3;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.v0()) {
                View view = d0Var.itemView;
                if (h.e.j.s0.u(view) == 0) {
                    h.e.j.s0.e0(view, 1);
                }
                e1 e1Var = RecyclerView.this.M0;
                if (e1Var == null) {
                    return;
                }
                h.e.j.b bVarN = e1Var.n();
                if (bVarN instanceof d1) {
                    ((d1) bVarN).o(view);
                }
                h.e.j.s0.Z(view, bVarN);
            }
        }

        private void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i2) {
            a(this.c.get(i2), true);
            this.c.remove(i2);
        }

        public void B(View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (d0VarH0.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d0VarH0.isScrap()) {
                d0VarH0.unScrap();
            } else if (d0VarH0.wasReturnedFromScrap()) {
                d0VarH0.clearReturnedFromScrapFlag();
            }
            C(d0VarH0);
            if (RecyclerView.this.n0 == null || d0VarH0.isRecyclable()) {
                return;
            }
            RecyclerView.this.n0.j(d0VarH0);
        }

        void C(d0 d0Var) {
            boolean z;
            boolean z2 = true;
            if (d0Var.isScrap() || d0Var.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.isScrap());
                sb.append(" isAttached:");
                sb.append(d0Var.itemView.getParent() != null);
                sb.append(RecyclerView.this.P());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.P());
            }
            if (d0Var.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.P());
            }
            boolean zDoesTransientStatePreventRecycling = d0Var.doesTransientStatePreventRecycling();
            g gVar = RecyclerView.this.C;
            if ((gVar != null && zDoesTransientStatePreventRecycling && gVar.onFailedToRecycleView(d0Var)) || d0Var.isRecyclable()) {
                if (this.f <= 0 || d0Var.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.a1 && size > 0 && !RecyclerView.this.E0.d(d0Var.mPosition)) {
                        int i2 = size - 1;
                        while (i2 >= 0) {
                            if (!RecyclerView.this.E0.d(this.c.get(i2).mPosition)) {
                                break;
                            } else {
                                i2--;
                            }
                        }
                        size = i2 + 1;
                    }
                    this.c.add(size, d0Var);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    a(d0Var, true);
                }
                z = z;
            } else {
                z2 = false;
            }
            RecyclerView.this.f322h.q(d0Var);
            if (z || z2 || !zDoesTransientStatePreventRecycling) {
                return;
            }
            d0Var.mOwnerRecyclerView = null;
        }

        void D(View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            if (!d0VarH0.hasAnyOfTheFlags(12) && d0VarH0.isUpdated() && !RecyclerView.this.p(d0VarH0)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                d0VarH0.setScrapContainer(this, true);
                this.b.add(d0VarH0);
                return;
            }
            if (!d0VarH0.isInvalid() || d0VarH0.isRemoved() || RecyclerView.this.C.hasStableIds()) {
                d0VarH0.setScrapContainer(this, false);
                this.a.add(d0VarH0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.P());
            }
        }

        void E(u uVar) {
            u uVar2 = this.g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }

        void F(b0 b0Var) {
        }

        public void G(int i2) {
            this.e = i2;
            K();
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0181 A[PHI: r1 r4
          0x0181: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$d0) = (r1v11 androidx.recyclerview.widget.RecyclerView$d0), (r1v31 androidx.recyclerview.widget.RecyclerView$d0) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
          0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        d0 I(int i2, boolean z, long j2) {
            d0 d0VarG0;
            boolean z2;
            d0 d0Var;
            boolean z3;
            boolean zH;
            ViewGroup.LayoutParams layoutParams;
            p pVar;
            RecyclerView recyclerViewW;
            b0 b0Var;
            View viewA;
            if (i2 < 0 || i2 >= RecyclerView.this.F0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i2 + "(" + i2 + "). Item count:" + RecyclerView.this.F0.b() + RecyclerView.this.P());
            }
            if (RecyclerView.this.F0.e()) {
                d0VarG0 = h(i2);
                if (d0VarG0 != null) {
                    z2 = true;
                }
                if (d0VarG0 == null && (d0VarG0 = m(i2, z)) != null) {
                    if (L(d0VarG0)) {
                        if (!z) {
                            d0VarG0.addFlags(4);
                            if (d0VarG0.isScrap()) {
                                RecyclerView.this.removeDetachedView(d0VarG0.itemView, false);
                                d0VarG0.unScrap();
                            } else if (d0VarG0.wasReturnedFromScrap()) {
                                d0VarG0.clearReturnedFromScrapFlag();
                            }
                            C(d0VarG0);
                        }
                        d0VarG0 = null;
                    } else {
                        z2 = true;
                    }
                }
                if (d0VarG0 != null) {
                    d0Var = d0VarG0;
                } else {
                    int iM = RecyclerView.this.f.m(i2);
                    if (iM < 0 || iM >= RecyclerView.this.C.getItemCount()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i2 + "(offset:" + iM + ").state:" + RecyclerView.this.F0.b() + RecyclerView.this.P());
                    }
                    int itemViewType = RecyclerView.this.C.getItemViewType(iM);
                    if (RecyclerView.this.C.hasStableIds() && (d0VarG0 = l(RecyclerView.this.C.getItemId(iM), itemViewType, z)) != null) {
                        d0VarG0.mPosition = iM;
                        z2 = true;
                    }
                    if (d0VarG0 == null && (b0Var = this.f344h) != null && (viewA = b0Var.a(this, i2, itemViewType)) != null) {
                        d0VarG0 = RecyclerView.this.g0(viewA);
                        if (d0VarG0 == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.P());
                        }
                        if (d0VarG0.shouldIgnore()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.P());
                        }
                    }
                    if (d0VarG0 == null) {
                        d0 d0VarF = i().f(itemViewType);
                        if (d0VarF != null) {
                            d0VarF.resetInternal();
                            if (RecyclerView.X0) {
                                r(d0VarF);
                            }
                        }
                        d0VarG0 = d0VarF;
                    }
                    if (d0VarG0 == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j2 != Long.MAX_VALUE && !this.g.l(itemViewType, nanoTime, j2)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        d0 d0VarCreateViewHolder = recyclerView.C.createViewHolder(recyclerView, itemViewType);
                        if (RecyclerView.a1 && (recyclerViewW = RecyclerView.W(d0VarCreateViewHolder.itemView)) != null) {
                            d0VarCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewW);
                        }
                        this.g.e(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        d0Var = d0VarCreateViewHolder;
                    }
                }
                z3 = z2;
                if (z3 && !RecyclerView.this.F0.e() && d0Var.hasAnyOfTheFlags(XMLEvent.ENTITY_REFERENCE)) {
                    d0Var.setFlags(0, XMLEvent.ENTITY_REFERENCE);
                    if (RecyclerView.this.F0.f329k) {
                        int iE = l.e(d0Var) | XMLEvent.CHANGE_PREFIX_MAPPING;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.S0(d0Var, recyclerView2.n0.u(recyclerView2.F0, d0Var, iE, d0Var.getUnmodifiedPayloads()));
                    }
                }
                if (RecyclerView.this.F0.e() || !d0Var.isBound()) {
                    if (d0Var.isBound() || d0Var.needsUpdate() || d0Var.isInvalid()) {
                        zH = H(d0Var, RecyclerView.this.f.m(i2), i2, j2);
                    }
                    layoutParams = d0Var.itemView.getLayoutParams();
                    if (layoutParams == null) {
                        pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                        d0Var.itemView.setLayoutParams(pVar);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        pVar = (p) layoutParams;
                    } else {
                        pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                        d0Var.itemView.setLayoutParams(pVar);
                    }
                    pVar.a = d0Var;
                    pVar.d = z3 && zH;
                    return d0Var;
                }
                d0Var.mPreLayoutPosition = i2;
                zH = false;
                layoutParams = d0Var.itemView.getLayoutParams();
                if (layoutParams == null) {
                }
                pVar.a = d0Var;
                pVar.d = z3 && zH;
                return d0Var;
            }
            d0VarG0 = null;
            z2 = false;
            if (d0VarG0 == null) {
                if (L(d0VarG0)) {
                }
            }
            if (d0VarG0 != null) {
            }
            z3 = z2;
            if (z3) {
                d0Var.setFlags(0, XMLEvent.ENTITY_REFERENCE);
                if (RecyclerView.this.F0.f329k) {
                }
            }
            if (RecyclerView.this.F0.e()) {
                if (d0Var.isBound()) {
                }
                zH = H(d0Var, RecyclerView.this.f.m(i2), i2, j2);
            }
            layoutParams = d0Var.itemView.getLayoutParams();
            if (layoutParams == null) {
            }
            pVar.a = d0Var;
            pVar.d = z3 && zH;
            return d0Var;
        }

        void J(d0 d0Var) {
            if (d0Var.mInChangeScrap) {
                this.b.remove(d0Var);
            } else {
                this.a.remove(d0Var);
            }
            d0Var.mScrapContainer = null;
            d0Var.mInChangeScrap = false;
            d0Var.clearReturnedFromScrapFlag();
        }

        void K() {
            o oVar = RecyclerView.this.D;
            this.f = this.e + (oVar != null ? oVar.f340l : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                A(size);
            }
        }

        boolean L(d0 d0Var) {
            if (d0Var.isRemoved()) {
                return RecyclerView.this.F0.e();
            }
            int i2 = d0Var.mPosition;
            if (i2 >= 0 && i2 < RecyclerView.this.C.getItemCount()) {
                if (RecyclerView.this.F0.e() || RecyclerView.this.C.getItemViewType(d0Var.mPosition) == d0Var.getItemViewType()) {
                    return !RecyclerView.this.C.hasStableIds() || d0Var.getItemId() == RecyclerView.this.C.getItemId(d0Var.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.P());
        }

        void M(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.c.get(size);
                if (d0Var != null && (i4 = d0Var.mPosition) >= i2 && i4 < i5) {
                    d0Var.addFlags(2);
                    A(size);
                }
            }
        }

        void a(d0 d0Var, boolean z) {
            RecyclerView.r(d0Var);
            View view = d0Var.itemView;
            e1 e1Var = RecyclerView.this.M0;
            if (e1Var != null) {
                h.e.j.b bVarN = e1Var.n();
                h.e.j.s0.Z(view, bVarN instanceof d1 ? ((d1) bVarN).n(view) : null);
            }
            if (z) {
                g(d0Var);
            }
            d0Var.mOwnerRecyclerView = null;
            i().i(d0Var);
        }

        public void c() {
            this.a.clear();
            z();
        }

        void d() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).clearOldPosition();
            }
            int size2 = this.a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.a.get(i3).clearOldPosition();
            }
            ArrayList<d0> arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.b.get(i4).clearOldPosition();
                }
            }
        }

        void e() {
            this.a.clear();
            ArrayList<d0> arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.F0.b()) {
                return !RecyclerView.this.F0.e() ? i2 : RecyclerView.this.f.m(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.F0.b() + RecyclerView.this.P());
        }

        void g(d0 d0Var) {
            w wVar = RecyclerView.this.G;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.C;
            if (gVar != null) {
                gVar.onViewRecycled(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.F0 != null) {
                recyclerView.f322h.q(d0Var);
            }
        }

        d0 h(int i2) {
            int size;
            int iM;
            ArrayList<d0> arrayList = this.b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    d0 d0Var = this.b.get(i3);
                    if (!d0Var.wasReturnedFromScrap() && d0Var.getLayoutPosition() == i2) {
                        d0Var.addFlags(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.C.hasStableIds() && (iM = RecyclerView.this.f.m(i2)) > 0 && iM < RecyclerView.this.C.getItemCount()) {
                    long itemId = RecyclerView.this.C.getItemId(iM);
                    for (int i4 = 0; i4 < size; i4++) {
                        d0 d0Var2 = this.b.get(i4);
                        if (!d0Var2.wasReturnedFromScrap() && d0Var2.getItemId() == itemId) {
                            d0Var2.addFlags(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.g == null) {
                this.g = new u();
            }
            return this.g;
        }

        int j() {
            return this.a.size();
        }

        public List<d0> k() {
            return this.d;
        }

        d0 l(long j2, int i2, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.a.get(size);
                if (d0Var.getItemId() == j2 && !d0Var.wasReturnedFromScrap()) {
                    if (i2 == d0Var.getItemViewType()) {
                        d0Var.addFlags(32);
                        if (d0Var.isRemoved() && !RecyclerView.this.F0.e()) {
                            d0Var.setFlags(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.itemView, false);
                        y(d0Var.itemView);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.c.get(size2);
                if (d0Var2.getItemId() == j2 && !d0Var2.isAttachedToTransitionOverlay()) {
                    if (i2 == d0Var2.getItemViewType()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        d0 m(int i2, boolean z) {
            View viewE;
            int size = this.a.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.a.get(i3);
                if (!d0Var.wasReturnedFromScrap() && d0Var.getLayoutPosition() == i2 && !d0Var.isInvalid() && (RecyclerView.this.F0.f326h || !d0Var.isRemoved())) {
                    d0Var.addFlags(32);
                    return d0Var;
                }
            }
            if (z || (viewE = RecyclerView.this.g.e(i2)) == null) {
                int size2 = this.c.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d0 d0Var2 = this.c.get(i4);
                    if (!d0Var2.isInvalid() && d0Var2.getLayoutPosition() == i2 && !d0Var2.isAttachedToTransitionOverlay()) {
                        if (!z) {
                            this.c.remove(i4);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 d0VarH0 = RecyclerView.h0(viewE);
            RecyclerView.this.g.s(viewE);
            int iM = RecyclerView.this.g.m(viewE);
            if (iM != -1) {
                RecyclerView.this.g.d(iM);
                D(viewE);
                d0VarH0.addFlags(8224);
                return d0VarH0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d0VarH0 + RecyclerView.this.P());
        }

        View n(int i2) {
            return this.a.get(i2).itemView;
        }

        public View o(int i2) {
            return p(i2, false);
        }

        View p(int i2, boolean z) {
            return I(i2, z, Long.MAX_VALUE).itemView;
        }

        void s() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = (p) this.c.get(i2).itemView.getLayoutParams();
                if (pVar != null) {
                    pVar.c = true;
                }
            }
        }

        void t() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                d0 d0Var = this.c.get(i2);
                if (d0Var != null) {
                    d0Var.addFlags(6);
                    d0Var.addChangePayload(null);
                }
            }
            g gVar = RecyclerView.this.C;
            if (gVar == null || !gVar.hasStableIds()) {
                z();
            }
        }

        void u(int i2, int i3) {
            int size = this.c.size();
            for (int i4 = 0; i4 < size; i4++) {
                d0 d0Var = this.c.get(i4);
                if (d0Var != null && d0Var.mPosition >= i2) {
                    d0Var.offsetPosition(i3, true);
                }
            }
        }

        void v(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i4 = -1;
                i6 = i2;
                i5 = i3;
            } else {
                i4 = 1;
                i5 = i2;
                i6 = i3;
            }
            int size = this.c.size();
            for (int i8 = 0; i8 < size; i8++) {
                d0 d0Var = this.c.get(i8);
                if (d0Var != null && (i7 = d0Var.mPosition) >= i6 && i7 <= i5) {
                    if (i7 == i2) {
                        d0Var.offsetPosition(i3 - i2, false);
                    } else {
                        d0Var.offsetPosition(i4, false);
                    }
                }
            }
        }

        void w(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.c.get(size);
                if (d0Var != null) {
                    int i5 = d0Var.mPosition;
                    if (i5 >= i4) {
                        d0Var.offsetPosition(-i3, z);
                    } else if (i5 >= i2) {
                        d0Var.addFlags(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z) {
            c();
            i().h(gVar, gVar2, z);
        }

        void y(View view) {
            d0 d0VarH0 = RecyclerView.h0(view);
            d0VarH0.mScrapContainer = null;
            d0VarH0.mInChangeScrap = false;
            d0VarH0.clearReturnedFromScrapFlag();
            C(d0VarH0);
        }

        void z() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.c.clear();
            if (RecyclerView.a1) {
                RecyclerView.this.E0.b();
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    private class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.o(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.F0.g = true;
            recyclerView.Q0(true);
            if (RecyclerView.this.f.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i2, int i3, Object obj) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.f.r(i2, i3, obj)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i2, int i3) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.f.s(i2, i3)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i2, int i3, int i4) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.f.t(i2, i3, i4)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i2, int i3) {
            RecyclerView.this.o(null);
            if (RecyclerView.this.f.u(i2, i3)) {
                f();
            }
        }

        void f() {
            if (RecyclerView.Z0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.M && recyclerView.K) {
                    h.e.j.s0.U(recyclerView, recyclerView.f324j);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.b0 = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class z {
        public abstract int a();

        public abstract boolean b();

        public abstract boolean c();

        abstract void d(int i2, int i3);

        protected abstract void e(View view);

        public abstract void f(int i2);

        protected final void g() {
            throw null;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        X0 = i2 == 18 || i2 == 19 || i2 == 20;
        Y0 = i2 >= 23;
        Z0 = i2 >= 16;
        a1 = i2 >= 21;
        b1 = i2 <= 15;
        c1 = i2 <= 15;
        Class<?> cls = Integer.TYPE;
        d1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        e1 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void A() {
        int i2 = this.a0;
        this.a0 = 0;
        if (i2 == 0 || !v0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        h.e.j.q1.b.b(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void C() {
        this.F0.a(1);
        Q(this.F0);
        this.F0.f328j = false;
        r1();
        this.f322h.f();
        H0();
        P0();
        f1();
        a0 a0Var = this.F0;
        a0Var.f327i = a0Var.f329k && this.J0;
        this.J0 = false;
        this.I0 = false;
        a0Var.f326h = a0Var.f330l;
        a0Var.f = this.C.getItemCount();
        V(this.O0);
        if (this.F0.f329k) {
            int iG = this.g.g();
            for (int i2 = 0; i2 < iG; i2++) {
                d0 d0VarH0 = h0(this.g.f(i2));
                if (!d0VarH0.shouldIgnore() && (!d0VarH0.isInvalid() || this.C.hasStableIds())) {
                    this.f322h.e(d0VarH0, this.n0.u(this.F0, d0VarH0, l.e(d0VarH0), d0VarH0.getUnmodifiedPayloads()));
                    if (this.F0.f327i && d0VarH0.isUpdated() && !d0VarH0.isRemoved() && !d0VarH0.shouldIgnore() && !d0VarH0.isInvalid()) {
                        this.f322h.c(e0(d0VarH0), d0VarH0);
                    }
                }
            }
        }
        if (this.F0.f330l) {
            g1();
            a0 a0Var2 = this.F0;
            boolean z2 = a0Var2.g;
            a0Var2.g = false;
            this.D.W0(this.d, a0Var2);
            this.F0.g = z2;
            for (int i3 = 0; i3 < this.g.g(); i3++) {
                d0 d0VarH02 = h0(this.g.f(i3));
                if (!d0VarH02.shouldIgnore() && !this.f322h.i(d0VarH02)) {
                    int iE = l.e(d0VarH02);
                    boolean zHasAnyOfTheFlags = d0VarH02.hasAnyOfTheFlags(XMLEvent.ENTITY_REFERENCE);
                    if (!zHasAnyOfTheFlags) {
                        iE |= XMLEvent.CHANGE_PREFIX_MAPPING;
                    }
                    l.b bVarU = this.n0.u(this.F0, d0VarH02, iE, d0VarH02.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        S0(d0VarH02, bVarU);
                    } else {
                        this.f322h.a(d0VarH02, bVarU);
                    }
                }
            }
            s();
        } else {
            s();
        }
        I0();
        t1(false);
        this.F0.e = 2;
    }

    private void D() {
        r1();
        H0();
        this.F0.a(6);
        this.f.j();
        this.F0.f = this.C.getItemCount();
        a0 a0Var = this.F0;
        a0Var.d = 0;
        a0Var.f326h = false;
        this.D.W0(this.d, a0Var);
        a0 a0Var2 = this.F0;
        a0Var2.g = false;
        this.e = null;
        a0Var2.f329k = a0Var2.f329k && this.n0 != null;
        a0Var2.e = 4;
        I0();
        t1(false);
    }

    private void E() {
        this.F0.a(4);
        r1();
        H0();
        a0 a0Var = this.F0;
        a0Var.e = 1;
        if (a0Var.f329k) {
            for (int iG = this.g.g() - 1; iG >= 0; iG--) {
                d0 d0VarH0 = h0(this.g.f(iG));
                if (!d0VarH0.shouldIgnore()) {
                    long jE0 = e0(d0VarH0);
                    l.b bVarT = this.n0.t(this.F0, d0VarH0);
                    d0 d0VarG = this.f322h.g(jE0);
                    if (d0VarG == null || d0VarG.shouldIgnore()) {
                        this.f322h.d(d0VarH0, bVarT);
                    } else {
                        boolean zH = this.f322h.h(d0VarG);
                        boolean zH2 = this.f322h.h(d0VarH0);
                        if (zH && d0VarG == d0VarH0) {
                            this.f322h.d(d0VarH0, bVarT);
                        } else {
                            l.b bVarN = this.f322h.n(d0VarG);
                            this.f322h.d(d0VarH0, bVarT);
                            l.b bVarM = this.f322h.m(d0VarH0);
                            if (bVarN == null) {
                                m0(jE0, d0VarH0, d0VarG);
                            } else {
                                m(d0VarG, d0VarH0, bVarN, bVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f322h.o(this.V0);
        }
        this.D.j1(this.d);
        a0 a0Var2 = this.F0;
        a0Var2.c = a0Var2.f;
        this.e0 = false;
        this.f0 = false;
        a0Var2.f329k = false;
        a0Var2.f330l = false;
        this.D.f336h = false;
        ArrayList<d0> arrayList = this.d.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.D;
        if (oVar.f341m) {
            oVar.f340l = 0;
            oVar.f341m = false;
            this.d.K();
        }
        this.D.X0(this.F0);
        I0();
        t1(false);
        this.f322h.f();
        int[] iArr = this.O0;
        if (x(iArr[0], iArr[1])) {
            I(0, 0);
        }
        T0();
        d1();
    }

    private boolean K(MotionEvent motionEvent) {
        s sVar = this.J;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return U(motionEvent);
        }
        sVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.J = null;
        }
        return true;
    }

    private void K0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.p0) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.p0 = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.t0 = x2;
            this.r0 = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.u0 = y2;
            this.s0 = y2;
        }
    }

    private boolean O0() {
        return this.n0 != null && this.D.H1();
    }

    private void P0() {
        boolean z2;
        if (this.e0) {
            this.f.y();
            if (this.f0) {
                this.D.R0(this);
            }
        }
        if (O0()) {
            this.f.w();
        } else {
            this.f.j();
        }
        boolean z3 = false;
        boolean z4 = this.I0 || this.J0;
        this.F0.f329k = this.P && this.n0 != null && ((z2 = this.e0) || z4 || this.D.f336h) && (!z2 || this.C.hasStableIds());
        a0 a0Var = this.F0;
        if (a0Var.f329k && z4 && !this.e0 && O0()) {
            z3 = true;
        }
        a0Var.f330l = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R0(float f2, float f3, float f4, float f5) {
        boolean z2;
        boolean z3 = true;
        if (f3 < 0.0f) {
            M();
            androidx.core.widget.f.a(this.j0, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
        } else {
            if (f3 <= 0.0f) {
                z2 = false;
                if (f5 >= 0.0f) {
                    O();
                    androidx.core.widget.f.a(this.k0, (-f5) / getHeight(), f2 / getWidth());
                } else if (f5 > 0.0f) {
                    L();
                    androidx.core.widget.f.a(this.m0, f5 / getHeight(), 1.0f - (f2 / getWidth()));
                } else {
                    z3 = z2;
                }
                if (z3 && f3 == 0.0f && f5 == 0.0f) {
                    return;
                }
                h.e.j.s0.T(this);
            }
            N();
            androidx.core.widget.f.a(this.l0, f3 / getWidth(), f4 / getHeight());
        }
        z2 = true;
        if (f5 >= 0.0f) {
        }
        if (z3) {
        }
        h.e.j.s0.T(this);
    }

    private void T0() {
        View viewFindViewById;
        if (!this.B0 || this.C == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!c1 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.g.n(focusedChild)) {
                    return;
                }
            } else if (this.g.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewX = null;
        d0 d0VarZ = (this.F0.f332n == -1 || !this.C.hasStableIds()) ? null : Z(this.F0.f332n);
        if (d0VarZ != null && !this.g.n(d0VarZ.itemView) && d0VarZ.itemView.hasFocusable()) {
            viewX = d0VarZ.itemView;
        } else if (this.g.g() > 0) {
            viewX = X();
        }
        if (viewX != null) {
            int i2 = this.F0.f333o;
            if (i2 != -1 && (viewFindViewById = viewX.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewX = viewFindViewById;
            }
            viewX.requestFocus();
        }
    }

    private boolean U(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.I.get(i2);
            if (sVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.J = sVar;
                return true;
            }
        }
        return false;
    }

    private void U0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.j0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.j0.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.k0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.k0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.l0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.l0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.m0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.m0.isFinished();
        }
        if (zIsFinished) {
            h.e.j.s0.T(this);
        }
    }

    private void V(int[] iArr) {
        int iG = this.g.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iG; i4++) {
            d0 d0VarH0 = h0(this.g.f(i4));
            if (!d0VarH0.shouldIgnore()) {
                int layoutPosition = d0VarH0.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView W(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewW = W(viewGroup.getChildAt(i2));
            if (recyclerViewW != null) {
                return recyclerViewW;
            }
        }
        return null;
    }

    private View X() {
        d0 d0VarY;
        a0 a0Var = this.F0;
        int i2 = a0Var.f331m;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = a0Var.b();
        for (int i3 = i2; i3 < iB; i3++) {
            d0 d0VarY2 = Y(i3);
            if (d0VarY2 == null) {
                break;
            }
            if (d0VarY2.itemView.hasFocusable()) {
                return d0VarY2.itemView;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (d0VarY = Y(iMin)) == null) {
                return null;
            }
        } while (!d0VarY.itemView.hasFocusable());
        return d0VarY.itemView;
    }

    private void c1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f325k.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.c) {
                Rect rect = pVar.b;
                Rect rect2 = this.f325k;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f325k);
            offsetRectIntoDescendantCoords(view, this.f325k);
        }
        this.D.q1(this, view, this.f325k, !this.P, view2 == null);
    }

    private void d1() {
        a0 a0Var = this.F0;
        a0Var.f332n = -1L;
        a0Var.f331m = -1;
        a0Var.f333o = -1;
    }

    private void e1() {
        VelocityTracker velocityTracker = this.q0;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        u1(0);
        U0();
    }

    private void f(d0 d0Var) {
        View view = d0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.d.J(g0(view));
        if (d0Var.isTmpDetached()) {
            this.g.c(view, -1, view.getLayoutParams(), true);
        } else if (z2) {
            this.g.k(view);
        } else {
            this.g.b(view, true);
        }
    }

    private void f1() {
        View focusedChild = (this.B0 && hasFocus() && this.C != null) ? getFocusedChild() : null;
        d0 d0VarT = focusedChild != null ? T(focusedChild) : null;
        if (d0VarT == null) {
            d1();
            return;
        }
        this.F0.f332n = this.C.hasStableIds() ? d0VarT.getItemId() : -1L;
        this.F0.f331m = this.e0 ? -1 : d0VarT.isRemoved() ? d0VarT.mOldPosition : d0VarT.getAdapterPosition();
        this.F0.f333o = j0(d0VarT.itemView);
    }

    private h.e.j.v getScrollingChildHelper() {
        if (this.P0 == null) {
            this.P0 = new h.e.j.v(this);
        }
        return this.P0;
    }

    static d0 h0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).a;
    }

    static void i0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int j0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String k0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + NameUtil.PERIOD + str;
    }

    private void k1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.C;
        if (gVar2 != null) {
            gVar2.unregisterAdapterDataObserver(this.c);
            this.C.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            V0();
        }
        this.f.y();
        g gVar3 = this.C;
        this.C = gVar;
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.c);
            gVar.onAttachedToRecyclerView(this);
        }
        o oVar = this.D;
        if (oVar != null) {
            oVar.D0(gVar3, this.C);
        }
        this.d.x(gVar3, this.C, z2);
        this.F0.g = true;
    }

    private void m(d0 d0Var, d0 d0Var2, l.b bVar, l.b bVar2, boolean z2, boolean z3) {
        d0Var.setIsRecyclable(false);
        if (z2) {
            f(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                f(d0Var2);
            }
            d0Var.mShadowedHolder = d0Var2;
            f(d0Var);
            this.d.J(d0Var);
            d0Var2.setIsRecyclable(false);
            d0Var2.mShadowingHolder = d0Var;
        }
        if (this.n0.b(d0Var, d0Var2, bVar, bVar2)) {
            N0();
        }
    }

    private void m0(long j2, d0 d0Var, d0 d0Var2) {
        int iG = this.g.g();
        for (int i2 = 0; i2 < iG; i2++) {
            d0 d0VarH0 = h0(this.g.f(i2));
            if (d0VarH0 != d0Var && e0(d0VarH0) == j2) {
                g gVar = this.C;
                if (gVar == null || !gVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d0VarH0 + " \n View Holder 2:" + d0Var + P());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d0VarH0 + " \n View Holder 2:" + d0Var + P());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + P());
    }

    private boolean o0() {
        int iG = this.g.g();
        for (int i2 = 0; i2 < iG; i2++) {
            d0 d0VarH0 = h0(this.g.f(i2));
            if (d0VarH0 != null && !d0VarH0.shouldIgnore() && d0VarH0.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    private void q() {
        e1();
        setScrollState(0);
    }

    @SuppressLint({"InlinedApi"})
    private void q0() {
        if (h.e.j.s0.v(this) == 0) {
            h.e.j.s0.f0(this, 8);
        }
    }

    static void r(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == d0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            d0Var.mNestedRecyclerView = null;
        }
    }

    private void r0() {
        this.g = new androidx.recyclerview.widget.e(new e());
    }

    private void v(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException, SecurityException {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strK0 = k0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strK0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(d1);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strK0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strK0, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strK0, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strK0, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strK0, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strK0, e8);
            }
        }
    }

    private void w1() {
        this.C0.g();
        o oVar = this.D;
        if (oVar != null) {
            oVar.G1();
        }
    }

    private boolean x(int i2, int i3) {
        V(this.O0);
        int[] iArr = this.O0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private boolean x0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || S(view2) == null) {
            return false;
        }
        if (view == null || S(view) == null) {
            return true;
        }
        this.f325k.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f325k);
        offsetDescendantRectToMyCoords(view2, this.t);
        char c2 = 65535;
        int i4 = this.D.Y() == 1 ? -1 : 1;
        Rect rect = this.f325k;
        int i5 = rect.left;
        Rect rect2 = this.t;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + P());
    }

    public void A0(int i2) {
        int iG = this.g.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.g.f(i3).offsetLeftAndRight(i2);
        }
    }

    void B() {
        if (this.C == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.D == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        a0 a0Var = this.F0;
        a0Var.f328j = false;
        if (a0Var.e == 1) {
            C();
            this.D.x1(this);
            D();
        } else if (!this.f.q() && this.D.n0() == getWidth() && this.D.W() == getHeight()) {
            this.D.x1(this);
        } else {
            this.D.x1(this);
            D();
        }
        E();
    }

    public void B0(int i2) {
        int iG = this.g.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.g.f(i3).offsetTopAndBottom(i2);
        }
    }

    void C0(int i2, int i3) {
        int iJ = this.g.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            d0 d0VarH0 = h0(this.g.i(i4));
            if (d0VarH0 != null && !d0VarH0.shouldIgnore() && d0VarH0.mPosition >= i2) {
                d0VarH0.offsetPosition(i3, false);
                this.F0.g = true;
            }
        }
        this.d.u(i2, i3);
        requestLayout();
    }

    void D0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iJ = this.g.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iJ; i8++) {
            d0 d0VarH0 = h0(this.g.i(i8));
            if (d0VarH0 != null && (i7 = d0VarH0.mPosition) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    d0VarH0.offsetPosition(i3 - i2, false);
                } else {
                    d0VarH0.offsetPosition(i6, false);
                }
                this.F0.g = true;
            }
        }
        this.d.v(i2, i3);
        requestLayout();
    }

    void E0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iJ = this.g.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            d0 d0VarH0 = h0(this.g.i(i5));
            if (d0VarH0 != null && !d0VarH0.shouldIgnore()) {
                int i6 = d0VarH0.mPosition;
                if (i6 >= i4) {
                    d0VarH0.offsetPosition(-i3, z2);
                    this.F0.g = true;
                } else if (i6 >= i2) {
                    d0VarH0.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.F0.g = true;
                }
            }
        }
        this.d.w(i2, i3, z2);
        requestLayout();
    }

    public boolean F(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public void F0(View view) {
    }

    public final void G(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void G0(View view) {
    }

    void H(int i2) {
        o oVar = this.D;
        if (oVar != null) {
            oVar.d1(i2);
        }
        L0(i2);
        t tVar = this.G0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.H0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.H0.get(size).a(this, i2);
            }
        }
    }

    void H0() {
        this.g0++;
    }

    void I(int i2, int i3) {
        this.h0++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        M0(i2, i3);
        t tVar = this.G0;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List<t> list = this.H0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.H0.get(size).b(this, i2, i3);
            }
        }
        this.h0--;
    }

    void I0() {
        J0(true);
    }

    void J() {
        int i2;
        for (int size = this.T0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.T0.get(size);
            if (d0Var.itemView.getParent() == this && !d0Var.shouldIgnore() && (i2 = d0Var.mPendingAccessibilityState) != -1) {
                h.e.j.s0.e0(d0Var.itemView, i2);
                d0Var.mPendingAccessibilityState = -1;
            }
        }
        this.T0.clear();
    }

    void J0(boolean z2) {
        int i2 = this.g0 - 1;
        this.g0 = i2;
        if (i2 < 1) {
            this.g0 = 0;
            if (z2) {
                A();
                J();
            }
        }
    }

    void L() {
        if (this.m0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.i0.a(this, 3);
        this.m0 = edgeEffectA;
        if (this.f323i) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void L0(int i2) {
    }

    void M() {
        if (this.j0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.i0.a(this, 0);
        this.j0 = edgeEffectA;
        if (this.f323i) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void M0(int i2, int i3) {
    }

    void N() {
        if (this.l0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.i0.a(this, 2);
        this.l0 = edgeEffectA;
        if (this.f323i) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void N0() {
        if (this.L0 || !this.K) {
            return;
        }
        h.e.j.s0.U(this, this.U0);
        this.L0 = true;
    }

    void O() {
        if (this.k0 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.i0.a(this, 1);
        this.k0 = edgeEffectA;
        if (this.f323i) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String P() {
        return " " + super.toString() + ", adapter:" + this.C + ", layout:" + this.D + ", context:" + getContext();
    }

    final void Q(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.p = 0;
            a0Var.q = 0;
        } else {
            OverScroller overScroller = this.C0.e;
            a0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    void Q0(boolean z2) {
        this.f0 = z2 | this.f0;
        this.e0 = true;
        z0();
    }

    public View R(float f2, float f3) {
        for (int iG = this.g.g() - 1; iG >= 0; iG--) {
            View viewF = this.g.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f2 >= viewF.getLeft() + translationX && f2 <= viewF.getRight() + translationX && f3 >= viewF.getTop() + translationY && f3 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public View S(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    void S0(d0 d0Var, l.b bVar) {
        d0Var.setFlags(0, XMLEvent.ENTITY_REFERENCE);
        if (this.F0.f327i && d0Var.isUpdated() && !d0Var.isRemoved() && !d0Var.shouldIgnore()) {
            this.f322h.c(e0(d0Var), d0Var);
        }
        this.f322h.e(d0Var, bVar);
    }

    public d0 T(View view) {
        View viewS = S(view);
        if (viewS == null) {
            return null;
        }
        return g0(viewS);
    }

    void V0() {
        l lVar = this.n0;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.D;
        if (oVar != null) {
            oVar.i1(this.d);
            this.D.j1(this.d);
        }
        this.d.c();
    }

    boolean W0(View view) {
        r1();
        boolean zR = this.g.r(view);
        if (zR) {
            d0 d0VarH0 = h0(view);
            this.d.J(d0VarH0);
            this.d.C(d0VarH0);
        }
        t1(!zR);
        return zR;
    }

    public void X0(n nVar) {
        o oVar = this.D;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.H.remove(nVar);
        if (this.H.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        y0();
        requestLayout();
    }

    public d0 Y(int i2) {
        d0 d0Var = null;
        if (this.e0) {
            return null;
        }
        int iJ = this.g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarH0 = h0(this.g.i(i3));
            if (d0VarH0 != null && !d0VarH0.isRemoved() && d0(d0VarH0) == i2) {
                if (!this.g.n(d0VarH0.itemView)) {
                    return d0VarH0;
                }
                d0Var = d0VarH0;
            }
        }
        return d0Var;
    }

    public void Y0(q qVar) {
        List<q> list = this.d0;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public d0 Z(long j2) {
        g gVar = this.C;
        d0 d0Var = null;
        if (gVar != null && gVar.hasStableIds()) {
            int iJ = this.g.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                d0 d0VarH0 = h0(this.g.i(i2));
                if (d0VarH0 != null && !d0VarH0.isRemoved() && d0VarH0.getItemId() == j2) {
                    if (!this.g.n(d0VarH0.itemView)) {
                        return d0VarH0;
                    }
                    d0Var = d0VarH0;
                }
            }
        }
        return d0Var;
    }

    public void Z0(s sVar) {
        this.I.remove(sVar);
        if (this.J == sVar) {
            this.J = null;
        }
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            M();
            if (this.j0.isFinished()) {
                this.j0.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            N();
            if (this.l0.isFinished()) {
                this.l0.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            O();
            if (this.k0.isFinished()) {
                this.k0.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            L();
            if (this.m0.isFinished()) {
                this.m0.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        h.e.j.s0.T(this);
    }

    public d0 a0(int i2) {
        return b0(i2, false);
    }

    public void a1(t tVar) {
        List<t> list = this.H0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.D;
        if (oVar == null || !oVar.E0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    d0 b0(int i2, boolean z2) {
        int iJ = this.g.j();
        d0 d0Var = null;
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarH0 = h0(this.g.i(i3));
            if (d0VarH0 != null && !d0VarH0.isRemoved()) {
                if (z2) {
                    if (d0VarH0.mPosition != i2) {
                        continue;
                    } else {
                        if (!this.g.n(d0VarH0.itemView)) {
                            return d0VarH0;
                        }
                        d0Var = d0VarH0;
                    }
                } else if (d0VarH0.getLayoutPosition() != i2) {
                    continue;
                }
            }
        }
        return d0Var;
    }

    void b1() {
        d0 d0Var;
        int iG = this.g.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewF = this.g.f(i2);
            d0 d0VarG0 = g0(viewF);
            if (d0VarG0 != null && (d0Var = d0VarG0.mShadowingHolder) != null) {
                View view = d0Var.itemView;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public boolean c0(int i2, int i3) {
        o oVar = this.D;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.V) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.D.l();
        if (!zK || Math.abs(i2) < this.x0) {
            i2 = 0;
        }
        if (!zL || Math.abs(i3) < this.x0) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = zK || zL;
            dispatchNestedFling(f2, f3, z2);
            r rVar = this.w0;
            if (rVar != null && rVar.a(i2, i3)) {
                return true;
            }
            if (z2) {
                int i4 = zK ? 1 : 0;
                if (zL) {
                    i4 |= 2;
                }
                s1(i4, 1);
                int i5 = this.y0;
                int iMax = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.y0;
                this.C0.c(iMax, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.D.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.D;
        if (oVar != null && oVar.k()) {
            return this.D.q(this.F0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.D;
        if (oVar != null && oVar.k()) {
            return this.D.r(this.F0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.D;
        if (oVar != null && oVar.k()) {
            return this.D.s(this.F0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.D;
        if (oVar != null && oVar.l()) {
            return this.D.t(this.F0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.D;
        if (oVar != null && oVar.l()) {
            return this.D.u(this.F0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.D;
        if (oVar != null && oVar.l()) {
            return this.D.v(this.F0);
        }
        return 0;
    }

    int d0(d0 d0Var) {
        if (d0Var.hasAnyOfTheFlags(524) || !d0Var.isBound()) {
            return -1;
        }
        return this.f.e(d0Var.mPosition);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.H.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.H.get(i2).h(canvas, this, this.F0);
        }
        EdgeEffect edgeEffect = this.j0;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f323i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.j0;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.k0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f323i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.k0;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.l0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f323i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.l0;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.m0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f323i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.m0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.n0 == null || this.H.size() <= 0 || !this.n0.p()) ? z2 : true) {
            h.e.j.s0.T(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    long e0(d0 d0Var) {
        return this.C.hasStableIds() ? d0Var.getItemId() : d0Var.mPosition;
    }

    public int f0(View view) {
        d0 d0VarH0 = h0(view);
        if (d0VarH0 != null) {
            return d0VarH0.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewI0;
        boolean z2;
        View viewP0 = this.D.P0(view, i2);
        if (viewP0 != null) {
            return viewP0;
        }
        boolean z3 = (this.C == null || this.D == null || w0() || this.V) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.D.l()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (b1) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.D.k()) {
                int i4 = (this.D.Y() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (b1) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                u();
                if (S(view) == null) {
                    return null;
                }
                r1();
                this.D.I0(view, i2, this.d, this.F0);
                t1(false);
            }
            viewI0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                u();
                if (S(view) == null) {
                    return null;
                }
                r1();
                viewI0 = this.D.I0(view, i2, this.d, this.F0);
                t1(false);
            } else {
                viewI0 = viewFindNextFocus;
            }
        }
        if (viewI0 == null || viewI0.hasFocusable()) {
            return x0(view, viewI0, i2) ? viewI0 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        c1(viewI0, null);
        return view;
    }

    public void g(n nVar) {
        h(nVar, -1);
    }

    public d0 g0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return h0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void g1() {
        int iJ = this.g.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarH0 = h0(this.g.i(i2));
            if (!d0VarH0.shouldIgnore()) {
                d0VarH0.saveOldPosition();
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.D;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.D;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.C;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.D;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.N0;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f323i;
    }

    public e1 getCompatAccessibilityDelegate() {
        return this.M0;
    }

    public k getEdgeEffectFactory() {
        return this.i0;
    }

    public l getItemAnimator() {
        return this.n0;
    }

    public int getItemDecorationCount() {
        return this.H.size();
    }

    public o getLayoutManager() {
        return this.D;
    }

    public int getMaxFlingVelocity() {
        return this.y0;
    }

    public int getMinFlingVelocity() {
        return this.x0;
    }

    long getNanoTime() {
        if (a1) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.w0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.B0;
    }

    public u getRecycledViewPool() {
        return this.d.i();
    }

    public int getScrollState() {
        return this.o0;
    }

    public void h(n nVar, int i2) {
        o oVar = this.D;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.H.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.H.add(nVar);
        } else {
            this.H.add(i2, nVar);
        }
        y0();
        requestLayout();
    }

    boolean h1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        u();
        if (this.C != null) {
            int[] iArr = this.S0;
            iArr[0] = 0;
            iArr[1] = 0;
            i1(i2, i3, iArr);
            int[] iArr2 = this.S0;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.H.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.S0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        G(i5, i4, i6, i7, this.Q0, 0, iArr3);
        int[] iArr4 = this.S0;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.t0;
        int[] iArr5 = this.Q0;
        this.t0 = i12 - iArr5[0];
        this.u0 -= iArr5[1];
        int[] iArr6 = this.R0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !h.e.j.t.b(motionEvent, 8194)) {
                R0(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            t(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            I(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(q qVar) {
        if (this.d0 == null) {
            this.d0 = new ArrayList();
        }
        this.d0.add(qVar);
    }

    void i1(int i2, int i3, int[] iArr) {
        r1();
        H0();
        h.e.f.d.a("RV Scroll");
        Q(this.F0);
        int iU1 = i2 != 0 ? this.D.u1(i2, this.d, this.F0) : 0;
        int iW1 = i3 != 0 ? this.D.w1(i3, this.d, this.F0) : 0;
        h.e.f.d.b();
        b1();
        I0();
        t1(false);
        if (iArr != null) {
            iArr[0] = iU1;
            iArr[1] = iW1;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.K;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.V;
    }

    @Override // android.view.View, h.e.j.u
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(s sVar) {
        this.I.add(sVar);
    }

    public void j1(int i2) {
        if (this.V) {
            return;
        }
        v1();
        o oVar = this.D;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.v1(i2);
            awakenScrollBars();
        }
    }

    public void k(t tVar) {
        if (this.H0 == null) {
            this.H0 = new ArrayList();
        }
        this.H0.add(tVar);
    }

    void l(d0 d0Var, l.b bVar, l.b bVar2) {
        d0Var.setIsRecyclable(false);
        if (this.n0.a(d0Var, bVar, bVar2)) {
            N0();
        }
    }

    Rect l0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.c) {
            return pVar.b;
        }
        if (this.F0.e() && (pVar.b() || pVar.d())) {
            return pVar.b;
        }
        Rect rect = pVar.b;
        rect.set(0, 0, 0, 0);
        int size = this.H.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f325k.set(0, 0, 0, 0);
            this.H.get(i2).d(this.f325k, view, this, this.F0);
            int i3 = rect.left;
            Rect rect2 = this.f325k;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.c = false;
        return rect;
    }

    boolean l1(d0 d0Var, int i2) {
        if (!w0()) {
            h.e.j.s0.e0(d0Var.itemView, i2);
            return true;
        }
        d0Var.mPendingAccessibilityState = i2;
        this.T0.add(d0Var);
        return false;
    }

    boolean m1(AccessibilityEvent accessibilityEvent) {
        if (!w0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? h.e.j.q1.b.a(accessibilityEvent) : 0;
        this.a0 |= iA != 0 ? iA : 0;
        return true;
    }

    void n(d0 d0Var, l.b bVar, l.b bVar2) {
        f(d0Var);
        d0Var.setIsRecyclable(false);
        if (this.n0.c(d0Var, bVar, bVar2)) {
            N0();
        }
    }

    public boolean n0() {
        return !this.P || this.e0 || this.f.p();
    }

    public void n1(int i2, int i3) {
        o1(i2, i3, null);
    }

    void o(String str) {
        if (w0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + P());
        }
        if (this.h0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + P()));
        }
    }

    public void o1(int i2, int i3, Interpolator interpolator) {
        p1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g0 = 0;
        this.K = true;
        this.P = this.P && !isLayoutRequested();
        o oVar = this.D;
        if (oVar != null) {
            oVar.z(this);
        }
        this.L0 = false;
        if (a1) {
            ThreadLocal<androidx.recyclerview.widget.b0> threadLocal = androidx.recyclerview.widget.b0.g;
            androidx.recyclerview.widget.b0 b0Var = threadLocal.get();
            this.D0 = b0Var;
            if (b0Var == null) {
                this.D0 = new androidx.recyclerview.widget.b0();
                Display displayP = h.e.j.s0.p(this);
                float f2 = 60.0f;
                if (!isInEditMode() && displayP != null) {
                    float refreshRate = displayP.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.b0 b0Var2 = this.D0;
                b0Var2.e = (long) (1.0E9f / f2);
                threadLocal.set(b0Var2);
            }
            this.D0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.b0 b0Var;
        super.onDetachedFromWindow();
        l lVar = this.n0;
        if (lVar != null) {
            lVar.k();
        }
        v1();
        this.K = false;
        o oVar = this.D;
        if (oVar != null) {
            oVar.A(this, this.d);
        }
        this.T0.clear();
        removeCallbacks(this.U0);
        this.f322h.j();
        if (!a1 || (b0Var = this.D0) == null) {
            return;
        }
        b0Var.j(this);
        this.D0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.H.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.H.get(i2).f(canvas, this, this.F0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float axisValue;
        if (this.D != null && !this.V && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.D.l() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.D.k() ? motionEvent.getAxisValue(10) : 0.0f;
                if (f2 != 0.0f || axisValue != 0.0f) {
                    h1((int) (axisValue * this.z0), (int) (f2 * this.A0), motionEvent);
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.D.l()) {
                    f2 = -axisValue2;
                    if (f2 != 0.0f) {
                        h1((int) (axisValue * this.z0), (int) (f2 * this.A0), motionEvent);
                    }
                } else {
                    if (this.D.k()) {
                        axisValue = axisValue2;
                        f2 = 0.0f;
                    } else {
                        f2 = 0.0f;
                        axisValue = 0.0f;
                    }
                    if (f2 != 0.0f) {
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.V) {
            return false;
        }
        this.J = null;
        if (U(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.D;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.D.l();
        if (this.q0 == null) {
            this.q0 = VelocityTracker.obtain();
        }
        this.q0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.W) {
                this.W = false;
            }
            this.p0 = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.t0 = x2;
            this.r0 = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.u0 = y2;
            this.s0 = y2;
            if (this.o0 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                u1(1);
            }
            int[] iArr = this.R0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zK;
            if (zL) {
                i2 = (zK ? 1 : 0) | 2;
            }
            s1(i2, 0);
        } else if (actionMasked == 1) {
            this.q0.clear();
            u1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.p0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.p0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.o0 != 1) {
                int i3 = x3 - this.r0;
                int i4 = y3 - this.s0;
                if (zK == 0 || Math.abs(i3) <= this.v0) {
                    z2 = false;
                } else {
                    this.t0 = x3;
                    z2 = true;
                }
                if (zL && Math.abs(i4) > this.v0) {
                    this.u0 = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.p0 = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.t0 = x4;
            this.r0 = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.u0 = y4;
            this.s0 = y4;
        } else if (actionMasked == 6) {
            K0(motionEvent);
        }
        return this.o0 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        h.e.f.d.a("RV OnLayout");
        B();
        h.e.f.d.b();
        this.P = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        o oVar = this.D;
        if (oVar == null) {
            w(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.r0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.D.Y0(this.d, this.F0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.C == null) {
                return;
            }
            if (this.F0.e == 1) {
                C();
            }
            this.D.y1(i2, i3);
            this.F0.f328j = true;
            D();
            this.D.B1(i2, i3);
            if (this.D.E1()) {
                this.D.y1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), WXVideoFileObject.FILE_SIZE_LIMIT));
                this.F0.f328j = true;
                D();
                this.D.B1(i2, i3);
                return;
            }
            return;
        }
        if (this.M) {
            this.D.Y0(this.d, this.F0, i2, i3);
            return;
        }
        if (this.b0) {
            r1();
            H0();
            P0();
            I0();
            a0 a0Var = this.F0;
            if (a0Var.f330l) {
                a0Var.f326h = true;
            } else {
                this.f.j();
                this.F0.f326h = false;
            }
            this.b0 = false;
            t1(false);
        } else if (this.F0.f330l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.C;
        if (gVar != null) {
            this.F0.f = gVar.getItemCount();
        } else {
            this.F0.f = 0;
        }
        r1();
        this.D.Y0(this.d, this.F0, i2, i3);
        t1(false);
        this.F0.f326h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (w0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.e = yVar;
        super.onRestoreInstanceState(yVar.a());
        o oVar = this.D;
        if (oVar == null || (parcelable2 = this.e.e) == null) {
            return;
        }
        oVar.b1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.e;
        if (yVar2 != null) {
            yVar.b(yVar2);
        } else {
            o oVar = this.D;
            if (oVar != null) {
                yVar.e = oVar.c1();
            } else {
                yVar.e = null;
            }
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        t0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = false;
        if (this.V || this.W) {
            return false;
        }
        if (K(motionEvent)) {
            q();
            return true;
        }
        o oVar = this.D;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.D.l();
        if (this.q0 == null) {
            this.q0 = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.R0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.R0;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.p0 = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.t0 = x2;
            this.r0 = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.u0 = y2;
            this.s0 = y2;
            int i2 = zK;
            if (zL) {
                i2 = (zK ? 1 : 0) | 2;
            }
            s1(i2, 0);
        } else if (actionMasked == 1) {
            this.q0.addMovement(motionEventObtain);
            this.q0.computeCurrentVelocity(XmlValidationError.INCORRECT_ATTRIBUTE, this.y0);
            float f2 = zK != 0 ? -this.q0.getXVelocity(this.p0) : 0.0f;
            float f3 = zL ? -this.q0.getYVelocity(this.p0) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !c0((int) f2, (int) f3)) {
                setScrollState(0);
            }
            e1();
            z3 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.p0);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.p0 + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int iMax = this.t0 - x3;
            int iMax2 = this.u0 - y3;
            if (this.o0 != 1) {
                if (zK == 0) {
                    z2 = false;
                    if (zL) {
                        iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.v0) : Math.min(0, iMax2 + this.v0);
                        if (iMax2 != 0) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        setScrollState(1);
                    }
                } else {
                    iMax = iMax > 0 ? Math.max(0, iMax - this.v0) : Math.min(0, iMax + this.v0);
                    if (iMax != 0) {
                        z2 = true;
                    }
                    if (zL) {
                    }
                    if (z2) {
                    }
                }
            }
            int i3 = iMax;
            int i4 = iMax2;
            if (this.o0 == 1) {
                int[] iArr3 = this.S0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (F(zK != 0 ? i3 : 0, zL ? i4 : 0, iArr3, this.Q0, 0)) {
                    int[] iArr4 = this.S0;
                    i3 -= iArr4[0];
                    i4 -= iArr4[1];
                    int[] iArr5 = this.R0;
                    int i5 = iArr5[0];
                    int[] iArr6 = this.Q0;
                    iArr5[0] = i5 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i6 = i4;
                int[] iArr7 = this.Q0;
                this.t0 = x3 - iArr7[0];
                this.u0 = y3 - iArr7[1];
                if (h1(zK != 0 ? i3 : 0, zL ? i6 : 0, motionEvent)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.b0 b0Var = this.D0;
                if (b0Var != null && (i3 != 0 || i6 != 0)) {
                    b0Var.f(this, i3, i6);
                }
            }
        } else if (actionMasked == 3) {
            q();
        } else if (actionMasked == 5) {
            this.p0 = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.t0 = x4;
            this.r0 = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.u0 = y4;
            this.s0 = y4;
        } else if (actionMasked == 6) {
            K0(motionEvent);
        }
        if (!z3) {
            this.q0.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    boolean p(d0 d0Var) {
        l lVar = this.n0;
        return lVar == null || lVar.g(d0Var, d0Var.getUnmodifiedPayloads());
    }

    void p0() {
        this.f = new androidx.recyclerview.widget.a(new f());
    }

    public void p1(int i2, int i3, Interpolator interpolator, int i4) {
        q1(i2, i3, interpolator, i4, false);
    }

    void q1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.D;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.V) {
            return;
        }
        if (!oVar.k()) {
            i2 = 0;
        }
        if (!this.D.l()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!(i4 == Integer.MIN_VALUE || i4 > 0)) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            s1(i5, 1);
        }
        this.C0.f(i2, i3, i4, interpolator);
    }

    void r1() {
        int i2 = this.Q + 1;
        this.Q = i2;
        if (i2 != 1 || this.V) {
            return;
        }
        this.U = false;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        d0 d0VarH0 = h0(view);
        if (d0VarH0 != null) {
            if (d0VarH0.isTmpDetached()) {
                d0VarH0.clearTmpDetachFlag();
            } else if (!d0VarH0.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d0VarH0 + P());
            }
        }
        view.clearAnimation();
        z(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.D.a1(this, this.F0, view, view2) && view2 != null) {
            c1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.D.p1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.I.get(i2).onRequestDisallowInterceptTouchEvent(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.Q != 0 || this.V) {
            this.U = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int iJ = this.g.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarH0 = h0(this.g.i(i2));
            if (!d0VarH0.shouldIgnore()) {
                d0VarH0.clearOldPosition();
            }
        }
        this.d.d();
    }

    void s0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.z(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(h.n.b.a), resources.getDimensionPixelSize(h.n.b.c), resources.getDimensionPixelOffset(h.n.b.b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + P());
        }
    }

    public boolean s1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.D;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.V) {
            return;
        }
        boolean zK = oVar.k();
        boolean zL = this.D.l();
        if (zK || zL) {
            if (!zK) {
                i2 = 0;
            }
            if (!zL) {
                i3 = 0;
            }
            h1(i2, i3, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (m1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(e1 e1Var) {
        this.M0 = e1Var;
        h.e.j.s0.Z(this, e1Var);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        k1(gVar, false, true);
        Q0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.N0) {
            return;
        }
        this.N0 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f323i) {
            t0();
        }
        this.f323i = z2;
        super.setClipToPadding(z2);
        if (this.P) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        h.e.i.h.d(kVar);
        this.i0 = kVar;
        t0();
    }

    public void setHasFixedSize(boolean z2) {
        this.M = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.n0;
        if (lVar2 != null) {
            lVar2.k();
            this.n0.w(null);
        }
        this.n0 = lVar;
        if (lVar != null) {
            lVar.w(this.K0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.d.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.D) {
            return;
        }
        v1();
        if (this.D != null) {
            l lVar = this.n0;
            if (lVar != null) {
                lVar.k();
            }
            this.D.i1(this.d);
            this.D.j1(this.d);
            this.d.c();
            if (this.K) {
                this.D.A(this, this.d);
            }
            this.D.C1(null);
            this.D = null;
        } else {
            this.d.c();
        }
        this.g.o();
        this.D = oVar;
        if (oVar != null) {
            if (oVar.b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.b.P());
            }
            oVar.C1(this);
            if (this.K) {
                this.D.z(this);
            }
        }
        this.d.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(r rVar) {
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.G0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.B0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.d.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.G = wVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.o0) {
            return;
        }
        this.o0 = i2;
        if (i2 != 2) {
            w1();
        }
        H(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.v0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.v0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.d.F(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    @Override // android.view.View, h.e.j.u
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.V) {
            o("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.V = true;
                this.W = true;
                v1();
                return;
            }
            this.V = false;
            if (this.U && this.D != null && this.C != null) {
                requestLayout();
            }
            this.U = false;
        }
    }

    void t(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.j0;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.j0.onRelease();
            zIsFinished = this.j0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.l0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.l0.onRelease();
            zIsFinished |= this.l0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.k0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.k0.onRelease();
            zIsFinished |= this.k0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.m0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.m0.onRelease();
            zIsFinished |= this.m0.isFinished();
        }
        if (zIsFinished) {
            h.e.j.s0.T(this);
        }
    }

    void t0() {
        this.m0 = null;
        this.k0 = null;
        this.l0 = null;
        this.j0 = null;
    }

    void t1(boolean z2) {
        if (this.Q < 1) {
            this.Q = 1;
        }
        if (!z2 && !this.V) {
            this.U = false;
        }
        if (this.Q == 1) {
            if (z2 && this.U && !this.V && this.D != null && this.C != null) {
                B();
            }
            if (!this.V) {
                this.U = false;
            }
        }
        this.Q--;
    }

    void u() {
        if (!this.P || this.e0) {
            h.e.f.d.a("RV FullInvalidate");
            B();
            h.e.f.d.b();
            return;
        }
        if (this.f.p()) {
            if (!this.f.o(4) || this.f.o(11)) {
                if (this.f.p()) {
                    h.e.f.d.a("RV FullInvalidate");
                    B();
                    h.e.f.d.b();
                    return;
                }
                return;
            }
            h.e.f.d.a("RV PartialInvalidate");
            r1();
            H0();
            this.f.w();
            if (!this.U) {
                if (o0()) {
                    B();
                } else {
                    this.f.i();
                }
            }
            t1(true);
            I0();
            h.e.f.d.b();
        }
    }

    public void u0() {
        if (this.H.size() == 0) {
            return;
        }
        o oVar = this.D;
        if (oVar != null) {
            oVar.g("Cannot invalidate item decorations during a scroll or layout");
        }
        y0();
        requestLayout();
    }

    public void u1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    boolean v0() {
        AccessibilityManager accessibilityManager = this.c0;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void v1() {
        setScrollState(0);
        w1();
    }

    void w(int i2, int i3) {
        setMeasuredDimension(o.n(i2, getPaddingLeft() + getPaddingRight(), h.e.j.s0.y(this)), o.n(i3, getPaddingTop() + getPaddingBottom(), h.e.j.s0.x(this)));
    }

    public boolean w0() {
        return this.g0 > 0;
    }

    void x1(int i2, int i3, Object obj) {
        int i4;
        int iJ = this.g.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iJ; i6++) {
            View viewI = this.g.i(i6);
            d0 d0VarH0 = h0(viewI);
            if (d0VarH0 != null && !d0VarH0.shouldIgnore() && (i4 = d0VarH0.mPosition) >= i2 && i4 < i5) {
                d0VarH0.addFlags(2);
                d0VarH0.addChangePayload(obj);
                ((p) viewI.getLayoutParams()).c = true;
            }
        }
        this.d.M(i2, i3);
    }

    void y(View view) {
        d0 d0VarH0 = h0(view);
        F0(view);
        g gVar = this.C;
        if (gVar != null && d0VarH0 != null) {
            gVar.onViewAttachedToWindow(d0VarH0);
        }
        List<q> list = this.d0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.d0.get(size).b(view);
            }
        }
    }

    void y0() {
        int iJ = this.g.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            ((p) this.g.i(i2).getLayoutParams()).c = true;
        }
        this.d.s();
    }

    void z(View view) {
        d0 d0VarH0 = h0(view);
        G0(view);
        g gVar = this.C;
        if (gVar != null && d0VarH0 != null) {
            gVar.onViewDetachedFromWindow(d0VarH0);
        }
        List<q> list = this.d0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.d0.get(size).a(view);
            }
        }
    }

    void z0() {
        int iJ = this.g.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarH0 = h0(this.g.i(i2));
            if (d0VarH0 != null && !d0VarH0.shouldIgnore()) {
                d0VarH0.addFlags(6);
            }
        }
        y0();
        this.d.t();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.n.a.a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i2);
        this.c = new x();
        this.d = new v();
        this.f322h = new n1();
        this.f324j = new a();
        this.f325k = new Rect();
        this.t = new Rect();
        this.A = new RectF();
        this.H = new ArrayList<>();
        this.I = new ArrayList<>();
        this.Q = 0;
        this.e0 = false;
        this.f0 = false;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = new k();
        this.n0 = new androidx.recyclerview.widget.p();
        this.o0 = 0;
        this.p0 = -1;
        this.z0 = Float.MIN_VALUE;
        this.A0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.B0 = true;
        this.C0 = new c0();
        this.E0 = a1 ? new b0.a() : null;
        this.F0 = new a0();
        this.I0 = false;
        this.J0 = false;
        this.K0 = new m();
        this.L0 = false;
        this.O0 = new int[2];
        this.Q0 = new int[2];
        this.R0 = new int[2];
        this.S0 = new int[2];
        this.T0 = new ArrayList();
        this.U0 = new b();
        this.V0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v0 = viewConfiguration.getScaledTouchSlop();
        this.z0 = h.e.j.t0.b(viewConfiguration, context);
        this.A0 = h.e.j.t0.d(viewConfiguration, context);
        this.x0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.y0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.n0.w(this.K0);
        p0();
        r0();
        q0();
        if (h.e.j.s0.u(this) == 0) {
            h.e.j.s0.e0(this, 1);
        }
        this.c0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new e1(this));
        int[] iArr = h.n.d.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(h.n.d.f1344j);
        if (typedArrayObtainStyledAttributes.getInt(h.n.d.d, -1) == -1) {
            setDescendantFocusability(WXMediaMessage.NATIVE_GAME__THUMB_LIMIT);
        }
        this.f323i = typedArrayObtainStyledAttributes.getBoolean(h.n.d.c, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(h.n.d.e, false);
        this.O = z3;
        if (z3) {
            s0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(h.n.d.f1342h), typedArrayObtainStyledAttributes.getDrawable(h.n.d.f1343i), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(h.n.d.f), typedArrayObtainStyledAttributes.getDrawable(h.n.d.g));
        }
        typedArrayObtainStyledAttributes.recycle();
        v(context, string, attributeSet, i2, 0);
        if (i3 >= 21) {
            int[] iArr2 = W0;
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
            if (i3 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
            }
            z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    public static class p extends ViewGroup.MarginLayoutParams {
        d0 a;
        final Rect b;
        boolean c;
        boolean d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public int a() {
            return this.a.getLayoutPosition();
        }

        public boolean b() {
            return this.a.isUpdated();
        }

        public boolean c() {
            return this.a.isRemoved();
        }

        public boolean d() {
            return this.a.isInvalid();
        }

        public p(int i2, int i3) {
            super(i2, i3);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    public static class y extends h.g.a.c {
        public static final Parcelable.Creator<y> CREATOR = new c1();
        Parcelable e;

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.e = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void b(y yVar) {
            this.e = yVar.e;
        }

        @Override // h.g.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.e, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.D;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + P());
    }
}
