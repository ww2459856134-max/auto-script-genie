package com.airbnb.lottie.v0.l;

import android.graphics.PointF;
import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class l implements b {
    private final String a;
    private final k b;
    private final com.airbnb.lottie.v0.k.b c;
    private final com.airbnb.lottie.v0.k.m<PointF, PointF> d;
    private final com.airbnb.lottie.v0.k.b e;
    private final com.airbnb.lottie.v0.k.b f;
    private final com.airbnb.lottie.v0.k.b g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.v0.k.b f528h;

    /* renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.v0.k.b f529i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f530j;

    public l(String str, k kVar, com.airbnb.lottie.v0.k.b bVar, com.airbnb.lottie.v0.k.m<PointF, PointF> mVar, com.airbnb.lottie.v0.k.b bVar2, com.airbnb.lottie.v0.k.b bVar3, com.airbnb.lottie.v0.k.b bVar4, com.airbnb.lottie.v0.k.b bVar5, com.airbnb.lottie.v0.k.b bVar6, boolean z) {
        this.a = str;
        this.b = kVar;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.f528h = bVar5;
        this.f529i = bVar6;
        this.f530j = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.r(e0Var, cVar, this);
    }

    public com.airbnb.lottie.v0.k.b b() {
        return this.f;
    }

    public com.airbnb.lottie.v0.k.b c() {
        return this.f528h;
    }

    public String d() {
        return this.a;
    }

    public com.airbnb.lottie.v0.k.b e() {
        return this.g;
    }

    public com.airbnb.lottie.v0.k.b f() {
        return this.f529i;
    }

    public com.airbnb.lottie.v0.k.b g() {
        return this.c;
    }

    public com.airbnb.lottie.v0.k.m<PointF, PointF> h() {
        return this.d;
    }

    public com.airbnb.lottie.v0.k.b i() {
        return this.e;
    }

    public k j() {
        return this.b;
    }

    public boolean k() {
        return this.f530j;
    }
}
