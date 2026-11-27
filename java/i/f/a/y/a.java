package i.f.a.y;

import i.f.a.r;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends k {
    static final char[] d = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] f = {'A', 'B', 'C', 'D'};
    private final StringBuilder a = new StringBuilder(20);
    private int[] b = new int[80];
    private int c = 0;

    static boolean h(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i2) {
        int[] iArr = this.b;
        int i3 = this.c;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.c = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.b = iArr2;
        }
    }

    private int j() throws i.f.a.k {
        for (int i2 = 1; i2 < this.c; i2 += 2) {
            int iL = l(i2);
            if (iL != -1 && h(f, d[iL])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.b[i4];
                }
                if (i2 == 1 || this.b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw i.f.a.k.a();
    }

    private void k(i.f.a.v.a aVar) throws i.f.a.k {
        int i2 = 0;
        this.c = 0;
        int iJ = aVar.j(0);
        int iK = aVar.k();
        if (iJ >= iK) {
            throw i.f.a.k.a();
        }
        boolean z = true;
        while (iJ < iK) {
            if (aVar.g(iJ) != z) {
                i2++;
            } else {
                i(i2);
                z = !z;
                i2 = 1;
            }
            iJ++;
        }
        i(i2);
    }

    private int l(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    private void m(int i2) throws i.f.a.k {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.a.length() - 1;
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            int i6 = e[this.a.charAt(i5)];
            for (int i7 = 6; i7 >= 0; i7--) {
                int i8 = (i7 & 1) + ((i6 & 1) << 1);
                iArr[i8] = iArr[i8] + this.b[i4 + i7];
                iArr2[i8] = iArr2[i8] + 1;
                i6 >>= 1;
            }
            if (i5 >= length) {
                break;
            }
            i4 += 8;
            i5++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i9 = 0; i9 < 2; i9++) {
            fArr2[i9] = 0.0f;
            int i10 = i9 + 2;
            fArr2[i10] = ((iArr[i9] / iArr2[i9]) + (iArr[i10] / iArr2[i10])) / 2.0f;
            fArr[i9] = fArr2[i10];
            fArr[i10] = ((iArr[i10] * 2.0f) + 1.5f) / iArr2[i10];
        }
        loop3: while (true) {
            int i11 = e[this.a.charAt(i3)];
            for (int i12 = 6; i12 >= 0; i12--) {
                int i13 = (i12 & 1) + ((i11 & 1) << 1);
                float f2 = this.b[i2 + i12];
                if (f2 < fArr2[i13] || f2 > fArr[i13]) {
                    break loop3;
                }
                i11 >>= 1;
            }
            if (i3 >= length) {
                return;
            }
            i2 += 8;
            i3++;
        }
        throw i.f.a.k.a();
    }

    @Override // i.f.a.y.k
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k {
        Arrays.fill(this.b, 0);
        k(aVar);
        int iJ = j();
        this.a.setLength(0);
        int i3 = iJ;
        do {
            int iL = l(i3);
            if (iL == -1) {
                throw i.f.a.k.a();
            }
            this.a.append((char) iL);
            i3 += 8;
            if (this.a.length() > 1 && h(f, d[iL])) {
                break;
            }
        } while (i3 < this.c);
        int i4 = i3 - 1;
        int i5 = this.b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.b[i3 + i7];
        }
        if (i3 < this.c && i5 < i6 / 2) {
            throw i.f.a.k.a();
        }
        m(iJ);
        for (int i8 = 0; i8 < this.a.length(); i8++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i8, d[sb.charAt(i8)]);
        }
        char cCharAt = this.a.charAt(0);
        char[] cArr = f;
        if (!h(cArr, cCharAt)) {
            throw i.f.a.k.a();
        }
        StringBuilder sb2 = this.a;
        if (!h(cArr, sb2.charAt(sb2.length() - 1))) {
            throw i.f.a.k.a();
        }
        if (this.a.length() <= 3) {
            throw i.f.a.k.a();
        }
        if (map == null || !map.containsKey(i.f.a.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iJ; i10++) {
            i9 += this.b[i10];
        }
        float f2 = i9;
        while (iJ < i4) {
            i9 += this.b[iJ];
            iJ++;
        }
        float f3 = i2;
        return new i.f.a.p(this.a.toString(), null, new r[]{new r(f2, f3), new r(i9, f3)}, i.f.a.a.CODABAR);
    }
}
