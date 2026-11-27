package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class p3 implements p6 {
    public static int a(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) throws n.a.a.n.c.r1.p {
        return n.a.a.n.c.r1.z.f(n.a.a.n.c.r1.z.i(w0Var, i2, i3));
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        if (w0VarArr.length < 2) {
            return n.a.a.n.c.r1.o.e;
        }
        try {
            int iA = a(w0VarArr[0], i2, i3);
            if (iA >= 1 && iA < w0VarArr.length) {
                n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0VarArr[iA], i2, i3);
                return w0VarI == n.a.a.n.c.r1.u.a ? n.a.a.n.c.r1.l.a : w0VarI;
            }
            return n.a.a.n.c.r1.o.e;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
