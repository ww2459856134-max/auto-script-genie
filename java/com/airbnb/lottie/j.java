package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class j implements Callable<k0<e>> {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ Context b;
    final /* synthetic */ int c;

    j(WeakReference weakReference, Context context, int i2) {
        this.a = weakReference;
        this.b = context;
        this.c = i2;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k0<e> call() {
        Context context = (Context) this.a.get();
        if (context == null) {
            context = this.b;
        }
        return m.n(context, this.c);
    }
}
