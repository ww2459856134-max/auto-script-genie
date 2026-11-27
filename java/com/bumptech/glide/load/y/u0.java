package com.bumptech.glide.load.y;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class u0<Data> implements com.bumptech.glide.load.w.e<Data>, com.bumptech.glide.load.w.d<Data> {
    private final List<com.bumptech.glide.load.w.e<Data>> c;
    private final h.e.i.e<List<Throwable>> d;
    private int e;
    private com.bumptech.glide.h f;
    private com.bumptech.glide.load.w.d<? super Data> g;

    /* renamed from: h, reason: collision with root package name */
    private List<Throwable> f642h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f643i;

    u0(List<com.bumptech.glide.load.w.e<Data>> list, h.e.i.e<List<Throwable>> eVar) {
        this.d = eVar;
        com.bumptech.glide.b0.n.c(list);
        this.c = list;
        this.e = 0;
    }

    private void g() {
        if (this.f643i) {
            return;
        }
        if (this.e < this.c.size() - 1) {
            this.e++;
            d(this.f, this.g);
        } else {
            com.bumptech.glide.b0.n.d(this.f642h);
            this.g.f(new com.bumptech.glide.load.x.t0("Fetch failed", new ArrayList(this.f642h)));
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public Class<Data> a() {
        return this.c.get(0).a();
    }

    @Override // com.bumptech.glide.load.w.e
    public void b() {
        List<Throwable> list = this.f642h;
        if (list != null) {
            this.d.b(list);
        }
        this.f642h = null;
        Iterator<com.bumptech.glide.load.w.e<Data>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public com.bumptech.glide.load.a c() {
        return this.c.get(0).c();
    }

    @Override // com.bumptech.glide.load.w.e
    public void cancel() {
        this.f643i = true;
        Iterator<com.bumptech.glide.load.w.e<Data>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @Override // com.bumptech.glide.load.w.e
    public void d(com.bumptech.glide.h hVar, com.bumptech.glide.load.w.d<? super Data> dVar) {
        this.f = hVar;
        this.g = dVar;
        this.f642h = this.d.a();
        this.c.get(this.e).d(hVar, this);
        if (this.f643i) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.w.d
    public void e(Data data) {
        if (data != null) {
            this.g.e(data);
        } else {
            g();
        }
    }

    @Override // com.bumptech.glide.load.w.d
    public void f(Exception exc) {
        List<Throwable> list = this.f642h;
        com.bumptech.glide.b0.n.d(list);
        list.add(exc);
        g();
    }
}
