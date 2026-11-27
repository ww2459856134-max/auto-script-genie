package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;

/* loaded from: classes.dex */
public class f0 extends o {
    private CTLineChart c;

    protected f0(l lVar, CTLineChart cTLineChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTLineChart;
        for (CTLineSer cTLineSer : cTLineChart.getSerList()) {
            this.a.add(new e0(this, cTLineSer, cTLineSer.getCat(), cTLineSer.getVal()));
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
