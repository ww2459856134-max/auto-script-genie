package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.f;

/* loaded from: classes.dex */
class b2 {
    private final w0 a;
    private final c2 b;
    private final Fragment c;
    private boolean d = false;
    private int e = -1;

    b2(w0 w0Var, c2 c2Var, Fragment fragment) {
        this.a = w0Var;
        this.b = c2Var;
        this.c = fragment;
    }

    private boolean l(View view) {
        if (view == this.c.h0) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.h0) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.c.q1(bundle);
        this.a.j(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.c.h0 != null) {
            s();
        }
        if (this.c.e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.c.e);
        }
        if (this.c.f != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.c.f);
        }
        if (!this.c.j0) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.c.j0);
        }
        return bundle;
    }

    void a() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        fragment.W0(fragment.d);
        w0 w0Var = this.a;
        Fragment fragment2 = this.c;
        w0Var.a(fragment2, fragment2.d, false);
    }

    void b() {
        int iJ = this.b.j(this.c);
        Fragment fragment = this.c;
        fragment.g0.addView(fragment.h0, iJ);
    }

    void c() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.f232j;
        b2 b2VarM = null;
        if (fragment2 != null) {
            b2 b2VarM2 = this.b.m(fragment2.f230h);
            if (b2VarM2 == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.f232j + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.c;
            fragment3.f233k = fragment3.f232j.f230h;
            fragment3.f232j = null;
            b2VarM = b2VarM2;
        } else {
            String str = fragment.f233k;
            if (str != null && (b2VarM = this.b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.f233k + " that does not belong to this FragmentManager!");
            }
        }
        if (b2VarM != null && (p1.P || b2VarM.k().c < 1)) {
            b2VarM.m();
        }
        Fragment fragment4 = this.c;
        fragment4.O = fragment4.M.t0();
        Fragment fragment5 = this.c;
        fragment5.Q = fragment5.M.w0();
        this.a.g(this.c, false);
        this.c.X0();
        this.a.b(this.c, false);
    }

    int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.c;
        if (fragment2.M == null) {
            return fragment2.c;
        }
        int iMin = this.e;
        int i2 = a2.a[fragment2.q0.ordinal()];
        if (i2 != 1) {
            iMin = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment3 = this.c;
        if (fragment3.G) {
            if (fragment3.H) {
                iMin = Math.max(this.e, 2);
                View view = this.c.h0;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, fragment3.c) : Math.min(iMin, 1);
            }
        }
        if (!this.c.C) {
            iMin = Math.min(iMin, 1);
        }
        g3 g3VarL = null;
        if (p1.P && (viewGroup = (fragment = this.c).g0) != null) {
            g3VarL = j3.n(viewGroup, fragment.L()).l(this);
        }
        if (g3VarL == g3.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (g3VarL == g3.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.c;
            if (fragment4.D) {
                iMin = fragment4.h0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.c;
        if (fragment5.i0 && fragment5.c < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.c);
        }
        return iMin;
    }

    void e() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        if (fragment.p0) {
            fragment.A1(fragment.d);
            this.c.c = 1;
            return;
        }
        this.a.h(fragment, fragment.d, false);
        Fragment fragment2 = this.c;
        fragment2.a1(fragment2.d);
        w0 w0Var = this.a;
        Fragment fragment3 = this.c;
        w0Var.c(fragment3, fragment3.d, false);
    }

    void f() {
        String resourceName;
        if (this.c.G) {
            return;
        }
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        LayoutInflater layoutInflaterG1 = fragment.g1(fragment.d);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.c;
        ViewGroup viewGroup2 = fragment2.g0;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i2 = fragment2.V;
            if (i2 != 0) {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.M.o0().d(this.c.V);
                if (viewGroup == null) {
                    Fragment fragment3 = this.c;
                    if (!fragment3.I) {
                        try {
                            resourceName = fragment3.R().getResourceName(this.c.V);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.V) + " (" + resourceName + ") for fragment " + this.c);
                    }
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.g0 = viewGroup;
        fragment4.c1(layoutInflaterG1, viewGroup, fragment4.d);
        View view = this.c.h0;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.c;
            fragment5.h0.setTag(h.j.b.a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.c;
            if (fragment6.Z) {
                fragment6.h0.setVisibility(8);
            }
            if (h.e.j.s0.J(this.c.h0)) {
                h.e.j.s0.W(this.c.h0);
            } else {
                View view2 = this.c.h0;
                view2.addOnAttachStateChangeListener(new z1(this, view2));
            }
            this.c.t1();
            w0 w0Var = this.a;
            Fragment fragment7 = this.c;
            w0Var.m(fragment7, fragment7.h0, fragment7.d, false);
            int visibility = this.c.h0.getVisibility();
            float alpha = this.c.h0.getAlpha();
            if (p1.P) {
                this.c.M1(alpha);
                Fragment fragment8 = this.c;
                if (fragment8.g0 != null && visibility == 0) {
                    View viewFindFocus = fragment8.h0.findFocus();
                    if (viewFindFocus != null) {
                        this.c.H1(viewFindFocus);
                        if (p1.F0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.c);
                        }
                    }
                    this.c.h0.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.c;
                if (visibility == 0 && fragment9.g0 != null) {
                    z = true;
                }
                fragment9.l0 = z;
            }
        }
        this.c.c = 2;
    }

    void g() {
        Fragment fragmentF;
        if (p1.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.D && !fragment.h0();
        if (!(z || this.b.o().o(this.c))) {
            String str = this.c.f233k;
            if (str != null && (fragmentF = this.b.f(str)) != null && fragmentF.b0) {
                this.c.f232j = fragmentF;
            }
            this.c.c = 0;
            return;
        }
        s0<?> s0Var = this.c.O;
        if (s0Var instanceof androidx.lifecycle.w) {
            zIsChangingConfigurations = this.b.o().l();
        } else if (s0Var.i() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) s0Var.i()).isChangingConfigurations();
        }
        if (z || zIsChangingConfigurations) {
            this.b.o().f(this.c);
        }
        this.c.d1();
        this.a.d(this.c, false);
        for (b2 b2Var : this.b.k()) {
            if (b2Var != null) {
                Fragment fragmentK = b2Var.k();
                if (this.c.f230h.equals(fragmentK.f233k)) {
                    fragmentK.f232j = this.c;
                    fragmentK.f233k = null;
                }
            }
        }
        Fragment fragment2 = this.c;
        String str2 = fragment2.f233k;
        if (str2 != null) {
            fragment2.f232j = this.b.f(str2);
        }
        this.b.q(this);
    }

    void h() {
        View view;
        if (p1.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.g0;
        if (viewGroup != null && (view = fragment.h0) != null) {
            viewGroup.removeView(view);
        }
        this.c.e1();
        this.a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.g0 = null;
        fragment2.h0 = null;
        fragment2.s0 = null;
        fragment2.t0.i(null);
        this.c.H = false;
    }

    void i() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.f1();
        boolean z = false;
        this.a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.c = -1;
        fragment.O = null;
        fragment.Q = null;
        fragment.M = null;
        if (fragment.D && !fragment.h0()) {
            z = true;
        }
        if (z || this.b.o().o(this.c)) {
            if (p1.F0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.b0();
        }
    }

    void j() {
        Fragment fragment = this.c;
        if (fragment.G && fragment.H && !fragment.J) {
            if (p1.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Fragment fragment2 = this.c;
            fragment2.c1(fragment2.g1(fragment2.d), null, this.c.d);
            View view = this.c.h0;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.h0.setTag(h.j.b.a, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.Z) {
                    fragment4.h0.setVisibility(8);
                }
                this.c.t1();
                w0 w0Var = this.a;
                Fragment fragment5 = this.c;
                w0Var.m(fragment5, fragment5.h0, fragment5.d, false);
                this.c.c = 2;
            }
        }
    }

    Fragment k() {
        return this.c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int iD = d();
                Fragment fragment = this.c;
                int i2 = fragment.c;
                if (iD == i2) {
                    if (p1.P && fragment.m0) {
                        if (fragment.h0 != null && (viewGroup = fragment.g0) != null) {
                            j3 j3VarN = j3.n(viewGroup, fragment.L());
                            if (this.c.Z) {
                                j3VarN.c(this);
                            } else {
                                j3VarN.e(this);
                            }
                        }
                        Fragment fragment2 = this.c;
                        p1 p1Var = fragment2.M;
                        if (p1Var != null) {
                            p1Var.D0(fragment2);
                        }
                        Fragment fragment3 = this.c;
                        fragment3.m0 = false;
                        fragment3.F0(fragment3.Z);
                    }
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.c.c = 1;
                            break;
                        case 2:
                            fragment.H = false;
                            fragment.c = 2;
                            break;
                        case 3:
                            if (p1.F0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                            }
                            Fragment fragment4 = this.c;
                            if (fragment4.h0 != null && fragment4.e == null) {
                                s();
                            }
                            Fragment fragment5 = this.c;
                            if (fragment5.h0 != null && (viewGroup3 = fragment5.g0) != null) {
                                j3.n(viewGroup3, fragment5.L()).d(this);
                            }
                            this.c.c = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.c = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.h0 != null && (viewGroup2 = fragment.g0) != null) {
                                j3.n(viewGroup2, fragment.L()).b(h3.b(this.c.h0.getVisibility()), this);
                            }
                            this.c.c = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.c = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.d = false;
        }
    }

    void n() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.l1();
        this.a.f(this.c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.c.d;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.e = fragment.d.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.f = fragment2.d.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.f233k = fragment3.d.getString("android:target_state");
        Fragment fragment4 = this.c;
        if (fragment4.f233k != null) {
            fragment4.t = fragment4.d.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.c;
        Boolean bool = fragment5.g;
        if (bool != null) {
            fragment5.j0 = bool.booleanValue();
            this.c.g = null;
        } else {
            fragment5.j0 = fragment5.d.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.c;
        if (fragment6.j0) {
            return;
        }
        fragment6.i0 = true;
    }

    void p() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View viewE = this.c.E();
        if (viewE != null && l(viewE)) {
            boolean zRequestFocus = viewE.requestFocus();
            if (p1.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(viewE);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.h0.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.H1(null);
        this.c.p1();
        this.a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.d = null;
        fragment.e = null;
        fragment.f = null;
    }

    y1 r() {
        y1 y1Var = new y1(this.c);
        Fragment fragment = this.c;
        if (fragment.c <= -1 || y1Var.D != null) {
            y1Var.D = fragment.d;
        } else {
            Bundle bundleQ = q();
            y1Var.D = bundleQ;
            if (this.c.f233k != null) {
                if (bundleQ == null) {
                    y1Var.D = new Bundle();
                }
                y1Var.D.putString("android:target_state", this.c.f233k);
                int i2 = this.c.t;
                if (i2 != 0) {
                    y1Var.D.putInt("android:target_req_state", i2);
                }
            }
        }
        return y1Var;
    }

    void s() {
        if (this.c.h0 == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.c.h0.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.e = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.s0.g(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.f = bundle;
    }

    void t(int i2) {
        this.e = i2;
    }

    void u() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.r1();
        this.a.k(this.c, false);
    }

    void v() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.s1();
        this.a.l(this.c, false);
    }

    b2(w0 w0Var, c2 c2Var, ClassLoader classLoader, r0 r0Var, y1 y1Var) {
        this.a = w0Var;
        this.b = c2Var;
        Fragment fragmentA = r0Var.a(classLoader, y1Var.c);
        this.c = fragmentA;
        Bundle bundle = y1Var.t;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.G1(y1Var.t);
        fragmentA.f230h = y1Var.d;
        fragmentA.G = y1Var.e;
        fragmentA.I = true;
        fragmentA.U = y1Var.f;
        fragmentA.V = y1Var.g;
        fragmentA.W = y1Var.f281h;
        fragmentA.b0 = y1Var.f282i;
        fragmentA.D = y1Var.f283j;
        fragmentA.a0 = y1Var.f284k;
        fragmentA.Z = y1Var.A;
        fragmentA.q0 = f.b.values()[y1Var.C];
        Bundle bundle2 = y1Var.D;
        if (bundle2 != null) {
            fragmentA.d = bundle2;
        } else {
            fragmentA.d = new Bundle();
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    b2(w0 w0Var, c2 c2Var, Fragment fragment, y1 y1Var) {
        this.a = w0Var;
        this.b = c2Var;
        this.c = fragment;
        fragment.e = null;
        fragment.f = null;
        fragment.K = 0;
        fragment.H = false;
        fragment.C = false;
        Fragment fragment2 = fragment.f232j;
        fragment.f233k = fragment2 != null ? fragment2.f230h : null;
        fragment.f232j = null;
        Bundle bundle = y1Var.D;
        if (bundle != null) {
            fragment.d = bundle;
        } else {
            fragment.d = new Bundle();
        }
    }
}
