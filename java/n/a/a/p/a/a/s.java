package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;

/* loaded from: classes.dex */
final class s implements k {
    private final CTNumData a;
    private final String b;
    final /* synthetic */ CTAxDataSource c;

    s(CTAxDataSource cTAxDataSource) {
        this.c = cTAxDataSource;
        CTNumData cTNumData = (CTNumData) cTAxDataSource.getNumLit().copy();
        this.a = cTNumData;
        this.b = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
    }

    @Override // n.a.a.p.a.a.k, n.a.a.p.a.a.p
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
    public String b(int i2) {
        return this.a.getPtArray(i2).getV();
    }

    @Override // n.a.a.p.a.a.p
    public String getFormatCode() {
        return this.b;
    }

    @Override // n.a.a.p.a.a.k, n.a.a.p.a.a.p
    public boolean isNumeric() {
        return true;
    }
}
