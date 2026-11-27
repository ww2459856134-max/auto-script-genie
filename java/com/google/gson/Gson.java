package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.k0;
import com.google.gson.internal.t0;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class Gson {

    /* renamed from: k, reason: collision with root package name */
    static final String f724k = null;

    /* renamed from: l, reason: collision with root package name */
    static final k f725l = j.c;

    /* renamed from: m, reason: collision with root package name */
    static final h0 f726m = g0.c;

    /* renamed from: n, reason: collision with root package name */
    static final h0 f727n = g0.d;
    private final ThreadLocal<Map<com.google.gson.k0.a<?>, TypeAdapter<?>>> a;
    private final ConcurrentMap<com.google.gson.k0.a<?>, TypeAdapter<?>> b;
    private final com.google.gson.internal.z c;
    private final JsonAdapterAnnotationTypeAdapterFactory d;
    final List<i0> e;
    final boolean f;
    final boolean g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f728h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f729i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f730j;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> a = null;

        FutureTypeAdapter() {
        }

        private TypeAdapter<T> f() {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public T b(com.google.gson.l0.b bVar) throws IOException {
            return f().b(bVar);
        }

        @Override // com.google.gson.TypeAdapter
        public void d(com.google.gson.l0.d dVar, T t) throws IOException {
            f().d(dVar, t);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> e() {
            return f();
        }

        public void g(TypeAdapter<T> typeAdapter) {
            if (this.a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.a = typeAdapter;
        }
    }

    public Gson() {
        this(Excluder.f731i, f725l, Collections.emptyMap(), false, false, false, true, false, false, false, true, a0.c, f724k, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f726m, f727n, Collections.emptyList());
    }

    private static void a(Object obj, com.google.gson.l0.b bVar) {
        if (obj != null) {
            try {
                if (bVar.L() == com.google.gson.l0.c.END_DOCUMENT) {
                } else {
                    throw new x("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.l0.e e) {
                throw new x(e);
            } catch (IOException e2) {
                throw new q(e2);
            }
        }
    }

    private static TypeAdapter<AtomicLong> b(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicLong b(com.google.gson.l0.b bVar) throws IOException {
                return new AtomicLong(((Number) typeAdapter.b(bVar)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.l0.d dVar, AtomicLong atomicLong) throws IOException {
                typeAdapter.d(dVar, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private static TypeAdapter<AtomicLongArray> c(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray b(com.google.gson.l0.b bVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.s()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.b(bVar)).longValue()));
                }
                bVar.j();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.l0.d dVar, AtomicLongArray atomicLongArray) throws IOException {
                dVar.d();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    typeAdapter.d(dVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                dVar.j();
            }
        }.a();
    }

    static void d(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> e(boolean z) {
        return z ? TypeAdapters.v : new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Double b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Double.valueOf(bVar.z());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.l0.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                    return;
                }
                double dDoubleValue = number.doubleValue();
                Gson.d(dDoubleValue);
                dVar.J(dDoubleValue);
            }
        };
    }

    private TypeAdapter<Number> f(boolean z) {
        return z ? TypeAdapters.u : new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Float b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Float.valueOf((float) bVar.z());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.l0.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                    return;
                }
                float fFloatValue = number.floatValue();
                Gson.d(fFloatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(fFloatValue);
                }
                dVar.M(number);
            }
        };
    }

    private static TypeAdapter<Number> o(a0 a0Var) {
        return a0Var == a0.c ? TypeAdapters.t : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Long.valueOf(bVar.D());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.l0.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.N(number.toString());
                }
            }
        };
    }

    public <T> T g(com.google.gson.l0.b bVar, com.google.gson.k0.a<T> aVar) throws x, q {
        boolean zU = bVar.u();
        boolean z = true;
        bVar.Q(true);
        try {
            try {
                try {
                    bVar.L();
                    z = false;
                    T tB = l(aVar).b(bVar);
                    bVar.Q(zU);
                    return tB;
                } catch (EOFException e) {
                    if (!z) {
                        throw new x(e);
                    }
                    bVar.Q(zU);
                    return null;
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
                }
            } catch (IOException e3) {
                throw new x(e3);
            } catch (IllegalStateException e4) {
                throw new x(e4);
            }
        } catch (Throwable th) {
            bVar.Q(zU);
            throw th;
        }
    }

    public <T> T h(Reader reader, com.google.gson.k0.a<T> aVar) throws x, q {
        com.google.gson.l0.b bVarP = p(reader);
        T t = (T) g(bVarP, aVar);
        a(t, bVarP);
        return t;
    }

    public <T> T i(String str, com.google.gson.k0.a<T> aVar) throws x {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), aVar);
    }

    public <T> T j(String str, Class<T> cls) throws x {
        return (T) k0.b(cls).cast(i(str, com.google.gson.k0.a.a(cls)));
    }

    public <T> T k(String str, Type type) throws x {
        return (T) i(str, com.google.gson.k0.a.b(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r3.g(r2);
        r0.put(r7, r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> TypeAdapter<T> l(com.google.gson.k0.a<T> aVar) {
        Objects.requireNonNull(aVar, "type must not be null");
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.b.get(aVar);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<? extends com.google.gson.k0.a<?>, ? extends TypeAdapter<?>> map = this.a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z = true;
        } else {
            TypeAdapter<T> typeAdapter2 = (TypeAdapter) map.get(aVar);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
        }
        TypeAdapter<T> typeAdapterA = null;
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(aVar, futureTypeAdapter);
            Iterator<i0> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapterA = it.next().a(this, aVar);
                if (typeAdapterA != null) {
                    break;
                }
            }
            if (typeAdapterA != null) {
                if (z) {
                    this.b.putAll(map);
                }
                return typeAdapterA;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } finally {
            if (z) {
                this.a.remove();
            }
        }
    }

    public <T> TypeAdapter<T> m(Class<T> cls) {
        return l(com.google.gson.k0.a.a(cls));
    }

    public <T> TypeAdapter<T> n(i0 i0Var, com.google.gson.k0.a<T> aVar) {
        if (!this.e.contains(i0Var)) {
            i0Var = this.d;
        }
        boolean z = false;
        for (i0 i0Var2 : this.e) {
            if (z) {
                TypeAdapter<T> typeAdapterA = i0Var2.a(this, aVar);
                if (typeAdapterA != null) {
                    return typeAdapterA;
                }
            } else if (i0Var2 == i0Var) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.l0.b p(Reader reader) {
        com.google.gson.l0.b bVar = new com.google.gson.l0.b(reader);
        bVar.Q(this.f730j);
        return bVar;
    }

    public com.google.gson.l0.d q(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        com.google.gson.l0.d dVar = new com.google.gson.l0.d(writer);
        if (this.f729i) {
            dVar.F("  ");
        }
        dVar.D(this.f728h);
        dVar.G(this.f730j);
        dVar.H(this.f);
        return dVar;
    }

    public String r(p pVar) throws q {
        StringWriter stringWriter = new StringWriter();
        v(pVar, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        return obj == null ? r(r.a) : t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) throws q {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f + ",factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }

    public void u(p pVar, com.google.gson.l0.d dVar) throws q {
        boolean zP = dVar.p();
        dVar.G(true);
        boolean zO = dVar.o();
        dVar.D(this.f728h);
        boolean zN = dVar.n();
        dVar.H(this.f);
        try {
            try {
                t0.b(pVar, dVar);
            } catch (IOException e) {
                throw new q(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
            }
        } finally {
            dVar.G(zP);
            dVar.D(zO);
            dVar.H(zN);
        }
    }

    public void v(p pVar, Appendable appendable) throws q {
        try {
            u(pVar, q(t0.c(appendable)));
        } catch (IOException e) {
            throw new q(e);
        }
    }

    public void w(Object obj, Type type, com.google.gson.l0.d dVar) throws q {
        TypeAdapter typeAdapterL = l(com.google.gson.k0.a.b(type));
        boolean zP = dVar.p();
        dVar.G(true);
        boolean zO = dVar.o();
        dVar.D(this.f728h);
        boolean zN = dVar.n();
        dVar.H(this.f);
        try {
            try {
                typeAdapterL.d(dVar, obj);
            } catch (IOException e) {
                throw new q(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e2.getMessage(), e2);
            }
        } finally {
            dVar.G(zP);
            dVar.D(zO);
            dVar.H(zN);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) throws q {
        try {
            w(obj, type, q(t0.c(appendable)));
        } catch (IOException e) {
            throw new q(e);
        }
    }

    Gson(Excluder excluder, k kVar, Map<Type, l<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, a0 a0Var, String str, int i2, int i3, List<i0> list, List<i0> list2, List<i0> list3, h0 h0Var, h0 h0Var2, List<b0> list4) {
        this.a = new ThreadLocal<>();
        this.b = new ConcurrentHashMap();
        com.google.gson.internal.z zVar = new com.google.gson.internal.z(map, z8, list4);
        this.c = zVar;
        this.f = z;
        this.g = z3;
        this.f728h = z4;
        this.f729i = z5;
        this.f730j = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.e(h0Var));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.f745m);
        arrayList.add(TypeAdapters.g);
        arrayList.add(TypeAdapters.f741i);
        arrayList.add(TypeAdapters.f743k);
        TypeAdapter<Number> typeAdapterO = o(a0Var);
        arrayList.add(TypeAdapters.b(Long.TYPE, Long.class, typeAdapterO));
        arrayList.add(TypeAdapters.b(Double.TYPE, Double.class, e(z7)));
        arrayList.add(TypeAdapters.b(Float.TYPE, Float.class, f(z7)));
        arrayList.add(NumberTypeAdapter.e(h0Var2));
        arrayList.add(TypeAdapters.f747o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(TypeAdapters.a(AtomicLong.class, b(typeAdapterO)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, c(typeAdapterO)));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.z));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.a(com.google.gson.internal.c0.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.d);
        arrayList.add(DateTypeAdapter.b);
        arrayList.add(TypeAdapters.S);
        if (com.google.gson.internal.sql.c.a) {
            arrayList.add(com.google.gson.internal.sql.c.c);
            arrayList.add(com.google.gson.internal.sql.c.b);
            arrayList.add(com.google.gson.internal.sql.c.d);
        }
        arrayList.add(ArrayTypeAdapter.c);
        arrayList.add(TypeAdapters.b);
        arrayList.add(new CollectionTypeAdapterFactory(zVar));
        arrayList.add(new MapTypeAdapterFactory(zVar, z2));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(zVar);
        this.d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(zVar, kVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.e = Collections.unmodifiableList(arrayList);
    }
}
