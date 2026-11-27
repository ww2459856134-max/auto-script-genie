package com.bumptech.glide.load.x;

import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
class o0 implements com.bumptech.glide.load.n {
    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final com.bumptech.glide.load.n g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.v<?>> f629h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.r f630i;

    /* renamed from: j, reason: collision with root package name */
    private int f631j;

    o0(Object obj, com.bumptech.glide.load.n nVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.v<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.r rVar) {
        com.bumptech.glide.b0.n.d(obj);
        this.b = obj;
        com.bumptech.glide.b0.n.e(nVar, "Signature must not be null");
        this.g = nVar;
        this.c = i2;
        this.d = i3;
        com.bumptech.glide.b0.n.d(map);
        this.f629h = map;
        com.bumptech.glide.b0.n.e(cls, "Resource class must not be null");
        this.e = cls;
        com.bumptech.glide.b0.n.e(cls2, "Transcode class must not be null");
        this.f = cls2;
        com.bumptech.glide.b0.n.d(rVar);
        this.f630i = rVar;
    }

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.b.equals(o0Var.b) && this.g.equals(o0Var.g) && this.d == o0Var.d && this.c == o0Var.c && this.f629h.equals(o0Var.f629h) && this.e.equals(o0Var.e) && this.f.equals(o0Var.f) && this.f630i.equals(o0Var.f630i);
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        if (this.f631j == 0) {
            int iHashCode = this.b.hashCode();
            this.f631j = iHashCode;
            int iHashCode2 = (iHashCode * 31) + this.g.hashCode();
            this.f631j = iHashCode2;
            int i2 = (iHashCode2 * 31) + this.c;
            this.f631j = i2;
            int i3 = (i2 * 31) + this.d;
            this.f631j = i3;
            int iHashCode3 = (i3 * 31) + this.f629h.hashCode();
            this.f631j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.f631j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.f631j = iHashCode5;
            this.f631j = (iHashCode5 * 31) + this.f630i.hashCode();
        }
        return this.f631j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.f631j + ", transformations=" + this.f629h + ", options=" + this.f630i + '}';
    }
}
