package com.airbnb.lottie;

/* loaded from: classes.dex */
class l0 implements Runnable {
    final /* synthetic */ m0 c;

    l0(m0 m0Var) {
        this.c = m0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.d == null) {
            return;
        }
        k0 k0Var = this.c.d;
        if (k0Var.b() != null) {
            this.c.i(k0Var.b());
        } else {
            this.c.g(k0Var.a());
        }
    }
}
