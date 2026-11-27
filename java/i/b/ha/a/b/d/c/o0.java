package i.b.ha.a.b.d.c;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class o0 implements Closeable {
    private final Deflater c;
    private long e;
    private long f;
    private long g;
    private final CRC32 d = new CRC32();

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f1432h = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];

    o0(Deflater deflater) {
        this.c = deflater;
    }

    static o0 a(OutputStream outputStream, Deflater deflater) {
        return new n0(deflater, outputStream);
    }

    private void d() throws IOException {
        while (!this.c.needsInput()) {
            c();
        }
    }

    private void s(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 <= 0 || this.c.finished()) {
            return;
        }
        if (i3 <= 8192) {
            this.c.setInput(bArr, i2, i3);
            d();
            return;
        }
        int i4 = i3 / XMLEvent.ENTITY_REFERENCE;
        for (int i5 = 0; i5 < i4; i5++) {
            this.c.setInput(bArr, (i5 * XMLEvent.ENTITY_REFERENCE) + i2, XMLEvent.ENTITY_REFERENCE);
            d();
        }
        int i6 = i4 * XMLEvent.ENTITY_REFERENCE;
        if (i6 < i3) {
            this.c.setInput(bArr, i2 + i6, i3 - i6);
            d();
        }
    }

    void c() throws IOException {
        Deflater deflater = this.c;
        byte[] bArr = this.f1432h;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            q(this.f1432h, 0, iDeflate);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.end();
    }

    void f() throws IOException {
        this.c.finish();
        while (!this.c.finished()) {
            c();
        }
    }

    public long i() {
        return this.f;
    }

    public long j() {
        return this.d.getValue();
    }

    public long m() {
        return this.g;
    }

    void n() {
        this.d.reset();
        this.c.reset();
        this.f = 0L;
        this.e = 0L;
    }

    long o(byte[] bArr, int i2, int i3, int i4) throws IOException {
        long j2 = this.e;
        this.d.update(bArr, i2, i3);
        if (i4 == 8) {
            s(bArr, i2, i3);
        } else {
            q(bArr, i2, i3);
        }
        this.f += i3;
        return this.e - j2;
    }

    public void p(byte[] bArr) throws IOException {
        q(bArr, 0, bArr.length);
    }

    public void q(byte[] bArr, int i2, int i3) throws IOException {
        u(bArr, i2, i3);
        long j2 = i3;
        this.e += j2;
        this.g += j2;
    }

    protected abstract void u(byte[] bArr, int i2, int i3) throws IOException;
}
