package com.bumptech.glide.y;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    private final List<a<?>> a = new ArrayList();

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.load.d<T> dVar) {
        this.a.add(new a<>(cls, dVar));
    }

    public synchronized <T> com.bumptech.glide.load.d<T> b(Class<T> cls) {
        for (a<?> aVar : this.a) {
            if (aVar.a(cls)) {
                return (com.bumptech.glide.load.d<T>) aVar.b;
            }
        }
        return null;
    }
}
