package com.bumptech.glide.load.z.f;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;

/* loaded from: classes.dex */
final class w0 implements a1<AssetFileDescriptor> {
    private w0() {
    }

    @Override // com.bumptech.glide.load.z.f.a1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
    }

    /* synthetic */ w0(u0 u0Var) {
        this();
    }
}
