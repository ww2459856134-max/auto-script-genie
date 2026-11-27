package com.google.gson.internal.z0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class c extends b {
    private c() {
        super();
    }

    @Override // com.google.gson.internal.z0.b
    public Method a(Class<?> cls, Field field) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.z0.b
    <T> Constructor<T> b(Class<T> cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.z0.b
    String[] c(Class<?> cls) {
        throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
    }

    @Override // com.google.gson.internal.z0.b
    boolean d(Class<?> cls) {
        return false;
    }
}
