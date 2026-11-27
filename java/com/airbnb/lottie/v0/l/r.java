package com.airbnb.lottie.v0.l;

import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class r implements b {
    private final String a;
    private final int b;
    private final com.airbnb.lottie.v0.k.h c;
    private final boolean d;

    public r(String str, int i2, com.airbnb.lottie.v0.k.h hVar, boolean z) {
        this.a = str;
        this.b = i2;
        this.c = hVar;
        this.d = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.u(e0Var, cVar, this);
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.v0.k.h c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
