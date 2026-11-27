package com.bumptech.glide.u;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
class h implements Closeable {
    private final InputStream c;
    private final Charset d;
    private byte[] e;
    private int f;
    private int g;

    public h(InputStream inputStream, Charset charset) {
        this(inputStream, XMLEvent.ENTITY_REFERENCE, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.c;
        byte[] bArr = this.e;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f = 0;
        this.g = i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.c) {
            if (this.e != null) {
                this.e = null;
                this.c.close();
            }
        }
    }

    public boolean d() {
        return this.g == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String f() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.c) {
            if (this.e == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f >= this.g) {
                c();
            }
            for (int i4 = this.f; i4 != this.g; i4++) {
                byte[] bArr2 = this.e;
                if (bArr2[i4] == 10) {
                    if (i4 != this.f) {
                        i3 = i4 - 1;
                        if (bArr2[i3] != 13) {
                            i3 = i4;
                        }
                    }
                    byte[] bArr3 = this.e;
                    int i5 = this.f;
                    String str = new String(bArr3, i5, i3 - i5, this.d.name());
                    this.f = i4 + 1;
                    return str;
                }
            }
            g gVar = new g(this, (this.g - this.f) + 80);
            loop1: while (true) {
                byte[] bArr4 = this.e;
                int i6 = this.f;
                gVar.write(bArr4, i6, this.g - i6);
                this.g = -1;
                c();
                i2 = this.f;
                while (i2 != this.g) {
                    bArr = this.e;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i7 = this.f;
            if (i2 != i7) {
                gVar.write(bArr, i7, i2 - i7);
            }
            this.f = i2 + 1;
            return gVar.toString();
        }
    }

    public h(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(i.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.c = inputStream;
        this.d = charset;
        this.e = new byte[i2];
    }
}
