package i.f.a.z.d.m;

/* loaded from: classes.dex */
final class c {
    private final b a;
    private final int[] b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    c a(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return cVar;
        }
        if (cVar.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = cVar.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = this.a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new c(this.a, iArr3);
    }

    int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.b) {
                iA = this.a.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            b bVar = this.a;
            iA2 = bVar.a(bVar.i(i2, iA2), this.b[i4]);
        }
        return iA2;
    }

    int c(int i2) {
        return this.b[(r0.length - 1) - i2];
    }

    int d() {
        return this.b.length - 1;
    }

    boolean e() {
        return this.b[0] == 0;
    }

    c f(int i2) {
        if (i2 == 0) {
            return this.a.f();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.i(this.b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    c g(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || cVar.e()) {
            return this.a.f();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = cVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                b bVar = this.a;
                iArr3[i5] = bVar.a(iArr3[i5], bVar.i(i3, iArr2[i4]));
            }
        }
        return new c(this.a, iArr3);
    }

    c h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.f();
        }
        int length = this.b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.i(this.b[i4], i3);
        }
        return new c(this.a, iArr);
    }

    c i() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(0, this.b[i2]);
        }
        return new c(this.a, iArr);
    }

    c j(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
