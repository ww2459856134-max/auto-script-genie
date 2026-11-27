package i.f.a.v;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class j extends h {
    private b e;

    public j(i.f.a.i iVar) {
        super(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[PHI: r5
      0x009c: PHI (r5v4 int) = (r5v3 int), (r5v7 int), (r5v7 int) binds: [B:31:0x007a, B:33:0x007e, B:34:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[][] i(byte[] bArr, int i2, int i3, int i4, int i5) {
        char c;
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        char c2 = 2;
        boolean z = true;
        int i9 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        int i10 = 0;
        while (i10 < i3) {
            int i11 = i10 << 3;
            if (i11 > i7) {
                i11 = i7;
            }
            int i12 = i9;
            while (i12 < i2) {
                int i13 = i12 << 3;
                if (i13 > i8) {
                    i13 = i8;
                }
                int i14 = (i11 * i4) + i13;
                int i15 = i9;
                int i16 = i15;
                int i17 = i16;
                int i18 = 255;
                while (i15 < i6) {
                    int i19 = i17;
                    int i20 = 0;
                    while (i20 < i6) {
                        int i21 = bArr[i14 + i20] & 255;
                        i16 += i21;
                        if (i21 < i18) {
                            i18 = i21;
                        }
                        if (i21 > i19) {
                            i19 = i21;
                        }
                        i20++;
                        i6 = 8;
                    }
                    if (i19 - i18 > 24) {
                        while (true) {
                            i15++;
                            i14 += i4;
                            if (i15 < 8) {
                                int i22 = 0;
                                for (int i23 = 8; i22 < i23; i23 = 8) {
                                    i16 += bArr[i14 + i22] & 255;
                                    i22++;
                                }
                            }
                        }
                    }
                    i15++;
                    i14 += i4;
                    i17 = i19;
                    z = true;
                    i6 = 8;
                }
                boolean z2 = z;
                int i24 = i16 >> 6;
                if (i17 - i18 <= 24) {
                    i24 = i18 / 2;
                    if (i10 <= 0 || i12 <= 0) {
                        c = 2;
                    } else {
                        int i25 = i10 - 1;
                        int i26 = i12 - 1;
                        c = 2;
                        int i27 = ((iArr[i25][i12] + (iArr[i10][i26] * 2)) + iArr[i25][i26]) / 4;
                        if (i18 < i27) {
                            i24 = i27;
                        }
                    }
                }
                iArr[i10][i12] = i24;
                i12++;
                z = z2;
                c2 = c;
                i6 = 8;
                i9 = 0;
            }
            i10++;
            i6 = 8;
            i9 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int iK = k(i8, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int iK2 = k(i11, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[iK + i15];
                    i14 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static int k(int i2, int i3) {
        if (i2 < 2) {
            return 2;
        }
        return Math.min(i2, i3);
    }

    private static void l(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.l(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // i.f.a.b
    public i.f.a.b a(i.f.a.i iVar) {
        return new j(iVar);
    }

    @Override // i.f.a.v.h, i.f.a.b
    public b b() throws i.f.a.k {
        b bVar = this.e;
        if (bVar != null) {
            return bVar;
        }
        i.f.a.i iVarE = e();
        int iD = iVarE.d();
        int iA = iVarE.a();
        if (iD < 40 || iA < 40) {
            this.e = super.b();
        } else {
            byte[] bArrB = iVarE.b();
            int i2 = iD >> 3;
            if ((iD & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = iA >> 3;
            if ((iA & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrI = i(bArrB, i3, i5, iD, iA);
            b bVar2 = new b(iD, iA);
            j(bArrB, i3, i5, iD, iA, iArrI, bVar2);
            this.e = bVar2;
        }
        return this.e;
    }
}
