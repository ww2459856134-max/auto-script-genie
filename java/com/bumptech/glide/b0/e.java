package com.bumptech.glide.b0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e extends FilterInputStream {
    private final long c;
    private int d;

    private e(InputStream inputStream, long j2) {
        super(inputStream);
        this.c = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.d += i2;
        } else if (this.c - this.d > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.c + ", but read: " + this.d);
        }
        return i2;
    }

    public static InputStream c(InputStream inputStream, long j2) {
        return new e(inputStream, j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.c - this.d, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        i4 = super.read(bArr, i2, i3);
        a(i4);
        return i4;
    }
}
