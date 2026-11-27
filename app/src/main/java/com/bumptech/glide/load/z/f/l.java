package com.bumptech.glide.load.z.f;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
final class l {
    private final ByteBuffer a;

    l(byte[] bArr, int i2) {
        this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
    }

    private boolean c(int i2, int i3) {
        return this.a.remaining() - i2 >= i3;
    }

    short a(int i2) {
        if (c(i2, 2)) {
            return this.a.getShort(i2);
        }
        return (short) -1;
    }

    int b(int i2) {
        if (c(i2, 4)) {
            return this.a.getInt(i2);
        }
        return -1;
    }

    int d() {
        return this.a.remaining();
    }

    void e(ByteOrder byteOrder) {
        this.a.order(byteOrder);
    }
}
