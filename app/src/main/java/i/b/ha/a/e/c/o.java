package i.b.ha.a.e.c;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
class o implements h {
    private final double[][] a;
    private final double[] b;
    private final double c;

    @Override // i.b.ha.a.e.c.h
    public u a(u uVar) {
        double[][] dArr = this.a;
        int length = dArr.length;
        int length2 = dArr[0].length;
        if (uVar.a() != length2) {
            throw new i.b.ha.a.e.b.b(uVar.a(), length2);
        }
        if (!c()) {
            throw new w();
        }
        double[] dArr2 = new double[length];
        double[] dArrD = uVar.d();
        for (int i2 = 0; i2 < i.b.ha.a.e.g.j.q(length2, length); i2++) {
            double[] dArr3 = this.a[i2];
            double d = 0.0d;
            for (int i3 = i2; i3 < length2; i3++) {
                d += dArrD[i3] * dArr3[i3];
            }
            double d2 = d / (this.b[i2] * dArr3[i2]);
            for (int i4 = i2; i4 < length2; i4++) {
                dArrD[i4] = dArrD[i4] + (dArr3[i4] * d2);
            }
        }
        for (int length3 = this.b.length - 1; length3 >= 0; length3--) {
            dArrD[length3] = dArrD[length3] / this.b[length3];
            double d3 = dArrD[length3];
            double[] dArr4 = this.a[length3];
            dArr2[length3] = d3;
            for (int i5 = 0; i5 < length3; i5++) {
                dArrD[i5] = dArrD[i5] - (dArr4[i5] * d3);
            }
        }
        return new f(dArr2, false);
    }

    @Override // i.b.ha.a.e.c.h
    public r b() {
        return d(l.f(this.a[0].length));
    }

    public boolean c() {
        for (double d : this.b) {
            if (i.b.ha.a.e.g.j.a(d) <= this.c) {
                return false;
            }
        }
        return true;
    }

    public r d(r rVar) throws k, i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        double d;
        double[][] dArr = this.a;
        int length = dArr.length;
        int i2 = 0;
        int length2 = dArr[0].length;
        if (rVar.d() != length2) {
            throw new i.b.ha.a.e.b.b(rVar.d(), length2);
        }
        if (!c()) {
            throw new w();
        }
        int iA = rVar.a();
        int i3 = ((iA + 52) - 1) / 52;
        double[][] dArrQ = g.q(length, iA);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, rVar.d(), 52);
        double[] dArr3 = new double[52];
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i4 * 52;
            int iQ = i.b.ha.a.e.g.j.q(i5 + 52, iA);
            int i6 = iQ - i5;
            int i7 = i4;
            rVar.b(0, length2 - 1, i5, iQ - 1, dArr2);
            int i8 = i2;
            while (true) {
                d = 1.0d;
                if (i8 >= i.b.ha.a.e.g.j.q(length2, length)) {
                    break;
                }
                double[] dArr4 = this.a[i8];
                double d2 = 1.0d / (this.b[i8] * dArr4[i8]);
                Arrays.fill(dArr3, i2, i6, 0.0d);
                int i9 = i8;
                while (i9 < length2) {
                    double d3 = dArr4[i9];
                    double[] dArr5 = dArr2[i9];
                    while (i2 < i6) {
                        dArr3[i2] = dArr3[i2] + (dArr5[i2] * d3);
                        i2++;
                    }
                    i9++;
                    i2 = 0;
                }
                for (int i10 = 0; i10 < i6; i10++) {
                    dArr3[i10] = dArr3[i10] * d2;
                }
                for (int i11 = i8; i11 < length2; i11++) {
                    double d4 = dArr4[i11];
                    double[] dArr6 = dArr2[i11];
                    for (int i12 = 0; i12 < i6; i12++) {
                        dArr6[i12] = dArr6[i12] + (dArr3[i12] * d4);
                    }
                }
                i8++;
                i2 = 0;
            }
            int length3 = this.b.length - 1;
            while (length3 >= 0) {
                int i13 = length3 / 52;
                int i14 = i13 * 52;
                double d5 = d / this.b[length3];
                double[] dArr7 = dArr2[length3];
                double[] dArr8 = dArrQ[(i13 * i3) + i7];
                int i15 = (length3 - i14) * i6;
                int i16 = 0;
                while (i16 < i6) {
                    dArr7[i16] = dArr7[i16] * d5;
                    dArr8[i15] = dArr7[i16];
                    i16++;
                    i15++;
                }
                double[] dArr9 = this.a[length3];
                for (int i17 = 0; i17 < length3; i17++) {
                    double d6 = dArr9[i17];
                    double[] dArr10 = dArr2[i17];
                    for (int i18 = 0; i18 < i6; i18++) {
                        dArr10[i18] = dArr10[i18] - (dArr7[i18] * d6);
                    }
                }
                length3--;
                d = 1.0d;
            }
            i4 = i7 + 1;
            i2 = 0;
        }
        return new g(length, iA, dArrQ, false);
    }

    private o(double[][] dArr, double[] dArr2, double d) {
        this.a = dArr;
        this.b = dArr2;
        this.c = d;
    }
}
