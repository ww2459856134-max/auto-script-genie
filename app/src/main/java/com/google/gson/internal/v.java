package com.google.gson.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
class v<T> implements i0<T> {
    final /* synthetic */ Type a;

    v(Type type) {
        this.a = type;
    }

    @Override // com.google.gson.internal.i0
    public T a() {
        Type type = this.a;
        if (!(type instanceof ParameterizedType)) {
            throw new com.google.gson.q("Invalid EnumMap type: " + this.a.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) new EnumMap((Class) type2);
        }
        throw new com.google.gson.q("Invalid EnumMap type: " + this.a.toString());
    }
}
