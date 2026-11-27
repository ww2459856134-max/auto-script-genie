package com.bumptech.glide.load.z.k;

import android.graphics.Bitmap;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.x.z0;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {
    private final Bitmap.CompressFormat a;
    private final int b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.z.k.e
    public z0<byte[]> a(z0<Bitmap> z0Var, r rVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        z0Var.get().compress(this.a, this.b, byteArrayOutputStream);
        z0Var.a();
        return new com.bumptech.glide.load.z.g.c(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.b = i2;
    }
}
