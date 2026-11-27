package com.bumptech.glide.load.z.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes.dex */
public final class j0 implements com.bumptech.glide.load.x.z0<BitmapDrawable>, com.bumptech.glide.load.x.u0 {
    private final Resources c;
    private final com.bumptech.glide.load.x.z0<Bitmap> d;

    private j0(Resources resources, com.bumptech.glide.load.x.z0<Bitmap> z0Var) {
        com.bumptech.glide.b0.n.d(resources);
        this.c = resources;
        com.bumptech.glide.b0.n.d(z0Var);
        this.d = z0Var;
    }

    public static com.bumptech.glide.load.x.z0<BitmapDrawable> e(Resources resources, com.bumptech.glide.load.x.z0<Bitmap> z0Var) {
        if (z0Var == null) {
            return null;
        }
        return new j0(resources, z0Var);
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
        this.d.a();
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.x.u0
    public void c() {
        com.bumptech.glide.load.x.z0<Bitmap> z0Var = this.d;
        if (z0Var instanceof com.bumptech.glide.load.x.u0) {
            ((com.bumptech.glide.load.x.u0) z0Var).c();
        }
    }

    @Override // com.bumptech.glide.load.x.z0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.c, this.d.get());
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return this.d.getSize();
    }
}
