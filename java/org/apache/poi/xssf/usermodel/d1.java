package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

/* loaded from: classes.dex */
public class d1 extends v0 {
    private static final CTMarker f = CTMarker.Factory.newInstance();
    private CTMarker a;
    private CTMarker b;
    private CTPositiveSize2D c;
    private CTPoint2D d;
    private i2 e;

    protected d1(CTMarker cTMarker, CTMarker cTMarker2) {
        n.a.a.n.d.m mVar = n.a.a.n.d.m.MOVE_AND_RESIZE;
        this.a = cTMarker;
        this.b = cTMarker2;
    }

    private CTMarker a(CTMarker cTMarker, long j2, long j3) {
        CTMarker cTMarkerNewInstance = CTMarker.Factory.newInstance();
        int row = cTMarker.getRow();
        int col = cTMarker.getCol();
        int iB = n.a.a.o.n1.b(this.e.Q(col));
        long jA = iB - n.a.a.j.o.c.a(cTMarker.xgetColOff());
        while (jA < j2) {
            col++;
            iB = n.a.a.o.n1.b(this.e.Q(col));
            jA += iB;
        }
        cTMarkerNewInstance.setCol(col);
        cTMarkerNewInstance.setColOff(Long.valueOf(iB - (jA - j2)));
        int iC = n.a.a.o.n1.c(l(this.e, row));
        long jA2 = iC - n.a.a.j.o.c.a(cTMarker.xgetRowOff());
        while (jA2 < j3) {
            row++;
            iC = n.a.a.o.n1.c(l(this.e, row));
            jA2 += iC;
        }
        cTMarkerNewInstance.setRow(row);
        cTMarkerNewInstance.setRowOff(Long.valueOf(iC - (jA2 - j3)));
        return cTMarkerNewInstance;
    }

    private CTMarker b() {
        CTMarker cTMarker = this.a;
        return cTMarker != null ? cTMarker : a(f, n.a.a.j.o.c.a(this.d.xgetX()), n.a.a.j.o.c.a(this.d.xgetY()));
    }

    private CTMarker c() {
        CTMarker cTMarker = this.b;
        return cTMarker != null ? cTMarker : a(b(), this.c.getCx(), this.c.getCy());
    }

    private static float l(i2 i2Var, int i2) {
        f2 f2VarF = i2Var.f(i2);
        return f2VarF == null ? i2Var.S() : f2VarF.p();
    }

    public short d() {
        return (short) b().getCol();
    }

    public short e() {
        return (short) c().getCol();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return f() == d1Var.f() && g() == d1Var.g() && h() == d1Var.h() && i() == d1Var.i() && d() == d1Var.d() && e() == d1Var.e() && j() == d1Var.j() && k() == d1Var.k();
    }

    public int f() {
        return Math.toIntExact(n.a.a.j.o.c.a(b().xgetColOff()));
    }

    public int g() {
        return Math.toIntExact(n.a.a.j.o.c.a(c().xgetColOff()));
    }

    public int h() {
        return Math.toIntExact(n.a.a.j.o.c.a(b().xgetRowOff()));
    }

    public int hashCode() {
        return 42;
    }

    public int i() {
        return Math.toIntExact(n.a.a.j.o.c.a(c().xgetRowOff()));
    }

    public int j() {
        return b().getRow();
    }

    public int k() {
        return c().getRow();
    }

    public String toString() {
        return "from : " + b() + "; to: " + c();
    }

    protected d1(i2 i2Var, CTMarker cTMarker, CTPositiveSize2D cTPositiveSize2D) {
        n.a.a.n.d.m mVar = n.a.a.n.d.m.MOVE_DONT_RESIZE;
        this.e = i2Var;
        this.c = cTPositiveSize2D;
        this.a = cTMarker;
    }

    protected d1(i2 i2Var, CTPoint2D cTPoint2D, CTPositiveSize2D cTPositiveSize2D) {
        n.a.a.n.d.m mVar = n.a.a.n.d.m.DONT_MOVE_AND_RESIZE;
        this.e = i2Var;
        this.d = cTPoint2D;
        this.c = cTPositiveSize2D;
    }
}
