package com.airbnb.lottie.v0.l;

import android.graphics.PointF;
import com.airbnb.lottie.e0;

/* loaded from: classes.dex */
public class m implements b {
    private final String a;
    private final com.airbnb.lottie.v0.k.m<PointF, PointF> b;
    private final com.airbnb.lottie.v0.k.f c;
    private final com.airbnb.lottie.v0.k.b d;
    private final boolean e;

    public m(String str, com.airbnb.lottie.v0.k.m<PointF, PointF> mVar, com.airbnb.lottie.v0.k.f fVar, com.airbnb.lottie.v0.k.b bVar, boolean z) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = bVar;
        this.e = z;
    }

    @Override // com.airbnb.lottie.v0.l.b
    public com.airbnb.lottie.t0.b.e a(e0 e0Var, com.airbnb.lottie.v0.m.c cVar) {
        return new com.airbnb.lottie.t0.b.s(e0Var, cVar, this);
    }

    public com.airbnb.lottie.v0.k.b b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.v0.k.m<PointF, PointF> d() {
        return this.b;
    }

    public com.airbnb.lottie.v0.k.f e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
