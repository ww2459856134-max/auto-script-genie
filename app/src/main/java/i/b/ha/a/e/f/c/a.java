package i.b.ha.a.e.f.c;

import i.b.ha.a.e.b.d;
import i.b.ha.a.e.b.i;
import i.b.ha.a.e.b.l;
import i.b.ha.a.e.c.e;
import i.b.ha.a.e.c.f;
import i.b.ha.a.e.c.r;
import i.b.ha.a.e.c.u;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class a {
    private r a;
    private u b;
    private boolean c = false;

    protected abstract u a();

    public double[] b() {
        return a().d();
    }

    protected r c() {
        return this.a;
    }

    protected u d() {
        return this.b;
    }

    protected void e(double[][] dArr) {
        if (dArr == null) {
            throw new l();
        }
        if (dArr.length == 0) {
            throw new i();
        }
        if (this.c) {
            this.a = new e(dArr, true);
            return;
        }
        int length = dArr[0].length;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, dArr.length, length + 1);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (dArr[i2].length != length) {
                throw new i.b.ha.a.e.b.b(dArr[i2].length, length);
            }
            dArr2[i2][0] = 1.0d;
            System.arraycopy(dArr[i2], 0, dArr2[i2], 1, length);
        }
        this.a = new e(dArr2, false);
    }

    protected void f(double[] dArr) {
        if (dArr == null) {
            throw new l();
        }
        if (dArr.length == 0) {
            throw new i();
        }
        this.b = new f(dArr);
    }

    public void g(boolean z) {
        this.c = z;
    }

    protected void h(double[][] dArr, double[] dArr2) throws d {
        if (dArr == null || dArr2 == null) {
            throw new l();
        }
        if (dArr.length != dArr2.length) {
            throw new i.b.ha.a.e.b.b(dArr2.length, dArr.length);
        }
        if (dArr.length == 0) {
            throw new i();
        }
        if (dArr[0].length + 1 > dArr.length) {
            throw new d(i.b.ha.a.e.b.p.d.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, Integer.valueOf(dArr.length), Integer.valueOf(dArr[0].length));
        }
    }
}
