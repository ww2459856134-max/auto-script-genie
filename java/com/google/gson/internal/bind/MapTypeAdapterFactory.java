package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.b0;
import com.google.gson.internal.e;
import com.google.gson.internal.t0;
import com.google.gson.internal.z;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import com.google.gson.p;
import com.google.gson.u;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements i0 {
    private final z c;
    final boolean d;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final TypeAdapter<K> a;
        private final TypeAdapter<V> b;
        private final com.google.gson.internal.i0<? extends Map<K, V>> c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, com.google.gson.internal.i0<? extends Map<K, V>> i0Var) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.c = i0Var;
        }

        private String e(p pVar) {
            if (!pVar.k()) {
                if (pVar.h()) {
                    return "null";
                }
                throw new AssertionError();
            }
            u uVarE = pVar.e();
            if (uVarE.v()) {
                return String.valueOf(uVarE.p());
            }
            if (uVarE.t()) {
                return Boolean.toString(uVarE.l());
            }
            if (uVarE.w()) {
                return uVarE.r();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(com.google.gson.l0.b bVar) throws IOException {
            c cVarL = bVar.L();
            if (cVarL == c.NULL) {
                bVar.H();
                return null;
            }
            Map<K, V> mapA = this.c.a();
            if (cVarL == c.BEGIN_ARRAY) {
                bVar.a();
                while (bVar.s()) {
                    bVar.a();
                    K kB = this.a.b(bVar);
                    if (mapA.put(kB, this.b.b(bVar)) != null) {
                        throw new x("duplicate key: " + kB);
                    }
                    bVar.j();
                }
                bVar.j();
            } else {
                bVar.c();
                while (bVar.s()) {
                    b0.a.a(bVar);
                    K kB2 = this.a.b(bVar);
                    if (mapA.put(kB2, this.b.b(bVar)) != null) {
                        throw new x("duplicate key: " + kB2);
                    }
                }
                bVar.m();
            }
            return mapA;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.w();
                return;
            }
            if (!MapTypeAdapterFactory.this.d) {
                dVar.f();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    dVar.s(String.valueOf(entry.getKey()));
                    this.b.d(dVar, entry.getValue());
                }
                dVar.m();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                p pVarC = this.a.c(entry2.getKey());
                arrayList.add(pVarC);
                arrayList2.add(entry2.getValue());
                z |= pVarC.g() || pVarC.j();
            }
            if (!z) {
                dVar.f();
                int size = arrayList.size();
                while (i2 < size) {
                    dVar.s(e((p) arrayList.get(i2)));
                    this.b.d(dVar, arrayList2.get(i2));
                    i2++;
                }
                dVar.m();
                return;
            }
            dVar.d();
            int size2 = arrayList.size();
            while (i2 < size2) {
                dVar.d();
                t0.b((p) arrayList.get(i2), dVar);
                this.b.d(dVar, arrayList2.get(i2));
                dVar.j();
                i2++;
            }
            dVar.j();
        }
    }

    public MapTypeAdapterFactory(z zVar, boolean z) {
        this.c = zVar;
        this.d = z;
    }

    private TypeAdapter<?> b(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f : gson.l(com.google.gson.k0.a.b(type));
    }

    @Override // com.google.gson.i0
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type typeE = aVar.e();
        Class<? super T> clsD = aVar.d();
        if (!Map.class.isAssignableFrom(clsD)) {
            return null;
        }
        Type[] typeArrJ = e.j(typeE, clsD);
        return new Adapter(gson, typeArrJ[0], b(gson, typeArrJ[0]), typeArrJ[1], gson.l(com.google.gson.k0.a.b(typeArrJ[1])), this.c.b(aVar));
    }
}
