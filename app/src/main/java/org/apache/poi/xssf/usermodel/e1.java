package org.apache.poi.xssf.usermodel;

import java.util.Arrays;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* loaded from: classes.dex */
public class e1 extends n.a.a.n.d.c0 {
    private final CTColor a;
    private final u0 b;

    private e1(CTColor cTColor, u0 u0Var) {
        this.a = cTColor;
        this.b = u0Var;
    }

    public static e1 f(CTColor cTColor, u0 u0Var) {
        if (cTColor == null) {
            return null;
        }
        return new e1(cTColor, u0Var);
    }

    private boolean p(e1 e1Var) {
        if (n() == e1Var.n()) {
            return !n() || Arrays.equals(g(), e1Var.g());
        }
        return false;
    }

    private boolean q(e1 e1Var) {
        return m() == e1Var.m();
    }

    private boolean r(e1 e1Var) {
        if (e() == e1Var.e()) {
            return !e() || i() == e1Var.i();
        }
        return false;
    }

    private boolean s(e1 e1Var) {
        if (o() == e1Var.o()) {
            return !o() || j() == e1Var.j();
        }
        return false;
    }

    private boolean t(e1 e1Var) {
        if (l() == e1Var.l()) {
            return !l() || k() == e1Var.k();
        }
        return false;
    }

    @Override // n.a.a.n.d.c0
    public short a() {
        return (short) this.a.getIndexed();
    }

    @Override // n.a.a.n.d.c0
    protected byte[] b() {
        if (!e()) {
            return null;
        }
        u0 u0Var = this.b;
        return u0Var != null ? u0Var.a(a()) : t0.b(a());
    }

    @Override // n.a.a.n.d.c0
    protected byte[] d() {
        return this.a.getRgb();
    }

    @Override // n.a.a.n.d.c0
    public boolean e() {
        return this.a.isSetIndexed();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return p(e1Var) && s(e1Var) && r(e1Var) && t(e1Var) && q(e1Var);
    }

    public byte[] g() {
        byte[] bArrC = c();
        if (bArrC == null) {
            return null;
        }
        if (bArrC.length != 3) {
            return bArrC;
        }
        byte[] bArr = new byte[4];
        bArr[0] = -1;
        System.arraycopy(bArrC, 0, bArr, 1, 3);
        return bArr;
    }

    public CTColor h() {
        return this.a;
    }

    public int hashCode() {
        return this.a.toString().hashCode();
    }

    public short i() {
        return a();
    }

    public int j() {
        return (int) this.a.getTheme();
    }

    public double k() {
        return this.a.getTint();
    }

    public boolean l() {
        return this.a.isSetTint() && this.a.getTint() != 0.0d;
    }

    public boolean m() {
        return this.a.getAuto();
    }

    public boolean n() {
        return this.a.isSetRgb();
    }

    public boolean o() {
        return this.a.isSetTheme();
    }

    public e1(byte[] bArr, u0 u0Var) {
        this(CTColor.Factory.newInstance(), u0Var);
        this.a.setRgb(bArr);
    }
}
