package com.bumptech.glide.b0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class a extends InputStream {
    private final ByteBuffer c;
    private int d = -1;

    a(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.c.remaining();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.d = this.c.position();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.c.hasRemaining()) {
            return this.c.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        int i2 = this.d;
        if (i2 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.c.position(i2);
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        if (!this.c.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j2, available());
        this.c.position((int) (r0.position() + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.c.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i3, available());
        this.c.get(bArr, i2, iMin);
        return iMin;
    }
}
