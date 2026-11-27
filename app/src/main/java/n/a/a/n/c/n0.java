package n.a.a.n.c;

import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class n0 extends n.a.a.n.c.r1.k {

    /* renamed from: i, reason: collision with root package name */
    private final f1 f2366i;

    n0(n.a.a.n.c.u1.d1 d1Var, f1 f1Var) {
        super(d1Var, f1Var);
        this.f2366i = f1Var;
    }

    @Override // n.a.a.n.c.r1.j
    public n.a.a.n.c.r1.j c(int i2, int i3, int i4, int i5) {
        return new n0(new n.a.a.n.c.u1.c1(getFirstRow(), getFirstColumn(), i2, i3, i4, i5), this.f2366i);
    }

    @Override // n.a.a.n.c.r1.k, n.a.a.n.c.j1
    public boolean e(int i2) {
        f1 f1Var = this.f2366i;
        return f1Var.h(f1Var.g()).f(getFirstRow() + i2);
    }

    @Override // n.a.a.n.c.r1.k, n.a.a.n.c.r1.j
    public n.a.a.n.c.r1.w0 k(int i2, int i3) {
        return v(g(), i2, i3);
    }

    @Override // n.a.a.n.c.r1.k, n.a.a.n.c.j1
    public boolean n(int i2, int i3) {
        f1 f1Var = this.f2366i;
        return f1Var.h(f1Var.g()).g(getFirstRow() + i2, getFirstColumn() + i3);
    }

    public String toString() {
        return n0.class.getName() + "[" + this.f2366i.p() + '!' + new n.a.a.n.e.s(getFirstRow(), getFirstColumn()).g() + NameUtil.COLON + new n.a.a.n.e.s(getLastRow(), getLastColumn()).g() + "]";
    }

    @Override // n.a.a.n.c.r1.k
    public n.a.a.n.c.r1.w0 v(int i2, int i3, int i4) {
        return this.f2366i.f(i2, i3 + getFirstRow(), i4 + getFirstColumn());
    }

    @Override // n.a.a.n.c.j1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public n0 h(int i2) {
        if (i2 < getWidth()) {
            int firstColumn = getFirstColumn() + i2;
            return new n0(getFirstRow(), firstColumn, getLastRow(), firstColumn, this.f2366i);
        }
        throw new IllegalArgumentException("Invalid columnIndex " + i2 + ".  Allowable range is (0.." + getWidth() + ").");
    }

    @Override // n.a.a.n.c.j1
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public n0 f(int i2) {
        if (i2 < a()) {
            int firstRow = getFirstRow() + i2;
            return new n0(firstRow, getFirstColumn(), firstRow, getLastColumn(), this.f2366i);
        }
        throw new IllegalArgumentException("Invalid rowIndex " + i2 + ".  Allowable range is (0.." + a() + ").");
    }

    public n0(int i2, int i3, int i4, int i5, f1 f1Var) {
        super(f1Var, i2, i3, f1Var.e(i4), i5);
        this.f2366i = f1Var;
    }
}
