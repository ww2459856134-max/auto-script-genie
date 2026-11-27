package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class v7 extends dc {
    private static m8 l(n.a.a.n.c.j1 j1Var) {
        m8 m8VarF = n8.f(j1Var);
        if (m8VarF != null) {
            return m8VarF;
        }
        throw new IllegalStateException("non-vector lookup or result areas not supported yet");
    }

    @Override // n.a.a.n.c.t1.n6
    public n.a.a.n.c.r1.w0 e(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2, n.a.a.n.c.r1.w0 w0Var3) {
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            n.a.a.n.c.j1 j1VarR = n8.r(w0Var2);
            n.a.a.n.c.j1 j1VarR2 = n8.r(w0Var3);
            m8 m8VarL = l(j1VarR);
            m8 m8VarL2 = l(j1VarR2);
            if (m8VarL.getSize() <= m8VarL2.getSize()) {
                return m8VarL2.getItem(n8.j(w0VarI, m8VarL, true));
            }
            throw new IllegalStateException("Lookup vector and result vector of differing sizes not supported yet");
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        m8 m8VarL;
        m8 m8VarL2;
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            n.a.a.n.c.j1 j1VarR = n8.r(w0Var2);
            if (j1VarR.getWidth() > j1VarR.a()) {
                m8VarL = l(j1VarR.f(0));
                m8VarL2 = l(j1VarR.f(j1VarR.a() - 1));
            } else {
                m8VarL = l(j1VarR.h(0));
                m8VarL2 = l(j1VarR.h(j1VarR.getWidth() - 1));
            }
            return m8VarL2.getItem(n8.j(w0VarI, m8VarL, true));
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
