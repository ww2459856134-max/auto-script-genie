package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Add missing generic type declarations: [I] */
/* loaded from: classes.dex */
class z<I> extends androidx.activity.result.d<I> {
    final /* synthetic */ AtomicReference a;

    z(Fragment fragment, AtomicReference atomicReference, androidx.activity.result.l.b bVar) {
        this.a = atomicReference;
    }

    @Override // androidx.activity.result.d
    public void b(I i2, androidx.core.app.g gVar) {
        androidx.activity.result.d dVar = (androidx.activity.result.d) this.a.get();
        if (dVar == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        dVar.b(i2, gVar);
    }

    @Override // androidx.activity.result.d
    public void c() {
        androidx.activity.result.d dVar = (androidx.activity.result.d) this.a.getAndSet(null);
        if (dVar != null) {
            dVar.c();
        }
    }
}
