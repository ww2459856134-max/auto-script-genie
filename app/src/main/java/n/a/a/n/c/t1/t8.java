package n.a.a.n.c.t1;

/* loaded from: classes.dex */
final class t8 extends x8 {
    private final v8 a = new v8(false, false);

    t8() {
    }

    @Override // n.a.a.n.c.t1.x8
    protected double[] l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        double[] dArrP = this.a.p(w0Var);
        if ((w0Var instanceof n.a.a.n.c.r1.j) && dArrP.length == 1) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
        return dArrP;
    }

    @Override // n.a.a.n.c.t1.x8
    protected double[][] m(double[][] dArr, double[][] dArr2) throws n.a.a.n.c.r1.p {
        i.b.ha.a.e.c.e eVar = new i.b.ha.a.e.c.e(dArr);
        i.b.ha.a.e.c.e eVar2 = new i.b.ha.a.e.c.e(dArr2);
        try {
            i.b.ha.a.e.c.l.c(eVar, eVar2);
            return eVar.q(eVar2).getData();
        } catch (i.b.ha.a.e.b.b unused) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.e);
        }
    }
}
