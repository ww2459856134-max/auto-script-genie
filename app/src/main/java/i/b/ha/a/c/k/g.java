package i.b.ha.a.c.k;

import i.b.ha.a.c.i.m;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class g extends FilterOutputStream {
    public g(OutputStream outputStream) {
        super(outputStream);
    }

    protected void a(int i2) throws IOException {
    }

    protected abstract void c(int i2) throws IOException;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        i.b.ha.a.c.e.g(((FilterOutputStream) this).out, new m() { // from class: i.b.ha.a.c.k.c
            @Override // i.b.ha.a.c.i.m
            public final void accept(Object obj) throws IOException {
                this.a.d((IOException) obj);
                throw null;
            }
        });
    }

    protected void d(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException e) {
            d(e);
            throw null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            int iM = i.b.ha.a.c.e.m(bArr);
            c(iM);
            ((FilterOutputStream) this).out.write(bArr);
            a(iM);
        } catch (IOException e) {
            d(e);
            throw null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        try {
            c(i3);
            ((FilterOutputStream) this).out.write(bArr, i2, i3);
            a(i3);
        } catch (IOException e) {
            d(e);
            throw null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        try {
            c(1);
            ((FilterOutputStream) this).out.write(i2);
            a(1);
        } catch (IOException e) {
            d(e);
            throw null;
        }
    }
}
