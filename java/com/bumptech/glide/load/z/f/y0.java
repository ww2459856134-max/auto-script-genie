package com.bumptech.glide.load.z.f;

import android.media.MediaMetadataRetriever;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class y0 implements a1<ByteBuffer> {
    y0() {
    }

    @Override // com.bumptech.glide.load.z.f.a1
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
        mediaMetadataRetriever.setDataSource(new x0(this, byteBuffer));
    }
}
