package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.t0;
import com.google.gson.l0.d;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.t;
import com.google.gson.v;
import com.google.gson.w;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final w<T> a;
    private final o<T> b;
    final Gson c;
    private final com.google.gson.k0.a<T> d;
    private final i0 e;
    private final TreeTypeAdapter<T>.b f;
    private final boolean g;

    /* renamed from: h, reason: collision with root package name */
    private volatile TypeAdapter<T> f739h;

    private static final class SingleTypeFactory implements i0 {
        private final com.google.gson.k0.a<?> c;
        private final boolean d;
        private final Class<?> e;
        private final w<?> f;
        private final o<?> g;

        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            com.google.gson.k0.a<?> aVar2 = this.c;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.d && this.c.e() == aVar.d()) : this.e.isAssignableFrom(aVar.d())) {
                return new TreeTypeAdapter(this.f, this.g, gson, aVar, this);
            }
            return null;
        }
    }

    private final class b implements v, n {
        private b(TreeTypeAdapter treeTypeAdapter) {
        }
    }

    public TreeTypeAdapter(w<T> wVar, o<T> oVar, Gson gson, com.google.gson.k0.a<T> aVar, i0 i0Var, boolean z) {
        this.f = new b();
        this.a = wVar;
        this.b = oVar;
        this.c = gson;
        this.d = aVar;
        this.e = i0Var;
        this.g = z;
    }

    private TypeAdapter<T> f() {
        TypeAdapter<T> typeAdapter = this.f739h;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> typeAdapterN = this.c.n(this.e, this.d);
        this.f739h = typeAdapterN;
        return typeAdapterN;
    }

    @Override // com.google.gson.TypeAdapter
    public T b(com.google.gson.l0.b bVar) throws t, IOException {
        if (this.b == null) {
            return f().b(bVar);
        }
        p pVarA = t0.a(bVar);
        if (this.g && pVarA.h()) {
            return null;
        }
        return this.b.a(pVarA, this.d.e(), this.f);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(d dVar, T t) throws IOException {
        w<T> wVar = this.a;
        if (wVar == null) {
            f().d(dVar, t);
        } else if (this.g && t == null) {
            dVar.w();
        } else {
            t0.b(wVar.a(t, this.d.e(), this.f), dVar);
        }
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> e() {
        return this.a != null ? this : f();
    }

    public TreeTypeAdapter(w<T> wVar, o<T> oVar, Gson gson, com.google.gson.k0.a<T> aVar, i0 i0Var) {
        this(wVar, oVar, gson, aVar, i0Var, true);
    }
}
