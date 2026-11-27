package org.apache.poi.xssf.usermodel;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.TreeMap;
import n.a.a.n.d.o0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

/* loaded from: classes.dex */
public class f2 implements n.a.a.n.d.o0, Comparable<f2> {
    private final CTRow c;
    private final TreeMap<Integer, z0> d = new TreeMap<>();
    private final i2 e;

    protected f2(CTRow cTRow, i2 i2Var) {
        this.c = cTRow;
        this.e = i2Var;
        for (CTCell cTCell : cTRow.getCArray()) {
            z0 z0Var = new z0(this, cTCell);
            this.d.put(Integer.valueOf(z0Var.i()), z0Var);
            i2Var.h0(z0Var);
        }
        if (cTRow.isSetR()) {
            return;
        }
        int iD = i2Var.d() + 2;
        if (iD == 2 && i2Var.m() == 0) {
            iD = 1;
        }
        cTRow.setR(iD);
    }

    private void g(CTCell[] cTCellArr) {
        CTCell[] cTCellArr2 = new CTCell[cTCellArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(this.d.size());
        int i2 = 0;
        int i3 = 0;
        for (CTCell cTCell : cTCellArr) {
            cTCellArr2[i3] = (CTCell) cTCell.copy();
            identityHashMap.put(cTCell, Integer.valueOf(i3));
            i3++;
        }
        for (z0 z0Var : this.d.values()) {
            Integer num = (Integer) identityHashMap.get(z0Var.O());
            Objects.requireNonNull(num, "Should find CTCell in _row");
            if (num.intValue() != i2) {
                this.c.setCArray(i2, cTCellArr2[num.intValue()]);
                z0Var.d0(this.c.getCArray(i2));
            }
            i2++;
        }
        while (this.c.sizeOfCArray() > this.d.size()) {
            this.c.removeC(this.d.size());
        }
    }

    private static void w(z0 z0Var, n.a.a.n.d.j jVar) {
        int i2 = e2.a[jVar.ordinal()];
        if (i2 == 1) {
            z0Var.n(0.0d);
            return;
        }
        if (i2 == 2) {
            z0Var.s("");
            return;
        }
        if (i2 == 3) {
            z0Var.o(false);
        } else {
            if (i2 == 4) {
                z0Var.e0(n.a.a.n.d.i0._NO_ERROR);
                return;
            }
            throw new AssertionError("Unknown cell-type specified: " + jVar);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f2 f2Var) {
        if (getSheet() == f2Var.getSheet()) {
            return Integer.compare(q(), f2Var.q());
        }
        throw new IllegalArgumentException("The compared rows must belong to the same sheet");
    }

    @Override // n.a.a.n.d.o0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z0 i(int i2) {
        return e(i2, n.a.a.n.d.j.BLANK);
    }

    public z0 e(int i2, n.a.a.n.d.j jVar) {
        CTCell cTCellAddNewC;
        Integer numValueOf = Integer.valueOf(i2);
        z0 z0Var = this.d.get(numValueOf);
        if (z0Var != null) {
            cTCellAddNewC = z0Var.O();
            cTCellAddNewC.set(CTCell.Factory.newInstance());
        } else {
            cTCellAddNewC = this.c.addNewC();
        }
        z0 z0Var2 = new z0(this, cTCellAddNewC);
        try {
            z0Var2.f0(i2);
            if (jVar != n.a.a.n.d.j.BLANK && jVar != n.a.a.n.d.j.FORMULA) {
                w(z0Var2, jVar);
            }
            this.d.put(numValueOf, z0Var2);
            return z0Var2;
        } catch (IllegalArgumentException e) {
            this.c.removeC(this.c.getCList().size() - 1);
            throw e;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f2)) {
            return false;
        }
        f2 f2Var = (f2) obj;
        return q() == f2Var.q() && getSheet() == f2Var.getSheet();
    }

    public CTRow h() {
        return this.c;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // n.a.a.n.d.o0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public z0 x(int i2) {
        return k(i2, this.e.getWorkbook().getMissingCellPolicy());
    }

    public z0 k(int i2, o0.a aVar) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Cell index must be >= 0");
        }
        z0 z0Var = this.d.get(Integer.valueOf(i2));
        int i3 = e2.b[aVar.ordinal()];
        if (i3 == 1) {
            return z0Var;
        }
        if (i3 == 2) {
            if (z0Var != null && z0Var.b() == n.a.a.n.d.j.BLANK) {
                return null;
            }
            return z0Var;
        }
        if (i3 == 3) {
            return z0Var == null ? e(i2, n.a.a.n.d.j.BLANK) : z0Var;
        }
        throw new IllegalArgumentException("Illegal policy " + aVar);
    }

    public short l() {
        return (short) (this.d.isEmpty() ? -1 : this.d.firstKey().intValue());
    }

    @Override // n.a.a.n.d.o0
    public short n() {
        return (short) (this.d.isEmpty() ? -1 : this.d.lastKey().intValue() + 1);
    }

    public float p() {
        return this.c.isSetHt() ? (float) this.c.getHt() : this.e.S();
    }

    @Override // n.a.a.n.d.o0
    public int q() {
        return Math.toIntExact(this.c.getR() - 1);
    }

    @Override // n.a.a.n.d.o0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public i2 getSheet() {
        return this.e;
    }

    @Override // n.a.a.n.d.o0
    public Iterator<n.a.a.n.d.e> s() {
        return this.d.values().iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<n.a.a.n.d.e> spliterator() {
        return this.d.values().spliterator();
    }

    public boolean t() {
        return this.c.getHidden();
    }

    public String toString() {
        return this.c.toString();
    }

    protected void u() {
        CTCell[] cArray = this.c.getCArray();
        if (cArray.length == this.d.size()) {
            Iterator<z0> it = this.d.values().iterator();
            int length = cArray.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                }
                CTCell cTCell = cArray[i2];
                z0 next = it.next();
                next.H();
                if (cTCell != next.O()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return;
            }
        }
        g(cArray);
    }

    public void v(n.a.a.n.d.e eVar) throws IllegalStateException, n.a.a.n.c.x {
        if (eVar.getRow() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this row");
        }
        if (!this.d.containsValue(eVar)) {
            throw new IllegalArgumentException("the row does not contain this cell");
        }
        z0 z0Var = (z0) eVar;
        if (z0Var.e()) {
            z0Var.r(null);
        }
        if (eVar.b() == n.a.a.n.d.j.FORMULA) {
            this.e.getWorkbook().onDeleteFormula(z0Var);
        }
        z0 z0VarRemove = this.d.remove(Integer.valueOf(eVar.i()));
        int i2 = 0;
        for (CTCell cTCell : this.c.getCArray()) {
            if (cTCell == z0VarRemove.O()) {
                this.c.removeC(i2);
            }
            i2++;
        }
    }

    public void z(int i2) {
        int iC = n.a.a.n.a.EXCEL2007.c();
        if (i2 >= 0 && i2 <= iC) {
            this.c.setR(i2 + 1);
            return;
        }
        throw new IllegalArgumentException("Invalid row number (" + i2 + ") outside allowable range (0.." + iC + ")");
    }
}
