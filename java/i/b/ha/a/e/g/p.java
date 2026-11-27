package i.b.ha.a.e.g;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class p implements Serializable {
    private double c;
    private double d;
    private o e;
    private double[] f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1496h;

    public p(int i2) throws i.b.ha.a.e.b.d {
        this(i2, 2.0d);
    }

    public synchronized void a(double d) {
        if (this.f.length <= this.f1496h + this.g) {
            d();
        }
        double[] dArr = this.f;
        int i2 = this.f1496h;
        int i3 = this.g;
        this.g = i3 + 1;
        dArr[i2 + i3] = d;
    }

    public synchronized void b(double[] dArr) {
        int i2 = this.g;
        double[] dArr2 = new double[dArr.length + i2 + 1];
        System.arraycopy(this.f, this.f1496h, dArr2, 0, i2);
        System.arraycopy(dArr, 0, dArr2, this.g, dArr.length);
        this.f = dArr2;
        this.f1496h = 0;
        this.g += dArr.length;
    }

    protected void c(double d, double d2) throws i.b.ha.a.e.b.n {
        if (d < d2) {
            i.b.ha.a.e.b.n nVar = new i.b.ha.a.e.b.n(Double.valueOf(d), 1, true);
            nVar.a().a(i.b.ha.a.e.b.p.d.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, Double.valueOf(d), Double.valueOf(d2));
            throw nVar;
        }
        if (d <= 1.0d) {
            i.b.ha.a.e.b.n nVar2 = new i.b.ha.a.e.b.n(Double.valueOf(d), 1, false);
            nVar2.a().a(i.b.ha.a.e.b.p.d.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, Double.valueOf(d));
            throw nVar2;
        }
        if (d2 > 1.0d) {
            return;
        }
        i.b.ha.a.e.b.n nVar3 = new i.b.ha.a.e.b.n(Double.valueOf(d), 1, false);
        nVar3.a().a(i.b.ha.a.e.b.p.d.EXPANSION_FACTOR_SMALLER_THAN_ONE, Double.valueOf(d2));
        throw nVar3;
    }

    protected synchronized void d() {
        double[] dArr = new double[this.e == o.MULTIPLICATIVE ? (int) j.d(this.f.length * this.d) : (int) (this.f.length + j.y(this.d))];
        double[] dArr2 = this.f;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        this.f = dArr;
    }

    public synchronized double[] e() {
        double[] dArr;
        int i2 = this.g;
        dArr = new double[i2];
        System.arraycopy(this.f, this.f1496h, dArr, 0, i2);
        return dArr;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        synchronized (this) {
            synchronized (obj) {
                p pVar = (p) obj;
                if (!(((((pVar.c > this.c ? 1 : (pVar.c == this.c ? 0 : -1)) == 0) && (pVar.d > this.d ? 1 : (pVar.d == this.d ? 0 : -1)) == 0) && pVar.e == this.e) && pVar.g == this.g) || pVar.f1496h != this.f1496h) {
                    z = false;
                }
                if (z) {
                    return Arrays.equals(this.f, pVar.f);
                }
                return false;
            }
        }
    }

    public synchronized int hashCode() {
        return Arrays.hashCode(new int[]{Double.valueOf(this.d).hashCode(), Double.valueOf(this.c).hashCode(), this.e.hashCode(), Arrays.hashCode(this.f), this.g, this.f1496h});
    }

    public p(int i2, double d) throws i.b.ha.a.e.b.d {
        this(i2, d, d + 0.5d);
    }

    public p(int i2, double d, double d2) throws i.b.ha.a.e.b.d {
        this(i2, d, d2, o.MULTIPLICATIVE, null);
    }

    public p(int i2, double d, double d2, o oVar, double... dArr) throws i.b.ha.a.e.b.d {
        this.c = 2.5d;
        this.d = 2.0d;
        this.e = o.MULTIPLICATIVE;
        this.g = 0;
        this.f1496h = 0;
        if (i2 > 0) {
            c(d2, d);
            this.d = d;
            this.c = d2;
            this.e = oVar;
            this.f = new double[i2];
            this.g = 0;
            this.f1496h = 0;
            if (dArr == null || dArr.length <= 0) {
                return;
            }
            b(dArr);
            return;
        }
        throw new i.b.ha.a.e.b.k(i.b.ha.a.e.b.p.d.INITIAL_CAPACITY_NOT_POSITIVE, Integer.valueOf(i2));
    }
}
