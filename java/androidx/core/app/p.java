package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class p {
    private static String d;
    private final Context a;
    private final NotificationManager b;
    private static final Object c = new Object();
    private static Set<String> e = new HashSet();

    private p(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public static p b(Context context) {
        return new p(context);
    }

    public static Set<String> c(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (c) {
            if (string != null) {
                if (!string.equals(d)) {
                    String[] strArrSplit = string.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    e = hashSet;
                    d = string;
                }
                set = e;
            } else {
                set = e;
            }
        }
        return set;
    }

    public boolean a() throws ClassNotFoundException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return this.b.areNotificationsEnabled();
        }
        if (i2 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.a.getApplicationInfo();
        String packageName = this.a.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
