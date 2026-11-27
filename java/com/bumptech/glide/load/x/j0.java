package com.bumptech.glide.load.x;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class j0<R> implements o<R>, com.bumptech.glide.b0.q.f {
    private static final k0 W = new k0();
    private final AtomicInteger A;
    private com.bumptech.glide.load.n C;
    private boolean D;
    private boolean G;
    private boolean H;
    private boolean I;
    private z0<?> J;
    com.bumptech.glide.load.a K;
    private boolean M;
    t0 O;
    private boolean P;
    r0<?> Q;
    private p<R> U;
    private volatile boolean V;
    final m0 c;
    private final com.bumptech.glide.b0.q.l d;
    private final q0 e;
    private final h.e.i.e<j0<?>> f;
    private final k0 g;

    /* renamed from: h, reason: collision with root package name */
    private final n0 f617h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.x.i1.f f618i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.x.i1.f f619j;

    /* renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.x.i1.f f620k;
    private final com.bumptech.glide.load.x.i1.f t;

    private class a implements Runnable {
        private final com.bumptech.glide.z.h c;

        a(com.bumptech.glide.z.h hVar) {
            this.c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.c.getLock()) {
                synchronized (j0.this) {
                    if (j0.this.c.b(this.c)) {
                        j0.this.f(this.c);
                    }
                    j0.this.i();
                }
            }
        }
    }

    private class b implements Runnable {
        private final com.bumptech.glide.z.h c;

        b(com.bumptech.glide.z.h hVar) {
            this.c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.c.getLock()) {
                synchronized (j0.this) {
                    if (j0.this.c.b(this.c)) {
                        j0.this.Q.c();
                        j0.this.g(this.c);
                        j0.this.r(this.c);
                    }
                    j0.this.i();
                }
            }
        }
    }

    j0(com.bumptech.glide.load.x.i1.f fVar, com.bumptech.glide.load.x.i1.f fVar2, com.bumptech.glide.load.x.i1.f fVar3, com.bumptech.glide.load.x.i1.f fVar4, n0 n0Var, q0 q0Var, h.e.i.e<j0<?>> eVar) {
        this(fVar, fVar2, fVar3, fVar4, n0Var, q0Var, eVar, W);
    }

    private com.bumptech.glide.load.x.i1.f j() {
        return this.G ? this.f620k : this.H ? this.t : this.f619j;
    }

    private boolean m() {
        return this.P || this.M || this.V;
    }

    private synchronized void q() {
        if (this.C == null) {
            throw new IllegalArgumentException();
        }
        this.c.clear();
        this.C = null;
        this.Q = null;
        this.J = null;
        this.P = false;
        this.V = false;
        this.M = false;
        this.U.w(false);
        this.U = null;
        this.O = null;
        this.K = null;
        this.f.b(this);
    }

    synchronized void a(com.bumptech.glide.z.h hVar, Executor executor) {
        this.d.c();
        this.c.a(hVar, executor);
        boolean z = true;
        if (this.M) {
            k(1);
            executor.execute(new b(hVar));
        } else if (this.P) {
            k(1);
            executor.execute(new a(hVar));
        } else {
            if (this.V) {
                z = false;
            }
            com.bumptech.glide.b0.n.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // com.bumptech.glide.load.x.o
    public void b(t0 t0Var) {
        synchronized (this) {
            this.O = t0Var;
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.x.o
    public void c(z0<R> z0Var, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.J = z0Var;
            this.K = aVar;
        }
        o();
    }

    @Override // com.bumptech.glide.load.x.o
    public void d(p<?> pVar) {
        j().execute(pVar);
    }

    @Override // com.bumptech.glide.b0.q.f
    public com.bumptech.glide.b0.q.l e() {
        return this.d;
    }

    void f(com.bumptech.glide.z.h hVar) {
        try {
            hVar.b(this.O);
        } catch (Throwable th) {
            throw new g(th);
        }
    }

    void g(com.bumptech.glide.z.h hVar) {
        try {
            hVar.c(this.Q, this.K);
        } catch (Throwable th) {
            throw new g(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.V = true;
        this.U.a();
        this.f617h.b(this, this.C);
    }

    void i() {
        r0<?> r0Var;
        synchronized (this) {
            this.d.c();
            com.bumptech.glide.b0.n.a(m(), "Not yet complete!");
            int iDecrementAndGet = this.A.decrementAndGet();
            com.bumptech.glide.b0.n.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                r0Var = this.Q;
                q();
            } else {
                r0Var = null;
            }
        }
        if (r0Var != null) {
            r0Var.f();
        }
    }

    synchronized void k(int i2) {
        r0<?> r0Var;
        com.bumptech.glide.b0.n.a(m(), "Not yet complete!");
        if (this.A.getAndAdd(i2) == 0 && (r0Var = this.Q) != null) {
            r0Var.c();
        }
    }

    synchronized j0<R> l(com.bumptech.glide.load.n nVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.C = nVar;
        this.D = z;
        this.G = z2;
        this.H = z3;
        this.I = z4;
        return this;
    }

    void n() {
        synchronized (this) {
            this.d.c();
            if (this.V) {
                q();
                return;
            }
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.P) {
                throw new IllegalStateException("Already failed once");
            }
            this.P = true;
            com.bumptech.glide.load.n nVar = this.C;
            m0 m0VarE = this.c.e();
            k(m0VarE.size() + 1);
            this.f617h.a(this, nVar, null);
            Iterator<l0> it = m0VarE.iterator();
            while (it.hasNext()) {
                l0 next = it.next();
                next.b.execute(new a(next.a));
            }
            i();
        }
    }

    void o() {
        synchronized (this) {
            this.d.c();
            if (this.V) {
                this.J.a();
                q();
                return;
            }
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.M) {
                throw new IllegalStateException("Already have resource");
            }
            this.Q = this.g.a(this.J, this.D, this.C, this.e);
            this.M = true;
            m0 m0VarE = this.c.e();
            k(m0VarE.size() + 1);
            this.f617h.a(this, this.C, this.Q);
            Iterator<l0> it = m0VarE.iterator();
            while (it.hasNext()) {
                l0 next = it.next();
                next.b.execute(new b(next.a));
            }
            i();
        }
    }

    boolean p() {
        return this.I;
    }

    synchronized void r(com.bumptech.glide.z.h hVar) {
        this.d.c();
        this.c.h(hVar);
        if (this.c.isEmpty()) {
            h();
            if ((this.M || this.P) && this.A.get() == 0) {
                q();
            }
        }
    }

    public synchronized void s(p<R> pVar) {
        this.U = pVar;
        (pVar.C() ? this.f618i : j()).execute(pVar);
    }

    j0(com.bumptech.glide.load.x.i1.f fVar, com.bumptech.glide.load.x.i1.f fVar2, com.bumptech.glide.load.x.i1.f fVar3, com.bumptech.glide.load.x.i1.f fVar4, n0 n0Var, q0 q0Var, h.e.i.e<j0<?>> eVar, k0 k0Var) {
        this.c = new m0();
        this.d = com.bumptech.glide.b0.q.l.a();
        this.A = new AtomicInteger();
        this.f618i = fVar;
        this.f619j = fVar2;
        this.f620k = fVar3;
        this.t = fVar4;
        this.f617h = n0Var;
        this.e = q0Var;
        this.f = eVar;
        this.g = k0Var;
    }
}
