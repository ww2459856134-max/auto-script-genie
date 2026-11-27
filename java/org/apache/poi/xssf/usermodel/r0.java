package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
public abstract class r0 extends n.a.a.n.c.d {
    protected r0(n.a.a.n.c.n1 n1Var) {
        super(n1Var);
    }

    private void i(l1 l1Var) {
        n.a.a.n.c.r rVarO;
        for (n.a.a.n.c.u1.k2 k2Var : f().q(l1Var)) {
            if (k2Var instanceof n.a.a.n.c.u1.b1) {
                n.a.a.n.c.u1.b1 b1Var = (n.a.a.n.c.u1.b1) k2Var;
                if (b1Var.f() > 0 && (rVarO = f().o(b1Var.c(), b1Var.g(), b1Var.f())) != null) {
                    j(l1Var, rVarO, b1Var);
                }
            }
        }
    }

    private static void j(l1 l1Var, n.a.a.n.c.r rVar, n.a.a.n.c.u1.b1 b1Var) {
        XSSFWorkbook workbook = l1Var.l().getSheet().getWorkbook();
        XSSFWorkbook xSSFWorkbook = (XSSFWorkbook) workbook.getCreationHelper().d().get(rVar.b());
        n.a.a.q.b.e externalLinksTable = workbook.getExternalLinksTable(b1Var.f() - 1);
        if (xSSFWorkbook == null || externalLinksTable == null) {
            return;
        }
        int sheetIndex = xSSFWorkbook.getSheetIndex(b1Var.c());
        int sheetIndex2 = b1Var.g() != null ? xSSFWorkbook.getSheetIndex(b1Var.g()) : sheetIndex;
        while (sheetIndex <= sheetIndex2) {
            i2 sheetAt = xSSFWorkbook.getSheetAt(sheetIndex);
            int firstRow = b1Var.getFirstRow();
            int lastRow = b1Var.getLastRow();
            for (int i2 = firstRow; i2 <= lastRow; i2++) {
                f2 f2VarF = sheetAt.f(i2);
                if (f2VarF != null) {
                    int firstColumn = b1Var.getFirstColumn();
                    int lastColumn = b1Var.getLastColumn();
                    for (int i3 = firstColumn; i3 <= lastColumn; i3++) {
                        z0 z0VarX = f2VarF.x(i3);
                        if (z0VarX != null) {
                            externalLinksTable.I(sheetAt.c(), i2 + 1, new n.a.a.n.e.s(z0VarX).i(false), z0VarX.U());
                        }
                    }
                }
            }
            sheetIndex++;
        }
    }

    @Override // n.a.a.n.c.d
    protected n.a.a.n.d.n0 c(String str) {
        return new d2(str);
    }

    @Override // n.a.a.n.c.d
    protected n.a.a.n.d.l e(n.a.a.n.d.e eVar) {
        try {
            n.a.a.n.c.l lVarK = k(eVar);
            n.a.a.n.c.r1.w0 w0VarG = this.a.g(lVarK);
            if (lVarK instanceof l1) {
                i((l1) lVarK);
            }
            if (w0VarG instanceof n.a.a.n.c.r1.x) {
                return new n.a.a.n.d.l(((n.a.a.n.c.r1.x) w0VarG).r());
            }
            if (w0VarG instanceof n.a.a.n.c.r1.m) {
                return n.a.a.n.d.l.h(((n.a.a.n.c.r1.m) w0VarG).u());
            }
            if (w0VarG instanceof n.a.a.n.c.r1.m0) {
                return new n.a.a.n.d.l(((n.a.a.n.c.r1.m0) w0VarG).getStringValue());
            }
            if (w0VarG instanceof n.a.a.n.c.r1.o) {
                return n.a.a.n.d.l.d(((n.a.a.n.c.r1.o) w0VarG).u());
            }
            throw new IllegalStateException("Unexpected eval class (" + w0VarG.getClass().getName() + "): " + w0VarG + ", cell: " + new n.a.a.n.e.s(eVar.getSheet().c(), eVar.g(), eVar.i(), false, false).i(true) + ", value: " + eVar);
        } catch (IllegalStateException e) {
            if (e.getClass() != IllegalStateException.class) {
                throw e;
            }
            throw new IllegalStateException("Failed to evaluate cell: " + new n.a.a.n.e.s(eVar.getSheet().c(), eVar.g(), eVar.i(), false, false).i(true) + ", value: " + eVar, e);
        }
    }

    protected abstract n.a.a.n.c.l k(n.a.a.n.d.e eVar);
}
