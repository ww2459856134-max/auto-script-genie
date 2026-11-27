package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class x8 extends c6 {
    protected x8() {
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        double[][] dArrF;
        double[][] dArrF2;
        try {
            try {
                if (w0Var instanceof n.a.a.n.c.r1.j) {
                    try {
                        dArrF = y8.f(l(w0Var), ((n.a.a.n.c.r1.j) w0Var).a(), ((n.a.a.n.c.r1.j) w0Var).getWidth());
                    } catch (n.a.a.n.c.r1.p e) {
                        return e.a();
                    }
                } else {
                    try {
                        dArrF = new double[][]{new double[]{y9.D(w0Var, i2, i3)}};
                    } catch (n.a.a.n.c.r1.p e2) {
                        return e2.a();
                    }
                }
                if (w0Var2 instanceof n.a.a.n.c.r1.j) {
                    try {
                        dArrF2 = y8.f(l(w0Var2), ((n.a.a.n.c.r1.j) w0Var2).a(), ((n.a.a.n.c.r1.j) w0Var2).getWidth());
                    } catch (n.a.a.n.c.r1.p e3) {
                        return e3.a();
                    }
                } else {
                    try {
                        dArrF2 = new double[][]{new double[]{y9.D(w0Var2, i2, i3)}};
                    } catch (n.a.a.n.c.r1.p e4) {
                        return e4.a();
                    }
                }
                double[][] dArrM = m(dArrF, dArrF2);
                int length = dArrM[0].length;
                int length2 = dArrM.length;
                double[] dArrD = y8.d(dArrM);
                y8.c(dArrD);
                n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[dArrD.length];
                for (int i4 = 0; i4 < dArrD.length; i4++) {
                    w0VarArr[i4] = new n.a.a.n.c.r1.x(dArrD[i4]);
                }
                if (dArrD.length == 1) {
                    return w0VarArr[0];
                }
                n.a.a.n.c.r1.j jVar = (n.a.a.n.c.r1.j) w0Var;
                return new n.a.a.n.c.e(jVar.getFirstRow(), jVar.getFirstColumn(), (jVar.getFirstRow() + length2) - 1, (jVar.getFirstColumn() + length) - 1, w0VarArr);
            } catch (IllegalArgumentException unused) {
                return n.a.a.n.c.r1.o.e;
            }
        } catch (n.a.a.n.c.r1.p e5) {
            return e5.a();
        }
    }

    protected abstract double[] l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p;

    protected abstract double[][] m(double[][] dArr, double[][] dArr2) throws n.a.a.n.c.r1.p;
}
