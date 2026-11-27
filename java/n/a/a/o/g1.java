package n.a.a.o;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class g1 extends FilterInputStream {
    final int[] c;
    private int d;
    private int e;
    private int f;
    private final byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f2499h;

    /* renamed from: i, reason: collision with root package name */
    private f1 f2500i;

    public g1(InputStream inputStream, String str, String str2) {
        this(inputStream, str.getBytes(StandardCharsets.UTF_8), str2 == null ? null : str2.getBytes(StandardCharsets.UTF_8));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Objects.requireNonNull(bArr);
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        int i4 = read();
        if (i4 == -1) {
            return -1;
        }
        bArr[i2] = (byte) i4;
        int i5 = 1;
        while (i5 < i3) {
            int i6 = read();
            if (i6 == -1) {
                break;
            }
            bArr[i2 + i5] = (byte) i6;
            i5++;
        }
        return i5;
    }

    public String toString() {
        return this.f2500i.name() + " " + this.d + " " + this.f + " " + this.e;
    }

    public g1(InputStream inputStream, byte[] bArr, byte[] bArr2) {
        super(inputStream);
        this.f2500i = f1.NOT_MATCHED;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("pattern length should be > 0");
        }
        this.g = bArr;
        this.f2499h = bArr2;
        this.c = new int[bArr.length];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = e1.a[this.f2500i.ordinal()];
        if (i2 == 2) {
            int i3 = super.read();
            byte[] bArr = this.g;
            int i4 = this.d;
            if (bArr[i4] == i3) {
                int[] iArr = this.c;
                int i5 = i4 + 1;
                this.d = i5;
                iArr[i4] = i3;
                if (i5 == bArr.length) {
                    byte[] bArr2 = this.f2499h;
                    if (bArr2 != null && bArr2.length != 0) {
                        this.f2500i = f1.REPLACING;
                        this.f = 0;
                    } else {
                        this.f2500i = f1.NOT_MATCHED;
                        this.d = 0;
                    }
                }
            } else {
                int[] iArr2 = this.c;
                this.d = i4 + 1;
                iArr2[i4] = i3;
                this.f2500i = f1.UNBUFFER;
                this.e = 0;
            }
            return read();
        }
        if (i2 == 3) {
            byte[] bArr3 = this.f2499h;
            int i6 = this.f;
            int i7 = i6 + 1;
            this.f = i7;
            byte b = bArr3[i6];
            if (i7 == bArr3.length) {
                this.f2500i = f1.NOT_MATCHED;
                this.f = 0;
            }
            return b;
        }
        if (i2 != 4) {
            int i8 = super.read();
            if (this.g[0] != i8) {
                return i8;
            }
            Arrays.fill(this.c, 0);
            this.d = 0;
            int[] iArr3 = this.c;
            this.d = 0 + 1;
            iArr3[0] = i8;
            if (this.g.length == 1) {
                this.f2500i = f1.REPLACING;
                this.f = 0;
            } else {
                this.f2500i = f1.MATCHING;
            }
            return read();
        }
        int[] iArr4 = this.c;
        int i9 = this.e;
        int i10 = i9 + 1;
        this.e = i10;
        int i11 = iArr4[i9];
        if (i10 == this.d) {
            this.f2500i = f1.NOT_MATCHED;
            this.d = 0;
        }
        return i11;
    }
}
