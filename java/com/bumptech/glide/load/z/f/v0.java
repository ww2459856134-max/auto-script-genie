package com.bumptech.glide.load.z.f;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class v0 implements com.bumptech.glide.load.p<Integer> {
    private final ByteBuffer a = ByteBuffer.allocate(4);

    v0() {
    }

    @Override // com.bumptech.glide.load.p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.a) {
            this.a.position(0);
            messageDigest.update(this.a.putInt(num.intValue()).array());
        }
    }
}
