package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarSer;

/* loaded from: classes.dex */
public class m0 extends o {
    private CTRadarChart c;

    protected m0(l lVar, CTRadarChart cTRadarChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTRadarChart;
        for (CTRadarSer cTRadarSer : cTRadarChart.getSerList()) {
            this.a.add(new l0(this, cTRadarSer, cTRadarSer.getCat(), cTRadarSer.getVal()));
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
