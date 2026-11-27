package i.b.ha.a.b.e.b;

import com.auto.exceldeps.log4j.util.Chars;
import i.b.ha.a.b.f.h;
import i.b.ha.a.c.j.f;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b extends i.b.ha.a.b.e.a implements h {
    private int A;
    private int C;
    private int D;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int M;
    private int O;
    private int P;
    private char Q;
    private a U;
    private int d;
    private int e;
    private int f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final c f1458h;

    /* renamed from: i, reason: collision with root package name */
    private int f1459i;

    /* renamed from: j, reason: collision with root package name */
    private i.b.ha.a.b.f.b f1460j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f1461k;
    private int t;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private void B() throws IOException {
        i.b.ha.a.b.f.b bVar = this.f1460j;
        do {
            char cN = n(bVar);
            char cN2 = n(bVar);
            char cN3 = n(bVar);
            char cN4 = n(bVar);
            char cN5 = n(bVar);
            char cN6 = n(bVar);
            if (cN != 23 || cN2 != 'r' || cN3 != 'E' || cN4 != '8' || cN5 != 'P' || cN6 != 144) {
                if (cN != '1' || cN2 != 'A' || cN3 != 'Y' || cN4 != '&' || cN5 != 'S' || cN6 != 'Y') {
                    this.t = 0;
                    throw new IOException("Bad block header");
                }
                this.A = m(bVar);
                this.g = o(bVar, 1) == 1;
                if (this.U == null) {
                    this.U = new a(this.f);
                }
                w();
                this.f1458h.c();
                this.t = 1;
                return;
            }
        } while (!q());
    }

    private void D() {
        a aVar = this.U;
        boolean[] zArr = aVar.a;
        byte[] bArr = aVar.b;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                bArr[i2] = (byte) i3;
                i2++;
            }
        }
        this.f1459i = i2;
    }

    private int F() throws IOException {
        switch (this.t) {
            case 0:
                return -1;
            case 1:
                return I();
            case 2:
                throw new IllegalStateException();
            case 3:
                return N();
            case 4:
                return O();
            case 5:
                throw new IllegalStateException();
            case 6:
                return K();
            case 7:
                return L();
            default:
                throw new IllegalStateException();
        }
    }

    private int G(i.b.ha.a.b.f.b bVar) throws IOException {
        return (int) bVar.o(8);
    }

    private void H() throws IOException {
        i.b.ha.a.b.f.b bVar = this.f1460j;
        a aVar = this.U;
        boolean[] zArr = aVar.a;
        byte[] bArr = aVar.f1455m;
        byte[] bArr2 = aVar.c;
        byte[] bArr3 = aVar.d;
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            if (j(bVar)) {
                i2 |= 1 << i3;
            }
        }
        Arrays.fill(zArr, false);
        for (int i4 = 0; i4 < 16; i4++) {
            if (((1 << i4) & i2) != 0) {
                int i5 = i4 << 4;
                for (int i6 = 0; i6 < 16; i6++) {
                    if (j(bVar)) {
                        zArr[i5 + i6] = true;
                    }
                }
            }
        }
        D();
        int i7 = this.f1459i + 2;
        int iO = o(bVar, 3);
        int iO2 = o(bVar, 15);
        if (iO2 < 0) {
            throw new IOException("Corrupted input, nSelectors value negative");
        }
        p(i7, 259, "alphaSize");
        p(iO, 7, "nGroups");
        for (int i8 = 0; i8 < iO2; i8++) {
            int i9 = 0;
            while (j(bVar)) {
                i9++;
            }
            if (i8 < 18002) {
                bArr3[i8] = (byte) i9;
            }
        }
        int iMin = Math.min(iO2, 18002);
        int i10 = iO;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            } else {
                bArr[i10] = (byte) i10;
            }
        }
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = bArr3[i11] & 255;
            p(i12, 6, "selectorMtf");
            byte b = bArr[i12];
            while (i12 > 0) {
                bArr[i12] = bArr[i12 - 1];
                i12--;
            }
            bArr[0] = b;
            bArr2[i11] = b;
        }
        char[][] cArr = aVar.f1454l;
        for (int i13 = 0; i13 < iO; i13++) {
            int iO3 = o(bVar, 5);
            char[] cArr2 = cArr[i13];
            for (int i14 = 0; i14 < i7; i14++) {
                while (j(bVar)) {
                    iO3 += j(bVar) ? -1 : 1;
                }
                cArr2[i14] = (char) iO3;
            }
        }
        s(i7, iO);
    }

    private int I() throws IOException {
        a aVar;
        if (this.t == 0 || (aVar = this.U) == null) {
            return -1;
        }
        int[] iArr = aVar.f1452j;
        int i2 = this.d + 1;
        int[] iArrA = aVar.a(i2);
        a aVar2 = this.U;
        byte[] bArr = aVar2.f1457o;
        iArr[0] = 0;
        System.arraycopy(aVar2.e, 0, iArr, 1, 256);
        int i3 = iArr[0];
        for (int i4 = 1; i4 <= 256; i4++) {
            i3 += iArr[i4];
            iArr[i4] = i3;
        }
        int i5 = this.d;
        for (int i6 = 0; i6 <= i5; i6++) {
            int i7 = bArr[i6] & 255;
            int i8 = iArr[i7];
            iArr[i7] = i8 + 1;
            p(i8, i2, "tt index");
            iArrA[i8] = i6;
        }
        int i9 = this.e;
        if (i9 < 0 || i9 >= iArrA.length) {
            throw new IOException("Stream corrupted");
        }
        this.P = iArrA[i9];
        this.G = 0;
        this.J = 0;
        this.H = 256;
        if (!this.g) {
            return J();
        }
        this.M = 0;
        this.O = 0;
        return M();
    }

    private int J() throws IOException {
        if (this.J > this.d) {
            this.t = 5;
            u();
            B();
            return I();
        }
        this.I = this.H;
        a aVar = this.U;
        byte[] bArr = aVar.f1457o;
        int i2 = this.P;
        int i3 = bArr[i2] & 255;
        this.H = i3;
        p(i2, aVar.f1456n.length, "su_tPos");
        this.P = this.U.f1456n[this.P];
        this.J++;
        this.t = 6;
        this.f1458h.d(i3);
        return i3;
    }

    private int K() throws IOException {
        if (this.H != this.I) {
            this.G = 1;
            return J();
        }
        int i2 = this.G + 1;
        this.G = i2;
        if (i2 < 4) {
            return J();
        }
        p(this.P, this.U.f1457o.length, "su_tPos");
        a aVar = this.U;
        byte[] bArr = aVar.f1457o;
        int i3 = this.P;
        this.Q = (char) (bArr[i3] & 255);
        this.P = aVar.f1456n[i3];
        this.K = 0;
        return L();
    }

    private int L() throws IOException {
        if (this.K >= this.Q) {
            this.J++;
            this.G = 0;
            return J();
        }
        int i2 = this.H;
        this.f1458h.d(i2);
        this.K++;
        this.t = 7;
        return i2;
    }

    private int M() throws IOException {
        if (this.J > this.d) {
            u();
            B();
            return I();
        }
        this.I = this.H;
        a aVar = this.U;
        byte[] bArr = aVar.f1457o;
        int i2 = this.P;
        int i3 = bArr[i2] & 255;
        p(i2, aVar.f1456n.length, "su_tPos");
        this.P = this.U.f1456n[this.P];
        int i4 = this.M;
        if (i4 == 0) {
            this.M = d.a(this.O) - 1;
            int i5 = this.O + 1;
            this.O = i5;
            if (i5 == 512) {
                this.O = 0;
            }
        } else {
            this.M = i4 - 1;
        }
        int i6 = i3 ^ (this.M == 1 ? 1 : 0);
        this.H = i6;
        this.J++;
        this.t = 3;
        this.f1458h.d(i6);
        return i6;
    }

    private int N() throws IOException {
        if (this.H != this.I) {
            this.t = 2;
            this.G = 1;
            return M();
        }
        int i2 = this.G + 1;
        this.G = i2;
        if (i2 < 4) {
            this.t = 2;
            return M();
        }
        a aVar = this.U;
        byte[] bArr = aVar.f1457o;
        int i3 = this.P;
        this.Q = (char) (bArr[i3] & 255);
        p(i3, aVar.f1456n.length, "su_tPos");
        this.P = this.U.f1456n[this.P];
        int i4 = this.M;
        if (i4 == 0) {
            this.M = d.a(this.O) - 1;
            int i5 = this.O + 1;
            this.O = i5;
            if (i5 == 512) {
                this.O = 0;
            }
        } else {
            this.M = i4 - 1;
        }
        this.K = 0;
        this.t = 4;
        if (this.M == 1) {
            this.Q = (char) (this.Q ^ 1);
        }
        return O();
    }

    private int O() throws IOException {
        if (this.K < this.Q) {
            this.f1458h.d(this.H);
            this.K++;
            return this.H;
        }
        this.t = 2;
        this.J++;
        this.G = 0;
        return M();
    }

    private static boolean j(i.b.ha.a.b.f.b bVar) throws IOException {
        return o(bVar, 1) != 0;
    }

    private static int m(i.b.ha.a.b.f.b bVar) throws IOException {
        return o(bVar, 32);
    }

    private static char n(i.b.ha.a.b.f.b bVar) throws IOException {
        return (char) o(bVar, 8);
    }

    private static int o(i.b.ha.a.b.f.b bVar, int i2) throws IOException {
        long jO = bVar.o(i2);
        if (jO >= 0) {
            return (int) jO;
        }
        throw new IOException("Unexpected end of stream");
    }

    private static void p(int i2, int i3, String str) throws IOException {
        if (i2 < 0) {
            throw new IOException("Corrupted input, " + str + " value negative");
        }
        if (i2 < i3) {
            return;
        }
        throw new IOException("Corrupted input, " + str + " value too big");
    }

    private boolean q() throws IOException {
        int iM = m(this.f1460j);
        this.C = iM;
        this.t = 0;
        this.U = null;
        if (iM == this.D) {
            return (this.f1461k && z(false)) ? false : true;
        }
        throw new IOException("BZip2 CRC error");
    }

    private void s(int i2, int i3) throws IOException {
        a aVar = this.U;
        char[][] cArr = aVar.f1454l;
        int[] iArr = aVar.f1451i;
        int[][] iArr2 = aVar.f;
        int[][] iArr3 = aVar.g;
        int[][] iArr4 = aVar.f1450h;
        for (int i4 = 0; i4 < i3; i4++) {
            char c = Chars.SPACE;
            char[] cArr2 = cArr[i4];
            int i5 = i2;
            char c2 = 0;
            while (true) {
                i5--;
                if (i5 >= 0) {
                    char c3 = cArr2[i5];
                    if (c3 > c2) {
                        c2 = c3;
                    }
                    if (c3 < c) {
                        c = c3;
                    }
                }
            }
            y(iArr2[i4], iArr3[i4], iArr4[i4], cArr[i4], c, c2, i2);
            iArr[i4] = c;
        }
    }

    private void u() throws IOException {
        int iB = this.f1458h.b();
        int i2 = this.A;
        if (i2 == iB) {
            int i3 = this.D;
            int i4 = (i3 >>> 31) | (i3 << 1);
            this.D = i4;
            this.D = iB ^ i4;
            return;
        }
        int i5 = this.C;
        int i6 = (i5 >>> 31) | (i5 << 1);
        this.D = i6;
        this.D = i6 ^ i2;
        throw new IOException("BZip2 CRC error");
    }

    private void w() throws IOException {
        int i2;
        String str;
        char c;
        int i3;
        b bVar = this;
        i.b.ha.a.b.f.b bVar2 = bVar.f1460j;
        bVar.e = o(bVar2, 24);
        H();
        a aVar = bVar.U;
        byte[] bArr = aVar.f1457o;
        int[] iArr = aVar.e;
        byte[] bArr2 = aVar.c;
        byte[] bArr3 = aVar.b;
        char[] cArr = aVar.f1453k;
        int[] iArr2 = aVar.f1451i;
        int[][] iArr3 = aVar.f;
        int[][] iArr4 = aVar.g;
        int[][] iArr5 = aVar.f1450h;
        int i4 = bVar.f * 100000;
        int i5 = 256;
        while (true) {
            i5--;
            if (i5 < 0) {
                break;
            }
            cArr[i5] = (char) i5;
            iArr[i5] = 0;
        }
        int i6 = bVar.f1459i + 1;
        int iX = x();
        int i7 = bArr2[0] & 255;
        p(i7, 6, "zt");
        int[] iArr6 = iArr4[i7];
        int[] iArr7 = iArr3[i7];
        int[] iArr8 = iArr5[i7];
        int i8 = iArr2[i7];
        int i9 = iX;
        int i10 = 49;
        int i11 = -1;
        int i12 = 0;
        while (i9 != i6) {
            int i13 = i6;
            String str2 = "groupNo";
            i.b.ha.a.b.f.b bVar3 = bVar2;
            if (i9 == 0 || i9 == 1) {
                int[] iArr9 = iArr2;
                int i14 = i9;
                int i15 = i4;
                byte[] bArr4 = bArr;
                i9 = i14;
                int i16 = -1;
                int i17 = i10;
                int i18 = i12;
                int i19 = i8;
                int[] iArr10 = iArr8;
                int[] iArr11 = iArr7;
                int[] iArr12 = iArr6;
                int i20 = 1;
                while (true) {
                    if (i9 != 0) {
                        i2 = i11;
                        if (i9 != 1) {
                            break;
                        } else {
                            i16 += i20 << 1;
                        }
                    } else {
                        i16 += i20;
                        i2 = i11;
                    }
                    if (i17 == 0) {
                        int i21 = i18 + 1;
                        p(i21, 18002, str2);
                        int i22 = bArr2[i21] & 255;
                        str = str2;
                        p(i22, 6, "zt");
                        iArr12 = iArr4[i22];
                        iArr11 = iArr3[i22];
                        iArr10 = iArr5[i22];
                        i19 = iArr9[i22];
                        i18 = i21;
                        i17 = 49;
                    } else {
                        str = str2;
                        i17--;
                    }
                    int i23 = i19;
                    p(i23, 258, "zn");
                    int iO = o(bVar3, i23);
                    int i24 = i23;
                    while (iO > iArr11[i24]) {
                        int i25 = i24 + 1;
                        p(i25, 258, "zn");
                        iO = (iO << 1) | o(bVar3, 1);
                        i24 = i25;
                        iArr5 = iArr5;
                    }
                    int i26 = iO - iArr12[i24];
                    p(i26, 258, "zvec");
                    i20 <<= 1;
                    i9 = iArr10[i26];
                    i19 = i23;
                    i11 = i2;
                    str2 = str;
                    iArr5 = iArr5;
                }
                bVar = this;
                int[][] iArr13 = iArr5;
                p(i16, bVar.U.f1457o.length, "s");
                char c2 = cArr[0];
                p(c2, 256, "yy");
                byte b = bArr3[c2];
                int i27 = b & 255;
                iArr[i27] = iArr[i27] + i16 + 1;
                int i28 = i2 + 1;
                int i29 = i16 + i28;
                p(i29, bVar.U.f1457o.length, "lastShadow");
                Arrays.fill(bArr4, i28, i29 + 1, b);
                if (i29 >= i15) {
                    throw new IOException("Block overrun while expanding RLE in MTF, " + i29 + " exceeds " + i15);
                }
                i11 = i29;
                iArr6 = iArr12;
                iArr7 = iArr11;
                iArr8 = iArr10;
                i8 = i19;
                i12 = i18;
                i6 = i13;
                i10 = i17;
                iArr2 = iArr9;
                bArr = bArr4;
                iArr5 = iArr13;
                i4 = i15;
                bVar2 = bVar3;
            } else {
                i11++;
                if (i11 >= i4) {
                    throw new IOException("Block overrun in MTF, " + i11 + " exceeds " + i4);
                }
                int i30 = i4;
                p(i9, 257, "nextSym");
                int i31 = i9 - 1;
                char c3 = cArr[i31];
                int[] iArr14 = iArr2;
                p(c3, 256, "yy");
                int i32 = bArr3[c3] & 255;
                iArr[i32] = iArr[i32] + 1;
                bArr[i11] = bArr3[c3];
                if (i9 <= 16) {
                    while (i31 > 0) {
                        int i33 = i31 - 1;
                        cArr[i31] = cArr[i33];
                        i31 = i33;
                    }
                    c = 0;
                } else {
                    c = 0;
                    System.arraycopy(cArr, 0, cArr, 1, i31);
                }
                cArr[c] = c3;
                if (i10 == 0) {
                    int i34 = i12 + 1;
                    p(i34, 18002, "groupNo");
                    int i35 = bArr2[i34] & 255;
                    p(i35, 6, "zt");
                    int[] iArr15 = iArr4[i35];
                    int[] iArr16 = iArr3[i35];
                    int[] iArr17 = iArr5[i35];
                    i3 = iArr14[i35];
                    i12 = i34;
                    iArr6 = iArr15;
                    iArr7 = iArr16;
                    iArr8 = iArr17;
                    i10 = 49;
                } else {
                    i10--;
                    i3 = i8;
                }
                p(i3, 258, "zn");
                int iO2 = o(bVar3, i3);
                int i36 = i3;
                while (iO2 > iArr7[i36]) {
                    i36++;
                    p(i36, 258, "zn");
                    iO2 = (iO2 << 1) | o(bVar3, 1);
                }
                int i37 = iO2 - iArr6[i36];
                p(i37, 258, "zvec");
                i9 = iArr8[i37];
                i8 = i3;
                bVar2 = bVar3;
                i6 = i13;
                i4 = i30;
                iArr2 = iArr14;
                bVar = this;
            }
        }
        bVar.d = i11;
    }

    private int x() throws IOException {
        a aVar = this.U;
        int i2 = aVar.c[0] & 255;
        p(i2, 6, "zt");
        int[] iArr = aVar.f[i2];
        int i3 = aVar.f1451i[i2];
        p(i3, 258, "zn");
        int iO = o(this.f1460j, i3);
        while (iO > iArr[i3]) {
            i3++;
            p(i3, 258, "zn");
            iO = (iO << 1) | o(this.f1460j, 1);
        }
        int i4 = iO - aVar.g[i2][i3];
        p(i4, 258, "zvec");
        return aVar.f1450h[i2][i4];
    }

    private static void y(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i2, int i3, int i4) throws IOException {
        int i5 = 0;
        int i6 = 0;
        for (int i7 = i2; i7 <= i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                if (cArr[i8] == i7) {
                    iArr3[i6] = i8;
                    i6++;
                }
            }
        }
        int i9 = 23;
        while (true) {
            i9--;
            if (i9 <= 0) {
                break;
            }
            iArr2[i9] = 0;
            iArr[i9] = 0;
        }
        for (int i10 = 0; i10 < i4; i10++) {
            char c = cArr[i10];
            p(c, 258, "length");
            int i11 = c + 1;
            iArr2[i11] = iArr2[i11] + 1;
        }
        int i12 = iArr2[0];
        for (int i13 = 1; i13 < 23; i13++) {
            i12 += iArr2[i13];
            iArr2[i13] = i12;
        }
        int i14 = iArr2[i2];
        int i15 = i2;
        while (i15 <= i3) {
            int i16 = i15 + 1;
            int i17 = iArr2[i16];
            int i18 = i5 + (i17 - i14);
            iArr[i15] = i18 - 1;
            i5 = i18 << 1;
            i15 = i16;
            i14 = i17;
        }
        for (int i19 = i2 + 1; i19 <= i3; i19++) {
            iArr2[i19] = ((iArr[i19 - 1] + 1) << 1) - iArr2[i19];
        }
    }

    private boolean z(boolean z) throws IOException {
        i.b.ha.a.b.f.b bVar = this.f1460j;
        if (bVar == null) {
            throw new IOException("No InputStream");
        }
        if (!z) {
            bVar.f();
        }
        int iG = G(this.f1460j);
        if (iG == -1 && !z) {
            return false;
        }
        int iG2 = G(this.f1460j);
        int iG3 = G(this.f1460j);
        if (iG != 66 || iG2 != 90 || iG3 != 104) {
            throw new IOException(z ? "Stream is not in the BZip2 format" : "Unexpected data after a valid BZip2 stream");
        }
        int iG4 = G(this.f1460j);
        if (iG4 < 49 || iG4 > 57) {
            throw new IOException("BZip2 block size is invalid");
        }
        this.f = iG4 - 48;
        this.D = 0;
        return true;
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        return this.f1460j.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        i.b.ha.a.b.f.b bVar = this.f1460j;
        if (bVar != null) {
            try {
                bVar.close();
            } finally {
                this.U = null;
                this.f1460j = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f1460j == null) {
            throw new IOException("Stream closed");
        }
        int iF = F();
        d(iF < 0 ? -1 : 1);
        return iF;
    }

    public b(InputStream inputStream, boolean z) throws IOException {
        this.f1458h = new c();
        this.t = 1;
        this.f1460j = new i.b.ha.a.b.f.b(inputStream == System.in ? f.j(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.f1461k = z;
        z(true);
        B();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i2 + ") < 0.");
        }
        if (i3 >= 0) {
            int i4 = i2 + i3;
            if (i4 <= bArr.length) {
                if (this.f1460j == null) {
                    throw new IOException("Stream closed");
                }
                if (i3 == 0) {
                    return 0;
                }
                int i5 = i2;
                while (i5 < i4) {
                    int iF = F();
                    if (iF < 0) {
                        break;
                    }
                    bArr[i5] = (byte) iF;
                    d(1);
                    i5++;
                }
                if (i5 == i2) {
                    return -1;
                }
                return i5 - i2;
            }
            throw new IndexOutOfBoundsException("offs(" + i2 + ") + len(" + i3 + ") > dest.length(" + bArr.length + ").");
        }
        throw new IndexOutOfBoundsException("len(" + i3 + ") < 0.");
    }
}
