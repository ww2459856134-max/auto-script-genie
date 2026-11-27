package com.airbnb.lottie;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class l implements Callable<k0<e>> {
    final /* synthetic */ e a;

    l(e eVar) {
        this.a = eVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k0<e> call() {
        return new k0<>(this.a);
    }
}
