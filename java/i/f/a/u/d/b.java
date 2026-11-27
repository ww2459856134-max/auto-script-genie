package i.f.a.u.d;

import i.f.a.k;
import i.f.a.r;
import i.f.a.v.i;
import i.f.a.v.n.c;
import i.f.a.v.n.e;

/* loaded from: classes.dex */
public final class b {
    private static final int[] g = {3808, 476, 2107, 1799};
    private final i.f.a.v.b a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public b(i.f.a.v.b bVar) {
        this.a = bVar;
    }

    private static float b(r rVar, r rVar2) {
        return i.f.a.v.m.a.a(rVar.c(), rVar.d(), rVar2.c(), rVar2.d());
    }

    private static float c(a aVar, a aVar2) {
        return i.f.a.v.m.a.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static r[] d(r[] rVarArr, int i2, int i3) {
        float f = i3 / (i2 * 2.0f);
        float fC = rVarArr[0].c() - rVarArr[2].c();
        float fD = rVarArr[0].d() - rVarArr[2].d();
        float fC2 = (rVarArr[0].c() + rVarArr[2].c()) / 2.0f;
        float fD2 = (rVarArr[0].d() + rVarArr[2].d()) / 2.0f;
        float f2 = fC * f;
        float f3 = fD * f;
        r rVar = new r(fC2 + f2, fD2 + f3);
        r rVar2 = new r(fC2 - f2, fD2 - f3);
        float fC3 = rVarArr[1].c() - rVarArr[3].c();
        float fD3 = rVarArr[1].d() - rVarArr[3].d();
        float fC4 = (rVarArr[1].c() + rVarArr[3].c()) / 2.0f;
        float fD4 = (rVarArr[1].d() + rVarArr[3].d()) / 2.0f;
        float f4 = fC3 * f;
        float f5 = f * fD3;
        return new r[]{rVar, new r(fC4 + f4, fD4 + f5), rVar2, new r(fC4 - f4, fD4 - f5)};
    }

    private void e(r[] rVarArr) throws k {
        long j2;
        long j3;
        if (!o(rVarArr[0]) || !o(rVarArr[1]) || !o(rVarArr[2]) || !o(rVarArr[3])) {
            throw k.a();
        }
        int i2 = this.e * 2;
        int[] iArr = {r(rVarArr[0], rVarArr[1], i2), r(rVarArr[1], rVarArr[2], i2), r(rVarArr[2], rVarArr[3], i2), r(rVarArr[3], rVarArr[0], i2)};
        this.f = m(iArr, i2);
        long j4 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f + i3) % 4];
            if (this.b) {
                j2 = j4 << 7;
                j3 = (i4 >> 1) & 127;
            } else {
                j2 = j4 << 10;
                j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
            }
            j4 = j2 + j3;
        }
        int iH = h(j4, this.b);
        if (this.b) {
            this.c = (iH >> 6) + 1;
            this.d = (iH & 63) + 1;
        } else {
            this.c = (iH >> 11) + 1;
            this.d = (iH & 2047) + 1;
        }
    }

    private r[] f(a aVar) throws k {
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z = true;
        while (this.e < 9) {
            a aVarJ = j(aVar, z, 1, -1);
            a aVarJ2 = j(aVar2, z, 1, 1);
            a aVarJ3 = j(aVar3, z, -1, 1);
            a aVarJ4 = j(aVar4, z, -1, -1);
            if (this.e > 2) {
                double dC = (c(aVarJ4, aVarJ) * this.e) / (c(aVar4, aVar) * (this.e + 2));
                if (dC < 0.75d || dC > 1.25d || !p(aVarJ, aVarJ2, aVarJ3, aVarJ4)) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar4 = aVarJ4;
            aVar = aVarJ;
            aVar2 = aVarJ2;
            aVar3 = aVarJ3;
        }
        int i2 = this.e;
        if (i2 != 5 && i2 != 7) {
            throw k.a();
        }
        this.b = i2 == 5;
        r[] rVarArr = {new r(aVar.a() + 0.5f, aVar.b() - 0.5f), new r(aVar2.a() + 0.5f, aVar2.b() + 0.5f), new r(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new r(aVar4.a() - 0.5f, aVar4.b() - 0.5f)};
        int i3 = this.e;
        return d(rVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private int g(a aVar, a aVar2) {
        float fC = c(aVar, aVar2);
        float fA = (aVar2.a() - aVar.a()) / fC;
        float fB = (aVar2.b() - aVar.b()) / fC;
        float fA2 = aVar.a();
        float fB2 = aVar.b();
        boolean zD = this.a.d(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fC);
        int i2 = 0;
        for (int i3 = 0; i3 < iCeil; i3++) {
            fA2 += fA;
            fB2 += fB;
            if (this.a.d(i.f.a.v.m.a.c(fA2), i.f.a.v.m.a.c(fB2)) != zD) {
                i2++;
            }
        }
        float f = i2 / fC;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zD ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j2, boolean z) throws k {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(i.f.a.v.n.a.f1690k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (e unused) {
            throw k.a();
        }
    }

    private int i() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i2 = this.c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private a j(a aVar, boolean z, int i2, int i3) {
        int iA = aVar.a() + i2;
        int iB = aVar.b();
        while (true) {
            iB += i3;
            if (!n(iA, iB) || this.a.d(iA, iB) != z) {
                break;
            }
            iA += i2;
        }
        int i4 = iA - i2;
        int i5 = iB - i3;
        while (n(i4, i5) && this.a.d(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (n(i6, i5) && this.a.d(i6, i5) == z) {
            i5 += i3;
        }
        return new a(i6, i5 - i3);
    }

    private a k() {
        r rVarC;
        r rVar;
        r rVar2;
        r rVar3;
        r rVarC2;
        r rVarC3;
        r rVarC4;
        r rVarC5;
        try {
            r[] rVarArrC = new i.f.a.v.m.b(this.a).c();
            rVar2 = rVarArrC[0];
            rVar3 = rVarArrC[1];
            rVar = rVarArrC[2];
            rVarC = rVarArrC[3];
        } catch (k unused) {
            int iJ = this.a.j() / 2;
            int iG = this.a.g() / 2;
            int i2 = iJ + 7;
            int i3 = iG - 7;
            r rVarC6 = j(new a(i2, i3), false, 1, -1).c();
            int i4 = iG + 7;
            r rVarC7 = j(new a(i2, i4), false, 1, 1).c();
            int i5 = iJ - 7;
            r rVarC8 = j(new a(i5, i4), false, -1, 1).c();
            rVarC = j(new a(i5, i3), false, -1, -1).c();
            rVar = rVarC8;
            rVar2 = rVarC6;
            rVar3 = rVarC7;
        }
        int iC = i.f.a.v.m.a.c((((rVar2.c() + rVarC.c()) + rVar3.c()) + rVar.c()) / 4.0f);
        int iC2 = i.f.a.v.m.a.c((((rVar2.d() + rVarC.d()) + rVar3.d()) + rVar.d()) / 4.0f);
        try {
            r[] rVarArrC2 = new i.f.a.v.m.b(this.a, 15, iC, iC2).c();
            rVarC2 = rVarArrC2[0];
            rVarC3 = rVarArrC2[1];
            rVarC4 = rVarArrC2[2];
            rVarC5 = rVarArrC2[3];
        } catch (k unused2) {
            int i6 = iC + 7;
            int i7 = iC2 - 7;
            rVarC2 = j(new a(i6, i7), false, 1, -1).c();
            int i8 = iC2 + 7;
            rVarC3 = j(new a(i6, i8), false, 1, 1).c();
            int i9 = iC - 7;
            rVarC4 = j(new a(i9, i8), false, -1, 1).c();
            rVarC5 = j(new a(i9, i7), false, -1, -1).c();
        }
        return new a(i.f.a.v.m.a.c((((rVarC2.c() + rVarC5.c()) + rVarC3.c()) + rVarC4.c()) / 4.0f), i.f.a.v.m.a.c((((rVarC2.d() + rVarC5.d()) + rVarC3.d()) + rVarC4.d()) / 4.0f));
    }

    private r[] l(r[] rVarArr) {
        return d(rVarArr, this.e * 2, i());
    }

    private static int m(int[] iArr, int i2) throws k {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw k.a();
    }

    private boolean n(int i2, int i3) {
        return i2 >= 0 && i2 < this.a.j() && i3 > 0 && i3 < this.a.g();
    }

    private boolean o(r rVar) {
        return n(i.f.a.v.m.a.c(rVar.c()), i.f.a.v.m.a.c(rVar.d()));
    }

    private boolean p(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iG = g(aVar8, aVar5);
        return iG != 0 && g(aVar5, aVar6) == iG && g(aVar6, aVar7) == iG && g(aVar7, aVar8) == iG;
    }

    private i.f.a.v.b q(i.f.a.v.b bVar, r rVar, r rVar2, r rVar3, r rVar4) throws k {
        i iVarB = i.b();
        int i2 = i();
        float f = i2 / 2.0f;
        int i3 = this.e;
        float f2 = f - i3;
        float f3 = f + i3;
        return iVarB.c(bVar, i2, i2, f2, f2, f3, f2, f3, f3, f2, f3, rVar.c(), rVar.d(), rVar2.c(), rVar2.d(), rVar3.c(), rVar3.d(), rVar4.c(), rVar4.d());
    }

    private int r(r rVar, r rVar2, int i2) {
        float fB = b(rVar, rVar2);
        float f = fB / i2;
        float fC = rVar.c();
        float fD = rVar.d();
        float fC2 = ((rVar2.c() - rVar.c()) * f) / fB;
        float fD2 = (f * (rVar2.d() - rVar.d())) / fB;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f2 = i4;
            if (this.a.d(i.f.a.v.m.a.c((f2 * fC2) + fC), i.f.a.v.m.a.c((f2 * fD2) + fD))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public i.f.a.u.a a(boolean z) throws k {
        r[] rVarArrF = f(k());
        if (z) {
            r rVar = rVarArrF[0];
            rVarArrF[0] = rVarArrF[2];
            rVarArrF[2] = rVar;
        }
        e(rVarArrF);
        i.f.a.v.b bVar = this.a;
        int i2 = this.f;
        return new i.f.a.u.a(q(bVar, rVarArrF[i2 % 4], rVarArrF[(i2 + 1) % 4], rVarArrF[(i2 + 2) % 4], rVarArrF[(i2 + 3) % 4]), l(rVarArrF), this.b, this.d, this.c);
    }
}
