package com.airbnb.lottie.v0.l;

import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class x implements b {
    private final String a;
    private final w b;
    private final com.airbnb.lottie.v0.k.b c;
    private final com.airbnb.lottie.v0.k.b d;
    private final com.airbnb.lottie.v0.k.b e;
    private final boolean f;

    public x(String str, w wVar, com.airbnb.lottie.v0.k.b bVar, com.airbnb.lottie.v0.k.b bVar2, com.airbnb.lottie.v0.k.b bVar3, boolean z) {
        this.a = str;
        this.b = wVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.w(cVar, this);
    }

    public com.airbnb.lottie.v0.k.b b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.v0.k.b d() {
        return this.e;
    }

    public com.airbnb.lottie.v0.k.b e() {
        return this.c;
    }

    public w f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
