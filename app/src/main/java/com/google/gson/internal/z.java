package com.google.gson.internal;

import com.google.gson.b0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* loaded from: classes.dex */
public final class z {
    private final Map<Type, com.google.gson.l<?>> a;
    private final boolean b;
    private final List<com.google.gson.b0> c;

    public z(Map<Type, com.google.gson.l<?>> map, boolean z, List<com.google.gson.b0> list) {
        this.a = map;
        this.b = z;
        this.c = list;
    }

    static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static <T> i0<T> c(Class<? super T> cls, b0.a aVar) throws NoSuchMethodException, SecurityException {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            b0.a aVar2 = b0.a.ALLOW;
            if (aVar == aVar2 || (p0.a(declaredConstructor, null) && (aVar != b0.a.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z = true;
            }
            if (z) {
                return (aVar != aVar2 || (strM = com.google.gson.internal.z0.e.m(declaredConstructor)) == null) ? new y(declaredConstructor) : new x(strM);
            }
            return new w("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> i0<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new f() : Set.class.isAssignableFrom(cls) ? new g() : Queue.class.isAssignableFrom(cls) ? new h() : new i();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new j() : ConcurrentMap.class.isAssignableFrom(cls) ? new k() : SortedMap.class.isAssignableFrom(cls) ? new l() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.k0.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).d())) ? new n() : new m();
        }
        return null;
    }

    private static <T> i0<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new u(type);
        }
        if (cls == EnumMap.class) {
            return new v(type);
        }
        return null;
    }

    private <T> i0<T> f(Class<? super T> cls) {
        if (this.b) {
            return new o(this, cls);
        }
        return new q(this, "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> i0<T> b(com.google.gson.k0.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type typeE = aVar.e();
        Class<? super T> clsD = aVar.d();
        com.google.gson.l<?> lVar = this.a.get(typeE);
        if (lVar != null) {
            return new p(this, lVar, typeE);
        }
        com.google.gson.l<?> lVar2 = this.a.get(clsD);
        if (lVar2 != null) {
            return new r(this, lVar2, typeE);
        }
        i0<T> i0VarE = e(typeE, clsD);
        if (i0VarE != null) {
            return i0VarE;
        }
        b0.a aVarB = p0.b(this.c, clsD);
        i0<T> i0VarC = c(clsD, aVarB);
        if (i0VarC != null) {
            return i0VarC;
        }
        i0<T> i0VarD = d(typeE, clsD);
        if (i0VarD != null) {
            return i0VarD;
        }
        String strA = a(clsD);
        if (strA != null) {
            return new s(this, strA);
        }
        if (aVarB == b0.a.ALLOW) {
            return f(clsD);
        }
        return new t(this, "Unable to create instance of " + clsD + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.a.toString();
    }
}
