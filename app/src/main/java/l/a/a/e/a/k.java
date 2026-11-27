package l.a.a.e.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class k extends InputStream {
    private InputStream c;
    private long d = 0;
    private byte[] e = new byte[1];
    private long f;

    public k(InputStream inputStream, long j2) {
        this.c = inputStream;
        this.f = j2;
    }

    private int c(byte[] bArr, int i2) throws IOException {
        int length = bArr.length - i2;
        int i3 = 0;
        for (int i4 = 0; i2 < bArr.length && i3 != -1 && i4 < 15; i4++) {
            i3 += this.c.read(bArr, i2, length);
            if (i3 > 0) {
                i2 += i3;
                length -= i3;
            }
        }
        return i2;
    }

    public int a(byte[] bArr) throws IOException {
        int iC = this.c.read(bArr);
        if (iC == -1) {
            throw new IOException("Unexpected EOF reached when trying to read stream");
        }
        if (iC == bArr.length || (iC = c(bArr, iC)) == bArr.length) {
            return iC;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.e) == -1) {
            return -1;
        }
        return this.e[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.f;
        if (j2 != -1) {
            long j3 = this.d;
            if (j3 >= j2) {
                return -1;
            }
            if (i3 > j2 - j3) {
                i3 = (int) (j2 - j3);
            }
        }
        int i4 = this.c.read(bArr, i2, i3);
        if (i4 > 0) {
            this.d += i4;
        }
        return i4;
    }
}
