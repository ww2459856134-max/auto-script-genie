package i.f.a.v.m;

import i.f.a.k;
import i.f.a.r;

/* loaded from: classes.dex */
public final class b {
    private final i.f.a.v.b a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public b(i.f.a.v.b bVar) throws k {
        this(bVar, 10, bVar.j() / 2, bVar.g() / 2);
    }

    private r[] a(r rVar, r rVar2, r rVar3, r rVar4) {
        float fC = rVar.c();
        float fD = rVar.d();
        float fC2 = rVar2.c();
        float fD2 = rVar2.d();
        float fC3 = rVar3.c();
        float fD3 = rVar3.d();
        float fC4 = rVar4.c();
        float fD4 = rVar4.d();
        return fC < ((float) this.c) / 2.0f ? new r[]{new r(fC4 - 1.0f, fD4 + 1.0f), new r(fC2 + 1.0f, fD2 + 1.0f), new r(fC3 - 1.0f, fD3 - 1.0f), new r(fC + 1.0f, fD - 1.0f)} : new r[]{new r(fC4 + 1.0f, fD4 + 1.0f), new r(fC2 + 1.0f, fD2 - 1.0f), new r(fC3 - 1.0f, fD3 + 1.0f), new r(fC - 1.0f, fD - 1.0f)};
    }

    private boolean b(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.a.d(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.a.d(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private r d(float f, float f2, float f3, float f4) {
        int iC = a.c(a.a(f, f2, f3, f4));
        float f5 = iC;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i2 = 0; i2 < iC; i2++) {
            float f8 = i2;
            int iC2 = a.c((f8 * f6) + f);
            int iC3 = a.c((f8 * f7) + f2);
            if (this.a.d(iC2, iC3)) {
                return new r(iC2, iC3);
            }
        }
        return null;
    }

    public r[] c() throws k {
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.g;
        int i5 = this.f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        while (z6) {
            boolean z7 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z2) || i3 >= this.c) {
                    break;
                }
                zB = b(i4, i5, i3, false);
                if (zB) {
                    i3++;
                    z2 = true;
                    z7 = true;
                } else if (!z2) {
                    i3++;
                }
            }
            if (i3 < this.c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z3) || i5 >= this.b) {
                        break;
                    }
                    zB2 = b(i2, i3, i5, true);
                    if (zB2) {
                        i5++;
                        z3 = true;
                        z7 = true;
                    } else if (!z3) {
                        i5++;
                    }
                }
                if (i5 < this.b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z4) || i2 < 0) {
                            break;
                        }
                        zB3 = b(i4, i5, i2, false);
                        if (zB3) {
                            i2--;
                            z4 = true;
                            z7 = true;
                        } else if (!z4) {
                            i2--;
                        }
                    }
                    if (i2 >= 0) {
                        z6 = z7;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z5) || i4 < 0) {
                                break;
                            }
                            zB4 = b(i2, i3, i4, true);
                            if (zB4) {
                                i4--;
                                z6 = true;
                                z5 = true;
                            } else if (!z5) {
                                i4--;
                            }
                        }
                        if (i4 < 0) {
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z) {
            throw k.a();
        }
        int i6 = i3 - i2;
        r rVarD = null;
        r rVarD2 = null;
        for (int i7 = 1; rVarD2 == null && i7 < i6; i7++) {
            rVarD2 = d(i2, i5 - i7, i2 + i7, i5);
        }
        if (rVarD2 == null) {
            throw k.a();
        }
        r rVarD3 = null;
        for (int i8 = 1; rVarD3 == null && i8 < i6; i8++) {
            rVarD3 = d(i2, i4 + i8, i2 + i8, i4);
        }
        if (rVarD3 == null) {
            throw k.a();
        }
        r rVarD4 = null;
        for (int i9 = 1; rVarD4 == null && i9 < i6; i9++) {
            rVarD4 = d(i3, i4 + i9, i3 - i9, i4);
        }
        if (rVarD4 == null) {
            throw k.a();
        }
        for (int i10 = 1; rVarD == null && i10 < i6; i10++) {
            rVarD = d(i3, i5 - i10, i3 - i10, i5);
        }
        if (rVarD != null) {
            return a(rVarD, rVarD2, rVarD4, rVarD3);
        }
        throw k.a();
    }

    public b(i.f.a.v.b bVar, int i2, int i3, int i4) throws k {
        this.a = bVar;
        int iG = bVar.g();
        this.b = iG;
        int iJ = bVar.j();
        this.c = iJ;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.d = i6;
        int i7 = i3 + i5;
        this.e = i7;
        int i8 = i4 - i5;
        this.g = i8;
        int i9 = i4 + i5;
        this.f = i9;
        if (i8 < 0 || i6 < 0 || i9 >= iG || i7 >= iJ) {
            throw k.a();
        }
    }
}
