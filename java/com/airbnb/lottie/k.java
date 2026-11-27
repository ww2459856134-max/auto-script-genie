package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class k implements Callable<k0<e>> {
    final /* synthetic */ InputStream a;
    final /* synthetic */ String b;

    k(InputStream inputStream, String str) {
        this.a = inputStream;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k0<e> call() {
        return m.h(this.a, this.b);
    }
}
