package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* loaded from: classes.dex */
abstract class f0 extends InflaterInputStream implements i.b.ha.a.b.f.h {
    private long c;
    private long d;

    f0(InputStream inputStream, Inflater inflater) {
        super(inputStream, inflater);
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.c;
    }

    @Override // i.b.ha.a.b.f.h
    public long c() {
        return this.d;
    }

    @Override // java.util.zip.InflaterInputStream
    protected void fill() throws IOException {
        super.fill();
        this.c += ((InflaterInputStream) this).inf.getRemaining();
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = super.read();
        if (i2 > -1) {
            this.d++;
        }
        return i2;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = super.read(bArr, i2, i3);
        if (i4 > -1) {
            this.d += i4;
        }
        return i4;
    }
}
