package com.bumptech.glide.load;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class r implements n {
    private final h.d.b<q<?>, Object> b = new com.bumptech.glide.b0.d();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(q<T> qVar, Object obj, MessageDigest messageDigest) {
        qVar.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            f(this.b.i(i2), this.b.m(i2), messageDigest);
        }
    }

    public <T> T c(q<T> qVar) {
        return this.b.containsKey(qVar) ? (T) this.b.get(qVar) : qVar.c();
    }

    public void d(r rVar) {
        this.b.j(rVar.b);
    }

    public <T> r e(q<T> qVar, T t) {
        this.b.put(qVar, t);
        return this;
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.b.equals(((r) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }
}
