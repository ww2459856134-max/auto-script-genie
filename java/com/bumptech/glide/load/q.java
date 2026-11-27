package com.bumptech.glide.load;

import com.auto.exceldeps.log4j.util.Chars;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class q<T> {
    private static final p<Object> e = new o();
    private final T a;
    private final p<T> b;
    private final String c;
    private volatile byte[] d;

    private q(String str, T t, p<T> pVar) {
        com.bumptech.glide.b0.n.b(str);
        this.c = str;
        this.a = t;
        com.bumptech.glide.b0.n.d(pVar);
        this.b = pVar;
    }

    public static <T> q<T> a(String str, T t, p<T> pVar) {
        return new q<>(str, t, pVar);
    }

    private static <T> p<T> b() {
        return (p<T>) e;
    }

    private byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(n.a);
        }
        return this.d;
    }

    public static <T> q<T> e(String str) {
        return new q<>(str, null, b());
    }

    public static <T> q<T> f(String str, T t) {
        return new q<>(str, t, b());
    }

    public T c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.c.equals(((q) obj).c);
        }
        return false;
    }

    public void g(T t, MessageDigest messageDigest) {
        this.b.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + Chars.QUOTE + '}';
    }
}
