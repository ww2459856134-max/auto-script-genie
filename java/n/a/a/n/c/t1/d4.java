package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class d4 implements p6 {
    private static final z3 b = new z3() { // from class: n.a.a.n.c.t1.k
        @Override // n.a.a.n.c.t1.z3
        public final boolean a(n.a.a.n.c.r1.w0 w0Var) {
            return d4.b(w0Var);
        }
    };
    private static final z3 c = new b4();
    private static final z3 d = new c4();
    private final z3 a;

    public d4() {
        this.a = b;
    }

    static /* synthetic */ boolean b(n.a.a.n.c.r1.w0 w0Var) {
        return w0Var != n.a.a.n.c.r1.l.a;
    }

    public static d4 c(boolean z) {
        return new d4(z ? c : d);
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

    private d4(z3 z3Var) {
        this.a = z3Var;
    }
}
