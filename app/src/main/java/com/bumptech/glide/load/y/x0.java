package com.bumptech.glide.load.y;

/* loaded from: classes.dex */
class x0<Model, Data> {
    private final Class<Model> a;
    final Class<Data> b;
    final q0<? extends Model, ? extends Data> c;

    public x0(Class<Model> cls, Class<Data> cls2, q0<? extends Model, ? extends Data> q0Var) {
        this.a = cls;
        this.b = cls2;
        this.c = q0Var;
    }

    public boolean a(Class<?> cls) {
        return this.a.isAssignableFrom(cls);
    }

    public boolean b(Class<?> cls, Class<?> cls2) {
        return a(cls) && this.b.isAssignableFrom(cls2);
    }
}
