package l.a.a.i;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* loaded from: classes.dex */
public class g {
    private final byte[] a = new byte[2];
    private final byte[] b = new byte[4];
    private final byte[] c = new byte[8];

    private void a(InputStream inputStream, byte[] bArr, int i2) throws IOException {
        if (i.m(inputStream, bArr, 0, i2) != i2) {
            throw new l.a.a.c.b("Could not fill buffer");
        }
    }

    private void n(byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
    }

    public int b(InputStream inputStream) throws IOException {
        a(inputStream, this.b, 4);
        return d(this.b);
    }

    public int c(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.b);
        return d(this.b);
    }

    public int d(byte[] bArr) {
        return e(bArr, 0);
    }

    public int e(byte[] bArr, int i2) {
        return ((((bArr[i2 + 3] & 255) << 8) | (bArr[i2 + 2] & 255)) << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
    }

    public long f(InputStream inputStream) throws IOException {
        byte[] bArr = this.c;
        a(inputStream, bArr, bArr.length);
        return j(this.c, 0);
    }

    public long g(InputStream inputStream, int i2) throws IOException {
        n(this.c);
        a(inputStream, this.c, i2);
        return j(this.c, 0);
    }

    public long h(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.c);
        return j(this.c, 0);
    }

    public long i(RandomAccessFile randomAccessFile, int i2) throws IOException {
        n(this.c);
        randomAccessFile.readFully(this.c, 0, i2);
        return j(this.c, 0);
    }

    public long j(byte[] bArr, int i2) {
        if (bArr.length - i2 < 8) {
            n(this.c);
        }
        System.arraycopy(bArr, i2, this.c, 0, Math.min(bArr.length - i2, 8));
        byte[] bArr2 = this.c;
        return ((((((((((((((0 | (bArr2[7] & 255)) << 8) | (bArr2[6] & 255)) << 8) | (bArr2[5] & 255)) << 8) | (bArr2[4] & 255)) << 8) | (bArr2[3] & 255)) << 8) | (bArr2[2] & 255)) << 8) | (bArr2[1] & 255)) << 8) | (bArr2[0] & 255);
    }

    public int k(InputStream inputStream) throws IOException {
        byte[] bArr = this.a;
        a(inputStream, bArr, bArr.length);
        return m(this.a, 0);
    }

    public int l(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.a);
        return m(this.a, 0);
    }

    public int m(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    public void o(OutputStream outputStream, int i2) throws IOException {
        p(this.b, 0, i2);
        outputStream.write(this.b);
    }

    public void p(byte[] bArr, int i2, int i3) {
        bArr[i2 + 3] = (byte) (i3 >>> 24);
        bArr[i2 + 2] = (byte) (i3 >>> 16);
        bArr[i2 + 1] = (byte) (i3 >>> 8);
        bArr[i2] = (byte) (i3 & 255);
    }

    public void q(OutputStream outputStream, long j2) throws IOException {
        r(this.c, 0, j2);
        outputStream.write(this.c);
    }

    public void r(byte[] bArr, int i2, long j2) {
        bArr[i2 + 7] = (byte) (j2 >>> 56);
        bArr[i2 + 6] = (byte) (j2 >>> 48);
        bArr[i2 + 5] = (byte) (j2 >>> 40);
        bArr[i2 + 4] = (byte) (j2 >>> 32);
        bArr[i2 + 3] = (byte) (j2 >>> 24);
        bArr[i2 + 2] = (byte) (j2 >>> 16);
        bArr[i2 + 1] = (byte) (j2 >>> 8);
        bArr[i2] = (byte) (j2 & 255);
    }

    public void s(OutputStream outputStream, int i2) throws IOException {
        t(this.a, 0, i2);
        outputStream.write(this.a);
    }

    public void t(byte[] bArr, int i2, int i3) {
        bArr[i2 + 1] = (byte) (i3 >>> 8);
        bArr[i2] = (byte) (i3 & 255);
    }
}
