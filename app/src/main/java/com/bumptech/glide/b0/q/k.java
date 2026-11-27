package com.bumptech.glide.b0.q;

/* loaded from: classes.dex */
class k extends l {
    private volatile boolean a;

    k() {
        super();
    }

    @Override // com.bumptech.glide.b0.q.l
    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.bumptech.glide.b0.q.l
    public void c() {
        if (this.a) {
            throw new IllegalStateException("Already released");
        }
    }
}
