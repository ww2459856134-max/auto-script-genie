package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* loaded from: classes.dex */
public final class u1 implements n.a.a.n.d.m0 {
    private final XSSFWorkbook a;
    private final CTDefinedName b;

    protected u1(CTDefinedName cTDefinedName, XSSFWorkbook xSSFWorkbook) {
        this.a = xSSFWorkbook;
        this.b = cTDefinedName;
    }

    private static void j(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("Invalid name: '" + str + "': cannot exceed 255 characters in length");
        }
        if (str.equalsIgnoreCase("R") || str.equalsIgnoreCase("C")) {
            throw new IllegalArgumentException("Invalid name: '" + str + "': cannot be special shorthand R or C");
        }
        char cCharAt = str.charAt(0);
        if (!(Character.isLetter(cCharAt) || "_\\".indexOf(cCharAt) != -1)) {
            throw new IllegalArgumentException("Invalid name: '" + str + "': first character must be underscore or a letter");
        }
        for (char c : str.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || "_.\\".indexOf(c) != -1)) {
                throw new IllegalArgumentException("Invalid name: '" + str + "': name must be letter, digit, period, or underscore");
            }
        }
        if (str.matches("[A-Za-z]+\\d+")) {
            try {
                if (n.a.a.n.e.s.b(str.replaceAll("\\d", ""), str.replaceAll("[A-Za-z]", ""), n.a.a.n.a.EXCEL2007)) {
                    throw new IllegalArgumentException("Invalid name: '" + str + "': cannot be $A$1-style cell reference");
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (str.matches("[Rr]\\d+[Cc]\\d+")) {
            throw new IllegalArgumentException("Invalid name: '" + str + "': cannot be R1C1-style cell reference");
        }
    }

    @Override // n.a.a.n.d.m0
    public int a() {
        if (this.b.isSetLocalSheetId()) {
            return (int) this.b.getLocalSheetId();
        }
        return -1;
    }

    @Override // n.a.a.n.d.m0
    public void b(String str) {
        j(str);
        String strD = d();
        int iA = a();
        for (u1 u1Var : this.a.getNames(str)) {
            if (u1Var.a() == iA && u1Var != this) {
                StringBuilder sb = new StringBuilder();
                sb.append("The ");
                sb.append(iA == -1 ? "workbook" : "sheet");
                sb.append(" already contains this name: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.b.setName(str);
        this.a.updateName(this, strD);
    }

    @Override // n.a.a.n.d.m0
    public void c(int i2) {
        String str;
        int numberOfSheets = this.a.getNumberOfSheets() - 1;
        if (i2 >= -1 && i2 <= numberOfSheets) {
            if (i2 != -1) {
                this.b.setLocalSheetId(i2);
                return;
            } else {
                if (this.b.isSetLocalSheetId()) {
                    this.b.unsetLocalSheetId();
                    return;
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Sheet index (");
        sb.append(i2);
        sb.append(") is out of range");
        if (numberOfSheets == -1) {
            str = "";
        } else {
            str = " (0.." + numberOfSheets + ")";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // n.a.a.n.d.m0
    public String d() {
        return this.b.getName();
    }

    protected CTDefinedName e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u1) {
            return this.b.toString().equals(((u1) obj).e().toString());
        }
        return false;
    }

    public boolean f() {
        return this.b.getFunction();
    }

    public String g() {
        String stringValue = this.b.getStringValue();
        if (stringValue == null || stringValue.length() < 1) {
            return null;
        }
        return stringValue;
    }

    public boolean h() {
        return f();
    }

    public int hashCode() {
        return this.b.toString().hashCode();
    }

    public void i(String str) {
        n.a.a.n.c.b0.I(str, o1.x(this.a), n.a.a.n.c.f0.NAMEDRANGE, a(), -1);
        this.b.setStringValue(str);
    }

    @Override // n.a.a.n.d.m0
    public void setFunction(boolean z) {
        this.b.setFunction(z);
    }
}
