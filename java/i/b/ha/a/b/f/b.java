package i.b.ha.a.b.f;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b implements Closeable {
    private static final long[] g = new long[64];
    private final i.b.ha.a.c.j.e c;
    private final ByteOrder d;
    private long e;
    private int f;

    static {
        for (int i2 = 1; i2 <= 63; i2++) {
            long[] jArr = g;
            jArr[i2] = (jArr[i2 - 1] << 1) + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(InputStream inputStream, ByteOrder byteOrder) {
        this.c = ((i.b.ha.a.c.j.d) i.b.ha.a.c.j.e.j().h(inputStream)).a().get();
        this.d = byteOrder;
    }

    private boolean i(int i2) throws IOException {
        while (true) {
            int i3 = this.f;
            if (i3 >= i2 || i3 >= 57) {
                return false;
            }
            long j2 = this.c.read();
            if (j2 < 0) {
                return true;
            }
            if (this.d == ByteOrder.LITTLE_ENDIAN) {
                this.e = (j2 << this.f) | this.e;
            } else {
                long j3 = this.e << 8;
                this.e = j3;
                this.e = j2 | j3;
            }
            this.f += 8;
        }
    }

    private long m(int i2) throws IOException {
        long j2;
        int i3 = i2 - this.f;
        int i4 = 8 - i3;
        long j3 = this.c.read();
        if (j3 < 0) {
            return j3;
        }
        if (this.d == ByteOrder.LITTLE_ENDIAN) {
            long[] jArr = g;
            this.e = ((jArr[i3] & j3) << this.f) | this.e;
            j2 = (j3 >>> i3) & jArr[i4];
        } else {
            long j4 = this.e << i3;
            this.e = j4;
            long[] jArr2 = g;
            this.e = j4 | ((j3 >>> i4) & jArr2[i3]);
            j2 = j3 & jArr2[i4];
        }
        long j5 = this.e & g[i2];
        this.e = j2;
        this.f = i4;
        return j5;
    }

    private long p(int i2) {
        long j2;
        if (this.d == ByteOrder.LITTLE_ENDIAN) {
            long j3 = this.e;
            j2 = j3 & g[i2];
            this.e = j3 >>> i2;
        } else {
            j2 = (this.e >> (this.f - i2)) & g[i2];
        }
        this.f -= i2;
        return j2;
    }

    public void a() {
        int i2 = this.f % 8;
        if (i2 > 0) {
            p(i2);
        }
    }

    public long c() throws IOException {
        return this.f + (this.c.available() * 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public int d() {
        return this.f;
    }

    public void f() {
        this.e = 0L;
        this.f = 0;
    }

    public long j() {
        return this.c.m();
    }

    public int n() throws IOException {
        return (int) o(1);
    }

    public long o(int i2) throws IOException {
        if (i2 < 0 || i2 > 63) {
            throw new IOException("count must not be negative or greater than 63");
        }
        if (i(i2)) {
            return -1L;
        }
        return this.f < i2 ? m(i2) : p(i2);
    }
}
