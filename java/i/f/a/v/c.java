package i.f.a.v;

/* loaded from: classes.dex */
public final class c {
    private final byte[] a;
    private int b;
    private int c;

    public c(byte[] bArr) {
        this.a = bArr;
    }

    public int a() {
        return ((this.a.length - this.b) * 8) - this.c;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int d(int i2) {
        if (i2 <= 0 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.c;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 8 - i3;
            int iMin = Math.min(i2, i5);
            int i6 = i5 - iMin;
            byte[] bArr = this.a;
            int i7 = this.b;
            int i8 = (((255 >> (8 - iMin)) << i6) & bArr[i7]) >> i6;
            i2 -= iMin;
            int i9 = this.c + iMin;
            this.c = i9;
            if (i9 == 8) {
                this.c = 0;
                this.b = i7 + 1;
            }
            i4 = i8;
        }
        if (i2 <= 0) {
            return i4;
        }
        while (i2 >= 8) {
            int i10 = i4 << 8;
            byte[] bArr2 = this.a;
            int i11 = this.b;
            i4 = (bArr2[i11] & 255) | i10;
            this.b = i11 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i4;
        }
        int i12 = 8 - i2;
        int i13 = (i4 << i2) | ((((255 >> i12) << i12) & this.a[this.b]) >> i12);
        this.c += i2;
        return i13;
    }
}
