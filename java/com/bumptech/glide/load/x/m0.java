package com.bumptech.glide.load.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class m0 implements Iterable<l0> {
    private final List<l0> c;

    m0() {
        this(new ArrayList(2));
    }

    private static l0 g(com.bumptech.glide.z.h hVar) {
        return new l0(hVar, com.bumptech.glide.b0.i.a());
    }

    void a(com.bumptech.glide.z.h hVar, Executor executor) {
        this.c.add(new l0(hVar, executor));
    }

    boolean b(com.bumptech.glide.z.h hVar) {
        return this.c.contains(g(hVar));
    }

    void clear() {
        this.c.clear();
    }

    m0 e() {
        return new m0(new ArrayList(this.c));
    }

    void h(com.bumptech.glide.z.h hVar) {
        this.c.remove(g(hVar));
    }

    boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<l0> iterator() {
        return this.c.iterator();
    }

    int size() {
        return this.c.size();
    }

    m0(List<l0> list) {
        this.c = list;
    }
}
