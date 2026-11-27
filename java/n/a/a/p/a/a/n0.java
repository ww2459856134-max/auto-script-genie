package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;

/* loaded from: classes.dex */
public class n0 extends n {
    private CTScatterSer c;

    protected n0(o0 o0Var, CTScatterSer cTScatterSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
        super(z.a(cTAxDataSource), z.b(cTNumDataSource));
        this.c = cTScatterSer;
    }

    @Override // n.a.a.p.a.a.n
    protected CTAxDataSource a() {
        return this.c.getXVal();
    }

    @Override // n.a.a.p.a.a.n
    protected CTNumDataSource b() {
        return this.c.getYVal();
    }
}
