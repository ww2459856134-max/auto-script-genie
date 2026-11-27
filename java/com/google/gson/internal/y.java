package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class y<T> implements i0<T> {
    final /* synthetic */ Constructor a;

    y(Constructor constructor) {
        this.a = constructor;
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        try {
            return (T) this.a.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            com.google.gson.internal.z0.e.e(e);
            throw null;
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.z0.e.c(this.a) + "' with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.z0.e.c(this.a) + "' with no args", e3.getCause());
        }
    }
}
