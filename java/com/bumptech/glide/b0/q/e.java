package com.bumptech.glide.b0.q;

import android.util.Log;

/* loaded from: classes.dex */
final class e<T> implements h.e.i.e<T> {
    private final d<T> a;
    private final g<T> b;
    private final h.e.i.e<T> c;

    e(h.e.i.e<T> eVar, d<T> dVar, g<T> gVar) {
        this.c = eVar;
        this.a = dVar;
        this.b = gVar;
    }

    @Override // h.e.i.e
    public T a() {
        T tA = this.c.a();
        if (tA == null) {
            tA = this.a.a();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + tA.getClass());
            }
        }
        if (tA instanceof f) {
            tA.e().b(false);
        }
        return (T) tA;
    }

    @Override // h.e.i.e
    public boolean b(T t) {
        if (t instanceof f) {
            ((f) t).e().b(true);
        }
        this.b.a(t);
        return this.c.b(t);
    }
}
