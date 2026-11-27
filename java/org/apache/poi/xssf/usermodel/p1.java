package org.apache.poi.xssf.usermodel;

import java.util.Objects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontFamily;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;

/* loaded from: classes.dex */
public class p1 implements n.a.a.n.d.d0 {
    public static final short e = n.a.a.n.d.l0.BLACK.a();
    private u0 a;
    private n.a.a.q.b.l b;
    private final CTFont c;
    private int d;

    public p1(CTFont cTFont, int i2, u0 u0Var) {
        this.c = cTFont;
        this.d = (short) i2;
        this.a = u0Var;
    }

    private double g() {
        CTFontSize szArray = this.c.sizeOfSzArray() == 0 ? null : this.c.getSzArray(0);
        if (szArray != null) {
            return szArray.getVal();
        }
        return 11.0d;
    }

    public boolean a() {
        CTBooleanProperty bArray = this.c.sizeOfBArray() == 0 ? null : this.c.getBArray(0);
        return bArray != null && bArray.getVal();
    }

    public CTFont b() {
        return this.c;
    }

    public int c() {
        CTIntProperty charsetArray = this.c.sizeOfCharsetArray() == 0 ? null : this.c.getCharsetArray(0);
        return (charsetArray == null ? n.a.a.e.a.d.a.ANSI : n.a.a.e.a.d.a.b(charsetArray.getVal())).a();
    }

    public short d() {
        CTColor colorArray = this.c.sizeOfColorArray() == 0 ? null : this.c.getColorArray(0);
        if (colorArray == null) {
            return n.a.a.n.d.l0.BLACK.a();
        }
        long indexed = colorArray.getIndexed();
        if (indexed == e) {
            return n.a.a.n.d.l0.BLACK.a();
        }
        n.a.a.n.d.l0 l0Var = n.a.a.n.d.l0.RED;
        return indexed == ((long) l0Var.a()) ? l0Var.a() : (short) indexed;
    }

    public int e() {
        CTFontFamily familyArray = this.c.sizeOfFamilyArray() == 0 ? null : this.c.getFamilyArray(0);
        return (familyArray == null ? n.a.a.n.d.e0.NOT_APPLICABLE : n.a.a.n.d.e0.b(familyArray.getVal())).a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return Objects.equals(Boolean.valueOf(i()), Boolean.valueOf(p1Var.i())) && Objects.equals(Boolean.valueOf(a()), Boolean.valueOf(p1Var.a())) && Objects.equals(Boolean.valueOf(k()), Boolean.valueOf(p1Var.k())) && Objects.equals(Integer.valueOf(c()), Integer.valueOf(p1Var.c())) && Objects.equals(Short.valueOf(d()), Short.valueOf(p1Var.d())) && Objects.equals(Integer.valueOf(e()), Integer.valueOf(p1Var.e())) && Objects.equals(Short.valueOf(f()), Short.valueOf(p1Var.f())) && Objects.equals(h(), p1Var.h()) && Objects.equals(j(), p1Var.j()) && Objects.equals(Short.valueOf(l()), Short.valueOf(p1Var.l())) && Objects.equals(Short.valueOf(m()), Short.valueOf(p1Var.m())) && Objects.equals(Byte.valueOf(n()), Byte.valueOf(p1Var.n())) && Objects.equals(o(), p1Var.o());
    }

    public short f() {
        return (short) (g() * 20.0d);
    }

    public String h() {
        CTFontName nameArray = this.c.sizeOfNameArray() == 0 ? null : this.c.getNameArray(0);
        return nameArray == null ? "Calibri" : nameArray.getVal();
    }

    public int hashCode() {
        return this.c.toString().hashCode();
    }

    public boolean i() {
        CTBooleanProperty iArray = this.c.sizeOfIArray() == 0 ? null : this.c.getIArray(0);
        return iArray != null && iArray.getVal();
    }

