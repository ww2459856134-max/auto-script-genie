package com.permission;

import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public class z0 {
    public void a() {
        try {
            Intent intent = new Intent();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", com.frame.v0.g().getPackageName(), null));
            } else if (i2 <= 8) {
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", com.frame.v0.g().getPackageName());
            }
            com.frame.v0.g().t(intent, x0.f835h.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b(Context context) {
        try {
            Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.putExtra("package", context.getPackageName());
            intent.putExtra("pn", context.getPackageName());
            intent.putExtra("extra_pkgname", context.getPackageName());
            com.frame.v0.g().t(intent, x0.b.intValue());
        } catch (Exception e) {
            Log.e("android:23", Log.getStackTraceString(e));
        }
    }

    public void c() {
    }

    public boolean d(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return e(context);
        }
        if (i2 >= 19) {
            return f(context, 24);
        }
        return true;
    }

    public boolean e(Context context) {
        Boolean bool = Boolean.TRUE;
        try {
            bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
        } catch (Exception e) {
            Log.e("android23", Log.getStackTraceString(e));
        }
        return bool.booleanValue();
    }

    boolean f(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e("Rom", Log.getStackTraceString(e));
            }
        } else {
            Log.e("Rom", "Below API 19 cannot invoke!");
        }
        return false;
    }

    public float g() {
        return -1.0f;
    }

    boolean h(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT).size() > 0;
    }

    public void i(Context context, String str) {
        String str2;
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 2) {
            com.frame.v0.g().s(context.getPackageManager().getLaunchIntentForPackage(str));
            return;
        }
        String str3 = strArrSplit[0];
        if (strArrSplit[1].startsWith(".")) {
            str2 = strArrSplit[0] + strArrSplit[1];
        } else {
            str2 = strArrSplit[1];
        }
        k(context, str3, str2);
    }

    public void j(Context context, String str, int i2) throws PendingIntent.CanceledException {
        String str2;
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 2) {
            com.frame.i0.n(str);
            return;
        }
        String str3 = strArrSplit[0];
        if (strArrSplit[1].startsWith(".")) {
            str2 = strArrSplit[0] + strArrSplit[1];
        } else {
            str2 = strArrSplit[1];
        }
        l(context, str3, str2, i2);
    }

    public void k(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtra("packageName", context.getPackageName());
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        com.frame.v0.g().startActivity(intent);
    }

    void l(Context context, String str, String str2, int i2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtra("packageName", context.getPackageName());
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        com.frame.v0.g().t(intent, i2);
    }

    public void m(Context context, String[] strArr, int i2) throws Exception {
        try {
            i(context, strArr[i2]);
        } catch (Exception e) {
            com.frame.k0.r(e);
            if (i2 >= strArr.length - 1) {
                throw new Exception("");
            }
            m(context, strArr, i2 + 1);
        }
    }

    public void n(Context context, String[] strArr, int i2, int i3) throws Exception {
        try {
            j(context, strArr[i2], i3);
        } catch (Exception e) {
            Log.e("Rom", e.getMessage());
            if (i2 >= strArr.length - 1) {
                throw new Exception("");
            }
            n(context, strArr, i2 + 1, i3);
        }
    }
}
