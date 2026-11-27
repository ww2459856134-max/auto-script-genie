package i.f.a.w.c;

import i.f.a.k;
import i.f.a.r;
import i.f.a.v.b;
import i.f.a.v.g;
import i.f.a.v.i;

/* loaded from: classes.dex */
public final class a {
    private final b a;
    private final i.f.a.v.m.b b;

    public a(b bVar) throws k {
        this.a = bVar;
        this.b = new i.f.a.v.m.b(bVar);
    }

    private r a(r[] rVarArr) {
        r rVar = rVarArr[0];
        r rVar2 = rVarArr[1];
        r rVar3 = rVarArr[2];
        r rVar4 = rVarArr[3];
        int iJ = j(rVar, rVar4);
        r rVarH = h(rVar, rVar2, (j(rVar2, rVar4) + 1) << 2);
        r rVarH2 = h(rVar3, rVar2, (iJ + 1) << 2);
        int iJ2 = j(rVarH, rVar4);
        int iJ3 = j(rVarH2, rVar4);
        float f = iJ2 + 1;
        r rVar5 = new r(rVar4.c() + ((rVar3.c() - rVar2.c()) / f), rVar4.d() + ((rVar3.d() - rVar2.d()) / f));
        float f2 = iJ3 + 1;
        r rVar6 = new r(rVar4.c() + ((rVar.c() - rVar2.c()) / f2), rVar4.d() + ((rVar.d() - rVar2.d()) / f2));
        if (e(rVar5)) {
            return (e(rVar6) && j(rVarH, rVar5) + j(rVarH2, rVar5) <= j(rVarH, rVar6) + j(rVarH2, rVar6)) ? rVar6 : rVar5;
        }
        if (e(rVar6)) {
            return rVar6;
        }
        return null;
    }

    private r[] c(r[] rVarArr) {
        r rVar = rVarArr[0];
        r rVar2 = rVarArr[1];
        r rVar3 = rVarArr[3];
        r rVar4 = rVarArr[2];
        int iJ = j(rVar, rVar2);
        int iJ2 = j(rVar2, rVar3);
        int iJ3 = j(rVar3, rVar4);
        int iJ4 = j(rVar4, rVar);
        r[] rVarArr2 = {rVar4, rVar, rVar2, rVar3};
        if (iJ > iJ2) {
            rVarArr2[0] = rVar;
            rVarArr2[1] = rVar2;
            rVarArr2[2] = rVar3;
            rVarArr2[3] = rVar4;
            iJ = iJ2;
        }
        if (iJ > iJ3) {
            rVarArr2[0] = rVar2;
            rVarArr2[1] = rVar3;
            rVarArr2[2] = rVar4;
            rVarArr2[3] = rVar;
        } else {
            iJ3 = iJ;
        }
        if (iJ3 > iJ4) {
            rVarArr2[0] = rVar3;
            rVarArr2[1] = rVar4;
            rVarArr2[2] = rVar;
            rVarArr2[3] = rVar2;
        }
        return rVarArr2;
    }

    private r[] d(r[] rVarArr) {
        r rVar = rVarArr[0];
        r rVar2 = rVarArr[1];
        r rVar3 = rVarArr[2];
        r rVar4 = rVarArr[3];
        int iJ = (j(rVar, rVar4) + 1) << 2;
        if (j(h(rVar2, rVar3, iJ), rVar) < j(h(rVar3, rVar2, iJ), rVar4)) {
            rVarArr[0] = rVar;
            rVarArr[1] = rVar2;
            rVarArr[2] = rVar3;
            rVarArr[3] = rVar4;
        } else {
            rVarArr[0] = rVar2;
            rVarArr[1] = rVar3;
            rVarArr[2] = rVar4;
            rVarArr[3] = rVar;
        }
        return rVarArr;
    }

    private boolean e(r rVar) {
        return rVar.c() >= 0.0f && rVar.c() < ((float) this.a.j()) && rVar.d() > 0.0f && rVar.d() < ((float) this.a.g());
    }

    private static r f(r rVar, float f, float f2) {
        float fC = rVar.c();
        float fD = rVar.d();
        return new r(fC < f ? fC - 1.0f : fC + 1.0f, fD < f2 ? fD - 1.0f : fD + 1.0f);
    }

