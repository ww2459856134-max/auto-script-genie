package i.b.ha.a.b.e.f;

import com.github.luben.zstd.ZstdInputStream;
import i.b.ha.a.b.f.h;
import i.b.ha.a.c.j.d;
import i.b.ha.a.c.j.e;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class a extends i.b.ha.a.b.e.a implements h {
    private final e d;
    private final ZstdInputStream e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(InputStream inputStream) throws IOException {
        e eVar = ((d) e.j().h(inputStream)).get();
        this.d = eVar;
        this.e = new ZstdInputStream(eVar);
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.d.m();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.e.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.e.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.e.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2 = this.e.read();
        d(i2 == -1 ? 0 : 1);
        return i2;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.e.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        return i.b.ha.a.c.e.p(this.e, j2);
    }

    public String toString() {
        return this.e.toString();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.e.read(bArr, i2, i3);
        d(i4);
        return i4;
    }
}
