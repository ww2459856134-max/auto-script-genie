package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class q<Z> {
    private com.bumptech.glide.load.n a;
    private com.bumptech.glide.load.u<Z> b;
    private y0<Z> c;

    q() {
    }

    void a() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    void b(r rVar, com.bumptech.glide.load.r rVar2) {
        com.bumptech.glide.b0.q.i.a("DecodeJob.encode");
        try {
            rVar.a().a(this.a, new j(this.b, this.c, rVar2));
        } finally {
            this.c.g();
            com.bumptech.glide.b0.q.i.d();
        }
    }

    boolean c() {
        return this.c != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <X> void d(com.bumptech.glide.load.n nVar, com.bumptech.glide.load.u<X> uVar, y0<X> y0Var) {
        this.a = nVar;
        this.b = uVar;
        this.c = y0Var;
    }
}
