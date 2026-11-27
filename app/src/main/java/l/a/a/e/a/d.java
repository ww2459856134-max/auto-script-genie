package l.a.a.e.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class d extends c {
    private Inflater e;
    private byte[] f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f2206h;

    public d(b<?> bVar, int i2) {
        super(bVar);
        this.g = new byte[1];
        this.e = new Inflater(true);
        this.f = new byte[i2];
    }

    private void f() throws IOException {
        byte[] bArr = this.f;
        int i2 = super.read(bArr, 0, bArr.length);
        this.f2206h = i2;
        if (i2 == -1) {
            throw new EOFException("Unexpected end of input stream");
        }
        this.e.setInput(this.f, 0, i2);
    }

    @Override // l.a.a.e.a.c
    public void a(InputStream inputStream, int i2) throws IOException {
        Inflater inflater = this.e;
        if (inflater != null) {
            inflater.end();
            this.e = null;
        }
        super.a(inputStream, i2);
    }

    @Override // l.a.a.e.a.c, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Inflater inflater = this.e;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    @Override // l.a.a.e.a.c
    public int d(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.e.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(c(), this.f2206h - remaining, remaining);
        }
        return remaining;
    }

    @Override // l.a.a.e.a.c, java.io.InputStream
    public int read() throws IOException {
        if (read(this.g) == -1) {
            return -1;
        }
        return this.g[0];
    }

    @Override // l.a.a.e.a.c, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // l.a.a.e.a.c, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws DataFormatException, IOException {
        while (true) {
            try {
                int iInflate = this.e.inflate(bArr, i2, i3);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (!this.e.finished() && !this.e.needsDictionary()) {
                    if (this.e.needsInput()) {
                        f();
                    }
                }
                return -1;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }
}
