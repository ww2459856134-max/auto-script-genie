package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.b0;
import com.google.gson.i0;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.k0;
import com.google.gson.internal.p0;
import com.google.gson.internal.z;
import com.google.gson.internal.z0.e;
import com.google.gson.k;
import com.google.gson.l0.c;
import com.google.gson.l0.d;
import com.google.gson.q;
import com.google.gson.t;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements i0 {
    private final z c;
    private final k d;
    private final Excluder e;
    private final JsonAdapterAnnotationTypeAdapterFactory f;
    private final List<b0> g;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, b> a;

        Adapter(Map<String, b> map) {
            this.a = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T b(com.google.gson.l0.b bVar) throws IOException {
            if (bVar.L() == c.NULL) {
                bVar.H();
                return null;
            }
            A aE = e();
            try {
                bVar.c();
                while (bVar.s()) {
                    b bVar2 = this.a.get(bVar.F());
                    if (bVar2 == null || !bVar2.e) {
                        bVar.V();
                    } else {
                        g(aE, bVar, bVar2);
                    }
                }
                bVar.m();
                return f(aE);
            } catch (IllegalAccessException e) {
                e.e(e);
                throw null;
            } catch (IllegalStateException e2) {
                throw new x(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void d(d dVar, T t) throws IOException {
            if (t == null) {
                dVar.w();
                return;
            }
            dVar.f();
            try {
                Iterator<b> it = this.a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(dVar, t);
                }
                dVar.m();
            } catch (IllegalAccessException e) {
                e.e(e);
                throw null;
            }
        }

        abstract A e();

        abstract T f(A a);

        abstract void g(A a, com.google.gson.l0.b bVar, b bVar2) throws IllegalAccessException, IOException;
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final com.google.gson.internal.i0<T> b;

        FieldReflectionAdapter(com.google.gson.internal.i0<T> i0Var, Map<String, b> map) {
            super(map);
            this.b = i0Var;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T e() {
            return this.b.a();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T f(T t) {
            return t;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void g(T t, com.google.gson.l0.b bVar, b bVar2) throws IllegalAccessException, IOException {
            bVar2.b(bVar, t);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        static final Map<Class<?>, Object> e = j();
        private final Constructor<T> b;
        private final Object[] c;
        private final Map<String, Integer> d;

        RecordAdapter(Class<T> cls, Map<String, b> map, boolean z) throws SecurityException, q {
            super(map);
            this.d = new HashMap();
            Constructor<T> constructorI = e.i(cls);
            this.b = constructorI;
            if (z) {
                ReflectiveTypeAdapterFactory.c(null, constructorI);
            } else {
                e.l(constructorI);
            }
            String[] strArrJ = e.j(cls);
            for (int i2 = 0; i2 < strArrJ.length; i2++) {
                this.d.put(strArrJ[i2], Integer.valueOf(i2));
            }
            Class<?>[] parameterTypes = this.b.getParameterTypes();
            this.c = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.c[i3] = e.get(parameterTypes[i3]);
            }
        }

        private static Map<Class<?>, Object> j() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public T f(Object[] objArr) {
            try {
                return this.b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                e.e(e2);
                throw null;
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + e.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + e.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + e.c(this.b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, com.google.gson.l0.b bVar, b bVar2) throws t, IOException {
            Integer num = this.d.get(bVar2.c);
            if (num != null) {
                bVar2.a(bVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + e.c(this.b) + "' for field with name '" + bVar2.c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    class a extends b {
        final /* synthetic */ boolean f;
        final /* synthetic */ Method g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f733h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TypeAdapter f734i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Gson f735j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.google.gson.k0.a f736k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f737l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f738m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, TypeAdapter typeAdapter, Gson gson, com.google.gson.k0.a aVar, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f = z3;
            this.g = method;
            this.f733h = z4;
            this.f734i = typeAdapter;
            this.f735j = gson;
            this.f736k = aVar;
            this.f737l = z5;
            this.f738m = z6;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(com.google.gson.l0.b bVar, int i2, Object[] objArr) throws t, IOException {
            Object objB = this.f734i.b(bVar);
            if (objB != null || !this.f737l) {
                objArr[i2] = objB;
                return;
            }
            throw new t("null is not allowed as value for record component '" + this.c + "' of primitive type; at path " + bVar.o());
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void b(com.google.gson.l0.b bVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
            Object objB = this.f734i.b(bVar);
            if (objB == null && this.f737l) {
                return;
            }
            if (this.f) {
                ReflectiveTypeAdapterFactory.c(obj, this.b);
            } else if (this.f738m) {
                throw new q("Cannot set value of 'static final' " + e.g(this.b, false));
            }
            this.b.set(obj, objB);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void c(d dVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            Object objInvoke;
            if (this.d) {
                if (this.f) {
                    Method method = this.g;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.c(obj, this.b);
                    } else {
                        ReflectiveTypeAdapterFactory.c(obj, method);
                    }
                }
                Method method2 = this.g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e) {
                        throw new q("Accessor " + e.g(this.g, false) + " threw exception", e.getCause());
                    }
                } else {
                    objInvoke = this.b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                dVar.s(this.a);
                (this.f733h ? this.f734i : new TypeAdapterRuntimeTypeWrapper(this.f735j, this.f734i, this.f736k.e())).d(dVar, objInvoke);
            }
        }
    }

    static abstract class b {
        final String a;
        final Field b;
        final String c;
        final boolean d;
        final boolean e;

        protected b(String str, Field field, boolean z, boolean z2) {
            this.a = str;
            this.b = field;
            this.c = field.getName();
            this.d = z;
            this.e = z2;
        }

        abstract void a(com.google.gson.l0.b bVar, int i2, Object[] objArr) throws t, IOException;

        abstract void b(com.google.gson.l0.b bVar, Object obj) throws IllegalAccessException, IOException;

        abstract void c(d dVar, Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(z zVar, k kVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List<b0> list) {
        this.c = zVar;
        this.d = kVar;
        this.e = excluder;
        this.f = jsonAdapterAnnotationTypeAdapterFactory;
        this.g = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void c(Object obj, M m2) {
        if (Modifier.isStatic(m2.getModifiers())) {
            obj = null;
        }
        if (p0.a(m2, obj)) {
            return;
        }
        throw new q(e.g(m2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private b d(Gson gson, Field field, Method method, String str, com.google.gson.k0.a<?> aVar, boolean z, boolean z2, boolean z3) {
        boolean zA = k0.a(aVar.d());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        com.google.gson.j0.b bVar = (com.google.gson.j0.b) field.getAnnotation(com.google.gson.j0.b.class);
        TypeAdapter<?> typeAdapterB = bVar != null ? this.f.b(this.c, gson, aVar, bVar) : null;
        return new a(this, str, field, z, z2, z3, method, typeAdapterB != null, typeAdapterB == null ? gson.l(aVar) : typeAdapterB, gson, aVar, zA, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    private Map<String, b> e(Gson gson, com.google.gson.k0.a<?> aVar, Class<?> cls, boolean z, boolean z2) throws SecurityException, q {
        boolean z3;
        Method method;
        int i2;
        int i3;
        boolean z4;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        com.google.gson.k0.a<?> aVarB = aVar;
        boolean z5 = z;
        Class<?> clsD = cls;
        while (clsD != Object.class) {
            Field[] declaredFields = clsD.getDeclaredFields();
            boolean z6 = true;
            boolean z7 = false;
            if (clsD != cls && declaredFields.length > 0) {
                b0.a aVarB2 = p0.b(reflectiveTypeAdapterFactory.g, clsD);
                if (aVarB2 == b0.a.BLOCK_ALL) {
                    throw new q("ReflectionAccessFilter does not permit using reflection for " + clsD + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z5 = aVarB2 == b0.a.BLOCK_INACCESSIBLE;
            }
            boolean z8 = z5;
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean zG = reflectiveTypeAdapterFactory.g(field, z6);
                boolean zG2 = reflectiveTypeAdapterFactory.g(field, z7);
                if (zG || zG2) {
                    b bVar = null;
                    if (!z2) {
                        z3 = zG2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = z7;
                    } else {
                        Method methodH = e.h(clsD, field);
                        if (!z8) {
                            e.l(methodH);
                        }
                        if (methodH.getAnnotation(com.google.gson.j0.c.class) != null && field.getAnnotation(com.google.gson.j0.c.class) == null) {
                            throw new q("@SerializedName on " + e.g(methodH, z7) + " is not supported");
                        }
                        z3 = zG2;
                        method = methodH;
                    }
                    if (!z8 && method == null) {
                        e.l(field);
                    }
                    Type typeO = com.google.gson.internal.e.o(aVarB.e(), clsD, field.getGenericType());
                    List<String> listF = reflectiveTypeAdapterFactory.f(field);
                    int size = listF.size();
                    ?? r1 = z7;
                    while (r1 < size) {
                        String str = listF.get(r1);
                        boolean z9 = r1 != 0 ? z7 : zG;
                        int i5 = r1;
                        b bVar2 = bVar;
                        int i6 = size;
                        List<String> list = listF;
                        Field field2 = field;
                        int i7 = i4;
                        int i8 = length;
                        boolean z10 = z7;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str, d(gson, field, method, str, com.google.gson.k0.a.b(typeO), z9, z3, z8)) : bVar2;
                        zG = z9;
                        i4 = i7;
                        size = i6;
                        listF = list;
                        field = field2;
                        length = i8;
                        z7 = z10;
                        r1 = i5 + 1;
                    }
                    b bVar3 = bVar;
                    Field field3 = field;
                    i2 = i4;
                    i3 = length;
                    z4 = z7;
                    if (bVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + bVar3.a + "'; conflict is caused by fields " + e.f(bVar3.b) + " and " + e.f(field3));
                    }
                } else {
                    i2 = i4;
                    i3 = length;
                    z4 = z7;
                }
                i4 = i2 + 1;
                z6 = true;
                reflectiveTypeAdapterFactory = this;
                length = i3;
                z7 = z4;
            }
            aVarB = com.google.gson.k0.a.b(com.google.gson.internal.e.o(aVarB.e(), clsD, clsD.getGenericSuperclass()));
            clsD = aVarB.d();
            reflectiveTypeAdapterFactory = this;
            z5 = z8;
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        com.google.gson.j0.c cVar = (com.google.gson.j0.c) field.getAnnotation(com.google.gson.j0.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.d.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z) {
        return (this.e.c(field.getType(), z) || this.e.f(field, z)) ? false : true;
    }

    @Override // com.google.gson.i0
    public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
        Class<? super T> clsD = aVar.d();
        if (!Object.class.isAssignableFrom(clsD)) {
            return null;
        }
        b0.a aVarB = p0.b(this.g, clsD);
        if (aVarB != b0.a.BLOCK_ALL) {
            boolean z = aVarB == b0.a.BLOCK_INACCESSIBLE;
            return e.k(clsD) ? new RecordAdapter(clsD, e(gson, aVar, clsD, z, true), z) : new FieldReflectionAdapter(this.c.b(aVar), e(gson, aVar, clsD, z, false));
        }
        throw new q("ReflectionAccessFilter does not permit using reflection for " + clsD + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
