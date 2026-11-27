package com.bumptech.glide.load.z.k;

/* loaded from: classes.dex */
final class f<Z, R> {
    private final Class<Z> a;
    private final Class<R> b;
    final e<Z, R> c;

    f(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.a = cls;
        this.b = cls2;
        this.c = eVar;
    }

    public boolean a(Class<?> cls, Class<?> cls2) {
        return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
    }
}
