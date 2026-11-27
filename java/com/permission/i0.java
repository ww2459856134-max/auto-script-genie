package com.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class i0 extends z0 {
    @Override // com.permission.z0
    public void a() {
        if (((int) g()) >= 8) {
            super.a();
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            com.frame.v0.g().t(intent, x0.f835h.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            try {
                Intent intent2 = new Intent("miui.intent.action.OP_AUTO_START");
                intent2.addCategory("android.intent.category.DEFAULT");
                com.frame.v0.g().startActivity(intent2);
            } catch (Exception unused) {
                com.frame.k0.r(e);
            }
        }
    }

    @Override // com.permission.z0
    public void b(Context context) {
        o(context);
    }

    @Override // com.permission.z0
    public float g() throws Throwable {
        String strK = a1.k("ro.miui.ui.version.name");
        if (strK == null) {
            return -1.0f;
        }
        try {
            return Integer.parseInt(strK.substring(1));
        } catch (Exception e) {
            Log.e("miui", "get miui version code error, version : " + strK);
            Log.e("miui", Log.getStackTraceString(e));
            return -1.0f;
        }
    }

    public void o(Context context) {
        try {
            int iG = (int) g();
            if (iG == -1) {
                s(context);
            } else if (iG == 5) {
                p(context);
            } else if (iG == 6) {
                q(context);
            } else if (iG == 7) {
                r(context);
            } else if (iG >= 8) {
                s(context);
            } else {
                Log.e("miui", "this is a special MIUI rom version, its version code " + iG);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            if (Build.VERSION.SDK_INT >= 23) {
                super.b(context);
            }
        }
    }

    public void p(Context context) {
        try {
            try {
                try {
                    String packageName = context.getPackageName();
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", packageName, null));
                    if (h(intent, context)) {
                        com.frame.v0.g().t(intent, x0.b.intValue());
                    } else {
                        Log.e("miui", "intent is not available!");
                    }
                } catch (Exception unused) {
                    s(context);
                }
            } catch (Exception unused2) {
                r(context);
            }
        } catch (Exception unused3) {
            q(context);
        }
    }

    public void q(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (h(intent, context)) {
            com.frame.v0.g().t(intent, x0.b.intValue());
        } else {
            Log.e("miui", "Intent is not available!");
        }
    }

    public void r(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (h(intent, context)) {
            com.frame.v0.g().t(intent, x0.b.intValue());
        } else {
            Log.e("miui", "Intent is not available!");
        }
    }

    public void s(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (h(intent, context)) {
            com.frame.v0.g().t(intent, x0.b.intValue());
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        if (h(intent2, context)) {
            com.frame.v0.g().t(intent2, x0.b.intValue());
        } else {
            Log.e("miui", "Intent is not available!");
        }
    }
}
