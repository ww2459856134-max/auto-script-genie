package i.f.a.w.b;

/* loaded from: classes.dex */
final class a {
    private final i.f.a.v.b a;
    private final i.f.a.v.b b;
    private final j c;

    a(i.f.a.v.b bVar) throws i.f.a.g {
        int iG = bVar.g();
        if (iG < 8 || iG > 144 || (iG & 1) != 0) {
            throw i.f.a.g.a();
        }
        this.c = j(bVar);
        i.f.a.v.b bVarA = a(bVar);
        this.a = bVarA;
        this.b = new i.f.a.v.b(bVarA.j(), bVarA.g());
    }

    private i.f.a.v.b a(i.f.a.v.b bVar) {
        int iF = this.c.f();
        int iE = this.c.e();
        if (bVar.g() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.c.c();
        int iB = this.c.b();
        int i2 = iF / iC;
        int i3 = iE / iB;
        i.f.a.v.b bVar2 = new i.f.a.v.b(i3 * iB, i2 * iC);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * iC;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 * iB;
                for (int i8 = 0; i8 < iC; i8++) {
                    int i9 = ((iC + 2) * i4) + 1 + i8;
                    int i10 = i5 + i8;
                    for (int i11 = 0; i11 < iB; i11++) {
                        if (bVar.d(((iB + 2) * i6) + 1 + i11, i9)) {
                            bVar2.l(i7 + i11, i10);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (h(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (h(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return h(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    private int e(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return h(1, i10, i2, i3) ? i11 | 1 : i11;
    }

    private int f(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (h(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return h(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int g(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    private boolean h(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.b.l(i3, i2);
        return this.a.d(i3, i2);
    }

    private int i(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (h(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (h(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (h(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (h(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private static j j(i.f.a.v.b bVar) throws i.f.a.g {
        return j.h(bVar.g(), bVar.j());
    }

    j b() {
        return this.c;
    }

    byte[] c() throws i.f.a.g {
        byte[] bArr = new byte[this.c.g()];
        int iG = this.a.g();
        int iJ = this.a.j();
        int i2 = 0;
        int i3 = 4;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i3 == iG && i2 == 0 && !z) {
                bArr[i4] = (byte) d(iG, iJ);
                i3 -= 2;
                i2 += 2;
                i4++;
                z = true;
            } else {
                int i5 = iG - 2;
                if (i3 == i5 && i2 == 0 && (iJ & 3) != 0 && !z2) {
                    bArr[i4] = (byte) e(iG, iJ);
                    i3 -= 2;
                    i2 += 2;
                    i4++;
                    z2 = true;
                } else if (i3 == iG + 4 && i2 == 2 && (iJ & 7) == 0 && !z3) {
                    bArr[i4] = (byte) f(iG, iJ);
                    i3 -= 2;
                    i2 += 2;
                    i4++;
                    z3 = true;
                } else if (i3 == i5 && i2 == 0 && (iJ & 7) == 4 && !z4) {
                    bArr[i4] = (byte) g(iG, iJ);
                    i3 -= 2;
                    i2 += 2;
                    i4++;
                    z4 = true;
                } else {
                    do {
                        if (i3 < iG && i2 >= 0 && !this.b.d(i2, i3)) {
                            bArr[i4] = (byte) i(i3, i2, iG, iJ);
                            i4++;
                        }
                        i3 -= 2;
                        i2 += 2;
                        if (i3 < 0) {
                            break;
                        }
                    } while (i2 < iJ);
                    int i6 = i3 + 1;
                    int i7 = i2 + 3;
                    do {
                        if (i6 >= 0 && i7 < iJ && !this.b.d(i7, i6)) {
                            bArr[i4] = (byte) i(i6, i7, iG, iJ);
                            i4++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= iG) {
                            break;
                        }
                    } while (i7 >= 0);
                    i3 = i6 + 3;
                    i2 = i7 + 1;
                }
            }
            if (i3 >= iG && i2 >= iJ) {
                break;
            }
        }
        if (i4 == this.c.g()) {
            return bArr;
        }
        throw i.f.a.g.a();
    }
}
