package com.bumptech.glide.y;

import com.bumptech.glide.b0.m;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class e {
    private final AtomicReference<m> a = new AtomicReference<>();
    private final h.d.b<m, List<Class<?>>> b = new h.d.b<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        m andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new m(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = this.b.get(andSet);
        }
        this.a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new m(cls, cls2, cls3), list);
        }
    }
}
