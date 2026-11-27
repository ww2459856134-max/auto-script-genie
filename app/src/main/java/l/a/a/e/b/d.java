package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class d extends OutputStream implements h {
    private OutputStream c;
    private long d = 0;

    public d(OutputStream outputStream) {
        this.c = outputStream;
    }

    @Override // l.a.a.e.b.h
    public long a() throws IOException {
        OutputStream outputStream = this.c;
        return outputStream instanceof i ? ((i) outputStream).a() : this.d;
    }

    @Override // l.a.a.e.b.h
    public int c() {
        if (m()) {
            return ((i) this.c).c();
        }
        return 0;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public boolean d(int i2) throws l.a.a.c.b {
        if (m()) {
            return ((i) this.c).d(i2);
        }
        return false;
    }

    public long f() throws IOException {
        OutputStream outputStream = this.c;
        return outputStream instanceof i ? ((i) outputStream).a() : this.d;
    }

    public long i() throws IOException {
        OutputStream outputStream = this.c;
        return outputStream instanceof i ? ((i) outputStream).a() : this.d;
    }

    public long j() {
        if (m()) {
            return ((i) this.c).f();
        }
        return 0L;
    }

    public boolean m() {
        OutputStream outputStream = this.c;
        return (outputStream instanceof i) && ((i) outputStream).m();
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
        this.d += i3;
    }
}
