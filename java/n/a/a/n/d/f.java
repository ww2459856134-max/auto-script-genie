package n.a.a.n.d;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class f implements e {
    private void G() {
        if (e()) {
            F(null);
        }
    }

    private void t(String str) {
        if (str.length() > v().g()) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "The maximum length of cell contents (text) is %d characters", Integer.valueOf(v().g())));
        }
    }

    public final void A(j jVar) {
        if (jVar == null || jVar == j._NONE) {
            throw new IllegalArgumentException("cellType shall not be null nor _NONE");
        }
        j jVar2 = j.FORMULA;
        if (jVar == jVar2) {
            if (b() != jVar2) {
                throw new IllegalArgumentException("Calling Cell.setCellType(CellType.FORMULA) is illegal. Use setCellFormula(String) directly.");
            }
        } else {
            G();
            B(jVar);
        }
    }

    protected abstract void B(j jVar);

    protected abstract void C(double d);

    protected abstract void D(String str);

    protected abstract void E(n0 n0Var);

    public final void F(String str) {
        if (f().u() <= 1) {
            getRow().getSheet().y(this);
            return;
        }
        if (str == null) {
            str = "Cell " + new n.a.a.n.e.s(this).g() + " is part of a multi-cell array formula. You cannot change part of an array.";
        }
        throw new IllegalStateException(str);
    }

    @Override // n.a.a.n.d.e
    public void l(n0 n0Var) {
        if (n0Var == null || n0Var.getString() == null) {
            y();
        } else {
            t(n0Var.getString());
            E(n0Var);
        }
    }

    @Override // n.a.a.n.d.e
    public void n(double d) {
        if (Double.isInfinite(d)) {
            p(i0.DIV0.d());
        } else if (Double.isNaN(d)) {
            p(i0.NUM.d());
        } else {
            C(d);
        }
    }

    @Override // n.a.a.n.d.e
    public final void r(String str) throws IllegalStateException, n.a.a.n.c.x {
        G();
        if (str == null) {
            w();
        } else {
            z(str);
        }
    }

    @Override // n.a.a.n.d.e
    public void s(String str) {
        if (str == null) {
            y();
        } else {
            t(str);
            D(str);
        }
    }

    public n.a.a.n.e.l u() {
        return new n.a.a.n.e.l(this);
    }

    protected abstract n.a.a.n.a v();

    public final void w() {
        if (b() == j.BLANK) {
            return;
        }
        if (e()) {
            F(null);
        } else {
            x();
        }
    }

    protected abstract void x();

    public void y() {
        A(j.BLANK);
    }

    protected abstract void z(String str);
}
