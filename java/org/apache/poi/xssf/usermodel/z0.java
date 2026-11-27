package org.apache.poi.xssf.usermodel;

import com.auto.exceldeps.log4j.Logger;
import java.util.Date;
import n.a.a.n.d.o0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* loaded from: classes.dex */
public final class z0 extends n.a.a.n.d.f {
    private static final Logger f = n.a.a.i.b.a(z0.class);
    private CTCell a;
    private final f2 b;
    private int c;
    private final n.a.a.q.b.g d;
    private final n.a.a.q.b.i e;

    protected z0(f2 f2Var, CTCell cTCell) {
        this.a = cTCell;
        this.b = f2Var;
        String r = cTCell.getR();
        if (r != null) {
            this.c = new n.a.a.n.e.s(r).l();
        } else {
            short sN = f2Var.n();
            if (sN != -1) {
                this.c = f2Var.k(sN - 1, o0.a.RETURN_NULL_AND_BLANK).i() + 1;
            }
        }
        this.d = f2Var.getSheet().getWorkbook().getSharedStringSource();
        this.e = f2Var.getSheet().getWorkbook().getStylesSource();
    }

    private static void I(int i2) {
        n.a.a.n.a aVar = n.a.a.n.a.EXCEL2007;
        int iA = aVar.a();
        if (i2 < 0 || i2 > iA) {
            throw new IllegalArgumentException("Invalid column index (" + i2 + ").  Allowable column range for " + aVar.name() + " is (0.." + iA + ") or ('A'..'" + aVar.b() + "')");
        }
    }

