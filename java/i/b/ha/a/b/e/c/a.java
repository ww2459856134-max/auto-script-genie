package i.b.ha.a.b.e.c;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class a extends i.b.ha.a.b.e.a implements i.b.ha.a.b.f.h {
    private InputStream d;
    private i e;
    private long f;
    private final byte[] g;

    a(i iVar) {
        this.g = new byte[1];
        this.e = iVar;
    }

    private void j() {
        i.b.ha.a.c.e.h(this.e);
        this.e = null;
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.f;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        i iVar = this.e;
        if (iVar != null) {
            return iVar.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            j();
        } finally {
            i.b.ha.a.c.e.f(this.d);
            this.d = null;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2;
        do {
            i2 = read(this.g);
            if (i2 == -1) {
                return -1;
            }
        } while (i2 == 0);
        if (i2 == 1) {
            return this.g[0] & 255;
        }
        throw new IllegalStateException("Invalid return value from read: " + i2);
    }

    public a(InputStream inputStream) {
        this(new i(inputStream));
        this.d = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        i iVar = this.e;
        if (iVar == null) {
            return -1;
        }
        try {
            int iP = iVar.p(bArr, i2, i3);
            this.f = this.e.q();
            d(iP);
            if (iP == -1) {
                j();
            }
            return iP;
        } catch (RuntimeException e) {
            throw new IOException("Invalid Deflate64 input", e);
        }
    }
}
