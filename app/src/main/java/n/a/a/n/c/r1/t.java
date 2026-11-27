package n.a.a.n.c.r1;

import n.a.a.n.c.t1.c6;
import n.a.a.n.c.t1.p6;

/* loaded from: classes.dex */
public final class t extends c6 {
    public static final p6 a = new t();

    private t() {
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
        int firstColumn;
        int lastRow;
        int firstRow;
        int lastRow2;
        int firstRow2 = jVar.getFirstRow();
        int firstColumn2 = jVar.getFirstColumn();
        int lastColumn = jVar2.getLastColumn();
        if (firstColumn2 <= lastColumn && (firstColumn = jVar2.getFirstColumn()) <= jVar.getLastColumn() && firstRow2 <= (lastRow = jVar2.getLastRow()) && (firstRow = jVar2.getFirstRow()) <= (lastRow2 = jVar.getLastRow())) {
            return jVar.c(Math.max(firstRow2, firstRow) - firstRow2, Math.min(lastRow2, lastRow) - firstRow2, Math.max(firstColumn2, firstColumn) - firstColumn2, Math.min(jVar.getLastColumn(), lastColumn) - firstColumn2);
        }
        return null;
    }

    @Override // n.a.a.n.c.t1.m6
    public w0 i(int i2, int i3, w0 w0Var, w0 w0Var2) {
        try {
            j jVarM = m(l(w0Var), l(w0Var2));
            return jVarM == null ? o.c : jVarM;
        } catch (p e) {
            return e.a();
        }
    }
}
