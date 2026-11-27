package n.a.a.n.c.r1;

import n.a.a.n.c.t1.c6;
import n.a.a.n.c.t1.p6;

/* loaded from: classes.dex */
public final class b0 extends c6 {
    public static final p6 a = new b0();

    private b0() {
    }

    private static j l(w0 w0Var) throws p {
        if (w0Var instanceof j) {
            return (j) w0Var;
        }
        if (w0Var instanceof c0) {
            return ((c0) w0Var).c(0, 0, 0, 0);
        }
        if (w0Var instanceof o) {
            throw new p((o) w0Var);
        }
        throw new IllegalArgumentException("Unexpected ref arg class (" + w0Var.getClass().getName() + ")");
    }

    private static j m(j jVar, j jVar2) {
        int firstRow = jVar.getFirstRow();
        int firstColumn = jVar.getFirstColumn();
        return jVar.c(Math.min(firstRow, jVar2.getFirstRow()) - firstRow, Math.max(jVar.getLastRow(), jVar2.getLastRow()) - firstRow, Math.min(firstColumn, jVar2.getFirstColumn()) - firstColumn, Math.max(jVar.getLastColumn(), jVar2.getLastColumn()) - firstColumn);
    }

    @Override // n.a.a.n.c.t1.m6
    public w0 i(int i2, int i3, w0 w0Var, w0 w0Var2) {
        try {
            return m(l(w0Var), l(w0Var2));
        } catch (p e) {
            return e.a();
        }
    }
}
