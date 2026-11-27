package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* loaded from: classes.dex */
final class d implements WildcardType, Serializable {
    private final Type c;
    private final Type d;

    public d(Type[] typeArr, Type[] typeArr2) {
        a.a(typeArr2.length <= 1);
        a.a(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            e.c(typeArr[0]);
            this.d = null;
            this.c = e.b(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        e.c(typeArr2[0]);
        a.a(typeArr[0] == Object.class);
        this.d = e.b(typeArr2[0]);
        this.c = Object.class;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && e.f(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.d;
        return type != null ? new Type[]{type} : e.a;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.c};
    }

    public int hashCode() {
        Type type = this.d;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.c.hashCode() + 31);
    }

    public String toString() {
        if (this.d != null) {
            return "? super " + e.t(this.d);
        }
        if (this.c == Object.class) {
            return "?";
        }
        return "? extends " + e.t(this.c);
    }
}
