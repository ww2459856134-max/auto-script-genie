package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.x.i0;
import com.bumptech.glide.w.p;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {
    private i0 b;
    private com.bumptech.glide.load.x.g1.g c;
    private com.bumptech.glide.load.x.g1.b d;
    private com.bumptech.glide.load.x.h1.o e;
    private com.bumptech.glide.load.x.i1.f f;
    private com.bumptech.glide.load.x.i1.f g;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.x.h1.a f581h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.x.h1.s f582i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.w.e f583j;

    /* renamed from: m, reason: collision with root package name */
    private p.a f586m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.x.i1.f f587n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f588o;
    private List<com.bumptech.glide.z.f<Object>> p;
    private boolean q;
    private boolean r;
    private final Map<Class<?>, t<?, ?>> a = new h.d.b();

    /* renamed from: k, reason: collision with root package name */
    private int f584k = 4;

    /* renamed from: l, reason: collision with root package name */
    private b f585l = new d(this);

    c a(Context context) {
        if (this.f == null) {
            this.f = com.bumptech.glide.load.x.i1.f.g();
        }
        if (this.g == null) {
            this.g = com.bumptech.glide.load.x.i1.f.e();
        }
        if (this.f587n == null) {
            this.f587n = com.bumptech.glide.load.x.i1.f.c();
        }
        if (this.f582i == null) {
            this.f582i = new com.bumptech.glide.load.x.h1.p(context).a();
        }
        if (this.f583j == null) {
            this.f583j = new com.bumptech.glide.w.h();
        }
        if (this.c == null) {
            int iB = this.f582i.b();
            if (iB > 0) {
                this.c = new com.bumptech.glide.load.x.g1.r(iB);
            } else {
                this.c = new com.bumptech.glide.load.x.g1.h();
            }
        }
        if (this.d == null) {
            this.d = new com.bumptech.glide.load.x.g1.o(this.f582i.a());
        }
        if (this.e == null) {
            this.e = new com.bumptech.glide.load.x.h1.m(this.f582i.d());
        }
        if (this.f581h == null) {
            this.f581h = new com.bumptech.glide.load.x.h1.l(context);
        }
        if (this.b == null) {
            this.b = new i0(this.e, this.f581h, this.g, this.f, com.bumptech.glide.load.x.i1.f.h(), this.f587n, this.f588o);
        }
        List<com.bumptech.glide.z.f<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        return new c(context, this.b, this.e, this.c, this.d, new com.bumptech.glide.w.p(this.f586m), this.f583j, this.f584k, this.f585l, this.a, this.p, this.q, this.r);
    }

    void b(p.a aVar) {
        this.f586m = aVar;
    }
}
