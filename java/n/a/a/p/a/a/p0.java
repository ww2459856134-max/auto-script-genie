package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceSer;

/* loaded from: classes.dex */
public class p0 extends n {
    private CTSurfaceSer c;

    protected p0(q0 q0Var, CTSurfaceSer cTSurfaceSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
        super(z.a(cTAxDataSource), z.b(cTNumDataSource));
        this.c = cTSurfaceSer;
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
