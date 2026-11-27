package com.airbnb.lottie.y0;

import com.airbnb.lottie.h0;

/* loaded from: classes.dex */
public abstract class d {
    private static h0 a = new c();

    public static void a(String str) {
        a.debug(str);
    }

    public static void b(String str, Throwable th) {
        a.error(str, th);
    }

    public static void c(String str) {
        a.a(str);
    }

    public static void d(String str, Throwable th) {
        a.b(str, th);
    }
}
