package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class l {
    private static Map<Class<?>, Integer> a = new HashMap();
    private static Map<Class<?>, List<Constructor<? extends d>>> b = new HashMap();

    private static d a(Constructor<? extends d> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends d> b(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strC = c(canonicalName);
            if (!name.isEmpty()) {
                strC = name + "." + strC;
            }
            Constructor declaredConstructor = Class.forName(strC).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Integer num = a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        a.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && h.class.isAssignableFrom(cls);
    }

    static g f(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends d>> list = b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        d[] dVarArr = new d[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            dVarArr[i2] = a(list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(dVarArr);
    }

    private static int g(Class<?> cls) throws NoSuchMethodException, SecurityException {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends d> constructorB = b(cls);
        if (constructorB != null) {
            b.put(cls, Collections.singletonList(constructorB));
            return 2;
        }
        if (a.c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (e(superclass)) {
            if (d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (e(cls2)) {
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        b.put(cls, arrayList);
        return 2;
    }
}
