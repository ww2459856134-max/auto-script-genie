package i.b.ha.a.b.d.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class x {
    private final int[] a;

    x(int i2) {
        if (i2 < 0 || i2 > 30) {
            throw new IllegalArgumentException("depth must be bigger than 0 and not bigger than 30 but is " + i2);
        }
        int[] iArr = new int[(int) ((1 << (i2 + 1)) - 1)];
        i.b.ha.a.d.a.a(iArr, -1);
        this.a = iArr;
    }

    static x b(InputStream inputStream, int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("totalNumberOfValues must be bigger than 0, is " + i2);
        }
        int i3 = inputStream.read() + 1;
        if (i3 == 0) {
            throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
        }
        byte[] bArrC = i.b.ha.a.b.f.g.c(inputStream, i3);
        if (bArrC.length != i3) {
            throw new EOFException();
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        int iMax = 0;
        for (byte b : bArrC) {
            int i5 = ((b & 240) >> 4) + 1;
            if (i4 + i5 > i2) {
                throw new IOException("Number of values exceeds given total number of values");
            }
            int i6 = (b & 15) + 1;
            int i7 = 0;
            while (i7 < i5) {
                iArr[i4] = i6;
                i7++;
                i4++;
            }
            iMax = Math.max(iMax, i6);
        }
        int[] iArr2 = new int[i2];
        for (int i8 = 0; i8 < i2; i8++) {
            iArr2[i8] = i8;
        }
        int[] iArr3 = new int[i2];
        int i9 = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            for (int i11 = 0; i11 < i2; i11++) {
                if (iArr[i11] == i10) {
                    iArr3[i9] = i10;
                    iArr2[i9] = i11;
                    i9++;
                }
            }
        }
        int[] iArr4 = new int[i2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = i2 - 1; i15 >= 0; i15--) {
            i12 += i13;
            if (iArr3[i15] != i14) {
                i14 = iArr3[i15];
                i13 = 1 << (16 - i14);
            }
            iArr4[iArr2[i15]] = i12;
        }
        x xVar = new x(iMax);
        for (int i16 = 0; i16 < i2; i16++) {
            int i17 = iArr[i16];
            if (i17 > 0) {
                xVar.a(0, Integer.reverse(iArr4[i16] << 16), i17, i16);
            }
        }
        return xVar;
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i4 != 0) {
            this.a[i2] = -2;
            a((i2 * 2) + 1 + (i3 & 1), i3 >>> 1, i4 - 1, i5);
            return;
        }
        int[] iArr = this.a;
        if (iArr[i2] == -1) {
            iArr[i2] = i5;
            return;
        }
        throw new IllegalArgumentException("Tree value at index " + i2 + " has already been assigned (" + this.a[i2] + ")");
    }

    public int c(y yVar) throws IOException {
        int i2 = 0;
        while (true) {
            int iN = yVar.n();
            if (iN == -1) {
                return -1;
            }
            int i3 = (i2 * 2) + 1 + iN;
            int i4 = this.a[i3];
            if (i4 != -2) {
                if (i4 != -1) {
                    return i4;
                }
                throw new IOException("The child " + iN + " of node at index " + i2 + " is not defined");
            }
            i2 = i3;
        }
    }
}
