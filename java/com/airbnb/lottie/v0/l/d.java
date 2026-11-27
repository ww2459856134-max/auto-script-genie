package com.airbnb.lottie.v0.l;

import android.graphics.Path;
import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class d implements b {
    private final f a;
    private final Path.FillType b;
    private final com.airbnb.lottie.v0.k.c c;
    private final com.airbnb.lottie.v0.k.d d;
    private final com.airbnb.lottie.v0.k.f e;
    private final com.airbnb.lottie.v0.k.f f;
    private final String g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f520h;

    public d(String str, f fVar, Path.FillType fillType, com.airbnb.lottie.v0.k.c cVar, com.airbnb.lottie.v0.k.d dVar, com.airbnb.lottie.v0.k.f fVar2, com.airbnb.lottie.v0.k.f fVar3, com.airbnb.lottie.v0.k.b bVar, com.airbnb.lottie.v0.k.b bVar2, boolean z) {
        this.a = fVar;
        this.b = fillType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar2;
        this.f = fVar3;
        this.g = str;
        this.f520h = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.j(e0Var, cVar, this);
    }

    public com.airbnb.lottie.v0.k.f b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public com.airbnb.lottie.v0.k.c d() {
        return this.c;
    }

    public f e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public com.airbnb.lottie.v0.k.d g() {
        return this.d;
    }

    public com.airbnb.lottie.v0.k.f h() {
        return this.e;
    }

    public boolean i() {
        return this.f520h;
    }
}
