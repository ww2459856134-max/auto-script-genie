package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* loaded from: classes.dex */
final class p0 implements n.a.a.n.c.n {
    private final u1 a;
    private final int b;
    private final n.a.a.n.c.c0 c;

    public p0(u1 u1Var, int i2, n.a.a.n.c.c0 c0Var) {
        this.a = u1Var;
        this.b = i2;
        this.c = c0Var;
    }

    @Override // n.a.a.n.c.n
    public boolean a() {
        return e();
    }

    @Override // n.a.a.n.c.n
    public n.a.a.n.c.u1.k2[] b() {
        return n.a.a.n.c.b0.H(this.a.g(), this.c, n.a.a.n.c.f0.NAMEDRANGE, this.a.a());
    }

    @Override // n.a.a.n.c.n
    public n.a.a.n.c.u1.b2 c() {
        return new n.a.a.n.c.u1.b2(this.b);
    }

    @Override // n.a.a.n.c.n
    public boolean d() {
        return this.a.h();
    }

    @Override // n.a.a.n.c.n
    public boolean e() {
        CTDefinedName cTDefinedNameE = this.a.e();
        String stringValue = cTDefinedNameE.getStringValue();
        return (cTDefinedNameE.getFunction() || stringValue == null || stringValue.isEmpty()) ? false : true;
    }

    @Override // n.a.a.n.c.n
    public String f() {
        return this.a.d();
    }
}
