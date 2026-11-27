package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
class k extends OutputStream {
    private OutputStream d;
    private long c = 0;
    private boolean e = false;

    public k(OutputStream outputStream) {
        this.d = outputStream;
    }

    public void a() throws IOException {
        this.e = true;
    }

    public long c() {
        return this.c;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
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
        if (!this.e) {
            this.d.write(bArr, i2, i3);
            this.c += i3;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }
}
