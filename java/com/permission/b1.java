package com.permission;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes.dex */
public class b1 extends z0 {
    public static int o(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
        if (cursorQuery == null) {
            return p(context);
        }
        cursorQuery.getColumnNames();
        if (!cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return p(context);
        }
        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentlmode"));
        cursorQuery.close();
        return i2;
    }

    private static int p(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentmode"));
                cursorQuery.close();
                return i2;
            }
            cursorQuery.close();
        }
        return 1;
    }

    @Override // com.permission.z0
    public void a() {
        try {
            n(com.frame.v0.g(), new String[]{"com.vivo.permissionmanager/.activity.BgStartUpManagerActivity", "com.iqoo.secure/.ui.phoneoptimize.SoftwareManagerActivity", "com.vivo.permissionmanager/.activity.PurviewTabActivity"}, 0, x0.f835h.intValue());
            com.frame.v0.f().edit().putBoolean("already_autorun", true).apply();
        } catch (Exception e) {
            com.frame.k0.r(e);
            super.a();
        }
    }

    @Override // com.permission.z0
    public void b(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            super.b(context);
            return;
        }
        try {
            n(context, new String[]{"com.iqoo.secure/.ui.phoneoptimize.SoftwareManagerActivity", "com.coloros.safecenter/.ui.phoneoptimize.FloatWindowManager", "com.iqoo.secure/.safeguard.SoftPermissionDetailActivity", "com.vivo.permissionmanager/.activity.PurviewTabActivity", "com.vivo.permissionmanager/com.vivo.permissionmanager.activity.SoftPermissionDetailActivity", "com.iqoo.secure"}, 0, x0.b.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            double dG = g();
            if (dG < 3.0d || dG >= 3.2d) {
                super.b(context);
            } else {
                Toast.makeText(context, String.format("回到【桌面】选择【设置】--【更多设置】--【权限管理】--【%s】，开启悬浮窗", com.frame.v0.g().getResources().getString(j.d.a.a)), 1).show();
            }
        }
    }

    @Override // com.permission.z0
    public void c() {
        try {
            n(com.frame.v0.g(), new String[]{"com.iqoo.powersaving/com.iqoo.powersaving.PowerSavingManagerActivity", "com.vivo.abe/com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity", "com.vivo.abeui/com.vivo.abeui.highpower.ExcessivePowerManagerActivity", "com.vivo.abe/com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"}, 0, x0.f837j.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            super.a();
        }
    }

    @Override // com.permission.z0
    public boolean d(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 23 ? super.d(context) : i2 <= 21 || o(context) == 0;
    }

    @Override // com.permission.z0
    public float g() throws Throwable {
        String strK = a1.k("ro.vivo.os.version");
        if (strK == null) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(strK);
        } catch (Exception e) {
            Log.e("Vivo", "get miui version code error, version : " + strK);
            Log.e("Vivo", Log.getStackTraceString(e));
            return -1.0f;
        }
    }
}
