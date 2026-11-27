package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.t<ByteBuffer, Bitmap> {
    private final y a;

    public g(y yVar) {
        this.a = yVar;
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.x.z0<Bitmap> b(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return this.a.f(com.bumptech.glide.b0.c.f(byteBuffer), i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.r rVar) {
        return this.a.q(byteBuffer);
    }
}
