package i.b.ha.a.b.d;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class b<E> extends i.b.ha.a.b.b<OutputStream> {
    private final byte[] d = new byte[1];
    private long e;

    protected void a(long j2) {
        if (j2 != -1) {
            this.e += j2;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.d;
        bArr[0] = (byte) (i2 & 255);
        write(bArr, 0, 1);
    }
}
