package com.airbnb.lottie.v0.k;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.z0.a<V>> a;

    n(List<com.airbnb.lottie.z0.a<V>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.v0.k.m
    public List<com.airbnb.lottie.z0.a<V>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v0.k.m
    public boolean c() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
