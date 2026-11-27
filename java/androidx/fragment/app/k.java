package androidx.fragment.app;

/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ i3 c;
    final /* synthetic */ i3 d;
    final /* synthetic */ boolean e;
    final /* synthetic */ h.d.b f;

    k(r rVar, i3 i3Var, i3 i3Var2, boolean z, h.d.b bVar) {
        this.c = i3Var;
        this.d = i3Var2;
        this.e = z;
        this.f = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        o2.f(this.c.f(), this.d.f(), this.e, this.f, false);
    }
}
