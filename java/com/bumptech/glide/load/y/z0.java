package com.bumptech.glide.load.y;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class z0 {
    private static final y0 e = new y0();
    private static final p0<Object, Object> f = new w0();
    private final List<x0<?, ?>> a;
    private final y0 b;
    private final Set<x0<?, ?>> c;
    private final h.e.i.e<List<Throwable>> d;

    public z0(h.e.i.e<List<Throwable>> eVar) {
        this(eVar, e);
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, q0<? extends Model, ? extends Data> q0Var, boolean z) {
        x0<?, ?> x0Var = new x0<>(cls, cls2, q0Var);
        List<x0<?, ?>> list = this.a;
        list.add(z ? list.size() : 0, x0Var);
    }

    private <Model, Data> p0<Model, Data> c(x0<?, ?> x0Var) {
        Object objB = x0Var.c.b(this);
        com.bumptech.glide.b0.n.d(objB);
        return (p0) objB;
    }

    private static <Model, Data> p0<Model, Data> f() {
        return (p0<Model, Data>) f;
    }

    synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, q0<? extends Model, ? extends Data> q0Var) {
        a(cls, cls2, q0Var, true);
    }

    public synchronized <Model, Data> p0<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (x0<?, ?> x0Var : this.a) {
                if (this.c.contains(x0Var)) {
                    z = true;
                } else if (x0Var.b(cls, cls2)) {
                    this.c.add(x0Var);
                    arrayList.add(c(x0Var));
                    this.c.remove(x0Var);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (p0) arrayList.get(0);
            }
            if (!z) {
                throw new com.bumptech.glide.l((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    synchronized <Model> List<p0<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (x0<?, ?> x0Var : this.a) {
                if (!this.c.contains(x0Var) && x0Var.a(cls)) {
                    this.c.add(x0Var);
                    arrayList.add(c(x0Var));
                    this.c.remove(x0Var);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (x0<?, ?> x0Var : this.a) {
            if (!arrayList.contains(x0Var.b) && x0Var.a(cls)) {
                arrayList.add(x0Var.b);
            }
        }
        return arrayList;
    }

    z0(h.e.i.e<List<Throwable>> eVar, y0 y0Var) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = eVar;
        this.b = y0Var;
    }
}
