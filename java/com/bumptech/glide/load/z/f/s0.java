package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
final class s0 implements com.bumptech.glide.load.x.z0<Bitmap> {
    private final Bitmap c;

    s0(Bitmap bitmap) {
        this.c = bitmap;
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.x.z0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return com.bumptech.glide.b0.p.g(this.c);
    }
}
