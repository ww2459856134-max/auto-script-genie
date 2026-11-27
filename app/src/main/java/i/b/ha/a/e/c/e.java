package i.b.ha.a.e.c;

import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class e extends c implements Serializable {
    private double[][] d;

    public e(int i2, int i3) throws i.b.ha.a.e.b.k {
        super(i2, i3);
        this.d = (double[][]) Array.newInstance((Class<?>) double.class, i2, i3);
    }

    private void o(double[][] dArr) throws i.b.ha.a.e.b.l, i.b.ha.a.e.b.i, i.b.ha.a.e.b.b, i.b.ha.a.e.b.o {
        i(dArr, 0, 0);
    }

    private double[][] p() {
        int iD = d();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, iD, a());
        for (int i2 = 0; i2 < iD; i2++) {
            double[][] dArr2 = this.d;
            System.arraycopy(dArr2[i2], 0, dArr[i2], 0, dArr2[i2].length);
        }
        return dArr;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.d
    public int a() {
        double[][] dArr = this.d;
        if (dArr == null || dArr[0] == null) {
            return 0;
        }
        return dArr[0].length;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.d
    public int d() {
        double[][] dArr = this.d;
        if (dArr == null) {
            return 0;
        }
        return dArr.length;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.r
    public double e(int i2, int i3) throws i.b.ha.a.e.b.o {
        l.b(this, i2, i3);
        return this.d[i2][i3];
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.r
    public void f(int i2, int i3, double d) throws i.b.ha.a.e.b.o {
        l.b(this, i2, i3);
        this.d[i2][i3] = d;
    }

    @Override // i.b.ha.a.e.c.r
    public double[][] getData() {
        return p();
    }

    @Override // i.b.ha.a.e.c.c
    public r h(int i2, int i3) throws i.b.ha.a.e.b.k {
        return new e(i2, i3);
    }

    @Override // i.b.ha.a.e.c.c
    public void i(double[][] dArr, int i2, int i3) throws i.b.ha.a.e.b.l, i.b.ha.a.e.b.i, i.b.ha.a.e.b.b, i.b.ha.a.e.b.o {
        if (this.d != null) {
            super.i(dArr, i2, i3);
            return;
        }
        if (i2 > 0) {
            throw new i.b.ha.a.e.b.f(i.b.ha.a.e.b.p.d.FIRST_ROWS_NOT_INITIALIZED_YET, Integer.valueOf(i2));
        }
        if (i3 > 0) {
            throw new i.b.ha.a.e.b.f(i.b.ha.a.e.b.p.d.FIRST_COLUMNS_NOT_INITIALIZED_YET, Integer.valueOf(i3));
        }
        i.b.ha.a.e.g.m.a(dArr);
        if (dArr.length == 0) {
            throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_ROW);
        }
        int length = dArr[0].length;
        if (length == 0) {
            throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_COLUMN);
        }
        this.d = (double[][]) Array.newInstance((Class<?>) double.class, dArr.length, length);
        int i4 = 0;
        while (true) {
            double[][] dArr2 = this.d;
            if (i4 >= dArr2.length) {
                return;
            }
            if (dArr[i4].length != length) {
                throw new i.b.ha.a.e.b.b(dArr[i4].length, length);
            }
            System.arraycopy(dArr[i4], 0, dArr2[i4 + i2], i3, length);
            i4++;
        }
    }

    @Override // i.b.ha.a.e.c.c
    public double m(t tVar) {
        int iD = d();
        int iA = a();
        tVar.b(iD, iA, 0, iD - 1, 0, iA - 1);
        for (int i2 = 0; i2 < iD; i2++) {
            double[] dArr = this.d[i2];
            for (int i3 = 0; i3 < iA; i3++) {
                tVar.c(i2, i3, dArr[i3]);
            }
        }
        return tVar.a();
    }

    @Override // i.b.ha.a.e.c.c
    public double n(t tVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        l.e(this, i2, i3, i4, i5);
        tVar.b(d(), a(), i2, i3, i4, i5);
        while (i2 <= i3) {
            double[] dArr = this.d[i2];
            for (int i6 = i4; i6 <= i5; i6++) {
                tVar.c(i2, i6, dArr[i6]);
            }
            i2++;
        }
        return tVar.a();
    }

    public e q(e eVar) throws i.b.ha.a.e.b.b {
        l.c(this, eVar);
        int iD = d();
        int iA = eVar.a();
        int iA2 = a();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, iD, iA);
        double[] dArr2 = new double[iA2];
        double[][] dArr3 = eVar.d;
        for (int i2 = 0; i2 < iA; i2++) {
            for (int i3 = 0; i3 < iA2; i3++) {
                dArr2[i3] = dArr3[i3][i2];
            }
            for (int i4 = 0; i4 < iD; i4++) {
                double[] dArr4 = this.d[i4];
                double d = 0.0d;
                for (int i5 = 0; i5 < iA2; i5++) {
                    d += dArr4[i5] * dArr2[i5];
                }
                dArr[i4][i2] = d;
            }
        }
        return new e(dArr, false);
    }

    public e(double[][] dArr) throws i.b.ha.a.e.b.l, i.b.ha.a.e.b.i, i.b.ha.a.e.b.b, i.b.ha.a.e.b.o {
        o(dArr);
    }

    public e(double[][] dArr, boolean z) throws i.b.ha.a.e.b.l, i.b.ha.a.e.b.i, i.b.ha.a.e.b.b, i.b.ha.a.e.b.o {
        if (z) {
            o(dArr);
            return;
        }
        if (dArr != null) {
            int length = dArr.length;
            if (length != 0) {
                int length2 = dArr[0].length;
                if (length2 != 0) {
                    for (int i2 = 1; i2 < length; i2++) {
                        if (dArr[i2].length != length2) {
                            throw new i.b.ha.a.e.b.b(dArr[i2].length, length2);
                        }
                    }
                    this.d = dArr;
                    return;
                }
                throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_COLUMN);
            }
            throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_ROW);
        }
        throw new i.b.ha.a.e.b.l();
    }
}
