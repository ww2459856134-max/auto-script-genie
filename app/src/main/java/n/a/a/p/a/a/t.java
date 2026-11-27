package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;

/* loaded from: classes.dex */
final class t implements k {
    private final CTStrData a;
    final /* synthetic */ CTAxDataSource b;

    t(CTAxDataSource cTAxDataSource) {
        this.b = cTAxDataSource;
        this.a = (CTStrData) cTAxDataSource.getStrLit().copy();
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
        return null;
    }
}
