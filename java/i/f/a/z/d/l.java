package i.f.a.z.d;

import i.f.a.r;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class l {
    private static final i.f.a.z.d.m.a a = new i.f.a.z.d.m.a();

    private static c a(j jVar) throws i.f.a.k {
        int[] iArrJ;
        if (jVar == null || (iArrJ = jVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArrJ) {
            i3 += iP - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] dVarArrD = jVar.d();
        for (int i5 = 0; i3 > 0 && dVarArrD[i5] == null; i5++) {
            i3--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            i2 += iP - iArrJ[length];
            if (iArrJ[length] > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i2 > 0 && dVarArrD[length2] == null; length2--) {
            i2--;
        }
        return jVar.a().a(i3, i2, jVar.k());
    }

    private static void b(h hVar, b[][] bVarArr) throws i.f.a.k {
        b bVar = bVarArr[0][1];
        int[] iArrA = bVar.a();
        int iJ = (hVar.j() * hVar.l()) - r(hVar.k());
        if (iArrA.length == 0) {
            if (iJ <= 0 || iJ > 928) {
                throw i.f.a.k.a();
            }
            bVar.b(iJ);
            return;
        }
        if (iArrA[0] == iJ || iJ <= 0 || iJ > 928) {
            return;
        }
        bVar.b(iJ);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(i.f.a.v.b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = z ? -1 : 1;
        int i7 = 0;
        int i8 = i4;
        while (i7 < 2) {
            while (true) {
                if (z) {
                    if (i8 >= i2) {
                        if (z == bVar.d(i8, i5)) {
                            if (Math.abs(i4 - i8) > 2) {
                                return i4;
                            }
                            i8 += i6;
                        }
                    }
                } else if (i8 < i3) {
                }
            }
        }
        return i8;
    }

    private static boolean d(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i2) throws i.f.a.d {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return a.a(iArr, i2, iArr2);
        }
        throw i.f.a.d.a();
    }

    private static b[][] f(h hVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, hVar.l(), hVar.j() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (i iVar : hVar.o()) {
            if (iVar != null) {
                for (d dVar : iVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i4].b(dVar.e());
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static i.f.a.v.e g(h hVar) throws i.f.a.k, i.f.a.d, i.f.a.g {
        b[][] bVarArrF = f(hVar);
        b(hVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[hVar.l() * hVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < hVar.l(); i2++) {
            int i3 = 0;
            while (i3 < hVar.j()) {
                int i4 = i3 + 1;
                int[] iArrA = bVarArrF[i2][i4].a();
                int iJ = (hVar.j() * i2) + i3;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return h(hVar.k(), iArr, i.f.a.z.a.b(arrayList), i.f.a.z.a.b(arrayList3), iArr2);
    }

    private static i.f.a.v.e h(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws i.f.a.d, i.f.a.g {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                throw i.f.a.d.a();
            }
            for (int i5 = 0; i5 < length; i5++) {
                iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
            }
            try {
                return j(iArr, i2, iArr2);
            } catch (i.f.a.d unused) {
                if (length == 0) {
                    throw i.f.a.d.a();
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    if (iArr5[i6] < iArr4[i6].length - 1) {
                        iArr5[i6] = iArr5[i6] + 1;
                        break;
                    }
                    iArr5[i6] = 0;
                    if (i6 == length - 1) {
                        throw i.f.a.d.a();
                    }
                    i6++;
                }
                i3 = i4;
            }
        }
    }

    public static i.f.a.v.e i(i.f.a.v.b bVar, r rVar, r rVar2, r rVar3, r rVar4, int i2, int i3) throws i.f.a.k, i.f.a.d, i.f.a.g {
        c cVar;
        h hVarV;
        int i4;
        int i5;
        int i6;
        int i7;
        c cVar2 = new c(bVar, rVar, rVar2, rVar3, rVar4);
        j jVarS = null;
        j jVarS2 = null;
        boolean z = true;
        while (true) {
            cVar = cVar2;
            if (rVar != null) {
                jVarS = s(bVar, cVar, rVar, true, i2, i3);
            }
            if (rVar3 != null) {
                jVarS2 = s(bVar, cVar, rVar3, false, i2, i3);
            }
            hVarV = v(jVarS, jVarS2);
            if (hVarV == null) {
                throw i.f.a.k.a();
            }
            cVar2 = hVarV.m();
            if (!z || cVar2 == null || (cVar2.g() >= cVar.g() && cVar2.e() <= cVar.e())) {
                break;
            }
            z = false;
        }
        hVarV.p(cVar);
        int iJ = hVarV.j() + 1;
        hVarV.q(0, jVarS);
        hVarV.q(iJ, jVarS2);
        boolean z2 = jVarS != null;
        int iMin = i2;
        int iMax = i3;
        for (int i8 = 1; i8 <= iJ; i8++) {
            int i9 = z2 ? i8 : iJ - i8;
            if (hVarV.n(i9) == null) {
                i jVar = (i9 == 0 || i9 == iJ) ? new j(cVar, i9 == 0) : new i(cVar);
                hVarV.q(i9, jVar);
                int i10 = -1;
                int iG = cVar.g();
                int i11 = -1;
                while (iG <= cVar.e()) {
                    int iT = t(hVarV, i9, iG, z2);
                    if (iT >= 0 && iT <= cVar.d()) {
                        i7 = iT;
                    } else if (i11 != i10) {
                        i7 = i11;
                    } else {
                        i4 = i11;
                        i5 = iG;
                        i6 = i10;
                        i11 = i4;
                        iG = i5 + 1;
                        i10 = i6;
                    }
                    i4 = i11;
                    int i12 = iG;
                    i6 = i10;
                    d dVarK = k(bVar, cVar.f(), cVar.d(), z2, i7, i12, iMin, iMax);
                    i5 = i12;
                    if (dVarK != null) {
                        jVar.f(i5, dVarK);
                        iMin = Math.min(iMin, dVarK.f());
                        iMax = Math.max(iMax, dVarK.f());
                        i11 = i7;
                    } else {
                        i11 = i4;
                    }
                    iG = i5 + 1;
                    i10 = i6;
                }
            }
        }
        return g(hVarV);
    }

    private static i.f.a.v.e j(int[] iArr, int i2, int[] iArr2) throws i.f.a.d, i.f.a.g {
        if (iArr.length == 0) {
            throw i.f.a.g.a();
        }
        int i3 = 1 << (i2 + 1);
        int iE = e(iArr, iArr2, i3);
        w(iArr, i3);
        i.f.a.v.e eVarB = g.b(iArr, String.valueOf(i2));
        eVarB.k(Integer.valueOf(iE));
        eVarB.j(Integer.valueOf(iArr2.length));
        return eVarB;
    }

    private static d k(i.f.a.v.b bVar, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int iD;
        int iA;
        int iC = c(bVar, i2, i3, z, i4, i5);
        int[] iArrQ = q(bVar, i2, i3, z, iC, i5);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = i.f.a.v.m.a.d(iArrQ);
        if (z) {
            i8 = iC + iD2;
        } else {
            for (int i9 = 0; i9 < iArrQ.length / 2; i9++) {
                int i10 = iArrQ[i9];
                iArrQ[i9] = iArrQ[(iArrQ.length - 1) - i9];
                iArrQ[(iArrQ.length - 1) - i9] = i10;
            }
            iC -= iD2;
            i8 = iC;
        }
        if (d(iD2, i6, i7) && (iA = i.f.a.z.a.a((iD = k.d(iArrQ)))) != -1) {
            return new d(iC, i8, n(iD), iA);
        }
        return null;
    }

    private static a l(j jVar, j jVar2) {
        a aVarI;
        a aVarI2;
        if (jVar == null || (aVarI = jVar.i()) == null) {
            if (jVar2 == null) {
                return null;
            }
            return jVar2.i();
        }
        if (jVar2 == null || (aVarI2 = jVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    private static int[] m(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int n(int i2) {
        return o(m(i2));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i2 : iArr) {
            iMax = Math.max(iMax, i2);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] q(i.f.a.v.b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i4 < i2) {
                    break;
                }
            } else {
                if (i4 >= i3) {
                    break;
                }
                if (i7 >= 8) {
                    break;
                }
                if (bVar.d(i4, i5) == z2) {
                    iArr[i7] = iArr[i7] + 1;
                    i4 += i6;
                } else {
                    i7++;
                    z2 = !z2;
                }
            }
        }
        if (i7 != 8) {
            if (z) {
                i2 = i3;
            }
            if (i4 != i2 || i7 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int r(int i2) {
        return 2 << i2;
    }

    private static j s(i.f.a.v.b bVar, c cVar, r rVar, boolean z, int i2, int i3) {
        j jVar = new j(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int iC = (int) rVar.c();
            for (int iD = (int) rVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i5) {
                d dVarK = k(bVar, 0, bVar.j(), z, iC, iD, i2, i3);
                if (dVarK != null) {
                    jVar.f(iD, dVarK);
                    iC = z ? dVarK.d() : dVarK.b();
                }
            }
            i4++;
        }
        return jVar;
    }

    private static int t(h hVar, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        d dVarB = u(hVar, i5) ? hVar.n(i5).b(i3) : null;
        if (dVarB != null) {
            return z ? dVarB.b() : dVarB.d();
        }
        d dVarC = hVar.n(i2).c(i3);
        if (dVarC != null) {
            return z ? dVarC.d() : dVarC.b();
        }
        if (u(hVar, i5)) {
            dVarC = hVar.n(i5).c(i3);
        }
        if (dVarC != null) {
            return z ? dVarC.b() : dVarC.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (!u(hVar, i2)) {
                c cVarM = hVar.m();
                return z ? cVarM.f() : cVarM.d();
            }
            for (d dVar : hVar.n(i2).d()) {
                if (dVar != null) {
                    return (z ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                }
            }
            i6++;
        }
    }

    private static boolean u(h hVar, int i2) {
        return i2 >= 0 && i2 <= hVar.j() + 1;
    }

    private static h v(j jVar, j jVar2) throws i.f.a.k {
        a aVarL;
        if ((jVar == null && jVar2 == null) || (aVarL = l(jVar, jVar2)) == null) {
            return null;
        }
        return new h(aVarL, c.j(a(jVar), a(jVar2)));
    }

    private static void w(int[] iArr, int i2) throws i.f.a.g {
        if (iArr.length < 4) {
            throw i.f.a.g.a();
        }
        int i3 = iArr[0];
        if (i3 > iArr.length) {
            throw i.f.a.g.a();
        }
        if (i3 == 0) {
            if (i2 >= iArr.length) {
                throw i.f.a.g.a();
            }
            iArr[0] = iArr.length - i2;
        }
    }
}
