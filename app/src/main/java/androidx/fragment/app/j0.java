package androidx.fragment.app;

/* loaded from: classes.dex */
class j0 implements Runnable {
    final /* synthetic */ k0 c;

    j0(k0 k0Var) {
        this.c = k0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.d.t() != null) {
            this.c.d.D1(null);
            k0 k0Var = this.c;
            k0Var.e.a(k0Var.d, k0Var.f);
        }
    }
}
