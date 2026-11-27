package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.u;
import com.bumptech.glide.load.x.w;
import com.bumptech.glide.load.x.w0;
import com.bumptech.glide.load.x.z0;
import com.bumptech.glide.load.y.p0;
import com.bumptech.glide.load.y.q0;
import com.bumptech.glide.load.y.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class o {
    private final t0 a;
    private final com.bumptech.glide.y.b b;
    private final com.bumptech.glide.y.g c;
    private final com.bumptech.glide.y.i d;
    private final com.bumptech.glide.load.w.j e;
    private final com.bumptech.glide.load.z.k.g f;
    private final com.bumptech.glide.y.c g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.y.e f669h = new com.bumptech.glide.y.e();

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.y.d f670i = new com.bumptech.glide.y.d();

    /* renamed from: j, reason: collision with root package name */
    private final h.e.i.e<List<Throwable>> f671j;

    public o() {
        h.e.i.e<List<Throwable>> eVarE = com.bumptech.glide.b0.q.h.e();
        this.f671j = eVarE;
        this.a = new t0(eVarE);
        this.b = new com.bumptech.glide.y.b();
        this.c = new com.bumptech.glide.y.g();
        this.d = new com.bumptech.glide.y.i();
        this.e = new com.bumptech.glide.load.w.j();
        this.f = new com.bumptech.glide.load.z.k.g();
        this.g = new com.bumptech.glide.y.c();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<w<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.d(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new w(cls, cls4, cls5, this.c.b(cls, cls4), this.f.a(cls4, cls5), this.f671j));
            }
        }
        return arrayList;
    }

    public <Data> o a(Class<Data> cls, com.bumptech.glide.load.d<Data> dVar) {
        this.b.a(cls, dVar);
        return this;
    }

    public <TResource> o b(Class<TResource> cls, u<TResource> uVar) {
        this.d.a(cls, uVar);
        return this;
    }

    public <Data, TResource> o c(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.t<Data, TResource> tVar) {
        e("legacy_append", cls, cls2, tVar);
        return this;
    }

    public <Model, Data> o d(Class<Model> cls, Class<Data> cls2, q0<Model, Data> q0Var) {
        this.a.a(cls, cls2, q0Var);
        return this;
    }

    public <Data, TResource> o e(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.t<Data, TResource> tVar) {
        this.c.a(str, tVar, cls, cls2);
        return this;
    }

    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.g.b();
        if (listB.isEmpty()) {
            throw new k();
        }
        return listB;
    }

    public <Data, TResource, Transcode> w0<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        w0<Data, TResource, Transcode> w0VarA = this.f670i.a(cls, cls2, cls3);
        if (this.f670i.c(w0VarA)) {
            return null;
        }
        if (w0VarA == null) {
            List<w<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
            w0VarA = listF.isEmpty() ? null : new w0<>(cls, cls2, cls3, listF, this.f671j);
            this.f670i.d(cls, cls2, cls3, w0VarA);
        }
        return w0VarA;
    }

    public <Model> List<p0<Model, ?>> i(Model model) {
        return this.a.d(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.f669h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.c.d(it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f669h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public <X> u<X> k(z0<X> z0Var) throws m {
        u<X> uVarB = this.d.b(z0Var.b());
        if (uVarB != null) {
            return uVarB;
        }
        throw new m(z0Var.b());
    }

    public <X> com.bumptech.glide.load.w.g<X> l(X x) {
        return this.e.a(x);
    }

    public <X> com.bumptech.glide.load.d<X> m(X x) throws n {
        com.bumptech.glide.load.d<X> dVarB = this.b.b(x.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new n(x.getClass());
    }

    public boolean n(z0<?> z0Var) {
        return this.d.b(z0Var.b()) != null;
    }

    public o o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public o p(com.bumptech.glide.load.w.f<?> fVar) {
        this.e.b(fVar);
        return this;
    }

    public <TResource, Transcode> o q(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.z.k.e<TResource, Transcode> eVar) {
        this.f.c(cls, cls2, eVar);
        return this;
    }

    public final o r(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.c.e(arrayList);
        return this;
    }
}
