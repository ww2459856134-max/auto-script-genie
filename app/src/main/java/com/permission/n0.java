package com.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class n0 extends z0 {
    @Override // com.permission.z0
    public void a() {
        try {
            n(com.frame.v0.g().d(), new String[]{"com.coloros.safecenter/com.coloros.safecenter.startupapp.view.StartupAppListActivity", "com.coloros.safe/com.coloros.safe.permission.startup.StartupAppListActivity", "com.coloros.safe/com.coloros.safe.permission.startupapp.StartupAppListActivity", "com.coloros.safecenter/com.coloros.safecenter.startupapp.StartupAppListActivity", "com.coloros.safecenter/com.coloros.safecenter.startup.StartupAppListActivity", "com.coloros.safecenter/com.coloros.privacypermissionsentry.PermissionTopActivity", "com.coloros.safecenter/com.color.safecenter.permission.PermissionTopActivity"}, 0, x0.f835h.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            super.a();
        }
    }

    @Override // com.permission.z0
    public void b(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 28) {
            super.b(context);
            return;
        }
        float fG = g();
        if (fG <= 2.0f && fG != -1.0f) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                com.frame.v0.g().t(intent, x0.b.intValue());
                return;
            } catch (Exception e) {
                com.frame.k0.r(e);
                try {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.oppo.getRomVersion", "com.oppo.safe.permission.PermissionTopActivity"));
                    intent2.putExtra("packageName", com.frame.v0.g().getPackageName());
                    com.frame.v0.g().t(intent2, x0.b.intValue());
                    return;
                } catch (Exception e2) {
                    com.frame.k0.r(e2);
                }
            }
        }
        try {
            n(context, new String[]{"com.coloros.safecenter/.permission.floatwindow.FloatWindowListActivity", "com.coloros.safecenter/.SecureSafeMainActivity", "com.coloros.safecenter/.permission.PermissionTopActivity", "com.coloros.safecenter/.sysfloatwindow.FloatWindowListActivity", "com.coloros.safecenter/.MainActivity", "com.oppo.safe/com.oppo.safe.permission.PermissionAppListActivity", "com.oppo.safe/com.oppo.safe.permission.PermissionTopActivity"}, 0, x0.b.intValue());
        } catch (Exception e3) {
            com.frame.k0.r(e3);
            if (Build.VERSION.SDK_INT >= 23) {
                super.b(context);
            }
        }
    }

    @Override // com.permission.z0
    public boolean d(Context context) {
        return super.d(context);
    }

    @Override // com.permission.z0
    public float g() throws Throwable {
        String strK = a1.k("ro.build.version.opporom");
        if (strK == null) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(strK.replace("v", "").replace("V", "").substring(0, 1));
        } catch (Exception e) {
            Log.e("Oppo", "get miui version code error, version : " + strK);
            Log.e("Oppo", Log.getStackTraceString(e));
            return -1.0f;
        }
    }
}
