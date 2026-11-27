package i.b;

import android.app.Activity;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.IRotationWatcher;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a9 {
    public static int a;
    public static int b;
    private static final IRotationWatcher.Stub c = new z8();

    public static int a() {
        return com.frame.n0.c("deafultDir", 0);
    }

    public static void b() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i2 = i(c);
        b = a();
        f(i2);
    }

    public static void c(Activity activity) {
        if (!e(activity)) {
            com.frame.y0.j("初始化屏幕方向（竖屏）");
        } else {
            h(1);
            com.frame.y0.j("初始化屏幕方向（横屏）");
        }
    }

    public static boolean d(int i2) {
        return Math.abs(i2) == 1 || Math.abs(i2) == 3;
    }

    public static boolean e(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        return a() == 0 && decorView.getWidth() > decorView.getHeight() && !d(a);
    }

    public static void f(int i2) {
        a = i2;
        int iK = com.frame.q1.k();
        int i3 = com.frame.q1.i();
        if (b == 0) {
            if (d(i2)) {
                int iMax = Math.max(iK, i3);
                int iMin = Math.min(iK, i3);
                com.frame.k0.c().w(iMax);
                com.frame.k0.c().v(iMin);
                com.frame.y0.g("切换横屏" + i2 + "：width:" + iMax + "   height:" + iMin);
                return;
            }
            int iMin2 = Math.min(iK, i3);
            int iMax2 = Math.max(iK, i3);
            com.frame.k0.c().w(iMin2);
            com.frame.k0.c().v(iMax2);
            com.frame.y0.g("切换竖屏" + i2 + "：width:" + iMin2 + "   height:" + iMax2);
            return;
        }
        if (d(i2)) {
            int iMin3 = Math.min(iK, i3);
            int iMax3 = Math.max(iK, i3);
            com.frame.k0.c().w(iMin3);
            com.frame.k0.c().v(iMax3);
            com.frame.y0.g("切换竖屏" + i2 + "：width:" + iMin3 + "   height:" + iMax3);
            return;
        }
        int iMax4 = Math.max(iK, i3);
        int iMin4 = Math.min(iK, i3);
        com.frame.k0.c().w(iMax4);
        com.frame.k0.c().v(iMin4);
        com.frame.y0.g("切换横屏" + i2 + "：width:" + iMax4 + "   height:" + iMin4);
    }

    public static void g() {
        f(a);
    }

    public static void h(int i2) {
        com.frame.n0.i("deafultDir", i2);
        b = i2;
    }

    public static int i(IRotationWatcher iRotationWatcher) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iIntValue = -1;
        try {
            Class<?>[] parameterTypes = null;
            Object objInvoke = Class.forName("android.view.IWindowManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "window"));
            for (Method method : objInvoke.getClass().getDeclaredMethods()) {
                Log.e("Service", "method = " + method.toGenericString());
                if ("watchRotation".equals(method.getName())) {
                    parameterTypes = method.getParameterTypes();
                }
            }
            Method declaredMethod = objInvoke.getClass().getDeclaredMethod("watchRotation", parameterTypes);
            iIntValue = Build.VERSION.SDK_INT >= 26 ? ((Integer) declaredMethod.invoke(objInvoke, iRotationWatcher, 0)).intValue() : ((Integer) declaredMethod.invoke(objInvoke, iRotationWatcher)).intValue();
            Log.e("Service", "rotation = " + iIntValue);
            return iIntValue;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return iIntValue;
        }
    }
}
