package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaSer;

/* loaded from: classes.dex */
public class e extends o {
    private CTAreaChart c;

    protected e(l lVar, CTAreaChart cTAreaChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTAreaChart;
        for (CTAreaSer cTAreaSer : cTAreaChart.getSerList()) {
            this.a.add(new d(this, cTAreaSer, cTAreaSer.getCat(), cTAreaSer.getVal()));
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
