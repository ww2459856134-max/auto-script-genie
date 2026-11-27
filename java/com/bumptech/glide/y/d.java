package com.bumptech.glide.y;

import com.bumptech.glide.b0.m;
import com.bumptech.glide.load.x.w;
import com.bumptech.glide.load.x.w0;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class d {
    private static final w0<?, ?, ?> c = new w0<>(Object.class, Object.class, Object.class, Collections.singletonList(new w(Object.class, Object.class, Object.class, Collections.emptyList(), new com.bumptech.glide.load.z.k.h(), null)), null);
    private final h.d.b<m, w0<?, ?, ?>> a = new h.d.b<>();
    private final AtomicReference<m> b = new AtomicReference<>();

    private m b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        m andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new m();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> w0<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        w0<Data, TResource, Transcode> w0Var;
        m mVarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            w0Var = (w0) this.a.get(mVarB);
        }
        this.b.set(mVarB);
        return w0Var;
    }

    public boolean c(w0<?, ?, ?> w0Var) {
        return c.equals(w0Var);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, w0<?, ?, ?> w0Var) {
        synchronized (this.a) {
            h.d.b<m, w0<?, ?, ?>> bVar = this.a;
            m mVar = new m(cls, cls2, cls3);
            if (w0Var == null) {
                w0Var = c;
            }
            bVar.put(mVar, w0Var);
        }
    }
}
