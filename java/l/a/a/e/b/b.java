package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;
import l.a.a.b.e;
import l.a.a.f.s;

/* loaded from: classes.dex */
abstract class b<T extends l.a.a.b.e> extends OutputStream {
    private k c;
    private T d;

    public b(k kVar, s sVar, char[] cArr, boolean z) throws IOException {
        this.c = kVar;
        this.d = (T) f(kVar, sVar, cArr, z);
    }

    public void a() throws IOException {
        this.c.a();
    }

    protected T c() {
        return this.d;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public long d() {
        return this.c.c();
    }

    protected abstract T f(OutputStream outputStream, s sVar, char[] cArr, boolean z) throws IOException;

    public void i(byte[] bArr) throws IOException {
        this.c.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.c.write(i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.c.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.d.a(bArr, i2, i3);
        this.c.write(bArr, i2, i3);
    }
}
