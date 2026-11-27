package i.b.ha.a.b.f;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class c extends InputStream {
    private final long c;
    private ByteBuffer d;
    private long e;

    public c(long j2, long j3) {
        long j4 = j2 + j3;
        this.c = j4;
        if (j4 >= j2) {
            this.e = j2;
            return;
        }
        throw new IllegalArgumentException("Invalid length of stream at offset=" + j2 + ", length=" + j3);
    }

    protected abstract int a(long j2, ByteBuffer byteBuffer) throws IOException;

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.e >= this.c) {
            return -1;
        }
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            this.d = ByteBuffer.allocate(1);
        } else {
            byteBuffer.rewind();
        }
        if (a(this.e, this.d) < 1) {
            return -1;
        }
        this.e++;
        return this.d.get() & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.e;
        long j3 = this.c;
        if (j2 >= j3) {
            return -1;
        }
        long jMin = Math.min(i3, j3 - j2);
        if (jMin <= 0) {
            return 0;
        }
        if (i2 >= 0 && i2 <= bArr.length && jMin <= bArr.length - i2) {
            int iA = a(this.e, ByteBuffer.wrap(bArr, i2, (int) jMin));
            if (iA > 0) {
                this.e += iA;
            }
            return iA;
        }
        throw new IndexOutOfBoundsException("offset or len are out of bounds");
    }
}
