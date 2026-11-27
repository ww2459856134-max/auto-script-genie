package com.google.gson.internal.z0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class d extends b {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Method d;

    @Override // com.google.gson.internal.z0.b
    public Method a(Class<?> cls, Field field) {
        try {
            return cls.getMethod(field.getName(), new Class[0]);
        } catch (ReflectiveOperationException e) {
            e.a(e);
            throw null;
        }
    }

    @Override // com.google.gson.internal.z0.b
    public <T> Constructor<T> b(Class<T> cls) {
        try {
            Object[] objArr = (Object[]) this.b.invoke(cls, new Object[0]);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = (Class) this.d.invoke(objArr[i2], new Object[0]);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e) {
            e.a(e);
            throw null;
        }
    }

    @Override // com.google.gson.internal.z0.b
    String[] c(Class<?> cls) {
        try {
            Object[] objArr = (Object[]) this.b.invoke(cls, new Object[0]);
            String[] strArr = new String[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                strArr[i2] = (String) this.c.invoke(objArr[i2], new Object[0]);
            }
            return strArr;
        } catch (ReflectiveOperationException e) {
            e.a(e);
            throw null;
        }
    }

    @Override // com.google.gson.internal.z0.b
    boolean d(Class<?> cls) {
        try {
            return ((Boolean) this.a.invoke(cls, new Object[0])).booleanValue();
        } catch (ReflectiveOperationException e) {
            e.a(e);
            throw null;
        }
    }

    private d() throws NoSuchMethodException, SecurityException {
        super();
        this.a = Class.class.getMethod("isRecord", new Class[0]);
        Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
        this.b = method;
        Class<?> componentType = method.getReturnType().getComponentType();
        this.c = componentType.getMethod("getName", new Class[0]);
        this.d = componentType.getMethod("getType", new Class[0]);
    }
}
