package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
abstract class c extends OutputStream {
    private b<?> c;

    public c(b<?> bVar) {
        this.c = bVar;
    }

    protected void a() throws IOException {
        this.c.a();
    }

    public long c() {
        return this.c.d();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.c.write(bArr, i2, i3);
    }
}
