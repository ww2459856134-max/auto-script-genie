package com.frame;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes.dex */
public class q0 implements Thread.UncaughtExceptionHandler {
    private static volatile q0 b;
    private Runnable a;

    private q0() {
    }

    public static q0 a() {
        if (b == null) {
            synchronized (q0.class) {
                if (b == null) {
                    b = new q0();
                }
            }
        }
        return b;
    }

    private String b() {
        try {
            Activity activityD = v0.g().d();
            return activityD != null ? activityD.getClass().getSimpleName() : "no act";
        } catch (Exception e) {
            k0.r(e);
            return "no act";
        }
    }

    private void c() {
        try {
            final Activity activityD = v0.g().d();
            if (activityD != null && "com.google.zxing.activity.CaptureActivity".equals(activityD.getClass().getName())) {
                activityD.runOnUiThread(new Runnable() { // from class: com.frame.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.f(activityD);
                    }
                });
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    private boolean e(Throwable th) {
        String className;
        loop0: while (true) {
            if (th == null) {
                return false;
            }
            String message = th.getMessage();
            if (message != null && message.contains("Crop rectangle does not fit within image data.")) {
                return true;
            }
            String name = th.getClass().getName();
            if (name != null && name.equals("java.lang.IllegalArgumentException")) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (stackTraceElement != null && (((className = stackTraceElement.getClassName()) != null && className.startsWith("com.google.zxing") && className.endsWith("PlanarYUVLuminanceSource")) || className.equals("d.f.b.n"))) {
                        break loop0;
                    }
                }
            }
            th = th.getCause();
        }
        return true;
    }

    static /* synthetic */ void f(Activity activity) {
        Toast.makeText(activity, "扫码预览区域计算异常，已退出本次扫码，请重试", 0).show();
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:27|3)|(3:29|4|5)|25|13|17|(1:19)|20|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x008f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0090, code lost:
    
        com.frame.k0.r(r8);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void h(Throwable th) throws Throwable {
        Runnable runnable;
        PrintWriter printWriter;
        Looper.prepare();
        PrintWriter printWriter2 = null;
        PrintWriter printWriter3 = null;
        try {
            try {
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(v0.g().getCacheDir(), "crash.txt"), true)));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused) {
        }
        try {
            PackageInfo packageInfo = v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append("===");
            sb.append(new Date());
            sb.append("|");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("|");
            sb.append(packageInfo.versionName);
            sb.append("|");
            sb.append(b());
            sb.append("|");
            sb.append(k0.a());
            printWriter.println(sb.toString());
            th.printStackTrace(printWriter);
            x0.g(printWriter);
            printWriter2 = sb;
        } catch (Exception unused2) {
            printWriter3 = printWriter;
            th.printStackTrace();
            x0.g(printWriter3);
            printWriter2 = printWriter3;
            y0.l(th);
            runnable = this.a;
            if (runnable != null) {
            }
            Looper.loop();
        } catch (Throwable th3) {
            th = th3;
            printWriter2 = printWriter;
            x0.g(printWriter2);
            throw th;
        }
        y0.l(th);
        runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
        Looper.loop();
    }

    static /* synthetic */ void i(File file) {
        String strV;
        try {
            strV = r0.v(file.getAbsolutePath());
        } catch (Exception e) {
            k0.r(e);
        }
        if (TextUtils.isEmpty(strV)) {
            return;
        }
        y0.o("上传crash日志");
        ArrayList<BasicNameValuePair> arrayListB = p0.h().b();
        arrayListB.add(new BasicNameValuePair("data", strV));
        p0.h().q(k0.f + "/uploadCrashData", arrayListB, null);
        try {
            r0.z(file.getAbsolutePath(), "", false);
            file.deleteOnExit();
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    public void d() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        if (v0.g().l()) {
            a().j();
        }
    }

    public void j() {
        final File file = new File(v0.g().getCacheDir(), "crash.txt");
        if (file.exists()) {
            new Thread(new Runnable() { // from class: com.frame.n
                @Override // java.lang.Runnable
                public final void run() {
                    q0.i(file);
                }
            }).start();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, final Throwable th) throws PendingIntent.CanceledException {
        if (e(th)) {
            c();
            return;
        }
        new Thread(new Runnable() { // from class: com.frame.m
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.c.h(th);
            }
        }).start();
        SystemClock.sleep(1000L);
        try {
            Process.killProcess(Process.myPid());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Intent intentC = i0.c(v0.g().getPackageName());
            intentC.setFlags(268435456);
            i0.e(0, intentC).send();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
