package com.bumptech.glide.load.z.f;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class m0 extends FilterInputStream {
    private volatile byte[] c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.x.g1.b f648h;

    public m0(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar) {
        this(inputStream, bVar, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f;
        if (i2 != -1) {
            int i3 = this.g - i2;
            int i4 = this.e;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.d == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f648h.c(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.c = bArr2;
                    this.f648h.e(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.g - this.f;
                this.g = i5;
                this.f = 0;
                this.d = 0;
                int i6 = inputStream.read(bArr, i5, bArr.length - i5);
                int i7 = this.g;
                if (i6 > 0) {
                    i7 += i6;
                }
                this.d = i7;
                return i6;
            }
        }
        int i8 = inputStream.read(bArr);
        if (i8 > 0) {
            this.f = -1;
            this.g = 0;
            this.d = i8;
        }
        return i8;
    }

    private static IOException f() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.c == null || inputStream == null) {
            f();
            throw null;
        }
        return (this.d - this.g) + inputStream.available();
    }

    public synchronized void c() {
        this.e = this.c.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c != null) {
            this.f648h.e(this.c);
            this.c = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        if (this.c != null) {
            this.f648h.e(this.c);
            this.c = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.e = Math.max(this.e, i2);
        this.f = this.g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.c;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            f();
            throw null;
        }
        if (this.g >= this.d && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.c && (bArr = this.c) == null) {
            f();
            throw null;
        }
        int i2 = this.d;
        int i3 = this.g;
        if (i2 - i3 <= 0) {
            return -1;
        }
        this.g = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.c == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.f;
        if (-1 == i2) {
            throw new l0("Mark has been invalidated, pos: " + this.g + " markLimit: " + this.e);
        }
        this.g = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.c;
        if (bArr == null) {
            f();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            f();
            throw null;
        }
        int i2 = this.d;
        int i3 = this.g;
        if (i2 - i3 >= j2) {
            this.g = (int) (i3 + j2);
            return j2;
        }
        long j3 = i2 - i3;
        this.g = i2;
        if (this.f == -1 || j2 > this.e) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        int i4 = this.d;
        int i5 = this.g;
        if (i4 - i5 >= j2 - j3) {
            this.g = (int) ((i5 + j2) - j3);
            return j2;
        }
        long j4 = (j3 + i4) - i5;
        this.g = i4;
        return j4;
    }

    m0(InputStream inputStream, com.bumptech.glide.load.x.g1.b bVar, int i2) {
        super(inputStream);
        this.f = -1;
        this.f648h = bVar;
        this.c = (byte[]) bVar.c(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.c;
        if (bArr2 == null) {
            f();
            throw null;
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i6 = this.g;
            int i7 = this.d;
            if (i6 < i7) {
                int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                System.arraycopy(bArr2, i6, bArr, i2, i8);
                this.g += i8;
                if (i8 == i3 || inputStream.available() == 0) {
                    return i8;
                }
                i2 += i8;
                i4 = i3 - i8;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.c && (bArr2 = this.c) == null) {
                        f();
                        throw null;
                    }
                    int i9 = this.d;
                    int i10 = this.g;
                    i5 = i9 - i10 >= i4 ? i4 : i9 - i10;
                    System.arraycopy(bArr2, i10, bArr, i2, i5);
                    this.g += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            f();
            throw null;
        }
    }
}
