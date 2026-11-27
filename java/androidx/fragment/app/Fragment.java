package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.i, androidx.lifecycle.w, androidx.savedstate.c {
    static final Object y0 = new Object();
    boolean C;
    boolean D;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    int K;
    p1 M;
    s0<?> O;
    Fragment Q;
    int U;
    int V;
    String W;
    boolean Z;
    boolean a0;
    boolean b0;
    boolean c0;
    Bundle d;
    boolean d0;
    SparseArray<Parcelable> e;
    Bundle f;
    private boolean f0;
    Boolean g;
    ViewGroup g0;
    View h0;

    /* renamed from: i, reason: collision with root package name */
    Bundle f231i;
    boolean i0;

    /* renamed from: j, reason: collision with root package name */
    Fragment f232j;
    a0 k0;
    boolean l0;
    boolean m0;
    float n0;
    LayoutInflater o0;
    boolean p0;
    androidx.lifecycle.k r0;
    z2 s0;
    int t;
    androidx.savedstate.b u0;
    private int v0;
    int c = -1;

    /* renamed from: h, reason: collision with root package name */
    String f230h = UUID.randomUUID().toString();

    /* renamed from: k, reason: collision with root package name */
    String f233k = null;
    private Boolean A = null;
    p1 P = new q1();
    boolean e0 = true;
    boolean j0 = true;
    f.b q0 = f.b.RESUMED;
    androidx.lifecycle.n<androidx.lifecycle.i> t0 = new androidx.lifecycle.n<>();
    private final AtomicInteger w0 = new AtomicInteger();
    private final ArrayList<c0> x0 = new ArrayList<>();

    public Fragment() {
        a0();
    }

    private void B1() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.h0 != null) {
            C1(this.d);
        }
        this.d = null;
    }

    private int I() {
        f.b bVar = this.q0;
        return (bVar == f.b.INITIALIZED || this.Q == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.Q.I());
    }

    private void a0() {
        this.r0 = new androidx.lifecycle.k(this);
        this.u0 = androidx.savedstate.b.a(this);
    }

    @Deprecated
    public static Fragment c0(Context context, String str, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Fragment fragmentNewInstance = r0.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.G1(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e) {
            throw new b0("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new b0("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new b0("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new b0("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    private a0 m() {
        if (this.k0 == null) {
            this.k0 = new a0();
        }
        return this.k0;
    }

    private <I, O> androidx.activity.result.d<I> u1(androidx.activity.result.l.b<I, O> bVar, h.b.a.c.a<Void, ActivityResultRegistry> aVar, androidx.activity.result.c<O> cVar) {
        if (this.c <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            w1(new y(this, aVar, atomicReference, bVar, cVar));
            return new z(this, atomicReference, bVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void w1(c0 c0Var) {
        if (this.c >= 0) {
            c0Var.a();
        } else {
            this.x0.add(c0Var);
        }
    }

    androidx.core.app.q A() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.s;
    }

    public void A0() {
        this.f0 = true;
    }

    void A1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.P.d1(parcelable);
        this.P.C();
    }

    int B() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 0;
        }
        return a0Var.e;
    }

    public void B0() {
    }

    public Object C() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f242m;
    }

    public void C0() {
        this.f0 = true;
    }

    final void C1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.h0.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        if (this.h0 != null) {
            this.s0.e(this.f);
            this.f = null;
        }
        this.f0 = false;
        V0(bundle);
        if (this.f0) {
            if (this.h0 != null) {
                this.s0.a(f.a.ON_CREATE);
            }
        } else {
            throw new l3("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    androidx.core.app.q D() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.t;
    }

    public void D0() {
        this.f0 = true;
    }

    void D1(View view) {
        m().a = view;
    }

    View E() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.v;
    }

    public LayoutInflater E0(Bundle bundle) {
        return H(bundle);
    }

    void E1(int i2, int i3, int i4, int i5) {
        if (this.k0 == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        m().d = i2;
        m().e = i3;
        m().f = i4;
        m().g = i5;
    }

    @Deprecated
    public final p1 F() {
        return this.M;
    }

    public void F0(boolean z) {
    }

    void F1(Animator animator) {
        m().b = animator;
    }

    public final Object G() {
        s0<?> s0Var = this.O;
        if (s0Var == null) {
            return null;
        }
        return s0Var.l();
    }

    @Deprecated
    public void G0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f0 = true;
    }

    public void G1(Bundle bundle) {
        if (this.M != null && m0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f231i = bundle;
    }

    @Deprecated
    public LayoutInflater H(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        s0<?> s0Var = this.O;
        if (s0Var == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterM = s0Var.m();
        h.e.j.q.b(layoutInflaterM, this.P.u0());
        return layoutInflaterM;
    }

    public void H0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f0 = true;
        s0<?> s0Var = this.O;
        Activity activityH = s0Var == null ? null : s0Var.h();
        if (activityH != null) {
            this.f0 = false;
            G0(activityH, attributeSet, bundle);
        }
    }

    void H1(View view) {
        m().v = view;
    }

    public void I0(boolean z) {
    }

    void I1(boolean z) {
        m().y = z;
    }

    int J() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 0;
        }
        return a0Var.f237h;
    }

    public boolean J0(MenuItem menuItem) {
        return false;
    }

    void J1(int i2) {
        if (this.k0 == null && i2 == 0) {
            return;
        }
        m();
        this.k0.f237h = i2;
    }

    public final Fragment K() {
        return this.Q;
    }

    public void K0(Menu menu) {
    }

    void K1(d0 d0Var) {
        m();
        a0 a0Var = this.k0;
        d0 d0Var2 = a0Var.x;
        if (d0Var == d0Var2) {
            return;
        }
        if (d0Var != null && d0Var2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (a0Var.w) {
            a0Var.x = d0Var;
        }
        if (d0Var != null) {
            d0Var.a();
        }
    }

    public final p1 L() {
        p1 p1Var = this.M;
        if (p1Var != null) {
            return p1Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void L0() {
        this.f0 = true;
    }

    void L1(boolean z) {
        if (this.k0 == null) {
            return;
        }
        m().c = z;
    }

    boolean M() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return false;
        }
        return a0Var.c;
    }

    public void M0(boolean z) {
    }

    void M1(float f) {
        m().u = f;
    }

    int N() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 0;
        }
        return a0Var.f;
    }

    public void N0(Menu menu) {
    }

    void N1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        m();
        a0 a0Var = this.k0;
        a0Var.f238i = arrayList;
        a0Var.f239j = arrayList2;
    }

    int O() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 0;
        }
        return a0Var.g;
    }

    public void O0(boolean z) {
    }

    @Deprecated
    public void O1(Fragment fragment, int i2) {
        p1 p1Var = this.M;
        p1 p1Var2 = fragment != null ? fragment.M : null;
        if (p1Var != null && p1Var2 != null && p1Var != p1Var2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentX = fragment; fragmentX != null; fragmentX = fragmentX.X()) {
            if (fragmentX.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.f233k = null;
            this.f232j = null;
        } else if (this.M == null || fragment.M == null) {
            this.f233k = null;
            this.f232j = fragment;
        } else {
            this.f233k = fragment.f230h;
            this.f232j = null;
        }
        this.t = i2;
    }

    float P() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 1.0f;
        }
        return a0Var.u;
    }

    @Deprecated
    public void P0(int i2, String[] strArr, int[] iArr) {
    }

    public void P1(@SuppressLint({"UnknownNullness"}) Intent intent) {
        Q1(intent, null);
    }

    public Object Q() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        Object obj = a0Var.f243n;
        return obj == y0 ? C() : obj;
    }

    public void Q0() {
        this.f0 = true;
    }

    public void Q1(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        s0<?> s0Var = this.O;
        if (s0Var != null) {
            s0Var.p(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final Resources R() {
        return y1().getResources();
    }

    public void R0(Bundle bundle) {
    }

    @Deprecated
    public void R1(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        S1(intent, i2, null);
    }

    public Object S() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        Object obj = a0Var.f241l;
        return obj == y0 ? z() : obj;
    }

    public void S0() {
        this.f0 = true;
    }

    @Deprecated
    public void S1(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.O != null) {
            L().L0(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Object T() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f244o;
    }

    public void T0() {
        this.f0 = true;
    }

    public void T1() {
        if (this.k0 == null || !m().w) {
            return;
        }
        if (this.O == null) {
            m().w = false;
        } else if (Looper.myLooper() != this.O.j().getLooper()) {
            this.O.j().postAtFrontOfQueue(new u(this));
        } else {
            i(true);
        }
    }

    public Object U() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        Object obj = a0Var.p;
        return obj == y0 ? T() : obj;
    }

    public void U0(View view, Bundle bundle) {
    }

    ArrayList<String> V() {
        ArrayList<String> arrayList;
        a0 a0Var = this.k0;
        return (a0Var == null || (arrayList = a0Var.f238i) == null) ? new ArrayList<>() : arrayList;
    }

    public void V0(Bundle bundle) {
        this.f0 = true;
    }

    ArrayList<String> W() {
        ArrayList<String> arrayList;
        a0 a0Var = this.k0;
        return (a0Var == null || (arrayList = a0Var.f239j) == null) ? new ArrayList<>() : arrayList;
    }

    void W0(Bundle bundle) {
        this.P.R0();
        this.c = 3;
        this.f0 = false;
        p0(bundle);
        if (this.f0) {
            B1();
            this.P.y();
        } else {
            throw new l3("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    @Deprecated
    public final Fragment X() {
        String str;
        Fragment fragment = this.f232j;
        if (fragment != null) {
            return fragment;
        }
        p1 p1Var = this.M;
        if (p1Var == null || (str = this.f233k) == null) {
            return null;
        }
        return p1Var.g0(str);
    }

    void X0() {
        Iterator<c0> it = this.x0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.x0.clear();
        this.P.j(this.O, j(), this);
        this.c = 0;
        this.f0 = false;
        s0(this.O.i());
        if (this.f0) {
            this.M.I(this);
            this.P.z();
        } else {
            throw new l3("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public View Y() {
        return this.h0;
    }

    void Y0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.P.A(configuration);
    }

    public LiveData<androidx.lifecycle.i> Z() {
        return this.t0;
    }

    boolean Z0(MenuItem menuItem) {
        if (this.Z) {
            return false;
        }
        if (u0(menuItem)) {
            return true;
        }
        return this.P.B(menuItem);
    }

    void a1(Bundle bundle) {
        this.P.R0();
        this.c = 1;
        this.f0 = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.r0.a(new androidx.lifecycle.g() { // from class: androidx.fragment.app.Fragment.5
                @Override // androidx.lifecycle.g
                public void a(androidx.lifecycle.i iVar, f.a aVar) {
                    View view;
                    if (aVar != f.a.ON_STOP || (view = Fragment.this.h0) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
        this.u0.c(bundle);
        v0(bundle);
        this.p0 = true;
        if (this.f0) {
            this.r0.h(f.a.ON_CREATE);
            return;
        }
        throw new l3("Fragment " + this + " did not call through to super.onCreate()");
    }

    @Override // androidx.savedstate.c
    public final SavedStateRegistry b() {
        return this.u0.b();
    }

    void b0() {
        a0();
        this.f230h = UUID.randomUUID().toString();
        this.C = false;
        this.D = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.K = 0;
        this.M = null;
        this.P = new q1();
        this.O = null;
        this.U = 0;
        this.V = 0;
        this.W = null;
        this.Z = false;
        this.a0 = false;
    }

    boolean b1(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.Z) {
            return false;
        }
        if (this.d0 && this.e0) {
            z = true;
            y0(menu, menuInflater);
        }
        return z | this.P.D(menu, menuInflater);
    }

    void c1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.P.R0();
        this.J = true;
        this.s0 = new z2(this, f());
        View viewZ0 = z0(layoutInflater, viewGroup, bundle);
        this.h0 = viewZ0;
        if (viewZ0 == null) {
            if (this.s0.d()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.s0 = null;
        } else {
            this.s0.c();
            androidx.lifecycle.x.a(this.h0, this.s0);
            androidx.lifecycle.y.a(this.h0, this.s0);
            androidx.savedstate.d.a(this.h0, this.s0);
            this.t0.i(this.s0);
        }
    }

    public final boolean d0() {
        return this.O != null && this.C;
    }

    void d1() {
        this.P.E();
        this.r0.h(f.a.ON_DESTROY);
        this.c = 0;
        this.f0 = false;
        this.p0 = false;
        A0();
        if (this.f0) {
            return;
        }
        throw new l3("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public final boolean e0() {
        return this.a0;
    }

    void e1() {
        this.P.F();
        if (this.h0 != null && this.s0.o().b().a(f.b.CREATED)) {
            this.s0.a(f.a.ON_DESTROY);
        }
        this.c = 1;
        this.f0 = false;
        C0();
        if (this.f0) {
            h.l.a.a.b(this).c();
            this.J = false;
        } else {
            throw new l3("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.w
    public androidx.lifecycle.v f() {
        if (this.M == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (I() != f.b.INITIALIZED.ordinal()) {
            return this.M.A0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final boolean f0() {
        return this.Z;
    }

    void f1() {
        this.c = -1;
        this.f0 = false;
        D0();
        this.o0 = null;
        if (this.f0) {
            if (this.P.E0()) {
                return;
            }
            this.P.E();
            this.P = new q1();
            return;
        }
        throw new l3("Fragment " + this + " did not call through to super.onDetach()");
    }

    boolean g0() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return false;
        }
        return a0Var.y;
    }

    LayoutInflater g1(Bundle bundle) {
        LayoutInflater layoutInflaterE0 = E0(bundle);
        this.o0 = layoutInflaterE0;
        return layoutInflaterE0;
    }

    final boolean h0() {
        return this.K > 0;
    }

    void h1() {
        onLowMemory();
        this.P.G();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void i(boolean z) {
        ViewGroup viewGroup;
        p1 p1Var;
        a0 a0Var = this.k0;
        d0 d0Var = null;
        if (a0Var != null) {
            a0Var.w = false;
            d0 d0Var2 = a0Var.x;
            a0Var.x = null;
            d0Var = d0Var2;
        }
        if (d0Var != null) {
            d0Var.b();
            return;
        }
        if (!p1.P || this.h0 == null || (viewGroup = this.g0) == null || (p1Var = this.M) == null) {
            return;
        }
        j3 j3VarN = j3.n(viewGroup, p1Var);
        j3VarN.p();
        if (z) {
            this.O.j().post(new v(this, j3VarN));
        } else {
            j3VarN.g();
        }
    }

    public final boolean i0() {
        p1 p1Var;
        return this.e0 && ((p1Var = this.M) == null || p1Var.H0(this.Q));
    }

    void i1(boolean z) {
        I0(z);
        this.P.H(z);
    }

    p0 j() {
        return new w(this);
    }

    boolean j0() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return false;
        }
        return a0Var.w;
    }

    boolean j1(MenuItem menuItem) {
        if (this.Z) {
            return false;
        }
        if (this.d0 && this.e0 && J0(menuItem)) {
            return true;
        }
        return this.P.J(menuItem);
    }

    public final boolean k0() {
        return this.D;
    }

    void k1(Menu menu) {
        if (this.Z) {
            return;
        }
        if (this.d0 && this.e0) {
            K0(menu);
        }
        this.P.K(menu);
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.U));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.V));
        printWriter.print(" mTag=");
        printWriter.println(this.W);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.c);
        printWriter.print(" mWho=");
        printWriter.print(this.f230h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.K);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.C);
        printWriter.print(" mRemoving=");
        printWriter.print(this.D);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.G);
        printWriter.print(" mInLayout=");
        printWriter.println(this.H);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.Z);
        printWriter.print(" mDetached=");
        printWriter.print(this.a0);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.e0);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.d0);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.b0);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.j0);
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.M);
        }
        if (this.O != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.O);
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.Q);
        }
        if (this.f231i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f231i);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.e);
        }
        if (this.f != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f);
        }
        Fragment fragmentX = X();
        if (fragmentX != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentX);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(M());
        if (y() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(y());
        }
        if (B() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(B());
        }
        if (N() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(N());
        }
        if (O() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(O());
        }
        if (this.g0 != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.g0);
        }
        if (this.h0 != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.h0);
        }
        if (t() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(t());
        }
        if (x() != null) {
            h.l.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.P + ParameterizedMessage.ERROR_MSG_SEPARATOR);
        this.P.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    final boolean l0() {
        Fragment fragmentK = K();
        return fragmentK != null && (fragmentK.k0() || fragmentK.l0());
    }

    void l1() {
        this.P.M();
        if (this.h0 != null) {
            this.s0.a(f.a.ON_PAUSE);
        }
        this.r0.h(f.a.ON_PAUSE);
        this.c = 6;
        this.f0 = false;
        L0();
        if (this.f0) {
            return;
        }
        throw new l3("Fragment " + this + " did not call through to super.onPause()");
    }

    public final boolean m0() {
        p1 p1Var = this.M;
        if (p1Var == null) {
            return false;
        }
        return p1Var.K0();
    }

    void m1(boolean z) {
        M0(z);
        this.P.N(z);
    }

    Fragment n(String str) {
        return str.equals(this.f230h) ? this : this.P.j0(str);
    }

    public final boolean n0() {
        View view;
        return (!d0() || f0() || (view = this.h0) == null || view.getWindowToken() == null || this.h0.getVisibility() != 0) ? false : true;
    }

    boolean n1(Menu menu) {
        boolean z = false;
        if (this.Z) {
            return false;
        }
        if (this.d0 && this.e0) {
            z = true;
            N0(menu);
        }
        return z | this.P.O(menu);
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.f o() {
        return this.r0;
    }

    void o0() {
        this.P.R0();
    }

    void o1() {
        boolean zI0 = this.M.I0(this);
        Boolean bool = this.A;
        if (bool == null || bool.booleanValue() != zI0) {
            this.A = Boolean.valueOf(zI0);
            O0(zI0);
            this.P.P();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f0 = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        x1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f0 = true;
    }

    String p() {
        return "fragment_" + this.f230h + "_rq#" + this.w0.getAndIncrement();
    }

    @Deprecated
    public void p0(Bundle bundle) {
        this.f0 = true;
    }

    void p1() {
        this.P.R0();
        this.P.a0(true);
        this.c = 7;
        this.f0 = false;
        Q0();
        if (!this.f0) {
            throw new l3("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.k kVar = this.r0;
        f.a aVar = f.a.ON_RESUME;
        kVar.h(aVar);
        if (this.h0 != null) {
            this.s0.a(aVar);
        }
        this.P.Q();
    }

    public final h0 q() {
        s0<?> s0Var = this.O;
        if (s0Var == null) {
            return null;
        }
        return (h0) s0Var.h();
    }

    @Deprecated
    public void q0(int i2, int i3, Intent intent) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    void q1(Bundle bundle) {
        R0(bundle);
        this.u0.d(bundle);
        Parcelable parcelableF1 = this.P.f1();
        if (parcelableF1 != null) {
            bundle.putParcelable("android:support:fragments", parcelableF1);
        }
    }

    public boolean r() {
        Boolean bool;
        a0 a0Var = this.k0;
        if (a0Var == null || (bool = a0Var.r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public void r0(Activity activity) {
        this.f0 = true;
    }

    void r1() {
        this.P.R0();
        this.P.a0(true);
        this.c = 5;
        this.f0 = false;
        S0();
        if (!this.f0) {
            throw new l3("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.k kVar = this.r0;
        f.a aVar = f.a.ON_START;
        kVar.h(aVar);
        if (this.h0 != null) {
            this.s0.a(aVar);
        }
        this.P.R();
    }

    public boolean s() {
        Boolean bool;
        a0 a0Var = this.k0;
        if (a0Var == null || (bool = a0Var.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void s0(Context context) {
        this.f0 = true;
        s0<?> s0Var = this.O;
        Activity activityH = s0Var == null ? null : s0Var.h();
        if (activityH != null) {
            this.f0 = false;
            r0(activityH);
        }
    }

    void s1() {
        this.P.T();
        if (this.h0 != null) {
            this.s0.a(f.a.ON_STOP);
        }
        this.r0.h(f.a.ON_STOP);
        this.c = 4;
        this.f0 = false;
        T0();
        if (this.f0) {
            return;
        }
        throw new l3("Fragment " + this + " did not call through to super.onStop()");
    }

    View t() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.a;
    }

    @Deprecated
    public void t0(Fragment fragment) {
    }

    void t1() {
        U0(this.h0, this.d);
        this.P.U();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f230h);
        if (this.U != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.U));
        }
        if (this.W != null) {
            sb.append(" tag=");
            sb.append(this.W);
        }
        sb.append(")");
        return sb.toString();
    }

    Animator u() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.b;
    }

    public boolean u0(MenuItem menuItem) {
        return false;
    }

    public final Bundle v() {
        return this.f231i;
    }

    public void v0(Bundle bundle) {
        this.f0 = true;
        A1(bundle);
        if (this.P.J0(1)) {
            return;
        }
        this.P.C();
    }

    public final <I, O> androidx.activity.result.d<I> v1(androidx.activity.result.l.b<I, O> bVar, androidx.activity.result.c<O> cVar) {
        return u1(bVar, new x(this), cVar);
    }

    public final p1 w() {
        if (this.O != null) {
            return this.P;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Animation w0(int i2, boolean z, int i3) {
        return null;
    }

    public Context x() {
        s0<?> s0Var = this.O;
        if (s0Var == null) {
            return null;
        }
        return s0Var.i();
    }

    public Animator x0(int i2, boolean z, int i3) {
        return null;
    }

    public final h0 x1() {
        h0 h0VarQ = q();
        if (h0VarQ != null) {
            return h0VarQ;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    int y() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return 0;
        }
        return a0Var.d;
    }

    public void y0(Menu menu, MenuInflater menuInflater) {
    }

    public final Context y1() {
        Context contextX = x();
        if (contextX != null) {
            return contextX;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public Object z() {
        a0 a0Var = this.k0;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f240k;
    }

    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.v0;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public final View z1() {
        View viewY = Y();
        if (viewY != null) {
            return viewY;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }
}
