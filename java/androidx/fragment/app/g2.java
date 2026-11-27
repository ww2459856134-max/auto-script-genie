package androidx.fragment.app;

/* loaded from: classes.dex */
class g2 implements Runnable {
    final /* synthetic */ m2 c;
    final /* synthetic */ Fragment d;
    final /* synthetic */ h.e.f.c e;

    g2(m2 m2Var, Fragment fragment, h.e.f.c cVar) {
        this.c = m2Var;
        this.d = fragment;
        this.e = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.d, this.e);
    }
}
