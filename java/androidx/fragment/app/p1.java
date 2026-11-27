package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.f;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class p1 {
    private static boolean O = false;
    static boolean P = true;
    private androidx.activity.result.d<androidx.activity.result.k> A;
    private androidx.activity.result.d<String[]> B;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<a> I;
    private ArrayList<Boolean> J;
    private ArrayList<Fragment> K;
    private ArrayList<o1> L;
    private u1 M;
    private boolean b;
    ArrayList<a> d;
    private ArrayList<Fragment> e;
    private OnBackPressedDispatcher g;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<l1> f272l;
    private s0<?> r;
    private p0 s;
    private Fragment t;
    Fragment u;
    private androidx.activity.result.d<Intent> z;
    private final ArrayList<m1> a = new ArrayList<>();
    private final c2 c = new c2();
    private final u0 f = new u0(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.i f268h = new z0(this, false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f269i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Bundle> f270j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f271k = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    private Map<Fragment, HashSet<h.e.f.c>> f273m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final m2 f274n = new a1(this);

    /* renamed from: o, reason: collision with root package name */
    private final w0 f275o = new w0(this);
    private final CopyOnWriteArrayList<v1> p = new CopyOnWriteArrayList<>();
    int q = -1;
    private r0 v = null;
    private r0 w = new b1(this);
    private k3 x = null;
    private k3 y = new c1(this);
    ArrayDeque<k1> C = new ArrayDeque<>();
    private Runnable N = new d1(this);

    static boolean F0(int i2) {
        return O || Log.isLoggable("FragmentManager", i2);
    }

    private boolean G0(Fragment fragment) {
        return (fragment.d0 && fragment.e0) || fragment.P.n();
    }

    private void L(Fragment fragment) {
        if (fragment == null || !fragment.equals(g0(fragment.f230h))) {
            return;
        }
        fragment.o1();
    }

    private void M0(h.d.d<Fragment> dVar) {
        int size = dVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragmentL = dVar.l(i2);
            if (!fragmentL.C) {
                View viewZ1 = fragmentL.z1();
                fragmentL.n0 = viewZ1.getAlpha();
                viewZ1.setAlpha(0.0f);
            }
        }
    }

    private void S(int i2) {
        try {
            this.b = true;
            this.c.d(i2);
            O0(i2, false);
            if (P) {
                Iterator<j3> it = r().iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
            this.b = false;
            a0(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    private void V() {
        if (this.H) {
            this.H = false;
            m1();
        }
    }

    private boolean W0(String str, int i2, int i3) {
        a0(false);
        Z(true);
        Fragment fragment = this.u;
        if (fragment != null && i2 < 0 && str == null && fragment.w().V0()) {
            return true;
        }
        boolean zX0 = X0(this.I, this.J, str, i2, i3);
        if (zX0) {
            this.b = true;
            try {
                b1(this.I, this.J);
            } finally {
                p();
            }
        }
        n1();
        V();
        this.c.b();
        return zX0;
    }

    private void X() {
        if (P) {
            Iterator<j3> it = r().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        } else {
            if (this.f273m.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f273m.keySet()) {
                m(fragment);
                P0(fragment);
            }
        }
    }

    private int Y0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, h.d.d<Fragment> dVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean zBooleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.C() && !aVar.A(arrayList, i5 + 1, i3)) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                o1 o1Var = new o1(aVar, zBooleanValue);
                this.L.add(o1Var);
                aVar.E(o1Var);
                if (zBooleanValue) {
                    aVar.v();
                } else {
                    aVar.w(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                d(dVar);
            }
        }
        return i4;
    }

    private void Z(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.r == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.r.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            o();
        }
        if (this.I == null) {
            this.I = new ArrayList<>();
            this.J = new ArrayList<>();
        }
        this.b = true;
        try {
            f0(null, null);
        } finally {
            this.b = false;
        }
    }

    private void b1(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        f0(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).f258o) {
                if (i3 != i2) {
                    d0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).f258o) {
                        i3++;
                    }
                }
                d0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            d0(arrayList, arrayList2, i3, size);
        }
    }

    private static void c0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.r(-1);
                aVar.w(i2 == i3 + (-1));
            } else {
                aVar.r(1);
                aVar.v();
            }
            i2++;
        }
    }

    private void c1() {
        if (this.f272l != null) {
            for (int i2 = 0; i2 < this.f272l.size(); i2++) {
                this.f272l.get(i2).a();
            }
        }
    }

    private void d(h.d.d<Fragment> dVar) {
        int i2 = this.q;
        if (i2 < 1) {
            return;
        }
        int iMin = Math.min(i2, 5);
        for (Fragment fragment : this.c.n()) {
            if (fragment.c < iMin) {
                Q0(fragment, iMin);
                if (fragment.h0 != null && !fragment.Z && fragment.l0) {
                    dVar.add(fragment);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    private void d0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ?? r1;
        int i4;
        boolean z;
        int i5;
        int i6;
        ArrayList<Boolean> arrayList3;
        int iY0;
        ArrayList<Boolean> arrayList4;
        int i7;
        boolean z2;
        boolean z3 = arrayList.get(i2).f258o;
        ArrayList<Fragment> arrayList5 = this.K;
        if (arrayList5 == null) {
            this.K = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.K.addAll(this.c.n());
        Fragment fragmentX0 = x0();
        boolean z4 = false;
        for (int i8 = i2; i8 < i3; i8++) {
            a aVar = arrayList.get(i8);
            fragmentX0 = !arrayList2.get(i8).booleanValue() ? aVar.x(this.K, fragmentX0) : aVar.F(this.K, fragmentX0);
            z4 = z4 || aVar.g;
        }
        this.K.clear();
        if (z3 || this.q < 1) {
            r1 = 1;
        } else if (P) {
            for (int i9 = i2; i9 < i3; i9++) {
                Iterator<e2> it = arrayList.get(i9).a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().b;
                    if (fragment != null && fragment.M != null) {
                        this.c.p(v(fragment));
                    }
                }
            }
            r1 = 1;
        } else {
            r1 = 1;
            o2.C(this.r.i(), this.s, arrayList, arrayList2, i2, i3, false, this.f274n);
        }
        c0(arrayList, arrayList2, i2, i3);
        if (P) {
            boolean zBooleanValue = arrayList2.get(i3 - 1).booleanValue();
            for (int i10 = i2; i10 < i3; i10++) {
                a aVar2 = arrayList.get(i10);
                if (zBooleanValue) {
                    for (int size = aVar2.a.size() - r1; size >= 0; size--) {
                        Fragment fragment2 = aVar2.a.get(size).b;
                        if (fragment2 != null) {
                            v(fragment2).m();
                        }
                    }
                } else {
                    Iterator<e2> it2 = aVar2.a.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = it2.next().b;
                        if (fragment3 != null) {
                            v(fragment3).m();
                        }
                    }
                }
            }
            O0(this.q, r1);
            for (j3 j3Var : s(arrayList, i2, i3)) {
                j3Var.r(zBooleanValue);
                j3Var.p();
                j3Var.g();
            }
            i7 = i3;
            arrayList4 = arrayList2;
        } else {
            if (z3) {
                h.d.d dVar = new h.d.d();
                d(dVar);
                i4 = r1;
                z = z3;
                i5 = i3;
                i6 = i2;
                arrayList3 = arrayList2;
                iY0 = Y0(arrayList, arrayList2, i2, i3, dVar);
                M0(dVar);
            } else {
                i4 = r1;
                z = z3;
                i5 = i3;
                i6 = i2;
                arrayList3 = arrayList2;
                iY0 = i5;
            }
            if (iY0 == i6 || !z) {
                arrayList4 = arrayList3;
                i7 = i5;
            } else {
                if (this.q >= i4) {
                    arrayList4 = arrayList3;
                    int i11 = iY0;
                    i7 = i5;
                    z2 = i4;
                    o2.C(this.r.i(), this.s, arrayList, arrayList2, i2, i11, true, this.f274n);
                } else {
                    arrayList4 = arrayList3;
                    i7 = i5;
                    z2 = i4;
                }
                O0(this.q, z2);
            }
        }
        for (int i12 = i2; i12 < i7; i12++) {
            a aVar3 = arrayList.get(i12);
            if (arrayList4.get(i12).booleanValue() && aVar3.s >= 0) {
                aVar3.s = -1;
            }
            aVar3.D();
        }
        if (z4) {
            c1();
        }
    }

    static int e1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void f0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<o1> arrayList3 = this.L;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            o1 o1Var = this.L.get(i2);
            if (arrayList != null && !o1Var.a && (iIndexOf2 = arrayList.indexOf(o1Var.b)) != -1 && arrayList2 != null && arrayList2.get(iIndexOf2).booleanValue()) {
                this.L.remove(i2);
                i2--;
                size--;
                o1Var.c();
            } else if (o1Var.e() || (arrayList != null && o1Var.b.A(arrayList, 0, arrayList.size()))) {
                this.L.remove(i2);
                i2--;
                size--;
                if (arrayList == null || o1Var.a || (iIndexOf = arrayList.indexOf(o1Var.b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                    o1Var.d();
                } else {
                    o1Var.c();
                }
            }
            i2++;
        }
    }

    private void k0() {
        if (P) {
            Iterator<j3> it = r().iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    private void k1(Fragment fragment) {
        ViewGroup viewGroupP0 = p0(fragment);
        if (viewGroupP0 == null || fragment.y() + fragment.B() + fragment.N() + fragment.O() <= 0) {
            return;
        }
        int i2 = h.j.b.c;
        if (viewGroupP0.getTag(i2) == null) {
            viewGroupP0.setTag(i2, fragment);
        }
        ((Fragment) viewGroupP0.getTag(i2)).L1(fragment.M());
    }

    private boolean l0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return false;
            }
            int size = this.a.size();
            boolean zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= this.a.get(i2).a(arrayList, arrayList2);
            }
            this.a.clear();
            this.r.j().removeCallbacks(this.N);
            return zA;
        }
    }

    private void m(Fragment fragment) {
        HashSet<h.e.f.c> hashSet = this.f273m.get(fragment);
        if (hashSet != null) {
            Iterator<h.e.f.c> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            w(fragment);
            this.f273m.remove(fragment);
        }
    }

    private void m1() {
        Iterator<b2> it = this.c.k().iterator();
        while (it.hasNext()) {
            T0(it.next());
        }
    }

    private u1 n0(Fragment fragment) {
        return this.M.h(fragment);
    }

    private void n1() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                this.f268h.f(m0() > 0 && I0(this.t));
            } else {
                this.f268h.f(true);
            }
        }
    }

    private void o() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void p() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    private ViewGroup p0(Fragment fragment) {
        ViewGroup viewGroup = fragment.g0;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.V > 0 && this.s.g()) {
            View viewD = this.s.d(fragment.V);
            if (viewD instanceof ViewGroup) {
                return (ViewGroup) viewD;
            }
        }
        return null;
    }

    private Set<j3> r() {
        HashSet hashSet = new HashSet();
        Iterator<b2> it = this.c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().g0;
            if (viewGroup != null) {
                hashSet.add(j3.o(viewGroup, y0()));
            }
        }
        return hashSet;
    }

    private Set<j3> s(ArrayList<a> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<e2> it = arrayList.get(i2).a.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().b;
                if (fragment != null && (viewGroup = fragment.g0) != null) {
                    hashSet.add(j3.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void u(Fragment fragment) {
        Animator animator;
        if (fragment.h0 != null) {
            m0 m0VarC = o0.c(this.r.i(), fragment, !fragment.Z, fragment.M());
            if (m0VarC == null || (animator = m0VarC.b) == null) {
                if (m0VarC != null) {
                    fragment.h0.startAnimation(m0VarC.a);
                    m0VarC.a.start();
                }
                fragment.h0.setVisibility((!fragment.Z || fragment.g0()) ? 0 : 8);
                if (fragment.g0()) {
                    fragment.I1(false);
                }
            } else {
                animator.setTarget(fragment.h0);
                if (!fragment.Z) {
                    fragment.h0.setVisibility(0);
                } else if (fragment.g0()) {
                    fragment.I1(false);
                } else {
                    ViewGroup viewGroup = fragment.g0;
                    View view = fragment.h0;
                    viewGroup.startViewTransition(view);
                    m0VarC.b.addListener(new e1(this, viewGroup, view, fragment));
                }
                m0VarC.b.start();
            }
        }
        D0(fragment);
        fragment.m0 = false;
        fragment.F0(fragment.Z);
    }

    private void w(Fragment fragment) {
        fragment.e1();
        this.f275o.n(fragment, false);
        fragment.g0 = null;
        fragment.h0 = null;
        fragment.s0 = null;
        fragment.t0.i(null);
        fragment.H = false;
    }

    static Fragment z0(View view) {
        Object tag = view.getTag(h.j.b.a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    void A(Configuration configuration) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.Y0(configuration);
            }
        }
    }

    androidx.lifecycle.v A0(Fragment fragment) {
        return this.M.k(fragment);
    }

    boolean B(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && fragment.Z0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void B0() {
        a0(true);
        if (this.f268h.c()) {
            V0();
        } else {
            this.g.c();
        }
    }

    void C() {
        this.E = false;
        this.F = false;
        this.M.n(false);
        S(1);
    }

    void C0(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.Z) {
            return;
        }
        fragment.Z = true;
        fragment.m0 = true ^ fragment.m0;
        k1(fragment);
    }

    boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && H0(fragment) && fragment.b1(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.B0();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    void D0(Fragment fragment) {
        if (fragment.C && G0(fragment)) {
            this.D = true;
        }
    }

    void E() {
        this.G = true;
        a0(true);
        X();
        S(-1);
        this.r = null;
        this.s = null;
        this.t = null;
        if (this.g != null) {
            this.f268h.d();
            this.g = null;
        }
        androidx.activity.result.d<Intent> dVar = this.z;
        if (dVar != null) {
            dVar.c();
            this.A.c();
            this.B.c();
        }
    }

    public boolean E0() {
        return this.G;
    }

    void F() {
        S(1);
    }

    void G() {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.h1();
            }
        }
    }

    void H(boolean z) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.i1(z);
            }
        }
    }

    boolean H0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.i0();
    }

    void I(Fragment fragment) {
        Iterator<v1> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        p1 p1Var = fragment.M;
        return fragment.equals(p1Var.x0()) && I0(p1Var.t);
    }

    boolean J(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && fragment.j1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean J0(int i2) {
        return this.q >= i2;
    }

    void K(Menu menu) {
        if (this.q < 1) {
            return;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.k1(menu);
            }
        }
    }

    public boolean K0() {
        return this.E || this.F;
    }

    void L0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.z == null) {
            this.r.p(fragment, intent, i2, bundle);
            return;
        }
        this.C.addLast(new k1(fragment.f230h, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.z.a(intent);
    }

    void M() {
        S(5);
    }

    void N(boolean z) {
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.m1(z);
            }
        }
    }

    void N0(Fragment fragment) {
        if (!this.c.c(fragment.f230h)) {
            if (F0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.q + "since it is not added to " + this);
                return;
            }
            return;
        }
        P0(fragment);
        View view = fragment.h0;
        if (view != null && fragment.l0 && fragment.g0 != null) {
            float f = fragment.n0;
            if (f > 0.0f) {
                view.setAlpha(f);
            }
            fragment.n0 = 0.0f;
            fragment.l0 = false;
            m0 m0VarC = o0.c(this.r.i(), fragment, true, fragment.M());
            if (m0VarC != null) {
                Animation animation = m0VarC.a;
                if (animation != null) {
                    fragment.h0.startAnimation(animation);
                } else {
                    m0VarC.b.setTarget(fragment.h0);
                    m0VarC.b.start();
                }
            }
        }
        if (fragment.m0) {
            u(fragment);
        }
    }

    boolean O(Menu menu) {
        boolean z = false;
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.n()) {
            if (fragment != null && H0(fragment) && fragment.n1(menu)) {
                z = true;
            }
        }
        return z;
    }

    void O0(int i2, boolean z) {
        s0<?> s0Var;
        if (this.r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.q) {
            this.q = i2;
            if (P) {
                this.c.r();
            } else {
                Iterator<Fragment> it = this.c.n().iterator();
                while (it.hasNext()) {
                    N0(it.next());
                }
                for (b2 b2Var : this.c.k()) {
                    Fragment fragmentK = b2Var.k();
                    if (!fragmentK.l0) {
                        N0(fragmentK);
                    }
                    if (fragmentK.D && !fragmentK.h0()) {
                        this.c.q(b2Var);
                    }
                }
            }
            m1();
            if (this.D && (s0Var = this.r) != null && this.q == 7) {
                s0Var.q();
                this.D = false;
            }
        }
    }

    void P() {
        n1();
        L(this.u);
    }

    void P0(Fragment fragment) {
        Q0(fragment, this.q);
    }

    void Q() {
        this.E = false;
        this.F = false;
        this.M.n(false);
        S(7);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void Q0(Fragment fragment, int i2) {
        ViewGroup viewGroup;
        b2 b2VarM = this.c.m(fragment.f230h);
        int i3 = 1;
        if (b2VarM == null) {
            b2VarM = new b2(this.f275o, this.c, fragment);
            b2VarM.t(1);
        }
        if (fragment.G && fragment.H && fragment.c == 2) {
            i2 = Math.max(i2, 2);
        }
        int iMin = Math.min(i2, b2VarM.d());
        int i4 = fragment.c;
        if (i4 <= iMin) {
            if (i4 < iMin && !this.f273m.isEmpty()) {
                m(fragment);
            }
            int i5 = fragment.c;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                }
                            }
                            if (iMin > 5) {
                                b2VarM.p();
                            }
                        }
                        if (iMin > 4) {
                            b2VarM.u();
                        }
                        if (iMin > 5) {
                        }
                    }
                    if (iMin > 2) {
                        b2VarM.a();
                    }
                    if (iMin > 4) {
                    }
                    if (iMin > 5) {
                    }
                }
                if (iMin > -1) {
                    b2VarM.j();
                }
                if (iMin > 1) {
                    b2VarM.f();
                }
                if (iMin > 2) {
                }
                if (iMin > 4) {
                }
                if (iMin > 5) {
                }
            } else if (iMin > -1) {
                b2VarM.c();
            }
            if (iMin > 0) {
                b2VarM.e();
            }
            if (iMin > -1) {
            }
            if (iMin > 1) {
            }
            if (iMin > 2) {
            }
            if (iMin > 4) {
            }
            if (iMin > 5) {
            }
        } else if (i4 > iMin) {
            if (i4 == 0) {
                i3 = iMin;
                if (i3 < 0) {
                    b2VarM.i();
                }
                iMin = i3;
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (i4 == 7) {
                                    if (iMin < 7) {
                                        b2VarM.n();
                                    }
                                }
                            }
                            if (iMin < 5) {
                                b2VarM.v();
                            }
                        }
                        if (iMin < 4) {
                            if (F0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.h0 != null && this.r.n(fragment) && fragment.e == null) {
                                b2VarM.s();
                            }
                        }
                    }
                    if (iMin < 2) {
                        m0 m0VarC = null;
                        View view = fragment.h0;
                        if (view != null && (viewGroup = fragment.g0) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.h0.clearAnimation();
                            if (!fragment.l0()) {
                                if (this.q > -1 && !this.G && fragment.h0.getVisibility() == 0 && fragment.n0 >= 0.0f) {
                                    m0VarC = o0.c(this.r.i(), fragment, false, fragment.M());
                                }
                                fragment.n0 = 0.0f;
                                ViewGroup viewGroup2 = fragment.g0;
                                View view2 = fragment.h0;
                                if (m0VarC != null) {
                                    o0.a(fragment, m0VarC, this.f274n);
                                }
                                viewGroup2.removeView(view2);
                                if (F0(2)) {
                                    Log.v("FragmentManager", "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != fragment.g0) {
                                    return;
                                }
                            }
                        }
                        if (this.f273m.get(fragment) == null) {
                            b2VarM.h();
                        }
                    }
                }
                if (iMin < 1) {
                    if (this.f273m.get(fragment) == null) {
                        b2VarM.g();
                        i3 = iMin;
                    }
                    if (i3 < 0) {
                    }
                    iMin = i3;
                }
            }
        }
        if (fragment.c != iMin) {
            if (F0(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.c);
            }
            fragment.c = iMin;
        }
    }

    void R() {
        this.E = false;
        this.F = false;
        this.M.n(false);
        S(5);
    }

    void R0() {
        if (this.r == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.M.n(false);
        for (Fragment fragment : this.c.n()) {
            if (fragment != null) {
                fragment.o0();
            }
        }
    }

    void S0(FragmentContainerView fragmentContainerView) {
        View view;
        for (b2 b2Var : this.c.k()) {
            Fragment fragmentK = b2Var.k();
            if (fragmentK.V == fragmentContainerView.getId() && (view = fragmentK.h0) != null && view.getParent() == null) {
                fragmentK.g0 = fragmentContainerView;
                b2Var.b();
            }
        }
    }

    void T() {
        this.F = true;
        this.M.n(true);
        S(4);
    }

    void T0(b2 b2Var) {
        Fragment fragmentK = b2Var.k();
        if (fragmentK.i0) {
            if (this.b) {
                this.H = true;
                return;
            }
            fragmentK.i0 = false;
            if (P) {
                b2Var.m();
            } else {
                P0(fragmentK);
            }
        }
    }

    void U() {
        S(2);
    }

    public void U0(int i2, int i3) {
        if (i2 >= 0) {
            Y(new n1(this, null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public boolean V0() {
        return W0(null, -1, 0);
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<a> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.t(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f269i.get());
        synchronized (this.a) {
            int size3 = this.a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    m1 m1Var = this.a.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(m1Var);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.s);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    boolean X0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<a> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.d.get(size2);
                    if ((str != null && str.equals(aVar.y())) || (i2 >= 0 && i2 == aVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.d.get(size2);
                        if (str == null || !str.equals(aVar2.y())) {
                            if (i2 < 0 || i2 != aVar2.s) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    void Y(m1 m1Var, boolean z) {
        if (!z) {
            if (this.r == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            o();
        }
        synchronized (this.a) {
            if (this.r == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.a.add(m1Var);
                g1();
            }
        }
    }

    void Z0(Fragment fragment, h.e.f.c cVar) {
        HashSet<h.e.f.c> hashSet = this.f273m.get(fragment);
        if (hashSet != null && hashSet.remove(cVar) && hashSet.isEmpty()) {
            this.f273m.remove(fragment);
            if (fragment.c < 5) {
                w(fragment);
                P0(fragment);
            }
        }
    }

    boolean a0(boolean z) {
        Z(z);
        boolean z2 = false;
        while (l0(this.I, this.J)) {
            this.b = true;
            try {
                b1(this.I, this.J);
                p();
                z2 = true;
            } catch (Throwable th) {
                p();
                throw th;
            }
        }
        n1();
        V();
        this.c.b();
        return z2;
    }

    void a1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.K);
        }
        boolean z = !fragment.h0();
        if (!fragment.a0 || z) {
            this.c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            fragment.D = true;
            k1(fragment);
        }
    }

    void b0(m1 m1Var, boolean z) {
        if (z && (this.r == null || this.G)) {
            return;
        }
        Z(z);
        if (m1Var.a(this.I, this.J)) {
            this.b = true;
            try {
                b1(this.I, this.J);
            } finally {
                p();
            }
        }
        n1();
        V();
        this.c.b();
    }

    void d1(Parcelable parcelable) {
        b2 b2Var;
        if (parcelable == null) {
            return;
        }
        s1 s1Var = (s1) parcelable;
        if (s1Var.c == null) {
            return;
        }
        this.c.t();
        Iterator<y1> it = s1Var.c.iterator();
        while (it.hasNext()) {
            y1 next = it.next();
            if (next != null) {
                Fragment fragmentG = this.M.g(next.d);
                if (fragmentG != null) {
                    if (F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentG);
                    }
                    b2Var = new b2(this.f275o, this.c, fragmentG, next);
                } else {
                    b2Var = new b2(this.f275o, this.c, this.r.i().getClassLoader(), q0(), next);
                }
                Fragment fragmentK = b2Var.k();
                fragmentK.M = this;
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.f230h + "): " + fragmentK);
                }
                b2Var.o(this.r.i().getClassLoader());
                this.c.p(b2Var);
                b2Var.t(this.q);
            }
        }
        for (Fragment fragment : this.M.j()) {
            if (!this.c.c(fragment.f230h)) {
                if (F0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + s1Var.c);
                }
                this.M.m(fragment);
                fragment.M = this;
                b2 b2Var2 = new b2(this.f275o, this.c, fragment);
                b2Var2.t(1);
                b2Var2.m();
                fragment.D = true;
                b2Var2.m();
            }
        }
        this.c.u(s1Var.d);
        if (s1Var.e != null) {
            this.d = new ArrayList<>(s1Var.e.length);
            int i2 = 0;
            while (true) {
                c[] cVarArr = s1Var.e;
                if (i2 >= cVarArr.length) {
                    break;
                }
                a aVarA = cVarArr[i2].a(this);
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVarA.s + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new a3("FragmentManager"));
                    aVarA.u("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVarA);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.f269i.set(s1Var.f);
        String str = s1Var.g;
        if (str != null) {
            Fragment fragmentG0 = g0(str);
            this.u = fragmentG0;
            L(fragmentG0);
        }
        ArrayList<String> arrayList = s1Var.f276h;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundle = s1Var.f277i.get(i3);
                bundle.setClassLoader(this.r.i().getClassLoader());
                this.f270j.put(arrayList.get(i3), bundle);
            }
        }
        this.C = new ArrayDeque<>(s1Var.f278j);
    }

    void e(a aVar) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        this.d.add(aVar);
    }

    public boolean e0() {
        boolean zA0 = a0(true);
        k0();
        return zA0;
    }

    void f(Fragment fragment, h.e.f.c cVar) {
        if (this.f273m.get(fragment) == null) {
            this.f273m.put(fragment, new HashSet<>());
        }
        this.f273m.get(fragment).add(cVar);
    }

    Parcelable f1() {
        int size;
        k0();
        X();
        a0(true);
        this.E = true;
        this.M.n(true);
        ArrayList<y1> arrayListV = this.c.v();
        c[] cVarArr = null;
        if (arrayListV.isEmpty()) {
            if (F0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListW = this.c.w();
        ArrayList<a> arrayList = this.d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            cVarArr = new c[size];
            for (int i2 = 0; i2 < size; i2++) {
                cVarArr[i2] = new c(this.d.get(i2));
                if (F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                }
            }
        }
        s1 s1Var = new s1();
        s1Var.c = arrayListV;
        s1Var.d = arrayListW;
        s1Var.e = cVarArr;
        s1Var.f = this.f269i.get();
        Fragment fragment = this.u;
        if (fragment != null) {
            s1Var.g = fragment.f230h;
        }
        s1Var.f276h.addAll(this.f270j.keySet());
        s1Var.f277i.addAll(this.f270j.values());
        s1Var.f278j = new ArrayList<>(this.C);
        return s1Var;
    }

    b2 g(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        b2 b2VarV = v(fragment);
        fragment.M = this;
        this.c.p(b2VarV);
        if (!fragment.a0) {
            this.c.a(fragment);
            fragment.D = false;
            if (fragment.h0 == null) {
                fragment.m0 = false;
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
        return b2VarV;
    }

    Fragment g0(String str) {
        return this.c.f(str);
    }

    void g1() {
        synchronized (this.a) {
            ArrayList<o1> arrayList = this.L;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z2 = this.a.size() == 1;
            if (z || z2) {
                this.r.j().removeCallbacks(this.N);
                this.r.j().post(this.N);
                n1();
            }
        }
    }

    public void h(v1 v1Var) {
        this.p.add(v1Var);
    }

    public Fragment h0(int i2) {
        return this.c.g(i2);
    }

    void h1(Fragment fragment, boolean z) {
        ViewGroup viewGroupP0 = p0(fragment);
        if (viewGroupP0 == null || !(viewGroupP0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupP0).setDrawDisappearingViewsLast(!z);
    }

    int i() {
        return this.f269i.getAndIncrement();
    }

    public Fragment i0(String str) {
        return this.c.h(str);
    }

    void i1(Fragment fragment, f.b bVar) {
        if (fragment.equals(g0(fragment.f230h)) && (fragment.O == null || fragment.M == this)) {
            fragment.q0 = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    void j(s0<?> s0Var, p0 p0Var, Fragment fragment) {
        String str;
        if (this.r != null) {
            throw new IllegalStateException("Already attached");
        }
        this.r = s0Var;
        this.s = p0Var;
        this.t = fragment;
        if (fragment != null) {
            h(new f1(this, fragment));
        } else if (s0Var instanceof v1) {
            h((v1) s0Var);
        }
        if (this.t != null) {
            n1();
        }
        if (s0Var instanceof androidx.activity.k) {
            androidx.activity.k kVar = (androidx.activity.k) s0Var;
            OnBackPressedDispatcher onBackPressedDispatcherK = kVar.k();
            this.g = onBackPressedDispatcherK;
            androidx.lifecycle.i iVar = kVar;
            if (fragment != null) {
                iVar = fragment;
            }
            onBackPressedDispatcherK.a(iVar, this.f268h);
        }
        if (fragment != null) {
            this.M = fragment.M.n0(fragment);
        } else if (s0Var instanceof androidx.lifecycle.w) {
            this.M = u1.i(((androidx.lifecycle.w) s0Var).f());
        } else {
            this.M = new u1(false);
        }
        this.M.n(K0());
        this.c.x(this.M);
        Object obj = this.r;
        if (obj instanceof androidx.activity.result.h) {
            ActivityResultRegistry activityResultRegistryE = ((androidx.activity.result.h) obj).e();
            if (fragment != null) {
                str = fragment.f230h + ParameterizedMessage.ERROR_MSG_SEPARATOR;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.z = activityResultRegistryE.i(str2 + "StartActivityForResult", new androidx.activity.result.l.f(), new g1(this));
            this.A = activityResultRegistryE.i(str2 + "StartIntentSenderForResult", new h1(), new x0(this));
            this.B = activityResultRegistryE.i(str2 + "RequestPermissions", new androidx.activity.result.l.e(), new y0(this));
        }
    }

    Fragment j0(String str) {
        return this.c.i(str);
    }

    void j1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.f230h)) && (fragment.O == null || fragment.M == this))) {
            Fragment fragment2 = this.u;
            this.u = fragment;
            L(fragment2);
            L(this.u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void k(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.a0) {
            fragment.a0 = false;
            if (fragment.C) {
                return;
            }
            this.c.a(fragment);
            if (F0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (G0(fragment)) {
                this.D = true;
            }
        }
    }

    public f2 l() {
        return new a(this);
    }

    void l1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.Z) {
            fragment.Z = false;
            fragment.m0 = !fragment.m0;
        }
    }

    public int m0() {
        ArrayList<a> arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    boolean n() {
        boolean zG0 = false;
        for (Fragment fragment : this.c.l()) {
            if (fragment != null) {
                zG0 = G0(fragment);
            }
            if (zG0) {
                return true;
            }
        }
        return false;
    }

    p0 o0() {
        return this.s;
    }

    public final void q(String str) {
        this.f270j.remove(str);
    }

    public r0 q0() {
        r0 r0Var = this.v;
        if (r0Var != null) {
            return r0Var;
        }
        Fragment fragment = this.t;
        return fragment != null ? fragment.M.q0() : this.w;
    }

    c2 r0() {
        return this.c;
    }

    public List<Fragment> s0() {
        return this.c.n();
    }

    void t(a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.w(z3);
        } else {
            aVar.v();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.q >= 1) {
            o2.C(this.r.i(), this.s, arrayList, arrayList2, 0, 1, true, this.f274n);
        }
        if (z3) {
            O0(this.q, true);
        }
        for (Fragment fragment : this.c.l()) {
            if (fragment != null && fragment.h0 != null && fragment.l0 && aVar.z(fragment.V)) {
                float f = fragment.n0;
                if (f > 0.0f) {
                    fragment.h0.setAlpha(f);
                }
                if (z3) {
                    fragment.n0 = 0.0f;
                } else {
                    fragment.n0 = -1.0f;
                    fragment.l0 = false;
                }
            }
        }
    }

    s0<?> t0() {
        return this.r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.t)));
            sb.append("}");
        } else {
            s0<?> s0Var = this.r;
            if (s0Var != null) {
                sb.append(s0Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    LayoutInflater.Factory2 u0() {
        return this.f;
    }

    b2 v(Fragment fragment) {
        b2 b2VarM = this.c.m(fragment.f230h);
        if (b2VarM != null) {
            return b2VarM;
        }
        b2 b2Var = new b2(this.f275o, this.c, fragment);
        b2Var.o(this.r.i().getClassLoader());
        b2Var.t(this.q);
        return b2Var;
    }

    w0 v0() {
        return this.f275o;
    }

    Fragment w0() {
        return this.t;
    }

    void x(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.a0) {
            return;
        }
        fragment.a0 = true;
        if (fragment.C) {
            if (F0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.c.s(fragment);
            if (G0(fragment)) {
                this.D = true;
            }
            k1(fragment);
        }
    }

    public Fragment x0() {
        return this.u;
    }

    void y() {
        this.E = false;
        this.F = false;
        this.M.n(false);
        S(4);
    }

    k3 y0() {
        k3 k3Var = this.x;
        if (k3Var != null) {
            return k3Var;
        }
        Fragment fragment = this.t;
        return fragment != null ? fragment.M.y0() : this.y;
    }

    void z() {
        this.E = false;
        this.F = false;
        this.M.n(false);
        S(0);
    }
}
