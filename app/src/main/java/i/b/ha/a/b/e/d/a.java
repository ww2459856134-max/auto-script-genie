package i.b.ha.a.b.e.d;

import i.b.ha.a.b.f.b;
import i.b.ha.a.b.f.h;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class a extends i.b.ha.a.b.e.a implements h {
    private byte[] A;
    private int C;
    protected final b e;

    /* renamed from: h, reason: collision with root package name */
    private byte f1467h;

    /* renamed from: j, reason: collision with root package name */
    private int f1469j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f1470k;
    private byte[] t;
    private final byte[] d = new byte[1];
    private int f = -1;
    private int g = 9;

    /* renamed from: i, reason: collision with root package name */
    private int f1468i = -1;

    protected a(InputStream inputStream, ByteOrder byteOrder) {
        this.e = new b(inputStream, byteOrder);
    }

    private int B(byte[] bArr, int i2, int i3) {
        int length = this.A.length - this.C;
        if (length <= 0) {
            return 0;
        }
        int iMin = Math.min(length, i3);
        System.arraycopy(this.A, this.C, bArr, i2, iMin);
        this.C += iMin;
        return iMin;
    }

    protected int D() throws IOException {
        int i2 = this.g;
        if (i2 <= 31) {
            return (int) this.e.o(i2);
        }
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    protected void F(int i2) {
        this.f = 1 << (i2 - 1);
    }

    protected void G(int i2, int i3) {
        this.f1470k[i2] = i3;
    }

    protected void H(int i2) {
        this.f1469j = i2;
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.e.j();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    protected abstract int j(int i2, byte b) throws IOException;

    protected int m(int i2, byte b, int i3) {
        int i4 = this.f1469j;
        if (i4 >= i3) {
            return -1;
        }
        this.f1470k[i4] = i2;
        this.t[i4] = b;
        this.f1469j = i4 + 1;
        return i4;
    }

    protected int n() throws IOException {
        int i2 = this.f1468i;
        if (i2 != -1) {
            return j(i2, this.f1467h);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    protected abstract int o() throws IOException;

    protected int p(int i2, boolean z) throws IOException {
        int i3 = i2;
        while (i3 >= 0) {
            byte[] bArr = this.A;
            int i4 = this.C - 1;
            this.C = i4;
            bArr[i4] = this.t[i3];
            i3 = this.f1470k[i3];
        }
        int i5 = this.f1468i;
        if (i5 != -1 && !z) {
            j(i5, this.A[this.C]);
        }
        this.f1468i = i2;
        byte[] bArr2 = this.A;
        int i6 = this.C;
        this.f1467h = bArr2[i6];
        return i6;
    }

    protected int q() {
        return this.f;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2 = read(this.d);
        return i2 < 0 ? i2 : this.d[0] & 255;
    }

    protected int s() {
        return this.g;
    }

    protected int u(int i2) {
        return this.f1470k[i2];
    }

    protected int w() {
        return this.f1470k.length;
    }

    protected int x() {
        return this.f1469j;
    }

    protected void y() {
        this.g++;
    }

    protected void z(int i2) {
        int i3 = 1 << i2;
        if (i3 < 256 || s() > i2) {
            throw new IllegalArgumentException("maxCodeSize " + i2 + " is out of bounds.");
        }
        this.f1470k = new int[i3];
        this.t = new byte[i3];
        this.A = new byte[i3];
        this.C = i3;
        for (int i4 = 0; i4 < 256; i4++) {
            this.f1470k[i4] = -1;
            this.t[i4] = (byte) i4;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int iB = B(bArr, i2, i3);
        while (true) {
            int i4 = i3 - iB;
            if (i4 > 0) {
                int iO = o();
                if (iO < 0) {
                    if (iB <= 0) {
                        return iO;
                    }
                    d(iB);
                    return iB;
                }
                iB += B(bArr, i2 + iB, i4);
            } else {
                d(iB);
                return iB;
            }
        }
    }
}
