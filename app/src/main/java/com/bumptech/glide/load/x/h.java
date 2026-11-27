package com.bumptech.glide.load.x;

import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
class h implements l, com.bumptech.glide.load.w.d<Object> {
    private final List<com.bumptech.glide.load.n> c;
    private final m<?> d;
    private final k e;
    private int f;
    private com.bumptech.glide.load.n g;

    /* renamed from: h, reason: collision with root package name */
    private List<com.bumptech.glide.load.y.p0<File, ?>> f609h;

    /* renamed from: i, reason: collision with root package name */
    private int f610i;

    /* renamed from: j, reason: collision with root package name */
    private volatile com.bumptech.glide.load.y.o0<?> f611j;

    /* renamed from: k, reason: collision with root package name */
    private File f612k;

    h(m<?> mVar, k kVar) {
        this(mVar.c(), mVar, kVar);
    }

    private boolean b() {
        return this.f610i < this.f609h.size();
    }

    @Override // com.bumptech.glide.load.x.l
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f609h != null && b()) {
                this.f611j = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.y.p0<File, ?>> list = this.f609h;
                    int i2 = this.f610i;
                    this.f610i = i2 + 1;
                    this.f611j = list.get(i2).a(this.f612k, this.d.s(), this.d.f(), this.d.k());
                    if (this.f611j != null && this.d.t(this.f611j.c.a())) {
                        this.f611j.c.d(this.d.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f + 1;
            this.f = i3;
            if (i3 >= this.c.size()) {
                return false;
            }
            com.bumptech.glide.load.n nVar = this.c.get(this.f);
            File fileB = this.d.d().b(new i(nVar, this.d.o()));
            this.f612k = fileB;
            if (fileB != null) {
                this.g = nVar;
                this.f609h = this.d.j(fileB);
                this.f610i = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.x.l
    public void cancel() {
        com.bumptech.glide.load.y.o0<?> o0Var = this.f611j;
        if (o0Var != null) {
            o0Var.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.w.d
    public void e(Object obj) {
        this.e.d(this.g, obj, this.f611j.c, com.bumptech.glide.load.a.DATA_DISK_CACHE, this.g);
    }

    @Override // com.bumptech.glide.load.w.d
    public void f(Exception exc) {
        this.e.b(this.g, exc, this.f611j.c, com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }

    h(List<com.bumptech.glide.load.n> list, m<?> mVar, k kVar) {
        this.f = -1;
        this.c = list;
        this.d = mVar;
        this.e = kVar;
    }
}
