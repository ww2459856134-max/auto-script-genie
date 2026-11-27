package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class o1 extends q0 {
    private final Map<i2, n1> c;

    private o1(XSSFWorkbook xSSFWorkbook) {
        super(xSSFWorkbook);
        this.c = new HashMap();
    }

    public static o1 x(XSSFWorkbook xSSFWorkbook) {
        if (xSSFWorkbook == null) {
            return null;
        }
        return new o1(xSSFWorkbook);
    }

    static /* synthetic */ n1 y(i2 i2Var, i2 i2Var2) {
        return new n1(i2Var);
    }

    @Override // n.a.a.n.c.t
    public int j(n.a.a.n.c.o oVar) {
        return this.a.getSheetIndex(((n1) oVar).b());
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.o l(int i2) {
        if (i2 < 0 || i2 >= this.a.getNumberOfSheets()) {
            this.a.getSheetAt(i2);
        }
        final i2 sheetAt = this.a.getSheetAt(i2);
        return this.c.computeIfAbsent(sheetAt, new Function() { // from class: org.apache.poi.xssf.usermodel.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return o1.y(sheetAt, (i2) obj);
            }
        });
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.u1.k2[] q(n.a.a.n.c.l lVar) {
        z0 z0VarL = ((l1) lVar).l();
        return n.a.a.n.c.b0.I(z0VarL.P(this), this, n.a.a.n.c.f0.CELL, this.a.getSheetIndex(z0VarL.getSheet()), z0VarL.g());
    }
}
