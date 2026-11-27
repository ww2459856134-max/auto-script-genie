package androidx.appcompat.app;

/* loaded from: classes.dex */
class b0 implements Runnable {
    final /* synthetic */ t0 c;

    b0(t0 t0Var) {
        this.c = t0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0 t0Var = this.c;
        t0Var.J.showAtLocation(t0Var.I, 55, 0, 0);
        this.c.V();
        if (!this.c.D0()) {
            this.c.I.setAlpha(1.0f);
            this.c.I.setVisibility(0);
            return;
        }
        this.c.I.setAlpha(0.0f);
        t0 t0Var2 = this.c;
        h.e.j.z0 z0VarB = h.e.j.s0.b(t0Var2.I);
        z0VarB.a(1.0f);
        t0Var2.M = z0VarB;
        this.c.M.f(new a0(this));
    }
}
