package i.b.ha.a.e.c;

/* loaded from: classes.dex */
public class p {
    private double[][] a;
    private double[] b;
    private final double c;

    public p(r rVar, double d) {
        this.c = d;
        int iD = rVar.d();
        int iA = rVar.a();
        this.a = rVar.c().getData();
        this.b = new double[i.b.ha.a.e.g.j.q(iD, iA)];
        a(this.a);
    }

    protected void a(double[][] dArr) {
        for (int i2 = 0; i2 < i.b.ha.a.e.g.j.q(dArr.length, dArr[0].length); i2++) {
            c(i2, dArr);
        }
    }

    public h b() {
        return new o(this.a, this.b, this.c);
    }

    protected void c(int i2, double[][] dArr) {
        double[] dArr2 = dArr[i2];
        double d = 0.0d;
        for (int i3 = i2; i3 < dArr2.length; i3++) {
            double d2 = dArr2[i3];
            d += d2 * d2;
        }
        double dB = dArr2[i2] > 0.0d ? -i.b.ha.a.e.g.j.B(d) : i.b.ha.a.e.g.j.B(d);
        this.b[i2] = dB;
        if (dB != 0.0d) {
            dArr2[i2] = dArr2[i2] - dB;
            for (int i4 = i2 + 1; i4 < dArr.length; i4++) {
                double[] dArr3 = dArr[i4];
                double d3 = 0.0d;
                for (int i5 = i2; i5 < dArr3.length; i5++) {
                    d3 -= dArr3[i5] * dArr2[i5];
                }
                double d4 = d3 / (dArr2[i2] * dB);
                for (int i6 = i2; i6 < dArr3.length; i6++) {
                    dArr3[i6] = dArr3[i6] - (dArr2[i6] * d4);
                }
            }
        }
    }
}
