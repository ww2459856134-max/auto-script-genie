package com.bumptech.glide.load.x;

import com.auto.exceldeps.log4j.util.Chars;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class b1 implements com.bumptech.glide.load.n {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bumptech.glide.b0.k<Class<?>, byte[]> f600j = new com.bumptech.glide.b0.k<>(50);
    private final com.bumptech.glide.load.x.g1.b b;
    private final com.bumptech.glide.load.n c;
    private final com.bumptech.glide.load.n d;
    private final int e;
    private final int f;
    private final Class<?> g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.r f601h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.v<?> f602i;

    b1(com.bumptech.glide.load.x.g1.b bVar, com.bumptech.glide.load.n nVar, com.bumptech.glide.load.n nVar2, int i2, int i3, com.bumptech.glide.load.v<?> vVar, Class<?> cls, com.bumptech.glide.load.r rVar) {
        this.b = bVar;
        this.c = nVar;
        this.d = nVar2;
        this.e = i2;
        this.f = i3;
        this.f602i = vVar;
        this.g = cls;
        this.f601h = rVar;
    }

    private byte[] c() {
        com.bumptech.glide.b0.k<Class<?>, byte[]> kVar = f600j;
        byte[] bArrG = kVar.g(this.g);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.g.getName().getBytes(com.bumptech.glide.load.n.a);
        kVar.k(this.g, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.v<?> vVar = this.f602i;
        if (vVar != null) {
            vVar.b(messageDigest);
        }
        this.f601h.b(messageDigest);
        messageDigest.update(c());
        this.b.e(bArr);
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return this.f == b1Var.f && this.e == b1Var.e && com.bumptech.glide.b0.p.c(this.f602i, b1Var.f602i) && this.g.equals(b1Var.g) && this.c.equals(b1Var.c) && this.d.equals(b1Var.d) && this.f601h.equals(b1Var.f601h);
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        com.bumptech.glide.load.v<?> vVar = this.f602i;
        if (vVar != null) {
            iHashCode = (iHashCode * 31) + vVar.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.f601h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.f602i + Chars.QUOTE + ", options=" + this.f601h + '}';
    }
}
