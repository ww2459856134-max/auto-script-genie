package i.b.ha.a.c.j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public class l extends InputStream {
    private final byte[] c;
    private final int d;
    private int e;
    private int f;

    public static k a() {
        return new k();
    }

    private static int c(byte[] bArr, int i2) {
        d(i2, "defaultValue");
        return Math.min(i2, bArr.length > 0 ? bArr.length : i2);
    }

    private static int d(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " cannot be negative");
    }

    @Override // java.io.InputStream
    public int available() {
        int i2 = this.e;
        int i3 = this.d;
        if (i2 < i3) {
            return i3 - i2;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f = this.e;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        int i2 = this.e;
        if (i2 >= this.d) {
            return -1;
        }
        byte[] bArr = this.c;
        this.e = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.e = this.f;
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Skipping backward is not supported");
        }
        int i2 = this.d;
        int i3 = this.e;
        long j3 = i2 - i3;
        if (j2 < j3) {
            j3 = j2;
        }
        this.e = Math.addExact(i3, Math.toIntExact(j2));
        return j3;
    }

    private l(k kVar) throws IOException {
        this(kVar.u(), kVar.f1481i, kVar.f1482j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        Objects.requireNonNull(bArr, "dest");
        return read(bArr, 0, bArr.length);
    }

    @Deprecated
    public l(byte[] bArr, int i2, int i3) {
        d(i2, "offset");
        d(i3, "length");
        Objects.requireNonNull(bArr, "data");
        this.c = bArr;
        this.d = Math.min(c(bArr, i2) + i3, bArr.length);
        this.e = c(bArr, i2);
        this.f = c(bArr, i2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        i.b.ha.a.c.e.d(bArr, i2, i3);
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.e;
        int i5 = this.d;
        if (i4 >= i5) {
            return -1;
        }
        int i6 = i5 - i4;
        if (i3 >= i6) {
            i3 = i6;
        }
        if (i3 <= 0) {
            return 0;
        }
        System.arraycopy(this.c, i4, bArr, i2, i3);
        this.e += i3;
        return i3;
    }
}
