package i.b.ha.a.c.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class e extends i {
    private long e;
    private long f;
    private final long g;

    /* renamed from: h, reason: collision with root package name */
    private final i.b.ha.a.c.i.l<Long, Long> f1478h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1479i;

    public static d j() {
        return new d();
    }

    private boolean p() {
        return this.g >= 0 && m() >= this.g;
    }

    private long s(long j2) {
        long j3 = this.g;
        return j3 >= 0 ? Math.min(j2, j3 - m()) : j2;
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(super.available(), (int) Math.min(o(), 2147483647L));
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1479i) {
            super.close();
        }
    }

    @Override // i.b.ha.a.c.j.i
    protected synchronized void d(int i2) throws IOException {
        if (i2 != -1) {
            this.e += i2;
            super.d(i2);
        } else {
            super.d(i2);
        }
    }

    public synchronized long m() {
        return this.e;
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        this.f = this.e;
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    public long n() {
        return this.g;
    }

    public long o() {
        long jN = n();
        if (jN == -1) {
            return Long.MAX_VALUE;
        }
        return Math.max(0L, jN - m());
    }

    protected void q(long j2, long j3) throws IOException {
        this.f1478h.accept(Long.valueOf(j2), Long.valueOf(j3));
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (!p()) {
            return super.read();
        }
        q(this.g, m());
        return -1;
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        ((FilterInputStream) this).in.reset();
        this.e = this.f;
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        long jSkip;
        jSkip = super.skip(s(j2));
        this.e += jSkip;
        return jSkip;
    }

    public String toString() {
        return ((FilterInputStream) this).in.toString();
    }

    private e(d dVar) throws IOException {
        super(dVar);
        this.f1479i = true;
        this.e = dVar.s();
        this.g = dVar.t();
        this.f1479i = dVar.v();
        this.f1478h = dVar.u();
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (p()) {
            q(this.g, m());
            return -1;
        }
        return super.read(bArr, i2, (int) s(i3));
    }

    @Deprecated
    public e(InputStream inputStream) {
        this(inputStream, -1L);
    }

    private e(InputStream inputStream, d dVar) {
        super(inputStream, dVar);
        this.f1479i = true;
        this.e = dVar.s();
        this.g = dVar.t();
        this.f1479i = dVar.v();
        this.f1478h = dVar.u();
    }

    @Deprecated
    public e(InputStream inputStream, long j2) {
        this(inputStream, j().w(j2));
    }
}
