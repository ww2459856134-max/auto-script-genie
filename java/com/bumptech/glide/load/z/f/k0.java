package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public final class k0 implements com.bumptech.glide.load.t<ParcelFileDescriptor, Bitmap> {
    private final y a;

    public k0(y yVar) {
        this.a = yVar;
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.x.z0<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.bumptech.glide.load.r rVar) throws IOException {
        return this.a.d(parcelFileDescriptor, i2, i3, rVar);
    }

    @Override // com.bumptech.glide.load.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.r rVar) {
        return this.a.o(parcelFileDescriptor);
    }
}
