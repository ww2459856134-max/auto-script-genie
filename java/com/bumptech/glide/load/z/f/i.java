package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class i extends f {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(com.bumptech.glide.load.n.a);

    @Override // com.bumptech.glide.load.n
    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // com.bumptech.glide.load.z.f.f
    protected Bitmap c(com.bumptech.glide.load.x.g1.g gVar, Bitmap bitmap, int i2, int i3) {
        return r0.b(gVar, bitmap, i2, i3);
    }

    @Override // com.bumptech.glide.load.n
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // com.bumptech.glide.load.n
    public int hashCode() {
        return -599754482;
    }
}