    private static b g(b bVar, r rVar, r rVar2, r rVar3, r rVar4, int i2, int i3) throws k {
        float f = i2 - 0.5f;
        float f2 = i3 - 0.5f;
        return i.b().c(bVar, i2, i3, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, rVar.c(), rVar.d(), rVar4.c(), rVar4.d(), rVar3.c(), rVar3.d(), rVar2.c(), rVar2.d());
    }

    private static r h(r rVar, r rVar2, int i2) {
        float f = i2 + 1;
        return new r(rVar.c() + ((rVar2.c() - rVar.c()) / f), rVar.d() + ((rVar2.d() - rVar.d()) / f));
    }

    private r[] i(r[] rVarArr) {
        r rVar = rVarArr[0];
        r rVar2 = rVarArr[1];
        r rVar3 = rVarArr[2];
        r rVar4 = rVarArr[3];
        int iJ = j(rVar, rVar4) + 1;
        r rVarH = h(rVar, rVar2, (j(rVar3, rVar4) + 1) << 2);
        r rVarH2 = h(rVar3, rVar2, iJ << 2);
        int iJ2 = j(rVarH, rVar4) + 1;
        int iJ3 = j(rVarH2, rVar4) + 1;
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if ((iJ3 & 1) == 1) {
            iJ3++;
        }
        float fC = (((rVar.c() + rVar2.c()) + rVar3.c()) + rVar4.c()) / 4.0f;
        float fD = (((rVar.d() + rVar2.d()) + rVar3.d()) + rVar4.d()) / 4.0f;
        r rVarF = f(rVar, fC, fD);
        r rVarF2 = f(rVar2, fC, fD);
        r rVarF3 = f(rVar3, fC, fD);
        r rVarF4 = f(rVar4, fC, fD);
        int i2 = iJ3 << 2;
        int i3 = iJ2 << 2;
        return new r[]{h(h(rVarF, rVarF2, i2), rVarF4, i3), h(h(rVarF2, rVarF, i2), rVarF3, i3), h(h(rVarF3, rVarF4, i2), rVarF2, i3), h(h(rVarF4, rVarF3, i2), rVarF, i3)};
    }

    private int j(r rVar, r rVar2) {
        int iC = (int) rVar.c();
        int iD = (int) rVar.d();
        int iC2 = (int) rVar2.c();
        int iD2 = (int) rVar2.d();
        int i2 = 0;
        boolean z = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i3 = (-iAbs) / 2;
        int i4 = iD < iD2 ? 1 : -1;
        int i5 = iC >= iC2 ? -1 : 1;
        boolean zD = this.a.d(z ? iD : iC, z ? iC : iD);
        while (iC != iC2) {
            boolean zD2 = this.a.d(z ? iD : iC, z ? iC : iD);
            if (zD2 != zD) {
                i2++;
                zD = zD2;
            }
            i3 += iAbs2;
            if (i3 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i4;
                i3 -= iAbs;
            }
            iC += i5;
        }
        return i2;
    }

    public g b() throws k {
        int iMax;
        int i2;
        r[] rVarArrC = c(this.b.c());
        d(rVarArrC);
        rVarArrC[3] = a(rVarArrC);
        if (rVarArrC[3] == null) {
            throw k.a();
        }
        r[] rVarArrI = i(rVarArrC);
        r rVar = rVarArrI[0];
        r rVar2 = rVarArrI[1];
        r rVar3 = rVarArrI[2];
        r rVar4 = rVarArrI[3];
        int iJ = j(rVar, rVar4) + 1;
        int iJ2 = j(rVar3, rVar4) + 1;
        if ((iJ & 1) == 1) {
            iJ++;
        }
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if (iJ * 4 >= iJ2 * 7 || iJ2 * 4 >= iJ * 7) {
            iMax = iJ;
            i2 = iJ2;
        } else {
            iMax = Math.max(iJ, iJ2);
            i2 = iMax;
        }
        return new g(g(this.a, rVar, rVar2, rVar3, rVar4, iMax, i2), new r[]{rVar, rVar2, rVar3, rVar4});
    }
}
