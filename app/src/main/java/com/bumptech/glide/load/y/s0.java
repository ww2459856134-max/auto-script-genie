package com.bumptech.glide.load.y;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class s0 {
    private final Map<Class<?>, r0<?>> a = new HashMap();

    s0() {
    }

    public void a() {
        this.a.clear();
    }

    public <Model> List<p0<Model, ?>> b(Class<Model> cls) {
        r0<?> r0Var = this.a.get(cls);
        if (r0Var == null) {
            return null;
        }
        return (List<p0<Model, ?>>) r0Var.a;
    }

    public <Model> void c(Class<Model> cls, List<p0<Model, ?>> list) {
        if (this.a.put(cls, new r0<>(list)) == null) {
            return;
        }
        throw new IllegalStateException("Already cached loaders for model: " + cls);
    }
}
