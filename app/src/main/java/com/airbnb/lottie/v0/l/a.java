package com.airbnb.lottie.v0.l;

import android.graphics.PointF;
import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class a implements b {
    private final String a;
    private final com.airbnb.lottie.v0.k.m<PointF, PointF> b;
    private final com.airbnb.lottie.v0.k.f c;
    private final boolean d;
    private final boolean e;

    public a(String str, com.airbnb.lottie.v0.k.m<PointF, PointF> mVar, com.airbnb.lottie.v0.k.f fVar, boolean z, boolean z2) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = z;
        this.e = z2;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.h(e0Var, cVar, this);
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.v0.k.m<PointF, PointF> c() {
        return this.b;
    }

    public com.airbnb.lottie.v0.k.f d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}
