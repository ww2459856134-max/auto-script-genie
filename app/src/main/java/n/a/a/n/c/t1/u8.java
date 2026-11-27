package n.a.a.n.c.t1;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
class u8 extends w8 {
    private final v8 a;

    public u8() {
        v8 v8Var = new v8(false, false);
        this.a = v8Var;
        v8Var.m(l9.ERROR);
    }

    @Override // n.a.a.n.c.t1.w8
    protected double[] l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        double[] dArrP = this.a.p(w0Var);
        if ((w0Var instanceof n.a.a.n.c.r1.j) && dArrP.length == 1) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        return this.a.p(w0Var);
    }

    @Override // n.a.a.n.c.t1.w8
    protected double[][] m(double[][] dArr) throws n.a.a.n.c.r1.p {
        if (dArr.length != dArr[0].length) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, 1, 1);
        dArr2[0][0] = new i.b.ha.a.e.c.j(new i.b.ha.a.e.c.e(dArr)).a();
        return dArr2;
    }
}
