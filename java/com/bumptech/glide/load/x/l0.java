package com.bumptech.glide.load.x;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class l0 {
    final com.bumptech.glide.z.h a;
    final Executor b;

    l0(com.bumptech.glide.z.h hVar, Executor executor) {
        this.a = hVar;
        this.b = executor;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l0) {
            return this.a.equals(((l0) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
