package n.a.a.n.c;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class d implements n.a.a.n.d.j0, o1 {
    protected final n1 a;

    protected d(n1 n1Var) {
        this.a = n1Var;
    }

    @Override // n.a.a.n.d.j0
    public n.a.a.n.d.j a(n.a.a.n.d.e eVar) {
        if (eVar == null || eVar.b() != n.a.a.n.d.j.FORMULA) {
            return n.a.a.n.d.j._NONE;
        }
        n.a.a.n.d.l lVarE = e(eVar);
        g(eVar, lVarE);
        return lVarE.c();
    }

    @Override // n.a.a.n.c.o1
    public n1 b() {
        return this.a;
    }

    protected abstract n.a.a.n.d.n0 c(String str);

    public n.a.a.n.d.l d(n.a.a.n.d.e eVar) {
        if (eVar == null) {
            return null;
        }
        switch (c.a[eVar.b().ordinal()]) {
            case 1:
                return n.a.a.n.d.l.h(eVar.c());
            case 2:
                return n.a.a.n.d.l.d(eVar.a());
            case 3:
                return e(eVar);
            case 4:
                return new n.a.a.n.d.l(eVar.d());
            case 5:
                return new n.a.a.n.d.l(eVar.q().getString());
            case 6:
                return null;
            default:
                throw new IllegalStateException("Bad cell type (" + eVar.b() + ")");
        }
    }

    protected abstract n.a.a.n.d.l e(n.a.a.n.d.e eVar);

    protected t f() {
        return this.a.x();
    }

    protected void g(n.a.a.n.d.e eVar, n.a.a.n.d.l lVar) {
        n.a.a.n.d.j jVarC = lVar.c();
        int i2 = c.a[jVarC.ordinal()];
        if (i2 == 1) {
            eVar.o(lVar.b());
            return;
        }
        if (i2 == 2) {
            eVar.p(lVar.e());
            return;
        }
        if (i2 == 4) {
            eVar.n(lVar.f());
            return;
        }
        if (i2 == 5) {
            eVar.l(c(lVar.g()));
            return;
        }
        throw new IllegalStateException("Unexpected cell value type (" + jVarC + ")");
    }

    public void h(Map<String, n.a.a.n.d.j0> map) {
        i.d(map);
    }
}
