package com.bumptech.glide.load.x;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class e extends WeakReference<r0<?>> {
    final com.bumptech.glide.load.n a;
    final boolean b;
    z0<?> c;

    e(com.bumptech.glide.load.n nVar, r0<?> r0Var, ReferenceQueue<? super r0<?>> referenceQueue, boolean z) {
        z0<?> z0Var;
        super(r0Var, referenceQueue);
        com.bumptech.glide.b0.n.d(nVar);
        this.a = nVar;
        if (r0Var.e() && z) {
            z0<?> z0VarD = r0Var.d();
            com.bumptech.glide.b0.n.d(z0VarD);
            z0Var = z0VarD;
        } else {
            z0Var = null;
        }
        this.c = z0Var;
        this.b = r0Var.e();
    }

    void a() {
        this.c = null;
        clear();
    }
}
