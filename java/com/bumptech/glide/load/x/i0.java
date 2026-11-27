package com.bumptech.glide.load.x;

import android.util.Log;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i0 implements n0, com.bumptech.glide.load.x.h1.n, q0 {

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f615i = Log.isLoggable("Engine", 2);
    private final v0 a;
    private final p0 b;
    private final com.bumptech.glide.load.x.h1.o c;
    private final f0 d;
    private final d1 e;
    private final g0 f;
    private final d0 g;

    /* renamed from: h, reason: collision with root package name */
    private final f f616h;

    public i0(com.bumptech.glide.load.x.h1.o oVar, com.bumptech.glide.load.x.h1.a aVar, com.bumptech.glide.load.x.i1.f fVar, com.bumptech.glide.load.x.i1.f fVar2, com.bumptech.glide.load.x.i1.f fVar3, com.bumptech.glide.load.x.i1.f fVar4, boolean z) {
        this(oVar, aVar, fVar, fVar2, fVar3, fVar4, null, null, null, null, null, null, z);
    }

    private r0<?> e(com.bumptech.glide.load.n nVar) {
        z0<?> z0VarD = this.c.d(nVar);
        if (z0VarD == null) {
            return null;
        }
        return z0VarD instanceof r0 ? (r0) z0VarD : new r0<>(z0VarD, true, true, nVar, this);
    }

    private r0<?> g(com.bumptech.glide.load.n nVar) {
        r0<?> r0VarE = this.f616h.e(nVar);
        if (r0VarE != null) {
            r0VarE.c();
        }
        return r0VarE;
    }

    private r0<?> h(com.bumptech.glide.load.n nVar) {
        r0<?> r0VarE = e(nVar);
        if (r0VarE != null) {
            r0VarE.c();
            this.f616h.a(nVar, r0VarE);
        }
        return r0VarE;
    }

    private r0<?> i(o0 o0Var, boolean z, long j2) {
        if (!z) {
            return null;
        }
        r0<?> r0VarG = g(o0Var);
        if (r0VarG != null) {
            if (f615i) {
                j("Loaded resource from active resources", j2, o0Var);
            }
            return r0VarG;
        }
        r0<?> r0VarH = h(o0Var);
        if (r0VarH == null) {
            return null;
        }
        if (f615i) {
            j("Loaded resource from cache", j2, o0Var);
        }
        return r0VarH;
    }

    private static void j(String str, long j2, com.bumptech.glide.load.n nVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.b0.j.a(j2) + "ms, key: " + nVar);
    }

    private <R> h0 l(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.n nVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, b0 b0Var, Map<Class<?>, com.bumptech.glide.load.v<?>> map, boolean z, boolean z2, com.bumptech.glide.load.r rVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.z.h hVar2, Executor executor, o0 o0Var, long j2) {
        j0<?> j0VarA = this.a.a(o0Var, z6);
        if (j0VarA != null) {
            j0VarA.a(hVar2, executor);
            if (f615i) {
                j("Added to existing load", j2, o0Var);
            }
            return new h0(this, hVar2, j0VarA);
        }
        j0<R> j0VarA2 = this.d.a(o0Var, z3, z4, z5, z6);
        p<R> pVarA = this.g.a(fVar, obj, o0Var, nVar, i2, i3, cls, cls2, hVar, b0Var, map, z, z2, z6, rVar, j0VarA2);
        this.a.c(o0Var, j0VarA2);
        j0VarA2.a(hVar2, executor);
        j0VarA2.s(pVarA);
        if (f615i) {
            j("Started new load", j2, o0Var);
        }
        return new h0(this, hVar2, j0VarA2);
    }

    @Override // com.bumptech.glide.load.x.n0
    public synchronized void a(j0<?> j0Var, com.bumptech.glide.load.n nVar, r0<?> r0Var) {
        if (r0Var != null) {
            if (r0Var.e()) {
                this.f616h.a(nVar, r0Var);
            }
            this.a.d(nVar, j0Var);
        } else {
            this.a.d(nVar, j0Var);
        }
    }

    @Override // com.bumptech.glide.load.x.n0
    public synchronized void b(j0<?> j0Var, com.bumptech.glide.load.n nVar) {
        this.a.d(nVar, j0Var);
    }

    @Override // com.bumptech.glide.load.x.q0
    public void c(com.bumptech.glide.load.n nVar, r0<?> r0Var) {
        this.f616h.d(nVar);
        if (r0Var.e()) {
            this.c.c(nVar, r0Var);
        } else {
            this.e.a(r0Var, false);
        }
    }

    @Override // com.bumptech.glide.load.x.h1.n
    public void d(z0<?> z0Var) {
        this.e.a(z0Var, true);
    }

    public <R> h0 f(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.n nVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, b0 b0Var, Map<Class<?>, com.bumptech.glide.load.v<?>> map, boolean z, boolean z2, com.bumptech.glide.load.r rVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.z.h hVar2, Executor executor) {
        long jB = f615i ? com.bumptech.glide.b0.j.b() : 0L;
        o0 o0VarA = this.b.a(obj, nVar, i2, i3, map, cls, cls2, rVar);
        synchronized (this) {
            r0<?> r0VarI = i(o0VarA, z3, jB);
            if (r0VarI == null) {
                return l(fVar, obj, nVar, i2, i3, cls, cls2, hVar, b0Var, map, z, z2, rVar, z3, z4, z5, z6, hVar2, executor, o0VarA, jB);
            }
            hVar2.c(r0VarI, com.bumptech.glide.load.a.MEMORY_CACHE);
            return null;
        }
    }

    public void k(z0<?> z0Var) {
        if (!(z0Var instanceof r0)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((r0) z0Var).f();
    }

    i0(com.bumptech.glide.load.x.h1.o oVar, com.bumptech.glide.load.x.h1.a aVar, com.bumptech.glide.load.x.i1.f fVar, com.bumptech.glide.load.x.i1.f fVar2, com.bumptech.glide.load.x.i1.f fVar3, com.bumptech.glide.load.x.i1.f fVar4, v0 v0Var, p0 p0Var, f fVar5, f0 f0Var, d0 d0Var, d1 d1Var, boolean z) {
        this.c = oVar;
        g0 g0Var = new g0(aVar);
        this.f = g0Var;
        f fVar6 = fVar5 == null ? new f(z) : fVar5;
        this.f616h = fVar6;
        fVar6.f(this);
        this.b = p0Var == null ? new p0() : p0Var;
        this.a = v0Var == null ? new v0() : v0Var;
        this.d = f0Var == null ? new f0(fVar, fVar2, fVar3, fVar4, this, this) : f0Var;
        this.g = d0Var == null ? new d0(g0Var) : d0Var;
        this.e = d1Var == null ? new d1() : d1Var;
        oVar.e(this);
    }
}
