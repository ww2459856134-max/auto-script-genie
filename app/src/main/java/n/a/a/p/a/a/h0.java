package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* loaded from: classes.dex */
public class h0 extends n {
    private CTPieSer c;

    protected h0(i0 i0Var, CTPieSer cTPieSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
        super(z.a(cTAxDataSource), z.b(cTNumDataSource));
        this.c = cTPieSer;
    }

    @Override // n.a.a.p.a.a.n
    protected CTAxDataSource a() {
        return this.c.getCat();
    }

    @Override // n.a.a.p.a.a.n
    protected CTNumDataSource b() {
        return this.c.getVal();
    }
}
