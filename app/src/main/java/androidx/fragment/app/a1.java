package androidx.fragment.app;

/* loaded from: classes.dex */
class a1 implements m2 {
    final /* synthetic */ p1 a;

    a1(p1 p1Var) {
        this.a = p1Var;
    }

    @Override // androidx.fragment.app.m2
    public void a(Fragment fragment, h.e.f.c cVar) {
        if (cVar.b()) {
            return;
        }
        this.a.Z0(fragment, cVar);
    }

    @Override // androidx.fragment.app.m2
    public void b(Fragment fragment, h.e.f.c cVar) {
        this.a.f(fragment, cVar);
    }
}
