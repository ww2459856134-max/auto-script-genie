package com.bumptech.glide.load.x;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
final class f {
    private final boolean a;
    final Map<com.bumptech.glide.load.n, e> b;
    private final ReferenceQueue<r0<?>> c;
    private q0 d;
    private volatile boolean e;
    private volatile d f;

    f(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new b()));
    }

    synchronized void a(com.bumptech.glide.load.n nVar, r0<?> r0Var) {
        e eVarPut = this.b.put(nVar, new e(nVar, r0Var, this.c, this.a));
        if (eVarPut != null) {
            eVarPut.a();
        }
    }

    void b() {
        while (!this.e) {
            try {
                c((e) this.c.remove());
                d dVar = this.f;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(e eVar) {
        z0<?> z0Var;
        synchronized (this) {
            this.b.remove(eVar.a);
            if (eVar.b && (z0Var = eVar.c) != null) {
                this.d.c(eVar.a, new r0<>(z0Var, true, false, eVar.a, this.d));
            }
        }
    }

    synchronized void d(com.bumptech.glide.load.n nVar) {
        e eVarRemove = this.b.remove(nVar);
        if (eVarRemove != null) {
            eVarRemove.a();
        }
    }

    synchronized r0<?> e(com.bumptech.glide.load.n nVar) {
        e eVar = this.b.get(nVar);
        if (eVar == null) {
            return null;
        }
        r0<?> r0Var = eVar.get();
        if (r0Var == null) {
            c(eVar);
        }
        return r0Var;
    }

    void f(q0 q0Var) {
        synchronized (q0Var) {
            synchronized (this) {
                this.d = q0Var;
            }
        }
    }

    f(boolean z, Executor executor) {
        this.b = new HashMap();
        this.c = new ReferenceQueue<>();
        this.a = z;
        executor.execute(new c(this));
    }
}
