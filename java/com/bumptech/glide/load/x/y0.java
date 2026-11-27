package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
final class y0<Z> implements z0<Z>, com.bumptech.glide.b0.q.f {
    private static final h.e.i.e<y0<?>> g = com.bumptech.glide.b0.q.h.d(20, new x0());
    private final com.bumptech.glide.b0.q.l c = com.bumptech.glide.b0.q.l.a();
    private z0<Z> d;
    private boolean e;
    private boolean f;

    y0() {
    }

    private void c(z0<Z> z0Var) {
        this.f = false;
        this.e = true;
        this.d = z0Var;
    }

    static <Z> y0<Z> d(z0<Z> z0Var) {
        y0 y0VarA = g.a();
        com.bumptech.glide.b0.n.d(y0VarA);
        y0 y0Var = y0VarA;
        y0Var.c(z0Var);
        return y0Var;
    }

    private void f() {
        this.d = null;
        g.b(this);
    }

    @Override // com.bumptech.glide.load.x.z0
    public synchronized void a() {
        this.c.c();
        this.f = true;
        if (!this.e) {
            this.d.a();
            f();
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<Z> b() {
        return this.d.b();
    }

    @Override // com.bumptech.glide.b0.q.f
    public com.bumptech.glide.b0.q.l e() {
        return this.c;
    }

    synchronized void g() {
        this.c.c();
        if (!this.e) {
            throw new IllegalStateException("Already unlocked");
        }
        this.e = false;
        if (this.f) {
            a();
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    public Z get() {
        return this.d.get();
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return this.d.getSize();
    }
}
