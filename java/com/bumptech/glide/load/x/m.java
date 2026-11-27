package com.bumptech.glide.load.x;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class m<Transcode> {
    private final List<com.bumptech.glide.load.y.o0<?>> a = new ArrayList();
    private final List<com.bumptech.glide.load.n> b = new ArrayList();
    private com.bumptech.glide.f c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;

    /* renamed from: h, reason: collision with root package name */
    private r f621h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.r f622i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.v<?>> f623j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f624k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f625l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f626m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.n f627n;

    /* renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.h f628o;
    private b0 p;
    private boolean q;
    private boolean r;

    m() {
    }

    void a() {
        this.c = null;
        this.d = null;
        this.f627n = null;
        this.g = null;
        this.f624k = null;
        this.f622i = null;
        this.f628o = null;
        this.f623j = null;
        this.p = null;
        this.a.clear();
        this.f625l = false;
        this.b.clear();
        this.f626m = false;
    }

    com.bumptech.glide.load.x.g1.b b() {
        return this.c.b();
    }

    List<com.bumptech.glide.load.n> c() {
        if (!this.f626m) {
            this.f626m = true;
            this.b.clear();
            List<com.bumptech.glide.load.y.o0<?>> listG = g();
            int size = listG.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.bumptech.glide.load.y.o0<?> o0Var = listG.get(i2);
                if (!this.b.contains(o0Var.a)) {
                    this.b.add(o0Var.a);
                }
                for (int i3 = 0; i3 < o0Var.b.size(); i3++) {
                    if (!this.b.contains(o0Var.b.get(i3))) {
                        this.b.add(o0Var.b.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    com.bumptech.glide.load.x.h1.c d() {
        return this.f621h.a();
    }

    b0 e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List<com.bumptech.glide.load.y.o0<?>> g() {
        if (!this.f625l) {
            this.f625l = true;
            this.a.clear();
            List listI = this.c.h().i(this.d);
            int size = listI.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.bumptech.glide.load.y.o0<?> o0VarA = ((com.bumptech.glide.load.y.p0) listI.get(i2)).a(this.d, this.e, this.f, this.f622i);
                if (o0VarA != null) {
                    this.a.add(o0VarA);
                }
            }
        }
        return this.a;
    }

    <Data> w0<Data, ?, Transcode> h(Class<Data> cls) {
        return this.c.h().h(cls, this.g, this.f624k);
    }

    Class<?> i() {
        return this.d.getClass();
    }

    List<com.bumptech.glide.load.y.p0<File, ?>> j(File file) throws com.bumptech.glide.l {
        return this.c.h().i(file);
    }

    com.bumptech.glide.load.r k() {
        return this.f622i;
    }

    com.bumptech.glide.h l() {
        return this.f628o;
    }

    List<Class<?>> m() {
        return this.c.h().j(this.d.getClass(), this.g, this.f624k);
    }

    <Z> com.bumptech.glide.load.u<Z> n(z0<Z> z0Var) {
        return this.c.h().k(z0Var);
    }

    com.bumptech.glide.load.n o() {
        return this.f627n;
    }

    <X> com.bumptech.glide.load.d<X> p(X x) throws com.bumptech.glide.n {
        return this.c.h().m(x);
    }

    Class<?> q() {
        return this.f624k;
    }

    <Z> com.bumptech.glide.load.v<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.v<Z> vVar = (com.bumptech.glide.load.v) this.f623j.get(cls);
        if (vVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.v<?>>> it = this.f623j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.v<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    vVar = (com.bumptech.glide.load.v) next.getValue();
                    break;
                }
            }
        }
        if (vVar != null) {
            return vVar;
        }
        if (!this.f623j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.z.e.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    int s() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void u(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.n nVar, int i2, int i3, b0 b0Var, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, com.bumptech.glide.load.r rVar, Map<Class<?>, com.bumptech.glide.load.v<?>> map, boolean z, boolean z2, r rVar2) {
        this.c = fVar;
        this.d = obj;
        this.f627n = nVar;
        this.e = i2;
        this.f = i3;
        this.p = b0Var;
        this.g = cls;
        this.f621h = rVar2;
        this.f624k = cls2;
        this.f628o = hVar;
        this.f622i = rVar;
        this.f623j = map;
        this.q = z;
        this.r = z2;
    }

    boolean v(z0<?> z0Var) {
        return this.c.h().n(z0Var);
    }

    boolean w() {
        return this.r;
    }

    boolean x(com.bumptech.glide.load.n nVar) {
        List<com.bumptech.glide.load.y.o0<?>> listG = g();
        int size = listG.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listG.get(i2).a.equals(nVar)) {
                return true;
            }
        }
        return false;
    }
}
