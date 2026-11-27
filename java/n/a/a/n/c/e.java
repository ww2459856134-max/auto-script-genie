package n.a.a.n.c;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class e extends n.a.a.n.c.r1.k {

    /* renamed from: i, reason: collision with root package name */
    private final n.a.a.n.c.r1.w0[] f2363i;

    public e(n.a.a.n.c.u1.d1 d1Var, n.a.a.n.c.r1.w0[] w0VarArr) {
        super(d1Var);
        this.f2363i = w0VarArr;
    }

    @Override // n.a.a.n.c.r1.j
    public n.a.a.n.c.r1.j c(int i2, int i3, int i4, int i5) {
        int i6;
        n.a.a.n.c.u1.c1 c1Var = new n.a.a.n.c.u1.c1(getFirstRow(), getFirstColumn(), i2, i3, i4, i5);
        int lastRow = (c1Var.getLastRow() - c1Var.getFirstRow()) + 1;
        int lastColumn = (c1Var.getLastColumn() - c1Var.getFirstColumn()) + 1;
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[lastRow * lastColumn];
        int firstRow = c1Var.getFirstRow() - getFirstRow();
        int firstColumn = c1Var.getFirstColumn() - getFirstColumn();
        for (int i7 = 0; i7 < lastRow; i7++) {
            for (int i8 = 0; i8 < lastColumn; i8++) {
                int i9 = firstRow + i7;
                w0VarArr[(i7 * lastColumn) + i8] = (i9 > getLastRow() || (i6 = firstColumn + i8) > getLastColumn()) ? n.a.a.n.c.r1.l.a : this.f2363i[(i9 * getWidth()) + i6];
            }
        }
        return new e(c1Var, w0VarArr);
    }

    @Override // n.a.a.n.c.j1
    public j1 f(int i2) {
        if (i2 >= a()) {
            throw new IllegalArgumentException("Invalid rowIndex " + i2 + ".  Allowable range is (0.." + a() + ").");
        }
        int firstRow = getFirstRow() + i2;
        int width = getWidth();
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[width];
        for (int i3 = 0; i3 < width; i3++) {
            w0VarArr[i3] = k(i2, i3);
        }
        return new e(firstRow, getFirstColumn(), firstRow, getLastColumn(), w0VarArr);
    }

    @Override // n.a.a.n.c.j1
    public j1 h(int i2) {
        if (i2 >= getWidth()) {
            throw new IllegalArgumentException("Invalid columnIndex " + i2 + ".  Allowable range is (0.." + getWidth() + ").");
        }
        int firstColumn = getFirstColumn() + i2;
        int iA = a();
        n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[iA];
        for (int i3 = 0; i3 < iA; i3++) {
            w0VarArr[i3] = k(i3, i2);
        }
        return new e(getFirstRow(), firstColumn, getLastRow(), firstColumn, w0VarArr);
    }

    @Override // n.a.a.n.c.r1.k, n.a.a.n.c.r1.j
    public n.a.a.n.c.r1.w0 k(int i2, int i3) {
        return v(-1, i2, i3);
    }

    public String toString() {
        return e.class.getName() + "[" + new n.a.a.n.e.s(getFirstRow(), getFirstColumn()).g() + NameUtil.COLON + new n.a.a.n.e.s(getLastRow(), getLastColumn()).g() + "]";
    }

    @Override // n.a.a.n.c.r1.k
    public n.a.a.n.c.r1.w0 v(int i2, int i3, int i4) {
        return this.f2363i[(i3 * getWidth()) + i4];
    }

    public e(int i2, int i3, int i4, int i5, n.a.a.n.c.r1.w0[] w0VarArr) {
        super(i2, i3, i4, i5);
        this.f2363i = w0VarArr;
    }
}
