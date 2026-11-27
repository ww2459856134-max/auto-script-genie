package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;

/* loaded from: classes.dex */
public class i extends o {
    private CTBarChart c;

    protected i(l lVar, CTBarChart cTBarChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTBarChart;
        if (cTBarChart.getBarDir() == null) {
            cTBarChart.addNewBarDir().setVal(a.BAR.c);
        }
        for (CTBarSer cTBarSer : cTBarChart.getSerList()) {
            this.a.add(new h(this, cTBarSer, cTBarSer.getCat(), cTBarSer.getVal()));
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
