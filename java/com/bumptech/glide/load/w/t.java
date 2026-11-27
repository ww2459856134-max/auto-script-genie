package com.bumptech.glide.load.w;

import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public final class t implements f<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.w.f
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.w.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g<ParcelFileDescriptor> b(ParcelFileDescriptor parcelFileDescriptor) {
        return new v(parcelFileDescriptor);
    }
}
