package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
final class e<T> implements d<T> {
    private final List<? extends com.airbnb.lottie.z0.a<T>> a;
    private com.airbnb.lottie.z0.a<T> c = null;
    private float d = -1.0f;
    private com.airbnb.lottie.z0.a<T> b = f(0.0f);

    e(List<? extends com.airbnb.lottie.z0.a<T>> list) {
        this.a = list;
    }

    private com.airbnb.lottie.z0.a<T> f(float f) {
        List<? extends com.airbnb.lottie.z0.a<T>> list = this.a;
        com.airbnb.lottie.z0.a<T> aVar = list.get(list.size() - 1);
        if (f >= aVar.e()) {
            return aVar;
        }
        for (int size = this.a.size() - 2; size >= 1; size--) {
            com.airbnb.lottie.z0.a<T> aVar2 = this.a.get(size);
            if (this.b != aVar2 && aVar2.a(f)) {
                return aVar2;
            }
        }
        return this.a.get(0);
    }

    @Override // com.airbnb.lottie.t0.c.d
    public com.airbnb.lottie.z0.a<T> a() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t0.c.d
    public float b() {
        return this.a.get(0).e();
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean c(float f) {
        com.airbnb.lottie.z0.a<T> aVar = this.c;
        com.airbnb.lottie.z0.a<T> aVar2 = this.b;
        if (aVar == aVar2 && this.d == f) {
            return true;
        }
        this.c = aVar2;
        this.d = f;
        return false;
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean d(float f) {
        if (this.b.a(f)) {
            return !this.b.h();
        }
        this.b = f(f);
        return true;
    }

    @Override // com.airbnb.lottie.t0.c.d
    public float e() {
        return this.a.get(r0.size() - 1).b();
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean isEmpty() {
        return false;
    }
}
