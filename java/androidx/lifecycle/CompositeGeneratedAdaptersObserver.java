package androidx.lifecycle;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements g {
    private final d[] a;

    CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.a = dVarArr;
    }

    @Override // androidx.lifecycle.g
    public void a(i iVar, f.a aVar) {
        m mVar = new m();
        for (d dVar : this.a) {
            dVar.a(iVar, aVar, false, mVar);
        }
        for (d dVar2 : this.a) {
            dVar2.a(iVar, aVar, true, mVar);
        }
    }
}
