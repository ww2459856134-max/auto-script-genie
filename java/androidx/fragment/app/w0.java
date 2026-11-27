package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
class w0 {
    private final CopyOnWriteArrayList<v0> a = new CopyOnWriteArrayList<>();
    private final p1 b;

    w0(p1 p1Var) {
        this.b = p1Var;
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().a(fragment, bundle, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.a(this.b, fragment, bundle);
            }
        }
    }

    void b(Fragment fragment, boolean z) {
        Context contextI = this.b.t0().i();
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().b(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.b(this.b, fragment, contextI);
            }
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().c(fragment, bundle, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.c(this.b, fragment, bundle);
            }
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().d(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.d(this.b, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().e(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.e(this.b, fragment);
            }
        }
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().f(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.f(this.b, fragment);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        Context contextI = this.b.t0().i();
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().g(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.g(this.b, fragment, contextI);
            }
        }
    }

    void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().h(fragment, bundle, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.h(this.b, fragment, bundle);
            }
        }
    }

    void i(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().i(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.i(this.b, fragment);
            }
        }
    }

    void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().j(fragment, bundle, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.j(this.b, fragment, bundle);
            }
        }
    }

    void k(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().k(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.k(this.b, fragment);
            }
        }
    }

    void l(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().l(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.l(this.b, fragment);
            }
        }
    }

    void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().m(fragment, view, bundle, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.m(this.b, fragment, view, bundle);
            }
        }
    }

    void n(Fragment fragment, boolean z) {
        Fragment fragmentW0 = this.b.w0();
        if (fragmentW0 != null) {
            fragmentW0.L().v0().n(fragment, true);
        }
        Iterator<v0> it = this.a.iterator();
        while (it.hasNext()) {
            v0 next = it.next();
            if (!z || next.b) {
                next.a.n(this.b, fragment);
            }
        }
    }
}
