package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class w8 extends b6 {
    protected w8() {
    }

    @Override // n.a.a.n.c.t1.l6
    /* renamed from: g */
    public n.a.a.n.c.r1.w0 l(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        if (!(w0Var instanceof n.a.a.n.c.r1.j)) {
            try {
                double[][] dArrM = m(new double[][]{new double[]{y9.D(w0Var, i2, i3)}});
                y9.a(dArrM[0][0]);
                return new n.a.a.n.c.r1.x(dArrM[0][0]);
            } catch (n.a.a.n.c.r1.p e) {
                return e.a();
            }
        }
        try {
            double[][] dArrM2 = m(y8.f(l(w0Var), ((n.a.a.n.c.r1.j) w0Var).a(), ((n.a.a.n.c.r1.j) w0Var).getWidth()));
            int length = dArrM2[0].length;
            int length2 = dArrM2.length;
            double[] dArrD = y8.d(dArrM2);
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
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    protected abstract double[] l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p;

    protected abstract double[][] m(double[][] dArr) throws n.a.a.n.c.r1.p;
}
