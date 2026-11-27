package com.bumptech.glide.load.z;

import com.bumptech.glide.b0.n;
import com.bumptech.glide.load.x.z0;

/* loaded from: classes.dex */
public abstract class d<T> implements z0<T> {
    protected final T c;

    public d(T t) {
        n.d(t);
        this.c = t;
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<T> b() {
        return (Class<T>) this.c.getClass();
    }

    @Override // com.bumptech.glide.load.x.z0
    public final T get() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.x.z0
    public final int getSize() {
        return 1;
    }
}
