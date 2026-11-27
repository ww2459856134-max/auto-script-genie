package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class x3 implements p6 {
    private static final z3 b = new z3() { // from class: n.a.a.n.c.t1.j
        @Override // n.a.a.n.c.t1.z3
        public final boolean a(n.a.a.n.c.r1.w0 w0Var) {
            return x3.b(w0Var);
        }
    };
    private static final z3 c = new v3();
    private static final z3 d = new w3();
    private final z3 a;

    public x3() {
        this.a = b;
    }

    static /* synthetic */ boolean b(n.a.a.n.c.r1.w0 w0Var) {
        return (w0Var instanceof n.a.a.n.c.r1.x) || w0Var == n.a.a.n.c.r1.u.a;
    }

    public static x3 c(boolean z) {
        return new x3(z ? c : d);
    }

    @Override // n.a.a.n.c.t1.p6
    public n.a.a.n.c.r1.w0 k(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        int length = w0VarArr.length;
        if (length < 1) {
            return n.a.a.n.c.r1.o.e;
        }
        if (length > 30) {
            return n.a.a.n.c.r1.o.e;
        }
        int iA = 0;
        for (n.a.a.n.c.r1.w0 w0Var : w0VarArr) {
            iA += a4.a(w0Var, this.a);
        }
        return new n.a.a.n.c.r1.x(iA);
    }

    private x3(z3 z3Var) {
        this.a = z3Var;
    }
}
