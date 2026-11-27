package i.b.ha.a.b.e.c;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
class i implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    private static final short[] f1463h = {96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f1464i = {16, 32, 48, 64, 81, 113, 146, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f1465j = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f1466k;
    private static final int[] t;
    private boolean c;
    private i.b.ha.a.b.f.b e;
    private final InputStream f;
    private final e g = new e();
    private d d = new g();

    static {
        int[] iArr = new int[288];
        f1466k = iArr;
        Arrays.fill(iArr, 0, 144, 8);
        Arrays.fill(iArr, 144, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        i.b.ha.a.d.a.a(iArr2, 5);
        t = iArr2;
    }

    i(InputStream inputStream) {
        this.e = new i.b.ha.a.b.f.b(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.f = inputStream;
    }

    private void B() throws IOException {
        this.e.a();
        long jX = x(16);
        if ((65535 & (jX ^ 65535)) != x(16)) {
            throw new IllegalStateException("Illegal LEN / NLEN values");
        }
        this.d = new h(this, jX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c o(int[] iArr) {
        int[] iArrS = s(iArr);
        c cVar = new c(0);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                int i4 = i3 - 1;
                int i5 = iArrS[i4];
                c cVarB = cVar;
                for (int i6 = i4; i6 >= 0; i6--) {
                    cVarB = ((1 << i6) & i5) == 0 ? cVarB.b() : cVarB.c();
                    if (cVarB == null) {
                        throw new IllegalStateException("node doesn't exist in Huffman tree");
                    }
                }
                cVarB.a(i2);
                iArrS[i4] = iArrS[i4] + 1;
            }
        }
        return cVar;
    }

    private static int[] s(int[] iArr) {
        int[] iArr2 = new int[65];
        int iMax = 0;
        for (int i2 : iArr) {
            if (i2 < 0 || i2 > 64) {
                throw new IllegalArgumentException("Invalid code " + i2 + " in literal table");
            }
            iMax = Math.max(iMax, i2);
            iArr2[i2] = iArr2[i2] + 1;
        }
        int i3 = iMax + 1;
        int[] iArrCopyOf = Arrays.copyOf(iArr2, i3);
        int[] iArr3 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 <= iMax; i5++) {
            i4 = (i4 + iArrCopyOf[i5]) << 1;
            iArr3[i5] = i4;
        }
        return iArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int u(i.b.ha.a.b.f.b bVar, c cVar) throws IOException {
        while (cVar != null && cVar.b == -1) {
            cVar = y(bVar, 1) == 0 ? cVar.c : cVar.d;
        }
        if (cVar != null) {
            return cVar.b;
        }
        return -1;
    }

    private static void w(i.b.ha.a.b.f.b bVar, int[] iArr, int[] iArr2) throws IOException {
        long jY;
        int iY = (int) (y(bVar, 4) + 4);
        int[] iArr3 = new int[19];
        for (int i2 = 0; i2 < iY; i2++) {
            iArr3[f1465j[i2]] = (int) y(bVar, 3);
        }
        c cVarO = o(iArr3);
        int length = iArr.length + iArr2.length;
        int[] iArr4 = new int[length];
        int i3 = -1;
        int i4 = 0;
        int iY2 = 0;
        while (i4 < length) {
            if (iY2 > 0) {
                iArr4[i4] = i3;
                iY2--;
                i4++;
            } else {
                int iU = u(bVar, cVarO);
                if (iU < 16) {
                    iArr4[i4] = iU;
                    i4++;
                    i3 = iU;
                } else {
                    long j2 = 3;
                    switch (iU) {
                        case 16:
                            iY2 = (int) (y(bVar, 2) + 3);
                            continue;
                        case 17:
                            jY = y(bVar, 3);
                            break;
                        case 18:
                            jY = y(bVar, 7);
                            j2 = 11;
                            break;
                    }
                    iY2 = (int) (jY + j2);
                    i3 = 0;
                }
            }
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr.length);
        System.arraycopy(iArr4, iArr.length, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long x(int i2) throws IOException {
        return y(this.e, i2);
    }

    private static long y(i.b.ha.a.b.f.b bVar, int i2) throws IOException {
        long jO = bVar.o(i2);
        if (jO != -1) {
            return jO;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }

    private int[][] z() throws IOException {
        int[][] iArr = {new int[(int) (x(5) + 257)], new int[(int) (x(5) + 1)]};
        w(this.e, iArr[0], iArr[1]);
        return iArr;
    }

    int available() throws IOException {
        return this.d.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d = new g();
        this.e = null;
    }

    public int p(byte[] bArr, int i2, int i3) throws IOException {
        while (true) {
            if (this.c && !this.d.b()) {
                return -1;
            }
            if (this.d.d() == j.INITIAL) {
                this.c = x(1) == 1;
                int iX = (int) x(2);
                if (iX == 0) {
                    B();
                } else if (iX == 1) {
                    this.d = new f(this, j.FIXED_CODES, f1466k, t);
                } else {
                    if (iX != 2) {
                        throw new IllegalStateException("Unsupported compression: " + iX);
                    }
                    int[][] iArrZ = z();
                    this.d = new f(this, j.DYNAMIC_CODES, iArrZ[0], iArrZ[1]);
                }
            } else {
                int iC = this.d.c(bArr, i2, i3);
                if (iC != 0) {
                    return iC;
                }
            }
        }
    }

    long q() {
        return this.e.j();
    }
}
