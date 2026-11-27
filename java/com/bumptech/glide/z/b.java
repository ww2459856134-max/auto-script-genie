package com.bumptech.glide.z;

/* loaded from: classes.dex */
public final class b implements e, c {
    private final Object a;
    private final e b;
    private volatile c c;
    private volatile c d;
    private d e;
    private d f;

    public b(Object obj, e eVar) {
        d dVar = d.CLEARED;
        this.e = dVar;
        this.f = dVar;
        this.a = obj;
        this.b = eVar;
    }

    private boolean m(c cVar) {
        return cVar.equals(this.c) || (this.e == d.FAILED && cVar.equals(this.d));
    }

    private boolean n() {
        e eVar = this.b;
        return eVar == null || eVar.l(this);
    }

    private boolean o() {
        e eVar = this.b;
        return eVar == null || eVar.e(this);
    }

    private boolean p() {
        e eVar = this.b;
        return eVar == null || eVar.i(this);
    }

    @Override // com.bumptech.glide.z.e, com.bumptech.glide.z.c
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c.a() || this.d.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.z.e
    public void b(c cVar) {
        synchronized (this.a) {
            if (cVar.equals(this.c)) {
                this.e = d.SUCCESS;
            } else if (cVar.equals(this.d)) {
                this.f = d.SUCCESS;
            }
            e eVar = this.b;
            if (eVar != null) {
                eVar.b(this);
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public e c() {
        e eVarC;
        synchronized (this.a) {
            e eVar = this.b;
            eVarC = eVar != null ? eVar.c() : this;
        }
        return eVarC;
    }

    @Override // com.bumptech.glide.z.c
    public void clear() {
        synchronized (this.a) {
            d dVar = d.CLEARED;
            this.e = dVar;
            this.c.clear();
            if (this.f != dVar) {
                this.f = dVar;
                this.d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.z.c
    public void d() {
        synchronized (this.a) {
            d dVar = this.e;
            d dVar2 = d.RUNNING;
            if (dVar == dVar2) {
                this.e = d.PAUSED;
                this.c.d();
            }
            if (this.f == dVar2) {
                this.f = d.PAUSED;
                this.d.d();
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public boolean e(c cVar) {
        boolean z;
        synchronized (this.a) {
            z = o() && m(cVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean f() {
        boolean z;
        synchronized (this.a) {
            d dVar = this.e;
            d dVar2 = d.CLEARED;
            z = dVar == dVar2 && this.f == dVar2;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean g() {
        boolean z;
        synchronized (this.a) {
            d dVar = this.e;
            d dVar2 = d.SUCCESS;
            z = dVar == dVar2 || this.f == dVar2;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean h(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        return this.c.h(bVar.c) && this.d.h(bVar.d);
    }

    @Override // com.bumptech.glide.z.e
    public boolean i(c cVar) {
        boolean z;
        synchronized (this.a) {
            z = p() && m(cVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            d dVar = this.e;
            d dVar2 = d.RUNNING;
            z = dVar == dVar2 || this.f == dVar2;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.e
    public void j(c cVar) {
        synchronized (this.a) {
            if (cVar.equals(this.d)) {
                this.f = d.FAILED;
                e eVar = this.b;
                if (eVar != null) {
                    eVar.j(this);
                }
                return;
            }
            this.e = d.FAILED;
            d dVar = this.f;
            d dVar2 = d.RUNNING;
            if (dVar != dVar2) {
                this.f = dVar2;
                this.d.k();
            }
        }
    }

    @Override // com.bumptech.glide.z.c
    public void k() {
        synchronized (this.a) {
            d dVar = this.e;
            d dVar2 = d.RUNNING;
            if (dVar != dVar2) {
                this.e = dVar2;
                this.c.k();
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public boolean l(c cVar) {
        boolean z;
        synchronized (this.a) {
            z = n() && m(cVar);
        }
        return z;
    }

    public void q(c cVar, c cVar2) {
        this.c = cVar;
        this.d = cVar2;
    }
}
