package com.airbnb.lottie.v0;

/* loaded from: classes.dex */
public class h {
    private static final h b = new h();
    private final h.d.g<String, com.airbnb.lottie.e> a = new h.d.g<>(20);

    h() {
    }

    public static h b() {
        return b;
    }

    public com.airbnb.lottie.e a(String str) {
        if (str == null) {
            return null;
        }
        return this.a.c(str);
    }

    public void c(String str, com.airbnb.lottie.e eVar) {
        if (str == null) {
            return;
        }
        this.a.d(str, eVar);
    }
}
