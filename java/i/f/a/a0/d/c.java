package i.f.a.a0.d;

import i.f.a.a0.c.u;
import i.f.a.k;
import i.f.a.r;
import i.f.a.s;
import i.f.a.v.i;
import java.util.Map;

/* loaded from: classes.dex */
public class c {
    private final i.f.a.v.b a;
    private s b;

    public c(i.f.a.v.b bVar) {
        this.a = bVar;
    }

    private float b(r rVar, r rVar2) {
        float fJ = j((int) rVar.c(), (int) rVar.d(), (int) rVar2.c(), (int) rVar2.d());
        float fJ2 = j((int) rVar2.c(), (int) rVar2.d(), (int) rVar.c(), (int) rVar.d());
        return Float.isNaN(fJ) ? fJ2 / 7.0f : Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    private static int c(r rVar, r rVar2, r rVar3, float f) throws k {
        int iC = ((i.f.a.v.m.a.c(r.b(rVar, rVar2) / f) + i.f.a.v.m.a.c(r.b(rVar, rVar3) / f)) / 2) + 7;
        int i2 = iC & 3;
        if (i2 == 0) {
            return iC + 1;
        }
        if (i2 == 2) {
            return iC - 1;
        }
        if (i2 != 3) {
            return iC;
        }
        throw k.a();
    }

    private static i.f.a.v.k d(r rVar, r rVar2, r rVar3, r rVar4, int i2) {
        float fC;
        float fD;
        float f;
        float f2 = i2 - 3.5f;
        if (rVar4 != null) {
            fC = rVar4.c();
            fD = rVar4.d();
            f = f2 - 3.0f;
        } else {
            fC = (rVar2.c() - rVar.c()) + rVar3.c();
            fD = (rVar2.d() - rVar.d()) + rVar3.d();
            f = f2;
        }
        return i.f.a.v.k.b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, rVar.c(), rVar.d(), rVar2.c(), rVar2.d(), fC, fD, rVar3.c(), rVar3.d());
    }

    private static i.f.a.v.b h(i.f.a.v.b bVar, i.f.a.v.k kVar, int i2) throws k {
        return i.b().d(bVar, i2, i2, kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (r15 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        return i.f.a.v.m.a.b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float i(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        c cVar;
        boolean z;
        int i12;
        int i13 = 1;
        boolean z2 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z2) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int iAbs = Math.abs(i8 - i6);
        int iAbs2 = Math.abs(i9 - i7);
        int i14 = 2;
        int i15 = (-iAbs) / 2;
        int i16 = i6 < i8 ? 1 : -1;
        int i17 = i7 < i9 ? 1 : -1;
        int i18 = i8 + i16;
        int i19 = i6;
        int i20 = i7;
        int i21 = 0;
        while (true) {
            if (i19 == i18) {
                i10 = i18;
                i11 = i14;
                break;
            }
            int i22 = z2 ? i20 : i19;
            int i23 = z2 ? i19 : i20;
            if (i21 == i13) {
                z = z2;
                i12 = i13;
                i10 = i18;
                cVar = this;
            } else {
                cVar = this;
                z = z2;
                i10 = i18;
                i12 = 0;
            }
            if (i12 == cVar.a.d(i22, i23)) {
                if (i21 == 2) {
                    return i.f.a.v.m.a.b(i19, i20, i6, i7);
                }
                i21++;
            }
            i15 += iAbs2;
            if (i15 > 0) {
                if (i20 == i9) {
                    i11 = 2;
                    break;
                }
                i20 += i17;
                i15 -= iAbs;
            }
            i19 += i16;
            i18 = i10;
            z2 = z;
            i13 = 1;
            i14 = 2;
        }
    }

    private float j(int i2, int i3, int i4, int i5) {
        float fJ;
        float fG;
        float fI = i(i2, i3, i4, i5);
        int iJ = i2 - (i4 - i2);
        int iG = 0;
        if (iJ < 0) {
            fJ = i2 / (i2 - iJ);
            iJ = 0;
        } else if (iJ >= this.a.j()) {
            fJ = ((this.a.j() - 1) - i2) / (iJ - i2);
            iJ = this.a.j() - 1;
        } else {
            fJ = 1.0f;
        }
        float f = i3;
        int i6 = (int) (f - ((i5 - i3) * fJ));
        if (i6 < 0) {
            fG = f / (i3 - i6);
        } else if (i6 >= this.a.g()) {
            fG = ((this.a.g() - 1) - i3) / (i6 - i3);
            iG = this.a.g() - 1;
        } else {
            iG = i6;
            fG = 1.0f;
        }
        return (fI + i(i2, i3, (int) (i2 + ((iJ - i2) * fG)), iG)) - 1.0f;
    }

    protected final float a(r rVar, r rVar2, r rVar3) {
        return (b(rVar, rVar2) + b(rVar, rVar3)) / 2.0f;
    }

    public final i.f.a.v.g e(Map<i.f.a.e, ?> map) throws k, i.f.a.g {
        this.b = map == null ? null : (s) map.get(i.f.a.e.NEED_RESULT_POINT_CALLBACK);
        return g(new g(this.a, this.b).g(map));
    }

    protected final a f(float f, int i2, int i3, float f2) throws k {
        int i4 = (int) (f2 * f);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.a.j() - 1, i2 + i4) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw k.a();
        }
        int iMax2 = Math.max(0, i3 - i4);
        int iMin2 = Math.min(this.a.g() - 1, i3 + i4) - iMax2;
        if (iMin2 >= f3) {
            return new b(this.a, iMax, iMax2, iMin, iMin2, f, this.b).c();
        }
        throw k.a();
    }

    protected final i.f.a.v.g g(h hVar) throws k, i.f.a.g {
        d dVarB = hVar.b();
        d dVarC = hVar.c();
        d dVarA = hVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw k.a();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        u uVarG = u.g(iC);
        int iE = uVarG.e() - 7;
        a aVarF = null;
        if (uVarG.d().length > 0) {
            float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
            float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
            float f = 1.0f - (3.0f / iE);
            int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f));
            int iD = (int) (dVarB.d() + (f * (fD - dVarB.d())));
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    aVarF = f(fA, iC2, iD, i2);
                    break;
                } catch (k unused) {
                }
            }
        }
        return new i.f.a.v.g(h(this.a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new r[]{dVarA, dVarB, dVarC} : new r[]{dVarA, dVarB, dVarC, aVarF});
    }
}
