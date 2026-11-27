package com.bumptech.glide.load.z.h;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.x.z0;

/* loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static z0<Drawable> e(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<Drawable> b() {
        return this.c.getClass();
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return Math.max(1, this.c.getIntrinsicWidth() * this.c.getIntrinsicHeight() * 4);
    }
}
