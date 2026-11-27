package l.a.a.e.a;

import java.io.IOException;
import java.io.InputStream;
import l.a.a.b.d;

/* loaded from: classes.dex */
abstract class b<T extends l.a.a.b.d> extends InputStream {
    private k c;
    private T d;
    private byte[] e;
    private byte[] f = new byte[1];

    public b(k kVar, l.a.a.f.j jVar, char[] cArr, int i2, boolean z) throws IOException {
        this.c = kVar;
        this.d = (T) i(jVar, cArr, z);
        if (l.a.a.i.i.i(jVar).equals(l.a.a.f.t.d.DEFLATE)) {
            this.e = new byte[i2];
        }
    }

    private void a(byte[] bArr, int i2) {
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
    }

    protected void c(InputStream inputStream, int i2) throws IOException {
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public T d() {
        return this.d;
    }

    public byte[] f() {
        return this.e;
    }

    protected abstract T i(l.a.a.f.j jVar, char[] cArr, boolean z) throws IOException;

    protected int j(byte[] bArr) throws IOException {
        return this.c.a(bArr);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f) == -1) {
            return -1;
        }
        return this.f[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int iM = l.a.a.i.i.m(this.c, bArr, i2, i3);
        if (iM > 0) {
            a(bArr, iM);
            this.d.a(bArr, i2, iM);
        }
        return iM;
    }
}
