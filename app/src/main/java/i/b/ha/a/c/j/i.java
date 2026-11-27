package i.b.ha.a.c.j;

import i.b.ha.a.c.i.m;
import i.b.ha.a.c.i.o;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class i extends FilterInputStream {
    private volatile boolean c;
    private final o d;

    protected i(h<?, ?> hVar) throws IOException {
        this(hVar.l(), hVar);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (((FilterInputStream) this).in == null || l()) {
            return 0;
        }
        try {
            return ((FilterInputStream) this).in.available();
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        i.b.ha.a.c.e.g(((FilterInputStream) this).in, new m() { // from class: i.b.ha.a.c.j.a
            @Override // i.b.ha.a.c.i.m
            public final void accept(Object obj) throws IOException {
                this.a.i((IOException) obj);
                throw null;
            }
        });
        this.c = true;
    }

    protected void d(int i2) throws IOException {
        this.d.a(i2);
    }

    protected void f(int i2) throws IOException {
    }

    protected void i(IOException iOException) throws IOException {
        throw iOException;
    }

    boolean l() {
        return this.c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        if (((FilterInputStream) this).in != null) {
            ((FilterInputStream) this).in.mark(i2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in != null && ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = 1;
        try {
            f(1);
            int i3 = ((FilterInputStream) this).in.read();
            if (i3 == -1) {
                i2 = -1;
            }
            d(i2);
            return i3;
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return ((FilterInputStream) this).in.skip(j2);
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }

    public i(InputStream inputStream) {
        super(inputStream);
        this.d = o.a;
    }

    protected i(InputStream inputStream, h<?, ?> hVar) {
        super(inputStream);
        this.d = hVar.r() != null ? hVar.r() : o.a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            f(i.b.ha.a.c.e.m(bArr));
            int i2 = ((FilterInputStream) this).in.read(bArr);
            d(i2);
            return i2;
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            f(i3);
            int i4 = ((FilterInputStream) this).in.read(bArr, i2, i3);
            d(i4);
            return i4;
        } catch (IOException e) {
            i(e);
            throw null;
        }
    }
}
