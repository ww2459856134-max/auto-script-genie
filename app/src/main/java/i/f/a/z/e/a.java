package i.f.a.z.e;

import i.f.a.c;
import i.f.a.e;
import i.f.a.k;
import i.f.a.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(r[] rVarArr, r[] rVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            rVarArr[iArr[i2]] = rVarArr2[i2];
        }
    }

    public static b b(c cVar, Map<e, ?> map, boolean z) throws k {
        i.f.a.v.b bVarA = cVar.a();
        List<r[]> listC = c(z, bVarA);
        if (listC.isEmpty()) {
            bVarA = bVarA.clone();
            bVarA.k();
            listC = c(z, bVarA);
        }
        return new b(bVarA, listC);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r5 = (i.f.a.r[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<r[]> c(boolean z, i.f.a.v.b bVar) {
        int iC;
        float fD;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        int i2 = 0;
        loop0: while (true) {
            int i3 = i2;
            while (true) {
                if (iMax >= bVar.g()) {
                    break loop0;
                }
                r[] rVarArrF = f(bVar, iMax, i2);
                if (rVarArrF[0] != null || rVarArrF[3] != null) {
                    arrayList.add(rVarArrF);
                    if (!z) {
                        break loop0;
                    }
                    if (rVarArrF[2] != null) {
                        iC = (int) rVarArrF[2].c();
                        fD = rVarArrF[2].d();
                    } else {
                        iC = (int) rVarArrF[4].c();
                        fD = rVarArrF[4].d();
                    }
                    iMax = (int) fD;
                    i2 = iC;
                    i3 = 1;
                } else {
                    break;
                }
            }
            iMax += 5;
            i2 = 0;
        }
        return arrayList;
    }

    private static int[] d(i.f.a.v.b bVar, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.d(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        int i7 = i2;
        int i8 = 0;
        boolean z = false;
        while (i2 < i4) {
            if (bVar.d(i2, i3) != z) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                if (i8 != length - 1) {
                    i8++;
                } else {
                    if (g(iArr2, iArr) < 0.42f) {
                        return new int[]{i7, i2};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i9 = i8 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z = !z;
            }
            i2++;
        }
        if (i8 != length - 1 || g(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    private static r[] e(i.f.a.v.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int i7;
        r[] rVarArr = new r[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i2) {
                z = false;
                break;
            }
            int[] iArrD = d(bVar, i5, i8, i3, iArr, iArr2);
            if (iArrD != null) {
                int i9 = i8;
                int[] iArr3 = iArrD;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i7 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] iArrD2 = d(bVar, i5, i11, i3, iArr, iArr2);
                    if (iArrD2 == null) {
                        i7 = i11 + 1;
                        break;
                    }
                    iArr3 = iArrD2;
                    i10 = i11;
                }
                float f = i7;
                rVarArr[0] = new r(iArr3[0], f);
                rVarArr[1] = new r(iArr3[1], f);
                z = true;
                i8 = i7;
            } else {
                i8 += 5;
            }
        }
        int i12 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) rVarArr[0].c(), (int) rVarArr[1].c()};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i2) {
                    i6 = i14;
                    break;
                }
                i6 = i14;
                int[] iArrD3 = d(bVar, iArr4[0], i13, i3, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i14 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i14 = i6 + 1;
                }
                i13++;
            }
            i12 = i13 - (i6 + 1);
            float f2 = i12;
            rVarArr[2] = new r(iArr4[0], f2);
            rVarArr[3] = new r(iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(rVarArr, (Object) null);
        }
        return rVarArr;
    }

    private static r[] f(i.f.a.v.b bVar, int i2, int i3) {
        int iG = bVar.g();
        int iJ = bVar.j();
        r[] rVarArr = new r[8];
        a(rVarArr, e(bVar, iG, iJ, i2, i3, c), a);
        if (rVarArr[4] != null) {
            i3 = (int) rVarArr[4].c();
            i2 = (int) rVarArr[4].d();
        }
        a(rVarArr, e(bVar, iG, iJ, i2, i3, d), b);
        return rVarArr;
    }

    private static float g(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f = i2;
        float f2 = f / i3;
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f5 = iArr2[i5] * f2;
            float f6 = iArr[i5];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
