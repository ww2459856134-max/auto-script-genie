package com.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

/* loaded from: classes.dex */
public class h0 extends z0 {
    @Override // com.permission.z0
    public void a() {
        Intent[] intentArr = {new Intent().setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity")), new Intent().setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.permission.PermissionMainActivity"))};
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                com.frame.v0.g().s(intentArr[i2]);
                return;
            } catch (Exception e) {
                com.frame.k0.r(e);
                try {
                    Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.putExtra("packageName", com.frame.v0.g().getPackageName());
                    com.frame.v0.g().s(intent);
                } catch (Exception unused) {
                    com.frame.k0.r(e);
                }
            }
        }
    }

    @Override // com.permission.z0
    public void b(Context context) {
        try {
            try {
                try {
                    Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
                    intent.putExtra("packageName", context.getPackageName());
                    intent.setFlags(268435456);
                    com.frame.v0.g().t(intent, x0.b.intValue());
                } catch (Exception unused) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        super.b(context);
                    }
                }
            } catch (Exception unused2) {
                Intent intent2 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent2.setClassName("com.meizu.safe", "com.meizu.safe.newpermission.ui.AdaptLegacyActivity");
                intent2.putExtra("packageName", context.getPackageName());
                intent2.setFlags(268435456);
                com.frame.v0.g().t(intent2, x0.b.intValue());
            }
        } catch (Exception e) {
            Toast.makeText(context, "请手动设置悬浮窗权限", 1).show();
            e.printStackTrace();
        }
    }

    @Override // com.permission.z0
    public float g() throws Throwable {
        try {
            String strK = a1.k("ro.build.version.emui");
            int iIndexOf = strK.indexOf("_");
            if (iIndexOf == -1) {
                iIndexOf = strK.indexOf(" ");
            }
            String strSubstring = strK.substring(iIndexOf + 1);
            if (strSubstring.contains("3.")) {
                return 3.1f;
            }
            return Float.parseFloat(strSubstring.trim());
        } catch (Exception e) {
            com.frame.k0.r(e);
            return 4.0f;
        }
    }
}
