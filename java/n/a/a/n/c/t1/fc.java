package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class fc extends ec {
    private static final n.a.a.n.c.r1.w0 a = n.a.a.n.c.r1.m.c;

    private m8 a(n.a.a.n.c.j1 j1Var, int i2) throws n.a.a.n.c.r1.p {
        if (i2 < j1Var.getWidth()) {
            return n8.b(j1Var, i2);
        }
        throw n.a.a.n.c.r1.p.b();
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        return j(i2, i3, w0Var, w0Var2, w0Var3, a);
    }

    @Override // n.a.a.n.c.t1.o6
    public n.a.a.n.c.r1.w0 j(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3, n.a.a.n.c.r1.w0 w0Var4) {
        boolean zP;
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            n.a.a.n.c.j1 j1VarR = n8.r(w0Var2);
            try {
                zP = n8.p(w0Var4, i2, i3);
            } catch (RuntimeException unused) {
                zP = true;
            }
            return a(j1VarR, n8.q(w0Var3, i2, i3)).getItem(n8.j(w0VarI, n8.b(j1VarR, 0), zP));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
