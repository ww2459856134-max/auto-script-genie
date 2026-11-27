package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;

/* loaded from: classes.dex */
public class c0 extends n {
    private CTLineSer c;

    protected c0(d0 d0Var, CTLineSer cTLineSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
        super(z.a(cTAxDataSource), z.b(cTNumDataSource));
        this.c = cTLineSer;
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
