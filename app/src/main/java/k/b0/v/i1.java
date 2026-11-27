package k.b0.v;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
class i1 implements g0 {
    private byte[] a;
    private int b;
    private int c = 0;

    static {
        k.y.c.b(i1.class);
    }

    public i1(int i2, int i3) {
        this.a = new byte[i2];
        this.b = i3;
    }

    @Override // k.b0.v.g0
    public void a(byte[] bArr, int i2) {
        System.arraycopy(bArr, 0, this.a, i2, bArr.length);
    }

    @Override // k.b0.v.g0
    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.a, 0, this.c);
    }

    @Override // k.b0.v.g0
    public int c() {
        return this.c;
    }

    @Override // k.b0.v.g0
    public void close() throws IOException {
    }

    @Override // k.b0.v.g0
    public void write(byte[] bArr) {
        while (true) {
            int i2 = this.c;
            int length = bArr.length + i2;
            byte[] bArr2 = this.a;
            if (length <= bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
                this.c += bArr.length;
                return;
            } else {
                byte[] bArr3 = new byte[bArr2.length + this.b];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                this.a = bArr3;
            }
        }
    }
}
