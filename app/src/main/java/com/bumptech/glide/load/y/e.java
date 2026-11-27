package com.bumptech.glide.load.y;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class e implements g<ByteBuffer> {
    e(f fVar) {
    }

    @Override // com.bumptech.glide.load.y.g
    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.y.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer b(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }
}
