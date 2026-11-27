package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.e;
import com.google.gson.internal.z;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements i0 {
    private final z c;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> a;
        private final com.google.gson.internal.i0<? extends Collection<E>> b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, com.google.gson.internal.i0<? extends Collection<E>> i0Var) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = i0Var;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(com.google.gson.l0.b bVar) throws IOException {
            if (bVar.L() == c.NULL) {
                bVar.H();
                return null;
            }
            Collection<E> collectionA = this.b.a();
            bVar.a();
            while (bVar.s()) {
                collectionA.add(this.a.b(bVar));
            }
            bVar.j();
            return collectionA;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.w();
                return;
            }
            dVar.d();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.a.d(dVar, it.next());
            }
            dVar.j();
        }
    }

    public CollectionTypeAdapterFactory(z zVar) {
        this.c = zVar;
    }

    @Override // com.google.gson.i0
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
        Type typeE = aVar.e();
        Class<? super T> clsD = aVar.d();
        if (!Collection.class.isAssignableFrom(clsD)) {
            return null;
        }
        Type typeH = e.h(typeE, clsD);
        return new Adapter(gson, typeH, gson.l(com.google.gson.k0.a.b(typeH)), this.c.b(aVar));
    }
}
