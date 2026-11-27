package com.airbnb.lottie.v0.l;

import android.graphics.Path;
import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class p implements b {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final com.airbnb.lottie.v0.k.a d;
    private final com.airbnb.lottie.v0.k.d e;
    private final boolean f;

    public p(String str, boolean z, Path.FillType fillType, com.airbnb.lottie.v0.k.a aVar, com.airbnb.lottie.v0.k.d dVar, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z2;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.i(e0Var, cVar, this);
    }

    public com.airbnb.lottie.v0.k.a b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public com.airbnb.lottie.v0.k.d e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
