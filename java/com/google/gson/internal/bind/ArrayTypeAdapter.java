package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.e;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final i0 c = new i0() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            Type typeE = aVar.e();
            if (!(typeE instanceof GenericArrayType) && (!(typeE instanceof Class) || !((Class) typeE).isArray())) {
                return null;
            }
            Type typeG = e.g(typeE);
            return new ArrayTypeAdapter(gson, gson.l(com.google.gson.k0.a.b(typeG)), e.k(typeG));
        }
    };
    private final Class<E> a;
    private final TypeAdapter<E> b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.a = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object b(com.google.gson.l0.b bVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (bVar.L() == c.NULL) {
            bVar.H();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        bVar.a();
        while (bVar.s()) {
            arrayList.add(this.b.b(bVar));
        }
        bVar.j();
        int size = arrayList.size();
        if (!this.a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void d(d dVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            dVar.w();
            return;
        }
        dVar.d();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.b.d(dVar, Array.get(obj, i2));
        }
        dVar.j();
    }
}
