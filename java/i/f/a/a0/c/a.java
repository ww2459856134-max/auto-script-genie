package i.f.a.a0.c;

/* loaded from: classes.dex */
final class a {
    private final i.f.a.v.b a;
    private u b;
    private p c;
    private boolean d;

    a(i.f.a.v.b bVar) throws i.f.a.g {
        int iG = bVar.g();
        if (iG < 21 || (iG & 3) != 1) {
            throw i.f.a.g.a();
        }
        this.a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.d ? this.a.d(i3, i2) : this.a.d(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    void b() {
        int i2 = 0;
        while (i2 < this.a.j()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.a.g(); i4++) {
                if (this.a.d(i2, i4) != this.a.d(i4, i2)) {
                    this.a.c(i4, i2);
                    this.a.c(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    byte[] c() throws i.f.a.g {
        p pVarD = d();
        u uVarE = e();
        k kVar = k.values()[pVarD.c()];
        int iG = this.a.g();
        kVar.b(this.a, iG);
        i.f.a.v.b bVarA = uVarE.a();
        byte[] bArr = new byte[uVarE.h()];
        int i2 = iG - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < iG; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!bVarA.d(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.a.d(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == uVarE.h()) {
            return bArr;
        }
        throw i.f.a.g.a();
    }

    p d() throws i.f.a.g {
        p pVar = this.c;
        if (pVar != null) {
            return pVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int iG = this.a.g();
        int i4 = iG - 7;
        for (int i5 = iG - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = iG - 8; i6 < iG; i6++) {
            iA = a(i6, 8, iA);
        }
        p pVarA = p.a(iA3, iA);
        this.c = pVarA;
        if (pVarA != null) {
            return pVarA;
        }
        throw i.f.a.g.a();
    }

    u e() throws i.f.a.g {
        u uVar = this.b;
        if (uVar != null) {
            return uVar;
        }
        int iG = this.a.g();
        int i2 = (iG - 17) / 4;
        if (i2 <= 6) {
            return u.i(i2);
        }
        int i3 = iG - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = iG - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        u uVarC = u.c(iA2);
        if (uVarC != null && uVarC.e() == iG) {
            this.b = uVarC;
            return uVarC;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = iG - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        u uVarC2 = u.c(iA);
        if (uVarC2 == null || uVarC2.e() != iG) {
            throw i.f.a.g.a();
        }
        this.b = uVarC2;
        return uVarC2;
    }

    void f() {
        if (this.c == null) {
            return;
        }
        k.values()[this.c.c()].b(this.a, this.a.g());
    }

    void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
