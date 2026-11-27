package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class g0 implements r {
    private final com.bumptech.glide.load.x.h1.a a;
    private volatile com.bumptech.glide.load.x.h1.c b;

    g0(com.bumptech.glide.load.x.h1.a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.x.r
    public com.bumptech.glide.load.x.h1.c a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = this.a.a();
                }
                if (this.b == null) {
                    this.b = new com.bumptech.glide.load.x.h1.d();
                }
            }
        }
        return this.b;
    }
}
