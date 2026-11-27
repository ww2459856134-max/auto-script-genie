package com.bumptech.glide.load.y;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
public class c0 implements com.bumptech.glide.load.n {
    private final d0 b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f641h;

    public c0(URL url) {
        this(url, d0.a);
    }

    private byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(com.bumptech.glide.load.n.a);
        }
        return this.g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.e)) {
            String string = this.d;
            if (TextUtils.isEmpty(string)) {
                URL url = this.c;
                com.bumptech.glide.b0.n.d(url);
                string = url.toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private URL g() throws MalformedURLException {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.c;
        com.bumptech.glide.b0.n.d(url);
        return url.toString();
    }

    public Map<String, String> e() {
        return this.b.getHeaders();
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return c().equals(c0Var.c()) && this.b.equals(c0Var.b);
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        if (this.f641h == 0) {
            int iHashCode = c().hashCode();
            this.f641h = iHashCode;
            this.f641h = (iHashCode * 31) + this.b.hashCode();
        }
        return this.f641h;
    }

    public String toString() {
        return c();
    }

    public c0(String str) {
        this(str, d0.a);
    }

    public c0(URL url, d0 d0Var) {
        com.bumptech.glide.b0.n.d(url);
        this.c = url;
        this.d = null;
        com.bumptech.glide.b0.n.d(d0Var);
        this.b = d0Var;
    }

    public c0(String str, d0 d0Var) {
        this.c = null;
        com.bumptech.glide.b0.n.b(str);
        this.d = str;
        com.bumptech.glide.b0.n.d(d0Var);
        this.b = d0Var;
    }
}
