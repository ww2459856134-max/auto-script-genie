package com.bumptech.glide.load.w;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class c extends OutputStream {
    private final OutputStream c;
    private byte[] d;
    private com.bumptech.glide.load.x.g1.b e;
    private int f;

    public c(OutputStream outputStream, com.bumptech.glide.load.x.g1.b bVar) {
        this(outputStream, bVar, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private void a() throws IOException {
        int i2 = this.f;
        if (i2 > 0) {
            this.c.write(this.d, 0, i2);
            this.f = 0;
        }
    }

    private void c() throws IOException {
        if (this.f == this.d.length) {
            a();
        }
    }

    private void d() {
        byte[] bArr = this.d;
        if (bArr != null) {
            this.e.e(bArr);
            this.d = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.c.close();
            d();
        } catch (Throwable th) {
            this.c.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.c.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.d;
        int i3 = this.f;
        this.f = i3 + 1;
        bArr[i3] = (byte) i2;
        c();
    }

    c(OutputStream outputStream, com.bumptech.glide.load.x.g1.b bVar, int i2) {
        this.c = outputStream;
        this.e = bVar;
        this.d = (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f;
            if (i7 == 0 && i5 >= this.d.length) {
                this.c.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.d.length - i7);
            System.arraycopy(bArr, i6, this.d, this.f, iMin);
            this.f += iMin;
            i4 += iMin;
            c();
        } while (i4 < i3);
    }
}
