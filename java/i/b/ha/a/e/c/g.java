package i.b.ha.a.e.c;

import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class g extends c implements Serializable {
    private final double[][] d;
    private final int e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1488h;

    public g(int i2, int i3) throws i.b.ha.a.e.b.k {
        super(i2, i3);
        this.e = i2;
        this.f = i3;
        this.g = ((i2 + 52) - 1) / 52;
        this.f1488h = ((i3 + 52) - 1) / 52;
        this.d = q(i2, i3);
    }

    private int o(int i2) {
        if (i2 == this.g - 1) {
            return this.e - (i2 * 52);
        }
        return 52;
    }

    private int p(int i2) {
        if (i2 == this.f1488h - 1) {
            return this.f - (i2 * 52);
        }
        return 52;
    }

    public static double[][] q(int i2, int i3) {
        int i4 = ((i2 + 52) - 1) / 52;
        int i5 = ((i3 + 52) - 1) / 52;
        double[][] dArr = new double[i4 * i5][];
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = i7 * 52;
            int iQ = i.b.ha.a.e.g.j.q(i8 + 52, i2) - i8;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = i9 * 52;
                dArr[i6] = new double[(i.b.ha.a.e.g.j.q(i10 + 52, i3) - i10) * iQ];
                i6++;
            }
        }
        return dArr;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.d
    public int a() {
        return this.f;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.d
    public int d() {
        return this.e;
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.r
    public double e(int i2, int i3) throws i.b.ha.a.e.b.o {
        l.b(this, i2, i3);
        int i4 = i2 / 52;
        int i5 = i3 / 52;
        return this.d[(i4 * this.f1488h) + i5][((i2 - (i4 * 52)) * p(i5)) + (i3 - (i5 * 52))];
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.r
    public void f(int i2, int i3, double d) throws i.b.ha.a.e.b.o {
        l.b(this, i2, i3);
        int i4 = i2 / 52;
        int i5 = i3 / 52;
        this.d[(i4 * this.f1488h) + i5][((i2 - (i4 * 52)) * p(i5)) + (i3 - (i5 * 52))] = d;
    }

    @Override // i.b.ha.a.e.c.r
    public double[][] getData() {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, d(), a());
        int i2 = this.f - ((this.f1488h - 1) * 52);
        for (int i3 = 0; i3 < this.g; i3++) {
            int i4 = i3 * 52;
            int iQ = i.b.ha.a.e.g.j.q(i4 + 52, this.e);
            int i5 = 0;
            int i6 = 0;
            while (i4 < iQ) {
                double[] dArr2 = dArr[i4];
                int i7 = this.f1488h * i3;
                int i8 = 0;
                int i9 = 0;
                while (i8 < this.f1488h - 1) {
                    System.arraycopy(this.d[i7], i5, dArr2, i9, 52);
                    i9 += 52;
                    i8++;
                    i7++;
                }
                System.arraycopy(this.d[i7], i6, dArr2, i9, i2);
                i5 += 52;
                i6 += i2;
                i4++;
            }
        }
        return dArr;
    }

    @Override // i.b.ha.a.e.c.c
    public double k(t tVar) {
        int i2 = this.e;
        int i3 = this.f;
        tVar.b(i2, i3, 0, i2 - 1, 0, i3 - 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.g; i5++) {
            int i6 = i5 * 52;
            int iQ = i.b.ha.a.e.g.j.q(i6 + 52, this.e);
            for (int i7 = 0; i7 < this.f1488h; i7++) {
                int i8 = i7 * 52;
                int iQ2 = i.b.ha.a.e.g.j.q(i8 + 52, this.f);
                double[] dArr = this.d[i4];
                int i9 = 0;
                for (int i10 = i6; i10 < iQ; i10++) {
                    for (int i11 = i8; i11 < iQ2; i11++) {
                        tVar.c(i10, i11, dArr[i9]);
                        i9++;
                    }
                }
                i4++;
            }
        }
        return tVar.a();
    }

    @Override // i.b.ha.a.e.c.c
    public double l(t tVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        g gVar = this;
        l.e(gVar, i2, i3, i4, i5);
        tVar.b(gVar.e, gVar.f, i2, i3, i4, i5);
        int i6 = i2 / 52;
        while (i6 < (i3 / 52) + 1) {
            int i7 = i6 * 52;
            int iO = i.b.ha.a.e.g.j.o(i2, i7);
            int i8 = i6 + 1;
            int iQ = i.b.ha.a.e.g.j.q(i8 * 52, i3 + 1);
            int i9 = i4 / 52;
            while (i9 < (i5 / 52) + 1) {
                int iP = gVar.p(i9);
                int i10 = i9 * 52;
                int iO2 = i.b.ha.a.e.g.j.o(i4, i10);
                int i11 = i9 + 1;
                int i12 = iO;
                int iQ2 = i.b.ha.a.e.g.j.q(i11 * 52, i5 + 1);
                int i13 = i8;
                double[] dArr = gVar.d[(gVar.f1488h * i6) + i9];
                int i14 = i12;
                while (i14 < iQ) {
                    int i15 = (((i14 - i7) * iP) + iO2) - i10;
                    int i16 = iO2;
                    while (i16 < iQ2) {
                        tVar.c(i14, i16, dArr[i15]);
                        i15++;
                        i16++;
                        i6 = i6;
                        i7 = i7;
                        iQ2 = iQ2;
                    }
                    i14++;
                    iQ2 = iQ2;
                }
                gVar = this;
                i9 = i11;
                iO = i12;
                i8 = i13;
            }
            gVar = this;
            i6 = i8;
        }
        return tVar.a();
    }

    @Override // i.b.ha.a.e.c.c
    public double m(t tVar) {
        int i2 = this.e;
        int i3 = this.f;
        tVar.b(i2, i3, 0, i2 - 1, 0, i3 - 1);
        for (int i4 = 0; i4 < this.g; i4++) {
            int i5 = i4 * 52;
            int iQ = i.b.ha.a.e.g.j.q(i5 + 52, this.e);
            for (int i6 = i5; i6 < iQ; i6++) {
                for (int i7 = 0; i7 < this.f1488h; i7++) {
                    int iP = p(i7);
                    int i8 = i7 * 52;
                    int iQ2 = i.b.ha.a.e.g.j.q(i8 + 52, this.f);
                    double[] dArr = this.d[(this.f1488h * i4) + i7];
                    int i9 = (i6 - i5) * iP;
                    while (i8 < iQ2) {
                        tVar.c(i6, i8, dArr[i9]);
                        i9++;
                        i8++;
                    }
                }
            }
        }
        return tVar.a();
    }

    @Override // i.b.ha.a.e.c.c
    public double n(t tVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        g gVar = this;
        l.e(gVar, i2, i3, i4, i5);
        tVar.b(gVar.e, gVar.f, i2, i3, i4, i5);
        int i6 = i2 / 52;
        while (i6 < (i3 / 52) + 1) {
            int i7 = i6 * 52;
            int iO = i.b.ha.a.e.g.j.o(i2, i7);
            int i8 = i6 + 1;
            int iQ = i.b.ha.a.e.g.j.q(i8 * 52, i3 + 1);
            while (iO < iQ) {
                int i9 = i4 / 52;
                while (i9 < (i5 / 52) + 1) {
                    int iP = gVar.p(i9);
                    int i10 = i9 * 52;
                    int iO2 = i.b.ha.a.e.g.j.o(i4, i10);
                    int i11 = i9 + 1;
                    int i12 = i8;
                    int iQ2 = i.b.ha.a.e.g.j.q(i11 * 52, i5 + 1);
                    int i13 = iQ;
                    double[] dArr = gVar.d[(gVar.f1488h * i6) + i9];
                    int i14 = (((iO - i7) * iP) + iO2) - i10;
                    while (iO2 < iQ2) {
                        tVar.c(iO, iO2, dArr[i14]);
                        i14++;
                        iO2++;
                        i6 = i6;
                    }
                    gVar = this;
                    i9 = i11;
                    i8 = i12;
                    iQ = i13;
                }
                iO++;
                gVar = this;
            }
            gVar = this;
            i6 = i8;
        }
        return tVar.a();
    }

    @Override // i.b.ha.a.e.c.c
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public g h(int i2, int i3) throws i.b.ha.a.e.b.k {
        return new g(i2, i3);
    }

    @Override // i.b.ha.a.e.c.c, i.b.ha.a.e.c.r
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public g c() {
        g gVar = new g(a(), d());
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1488h; i3++) {
            for (int i4 = 0; i4 < this.g; i4++) {
                double[] dArr = gVar.d[i2];
                double[] dArr2 = this.d[(this.f1488h * i4) + i3];
                int i5 = i3 * 52;
                int iQ = i.b.ha.a.e.g.j.q(i5 + 52, this.f);
                int i6 = i4 * 52;
                int iQ2 = i.b.ha.a.e.g.j.q(i6 + 52, this.e);
                int i7 = 0;
                for (int i8 = i5; i8 < iQ; i8++) {
                    int i9 = iQ - i5;
                    int i10 = i8 - i5;
                    for (int i11 = i6; i11 < iQ2; i11++) {
                        dArr[i7] = dArr2[i10];
                        i7++;
                        i10 += i9;
                    }
                }
                i2++;
            }
        }
        return gVar;
    }

    public g(int i2, int i3, double[][] dArr, boolean z) throws i.b.ha.a.e.b.k, i.b.ha.a.e.b.b {
        super(i2, i3);
        this.e = i2;
        this.f = i3;
        int i4 = ((i2 + 52) - 1) / 52;
        this.g = i4;
        int i5 = ((i3 + 52) - 1) / 52;
        this.f1488h = i5;
        if (z) {
            this.d = new double[i4 * i5][];
        } else {
            this.d = dArr;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.g; i7++) {
            int iO = o(i7);
            int i8 = 0;
            while (i8 < this.f1488h) {
                if (dArr[i6].length != p(i8) * iO) {
                    throw new i.b.ha.a.e.b.b(dArr[i6].length, iO * p(i8));
                }
                if (z) {
                    this.d[i6] = (double[]) dArr[i6].clone();
                }
                i8++;
                i6++;
            }
        }
    }
}
