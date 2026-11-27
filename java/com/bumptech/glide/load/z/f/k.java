package com.bumptech.glide.load.z.f;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
final class k implements n {
    private final ByteBuffer a;

    k(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // com.bumptech.glide.load.z.f.n
    public int a() throws m {
        return (c() << 8) | c();
    }

    @Override // com.bumptech.glide.load.z.f.n
    public int b(byte[] bArr, int i2) {
        int iMin = Math.min(i2, this.a.remaining());
        if (iMin == 0) {
            return -1;
        }
        this.a.get(bArr, 0, iMin);
        return iMin;
    }

    @Override // com.bumptech.glide.load.z.f.n
    public short c() throws m {
        if (this.a.remaining() >= 1) {
            return (short) (this.a.get() & 255);
        }
        throw new m();
    }

    @Override // com.bumptech.glide.load.z.f.n
    public long skip(long j2) {
        int iMin = (int) Math.min(this.a.remaining(), j2);
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }
}
