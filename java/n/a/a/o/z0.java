package n.a.a.o;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class z0 extends FilterOutputStream {
    public z0(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(int i2) throws IOException {
        int i3 = (i2 >>> 24) & 255;
        int i4 = (i2 >>> 16) & 255;
        int i5 = (i2 >>> 8) & 255;
        try {
            ((FilterOutputStream) this).out.write(i2 & 255);
            ((FilterOutputStream) this).out.write(i5);
            ((FilterOutputStream) this).out.write(i4);
            ((FilterOutputStream) this).out.write(i3);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void c(int i2) throws IOException {
        int i3 = (i2 >>> 8) & 255;
        try {
            ((FilterOutputStream) this).out.write(i2 & 255);
            ((FilterOutputStream) this).out.write(i3);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void d(long j2) throws IOException {
        try {
            ((FilterOutputStream) this).out.write((byte) (j2 & 255));
            ((FilterOutputStream) this).out.write((byte) ((j2 >>> 8) & 255));
            ((FilterOutputStream) this).out.write((byte) ((j2 >>> 16) & 255));
            ((FilterOutputStream) this).out.write((byte) ((j2 >>> 24) & 255));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            super.write(bArr);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        try {
            super.write(bArr, i2, i3);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
