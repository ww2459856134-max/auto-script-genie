package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.f;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
class z2 implements androidx.savedstate.c, androidx.lifecycle.w {
    private final androidx.lifecycle.v c;
    private androidx.lifecycle.k d = null;
    private androidx.savedstate.b e = null;

    z2(Fragment fragment, androidx.lifecycle.v vVar) {
        this.c = vVar;
    }

    void a(f.a aVar) {
        this.d.h(aVar);
    }

    @Override // androidx.savedstate.c
    public SavedStateRegistry b() {
        c();
        return this.e.b();
    }

    void c() {
        if (this.d == null) {
            this.d = new androidx.lifecycle.k(this);
            this.e = androidx.savedstate.b.a(this);
        }
    }

    boolean d() {
        return this.d != null;
    }

    void e(Bundle bundle) {
        this.e.c(bundle);
    }

    @Override // androidx.lifecycle.w
    public androidx.lifecycle.v f() {
        c();
        return this.c;
    }

    void g(Bundle bundle) {
        this.e.d(bundle);
    }

    void h(f.b bVar) {
        this.d.o(bVar);
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.f o() {
        c();
        return this.d;
    }
}
