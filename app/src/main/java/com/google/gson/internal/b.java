package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* loaded from: classes.dex */
final class b implements GenericArrayType, Serializable {
    private final Type c;

    public b(Type type) {
        Objects.requireNonNull(type);
        this.c = e.b(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && e.f(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.c;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return e.t(this.c) + "[]";
    }
}
