package i.b.ha.a.b.d;

import i.b.ha.a.c.c;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a<E> extends FilterInputStream {
    private final byte[] c;
    private long d;

    private a(InputStream inputStream, Charset charset) {
        super(inputStream);
        this.c = new byte[1];
        c.c(charset);
    }

    protected void d(int i2) {
        f(i2);
    }

    protected void f(long j2) {
        if (j2 != -1) {
            this.d += j2;
        }
    }

    public long i() {
        return this.d;
    }

    protected void j(long j2) {
        this.d -= j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (read(this.c, 0, 1) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
    }

    protected a(InputStream inputStream, String str) {
        this(inputStream, c.a(str));
    }
}
