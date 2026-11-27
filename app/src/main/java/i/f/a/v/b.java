package i.f.a.v;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {
    private final int c;
    private final int d;
    private final int e;
    private final int[] f;

    public b(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.d * (this.c + 1));
        for (int i2 = 0; i2 < this.d; i2++) {
            for (int i3 = 0; i3 < this.c; i3++) {
                sb.append(d(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.c, this.d, this.e, (int[]) this.f.clone());
    }

    public void c(int i2, int i3) {
        int i4 = (i3 * this.e) + (i2 / 32);
        int[] iArr = this.f;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean d(int i2, int i3) {
        return ((this.f[(i3 * this.e) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] e() {
        int length = this.f.length - 1;
        while (length >= 0 && this.f[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.e;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && Arrays.equals(this.f, bVar.f);
    }

    public int[] f() {
        int i2 = this.c;
        int i3 = this.d;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.d; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.e;
                if (i7 < i8) {
                    int i9 = this.f[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int g() {
        return this.d;
    }

    public a h(int i2, a aVar) {
        if (aVar == null || aVar.k() < this.c) {
            aVar = new a(this.c);
        } else {
            aVar.d();
        }
        int i3 = i2 * this.e;
        for (int i4 = 0; i4 < this.e; i4++) {
            aVar.q(i4 << 5, this.f[i3 + i4]);
        }
        return aVar;
    }

    public int hashCode() {
        int i2 = this.c;
        return (((((((i2 * 31) + i2) * 31) + this.d) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    public int[] i() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.e;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int j() {
        return this.c;
    }

    public void k() {
        a aVar = new a(this.c);
        a aVar2 = new a(this.c);
        int i2 = (this.d + 1) / 2;
        for (int i3 = 0; i3 < i2; i3++) {
            aVar = h(i3, aVar);
            int i4 = (this.d - 1) - i3;
            aVar2 = h(i4, aVar2);
            aVar.o();
            aVar2.o();
            n(i3, aVar2);
            n(i4, aVar);
        }
    }

    public void l(int i2, int i3) {
        int i4 = (i3 * this.e) + (i2 / 32);
        int[] iArr = this.f;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void m(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.d || i6 > this.c) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.e * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public void n(int i2, a aVar) {
        int[] iArrH = aVar.h();
        int[] iArr = this.f;
        int i3 = this.e;
        System.arraycopy(iArrH, 0, iArr, i2 * i3, i3);
    }

    public String o(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return o("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.c = i2;
        this.d = i3;
        int i4 = (i2 + 31) / 32;
        this.e = i4;
        this.f = new int[i4 * i3];
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = iArr;
    }
}
