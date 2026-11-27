package i.b.ha.a.e.f.b;

import i.b.ha.a.e.b.l;
import i.b.ha.a.e.g.m;
import i.b.ha.a.e.g.n;

/* loaded from: classes.dex */
public abstract class a extends b implements c {
    @Override // i.b.ha.a.e.f.b.c
    public abstract double a();

    @Override // i.b.ha.a.e.f.b.d
    public double b(double[] dArr, int i2, int i3) throws i.b.ha.a.e.b.d {
        if (d(dArr, i2, i3)) {
            clear();
            g(dArr, i2, i3);
        }
        return a();
    }

    @Override // i.b.ha.a.e.f.b.c
    public abstract void c(double d);

    @Override // i.b.ha.a.e.f.b.c
    public abstract void clear();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return n.d(aVar.a(), a()) && n.e((float) aVar.getN(), (float) getN());
    }

    public double f(double[] dArr) throws i.b.ha.a.e.b.d {
        if (dArr != null) {
            return b(dArr, 0, dArr.length);
        }
        throw new l(i.b.ha.a.e.b.p.d.INPUT_ARRAY, new Object[0]);
    }

    public void g(double[] dArr, int i2, int i3) throws i.b.ha.a.e.b.d {
        if (d(dArr, i2, i3)) {
            int i4 = i3 + i2;
            while (i2 < i4) {
                c(dArr[i2]);
                i2++;
            }
        }
    }

    public int hashCode() {
        return ((m.b(a()) + 31) * 31) + m.b(getN());
    }
}
