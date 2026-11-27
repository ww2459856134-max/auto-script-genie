package com.frame;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class k0 {
    private static k0 c = null;
    public static String d = "";
    public static String e = "";
    public static String f = "https://api1.skyingidea.com/api_v1";
    public static String g = "https://api.skyingidea.com/api_v1";
    private int a;
    private int b;

    public k0() {
        new HashMap();
    }

    public static String a() {
        return Build.BRAND;
    }

    public static long b() {
        long jD = n0.d("gfit", 0L);
        if (jD != 0) {
            return jD;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        n0.j("gfit", jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public static k0 c() {
        k0 k0Var = c;
        if (k0Var != null) {
            return k0Var;
        }
        k0 k0Var2 = new k0();
        c = k0Var2;
        return k0Var2;
    }

    public static void f() {
    }

    public static boolean g(Context context) {
        return true;
    }

    public static void i(String str) {
        y0.g(str);
    }

    public static void j(Activity activity) {
    }

    public static void k(Activity activity) {
    }

    public static <T> T l(String str, Class<T> cls) {
        return (T) m("app_data", str, cls);
    }

    public static <T> T m(String str, String str2, Class<T> cls) {
        String strD;
        T t;
        Gson gson = new Gson();
        f1 f1VarF = f1.f(v0.g(), str, 0);
        try {
            if (f1VarF.g().contains(str2)) {
                try {
                    String strB = n1.b(f1VarF.g().getString(str2, null));
                    if (!TextUtils.isEmpty(strB)) {
                        T t2 = (T) gson.j(strB, cls);
                        if (t2 != null) {
                            return t2;
                        }
                    }
                } catch (Exception e2) {
                    r(e2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        for (byte[] bArr : n1.d) {
            try {
                String strJ = f1VarF.j(str2, bArr);
                if (strJ != null && f1VarF.g().contains(strJ)) {
                    String string = f1VarF.g().getString(strJ, null);
                    if (TextUtils.isEmpty(string)) {
                        continue;
                    } else {
                        for (byte[] bArr2 : n1.d) {
                            try {
                                strD = n1.d(string, bArr2);
                            } catch (Exception e4) {
                                r(e4);
                            }
                            if (!TextUtils.isEmpty(strD) && (t = (T) gson.j(strD, cls)) != null) {
                                return t;
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                r(e5);
            }
        }
        return null;
    }

    public static <T> T n(String str, Class<T> cls, Class cls2) {
        return (T) o("app_data", str, cls, cls2);
    }

    public static <T> T o(String str, String str2, Class<T> cls, Class cls2) {
        String strD;
        T t;
        Gson gson = new Gson();
        f1 f1VarF = f1.f(v0.g(), str, 0);
        try {
            if (f1VarF.g().contains(str2)) {
                String string = f1VarF.g().getString(str2, null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        String strB = n1.b(string);
                        if (!TextUtils.isEmpty(strB)) {
                            T t2 = (T) gson.k(strB, com.google.gson.k0.a.c(cls, cls2).e());
                            if (t2 != null) {
                                return t2;
                            }
                        }
                    } catch (Exception e2) {
                        r(e2);
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        for (byte[] bArr : n1.d) {
            try {
                String strJ = f1VarF.j(str2, bArr);
                if (strJ != null && f1VarF.g().contains(strJ)) {
                    String string2 = f1VarF.g().getString(strJ, null);
                    if (TextUtils.isEmpty(string2)) {
                        continue;
                    } else {
                        for (byte[] bArr2 : n1.d) {
                            try {
                                strD = n1.d(string2, bArr2);
                            } catch (Exception e4) {
                                r(e4);
                            }
                            if (!TextUtils.isEmpty(strD) && (t = (T) gson.k(strD, com.google.gson.k0.a.c(cls, cls2).e())) != null) {
                                return t;
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                r(e5);
            }
        }
        return null;
    }

    public static final void q(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            v0.g().unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
        v0.g().registerReceiver(broadcastReceiver, intentFilter, v0.g().getPackageName() + ".permission", null);
    }

    public static void r(Throwable th) {
        th.printStackTrace();
    }

    public static final void s(Intent intent) {
        v0.g().sendOrderedBroadcast(intent, v0.g().getPackageName() + ".permission");
    }

    public static final void t(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.TEXT", str2);
            activity.startActivity(Intent.createChooser(intent, "邀请好友"));
        } catch (Exception e2) {
            r(e2);
        }
    }

    public static final void u(final Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType(r0.h(uri.getPath()));
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            l1.e(new Runnable() { // from class: com.frame.k
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(activity, "未找到可以处理的应用", 0).show();
                }
            });
            return;
        }
        try {
            activity.startActivity(intent);
        } catch (Exception unused) {
            intent.setData(uri);
            activity.startActivity(intent);
        }
    }

    public int d() {
        int i2 = this.b;
        return i2 == 0 ? q1.i() : i2;
    }

    public int e() {
        int i2 = this.a;
        return i2 == 0 ? q1.k() : i2;
    }

    public final void p(String str) throws IllegalStateException, IOException, IllegalArgumentException {
        try {
            AssetFileDescriptor assetFileDescriptorOpenFd = v0.g().getAssets().openFd(str);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e2) {
            r(e2);
        }
    }

    public void v(int i2) {
        this.b = i2;
    }

    public void w(int i2) {
        this.a = i2;
    }

    public void x(Class<? extends Service> cls) {
    }
}
