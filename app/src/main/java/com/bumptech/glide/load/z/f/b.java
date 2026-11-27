package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.u<BitmapDrawable> {
    private final com.bumptech.glide.load.x.g1.g a;
    private final com.bumptech.glide.load.u<Bitmap> b;

    public b(com.bumptech.glide.load.x.g1.g gVar, com.bumptech.glide.load.u<Bitmap> uVar) {
        this.a = gVar;
        this.b = uVar;
    }

    @Override // com.bumptech.glide.load.u
    public com.bumptech.glide.load.c b(com.bumptech.glide.load.r rVar) {
        return this.b.b(rVar);
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(com.bumptech.glide.load.x.z0<BitmapDrawable> z0Var, File file, com.bumptech.glide.load.r rVar) {
        return this.b.a(new e(z0Var.get().getBitmap(), this.a), file, rVar);
    }
}
