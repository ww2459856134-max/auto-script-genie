package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.l0.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson a;
    private final TypeAdapter<T> b;
    private final Type c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.a = gson;
        this.b = typeAdapter;
        this.c = type;
    }

    private static Type e(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    private static boolean f(TypeAdapter<?> typeAdapter) {
        TypeAdapter<?> typeAdapterE;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (typeAdapterE = ((SerializationDelegatingTypeAdapter) typeAdapter).e()) != typeAdapter) {
            typeAdapter = typeAdapterE;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T b(com.google.gson.l0.b bVar) throws IOException {
        return this.b.b(bVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(d dVar, T t) throws IOException {
        TypeAdapter<T> typeAdapterL = this.b;
        Type typeE = e(this.c, t);
        if (typeE != this.c) {
            typeAdapterL = this.a.l(com.google.gson.k0.a.b(typeE));
            if ((typeAdapterL instanceof ReflectiveTypeAdapterFactory.Adapter) && !f(this.b)) {
                typeAdapterL = this.b;
            }
        }
        typeAdapterL.d(dVar, t);
    }
}
