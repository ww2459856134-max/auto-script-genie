package i.f.a.v.n;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
final class b {
    private final a a;
    private final int[] b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
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

    b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = bVar.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new b(this.a, iArr3);
    }

    b[] b(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarG = this.a.g();
        int iH = this.a.h(bVar.d(bVar.f()));
        b bVarA = this;
        while (bVarA.f() >= bVar.f() && !bVarA.g()) {
            int iF = bVarA.f() - bVar.f();
            int iJ = this.a.j(bVarA.d(bVarA.f()), iH);
            b bVarJ = bVar.j(iF, iJ);
            bVarG = bVarG.a(this.a.b(iF, iJ));
            bVarA = bVarA.a(bVarJ);
        }
        return new b[]{bVarG, bVarA};
    }

    int c(int i2) {
        if (i2 == 0) {
            return d(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.b) {
                iA = a.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            iA2 = a.a(this.a.j(i2, iA2), this.b[i4]);
        }
        return iA2;
    }

    int d(int i2) {
        return this.b[(r0.length - 1) - i2];
    }

    int[] e() {
        return this.b;
    }

    int f() {
        return this.b.length - 1;
    }

    boolean g() {
        return this.b[0] == 0;
    }

    b h(int i2) {
        if (i2 == 0) {
            return this.a.g();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.j(this.b[i3], i2);
        }
        return new b(this.a, iArr);
    }

    b i(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.a.g();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = bVar.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = a.a(iArr3[i5], this.a.j(i3, iArr2[i4]));
            }
        }
        return new b(this.a, iArr3);
    }

    b j(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.g();
        }
        int length = this.b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.j(this.b[i4], i3);
        }
        return new b(this.a, iArr);
    }

    public String toString() {
        if (g()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    if (iF == f()) {
                        sb.append(ProcessIdUtil.DEFAULT_PROCESSID);
                    } else {
                        sb.append(" - ");
                    }
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i2 = this.a.i(iD);
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
