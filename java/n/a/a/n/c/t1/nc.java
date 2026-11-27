package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class nc extends c6 {
    private static m8 m(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        return w0Var instanceof n.a.a.n.c.j1 ? new jc((n.a.a.n.c.j1) w0Var) : w0Var instanceof n.a.a.n.c.r1.c0 ? new kc((n.a.a.n.c.r1.c0) w0Var) : new lc(w0Var);
    }

    private double n(m8 m8Var, m8 m8Var2, int i2) throws n.a.a.n.c.r1.p {
        ic icVarL = l();
        double dA = 0.0d;
        n.a.a.n.c.r1.o oVar = null;
        n.a.a.n.c.r1.o oVar2 = null;
        boolean z = false;
        for (int i3 = 0; i3 < i2; i3++) {
            n.a.a.n.c.r1.w0 item = m8Var.getItem(i3);
            n.a.a.n.c.r1.w0 item2 = m8Var2.getItem(i3);
            if ((item instanceof n.a.a.n.c.r1.o) && oVar == null) {
                oVar = (n.a.a.n.c.r1.o) item;
            } else if ((item2 instanceof n.a.a.n.c.r1.o) && oVar2 == null) {
                oVar2 = (n.a.a.n.c.r1.o) item2;
            } else if ((item instanceof n.a.a.n.c.r1.x) && (item2 instanceof n.a.a.n.c.r1.x)) {
                dA += icVarL.a(((n.a.a.n.c.r1.x) item).r(), ((n.a.a.n.c.r1.x) item2).r());
                z = true;
            }
        }
        if (oVar != null) {
            throw new n.a.a.n.c.r1.p(oVar);
        }
        if (oVar2 != null) {
            throw new n.a.a.n.c.r1.p(oVar2);
        }
        if (z) {
            return dA;
        }
        throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.d);
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            m8 m8VarM = m(w0Var);
            m8 m8VarM2 = m(w0Var2);
            int size = m8VarM.getSize();
            if (size != 0 && m8VarM2.getSize() == size) {
                double dN = n(m8VarM, m8VarM2, size);
                return (Double.isNaN(dN) || Double.isInfinite(dN)) ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(dN);
            }
            return n.a.a.n.c.r1.o.f2386i;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    protected abstract ic l();
}
