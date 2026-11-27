package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes.dex */
public class n0 implements com.bumptech.glide.load.t<Uri, Bitmap> {
    private final com.bumptech.glide.load.z.h.d a;
    private final com.bumptech.glide.load.x.g1.g b;

    public n0(com.bumptech.glide.load.z.h.d dVar, com.bumptech.glide.load.x.g1.g gVar) {
        this.a = dVar;
        this.b = gVar;
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.x.z0<Bitmap> b(Uri uri, int i2, int i3, com.bumptech.glide.load.r rVar) {
        com.bumptech.glide.load.x.z0<Drawable> z0VarB = this.a.b(uri, i2, i3, rVar);
        if (z0VarB == null) {
            return null;
        }
        return a0.a(this.b, z0VarB.get(), i2, i3);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, com.bumptech.glide.load.r rVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
