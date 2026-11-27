package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class r8 extends w8 {
    private final v8 a = new v8(false, false);

    r8() {
    }

    @Override // n.a.a.n.c.t1.w8
    protected double[] l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        double[] dArrP = this.a.p(w0Var);
        if ((w0Var instanceof n.a.a.n.c.r1.j) && dArrP.length == 1) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        return dArrP;
    }

    @Override // n.a.a.n.c.t1.w8
    protected double[][] m(double[][] dArr) throws n.a.a.n.c.r1.p {
        if (dArr.length == dArr[0].length) {
            return i.b.ha.a.e.c.l.h(new i.b.ha.a.e.c.e(dArr)).getData();
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
    }
}
