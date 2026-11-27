package n.a.a.k.b;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
final class t extends FilterOutputStream {
    t(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
    }
}
