package com.google.gson.internal.z0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
abstract class b {
    private b() {
    }

    public abstract Method a(Class<?> cls, Field field);

    abstract <T> Constructor<T> b(Class<T> cls);

    abstract String[] c(Class<?> cls);

    abstract boolean d(Class<?> cls);
}
