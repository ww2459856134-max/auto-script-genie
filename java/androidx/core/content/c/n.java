package androidx.core.content.c;

import android.content.res.Resources;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
abstract class n {
    private static final Object a = new Object();
    private static Method b;
    private static boolean c;

    /* JADX WARN: Removed duplicated region for block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(Resources.Theme theme) {
        Method method;
        synchronized (a) {
            if (c) {
                method = b;
                if (method != null) {
                }
            } else {
                try {
                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                }
                c = true;
                method = b;
                if (method != null) {
                    try {
                        method.invoke(theme, new Object[0]);
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                        b = null;
                    }
                }
            }
        }
    }
}
