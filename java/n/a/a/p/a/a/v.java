package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;

/* loaded from: classes.dex */
final class v implements g0<Double> {
    private final CTNumData a;
    private String b;
    final /* synthetic */ CTNumDataSource c;

    v(CTNumDataSource cTNumDataSource) {
        this.c = cTNumDataSource;
        CTNumData cTNumData = (CTNumData) cTNumDataSource.getNumLit().copy();
        this.a = cTNumData;
        this.b = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
    }

    @Override // n.a.a.p.a.a.p
    public boolean a() {
        return false;
    }

    @Override // n.a.a.p.a.a.p
    public String d() {
        return null;
    }

    @Override // n.a.a.p.a.a.p
    public int e() {
        return (int) this.a.getPtCount().getVal();
    }

    @Override // n.a.a.p.a.a.p
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Double b(int i2) {
        return Double.valueOf(this.a.getPtArray(i2).getV());
    }

    @Override // n.a.a.p.a.a.p
    public String getFormatCode() {
        return this.b;
    }

    @Override // n.a.a.p.a.a.p
    public boolean isNumeric() {
        return true;
    }

    @Override // n.a.a.p.a.a.g0
    public void setFormatCode(String str) {
        this.b = str;
    }
}
