package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class z5 implements n6, o6 {
    private static final n.a.a.n.c.r1.w0 a = n.a.a.n.c.r1.x.c;
    private static final n.a.a.n.c.r1.w0 b = n.a.a.n.c.r1.m.b;
    public static final p6 c = new v5();
    public static final p6 d = new w5();
    public static final p6 e = new x5();
    public static final p6 f = new y5();

    protected z5() {
    }

    protected abstract double a(double d2, double d3, double d4, double d5, boolean z) throws n.a.a.n.c.r1.p;

    public n.a.a.n.c.r1.w0 b(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4, n.a.a.n.c.r1.w0 w0Var5) {
        try {
            double dA = a(y9.D(w0Var, i2, i3), y9.D(w0Var2, i2, i3), y9.D(w0Var3, i2, i3), y9.D(w0Var4, i2, i3), y9.D(w0Var5, i2, i3) != 0.0d);
            y9.a(dA);
            return new n.a.a.n.c.r1.x(dA);
        } catch (n.a.a.n.c.r1.p e2) {
            return e2.a();
        }
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int length = w0VarArr.length;
        if (length == 3) {
            return b(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2], a, b);
        }
        if (length == 4) {
            n.a.a.n.c.r1.w0 w0Var = w0VarArr[3];
            if (w0Var == n.a.a.n.c.r1.u.a) {
                w0Var = a;
            }
            return b(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2], w0Var, b);
        }
        if (length != 5) {
            return n.a.a.n.c.r1.o.e;
        }
        n.a.a.n.c.r1.w0 w0Var2 = w0VarArr[3];
        n.a.a.n.c.r1.u uVar = n.a.a.n.c.r1.u.a;
        if (w0Var2 == uVar) {
            w0Var2 = a;
        }
        n.a.a.n.c.r1.w0 w0Var3 = w0Var2;
        n.a.a.n.c.r1.w0 w0Var4 = w0VarArr[4];
        if (w0Var4 == uVar) {
            w0Var4 = b;
        }
        return b(i2, i3, w0VarArr[0], w0VarArr[1], w0VarArr[2], w0Var3, w0Var4);
    }
}
