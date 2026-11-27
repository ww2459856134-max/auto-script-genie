package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class k0<V> {
    private final V a;
    private final Throwable b;

    public k0(V v) {
        this.a = v;
        this.b = null;
    }

    public Throwable a() {
        return this.b;
    }

    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        if (b() != null && b().equals(k0Var.b())) {
            return true;
        }
        if (a() == null || k0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public k0(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
