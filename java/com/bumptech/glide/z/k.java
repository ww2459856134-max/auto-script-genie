package com.bumptech.glide.z;

/* loaded from: classes.dex */
public class k implements e, c {
    private final e a;
    private final Object b;
    private volatile c c;
    private volatile c d;
    private d e;
    private d f;
    private boolean g;

    public k(Object obj, e eVar) {
        d dVar = d.CLEARED;
        this.e = dVar;
        this.f = dVar;
        this.b = obj;
        this.a = eVar;
    }

    private boolean m() {
        e eVar = this.a;
        return eVar == null || eVar.l(this);
    }

    private boolean n() {
        e eVar = this.a;
        return eVar == null || eVar.e(this);
    }

    private boolean o() {
        e eVar = this.a;
        return eVar == null || eVar.i(this);
    }

    @Override // com.bumptech.glide.z.e, com.bumptech.glide.z.c
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.d.a() || this.c.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.z.e
    public void b(c cVar) {
        synchronized (this.b) {
            if (cVar.equals(this.d)) {
                this.f = d.SUCCESS;
                return;
            }
            this.e = d.SUCCESS;
            e eVar = this.a;
            if (eVar != null) {
                eVar.b(this);
            }
            if (!this.f.a()) {
                this.d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public e c() {
        e eVarC;
        synchronized (this.b) {
            e eVar = this.a;
            eVarC = eVar != null ? eVar.c() : this;
        }
        return eVarC;
    }

    @Override // com.bumptech.glide.z.c
    public void clear() {
        synchronized (this.b) {
            this.g = false;
            d dVar = d.CLEARED;
            this.e = dVar;
            this.f = dVar;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // com.bumptech.glide.z.c
    public void d() {
        synchronized (this.b) {
            if (!this.f.a()) {
                this.f = d.PAUSED;
                this.d.d();
            }
            if (!this.e.a()) {
                this.e = d.PAUSED;
                this.c.d();
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public boolean e(c cVar) {
        boolean z;
        synchronized (this.b) {
            z = n() && cVar.equals(this.c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean f() {
        boolean z;
        synchronized (this.b) {
            z = this.e == d.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean g() {
        boolean z;
        synchronized (this.b) {
            z = this.e == d.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean h(c cVar) {
        if (!(cVar instanceof k)) {
            return false;
        }
        k kVar = (k) cVar;
        if (this.c == null) {
            if (kVar.c != null) {
                return false;
            }
        } else if (!this.c.h(kVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (kVar.d != null) {
                return false;
            }
        } else if (!this.d.h(kVar.d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.z.e
    public boolean i(c cVar) {
        boolean z;
        synchronized (this.b) {
            z = o() && (cVar.equals(this.c) || this.e != d.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.z.c
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.e == d.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.z.e
    public void j(c cVar) {
        synchronized (this.b) {
            if (!cVar.equals(this.c)) {
                this.f = d.FAILED;
                return;
            }
            this.e = d.FAILED;
            e eVar = this.a;
            if (eVar != null) {
                eVar.j(this);
            }
        }
    }

    @Override // com.bumptech.glide.z.c
    public void k() {
        synchronized (this.b) {
            this.g = true;
            try {
                if (this.e != d.SUCCESS) {
                    d dVar = this.f;
                    d dVar2 = d.RUNNING;
                    if (dVar != dVar2) {
                        this.f = dVar2;
                        this.d.k();
                    }
                }
                if (this.g) {
                    d dVar3 = this.e;
                    d dVar4 = d.RUNNING;
                    if (dVar3 != dVar4) {
                        this.e = dVar4;
                        this.c.k();
                    }
                }
            } finally {
                this.g = false;
            }
        }
    }

    @Override // com.bumptech.glide.z.e
    public boolean l(c cVar) {
        boolean z;
        synchronized (this.b) {
            z = m() && cVar.equals(this.c) && this.e != d.PAUSED;
        }
        return z;
    }

    public void p(c cVar, c cVar2) {
        this.c = cVar;
        this.d = cVar2;
    }
}
