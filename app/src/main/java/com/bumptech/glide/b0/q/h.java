package com.bumptech.glide.b0.q;

import java.util.List;

/* loaded from: classes.dex */
public abstract class h {
    private static final g<Object> a = new a();

    private static <T extends f> h.e.i.e<T> a(h.e.i.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    private static <T> h.e.i.e<T> b(h.e.i.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) a;
    }

    public static <T extends f> h.e.i.e<T> d(int i2, d<T> dVar) {
        return a(new h.e.i.g(i2), dVar);
    }

    public static <T> h.e.i.e<List<T>> e() {
        return f(20);
    }

    public static <T> h.e.i.e<List<T>> f(int i2) {
        return b(new h.e.i.g(i2), new b(), new c());
    }
}
