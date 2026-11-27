package com.airbnb.lottie.t0.b;

import com.airbnb.lottie.v0.l.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class w implements e, com.airbnb.lottie.t0.c.b {
    private final boolean a;
    private final List<com.airbnb.lottie.t0.c.b> b = new ArrayList();
    private final com.airbnb.lottie.v0.l.w c;
    private final com.airbnb.lottie.t0.c.g<?, Float> d;
    private final com.airbnb.lottie.t0.c.g<?, Float> e;
    private final com.airbnb.lottie.t0.c.g<?, Float> f;

    public w(com.airbnb.lottie.v0.m.c cVar, x xVar) {
        xVar.c();
        this.a = xVar.g();
        this.c = xVar.f();
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA = xVar.e().a();
        this.d = gVarA;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA2 = xVar.b().a();
        this.e = gVarA2;
        com.airbnb.lottie.t0.c.g<Float, Float> gVarA3 = xVar.d().a();
        this.f = gVarA3;
        cVar.i(gVarA);
        cVar.i(gVarA2);
        cVar.i(gVarA3);
        gVarA.a(this);
        gVarA2.a(this);
        gVarA3.a(this);
    }

    void b(com.airbnb.lottie.t0.c.b bVar) {
        this.b.add(bVar);
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            this.b.get(i2).d();
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
    }

    public com.airbnb.lottie.t0.c.g<?, Float> f() {
        return this.e;
    }

    public com.airbnb.lottie.t0.c.g<?, Float> g() {
        return this.f;
    }

    public com.airbnb.lottie.t0.c.g<?, Float> h() {
        return this.d;
    }

    com.airbnb.lottie.v0.l.w i() {
        return this.c;
    }

    public boolean j() {
        return this.a;
    }
}