    public n.a.a.n.d.f0 j() {
        CTFontScheme schemeArray = this.c.sizeOfSchemeArray() == 0 ? null : this.c.getSchemeArray(0);
        return schemeArray == null ? n.a.a.n.d.f0.NONE : n.a.a.n.d.f0.b(schemeArray.getVal().intValue());
    }

    public boolean k() {
        CTBooleanProperty strikeArray = this.c.sizeOfStrikeArray() == 0 ? null : this.c.getStrikeArray(0);
        return strikeArray != null && strikeArray.getVal();
    }

    public short l() {
        return (short) ((this.c.sizeOfColorArray() == 0 ? null : this.c.getColorArray(0)) == null ? 0L : r0.getTheme());
    }

    public short m() {
        int iIntValue;
        CTVerticalAlignFontProperty vertAlignArray = this.c.sizeOfVertAlignArray() == 0 ? null : this.c.getVertAlignArray(0);
        if (vertAlignArray == null || (iIntValue = vertAlignArray.getVal().intValue()) == 1) {
            return (short) 0;
        }
        if (iIntValue == 2) {
            return (short) 1;
        }
        if (iIntValue == 3) {
            return (short) 2;
        }
        throw new n.a.a.j.d("Wrong offset value " + iIntValue);
    }

    public byte n() {
        CTUnderlineProperty uArray = this.c.sizeOfUArray() == 0 ? null : this.c.getUArray(0);
        if (uArray != null) {
            return n.a.a.n.d.h0.c(uArray.getVal().intValue()).a();
        }
        return (byte) 0;
    }

    public e1 o() {
        CTColor colorArray = this.c.sizeOfColorArray() == 0 ? null : this.c.getColorArray(0);
        if (colorArray == null) {
            return null;
        }
        e1 e1VarF = e1.f(colorArray, this.a);
        n.a.a.q.b.l lVar = this.b;
        if (lVar != null) {
            lVar.J(e1VarF);
        }
        return e1VarF;
    }

    public long p(n.a.a.q.b.i iVar) {
        return q(iVar, true);
    }

    public long q(n.a.a.q.b.i iVar, boolean z) {
        this.b = iVar.getTheme();
        int iW = iVar.W(this, z);
        this.d = iW;
        return iW;
    }

    public void r(short s) {
        CTColor cTColorAddNewColor = this.c.sizeOfColorArray() == 0 ? this.c.addNewColor() : this.c.getColorArray(0);
        if (s == Short.MAX_VALUE) {
            cTColorAddNewColor.setIndexed(e);
        } else {
            cTColorAddNewColor.setIndexed(s);
        }
    }

    public void s(int i2) {
        (this.c.sizeOfFamilyArray() == 0 ? this.c.addNewFamily() : this.c.getFamilyArray(0)).setVal(i2);
    }

    public void t(n.a.a.n.d.e0 e0Var) {
        s(e0Var.a());
    }

    public String toString() {
        return this.c.toString();
    }

    public void u(double d) {
        (this.c.sizeOfSzArray() == 0 ? this.c.addNewSz() : this.c.getSzArray(0)).setVal(d);
    }

    public void v(short s) {
        u(s);
    }

    public void w(String str) {
        CTFontName cTFontNameAddNewName = this.c.sizeOfNameArray() == 0 ? this.c.addNewName() : this.c.getNameArray(0);
        if (str == null) {
            str = "Calibri";
        }
        cTFontNameAddNewName.setVal(str);
    }

    public void x(n.a.a.n.d.f0 f0Var) {
        (this.c.sizeOfSchemeArray() == 0 ? this.c.addNewScheme() : this.c.getSchemeArray(0)).setVal(STFontScheme.Enum.forInt(f0Var.a()));
    }

    public void y(n.a.a.q.b.l lVar) {
        this.b = lVar;
    }

    public p1() {
        this.c = CTFont.Factory.newInstance();
        w("Calibri");
        u(11.0d);
    }
}
