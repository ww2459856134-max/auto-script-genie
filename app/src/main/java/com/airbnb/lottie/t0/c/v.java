package com.airbnb.lottie.t0.c;

import java.util.Collections;

/* loaded from: classes.dex */
public class v<K, A> extends g<K, A> {

    /* renamed from: i, reason: collision with root package name */
    private final A f513i;

    public v(com.airbnb.lottie.z0.c<A> cVar) {
        this(cVar, null);
    }

    @Override // com.airbnb.lottie.t0.c.g
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.t0.c.g
    public A h() {
        com.airbnb.lottie.z0.c<A> cVar = this.e;
        A a = this.f513i;
        return cVar.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // com.airbnb.lottie.t0.c.g
    A i(com.airbnb.lottie.z0.a<K> aVar, float f) {
        return h();
    }

    @Override // com.airbnb.lottie.t0.c.g
    public void j() {
        if (this.e != null) {
            super.j();
        }
    }

    @Override // com.airbnb.lottie.t0.c.g
    public void l(float f) {
        this.d = f;
    }

    public v(com.airbnb.lottie.z0.c<A> cVar, A a) {
        super(Collections.emptyList());
        m(cVar);
        this.f513i = a;
    }
}
