package com.permission;

import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import java.util.Set;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
public class x0 {
    public static final Integer b = 10009;
    public static final Integer c = 10010;
    public static final Integer d = 10011;
    public static final Integer e = 10008;
    public static final Integer f = 10007;
    public static final Integer g = 10018;

    /* renamed from: h, reason: collision with root package name */
    public static final Integer f835h = 10020;

    /* renamed from: i, reason: collision with root package name */
    public static final Integer f836i = 10021;

    /* renamed from: j, reason: collision with root package name */
    public static final Integer f837j = 10022;

    /* renamed from: k, reason: collision with root package name */
    public static final Integer f838k = 10023;

    /* renamed from: l, reason: collision with root package name */
    private static x0 f839l;
    private w0 a;

    public static x0 m() {
        x0 x0Var = f839l;
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0();
        f839l = x0Var2;
        return x0Var2;
    }

    public void a() {
        try {
            com.frame.v0.g().t(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), c.intValue());
            w0 w0Var = this.a;
            if (w0Var != null) {
                w0Var.b();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void b() {
        a1.g().h().a();
        w0 w0Var = this.a;
        if (w0Var != null) {
            w0Var.f();
        }
    }

    public void c() {
        try {
            z0 z0VarH = a1.g().h();
            if (z0VarH instanceof i0) {
                ((i0) z0VarH).o(com.frame.v0.g());
            } else {
                i();
            }
            w0 w0Var = this.a;
            if (w0Var != null) {
                w0Var.c();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void d() {
        try {
            com.frame.v0.g().startActivity(new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + com.frame.v0.g().getPackageName())));
            w0 w0Var = this.a;
            if (w0Var != null) {
                w0Var.h();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void e() {
        try {
            z0 z0VarH = a1.g().h();
            if (z0VarH instanceof i0) {
                ((i0) z0VarH).o(com.frame.v0.g());
            } else {
                i();
            }
            w0 w0Var = this.a;
            if (w0Var != null) {
                w0Var.a();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void f() {
        a1.g().h().b(com.frame.v0.g());
        w0 w0Var = this.a;
        if (w0Var != null) {
            w0Var.d();
        }
    }

    public void g() {
        String packageName = com.frame.v0.g().getPackageName();
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            intent.putExtra("android.intent.extra.CHANNEL_ID", com.frame.v0.g().getApplicationInfo().uid);
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", com.frame.v0.g().getApplicationInfo().uid);
            if ("MI 6".equals(Build.MODEL)) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", packageName, null));
            }
            com.frame.v0.g().t(intent, f836i.intValue());
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            try {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", packageName, null));
                com.frame.v0.g().t(intent2, f836i.intValue());
            } catch (Exception e3) {
                com.frame.k0.r(e3);
            }
        }
    }

    public void h() {
        try {
            Intent intent = Build.VERSION.SDK_INT >= 22 ? new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS") : new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intent.addFlags(268435456);
            com.frame.v0.g().t(intent, g.intValue());
            w0 w0Var = this.a;
            if (w0Var != null) {
                w0Var.e();
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void i() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", com.frame.v0.g().getPackageName(), null));
            com.frame.v0.g().t(intent, f.intValue());
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void j() {
        WallpaperSetting.u();
        w0 w0Var = this.a;
        if (w0Var != null) {
            w0Var.g();
        }
    }

    public boolean k() {
        return com.frame.w0.d() || m().p();
    }

    public w0 l() {
        return this.a;
    }

    public boolean n() {
        AppOpsManager appOpsManager = (AppOpsManager) com.frame.v0.g().getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), com.frame.v0.g().getPackageName())).intValue() == 0;
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            return false;
        }
    }

    public boolean o() {
        return ((PowerManager) com.frame.v0.g().getSystemService("power")).isIgnoringBatteryOptimizations(com.frame.v0.g().getPackageName());
    }

    public boolean p() {
        try {
            return a1.g().h().d(com.frame.v0.g());
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            return true;
        }
    }

    public boolean q() {
        return androidx.core.app.p.b(com.frame.v0.g()).a();
    }

    public boolean r() {
        com.frame.v0 v0VarG = com.frame.v0.g();
        if (Settings.Secure.getString(v0VarG.getContentResolver(), "enabled_notification_listeners") != null) {
            return Settings.Secure.getString(v0VarG.getContentResolver(), "enabled_notification_listeners").contains(v0VarG.getPackageName());
        }
        Set<String> setC = androidx.core.app.p.c(v0VarG);
        if (!setC.isEmpty()) {
            return setC.contains(v0VarG.getPackageName());
        }
        if (com.frame.v0.f().getInt("already_readNotify", 0) == 1) {
            return true;
        }
        com.frame.v0.f().edit().putInt("already_readNotify", 1).apply();
        return false;
    }

    public void s(w0 w0Var) {
        this.a = w0Var;
    }
}
