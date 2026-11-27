package com.google.gson.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class u<T> implements i0<T> {
    final /* synthetic */ Type a;

    u(Type type) {
        this.a = type;
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        Type type = this.a;
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.q("Invalid EnumSet type: " + this.a.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) EnumSet.noneOf((Class) type2);
        }
        throw new com.google.gson.q("Invalid EnumSet type: " + this.a.toString());
    }
}
