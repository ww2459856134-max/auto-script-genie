package com.airbnb.lottie.t0.c;

import java.util.List;

/* loaded from: classes.dex */
final class f<T> implements d<T> {
    private final com.airbnb.lottie.z0.a<T> a;
    private float b = -1.0f;

    f(List<? extends com.airbnb.lottie.z0.a<T>> list) {
        this.a = list.get(0);
    }

    @Override // com.airbnb.lottie.t0.c.d
    public com.airbnb.lottie.z0.a<T> a() {
        return this.a;
    }

    @Override // com.airbnb.lottie.t0.c.d
    public float b() {
        return this.a.e();
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean c(float f) {
        if (this.b == f) {
            return true;
        }
        this.b = f;
        return false;
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean d(float f) {
        return !this.a.h();
    }

    @Override // com.airbnb.lottie.t0.c.d
    public float e() {
        return this.a.b();
    }

    @Override // com.airbnb.lottie.t0.c.d
    public boolean isEmpty() {
        return false;
    }
}
