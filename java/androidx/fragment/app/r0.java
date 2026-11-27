package androidx.fragment.app;

/* loaded from: classes.dex */
public abstract class r0 {
    private static final h.d.i<ClassLoader, h.d.i<String, Class<?>>> a = new h.d.i<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class<?> c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        h.d.i<ClassLoader, h.d.i<String, Class<?>>> iVar = a;
        h.d.i<String, Class<?>> iVar2 = iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new h.d.i<>();
            iVar.put(classLoader, iVar2);
        }
        Class<?> cls = iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new b0("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new b0("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
