package i.f.a.a0.d;

import i.f.a.k;
import i.f.a.r;
import i.f.a.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g {
    private static final f f = new f();
    private final i.f.a.v.b a;
    private boolean c;
    private final s e;
    private final List<d> b = new ArrayList();
    private final int[] d = new int[5];

    public g(i.f.a.v.b bVar, s sVar) {
        this.a = bVar;
        this.e = sVar;
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean b(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArrK = k();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.a.d(i3 - i7, i2 - i7)) {
            iArrK[2] = iArrK[2] + 1;
            i7++;
        }
        if (iArrK[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.a.d(i3 - i7, i2 - i7)) {
            iArrK[1] = iArrK[1] + 1;
            i7++;
        }
        if (iArrK[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.a.d(i3 - i7, i2 - i7)) {
            iArrK[0] = iArrK[0] + 1;
            i7++;
        }
        if (iArrK[0] == 0) {
            return false;
        }
        int iG = this.a.g();
        int iJ = this.a.j();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= iG || (i6 = i3 + i8) >= iJ || !this.a.d(i6, i9)) {
                break;
            }
            iArrK[2] = iArrK[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= iG || (i5 = i3 + i8) >= iJ || this.a.d(i5, i10)) {
                break;
            }
            iArrK[3] = iArrK[3] + 1;
            i8++;
        }
        if (iArrK[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= iG || (i4 = i3 + i8) >= iJ || !this.a.d(i4, i11)) {
                break;
            }
            iArrK[4] = iArrK[4] + 1;
            i8++;
        }
        if (iArrK[4] == 0) {
            return false;
        }
        return j(iArrK);
    }

    private float c(int i2, int i3, int i4, int i5) {
        i.f.a.v.b bVar = this.a;
        int iJ = bVar.j();
        int[] iArrK = k();
        int i6 = i2;
        while (i6 >= 0 && bVar.d(i6, i3)) {
            iArrK[2] = iArrK[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.d(i6, i3) && iArrK[1] <= i4) {
            iArrK[1] = iArrK[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArrK[1] <= i4) {
            while (i6 >= 0 && bVar.d(i6, i3) && iArrK[0] <= i4) {
                iArrK[0] = iArrK[0] + 1;
                i6--;
            }
            if (iArrK[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < iJ && bVar.d(i7, i3)) {
                iArrK[2] = iArrK[2] + 1;
                i7++;
            }
            if (i7 == iJ) {
                return Float.NaN;
            }
            while (i7 < iJ && !bVar.d(i7, i3) && iArrK[3] < i4) {
                iArrK[3] = iArrK[3] + 1;
                i7++;
            }
            if (i7 != iJ && iArrK[3] < i4) {
                while (i7 < iJ && bVar.d(i7, i3) && iArrK[4] < i4) {
                    iArrK[4] = iArrK[4] + 1;
                    i7++;
                }
                if (iArrK[4] < i4 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + iArrK[4]) - i5) * 5 < i5 && i(iArrK)) {
                    return a(iArrK, i7);
                }
            }
        }
        return Float.NaN;
    }

    private float d(int i2, int i3, int i4, int i5) {
        i.f.a.v.b bVar = this.a;
        int iG = bVar.g();
        int[] iArrK = k();
        int i6 = i2;
        while (i6 >= 0 && bVar.d(i3, i6)) {
            iArrK[2] = iArrK[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.d(i3, i6) && iArrK[1] <= i4) {
            iArrK[1] = iArrK[1] + 1;
            i6--;
        }
        if (i6 >= 0 && iArrK[1] <= i4) {
            while (i6 >= 0 && bVar.d(i3, i6) && iArrK[0] <= i4) {
                iArrK[0] = iArrK[0] + 1;
                i6--;
            }
            if (iArrK[0] > i4) {
                return Float.NaN;
            }
            int i7 = i2 + 1;
            while (i7 < iG && bVar.d(i3, i7)) {
                iArrK[2] = iArrK[2] + 1;
                i7++;
            }
            if (i7 == iG) {
                return Float.NaN;
            }
            while (i7 < iG && !bVar.d(i3, i7) && iArrK[3] < i4) {
                iArrK[3] = iArrK[3] + 1;
                i7++;
            }
            if (i7 != iG && iArrK[3] < i4) {
                while (i7 < iG && bVar.d(i3, i7) && iArrK[4] < i4) {
                    iArrK[4] = iArrK[4] + 1;
                    i7++;
                }
                if (iArrK[4] < i4 && Math.abs(((((iArrK[0] + iArrK[1]) + iArrK[2]) + iArrK[3]) + iArrK[4]) - i5) * 5 < i5 * 2 && i(iArrK)) {
                    return a(iArrK, i7);
                }
            }
        }
        return Float.NaN;
    }

    protected static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    protected static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private int h() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean i(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    protected static boolean j(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] k() {
        e(this.d);
        return this.d;
    }

    private boolean m() {
        int size = this.b.size();
        float fAbs = 0.0f;
        float fI = 0.0f;
        int i2 = 0;
        for (d dVar : this.b) {
            if (dVar.h() >= 2) {
                i2++;
                fI += dVar.i();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = fI / size;
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().i() - f2);
        }
        return fAbs <= fI * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d[] n() throws k {
        double d;
        double dAbs;
        if (this.b.size() < 3) {
            throw k.a();
        }
        this.b.sort(f);
        d[] dVarArr = new d[3];
        int i2 = 0;
        double d2 = Double.MAX_VALUE;
        while (i2 < this.b.size() - 2) {
            d dVar = this.b.get(i2);
            float fI = dVar.i();
            i2++;
            int i3 = i2;
            while (i3 < this.b.size() - 1) {
                d dVar2 = this.b.get(i3);
                double dO = o(dVar, dVar2);
                i3++;
                for (int i4 = i3; i4 < this.b.size(); i4++) {
                    d dVar3 = this.b.get(i4);
                    if (dVar3.i() <= 1.4f * fI) {
                        double dO2 = o(dVar2, dVar3);
                        double dO3 = o(dVar, dVar3);
                        if (dO < dO2) {
                            if (dO2 <= dO3) {
                                d = dO;
                                dO2 = dO3;
                                dO3 = dO2;
                            } else if (dO < dO3) {
                                d = dO;
                            } else {
                                d = dO3;
                                dO3 = dO;
                            }
                            dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d * 2.0d));
                            if (dAbs < d2) {
                                dVarArr[0] = dVar;
                                dVarArr[1] = dVar2;
                                dVarArr[2] = dVar3;
                                d2 = dAbs;
                            }
                        } else {
                            if (dO2 >= dO3) {
                                d = dO3;
                                dO3 = dO2;
                            } else if (dO < dO3) {
                                d = dO2;
                                dO2 = dO3;
                                dO3 = dO;
                                dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d * 2.0d));
                                if (dAbs < d2) {
                                }
                            } else {
                                d = dO2;
                            }
                            dO2 = dO;
                            dAbs = Math.abs(dO2 - (dO3 * 2.0d)) + Math.abs(dO2 - (d * 2.0d));
                            if (dAbs < d2) {
                            }
                        }
                    }
                }
            }
        }
        if (d2 != Double.MAX_VALUE) {
            return dVarArr;
        }
        throw k.a();
    }

    private static double o(d dVar, d dVar2) {
        double dC = dVar.c() - dVar2.c();
        double d = dVar.d() - dVar2.d();
        return (dC * dC) + (d * d);
    }

    final h g(Map<i.f.a.e, ?> map) throws k {
        boolean z = map != null && map.containsKey(i.f.a.e.TRY_HARDER);
        int iG = this.a.g();
        int iJ = this.a.j();
        int i2 = (iG * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean zM = false;
        while (i3 < iG && !zM) {
            e(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < iJ) {
                if (this.a.d(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (i(iArr) && l(iArr, i3, i4)) {
                    if (this.c) {
                        zM = m();
                    } else {
                        int iH = h();
                        if (iH > iArr[2]) {
                            i3 += (iH - iArr[2]) - 2;
                            i4 = iJ - 1;
                        }
                    }
                    e(iArr);
                    i5 = 0;
                    i2 = 2;
                } else {
                    f(iArr);
                    i5 = 3;
                }
                i4++;
            }
            if (i(iArr) && l(iArr, i3, iJ)) {
                i2 = iArr[0];
                if (this.c) {
                    zM = m();
                }
            }
            i3 += i2;
        }
        d[] dVarArrN = n();
        r.e(dVarArrN);
        return new h(dVarArrN);
    }

    protected final boolean l(int[] iArr, int i2, int i3) {
        boolean z = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i3);
        float fD = d(i2, iA, iArr[2], i4);
        if (!Float.isNaN(fD)) {
            int i5 = (int) fD;
            float fC = c(iA, i5, iArr[2], i4);
            if (!Float.isNaN(fC) && b(i5, (int) fC)) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.b.size()) {
                        break;
                    }
                    d dVar = this.b.get(i6);
                    if (dVar.f(f2, fD, fC)) {
                        this.b.set(i6, dVar.g(fD, fC, f2));
                        z = true;
                        break;
                    }
                    i6++;
                }
                if (!z) {
                    d dVar2 = new d(fC, fD, f2);
                    this.b.add(dVar2);
                    s sVar = this.e;
                    if (sVar != null) {
                        sVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
