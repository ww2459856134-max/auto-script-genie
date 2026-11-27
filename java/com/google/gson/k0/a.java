package com.google.gson.k0;

import com.google.gson.internal.e;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Objects;

/* loaded from: classes.dex */
public class a<T> {
    private final Class<? super T> a;
    private final Type b;
    private final int c;

    protected a() {
        Type typeF = f();
        this.b = typeF;
        this.a = (Class<? super T>) e.k(typeF);
        this.c = typeF.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    public static a<?> c(Type type, Type... typeArr) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArr);
        if (!(type instanceof Class)) {
            throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
        }
        Class cls = (Class) type;
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        int length = typeParameters.length;
        int length2 = typeArr.length;
        if (length2 != length) {
            throw new IllegalArgumentException(cls.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            Type type2 = typeArr[i2];
            Class<?> clsK = e.k(type2);
            TypeVariable<Class<T>> typeVariable = typeParameters[i2];
            for (Type type3 : typeVariable.getBounds()) {
                if (!e.k(type3).isAssignableFrom(clsK)) {
                    throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
                }
            }
        }
        return new a<>(e.n(null, type, typeArr));
    }

    private Type f() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                return e.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class<? super T> d() {
        return this.a;
    }

    public final Type e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && e.f(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return e.t(this.b);
    }

    private a(Type type) {
        Objects.requireNonNull(type);
        Type typeB = e.b(type);
        this.b = typeB;
        this.a = (Class<? super T>) e.k(typeB);
        this.c = typeB.hashCode();
    }
}
