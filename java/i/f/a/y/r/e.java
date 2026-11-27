package i.f.a.y.r;

import i.f.a.k;
import i.f.a.p;
import i.f.a.r;
import i.f.a.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f1706i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f1707j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f1708k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f1709l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f1710m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f1711n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    private static final int[][] f1712o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<d> f1713h = new ArrayList();

    private static void r(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041 A[PHI: r6 r7
      0x0041: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0041: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044 A[PHI: r6 r7
      0x0044: PHI (r6v7 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r7v11 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:24:0x003f, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void s(boolean z, int i2) throws k {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iD = i.f.a.v.m.a.d(m());
        int iD2 = i.f.a.v.m.a.d(k());
        boolean z6 = true;
        if (z) {
            if (iD > 12) {
                z2 = false;
                z3 = true;
            } else if (iD < 4) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 <= 12) {
                if (iD2 < 4) {
                    z5 = false;
                    z4 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
            }
            z4 = false;
            z5 = true;
        } else {
            if (iD > 11) {
                z2 = false;
                z3 = true;
            } else if (iD < 5) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iD2 <= 10) {
                if (iD2 < 4) {
                }
            }
            z4 = false;
            z5 = true;
        }
        int i3 = (iD + iD2) - i2;
        boolean z7 = (iD & 1) == z;
        boolean z8 = (iD2 & 1) == 1;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw k.a();
                }
                if (z7) {
                    if (z8) {
                        throw k.a();
                    }
                    z3 = true;
                } else {
                    if (!z8) {
                        throw k.a();
                    }
                    z5 = true;
                }
            } else if (z7) {
                if (!z8) {
                    throw k.a();
                }
                if (iD < iD2) {
                    z5 = true;
                } else {
                    z4 = true;
                    z3 = true;
                }
            } else if (z8) {
                throw k.a();
            }
            z6 = z2;
        } else if (z7) {
            if (z8) {
                throw k.a();
            }
        } else {
            if (!z8) {
                throw k.a();
            }
            z4 = true;
            z6 = z2;
        }
        if (z6) {
            if (z3) {
                throw k.a();
            }
            a.o(m(), n());
        }
        if (z3) {
            a.h(m(), n());
        }
        if (z4) {
            if (z5) {
                throw k.a();
            }
            a.o(k(), n());
        }
        if (z5) {
            a.h(k(), l());
        }
    }

    private static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private static p u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        r[] rVarArrA = dVar.d().a();
        r[] rVarArrA2 = dVar2.d().a();
        return new p(sb.toString(), null, new r[]{rVarArrA[0], rVarArrA[1], rVarArrA2[0], rVarArrA2[1]}, i.f.a.a.RSS_14);
    }

    private b v(i.f.a.v.a aVar, c cVar, boolean z) throws k {
        int[] iArrI = i();
        Arrays.fill(iArrI, 0);
        if (z) {
            i.f.a.y.k.g(aVar, cVar.b()[0], iArrI);
        } else {
            i.f.a.y.k.f(aVar, cVar.b()[1], iArrI);
            int i2 = 0;
            for (int length = iArrI.length - 1; i2 < length; length--) {
                int i3 = iArrI[i2];
                iArrI[i2] = iArrI[length];
                iArrI[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fD = i.f.a.v.m.a.d(iArrI) / i4;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i5 = 0; i5 < iArrI.length; i5++) {
            float f = iArrI[i5] / fD;
            int i6 = (int) (0.5f + f);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArrM[i7] = i6;
                fArrN[i7] = f - i6;
            } else {
                iArrK[i7] = i6;
                fArrL[i7] = f - i6;
            }
        }
        s(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + iArrM[length2];
            i9 += iArrM[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + iArrK[length3];
            i11 += iArrK[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw k.a();
            }
            int i13 = (10 - i11) / 2;
            int i14 = f1711n[i13];
            return new b((f.b(iArrK, 9 - i14, false) * f1707j[i13]) + f.b(iArrM, i14, true) + f1709l[i13], i12);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw k.a();
        }
        int i15 = (12 - i9) / 2;
        int i16 = f1710m[i15];
        return new b((f.b(iArrM, i16, false) * f1706i[i15]) + f.b(iArrK, 9 - i16, true) + f1708k[i15], i12);
    }

    private d w(i.f.a.v.a aVar, boolean z, int i2, Map<i.f.a.e, ?> map) {
        try {
            c cVarY = y(aVar, i2, z, x(aVar, z));
            s sVar = map == null ? null : (s) map.get(i.f.a.e.NEED_RESULT_POINT_CALLBACK);
            if (sVar != null) {
                int[] iArrB = cVarY.b();
                float fK = ((iArrB[0] + iArrB[1]) - 1) / 2.0f;
                if (z) {
                    fK = (aVar.k() - 1) - fK;
                }
                sVar.a(new r(fK, i2));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (k unused) {
            return null;
        }
    }

    private int[] x(i.f.a.v.a aVar, boolean z) throws k {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iK = aVar.k();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < iK) {
            z2 = !aVar.g(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        int i4 = i2;
        while (i2 < iK) {
            if (aVar.g(i2) != z2) {
                iArrJ[i3] = iArrJ[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else {
                    if (a.p(iArrJ)) {
                        return new int[]{i4, i2};
                    }
                    i4 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i3--;
                }
                iArrJ[i3] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw k.a();
    }

    private c y(i.f.a.v.a aVar, int i2, boolean z, int[] iArr) throws k {
        int iK;
        int i3;
        boolean zG = aVar.g(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zG != aVar.g(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i6;
        int iQ = a.q(iArrJ, f1712o);
        int i7 = iArr[1];
        if (z) {
            int iK2 = (aVar.k() - 1) - i5;
            iK = (aVar.k() - 1) - i7;
            i3 = iK2;
        } else {
            iK = i7;
            i3 = i5;
        }
        return new c(iQ, new int[]{i5, iArr[1]}, i3, iK, i2);
    }

    @Override // i.f.a.y.k, i.f.a.n
    public void b() {
        this.g.clear();
        this.f1713h.clear();
    }

    @Override // i.f.a.y.k
    public p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws k {
        r(this.g, w(aVar, false, i2, map));
        aVar.o();
        r(this.f1713h, w(aVar, true, i2, map));
        aVar.o();
        for (d dVar : this.g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f1713h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw k.a();
    }
}
