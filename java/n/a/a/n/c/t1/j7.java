package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public final class j7 extends c6 {
    private final f7 a;

    public j7(f7 f7Var) {
        this.a = f7Var;
    }

    private static m8 l(n.a.a.n.c.r1.w0 w0Var) throws n.a.a.n.c.r1.p {
        if (w0Var instanceof n.a.a.n.c.r1.o) {
            throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) w0Var);
        }
        return w0Var instanceof n.a.a.n.c.j1 ? new e7((n.a.a.n.c.j1) w0Var) : w0Var instanceof n.a.a.n.c.r1.c0 ? new g7((n.a.a.n.c.r1.c0) w0Var) : new h7(w0Var);
    }

    private double m(m8 m8Var, m8 m8Var2, int i2) throws n.a.a.n.c.r1.p {
        n.a.a.n.c.r1.o oVar = null;
        boolean z = false;
        double dR = 0.0d;
        double dR2 = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            n.a.a.n.c.r1.w0 item = m8Var.getItem(i3);
            n.a.a.n.c.r1.w0 item2 = m8Var2.getItem(i3);
            if (item instanceof n.a.a.n.c.r1.o) {
                throw new n.a.a.n.c.r1.p((n.a.a.n.c.r1.o) item);
            }
            if ((item2 instanceof n.a.a.n.c.r1.o) && oVar == null) {
                oVar = (n.a.a.n.c.r1.o) item2;
            } else if ((item instanceof n.a.a.n.c.r1.x) && (item2 instanceof n.a.a.n.c.r1.x)) {
                dR += ((n.a.a.n.c.r1.x) item).r();
                dR2 += ((n.a.a.n.c.r1.x) item2).r();
                z = true;
            }
        }
        if (oVar != null) {
            throw new n.a.a.n.c.r1.p(oVar);
        }
        if (!z) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.d);
        }
        double d = i2;
        double d2 = dR / d;
        double d3 = dR2 / d;
        double dR3 = 0.0d;
        double dR4 = 0.0d;
        for (int i4 = 0; i4 < i2; i4++) {
            n.a.a.n.c.r1.w0 item3 = m8Var.getItem(i4);
            n.a.a.n.c.r1.w0 item4 = m8Var2.getItem(i4);
            if ((item3 instanceof n.a.a.n.c.r1.x) && (item4 instanceof n.a.a.n.c.r1.x)) {
                n.a.a.n.c.r1.x xVar = (n.a.a.n.c.r1.x) item3;
                dR3 += (xVar.r() - d2) * (xVar.r() - d2);
                dR4 += (xVar.r() - d2) * (((n.a.a.n.c.r1.x) item4).r() - d3);
            }
        }
        if (dR3 == 0.0d) {
            throw new n.a.a.n.c.r1.p(n.a.a.n.c.r1.o.d);
        }
        double d4 = dR4 / dR3;
        return this.a == f7.INTERCEPT ? d3 - (d2 * d4) : d4;
    }

    @Override // n.a.a.n.c.t1.m6
    public n.a.a.n.c.r1.w0 i(int i2, int i3, n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        try {
            m8 m8VarL = l(w0Var);
            m8 m8VarL2 = l(w0Var2);
            int size = m8VarL2.getSize();
            if (size != 0 && m8VarL.getSize() == size) {
                double dM = m(m8VarL2, m8VarL, size);
                return (Double.isNaN(dM) || Double.isInfinite(dM)) ? n.a.a.n.c.r1.o.f2385h : new n.a.a.n.c.r1.x(dM);
            }
            return n.a.a.n.c.r1.o.f2386i;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }
}
