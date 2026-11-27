package l.a.a.e.b;

import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: classes.dex */
class e extends c {
    private byte[] d;
    protected Deflater e;

    public e(b<?> bVar, l.a.a.f.t.c cVar, int i2) {
        super(bVar);
        this.e = new Deflater(cVar.a(), true);
        this.d = new byte[i2];
    }

    private void d() throws IOException {
        Deflater deflater = this.e;
        byte[] bArr = this.d;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            super.write(this.d, 0, iDeflate);
        }
    }

    @Override // l.a.a.e.b.c
    public void a() throws IOException {
        if (!this.e.finished()) {
            this.e.finish();
            while (!this.e.finished()) {
                d();
            }
        }
        this.e.end();
        super.a();
    }

    @Override // l.a.a.e.b.c, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // l.a.a.e.b.c, java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2}, 0, 1);
    }

    @Override // l.a.a.e.b.c, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.e.setInput(bArr, i2, i3);
        while (!this.e.needsInput()) {
            d();
        }
    }
}
