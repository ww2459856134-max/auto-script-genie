package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
final class c implements ParameterizedType, Serializable {
    private final Type c;
    private final Type d;
    private final Type[] e;

    public c(Type type, Type type2, Type... typeArr) {
        Objects.requireNonNull(type2);
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z = true;
            boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z2) {
                z = false;
            }
            a.a(z);
        }
        this.c = type == null ? null : e.b(type);
        this.d = e.b(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.e = typeArr2;
        int length = typeArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            Objects.requireNonNull(this.e[i2]);
            e.c(this.e[i2]);
            Type[] typeArr3 = this.e;
            typeArr3[i2] = e.b(typeArr3[i2]);
        }
    }

    private static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && e.f(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return (Type[]) this.e.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.d;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.e) ^ this.d.hashCode()) ^ a(this.c);
    }

    public String toString() {
        int length = this.e.length;
        if (length == 0) {
            return e.t(this.d);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(e.t(this.d));
        sb.append("<");
        sb.append(e.t(this.e[0]));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(", ");
            sb.append(e.t(this.e[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
