package i.b.ha.a.e.c;

import java.io.Serializable;

/* loaded from: classes.dex */
public class f extends u implements Serializable {
    private static final v d = v.c();
    private double[] c;

    public f(double[] dArr) {
        this.c = (double[]) dArr.clone();
    }

    @Override // i.b.ha.a.e.c.u
    public int a() {
        return this.c.length;
    }

    @Override // i.b.ha.a.e.c.u
    public double b(int i2) throws i.b.ha.a.e.b.o {
        try {
            return this.c[i2];
        } catch (IndexOutOfBoundsException unused) {
            throw new i.b.ha.a.e.b.o(i.b.ha.a.e.b.p.d.INDEX, Integer.valueOf(i2), 0, Integer.valueOf(a() - 1));
        }
    }

    @Override // i.b.ha.a.e.c.u
    public boolean c() {
        for (double d2 : this.c) {
            if (Double.isNaN(d2)) {
                return true;
            }
        }
        return false;
    }

    @Override // i.b.ha.a.e.c.u
    public double[] d() {
        return (double[]) this.c.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.c.length != uVar.a()) {
            return false;
        }
        if (uVar.c()) {
            return c();
        }
        int i2 = 0;
        while (true) {
            double[] dArr = this.c;
            if (i2 >= dArr.length) {
                return true;
            }
            if (dArr[i2] != uVar.b(i2)) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        if (c()) {
            return 9;
        }
        return i.b.ha.a.e.g.m.c(this.c);
    }

    public String toString() {
        return d.a(this);
    }

    public f(double[] dArr, boolean z) throws i.b.ha.a.e.b.l {
        if (dArr != null) {
            this.c = z ? (double[]) dArr.clone() : dArr;
            return;
        }
        throw new i.b.ha.a.e.b.l();
    }
}
