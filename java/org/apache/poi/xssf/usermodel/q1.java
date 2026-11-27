package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
public final class q1 extends r0 {
    public q1(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, null, null);
    }

    @Override // org.apache.poi.xssf.usermodel.r0
    protected n.a.a.n.c.l k(n.a.a.n.d.e eVar) {
        if (eVar instanceof z0) {
            return new l1((z0) eVar);
        }
        throw new IllegalArgumentException("Unexpected type of cell: " + eVar.getClass() + ". Only XSSFCells can be evaluated.");
    }

    private q1(XSSFWorkbook xSSFWorkbook, n.a.a.n.c.m0 m0Var, n.a.a.n.c.v1.c cVar) {
        this(xSSFWorkbook, new n.a.a.n.c.n1(o1.x(xSSFWorkbook), m0Var, cVar));
    }

    protected q1(XSSFWorkbook xSSFWorkbook, n.a.a.n.c.n1 n1Var) {
        super(n1Var);
    }
}
