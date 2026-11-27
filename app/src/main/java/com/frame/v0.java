package com.frame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class v0 extends Application {
    public static boolean f = true;

    @SuppressLint({"StaticFieldLeak"})
    private static v0 g;
    private boolean c;
    private WeakReference<Activity> d;
    private boolean e;

    private void c(Activity activity) {
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService("activity");
            List<ActivityManager.AppTask> appTasks = activityManager == null ? null : activityManager.getAppTasks();
            if (appTasks != null && !appTasks.isEmpty()) {
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().finishAndRemoveTask();
                    } catch (RuntimeException e) {
                        Log.w("FrameApp", "remove app task failed", e);
                    }
                }
                return;
            }
            activity.finishAffinity();
        } catch (RuntimeException e2) {
            Log.w("FrameApp", "enumerate app tasks failed", e2);
            activity.finishAffinity();
        }
    }

    public static SharedPreferences e() {
        return f1.f(g, "app_data", 0);
    }

    public static SharedPreferences f() {
        return f1.f(g, "app_config", 0);
    }

    public static v0 g() {
        return g;
    }

    public static SharedPreferences i() {
        return f1.f(g, "app_params", 0);
    }

    static /* synthetic */ void n() {
        SharedPreferences sharedPreferencesF = f();
        sharedPreferencesF.edit().putInt("launchNum", sharedPreferencesF.getInt("launchNum", 0) + 1).apply();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void b() {
        l1.g(new Runnable() { // from class: com.frame.u
            @Override // java.lang.Runnable
            public final void run() {
                v0.n();
            }
        });
    }

    public Activity d() {
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int h() {
        return f().getInt("launchNum", 0);
    }

    public boolean j() {
        return f().getInt("alc", 0) != 0;
    }

    public boolean k() {
        return this.e;
    }

    public boolean l() {
        if (!this.c) {
            boolean z = f().getInt("privacy_code", 0) == 1;
            this.c = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public boolean m() {
        return !l();
    }

    public void o(Activity activity) {
        q(true);
        this.d = new WeakReference<>(activity);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        g = this;
        if (f && g().l()) {
            try {
                q0.a().d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Resources resources = super.getResources();
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception e2) {
            k0.r(e2);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            registerActivityLifecycleCallbacks(new u0(this));
        }
    }

    public void p(int i2) {
        f().edit().putInt("alc", i2).apply();
    }

    public void q(boolean z) {
        this.e = z;
    }

    public void r(int i2) {
        if (i2 != 1) {
            this.c = false;
        }
        f().edit().putInt("privacy_code", i2).apply();
    }

    public void s(Intent intent) {
        t(intent, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Activity activityD = d();
        if (activityD == null) {
            u(intent);
            return;
        }
        if (intent.getComponent() != null) {
            Log.e("startActivity", intent.getComponent().toShortString());
        }
        activityD.startActivity(intent);
    }

    public void t(Intent intent, int i2) {
        Activity activityD = d();
        if (activityD != null) {
            activityD.startActivityForResult(intent, i2);
            return;
        }
        Log.e("startActivityForResult", "startActivityForResult: FLAG_ACTIVITY_NEW_TASK");
        intent.addFlags(268435456);
        super.startActivity(intent);
    }

    public void u(Intent intent) {
        if (intent.getComponent() != null) {
            Log.e("startActivity", intent.getComponent().toShortString() + "---FLAG_ACTIVITY_NEW_TASK");
        }
        intent.addFlags(268435456);
        super.startActivity(intent);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x008e: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:46:0x008e */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(Activity activity) throws Throwable {
        boolean z;
        RuntimeException e;
        boolean zW;
        String str = "撤回成功，请重新打开应用";
        if (activity == null) {
            return;
        }
        Intent launchIntentForPackage = null;
        boolean z2 = false;
        try {
            try {
                try {
                    launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                } catch (Throwable th) {
                    th = th;
                    if (z2) {
                        Process.killProcess(Process.myPid());
                    }
                    throw th;
                }
            } catch (RuntimeException e2) {
                try {
                    Log.w("FrameApp", "resolve privacy entry failed", e2);
                } catch (RuntimeException e3) {
                    e = e3;
                    zW = false;
                    Log.w("FrameApp", "restart after privacy withdrawal failed", e);
                    if (zW) {
                        str = "撤回未完成，请重试";
                    }
                    Toast.makeText(this, str, 0).show();
                    if (!zW) {
                        return;
                    }
                    Process.killProcess(Process.myPid());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                c(activity);
            } else {
                activity.finishAffinity();
            }
            zW = w();
            try {
            } catch (RuntimeException e4) {
                e = e4;
                Log.w("FrameApp", "restart after privacy withdrawal failed", e);
                if (zW) {
                }
                Toast.makeText(this, str, 0).show();
                if (!zW) {
                }
                Process.killProcess(Process.myPid());
            }
            if (!zW) {
                Toast.makeText(activity, "保存失败，请重试", 0).show();
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(268435456);
                    startActivity(launchIntentForPackage);
                }
                if (zW) {
                    Process.killProcess(Process.myPid());
                    return;
                }
                return;
            }
            if (launchIntentForPackage == null) {
                Toast.makeText(this, "撤回成功，请重新打开应用", 0).show();
                if (zW) {
                    Process.killProcess(Process.myPid());
                    return;
                }
                return;
            }
            launchIntentForPackage.addFlags(268468224);
            startActivity(launchIntentForPackage);
            if (!zW) {
                return;
            }
            Process.killProcess(Process.myPid());
        } catch (Throwable th2) {
            th = th2;
            z2 = z;
        }
    }

    public boolean w() {
        this.c = false;
        return f().edit().putInt("privacy_code", 0).commit();
    }
}
