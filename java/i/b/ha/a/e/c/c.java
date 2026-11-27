package i.b.ha.a.e.c;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class c extends q implements r {
    private static final s c;

    static {
        s sVarE = s.e(Locale.US);
        c = sVarE;
        sVarE.c().setMinimumFractionDigits(1);
    }

    protected c() {
    }

    @Override // i.b.ha.a.e.c.d
    public abstract int a();

    @Override // i.b.ha.a.e.c.r
    public void b(int i2, int i3, int i4, int i5, double[][] dArr) throws k, i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        l.e(this, i2, i3, i4, i5);
        int i6 = (i3 + 1) - i2;
        int i7 = (i5 + 1) - i4;
        if (dArr.length < i6 || dArr[0].length < i7) {
            throw new k(dArr.length, dArr[0].length, i6, i7);
        }
        for (int i8 = 1; i8 < i6; i8++) {
            if (dArr[i8].length < i7) {
                throw new k(dArr.length, dArr[i8].length, i6, i7);
            }
        }
        l(new a(this, dArr), i2, i3, i4, i5);
    }

    @Override // i.b.ha.a.e.c.r
    public r c() throws i.b.ha.a.e.b.k {
        r rVarH = h(a(), d());
        k(new b(this, rVarH));
        return rVarH;
    }

    @Override // i.b.ha.a.e.c.d
    public abstract int d();

    @Override // i.b.ha.a.e.c.r
    public abstract double e(int i2, int i3) throws i.b.ha.a.e.b.o;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        int iD = d();
        int iA = a();
        if (rVar.a() != iA || rVar.d() != iD) {
            return false;
        }
        for (int i2 = 0; i2 < iD; i2++) {
            for (int i3 = 0; i3 < iA; i3++) {
                if (e(i2, i3) != rVar.e(i2, i3)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // i.b.ha.a.e.c.r
    public abstract void f(int i2, int i3, double d) throws i.b.ha.a.e.b.o;

    @Override // i.b.ha.a.e.c.d
    public boolean g() {
        return a() == d();
    }

    public abstract r h(int i2, int i3) throws i.b.ha.a.e.b.k;

    public int hashCode() {
        int iD = d();
        int iA = a();
        int iB = ((217 + iD) * 31) + iA;
        for (int i2 = 0; i2 < iD; i2++) {
            int i3 = 0;
            while (i3 < iA) {
                int i4 = i3 + 1;
                iB = (iB * 31) + ((((i2 + 1) * 11) + (i4 * 17)) * i.b.ha.a.e.g.m.b(e(i2, i3)));
                i3 = i4;
            }
        }
        return iB;
    }

    public void i(double[][] dArr, int i2, int i3) throws i.b.ha.a.e.b.l, i.b.ha.a.e.b.i, i.b.ha.a.e.b.b, i.b.ha.a.e.b.o {
        i.b.ha.a.e.g.m.a(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_ROW);
        }
        int length2 = dArr[0].length;
        if (length2 == 0) {
            throw new i.b.ha.a.e.b.i(i.b.ha.a.e.b.p.d.AT_LEAST_ONE_COLUMN);
        }
        for (int i4 = 1; i4 < length; i4++) {
            if (dArr[i4].length != length2) {
                throw new i.b.ha.a.e.b.b(length2, dArr[i4].length);
            }
        }
        l.d(this, i2);
        l.a(this, i3);
        l.d(this, (length + i2) - 1);
        l.a(this, (length2 + i3) - 1);
        for (int i5 = 0; i5 < length; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                f(i2 + i5, i3 + i6, dArr[i5][i6]);
            }
        }
    }

    public double k(t tVar) {
        return m(tVar);
    }

    public double l(t tVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n {
        return n(tVar, i2, i3, i4, i5);
    }

    public abstract double m(t tVar);

    public abstract double n(t tVar, int i2, int i3, int i4, int i5) throws i.b.ha.a.e.b.o, i.b.ha.a.e.b.n;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String name = getClass().getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(c.a(this));
        return sb.toString();
    }

    protected c(int i2, int i3) throws i.b.ha.a.e.b.k {
        if (i2 < 1) {
            throw new i.b.ha.a.e.b.k(Integer.valueOf(i2));
        }
        if (i3 < 1) {
            throw new i.b.ha.a.e.b.k(Integer.valueOf(i3));
        }
    }
}
