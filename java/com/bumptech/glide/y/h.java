package com.bumptech.glide.y;

import com.bumptech.glide.load.u;

/* loaded from: classes.dex */
final class h<T> {
    private final Class<T> a;
    final u<T> b;

    h(Class<T> cls, u<T> uVar) {
        this.a = cls;
        this.b = uVar;
    }

    boolean a(Class<?> cls) {
        return this.a.isAssignableFrom(cls);
    }
}
