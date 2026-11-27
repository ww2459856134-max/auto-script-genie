package com.bumptech.glide.load.z.k;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.x.z0;

/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {
    private final com.bumptech.glide.load.x.g1.g a;
    private final e<Bitmap, byte[]> b;
    private final e<com.bumptech.glide.load.z.j.f, byte[]> c;

    public c(com.bumptech.glide.load.x.g1.g gVar, e<Bitmap, byte[]> eVar, e<com.bumptech.glide.load.z.j.f, byte[]> eVar2) {
        this.a = gVar;
        this.b = eVar;
        this.c = eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static z0<com.bumptech.glide.load.z.j.f> b(z0<Drawable> z0Var) {
        return z0Var;
    }

    @Override // com.bumptech.glide.load.z.k.e
    public z0<byte[]> a(z0<Drawable> z0Var, r rVar) {
        Drawable drawable = z0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(com.bumptech.glide.load.z.f.e.e(((BitmapDrawable) drawable).getBitmap(), this.a), rVar);
        }
        if (!(drawable instanceof com.bumptech.glide.load.z.j.f)) {
            return null;
        }
        e<com.bumptech.glide.load.z.j.f, byte[]> eVar = this.c;
        b(z0Var);
        return eVar.a(z0Var, rVar);
    }
}
