package org.apache.poi.xssf.usermodel.t2;

import java.util.Objects;
import n.a.a.q.b.l;
import org.apache.poi.xssf.usermodel.e1;
import org.apache.poi.xssf.usermodel.u0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* loaded from: classes.dex */
public class c {
    private final u0 a;
    private l b;
    private final CTBorder c;

    public c(CTBorder cTBorder, l lVar, u0 u0Var) {
        this.c = cTBorder;
        this.a = u0Var;
        this.b = lVar;
    }

    private CTBorderPr a(b bVar) {
        return b(bVar, false);
    }

    private CTBorderPr b(b bVar, boolean z) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                CTBorderPr top = this.c.getTop();
                return (z && top == null) ? this.c.addNewTop() : top;
            case 2:
                CTBorderPr right = this.c.getRight();
                return (z && right == null) ? this.c.addNewRight() : right;
            case 3:
                CTBorderPr bottom = this.c.getBottom();
                return (z && bottom == null) ? this.c.addNewBottom() : bottom;
            case 4:
                CTBorderPr left = this.c.getLeft();
                return (z && left == null) ? this.c.addNewLeft() : left;
            case 5:
                CTBorderPr diagonal = this.c.getDiagonal();
                return (z && diagonal == null) ? this.c.addNewDiagonal() : diagonal;
            case 6:
                CTBorderPr vertical = this.c.getVertical();
                return (z && vertical == null) ? this.c.addNewVertical() : vertical;
            case 7:
                CTBorderPr horizontal = this.c.getHorizontal();
                return (z && horizontal == null) ? this.c.addNewHorizontal() : horizontal;
            default:
                throw new IllegalArgumentException("No suitable side specified for the border, had " + bVar);
        }
    }

    public e1 c(b bVar) {
        CTBorderPr cTBorderPrA = a(bVar);
        if (cTBorderPrA == null || !cTBorderPrA.isSetColor()) {
            return null;
        }
        e1 e1VarF = e1.f(cTBorderPrA.getColor(), this.a);
        l lVar = this.b;
        if (lVar != null) {
            lVar.J(e1VarF);
        }
        return e1VarF;
    }

    public n.a.a.n.d.c d(b bVar) {
        return n.a.a.n.d.c.values()[(a(bVar) == null ? STBorderStyle.NONE : r2.getStyle()).intValue() - 1];
    }

    public CTBorder e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        for (b bVar : b.values()) {
            if (!Objects.equals(c(bVar), cVar.c(bVar)) || !Objects.equals(d(bVar), cVar.d(bVar))) {
                z = false;
                break;
            }
        }
        z = true;
        if (!z || this.c.isSetDiagonalUp() != cVar.c.isSetDiagonalUp() || this.c.isSetDiagonalDown() != cVar.c.isSetDiagonalDown() || this.c.isSetOutline() != cVar.c.isSetOutline()) {
            return false;
        }
        if (this.c.isSetDiagonalUp() && this.c.getDiagonalUp() != cVar.c.getDiagonalUp()) {
            return false;
        }
        if (!this.c.isSetDiagonalDown() || this.c.getDiagonalDown() == cVar.c.getDiagonalDown()) {
            return !this.c.isSetOutline() || this.c.getOutline() == cVar.c.getOutline();
        }
        return false;
    }

    public void f(l lVar) {
        this.b = lVar;
    }

    public int hashCode() {
        return this.c.toString().hashCode();
    }

    public c(CTBorder cTBorder) {
        this(cTBorder, null, null);
    }

    public c(CTBorder cTBorder, u0 u0Var) {
        this(cTBorder, null, u0Var);
    }
}
