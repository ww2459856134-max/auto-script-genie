package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class c2 {
    private final ArrayList<Fragment> a = new ArrayList<>();
    private final HashMap<String, b2> b = new HashMap<>();
    private u1 c;

    c2() {
    }

    void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.C = true;
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.b.get(str) != null;
    }

    void d(int i2) {
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                b2Var.t(i2);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (b2 b2Var : this.b.values()) {
                printWriter.print(str);
                if (b2Var != null) {
                    Fragment fragmentK = b2Var.k();
                    printWriter.println(fragmentK);
                    fragmentK.l(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        b2 b2Var = this.b.get(str);
        if (b2Var != null) {
            return b2Var.k();
        }
        return null;
    }

    Fragment g(int i2) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.a.get(size);
            if (fragment != null && fragment.U == i2) {
                return fragment;
            }
        }
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                Fragment fragmentK = b2Var.k();
                if (fragmentK.U == i2) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.a.get(size);
                if (fragment != null && str.equals(fragment.W)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                Fragment fragmentK = b2Var.k();
                if (str.equals(fragmentK.W)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentN;
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null && (fragmentN = b2Var.k().n(str)) != null) {
                return fragmentN;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.g0;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.a.indexOf(fragment);
        for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.a.get(i2);
            if (fragment2.g0 == viewGroup && (view2 = fragment2.h0) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.a.size()) {
                return -1;
            }
            Fragment fragment3 = this.a.get(iIndexOf);
            if (fragment3.g0 == viewGroup && (view = fragment3.h0) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List<b2> k() {
        ArrayList arrayList = new ArrayList();
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                arrayList.add(b2Var);
            }
        }
        return arrayList;
    }

    List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                arrayList.add(b2Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    b2 m(String str) {
        return this.b.get(str);
    }

    List<Fragment> n() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    u1 o() {
        return this.c;
    }

    void p(b2 b2Var) {
        Fragment fragmentK = b2Var.k();
        if (c(fragmentK.f230h)) {
            return;
        }
        this.b.put(fragmentK.f230h, b2Var);
        if (fragmentK.c0) {
            if (fragmentK.b0) {
                this.c.e(fragmentK);
            } else {
                this.c.m(fragmentK);
            }
            fragmentK.c0 = false;
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void q(b2 b2Var) {
        Fragment fragmentK = b2Var.k();
        if (fragmentK.b0) {
            this.c.m(fragmentK);
        }
        if (this.b.put(fragmentK.f230h, null) != null && p1.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void r() {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            b2 b2Var = this.b.get(it.next().f230h);
            if (b2Var != null) {
                b2Var.m();
            }
        }
        for (b2 b2Var2 : this.b.values()) {
            if (b2Var2 != null) {
                b2Var2.m();
                Fragment fragmentK = b2Var2.k();
                if (fragmentK.D && !fragmentK.h0()) {
                    q(b2Var2);
                }
            }
        }
    }

    void s(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.C = false;
    }

    void t() {
        this.b.clear();
    }

    void u(List<String> list) {
        this.a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    ArrayList<y1> v() {
        ArrayList<y1> arrayList = new ArrayList<>(this.b.size());
        for (b2 b2Var : this.b.values()) {
            if (b2Var != null) {
                Fragment fragmentK = b2Var.k();
                y1 y1VarR = b2Var.r();
                arrayList.add(y1VarR);
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + y1VarR.D);
                }
            }
        }
        return arrayList;
    }

    ArrayList<String> w() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.a.size());
            Iterator<Fragment> it = this.a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f230h);
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f230h + "): " + next);
                }
            }
            return arrayList;
        }
    }

    void x(u1 u1Var) {
        this.c = u1Var;
    }
}
