package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class j extends f {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(com.bumptech.glide.load.n.a);

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // com.bumptech.glide.load.z.f.f
    protected Bitmap c(com.bumptech.glide.load.x.g1.g gVar, Bitmap bitmap, int i2, int i3) {
        return r0.c(gVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return -670243078;
    }
}