    private boolean J() {
        n.a.a.n.d.j jVarB = b();
        if (jVarB == n.a.a.n.d.j.FORMULA) {
            jVarB = N(false);
        }
        int i2 = y0.a[jVarB.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "1".equals(this.a.getV());
            }
            if (i2 == 4) {
                return a0(this.a.getV()) != 0.0d;
            }
            if (i2 == 5) {
                return Boolean.parseBoolean(this.d.K(b0(this.a.getV())).getString());
            }
            if (i2 != 6) {
                throw new IllegalStateException("Unexpected cell type (" + jVarB + ")");
            }
        }
        return false;
    }

    private String K() throws Error, RuntimeException {
        n.a.a.n.d.j jVarB = b();
        int[] iArr = y0.a;
        switch (iArr[jVarB.ordinal()]) {
            case 1:
                return "";
            case 2:
                return "1".equals(this.a.getV()) ? "TRUE" : "FALSE";
            case 3:
                n.a.a.n.d.j jVarN = N(false);
                String v = this.a.getV();
                int i2 = iArr[jVarN.ordinal()];
                if (i2 != 2) {
                    if (i2 == 4 || i2 == 5 || i2 == 6) {
                        return v;
                    }
                    throw new IllegalStateException("Unexpected formula result type (" + jVarN + ")");
                }
                if ("1".equals(v)) {
                    return "TRUE";
                }
                if ("0".equals(v)) {
                    return "FALSE";
                }
                throw new IllegalStateException("Unexpected boolean cached formula value '" + v + "'.");
            case 4:
            case 6:
                return this.a.getV();
            case 5:
                try {
                    return this.d.K(b0(this.a.getV())).getString();
                } catch (Throwable th) {
                    if (n.a.a.o.q0.a(th)) {
                        n.a.a.o.q0.b(th);
                        throw null;
                    }
                    f.atError().withThrowable(th).log("Failed to parse SST index '{}'", this.a.getV());
                    return "";
                }
            default:
                throw new IllegalStateException("Unexpected cell type (" + jVarB + ")");
        }
    }

    private String L(int i2, q0 q0Var) {
        i2 sheet = getSheet();
        CTCellFormula cTCellFormulaX = sheet.X(i2);
        if (cTCellFormulaX != null) {
            String stringValue = cTCellFormulaX.getStringValue();
            n.a.a.n.e.m mVarF = n.a.a.n.e.m.F(cTCellFormulaX.getRef());
            return n.a.a.n.c.d0.b(q0Var, new n.a.a.n.c.a1(n.a.a.n.a.EXCEL2007).a(n.a.a.n.c.b0.I(stringValue, q0Var, n.a.a.n.c.f0.CELL, sheet.getWorkbook().getSheetIndex(sheet), g()), g() - mVarF.b(), i() - mVarF.a()));
        }
        throw new IllegalStateException("Master cell of a shared formula with sid=" + i2 + " was not found");
    }

    private d2 M() throws Error, RuntimeException {
        STCellType.Enum t = this.a.getT();
        if (t == STCellType.INLINE_STR) {
            return this.a.isSetIs() ? new d2(this.a.getIs()) : this.a.isSetV() ? new d2(this.a.getV()) : new d2("");
        }
        if (t == STCellType.STR) {
            return new d2(this.a.isSetV() ? this.a.getV() : "");
        }
        if (!this.a.isSetV()) {
            return new d2("");
        }
        try {
            return (d2) this.d.K(b0(this.a.getV()));
        } catch (Throwable th) {
            if (n.a.a.o.q0.a(th)) {
                n.a.a.o.q0.b(th);
                throw null;
            }
            f.atError().withThrowable(th).log("Failed to parse SST index '{}'", this.a.getV());
            return new d2("");
        }
    }

    private n.a.a.n.d.j N(boolean z) {
        switch (this.a.getT().intValue()) {
            case 1:
                return n.a.a.n.d.j.BOOLEAN;
            case 2:
                return (this.a.isSetV() || !z) ? n.a.a.n.d.j.NUMERIC : n.a.a.n.d.j.BLANK;
            case 3:
                return n.a.a.n.d.j.ERROR;
            case 4:
            case 5:
            case 6:
                return n.a.a.n.d.j.STRING;
            default:
                throw new IllegalStateException("Illegal cell type: " + this.a.getT());
        }
    }

    private a1 R() {
        i2 sheet = getSheet();
        if (sheet != null) {
            return (a1) sheet.P(i());
        }
        return null;
    }

    private a1 T() {
        if (this.e.getNumCellStyles() <= 0 || !this.a.isSetS()) {
            return null;
        }
        return this.e.S(Math.toIntExact(this.a.getS()));
    }

    private boolean Z() {
        return (this.a.isSetF() && this.a.getF().getT() != STCellFormulaType.DATA_TABLE) || getSheet().e0(this);
    }

    private static double a0(String str) throws NumberFormatException {
        return Double.parseDouble(str.trim());
    }

    private static int b0(String str) throws NumberFormatException {
        return Integer.parseInt(str.trim());
    }

    private void c0() {
        CTCell cTCellNewInstance = CTCell.Factory.newInstance();
        cTCellNewInstance.setR(this.a.getR());
        if (this.a.isSetS()) {
            cTCellNewInstance.setS(this.a.getS());
        }
        this.a.set(cTCellNewInstance);
    }

    private void i0(String str, n.a.a.n.c.f0 f0Var) {
        XSSFWorkbook workbook = this.b.getSheet().getWorkbook();
        if (f0Var == n.a.a.n.c.f0.ARRAY && str == null) {
            x();
            return;
        }
        if (workbook.getCellFormulaValidation()) {
            n.a.a.n.c.b0.I(str, o1.x(workbook), f0Var, workbook.getSheetIndex(getSheet()), g());
        }
        if (!this.a.isSetF()) {
            CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
            cTCellFormulaNewInstance.setStringValue(str);
            this.a.setF(cTCellFormulaNewInstance);
        } else {
            CTCellFormula f2 = this.a.getF();
            f2.setStringValue(str);
            if (f2.getT() == STCellFormulaType.SHARED) {
                getRow().getSheet().h0(this);
            }
        }
    }

    private static RuntimeException j0(n.a.a.n.d.j jVar, n.a.a.n.d.j jVar2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get a ");
        sb.append(jVar);
        sb.append(" value from a ");
        sb.append(jVar2);
        sb.append(" ");
        sb.append(z ? "formula " : "");
        sb.append("cell");
        return new IllegalStateException(sb.toString());
    }

    @Override // n.a.a.n.d.f
    protected void B(n.a.a.n.d.j jVar) {
        h0(jVar, null);
    }

    @Override // n.a.a.n.d.f
    public void C(double d) {
        this.a.setT(STCellType.N);
        this.a.setV(String.valueOf(d));
    }

    @Override // n.a.a.n.d.f
    protected void D(String str) {
        E(new d2(str));
    }

    @Override // n.a.a.n.d.f
    protected void E(n.a.a.n.d.n0 n0Var) {
        if (b() == n.a.a.n.d.j.FORMULA) {
            this.a.setV(n0Var.getString());
            this.a.setT(STCellType.STR);
            return;
        }
        if (this.a.getT() == STCellType.INLINE_STR) {
            this.a.setV(n0Var.getString());
            return;
        }
        if (n0Var instanceof d2) {
            this.a.setT(STCellType.S);
            d2 d2Var = (d2) n0Var;
            d2Var.d(this.e);
            this.a.setV(Integer.toString(this.d.J(d2Var)));
            return;
        }
        this.a.setT(STCellType.S);
        d2 d2Var2 = new d2(n0Var.getString());
        d2Var2.d(this.e);
        this.a.setV(Integer.toString(this.d.J(d2Var2)));
    }

    protected void H() {
        a1 a1VarR;
        if (T() != null || getSheet() == null || (a1VarR = R()) == null) {
            return;
        }
        g0(a1VarR);
    }

    public CTCell O() {
        return this.a;
    }

    protected String P(q0 q0Var) {
        n.a.a.n.d.j jVarB = b();
        n.a.a.n.d.j jVar = n.a.a.n.d.j.FORMULA;
        if (jVarB != jVar) {
            throw j0(jVar, jVarB, false);
        }
        CTCellFormula f2 = this.a.getF();
        if (e() && (f2 == null || f2.getStringValue().isEmpty())) {
            return getSheet().U(this).P(q0Var);
        }
        if (f2 == null) {
            return null;
        }
        if (f2.getT() != STCellFormulaType.SHARED) {
            return f2.getStringValue();
        }
        int intExact = Math.toIntExact(f2.getSi());
        if (q0Var == null) {
            q0Var = o1.x(getSheet().getWorkbook());
        }
        return L(intExact, q0Var);
    }

    @Override // n.a.a.n.d.e
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public a1 k() {
        a1 a1VarT = T();
        return a1VarT == null ? R() : a1VarT;
    }

    public String S() throws IllegalStateException {
        n.a.a.n.d.j jVarN = N(true);
        n.a.a.n.d.j jVar = n.a.a.n.d.j.ERROR;
        if (jVarN == jVar) {
            return this.a.getV();
        }
        throw j0(jVar, jVarN, false);
    }

    public String U() {
        return this.a.getV();
    }

    public String V() {
        String r = this.a.getR();
        return r == null ? u().b() : r;
    }

    @Override // n.a.a.n.d.e
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public d2 q() throws Error, RuntimeException {
        d2 d2Var;
        n.a.a.n.d.j jVarB = b();
        int i2 = y0.a[jVarB.ordinal()];
        if (i2 == 1) {
            d2Var = new d2("");
        } else if (i2 == 3) {
            n.a.a.n.d.j jVarN = N(false);
            n.a.a.n.d.j jVar = n.a.a.n.d.j.STRING;
            if (jVarN != jVar) {
                throw j0(jVar, jVarN, true);
            }
            d2Var = M();
        } else {
            if (i2 != 5) {
                throw j0(n.a.a.n.d.j.STRING, jVarB, false);
            }
            d2Var = M();
        }
        d2Var.d(this.e);
        return d2Var;
    }

    @Override // n.a.a.n.d.e
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public f2 getRow() {
        return this.b;
    }

    @Override // n.a.a.n.d.e
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public i2 getSheet() {
        return getRow().getSheet();
    }

    @Override // n.a.a.n.d.e
    public byte a() throws IllegalStateException {
        String strS = S();
        if (strS == null) {
            return (byte) 0;
        }
        try {
            return n.a.a.n.d.i0.c(strS).d();
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Unexpected error code", e);
        }
    }

    @Override // n.a.a.n.d.e
    public n.a.a.n.d.j b() {
        return Z() ? n.a.a.n.d.j.FORMULA : N(true);
    }

    @Override // n.a.a.n.d.e
    public boolean c() {
        n.a.a.n.d.j jVarB = b();
        int i2 = y0.a[jVarB.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 == 2) {
            return this.a.isSetV() && "1".equals(this.a.getV());
        }
        if (i2 == 3) {
            return this.a.isSetV() && "1".equals(this.a.getV());
        }
        throw j0(n.a.a.n.d.j.BOOLEAN, jVarB, false);
    }

    @Override // n.a.a.n.d.e
    public double d() {
        n.a.a.n.d.j jVarH = Z() ? h() : b();
        int i2 = y0.a[jVarH.ordinal()];
        if (i2 == 1) {
            return 0.0d;
        }
        if (i2 == 3) {
            throw new AssertionError();
        }
        if (i2 != 4) {
            throw j0(n.a.a.n.d.j.NUMERIC, jVarH, false);
        }
        if (!this.a.isSetV()) {
            return 0.0d;
        }
        String v = this.a.getV();
        if (v.isEmpty()) {
            return 0.0d;
        }
        try {
            return a0(v);
        } catch (NumberFormatException unused) {
            throw j0(n.a.a.n.d.j.NUMERIC, n.a.a.n.d.j.STRING, false);
        }
    }

    public void d0(CTCell cTCell) {
        this.a = cTCell;
    }

    @Override // n.a.a.n.d.e
    public boolean e() {
        return getSheet().e0(this);
    }

    public void e0(n.a.a.n.d.i0 i0Var) {
        this.a.setT(STCellType.E);
        this.a.setV(i0Var.f());
    }

    @Override // n.a.a.n.d.e
    public n.a.a.n.e.m f() {
        z0 z0VarU = getSheet().U(this);
        if (z0VarU != null) {
            return n.a.a.n.e.m.F(z0VarU.a.getF().getRef());
        }
        throw new IllegalStateException("Cell " + new n.a.a.n.e.s(this).g() + " is not part of an array formula.");
    }

    protected void f0(int i2) {
        I(i2);
        this.c = i2;
        this.a.setR(new n.a.a.n.e.s(g(), i()).g());
    }

    @Override // n.a.a.n.d.e
    public int g() {
        return this.b.q();
    }

    public void g0(n.a.a.n.d.i iVar) {
        if (iVar == null) {
            if (this.a.isSetS()) {
                this.a.unsetS();
            }
        } else {
            ((a1) iVar).d(this.e);
            this.a.setS(this.e.X(r3));
        }
    }

    @Override // n.a.a.n.d.e
    public n.a.a.n.d.j h() {
        if (Z()) {
            return N(false);
        }
        throw new IllegalStateException("Only formula cells have cached results");
    }

    protected void h0(n.a.a.n.d.j jVar, q0 q0Var) {
        n.a.a.n.d.j jVarB = b();
        n.a.a.n.d.j jVar2 = n.a.a.n.d.j.FORMULA;
        if (jVarB == jVar2 && jVar != jVar2) {
            if (this.a.isSetF()) {
                this.b.getSheet().g0(this, q0Var);
            }
            getSheet().getWorkbook().onDeleteFormula(this);
        }
        switch (y0.a[jVar.ordinal()]) {
            case 1:
                c0();
                break;
            case 2:
                String str = J() ? "1" : "0";
                this.a.setT(STCellType.B);
                this.a.setV(str);
                break;
            case 3:
                if (!this.a.isSetF()) {
                    CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
                    cTCellFormulaNewInstance.setStringValue("0");
                    this.a.setF(cTCellFormulaNewInstance);
                    if (this.a.isSetT()) {
                        this.a.unsetT();
                        break;
                    }
                }
                break;
            case 4:
                this.a.setT(STCellType.N);
                break;
            case 5:
                if (jVarB != n.a.a.n.d.j.STRING) {
                    d2 d2Var = new d2(K());
                    d2Var.d(this.e);
                    this.a.setV(Integer.toString(this.d.J(d2Var)));
                }
                this.a.setT(STCellType.S);
                break;
            case 6:
                this.a.setT(STCellType.E);
                break;
            default:
                throw new IllegalArgumentException("Illegal cell type: " + jVar);
        }
        if (jVar == jVar2 || !this.a.isSetF()) {
            return;
        }
        this.a.unsetF();
    }

    @Override // n.a.a.n.d.e
    public int i() {
        return this.c;
    }

    @Override // n.a.a.n.d.e
    public String j() {
        return P(null);
    }

    @Override // n.a.a.n.d.e
    public Date m() {
        if (b() == n.a.a.n.d.j.BLANK) {
            return null;
        }
        return n.a.a.n.d.y.l(d(), getSheet().getWorkbook().isDate1904());
    }

    @Override // n.a.a.n.d.e
    public void o(boolean z) {
        this.a.setT(STCellType.B);
        this.a.setV(z ? "1" : "0");
    }

    @Override // n.a.a.n.d.e
    public void p(byte b) {
        e0(n.a.a.n.d.i0.a(b));
    }

    public String toString() {
        switch (y0.a[b().ordinal()]) {
            case 1:
                return "";
            case 2:
                return c() ? "TRUE" : "FALSE";
            case 3:
                return j();
            case 4:
                if (!n.a.a.n.d.y.r(this)) {
                    return Double.toString(d());
                }
                n.a.a.n.d.w wVar = new n.a.a.n.d.w();
                wVar.z(true);
                return wVar.l(this);
            case 5:
                return q().toString();
            case 6:
                return n.a.a.n.c.r1.o.v(a());
            default:
                return "Unknown Cell Type: " + b();
        }
    }

    @Override // n.a.a.n.d.f
    protected n.a.a.n.a v() {
        return n.a.a.n.a.EXCEL2007;
    }

    @Override // n.a.a.n.d.f
    protected void x() {
        this.b.getSheet().getWorkbook().onDeleteFormula(this);
        if (this.a.isSetF()) {
            this.b.getSheet().g0(this, null);
            this.a.unsetF();
        }
    }

    @Override // n.a.a.n.d.f
    protected void z(String str) {
        i0(str, n.a.a.n.c.f0.CELL);
    }
}
