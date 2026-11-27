package n.a.a.p.a.a;

import org.apache.poi.xssf.usermodel.i2;

/* loaded from: classes.dex */
class x extends w<Double> implements g0<Double> {
    private String e;

    protected x(i2 i2Var, n.a.a.n.e.m mVar) {
        super(i2Var, mVar);
    }

    @Override // n.a.a.p.a.a.p
    public String getFormatCode() {
        return this.e;
    }

    @Override // n.a.a.p.a.a.p
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Double b(int i2) {
        n.a.a.n.d.l lVarG = g(i2);
        if (lVarG == null || lVarG.c() != n.a.a.n.d.j.NUMERIC) {
            return null;
        }
        return Double.valueOf(lVarG.f());
    }

    @Override // n.a.a.p.a.a.p
    public boolean isNumeric() {
        return true;
    }

    @Override // n.a.a.p.a.a.g0
    public void setFormatCode(String str) {
        this.e = str;
    }
}
