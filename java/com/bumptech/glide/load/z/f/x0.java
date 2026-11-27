package com.bumptech.glide.load.z.f;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class x0 extends MediaDataSource {
    final /* synthetic */ ByteBuffer c;

    x0(y0 y0Var, ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.c.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        if (j2 >= this.c.limit()) {
            return -1;
        }
        this.c.position((int) j2);
        int iMin = Math.min(i3, this.c.remaining());
        this.c.get(bArr, i2, iMin);
        return iMin;
    }
}
