package i.b.ha.a.b.e.c;

/* loaded from: classes.dex */
final class e {
    private final byte[] a;
    private final int b;
    private int c;
    private boolean d;

    private int c(int i2) {
        int i3 = (i2 + 1) & this.b;
        if (!this.d && i3 < i2) {
            this.d = true;
        }
        return i3;
    }

    byte a(byte b) {
        byte[] bArr = this.a;
        int i2 = this.c;
        bArr[i2] = b;
        this.c = c(i2);
        return b;
    }

    void b(byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(bArr[i4]);
        }
    }

    void d(int i2, int i3, byte[] bArr) {
        if (i2 > this.a.length) {
            throw new IllegalStateException("Illegal distance parameter: " + i2);
        }
        int i4 = this.c;
        int iC = (i4 - i2) & this.b;
        if (!this.d && iC >= i4) {
            throw new IllegalStateException("Attempt to read beyond memory: dist=" + i2);
        }
        int i5 = 0;
        while (i5 < i3) {
            byte b = this.a[iC];
            a(b);
            bArr[i5] = b;
            i5++;
            iC = c(iC);
        }
    }

    private e() {
        this(16);
    }

    private e(int i2) {
        byte[] bArr = new byte[1 << i2];
        this.a = bArr;
        this.b = bArr.length - 1;
    }
}
