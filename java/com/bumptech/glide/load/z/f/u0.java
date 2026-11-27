package com.bumptech.glide.load.z.f;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class u0 implements com.bumptech.glide.load.p<Long> {
    private final ByteBuffer a = ByteBuffer.allocate(8);

    u0() {
    }

    @Override // com.bumptech.glide.load.p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(byte[] bArr, Long l2, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.a) {
            this.a.position(0);
            messageDigest.update(this.a.putLong(l2.longValue()).array());
        }
    }
}
