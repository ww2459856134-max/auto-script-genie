package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class i3 {
    private h3 a;
    private g3 b;
    private final Fragment c;
    private final List<Runnable> d = new ArrayList();
    private final HashSet<h.e.f.c> e = new HashSet<>();
    private boolean f = false;
    private boolean g = false;

    i3(h3 h3Var, g3 g3Var, Fragment fragment, h.e.f.c cVar) {
        this.a = h3Var;
        this.b = g3Var;
        this.c = fragment;
        cVar.c(new f3(this));
    }

    final void a(Runnable runnable) {
        this.d.add(runnable);
    }

    final void b() {
        if (h()) {
            return;
        }
        this.f = true;
        if (this.e.isEmpty()) {
            c();
            return;
        }
        Iterator it = new ArrayList(this.e).iterator();
        while (it.hasNext()) {
            ((h.e.f.c) it.next()).a();
        }
    }

    public void c() {
        if (this.g) {
            return;
        }
        if (p1.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        }
        this.g = true;
        Iterator<Runnable> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public final void d(h.e.f.c cVar) {
        if (this.e.remove(cVar) && this.e.isEmpty()) {
            c();
        }
    }

    public h3 e() {
        return this.a;
    }

    public final Fragment f() {
        return this.c;
    }

    g3 g() {
        return this.b;
    }

    final boolean h() {
        return this.f;
    }

    final boolean i() {
        return this.g;
    }

    public final void j(h.e.f.c cVar) {
        l();
        this.e.add(cVar);
    }

    final void k(h3 h3Var, g3 g3Var) {
        int i2 = d3.b[g3Var.ordinal()];
        if (i2 == 1) {
            if (this.a == h3.REMOVED) {
                if (p1.F0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                }
                this.a = h3.VISIBLE;
                this.b = g3.ADDING;
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
            }
            this.a = h3.REMOVED;
            this.b = g3.REMOVING;
            return;
        }
        if (i2 == 3 && this.a != h3.REMOVED) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + h3Var + ". ");
            }
            this.a = h3Var;
        }
    }

    abstract void l();

    public String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
    }
}
