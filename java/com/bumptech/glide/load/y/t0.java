package com.bumptech.glide.load.y;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class t0 {
    private final z0 a;
    private final s0 b;

    public t0(h.e.i.e<List<Throwable>> eVar) {
        this(new z0(eVar));
    }

    private static <A> Class<A> b(A a) {
        return (Class<A>) a.getClass();
    }

    private synchronized <A> List<p0<A, ?>> e(Class<A> cls) {
        List<p0<A, ?>> listB;
        listB = this.b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, listB);
        }
        return listB;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, q0<? extends Model, ? extends Data> q0Var) {
        this.a.b(cls, cls2, q0Var);
        this.b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.a.g(cls);
    }

    public <A> List<p0<A, ?>> d(A a) {
        List<p0<A, ?>> listE = e(b(a));
        if (listE.isEmpty()) {
            throw new com.bumptech.glide.l(a);
        }
        int size = listE.size();
        List<p0<A, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            p0<A, ?> p0Var = listE.get(i2);
            if (p0Var.b(a)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i2);
                    z = false;
                }
                listEmptyList.add(p0Var);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new com.bumptech.glide.l(a, listE);
        }
        return listEmptyList;
    }

    private t0(z0 z0Var) {
        this.b = new s0();
        this.a = z0Var;
    }
}
