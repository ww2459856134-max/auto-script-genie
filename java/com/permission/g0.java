package com.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

/* loaded from: classes.dex */
public class g0 extends z0 {
    @Override // com.permission.z0
    public void a() {
        if (a1.g().l()) {
            try {
                m(com.frame.v0.g(), new String[]{"com.huawei.systemmanager/com.huawei.systemmanager.mainscreen.MainScreenActivity"}, 0);
                return;
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        try {
            com.frame.v0.g().t(new Intent("huawei.intent.action.HSM_BOOTAPP_MANAGER"), x0.f835h.intValue());
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            Intent[] intentArr = {new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"))};
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    com.frame.v0.g().t(intentArr[i2], x0.f835h.intValue());
                    return;
                } catch (Exception e3) {
                    com.frame.k0.r(e3);
                }
            }
            super.a();
        }
    }

    @Override // com.permission.z0
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.b(context);
            return;
        }
        try {
            n(context, new String[]{"com.huawei.systemmanager/.addviewmonitor.AddViewMonitorActivity", "com.huawei.systemmanager/com.huawei.notificationmanager.ui.NotificationManagmentActivity", "com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity", "com.Android.settingsr/.permission.TabItem"}, 0, x0.b.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            Toast.makeText(context, "请手动设置悬浮窗权限", 1).show();
            if (Build.VERSION.SDK_INT >= 23) {
                super.b(context);
            }
        }
    }

    @Override // com.permission.z0
    public float g() {
        return 0.0f;
    }
}
