package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i0;
import com.google.gson.internal.c0;
import com.google.gson.j0.c;
import com.google.gson.l0.d;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public abstract class TypeAdapters {
    public static final TypeAdapter<BigInteger> A;
    public static final TypeAdapter<c0> B;
    public static final i0 C;
    public static final TypeAdapter<StringBuilder> D;
    public static final i0 E;
    public static final TypeAdapter<StringBuffer> F;
    public static final i0 G;
    public static final TypeAdapter<URL> H;
    public static final i0 I;
    public static final TypeAdapter<URI> J;
    public static final i0 K;
    public static final TypeAdapter<InetAddress> L;
    public static final i0 M;
    public static final TypeAdapter<UUID> N;
    public static final i0 O;
    public static final TypeAdapter<Currency> P;
    public static final i0 Q;
    public static final TypeAdapter<Calendar> R;
    public static final i0 S;
    public static final TypeAdapter<Locale> T;
    public static final i0 U;
    public static final TypeAdapter<p> V;
    public static final i0 W;
    public static final i0 X;
    public static final TypeAdapter<Class> a;
    public static final i0 b;
    public static final TypeAdapter<BitSet> c;
    public static final i0 d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final i0 g;

    /* renamed from: h, reason: collision with root package name */
    public static final TypeAdapter<Number> f740h;

    /* renamed from: i, reason: collision with root package name */
    public static final i0 f741i;

    /* renamed from: j, reason: collision with root package name */
    public static final TypeAdapter<Number> f742j;

    /* renamed from: k, reason: collision with root package name */
    public static final i0 f743k;

    /* renamed from: l, reason: collision with root package name */
    public static final TypeAdapter<Number> f744l;

    /* renamed from: m, reason: collision with root package name */
    public static final i0 f745m;

    /* renamed from: n, reason: collision with root package name */
    public static final TypeAdapter<AtomicInteger> f746n;

    /* renamed from: o, reason: collision with root package name */
    public static final i0 f747o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final i0 q;
    public static final TypeAdapter<AtomicIntegerArray> r;
    public static final i0 s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Character> w;
    public static final i0 x;
    public static final TypeAdapter<String> y;
    public static final TypeAdapter<BigDecimal> z;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30, reason: invalid class name */
    class AnonymousClass30 implements i0 {
        final /* synthetic */ com.google.gson.k0.a c;
        final /* synthetic */ TypeAdapter d;

        @Override // com.google.gson.i0
        public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
            if (aVar.equals(this.c)) {
                return this.d;
            }
            return null;
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<String, T> b = new HashMap();
        private final Map<T, String> c = new HashMap();

        class a implements PrivilegedAction<Field[]> {
            final /* synthetic */ Class a;

            a(EnumTypeAdapter enumTypeAdapter, Class cls) {
                this.a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() throws SecurityException {
                Field[] declaredFields = this.a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(this, cls))) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    c cVar = (c) field.getAnnotation(c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.a.put(str, r4);
                        }
                    }
                    this.a.put(strName, r4);
                    this.b.put(string, r4);
                    this.c.put(r4, strName);
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(com.google.gson.l0.b bVar) throws IOException {
            if (bVar.L() == com.google.gson.l0.c.NULL) {
                bVar.H();
                return null;
            }
            String strJ = bVar.J();
            T t = this.a.get(strJ);
            return t == null ? this.b.get(strJ) : t;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(d dVar, T t) throws IOException {
            dVar.N(t == null ? null : this.c.get(t));
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.gson.l0.c.values().length];
            a = iArr;
            try {
                iArr[com.google.gson.l0.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.l0.c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.l0.c.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.l0.c.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.l0.c.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.l0.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        TypeAdapter<Class> typeAdapterA = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ Class b(com.google.gson.l0.b bVar) throws IOException {
                e(bVar);
                throw null;
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void d(d dVar, Class cls) throws IOException {
                f(dVar, cls);
                throw null;
            }

            public Class e(com.google.gson.l0.b bVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            public void f(d dVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.a();
        a = typeAdapterA;
        b = a(Class.class, typeAdapterA);
        TypeAdapter<BitSet> typeAdapterA2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public BitSet b(com.google.gson.l0.b bVar) throws IOException, NumberFormatException {
                BitSet bitSet = new BitSet();
                bVar.a();
                com.google.gson.l0.c cVarL = bVar.L();
                int i2 = 0;
                while (cVarL != com.google.gson.l0.c.END_ARRAY) {
                    int i3 = a.a[cVarL.ordinal()];
                    boolean zY = true;
                    if (i3 == 1 || i3 == 2) {
                        int iB = bVar.B();
                        if (iB == 0) {
                            zY = false;
                        } else if (iB != 1) {
                            throw new x("Invalid bitset value " + iB + ", expected 0 or 1; at path " + bVar.q());
                        }
                    } else {
                        if (i3 != 3) {
                            throw new x("Invalid bitset value type: " + cVarL + "; at path " + bVar.o());
                        }
                        zY = bVar.y();
                    }
                    if (zY) {
                        bitSet.set(i2);
                    }
                    i2++;
                    cVarL = bVar.L();
                }
                bVar.j();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, BitSet bitSet) throws IOException {
                dVar.d();
                int length = bitSet.length();
                for (int i2 = 0; i2 < length; i2++) {
                    dVar.K(bitSet.get(i2) ? 1L : 0L);
                }
                dVar.j();
            }
        }.a();
        c = typeAdapterA2;
        d = a(BitSet.class, typeAdapterA2);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean b(com.google.gson.l0.b bVar) throws IOException {
                com.google.gson.l0.c cVarL = bVar.L();
                if (cVarL != com.google.gson.l0.c.NULL) {
                    return cVarL == com.google.gson.l0.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(bVar.J())) : Boolean.valueOf(bVar.y());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Boolean bool) throws IOException {
                dVar.L(bool);
            }
        };
        e = typeAdapter;
        f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Boolean.valueOf(bVar.J());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Boolean bool) throws IOException {
                dVar.N(bool == null ? "null" : bool.toString());
            }
        };
        g = b(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                try {
                    int iB = bVar.B();
                    if (iB <= 255 && iB >= -128) {
                        return Byte.valueOf((byte) iB);
                    }
                    throw new x("Lossy conversion from " + iB + " to byte; at path " + bVar.q());
                } catch (NumberFormatException e2) {
                    throw new x(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.K(number.byteValue());
                }
            }
        };
        f740h = typeAdapter2;
        f741i = b(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                try {
                    int iB = bVar.B();
                    if (iB <= 65535 && iB >= -32768) {
                        return Short.valueOf((short) iB);
                    }
                    throw new x("Lossy conversion from " + iB + " to short; at path " + bVar.q());
                } catch (NumberFormatException e2) {
                    throw new x(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.K(number.shortValue());
                }
            }
        };
        f742j = typeAdapter3;
        f743k = b(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                try {
                    return Integer.valueOf(bVar.B());
                } catch (NumberFormatException e2) {
                    throw new x(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.K(number.intValue());
                }
            }
        };
        f744l = typeAdapter4;
        f745m = b(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> typeAdapterA3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicInteger b(com.google.gson.l0.b bVar) throws IOException {
                try {
                    return new AtomicInteger(bVar.B());
                } catch (NumberFormatException e2) {
                    throw new x(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, AtomicInteger atomicInteger) throws IOException {
                dVar.K(atomicInteger.get());
            }
        }.a();
        f746n = typeAdapterA3;
        f747o = a(AtomicInteger.class, typeAdapterA3);
        TypeAdapter<AtomicBoolean> typeAdapterA4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean b(com.google.gson.l0.b bVar) throws IOException {
                return new AtomicBoolean(bVar.y());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, AtomicBoolean atomicBoolean) throws IOException {
                dVar.O(atomicBoolean.get());
            }
        }.a();
        p = typeAdapterA4;
        q = a(AtomicBoolean.class, typeAdapterA4);
        TypeAdapter<AtomicIntegerArray> typeAdapterA5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray b(com.google.gson.l0.b bVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.s()) {
                    try {
                        arrayList.add(Integer.valueOf(bVar.B()));
                    } catch (NumberFormatException e2) {
                        throw new x(e2);
                    }
                }
                bVar.j();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                dVar.d();
                int length = atomicIntegerArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    dVar.K(atomicIntegerArray.get(i2));
                }
                dVar.j();
            }
        }.a();
        r = typeAdapterA5;
        s = a(AtomicIntegerArray.class, typeAdapterA5);
        t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                try {
                    return Long.valueOf(bVar.D());
                } catch (NumberFormatException e2) {
                    throw new x(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.K(number.longValue());
                }
            }
        };
        u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Float.valueOf((float) bVar.z());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                dVar.M(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Number b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return Double.valueOf(bVar.z());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.w();
                } else {
                    dVar.J(number.doubleValue());
                }
            }
        };
        TypeAdapter<Character> typeAdapter5 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Character b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                String strJ = bVar.J();
                if (strJ.length() == 1) {
                    return Character.valueOf(strJ.charAt(0));
                }
                throw new x("Expecting character, got: " + strJ + "; at " + bVar.q());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Character ch) throws IOException {
                dVar.N(ch == null ? null : String.valueOf(ch));
            }
        };
        w = typeAdapter5;
        x = b(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter<String> typeAdapter6 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public String b(com.google.gson.l0.b bVar) throws IOException {
                com.google.gson.l0.c cVarL = bVar.L();
                if (cVarL != com.google.gson.l0.c.NULL) {
                    return cVarL == com.google.gson.l0.c.BOOLEAN ? Boolean.toString(bVar.y()) : bVar.J();
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, String str) throws IOException {
                dVar.N(str);
            }
        };
        y = typeAdapter6;
        z = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public BigDecimal b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                String strJ = bVar.J();
                try {
                    return new BigDecimal(strJ);
                } catch (NumberFormatException e2) {
                    throw new x("Failed parsing '" + strJ + "' as BigDecimal; at path " + bVar.q(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, BigDecimal bigDecimal) throws IOException {
                dVar.M(bigDecimal);
            }
        };
        A = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public BigInteger b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                String strJ = bVar.J();
                try {
                    return new BigInteger(strJ);
                } catch (NumberFormatException e2) {
                    throw new x("Failed parsing '" + strJ + "' as BigInteger; at path " + bVar.q(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, BigInteger bigInteger) throws IOException {
                dVar.M(bigInteger);
            }
        };
        B = new TypeAdapter<c0>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public c0 b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return new c0(bVar.J());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, c0 c0Var) throws IOException {
                dVar.M(c0Var);
            }
        };
        C = a(String.class, typeAdapter6);
        TypeAdapter<StringBuilder> typeAdapter7 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public StringBuilder b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return new StringBuilder(bVar.J());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, StringBuilder sb) throws IOException {
                dVar.N(sb == null ? null : sb.toString());
            }
        };
        D = typeAdapter7;
        E = a(StringBuilder.class, typeAdapter7);
        TypeAdapter<StringBuffer> typeAdapter8 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public StringBuffer b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return new StringBuffer(bVar.J());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, StringBuffer stringBuffer) throws IOException {
                dVar.N(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = a(StringBuffer.class, typeAdapter8);
        TypeAdapter<URL> typeAdapter9 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public URL b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                String strJ = bVar.J();
                if ("null".equals(strJ)) {
                    return null;
                }
                return new URL(strJ);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, URL url) throws IOException {
                dVar.N(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = a(URL.class, typeAdapter9);
        TypeAdapter<URI> typeAdapter10 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public URI b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                try {
                    String strJ = bVar.J();
                    if ("null".equals(strJ)) {
                        return null;
                    }
                    return new URI(strJ);
                } catch (URISyntaxException e2) {
                    throw new q(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, URI uri) throws IOException {
                dVar.N(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = a(URI.class, typeAdapter10);
        TypeAdapter<InetAddress> typeAdapter11 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InetAddress b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() != com.google.gson.l0.c.NULL) {
                    return InetAddress.getByName(bVar.J());
                }
                bVar.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, InetAddress inetAddress) throws IOException {
                dVar.N(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = d(InetAddress.class, typeAdapter11);
        TypeAdapter<UUID> typeAdapter12 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public UUID b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                String strJ = bVar.J();
                try {
                    return UUID.fromString(strJ);
                } catch (IllegalArgumentException e2) {
                    throw new x("Failed parsing '" + strJ + "' as UUID; at path " + bVar.q(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, UUID uuid) throws IOException {
                dVar.N(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = a(UUID.class, typeAdapter12);
        TypeAdapter<Currency> typeAdapterA6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Currency b(com.google.gson.l0.b bVar) throws IOException {
                String strJ = bVar.J();
                try {
                    return Currency.getInstance(strJ);
                } catch (IllegalArgumentException e2) {
                    throw new x("Failed parsing '" + strJ + "' as Currency; at path " + bVar.q(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Currency currency) throws IOException {
                dVar.N(currency.getCurrencyCode());
            }
        }.a();
        P = typeAdapterA6;
        Q = a(Currency.class, typeAdapterA6);
        TypeAdapter<Calendar> typeAdapter13 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Calendar b(com.google.gson.l0.b bVar) throws IOException, NumberFormatException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                bVar.c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (bVar.L() != com.google.gson.l0.c.END_OBJECT) {
                    String strF = bVar.F();
                    int iB = bVar.B();
                    if ("year".equals(strF)) {
                        i2 = iB;
                    } else if ("month".equals(strF)) {
                        i3 = iB;
                    } else if ("dayOfMonth".equals(strF)) {
                        i4 = iB;
                    } else if ("hourOfDay".equals(strF)) {
                        i5 = iB;
                    } else if ("minute".equals(strF)) {
                        i6 = iB;
                    } else if ("second".equals(strF)) {
                        i7 = iB;
                    }
                }
                bVar.m();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    dVar.w();
                    return;
                }
                dVar.f();
                dVar.s("year");
                dVar.K(calendar.get(1));
                dVar.s("month");
                dVar.K(calendar.get(2));
                dVar.s("dayOfMonth");
                dVar.K(calendar.get(5));
                dVar.s("hourOfDay");
                dVar.K(calendar.get(11));
                dVar.s("minute");
                dVar.K(calendar.get(12));
                dVar.s("second");
                dVar.K(calendar.get(13));
                dVar.m();
            }
        };
        R = typeAdapter13;
        S = c(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter<Locale> typeAdapter14 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Locale b(com.google.gson.l0.b bVar) throws IOException {
                if (bVar.L() == com.google.gson.l0.c.NULL) {
                    bVar.H();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(bVar.J(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, Locale locale) throws IOException {
                dVar.N(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = a(Locale.class, typeAdapter14);
        TypeAdapter<p> typeAdapter15 = new TypeAdapter<p>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            private p f(com.google.gson.l0.b bVar, com.google.gson.l0.c cVar) throws IOException {
                int i2 = a.a[cVar.ordinal()];
                if (i2 == 1) {
                    return new u(new c0(bVar.J()));
                }
                if (i2 == 2) {
                    return new u(bVar.J());
                }
                if (i2 == 3) {
                    return new u(Boolean.valueOf(bVar.y()));
                }
                if (i2 == 6) {
                    bVar.H();
                    return r.a;
                }
                throw new IllegalStateException("Unexpected token: " + cVar);
            }

            private p g(com.google.gson.l0.b bVar, com.google.gson.l0.c cVar) throws IOException {
                int i2 = a.a[cVar.ordinal()];
                if (i2 == 4) {
                    bVar.a();
                    return new m();
                }
                if (i2 != 5) {
                    return null;
                }
                bVar.c();
                return new s();
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public p b(com.google.gson.l0.b bVar) throws IOException {
                com.google.gson.l0.c cVarL = bVar.L();
                p pVarG = g(bVar, cVarL);
                if (pVarG == null) {
                    return f(bVar, cVarL);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (bVar.s()) {
                        String strF = pVarG instanceof s ? bVar.F() : null;
                        com.google.gson.l0.c cVarL2 = bVar.L();
                        p pVarG2 = g(bVar, cVarL2);
                        boolean z2 = pVarG2 != null;
                        if (pVarG2 == null) {
                            pVarG2 = f(bVar, cVarL2);
                        }
                        if (pVarG instanceof m) {
                            ((m) pVarG).l(pVarG2);
                        } else {
                            ((s) pVarG).l(strF, pVarG2);
                        }
                        if (z2) {
                            arrayDeque.addLast(pVarG);
                            pVarG = pVarG2;
                        }
                    } else {
                        if (pVarG instanceof m) {
                            bVar.j();
                        } else {
                            bVar.m();
                        }
                        if (arrayDeque.isEmpty()) {
                            return pVarG;
                        }
                        pVarG = (p) arrayDeque.removeLast();
                    }
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(d dVar, p pVar) throws IOException {
                if (pVar == null || pVar.h()) {
                    dVar.w();
                    return;
                }
                if (pVar.k()) {
                    u uVarE = pVar.e();
                    if (uVarE.v()) {
                        dVar.M(uVarE.p());
                        return;
                    } else if (uVarE.t()) {
                        dVar.O(uVarE.l());
                        return;
                    } else {
                        dVar.N(uVarE.r());
                        return;
                    }
                }
                if (pVar.g()) {
                    dVar.d();
                    Iterator<p> it = pVar.a().iterator();
                    while (it.hasNext()) {
                        d(dVar, it.next());
                    }
                    dVar.j();
                    return;
                }
                if (!pVar.j()) {
                    throw new IllegalArgumentException("Couldn't write " + pVar.getClass());
                }
                dVar.f();
                for (Map.Entry<String, p> entry : pVar.b().p()) {
                    dVar.s(entry.getKey());
                    d(dVar, entry.getValue());
                }
                dVar.m();
            }
        };
        V = typeAdapter15;
        W = d(p.class, typeAdapter15);
        X = new i0() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                Class<? super T> clsD = aVar.d();
                if (!Enum.class.isAssignableFrom(clsD) || clsD == Enum.class) {
                    return null;
                }
                if (!clsD.isEnum()) {
                    clsD = clsD.getSuperclass();
                }
                return new EnumTypeAdapter(clsD);
            }
        };
    }

    public static <TT> i0 a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new i0() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                if (aVar.d() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> i0 b(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new i0() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                Class<? super T> clsD = aVar.d();
                if (clsD == cls || clsD == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> i0 c(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new i0() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.i0
            public <T> TypeAdapter<T> a(Gson gson, com.google.gson.k0.a<T> aVar) {
                Class<? super T> clsD = aVar.d();
                if (clsD == cls || clsD == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> i0 d(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new i0() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.i0
            public <T2> TypeAdapter<T2> a(Gson gson, com.google.gson.k0.a<T2> aVar) {
                final Class<? super T2> clsD = aVar.d();
                if (cls.isAssignableFrom(clsD)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        @Override // com.google.gson.TypeAdapter
                        public T1 b(com.google.gson.l0.b bVar) throws IOException {
                            T1 t1 = (T1) typeAdapter.b(bVar);
                            if (t1 == null || clsD.isInstance(t1)) {
                                return t1;
                            }
                            throw new x("Expected a " + clsD.getName() + " but was " + t1.getClass().getName() + "; at path " + bVar.q());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void d(d dVar, T1 t1) throws IOException {
                            typeAdapter.d(dVar, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
