package i.e.a.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class p extends InputStream {
    private final z c;
    private final InputStream d;
    private byte[] e;
    private int f;
    private final int g;

    public p(z zVar, InputStream inputStream, byte[] bArr, int i2, int i3) {
        this.c = zVar;
        this.d = inputStream;
        this.e = bArr;
        this.f = i2;
        this.g = i3;
    }

    private void a() {
        byte[] bArr = this.e;
        if (bArr != null) {
            this.e = null;
            z zVar = this.c;
            if (zVar != null) {
                zVar.x(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.e != null ? this.g - this.f : this.d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a();
        this.d.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        if (this.e == null) {
            this.d.mark(i2);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.e == null && this.d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.e;
        if (bArr == null) {
            return this.d.read();
        }
        int i2 = this.f;
        int i3 = i2 + 1;
        this.f = i3;
        int i4 = bArr[i2] & 255;
        if (i3 >= this.g) {
            a();
        }
        return i4;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.e == null) {
            this.d.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        long j3;
        if (this.e != null) {
            int i2 = this.g;
            int i3 = this.f;
            long j4 = i2 - i3;
            if (j4 > j2) {
                this.f = i3 + ((int) j2);
                return j2;
            }
            a();
            j3 = j4 + 0;
            j2 -= j4;
        } else {
            j3 = 0;
        }
        return j2 > 0 ? j3 + this.d.skip(j2) : j3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            int i4 = this.g;
            int i5 = this.f;
            int i6 = i4 - i5;
            if (i3 > i6) {
                i3 = i6;
            }
            System.arraycopy(bArr2, i5, bArr, i2, i3);
            int i7 = this.f + i3;
            this.f = i7;
            if (i7 >= this.g) {
                a();
            }
            return i3;
        }
        return this.d.read(bArr, i2, i3);
    }
}
