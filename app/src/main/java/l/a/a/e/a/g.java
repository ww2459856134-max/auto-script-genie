package l.a.a.e.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class g extends i {
    private RandomAccessFile c;

    public g(File file) throws IOException {
        this.c = new h(file, l.a.a.f.t.f.READ.a());
    }

    @Override // l.a.a.e.a.i
    public void a(l.a.a.f.i iVar) throws IOException {
        this.c.seek(iVar.Q());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.c.read();
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
