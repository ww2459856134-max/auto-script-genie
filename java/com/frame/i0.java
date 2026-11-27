package com.frame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i0 {
    public static boolean a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = v0.g().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            k0.r(e);
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static void b(String str) {
        try {
            if (v0.g().getPackageName().equals(str) || !a(str)) {
                i(str);
            } else {
                n(str);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public static Intent c(String str) throws PackageManager.NameNotFoundException {
        ResolveInfo resolveInfo;
        PackageManager packageManager = v0.g().getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty() || (resolveInfo = listQueryIntentActivities.get(0)) == null) {
            return null;
        }
        String str2 = resolveInfo.activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str, str2));
        return intent2;
    }

    public static String d() {
        ActivityInfo activityInfo;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfoResolveActivity = v0.g().getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || "android".equals(activityInfo.packageName)) {
            return null;
        }
        return resolveInfoResolveActivity.activityInfo.packageName;
    }

    @SuppressLint({"WrongConstant"})
    public static PendingIntent e(int i2, Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(v0.g(), i2, intent, 33554432) : PendingIntent.getActivity(v0.g(), i2, intent, 134217728);
    }

    public static PendingIntent f(int i2, Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(v0.g(), i2, intent, 201326592) : PendingIntent.getBroadcast(v0.g(), i2, intent, 134217728);
    }

    @SuppressLint({"WrongConstant"})
    public static PendingIntent g(int i2, Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getService(v0.g(), i2, intent, 167772160) : PendingIntent.getService(v0.g(), i2, intent, 134217728);
    }

    public static void h(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse("market://details?id=" + str + "&th_name=need_comment"));
            v0.g().startActivity(intent);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public static void i(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse("market://details?id=" + str));
            v0.g().startActivity(intent);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public static void j(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse("market://search?q=" + str));
            v0.g().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void k(Activity activity, boolean z) {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                activity.getWindow().addFlags(67108864);
                l(activity.getWindow(), z);
                m(z, activity);
            }
            if (i2 > 21) {
                Window window = activity.getWindow();
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                if (z || i2 < 23) {
                    return;
                }
                try {
                    activity.getWindow().getDecorView().setSystemUiVisibility(9216);
                } catch (Exception e) {
                    k0.r(e);
                }
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    public static boolean l(Window window, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
                window.setAttributes(attributes);
                return true;
            } catch (Exception unused) {
                Log.e("MeiZu", "setStatusBarDarkIcon: failed");
            }
        }
        return false;
    }

    public static void m(boolean z, Activity activity) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    public static boolean n(String str) throws PendingIntent.CanceledException {
        try {
            Intent intentC = c(str);
            try {
                e(str.hashCode(), intentC).send();
                y0.g("PendingIntent.getActivity.send:" + str);
            } catch (Exception e) {
                k0.r(e);
            }
            v0.g().startActivity(intentC);
            y0.g("FrameApp.getInstance().startActivity:" + str);
            return true;
        } catch (Exception e2) {
            k0.r(e2);
            return false;
        }
    }
}
