package i.b.ha.a.d;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class b {
    public static final Object[] a = new Object[0];

    public static int a(Object obj) {
        if (obj != null) {
            return Array.getLength(obj);
        }
        return 0;
    }
}
