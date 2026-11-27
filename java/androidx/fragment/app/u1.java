package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class u1 extends androidx.lifecycle.t {

    /* renamed from: i, reason: collision with root package name */
    private static final u.a f279i = new t1();
    private final boolean e;
    private final HashMap<String, Fragment> b = new HashMap<>();
    private final HashMap<String, u1> c = new HashMap<>();
    private final HashMap<String, androidx.lifecycle.v> d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f280h = false;

    u1(boolean z) {
        this.e = z;
    }

    static u1 i(androidx.lifecycle.v vVar) {
        return (u1) new androidx.lifecycle.u(vVar, f279i).a(u1.class);
    }

    @Override // androidx.lifecycle.t
    protected void d() {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    void e(Fragment fragment) {
        if (this.f280h) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.containsKey(fragment.f230h)) {
                return;
            }
            this.b.put(fragment.f230h, fragment);
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u1.class != obj.getClass()) {
            return false;
        }
        u1 u1Var = (u1) obj;
        return this.b.equals(u1Var.b) && this.c.equals(u1Var.c) && this.d.equals(u1Var.d);
    }

    void f(Fragment fragment) {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        u1 u1Var = this.c.get(fragment.f230h);
        if (u1Var != null) {
            u1Var.d();
            this.c.remove(fragment.f230h);
        }
        androidx.lifecycle.v vVar = this.d.get(fragment.f230h);
        if (vVar != null) {
            vVar.a();
            this.d.remove(fragment.f230h);
        }
    }

    Fragment g(String str) {
        return this.b.get(str);
    }

    u1 h(Fragment fragment) {
        u1 u1Var = this.c.get(fragment.f230h);
        if (u1Var != null) {
            return u1Var;
        }
        u1 u1Var2 = new u1(this.e);
        this.c.put(fragment.f230h, u1Var2);
        return u1Var2;
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    Collection<Fragment> j() {
        return new ArrayList(this.b.values());
    }

    androidx.lifecycle.v k(Fragment fragment) {
        androidx.lifecycle.v vVar = this.d.get(fragment.f230h);
        if (vVar != null) {
            return vVar;
        }
        androidx.lifecycle.v vVar2 = new androidx.lifecycle.v();
        this.d.put(fragment.f230h, vVar2);
        return vVar2;
    }

    boolean l() {
        return this.f;
    }

    void m(Fragment fragment) {
        if (this.f280h) {
            if (p1.F0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.b.remove(fragment.f230h) != null) && p1.F0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void n(boolean z) {
        this.f280h = z;
    }

    boolean o(Fragment fragment) {
        if (this.b.containsKey(fragment.f230h)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
