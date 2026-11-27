package l.a.a.e.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
abstract class c extends InputStream {
    private b<?> c;
    protected byte[] d = new byte[1];

    public c(b<?> bVar) {
        this.c = bVar;
    }

    public void a(InputStream inputStream, int i2) throws IOException {
        this.c.c(inputStream, i2);
    }

    protected byte[] c() {
        return this.c.f();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public int d(PushbackInputStream pushbackInputStream) throws IOException {
        return 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.d) == -1) {
            return -1;
        }
        return this.d[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.c.read(bArr, i2, i3);
    }
}
