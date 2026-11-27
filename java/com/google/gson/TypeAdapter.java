package com.google.gson;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class TypeAdapter<T> {
    public final TypeAdapter<T> a() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public T b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return (T) TypeAdapter.this.b(bVar);
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void d(com.google.gson.l0.d dVar, T t) throws IOException {
                if (t == null) {
                    dVar.w();
                } else {
                    TypeAdapter.this.d(dVar, t);
                }
            }
        };
    }

    public abstract T b(com.google.gson.l0.b bVar) throws IOException;

    public final p c(T t) {
        try {
            com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
            d(bVar, t);
            return bVar.Q();
        } catch (IOException e) {
            throw new q(e);
        }
    }

    public abstract void d(com.google.gson.l0.d dVar, T t) throws IOException;
}
