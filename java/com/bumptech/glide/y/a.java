package com.bumptech.glide.y;

/* loaded from: classes.dex */
final class a<T> {
    private final Class<T> a;
    final com.bumptech.glide.load.d<T> b;

    a(Class<T> cls, com.bumptech.glide.load.d<T> dVar) {
        this.a = cls;
        this.b = dVar;
    }

    boolean a(Class<?> cls) {
        return this.a.isAssignableFrom(cls);
    }
}
