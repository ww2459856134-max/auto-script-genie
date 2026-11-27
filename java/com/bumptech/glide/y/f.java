package com.bumptech.glide.y;

import com.bumptech.glide.load.t;

/* loaded from: classes.dex */
class f<T, R> {
    private final Class<T> a;
    final Class<R> b;
    final t<T, R> c;

    public f(Class<T> cls, Class<R> cls2, t<T, R> tVar) {
        this.a = cls;
        this.b = cls2;
        this.c = tVar;
    }

    public boolean a(Class<?> cls, Class<?> cls2) {
        return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
    }
}
