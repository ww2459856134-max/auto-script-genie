package com.bumptech.glide.load.x;

import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
class a1 implements l, com.bumptech.glide.load.w.d<Object> {
    private final k c;
    private final m<?> d;
    private int e;
    private int f = -1;
    private com.bumptech.glide.load.n g;

    /* renamed from: h, reason: collision with root package name */
    private List<com.bumptech.glide.load.y.p0<File, ?>> f596h;

    /* renamed from: i, reason: collision with root package name */
    private int f597i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.bumptech.glide.load.y.o0<?> f598j;

    /* renamed from: k, reason: collision with root package name */
    private File f599k;
    private b1 t;

    a1(m<?> mVar, k kVar) {
        this.d = mVar;
        this.c = kVar;
    }

    private boolean b() {
        return this.f597i < this.f596h.size();
    }

    @Override // com.bumptech.glide.load.x.l
    public boolean a() {
        List<com.bumptech.glide.load.n> listC = this.d.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listM = this.d.m();
        if (listM.isEmpty()) {
            if (File.class.equals(this.d.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.d.i() + " to " + this.d.q());
        }
        while (true) {
            if (this.f596h != null && b()) {
                this.f598j = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.y.p0<File, ?>> list = this.f596h;
                    int i2 = this.f597i;
                    this.f597i = i2 + 1;
                    this.f598j = list.get(i2).a(this.f599k, this.d.s(), this.d.f(), this.d.k());
                    if (this.f598j != null && this.d.t(this.f598j.c.a())) {
                        this.f598j.c.d(this.d.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f + 1;
            this.f = i3;
            if (i3 >= listM.size()) {
                int i4 = this.e + 1;
                this.e = i4;
                if (i4 >= listC.size()) {
                    return false;
                }
                this.f = 0;
            }
            com.bumptech.glide.load.n nVar = listC.get(this.e);
            Class<?> cls = listM.get(this.f);
            this.t = new b1(this.d.b(), nVar, this.d.o(), this.d.s(), this.d.f(), this.d.r(cls), cls, this.d.k());
            File fileB = this.d.d().b(this.t);
            this.f599k = fileB;
            if (fileB != null) {
                this.g = nVar;
                this.f596h = this.d.j(fileB);
                this.f597i = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.x.l
    public void cancel() {
        com.bumptech.glide.load.y.o0<?> o0Var = this.f598j;
        if (o0Var != null) {
            o0Var.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.w.d
    public void e(Object obj) {
        this.c.d(this.g, obj, this.f598j.c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.t);
    }

    @Override // com.bumptech.glide.load.w.d
    public void f(Exception exc) {
        this.c.b(this.t, exc, this.f598j.c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }
}
