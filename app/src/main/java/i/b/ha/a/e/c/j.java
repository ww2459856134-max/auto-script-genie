package i.b.ha.a.e.c;

/* loaded from: classes.dex */
public class j {
    private final double[][] a;
    private final int[] b;
    private boolean c;
    private boolean d;

    public j(r rVar) {
        this(rVar, 1.0E-11d);
    }

    public double a() {
        if (this.d) {
            return 0.0d;
        }
        int length = this.b.length;
        double d = this.c ? 1.0d : -1.0d;
        for (int i2 = 0; i2 < length; i2++) {
            d *= this.a[i2][i2];
        }
        return d;
    }

    public j(r rVar, double d) {
        if (!rVar.g()) {
            throw new m(rVar.d(), rVar.a());
        }
        int iA = rVar.a();
        this.a = rVar.getData();
        this.b = new int[iA];
        for (int i2 = 0; i2 < iA; i2++) {
            this.b[i2] = i2;
        }
        this.c = true;
        this.d = false;
        int i3 = 0;
        while (i3 < iA) {
            for (int i4 = 0; i4 < i3; i4++) {
                double[] dArr = this.a[i4];
                double d2 = dArr[i3];
                for (int i5 = 0; i5 < i4; i5++) {
                    d2 -= dArr[i5] * this.a[i5][i3];
                }
                dArr[i3] = d2;
            }
            double dA = Double.NEGATIVE_INFINITY;
            int i6 = i3;
            int i7 = i6;
            while (i6 < iA) {
                double[] dArr2 = this.a[i6];
                double d3 = dArr2[i3];
                for (int i8 = 0; i8 < i3; i8++) {
                    d3 -= dArr2[i8] * this.a[i8][i3];
                }
                dArr2[i3] = d3;
                if (i.b.ha.a.e.g.j.a(d3) > dA) {
                    dA = i.b.ha.a.e.g.j.a(d3);
                    i7 = i6;
                }
                i6++;
            }
            if (i.b.ha.a.e.g.j.a(this.a[i7][i3]) < d) {
                this.d = true;
                return;
            }
            if (i7 != i3) {
                double[][] dArr3 = this.a;
                double[] dArr4 = dArr3[i7];
                double[] dArr5 = dArr3[i3];
                for (int i9 = 0; i9 < iA; i9++) {
                    double d4 = dArr4[i9];
                    dArr4[i9] = dArr5[i9];
                    dArr5[i9] = d4;
                }
                int[] iArr = this.b;
                int i10 = iArr[i7];
                iArr[i7] = iArr[i3];
                iArr[i3] = i10;
                this.c = !this.c;
            }
            double d5 = this.a[i3][i3];
            int i11 = i3 + 1;
            for (int i12 = i11; i12 < iA; i12++) {
                double[] dArr6 = this.a[i12];
                dArr6[i3] = dArr6[i3] / d5;
            }
            i3 = i11;
        }
    }
}
