package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class j3 {
    private final ViewGroup a;
    final ArrayList<i3> b = new ArrayList<>();
    final ArrayList<i3> c = new ArrayList<>();
    boolean d = false;
    boolean e = false;

    j3(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private void a(h3 h3Var, g3 g3Var, b2 b2Var) {
        synchronized (this.b) {
            h.e.f.c cVar = new h.e.f.c();
            i3 i3VarH = h(b2Var.k());
            if (i3VarH != null) {
                i3VarH.k(h3Var, g3Var);
                return;
            }
            e3 e3Var = new e3(h3Var, g3Var, b2Var, cVar);
            this.b.add(e3Var);
            e3Var.a(new b3(this, e3Var));
            e3Var.a(new c3(this, e3Var));
        }
    }

    private i3 h(Fragment fragment) {
        Iterator<i3> it = this.b.iterator();
        while (it.hasNext()) {
            i3 next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private i3 i(Fragment fragment) {
        Iterator<i3> it = this.c.iterator();
        while (it.hasNext()) {
            i3 next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    static j3 n(ViewGroup viewGroup, p1 p1Var) {
        return o(viewGroup, p1Var.y0());
    }

    static j3 o(ViewGroup viewGroup, k3 k3Var) {
        int i2 = h.j.b.b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof j3) {
            return (j3) tag;
        }
        j3 j3VarA = k3Var.a(viewGroup);
        viewGroup.setTag(i2, j3VarA);
        return j3VarA;
    }

    private void q() {
        Iterator<i3> it = this.b.iterator();
        while (it.hasNext()) {
            i3 next = it.next();
            if (next.g() == g3.ADDING) {
                next.k(h3.b(next.f().z1().getVisibility()), g3.NONE);
            }
        }
    }

    void b(h3 h3Var, b2 b2Var) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + b2Var.k());
        }
        a(h3Var, g3.ADDING, b2Var);
    }

    void c(b2 b2Var) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + b2Var.k());
        }
        a(h3.GONE, g3.NONE, b2Var);
    }

    void d(b2 b2Var) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + b2Var.k());
        }
        a(h3.REMOVED, g3.REMOVING, b2Var);
    }

    void e(b2 b2Var) {
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + b2Var.k());
        }
        a(h3.VISIBLE, g3.NONE, b2Var);
    }

    abstract void f(List<i3> list, boolean z);

    void g() {
        if (this.e) {
            return;
        }
        if (!h.e.j.s0.J(this.a)) {
            j();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.c);
                this.c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i3 i3Var = (i3) it.next();
                    if (p1.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + i3Var);
                    }
                    i3Var.b();
                    if (!i3Var.i()) {
                        this.c.add(i3Var);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.b);
                this.b.clear();
                this.c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((i3) it2.next()).l();
                }
                f(arrayList2, this.d);
                this.d = false;
            }
        }
    }

    void j() {
        String str;
        String str2;
        boolean zJ = h.e.j.s0.J(this.a);
        synchronized (this.b) {
            q();
            Iterator<i3> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.c).iterator();
            while (it2.hasNext()) {
                i3 i3Var = (i3) it2.next();
                if (p1.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (zJ) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(i3Var);
                    Log.v("FragmentManager", sb.toString());
                }
                i3Var.b();
            }
            Iterator it3 = new ArrayList(this.b).iterator();
            while (it3.hasNext()) {
                i3 i3Var2 = (i3) it3.next();
                if (p1.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (zJ) {
                        str = "";
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(i3Var2);
                    Log.v("FragmentManager", sb2.toString());
                }
                i3Var2.b();
            }
        }
    }

    void k() {
        if (this.e) {
            this.e = false;
            g();
        }
    }

    g3 l(b2 b2Var) {
        i3 i3VarH = h(b2Var.k());
        g3 g3VarG = i3VarH != null ? i3VarH.g() : null;
        i3 i3VarI = i(b2Var.k());
        return (i3VarI == null || !(g3VarG == null || g3VarG == g3.NONE)) ? g3VarG : i3VarI.g();
    }

    public ViewGroup m() {
        return this.a;
    }

    void p() {
        synchronized (this.b) {
            q();
            this.e = false;
            int size = this.b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                i3 i3Var = this.b.get(size);
                h3 h3VarC = h3.c(i3Var.f().h0);
                h3 h3VarE = i3Var.e();
                h3 h3Var = h3.VISIBLE;
                if (h3VarE == h3Var && h3VarC != h3Var) {
                    this.e = i3Var.f().j0();
                    break;
                }
                size--;
            }
        }
    }

    void r(boolean z) {
        this.d = z;
    }
}
