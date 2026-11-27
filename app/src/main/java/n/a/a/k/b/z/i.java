package n.a.a.k.b.z;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class i extends OutputStream {
    private final h c;
    private final i.b.ha.a.c.k.j d = i.b.ha.a.c.k.j.p().get();

    public i(h hVar) {
        this.c = hVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.d.flush();
        h hVar = this.c;
        byte[] bArr = hVar.f2292i;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length + this.d.w()];
            byte[] bArr3 = this.c.f2292i;
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            byte[] bArrD = this.d.d();
            System.arraycopy(bArrD, 0, bArr2, this.c.f2292i.length, bArrD.length);
            this.c.f2292i = bArr2;
        } else {
            hVar.f2292i = this.d.d();
        }
        this.d.u();
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        this.d.write(i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        this.d.write(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.d.write(bArr);
    }
}
