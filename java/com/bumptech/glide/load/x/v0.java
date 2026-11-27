package com.bumptech.glide.load.x;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class v0 {
    private final Map<com.bumptech.glide.load.n, j0<?>> a = new HashMap();
    private final Map<com.bumptech.glide.load.n, j0<?>> b = new HashMap();

    v0() {
    }

    private Map<com.bumptech.glide.load.n, j0<?>> b(boolean z) {
        return z ? this.b : this.a;
    }

    j0<?> a(com.bumptech.glide.load.n nVar, boolean z) {
        return b(z).get(nVar);
    }

    void c(com.bumptech.glide.load.n nVar, j0<?> j0Var) {
        b(j0Var.p()).put(nVar, j0Var);
    }

    void d(com.bumptech.glide.load.n nVar, j0<?> j0Var) {
        Map<com.bumptech.glide.load.n, j0<?>> mapB = b(j0Var.p());
        if (j0Var.equals(mapB.get(nVar))) {
            mapB.remove(nVar);
        }
    }
}
