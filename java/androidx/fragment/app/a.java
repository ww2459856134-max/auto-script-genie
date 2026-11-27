package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class a extends f2 implements m1 {
    final p1 q;
    boolean r;
    int s;

    a(p1 p1Var) {
        super(p1Var.q0(), p1Var.t0() != null ? p1Var.t0().i().getClassLoader() : null);
        this.s = -1;
        this.q = p1Var;
    }

    private static boolean B(e2 e2Var) {
        Fragment fragment = e2Var.b;
        return (fragment == null || !fragment.C || fragment.h0 == null || fragment.a0 || fragment.Z || !fragment.j0()) ? false : true;
    }

    boolean A(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.a.get(i5).b;
            int i6 = fragment != null ? fragment.V : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.a.get(i8).b;
                        if ((fragment2 != null ? fragment2.V : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    boolean C() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            if (B(this.a.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void D() {
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                this.p.get(i2).run();
            }
            this.p = null;
        }
    }

    void E(d0 d0Var) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            e2 e2Var = this.a.get(i2);
            if (B(e2Var)) {
                e2Var.b.K1(d0Var);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Fragment F(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            e2 e2Var = this.a.get(size);
            int i2 = e2Var.a;
            if (i2 == 1) {
                arrayList.remove(e2Var.b);
            } else if (i2 != 3) {
                switch (i2) {
                    case 6:
                        arrayList.add(e2Var.b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = e2Var.b;
                        break;
                    case 10:
                        e2Var.f249h = e2Var.g;
                        break;
                }
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.m1
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        this.q.e(this);
        return true;
    }

    @Override // androidx.fragment.app.f2
    public int g() {
        return s(false);
    }

    @Override // androidx.fragment.app.f2
    public int h() {
        return s(true);
    }

    @Override // androidx.fragment.app.f2
    public void i() {
        l();
        this.q.b0(this, false);
    }

    @Override // androidx.fragment.app.f2
    public void j() {
        l();
        this.q.b0(this, true);
    }

    @Override // androidx.fragment.app.f2
    public f2 k(Fragment fragment) {
        p1 p1Var = fragment.M;
        if (p1Var == null || p1Var == this.q) {
            super.k(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.f2
    void m(int i2, Fragment fragment, String str, int i3) {
        super.m(i2, fragment, str, i3);
        fragment.M = this.q;
    }

    @Override // androidx.fragment.app.f2
    public f2 n(Fragment fragment) {
        p1 p1Var = fragment.M;
        if (p1Var == null || p1Var == this.q) {
            super.n(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void r(int i2) {
        if (this.g) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.a.size();
            for (int i3 = 0; i3 < size; i3++) {
                e2 e2Var = this.a.get(i3);
                Fragment fragment = e2Var.b;
                if (fragment != null) {
                    fragment.K += i2;
                    if (p1.F0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + e2Var.b + " to " + e2Var.b.K);
                    }
                }
            }
        }
    }

    int s(boolean z) {
        if (this.r) {
            throw new IllegalStateException("commit already called");
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new a3("FragmentManager"));
            t("  ", printWriter);
            printWriter.close();
        }
        this.r = true;
        if (this.g) {
            this.s = this.q.i();
        } else {
            this.s = -1;
        }
        this.q.Y(this, z);
        return this.s;
    }

    public void t(String str, PrintWriter printWriter) {
        u(str, printWriter, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.s >= 0) {
            sb.append(" #");
            sb.append(this.s);
        }
        if (this.f251h != null) {
            sb.append(" ");
            sb.append(this.f251h);
        }
        sb.append("}");
        return sb.toString();
    }

    public void u(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f251h);
            printWriter.print(" mIndex=");
            printWriter.print(this.s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.r);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f252i != 0 || this.f253j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f252i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f253j);
            }
            if (this.f254k != 0 || this.f255l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f254k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f255l);
            }
        }
        if (this.a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            e2 e2Var = this.a.get(i2);
            switch (e2Var.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + e2Var.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(e2Var.b);
            if (z) {
                if (e2Var.c != 0 || e2Var.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(e2Var.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(e2Var.d));
                }
                if (e2Var.e != 0 || e2Var.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(e2Var.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(e2Var.f));
                }
            }
        }
    }

    void v() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            e2 e2Var = this.a.get(i2);
            Fragment fragment = e2Var.b;
            if (fragment != null) {
                fragment.L1(false);
                fragment.J1(this.f);
                fragment.N1(this.f256m, this.f257n);
            }
            switch (e2Var.a) {
                case 1:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, false);
                    this.q.g(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + e2Var.a);
                case 3:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.a1(fragment);
                    break;
                case 4:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.C0(fragment);
                    break;
                case 5:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, false);
                    this.q.l1(fragment);
                    break;
                case 6:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.x(fragment);
                    break;
                case 7:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, false);
                    this.q.k(fragment);
                    break;
                case 8:
                    this.q.j1(fragment);
                    break;
                case 9:
                    this.q.j1(null);
                    break;
                case 10:
                    this.q.i1(fragment, e2Var.f249h);
                    break;
            }
            if (!this.f258o && e2Var.a != 1 && fragment != null && !p1.P) {
                this.q.N0(fragment);
            }
        }
        if (this.f258o || p1.P) {
            return;
        }
        p1 p1Var = this.q;
        p1Var.O0(p1Var.q, true);
    }

    void w(boolean z) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            e2 e2Var = this.a.get(size);
            Fragment fragment = e2Var.b;
            if (fragment != null) {
                fragment.L1(true);
                fragment.J1(p1.e1(this.f));
                fragment.N1(this.f257n, this.f256m);
            }
            switch (e2Var.a) {
                case 1:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, true);
                    this.q.a1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + e2Var.a);
                case 3:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.g(fragment);
                    break;
                case 4:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.l1(fragment);
                    break;
                case 5:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, true);
                    this.q.C0(fragment);
                    break;
                case 6:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.k(fragment);
                    break;
                case 7:
                    fragment.E1(e2Var.c, e2Var.d, e2Var.e, e2Var.f);
                    this.q.h1(fragment, true);
                    this.q.x(fragment);
                    break;
                case 8:
                    this.q.j1(null);
                    break;
                case 9:
                    this.q.j1(fragment);
                    break;
                case 10:
                    this.q.i1(fragment, e2Var.g);
                    break;
            }
            if (!this.f258o && e2Var.a != 3 && fragment != null && !p1.P) {
                this.q.N0(fragment);
            }
        }
        if (this.f258o || !z || p1.P) {
            return;
        }
        p1 p1Var = this.q;
        p1Var.O0(p1Var.q, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Fragment x(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.a.size()) {
            e2 e2Var = this.a.get(i2);
            int i3 = e2Var.a;
            if (i3 == 1) {
                arrayList.add(e2Var.b);
            } else if (i3 == 2) {
                Fragment fragment3 = e2Var.b;
                int i4 = fragment3.V;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = arrayList.get(size);
                    if (fragment4.V == i4) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.a.add(i2, new e2(9, fragment4));
                                i2++;
                                fragment2 = null;
                            }
                            e2 e2Var2 = new e2(3, fragment4);
                            e2Var2.c = e2Var.c;
                            e2Var2.e = e2Var.e;
                            e2Var2.d = e2Var.d;
                            e2Var2.f = e2Var.f;
                            this.a.add(i2, e2Var2);
                            arrayList.remove(fragment4);
                            i2++;
                        }
                    }
                }
                if (z) {
                    this.a.remove(i2);
                    i2--;
                } else {
                    e2Var.a = 1;
                    arrayList.add(fragment3);
                }
            } else if (i3 == 3 || i3 == 6) {
                arrayList.remove(e2Var.b);
                Fragment fragment5 = e2Var.b;
                if (fragment5 == fragment2) {
                    this.a.add(i2, new e2(9, fragment5));
                    i2++;
                    fragment2 = null;
                }
            } else if (i3 != 7) {
                if (i3 == 8) {
                    this.a.add(i2, new e2(9, fragment2));
                    i2++;
                    fragment2 = e2Var.b;
                }
            }
            i2++;
        }
        return fragment2;
    }

    public String y() {
        return this.f251h;
    }

    boolean z(int i2) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.a.get(i3).b;
            int i4 = fragment != null ? fragment.V : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }
}
