package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class h implements Callable<k0<e>> {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    h(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k0<e> call() {
        return com.airbnb.lottie.w0.c.e(this.a, this.b, this.c);
    }
}
