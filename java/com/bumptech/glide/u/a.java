package com.bumptech.glide.u;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class a implements Callable<Void> {
    final /* synthetic */ f a;

    a(f fVar) {
        this.a = fVar;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        synchronized (this.a) {
            if (this.a.f680k == null) {
                return null;
            }
            this.a.L();
            if (this.a.B()) {
                this.a.I();
                this.a.A = 0;
            }
            return null;
        }
    }
}
