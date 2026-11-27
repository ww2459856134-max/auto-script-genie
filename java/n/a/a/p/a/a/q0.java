package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceSer;

/* loaded from: classes.dex */
public class q0 extends o {
    private CTSurface3DChart c;

    protected q0(l lVar, CTSurface3DChart cTSurface3DChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTSurface3DChart;
        for (CTSurfaceSer cTSurfaceSer : cTSurface3DChart.getSerList()) {
            this.a.add(new p0(this, cTSurfaceSer, cTSurfaceSer.getCat(), cTSurfaceSer.getVal()));
        }
        c(map, map2);
    }

    private void c(Map<Long, m> map, Map<Long, t0> map2) {
        if (this.c.sizeOfAxIdArray() == 0) {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                this.c.addNewAxId().setVal(it.next().longValue());
            }
            Iterator<Long> it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                this.c.addNewAxId().setVal(it2.next().longValue());
            }
        }
        b(this.c.getAxIdArray(), map, map2);
    }
}
