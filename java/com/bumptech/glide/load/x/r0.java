package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class r0<Z> implements z0<Z> {
    private final boolean c;
    private final boolean d;
    private final z0<Z> e;
    private final q0 f;
    private final com.bumptech.glide.load.n g;

    /* renamed from: h, reason: collision with root package name */
    private int f636h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f637i;

    r0(z0<Z> z0Var, boolean z, boolean z2, com.bumptech.glide.load.n nVar, q0 q0Var) {
        com.bumptech.glide.b0.n.d(z0Var);
        this.e = z0Var;
        this.c = z;
        this.d = z2;
        this.g = nVar;
        com.bumptech.glide.b0.n.d(q0Var);
        this.f = q0Var;
    }

    @Override // com.bumptech.glide.load.x.z0
    public synchronized void a() {
        if (this.f636h > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f637i) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f637i = true;
        if (this.d) {
            this.e.a();
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<Z> b() {
        return this.e.b();
    }

    synchronized void c() {
        if (this.f637i) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f636h++;
    }

    z0<Z> d() {
        return this.e;
    }

    boolean e() {
        return this.c;
    }

    void f() {
        boolean z;
        synchronized (this) {
            int i2 = this.f636h;
            if (i2 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i3 = i2 - 1;
            this.f636h = i3;
            if (i3 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f.c(this.g, this);
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    public Z get() {
        return this.e.get();
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return this.e.getSize();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.c + ", listener=" + this.f + ", key=" + this.g + ", acquired=" + this.f636h + ", isRecycled=" + this.f637i + ", resource=" + this.e + '}';
    }
}
