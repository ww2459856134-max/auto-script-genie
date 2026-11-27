package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.x.z0<Bitmap>, com.bumptech.glide.load.x.u0 {
    private final Bitmap c;
    private final com.bumptech.glide.load.x.g1.g d;

    public e(Bitmap bitmap, com.bumptech.glide.load.x.g1.g gVar) {
        com.bumptech.glide.b0.n.e(bitmap, "Bitmap must not be null");
        this.c = bitmap;
        com.bumptech.glide.b0.n.e(gVar, "BitmapPool must not be null");
        this.d = gVar;
    }

    public static e e(Bitmap bitmap, com.bumptech.glide.load.x.g1.g gVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, gVar);
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
        this.d.c(this.c);
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.x.u0
    public void c() {
        this.c.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.x.z0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return com.bumptech.glide.b0.p.g(this.c);
    }
}
