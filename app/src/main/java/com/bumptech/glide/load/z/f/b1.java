package com.bumptech.glide.load.z.f;

import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
final class b1 implements a1<ParcelFileDescriptor> {
    b1() {
    }

    @Override // com.bumptech.glide.load.z.f.a1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
        mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
    }
}
