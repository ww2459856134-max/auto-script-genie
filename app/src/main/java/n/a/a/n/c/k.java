package n.a.a.n.c;

/* loaded from: classes.dex */
final class k {
    private final y0 a = new y0();
    private final u b = new u();
    final l0 c;

    k(l0 l0Var) {
        this.c = l0Var;
    }

    private boolean a(n.a.a.n.c.r1.w0 w0Var, n.a.a.n.c.r1.w0 w0Var2) {
        Class<?> cls;
        if (w0Var == null || (cls = w0Var.getClass()) != w0Var2.getClass()) {
            return false;
        }
        if (w0Var == n.a.a.n.c.r1.l.a) {
            return w0Var2 == w0Var;
        }
        if (cls == n.a.a.n.c.r1.x.class) {
            return ((n.a.a.n.c.r1.x) w0Var).r() == ((n.a.a.n.c.r1.x) w0Var2).r();
        }
        if (cls == n.a.a.n.c.r1.m0.class) {
            return ((n.a.a.n.c.r1.m0) w0Var).getStringValue().equals(((n.a.a.n.c.r1.m0) w0Var2).getStringValue());
        }
        if (cls == n.a.a.n.c.r1.m.class) {
            return ((n.a.a.n.c.r1.m) w0Var).u() == ((n.a.a.n.c.r1.m) w0Var2).u();
        }
        if (cls == n.a.a.n.c.r1.o.class) {
            return ((n.a.a.n.c.r1.o) w0Var).u() == ((n.a.a.n.c.r1.o) w0Var2).u();
        }
        throw new IllegalStateException("Unexpected value class (" + cls.getName() + ")");
    }

    public v b(l lVar) {
        v vVarA = this.b.a(lVar);
        if (vVarA != null) {
            return vVarA;
        }
        v vVar = new v();
        this.b.b(lVar, vVar);
        return vVar;
    }

    public z0 c(int i2, int i3, int i4, int i5, n.a.a.n.c.r1.w0 w0Var) {
        x0 x0Var = new x0(i2, i3, i4, i5);
        z0 z0VarA = this.a.a(x0Var);
        if (z0VarA == null) {
            z0VarA = new z0(w0Var);
            this.a.b(x0Var, z0VarA);
            l0 l0Var = this.c;
            if (l0Var != null) {
                l0Var.b(i3, i4, i5, z0VarA);
            }
        } else {
            if (!a(z0VarA.d(), w0Var)) {
                throw new IllegalStateException("value changed");
            }
            l0 l0Var2 = this.c;
            if (l0Var2 != null) {
                l0Var2.a(i3, i4, i5, w0Var);
            }
        }
        return z0VarA;
    }
}
