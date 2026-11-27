package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class i0 implements com.bumptech.glide.load.t<InputStream, Bitmap> {
    private final d a = new d();

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.x.z0<Bitmap> b(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return this.a.b(ImageDecoder.createSource(com.bumptech.glide.b0.c.b(inputStream)), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, com.bumptech.glide.load.r rVar) throws IOException {
        return true;
    }
}
