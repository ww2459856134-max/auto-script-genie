package com.frame;

/* loaded from: classes.dex */
public abstract class n0 {
    public static boolean a(String str, boolean z) {
        return f1.f(v0.g(), "config", 0).getBoolean(str, z);
    }

    public static int b(String str) {
        return f1.f(v0.g(), "config", 0).getInt(str, 0);
    }

    public static int c(String str, int i2) {
        return f1.f(v0.g(), "config", 0).getInt(str, i2);
    }

    public static long d(String str, Long l2) {
        return f1.f(v0.g(), "config", 0).getLong(str, l2.longValue());
    }

    public static String e(String str) {
        return f1.f(v0.g(), "config", 0).getString(str, null);
    }

    public static String f(String str, String str2) {
        return f1.f(v0.g(), "config", 0).getString(str, str2);
    }

    public static void g(String str, boolean z) {
        f1.f(v0.g(), "config", 0).edit().putBoolean(str, z).apply();
    }

    public static void h(String str, float f) {
        f1.f(v0.g(), "config", 0).edit().putFloat(str, f).apply();
    }

    public static void i(String str, int i2) {
        f1.f(v0.g(), "config", 0).edit().putInt(str, i2).apply();
    }

    public static void j(String str, long j2) {
        f1.f(v0.g(), "config", 0).edit().putLong(str, j2).apply();
    }

    public static void k(String str, String str2) {
        f1.f(v0.g(), "config", 0).edit().putString(str, str2).apply();
    }
}
