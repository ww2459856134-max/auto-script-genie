package com.bumptech.glide.a0;

import com.bumptech.glide.load.n;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class d implements n {
    private final Object b;

    public d(Object obj) {
        com.bumptech.glide.b0.n.d(obj);
        this.b = obj;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(n.a));
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.b.equals(((d) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
