package n.a.a.n.c;

import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.x2;

/* loaded from: classes.dex */
final class k1 implements j6 {
    public static final j6 a = new k1();

    private k1() {
    }

    @Override // n.a.a.n.c.t1.j6
    public n.a.a.n.c.r1.w0 c(n.a.a.n.c.r1.w0[] w0VarArr, t0 t0Var) {
        n.a.a.n.c.r1.w0 w0VarB;
        int length = w0VarArr.length;
        if (length < 1) {
            throw new IllegalStateException("function name argument missing");
        }
        n.a.a.n.c.r1.w0 w0Var = w0VarArr[0];
        if (!(w0Var instanceof n.a.a.n.c.r1.s)) {
            throw new IllegalStateException("First argument should be a NameEval, but got (" + w0Var.getClass().getName() + ")");
        }
        String strU = ((n.a.a.n.c.r1.s) w0Var).u();
        j6 j6VarG = t0Var.g(strU);
        if (j6VarG == null) {
            throw new n.a.a.n.c.r1.w(strU);
        }
        int i2 = length - 1;
        n.a.a.n.c.r1.w0[] w0VarArr2 = new n.a.a.n.c.r1.w0[i2];
        System.arraycopy(w0VarArr, 1, w0VarArr2, 0, i2);
        return (!(j6VarG instanceof x2) || (w0VarB = u0.b((x2) j6VarG, w0VarArr2, t0Var)) == null) ? j6VarG.c(w0VarArr2, t0Var) : w0VarB;
    }
}
