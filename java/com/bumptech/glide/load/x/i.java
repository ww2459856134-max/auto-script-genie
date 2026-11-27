package com.bumptech.glide.load.x;

import java.security.MessageDigest;

/* loaded from: classes.dex */
final class i implements com.bumptech.glide.load.n {
    private final com.bumptech.glide.load.n b;
    private final com.bumptech.glide.load.n c;

    i(com.bumptech.glide.load.n nVar, com.bumptech.glide.load.n nVar2) {
        this.b = nVar;
        this.c = nVar2;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.b.equals(iVar.b) && this.c.equals(iVar.c);
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
