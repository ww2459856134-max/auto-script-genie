package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.z;

/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements i0 {
    private final z c;

    public JsonAdapterAnnotationTypeAdapterFactory(z zVar) {
        this.c = zVar;
    }

    @Override // com.google.gson.i0
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
        com.google.gson.j0.b bVar = (com.google.gson.j0.b) aVar.d().getAnnotation(com.google.gson.j0.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) b(this.c, gson, aVar, bVar);
    }

    TypeAdapter<?> b(z zVar, Gson gson, com.google.gson.k0.a<?> aVar, com.google.gson.j0.b bVar) {
        TypeAdapter<?> typeAdapterA;
        Object objA = zVar.b(com.google.gson.k0.a.a(bVar.value())).a();
        boolean zNullSafe = bVar.nullSafe();
        if (objA instanceof TypeAdapter) {
            typeAdapterA = (TypeAdapter) objA;
        } else {
            if (!(objA instanceof i0)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            typeAdapterA = ((i0) objA).a(gson, aVar);
        }
        return (typeAdapterA == null || !zNullSafe) ? typeAdapterA : typeAdapterA.a();
    }
}
