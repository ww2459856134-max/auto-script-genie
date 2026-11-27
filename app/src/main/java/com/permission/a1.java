package com.permission;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class a1 {
    private static a1 c;
    private String a;
    private z0 b;

    private a1() {
        if (f()) {
            this.a = "vivo";
            this.b = new b1();
            return;
        }
        if (d()) {
            this.a = "miui";
            this.b = new i0();
            return;
        }
        if (c()) {
            this.a = "meizu";
            this.b = new h0();
            return;
        }
        if (b()) {
            this.a = "huawei";
            this.b = new g0();
        } else if (a()) {
            this.a = "qihu";
            this.b = new y0();
        } else if (e()) {
            this.a = "oppo";
            this.b = new n0();
        } else {
            this.b = new z0();
            this.a = "other";
        }
    }

    public static a1 g() {
        a1 a1Var = c;
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1Var2 = new a1();
        c = a1Var2;
        return a1Var2;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        Log.e("RomUtils", "Exception while closing InputStream", e);
                    }
                    return line;
                } catch (IOException e2) {
                    e = e2;
                    Log.e("RomUtils", "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            Log.e("RomUtils", "Exception while closing InputStream", e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        Log.e("RomUtils", "Exception while closing InputStream", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
    }

    public boolean a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.equals("360") || str.contains("qiku");
    }

    public boolean b() {
        String str = Build.MANUFACTURER;
        return str.contains("HUAWEI") || str.contains("HONOR");
    }

    public boolean c() throws Throwable {
        String strK = k("ro.build.display.id");
        if (TextUtils.isEmpty(strK)) {
            return false;
        }
        return strK.contains("flyme") || strK.toLowerCase().contains("flyme");
    }

    public boolean d() {
        return !TextUtils.isEmpty(k("ro.miui.ui.version.name"));
    }

    public boolean e() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public boolean f() {
        return Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains("vivo");
    }

    public z0 h() {
        return this.b;
    }

    public float i() {
        z0 z0Var = this.b;
        if (z0Var != null) {
            return z0Var.g();
        }
        return 0.0f;
    }

    public String j() {
        return this.a;
    }

    public boolean l() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            ClassLoader classLoader = cls.getClassLoader();
            System.out.println("classLoader: " + classLoader);
            if (classLoader == null || classLoader.getParent() != null) {
                return false;
            }
            return "harmony".equals(method.invoke(cls, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }
}
