package com.bumptech.glide.load.x;

import android.util.Log;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class f1 implements l, k {
    private final m<?> c;
    private final k d;
    private int e;
    private h f;
    private Object g;

    /* renamed from: h, reason: collision with root package name */
    private volatile com.bumptech.glide.load.y.o0<?> f603h;

    /* renamed from: i, reason: collision with root package name */
    private i f604i;

    f1(m<?> mVar, k kVar) {
        this.c = mVar;
        this.d = kVar;
    }

    private void e(Object obj) {
        long jB = com.bumptech.glide.b0.j.b();
        try {
            com.bumptech.glide.load.d<X> dVarP = this.c.p(obj);
            j jVar = new j(dVarP, obj, this.c.k());
            this.f604i = new i(this.f603h.a, this.c.o());
            this.c.d().a(this.f604i, jVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f604i + ", data: " + obj + ", encoder: " + dVarP + ", duration: " + com.bumptech.glide.b0.j.a(jB));
            }
            this.f603h.c.b();
            this.f = new h(Collections.singletonList(this.f603h.a), this.c, this);
        } catch (Throwable th) {
            this.f603h.c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.e < this.c.g().size();
    }

    private void j(com.bumptech.glide.load.y.o0<?> o0Var) {
        this.f603h.c.d(this.c.l(), new e1(this, o0Var));
    }

    @Override // com.bumptech.glide.load.x.l
    public boolean a() {
        Object obj = this.g;
        if (obj != null) {
            this.g = null;
            e(obj);
        }
        h hVar = this.f;
        if (hVar != null && hVar.a()) {
            return true;
        }
        this.f = null;
        this.f603h = null;
        boolean z = false;
        while (!z && f()) {
            List<com.bumptech.glide.load.y.o0<?>> listG = this.c.g();
            int i2 = this.e;
            this.e = i2 + 1;
            this.f603h = listG.get(i2);
            if (this.f603h != null && (this.c.e().c(this.f603h.c.c()) || this.c.t(this.f603h.c.a()))) {
                j(this.f603h);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.x.k
    public void b(com.bumptech.glide.load.n nVar, Exception exc, com.bumptech.glide.load.w.e<?> eVar, com.bumptech.glide.load.a aVar) {
        this.d.b(nVar, exc, eVar, this.f603h.c.c());
    }

    @Override // com.bumptech.glide.load.x.k
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.x.l
    public void cancel() {
        com.bumptech.glide.load.y.o0<?> o0Var = this.f603h;
        if (o0Var != null) {
            o0Var.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.x.k
    public void d(com.bumptech.glide.load.n nVar, Object obj, com.bumptech.glide.load.w.e<?> eVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.n nVar2) {
        this.d.d(nVar, obj, eVar, this.f603h.c.c(), nVar);
    }

    boolean g(com.bumptech.glide.load.y.o0<?> o0Var) {
        com.bumptech.glide.load.y.o0<?> o0Var2 = this.f603h;
        return o0Var2 != null && o0Var2 == o0Var;
    }

    void h(com.bumptech.glide.load.y.o0<?> o0Var, Object obj) {
        b0 b0VarE = this.c.e();
        if (obj != null && b0VarE.c(o0Var.c.c())) {
            this.g = obj;
            this.d.c();
        } else {
            k kVar = this.d;
            com.bumptech.glide.load.n nVar = o0Var.a;
            com.bumptech.glide.load.w.e<?> eVar = o0Var.c;
            kVar.d(nVar, obj, eVar, eVar.c(), this.f604i);
        }
    }

    void i(com.bumptech.glide.load.y.o0<?> o0Var, Exception exc) {
        k kVar = this.d;
        i iVar = this.f604i;
        com.bumptech.glide.load.w.e<?> eVar = o0Var.c;
        kVar.b(iVar, exc, eVar, eVar.c());
    }
}
