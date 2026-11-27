package i.b.ha.a.c.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class g extends InputStream {
    public static final g c = new g();

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        i.b.ha.a.c.e.d(bArr, i2, i3);
        return i3 == 0 ? 0 : -1;
    }
}
