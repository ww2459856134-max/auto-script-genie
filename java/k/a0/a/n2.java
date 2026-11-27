package k.a0.a;

/* loaded from: classes.dex */
class n2 extends k.x.w0 {
    private int c;
    private String[] d;
    private int[] e;

    public n2(f2 f2Var, f2[] f2VarArr, k.w wVar) {
        super(f2Var);
        int iD = 0;
        for (f2 f2Var2 : f2VarArr) {
            iD += f2Var2.d();
        }
        byte[] bArr = new byte[iD + x().d()];
        System.arraycopy(x().c(), 0, bArr, 0, x().d());
        int iD2 = x().d() + 0;
        this.e = new int[f2VarArr.length];
        for (int i2 = 0; i2 < f2VarArr.length; i2++) {
            f2 f2Var3 = f2VarArr[i2];
            System.arraycopy(f2Var3.c(), 0, bArr, iD2, f2Var3.d());
            this.e[i2] = iD2;
            iD2 += f2Var3.d();
        }
        k.x.s0.d(bArr[0], bArr[1], bArr[2], bArr[3]);
        int iD3 = k.x.s0.d(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.c = iD3;
        this.d = new String[iD3];
        B(bArr, 8, wVar);
    }

    private void B(byte[] bArr, int i2, k.w wVar) {
        int i3 = i2;
        int iC = 0;
        int iD = 0;
        int i4 = 0;
        while (i4 < this.c) {
            int iC2 = k.x.s0.c(bArr[i3], bArr[i3 + 1]);
            int i5 = i3 + 2;
            byte b = bArr[i5];
            int i6 = i5 + 1;
            boolean z = (b & 4) != 0;
            boolean z2 = (b & 8) != 0;
            if (z2) {
                iC = k.x.s0.c(bArr[i6], bArr[i6 + 1]);
                i6 += 2;
            }
            int i7 = iC;
            if (z) {
                iD = k.x.s0.d(bArr[i6], bArr[i6 + 1], bArr[i6 + 2], bArr[i6 + 3]);
                i6 += 4;
            }
            int i8 = i6;
            int i9 = iD;
            boolean z3 = (b & 1) == 0;
            m2 m2Var = new m2();
            l2 l2Var = new l2();
            l2Var.a = z3;
            int iY = i8 + y(bArr, m2Var, i8, l2Var, iC2);
            this.d[i4] = l2Var.a ? k.x.y0.d(m2Var.a, iC2, 0, wVar) : k.x.y0.g(m2Var.a, iC2, 0);
            if (z2) {
                iY += i7 * 4;
            }
            if (z) {
                iY += i9;
            }
            i3 = iY;
            if (i3 > bArr.length) {
                k.y.a.b(false, "pos exceeds record length");
            }
            i4++;
            iC = i7;
            iD = i9;
        }
    }

    private int y(byte[] bArr, m2 m2Var, int i2, l2 l2Var, int i3) {
        int[] iArr;
        if (l2Var.a) {
            m2Var.a = new byte[i3];
        } else {
            m2Var.a = new byte[i3 * 2];
        }
        boolean z = false;
        int i4 = 0;
        while (true) {
            iArr = this.e;
            if (i4 >= iArr.length || z) {
                break;
            }
            z = i2 <= iArr[i4] && m2Var.a.length + i2 > iArr[i4];
            if (!z) {
                i4++;
            }
        }
        if (z) {
            int i5 = iArr[i4] - i2;
            System.arraycopy(bArr, i2, m2Var.a, 0, i5);
            return i5 + z(bArr, m2Var, i5, i4, l2Var, i3 - (l2Var.a ? i5 : i5 / 2));
        }
        byte[] bArr2 = m2Var.a;
        System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
        return m2Var.a.length;
    }

    private int z(byte[] bArr, m2 m2Var, int i2, int i3, l2 l2Var, int i4) {
        int i5 = i3;
        int i6 = i4;
        int i7 = this.e[i3];
        int i8 = 0;
        int i9 = i2;
        while (i6 > 0) {
            k.y.a.b(i5 < this.e.length, "continuation break index");
            boolean z = l2Var.a;
            if (z && bArr[i7] == 0) {
                int[] iArr = this.e;
                int iMin = i5 == iArr.length - 1 ? i6 : Math.min(i6, (iArr[i5 + 1] - i7) - 1);
                System.arraycopy(bArr, i7 + 1, m2Var.a, i9, iMin);
                i9 += iMin;
                i8 += iMin + 1;
                i6 -= iMin;
                l2Var.a = true;
            } else if (!z && bArr[i7] != 0) {
                int[] iArr2 = this.e;
                int iMin2 = i5 == iArr2.length - 1 ? i6 * 2 : Math.min(i6 * 2, (iArr2[i5 + 1] - i7) - 1);
                System.arraycopy(bArr, i7 + 1, m2Var.a, i9, iMin2);
                i9 += iMin2;
                i8 += iMin2 + 1;
                i6 -= iMin2 / 2;
                l2Var.a = false;
            } else if (z || bArr[i7] != 0) {
                byte[] bArr2 = m2Var.a;
                int i10 = i9 * 2;
                int iMin3 = i6 * 2;
                m2Var.a = new byte[i10 + iMin3];
                for (int i11 = 0; i11 < i9; i11++) {
                    m2Var.a[i11 * 2] = bArr2[i11];
                }
                int[] iArr3 = this.e;
                if (i5 != iArr3.length - 1) {
                    iMin3 = Math.min(iMin3, (iArr3[i5 + 1] - i7) - 1);
                }
                System.arraycopy(bArr, i7 + 1, m2Var.a, i10, iMin3);
                i8 += iMin3 + 1;
                i6 -= iMin3 / 2;
                l2Var.a = false;
                i9 = i10 + iMin3;
            } else {
                int[] iArr4 = this.e;
                int iMin4 = i5 == iArr4.length - 1 ? i6 : Math.min(i6, (iArr4[i5 + 1] - i7) - 1);
                for (int i12 = 0; i12 < iMin4; i12++) {
                    m2Var.a[i9] = bArr[i7 + i12 + 1];
                    i9 += 2;
                }
                i8 += iMin4 + 1;
                i6 -= iMin4;
                l2Var.a = false;
            }
            i5++;
            int[] iArr5 = this.e;
            if (i5 < iArr5.length) {
                i7 = iArr5[i5];
            }
        }
        return i8;
    }

    public String A(int i2) {
        k.y.a.a(i2 < this.c);
        return this.d[i2];
    }
}
