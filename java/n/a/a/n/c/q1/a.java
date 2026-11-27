package n.a.a.n.c.q1;

import n.a.a.o.j1;

/* loaded from: classes.dex */
public abstract class a {
    private static final Object a = null;

    private static int a(Object obj) {
        Class<?> cls;
        if (obj == a || (cls = obj.getClass()) == Boolean.class || cls == Double.class || cls == c.class) {
            return 8;
        }
        return j1.c((String) obj);
    }

    public static int b(Object[] objArr) {
        int length = objArr.length;
        for (Object obj : objArr) {
            length += a(obj);
        }
        return length;
    }
}
